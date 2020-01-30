package com.com.ldy.java.DataStuctPratise;

/**
 * Created by liudeyu on 2017/3/2.
 */
public class ListPratise {
    Node<Integer> header;
    int size;

    public ListPratise() {
        header = new Node<>();
        header.next = null;
        size = 0;
    }

    public ListPratise(Node<Integer> header, int size) {
        this.header = header;
        this.size = size;
    }

    void createList(int[] array) {
        if (array == null) {
            return;
        }

        Node lastNode = null;
        size = array.length;
        for (int tmp : array) {
            Node<Integer> node = new Node<>();
            node.value = tmp;
            node.next = null;
            if (lastNode == null) {
                header.next = node;
            } else {
                lastNode.next = node;
            }
            lastNode = node;
        }
    }

    void printAllNodes() {
        for (Node tmp = header.next; tmp != null; tmp = tmp.next) {

            System.out.print(tmp.value + " ");
        }
        System.out.println("");
    }

    boolean insertIndexElement(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }
        size += 1;
        Node lastNode = header;
        int i = 0;
        while (lastNode.next != null && i < index) {
            lastNode = lastNode.next;
            i++;
        }
        Node node = new Node();
        node.value = value;
        node.next = lastNode.next;
        lastNode.next = node;
        return true;
    }

    boolean deleteElement(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node lastNode = header;
        int i = 0;
        while (lastNode.next != null && i < index) {
            lastNode = lastNode.next;
            i++;
        }
        lastNode.next = lastNode.next.next;
        size--;
        return true;
    }

    Node findElement(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = header.next;
        int i = 0;
        while (current.next != null && i < index) {
            current = current.next;
            i++;
        }
        return current;
    }

    /*判断链表是否有环*/
    boolean isListHaveLoop() {
        Node twoStep = header;
        Node oneStep = header;
        boolean haveLoop = false;
        while (twoStep != null && oneStep != null) {
            twoStep = twoStep.next;
            if (twoStep != null) {
                twoStep = twoStep.next;
            } else {
                break;
            }
            oneStep = oneStep.next;
            if (twoStep == oneStep) {
                haveLoop = true;
                break;
            }

        }
        return haveLoop;
    }

    Node getElement(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node node = header.next;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node;
    }

    /*判断是否有环，并且返回相遇节点*/
    Node getMeetNodeForLoop() {
        Node twoStep = header;
        Node oneStep = header;
        while (twoStep != null && oneStep != null) {
            twoStep = twoStep.next;
            if (twoStep != null) {
                twoStep = twoStep.next;
            } else {
                return null;
            }
            oneStep = oneStep.next;
            if (twoStep == oneStep) {
                return twoStep;
            }
        }
        return null;
    }

    /*找到环的入口*/
    Node findEntryForLoop() {
        Node meetNode = getMeetNodeForLoop();
        if (meetNode == null) {
            return null;
        }
        Node fromStart = header;
        while (fromStart != null && meetNode != null) {
            fromStart = fromStart.next;
            meetNode = meetNode.next;
            if (fromStart == meetNode) {
                return fromStart;
            }
        }
        return null;
    }

    /*找到相交链表，无环情况下的第一个交点,对齐法*/
    Node getEntryForNoLoopList(ListPratise firstList, ListPratise secondList) {
        if (firstList == null || secondList== null) {
            return null;
        }
        int l1 = 0, l2 = 0;
        Node node1 = firstList.header.next;
        Node node2 = secondList.header.next;
        while (true) {
            if (node1 != null) {
                l1++;
                node1 = node1.next;
            }
            if (node2 != null) {
                l2++;
                node2 = node2.next;
            }
            if (node1 == null && node2 == null) {
                break;
            }
        }
        Node header1=firstList.header;
        Node header2=secondList.header;
        if (l1 > l2) {
            int gap = l1 - l2;
            int i = 0;
            while (header1 != null && i < gap) {
                header1 = header1.next;
                i++;
            }
        }
        if (l2 > l1) {
            int gap = l2 - l1;
            int i = 0;
            while (header2 != null && i < gap) {
                header2 = header2.next;
                i++;
            }
        }
        Node recordEntry = null;
        while (header1 != null && header2 != null) {
            if (header1 == header2) {
                recordEntry = header1;
                break;
            }
            header1 = header1.next;
            header2 = header2.next;
        }
        return recordEntry;
    }
    /*寻找无环链表的入口，基于循环圈入口*/
    Node findEntryForNoLoopBaseCircle(ListPratise firstList,ListPratise secondList){
        if(firstList==null||secondList==null){
            return null;
        }
        Node firstHead=firstList.header;
        Node secondHead=secondList.header;
        while(firstHead.next!=null){
            firstHead=firstHead.next;
        }
        firstHead.next=secondHead.next;
        return firstList.findEntryForLoop();
    }
    private static int ARRAYLENGTH=10000000;
    public static void main(String[] argv) {
        int[] ints = new int[ARRAYLENGTH];
        for (int i = 0; i < ARRAYLENGTH; i++) {
            ints[i] = i;
        }
        ListPratise listPratise = new ListPratise();
        listPratise.createList(ints);
        ListPratise secondList=new ListPratise();
        secondList.createList(new int []{1,2});
        secondList.header.next.next.next=listPratise.getElement(199999);
        long startTime,endTime;
        startTime=System.nanoTime();
        Node interNode2=listPratise.getEntryForNoLoopList(listPratise,secondList);
        endTime=System.nanoTime();
        System.out.println(interNode2.value+" intersection val and the naon time is "+(endTime-startTime) );
        startTime=System.nanoTime();
        Node intersectionNode=listPratise.findEntryForNoLoopBaseCircle(listPratise,secondList);
        endTime=System.nanoTime();
        if(intersectionNode!=null){
            System.out.println(intersectionNode.value+" intersection val and the naon time is "+(endTime-startTime) );
        }

    }

    private static void testLastItem(ListPratise listPratise) {
        for (int i = 0; i < 10; i++) {
            System.out.println("the last " + i + " element is " + (listPratise.backwardKElement(i) == null ? null : listPratise.backwardKElement(i).value));

        }
        System.out.println("");
    }

    private static void testSwapCase(ListPratise listPratise) {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++)
                listPratise.swapItems(j, j + 1);
        }
        listPratise.printAllNodes();
    }

    private static final int DELETETAG = Integer.MAX_VALUE;

    /*O(1)删除节点，给定特定节点，和头节点*/
    boolean deleteNode(Node node) {
        if (node == null) {
            return true;
        }
        if (node.next == null) {
            node.value = DELETETAG;
            return true;
        }
        Node nextNode = node.next;
        node.value = nextNode.value;
        node.next = nextNode.next;
        return true;
    }

    /*逆转链表*/
    void reverseList() {
        if (header.next == null || header.next.next == null) {
            return;
        }
        Node headNode = header.next;
        Node tailNode = headNode.next;
        while (tailNode != null) {
            Node tailNextNode = tailNode.next;
            Node headNext = header.next;
            header.next = tailNode;
            tailNode.next = headNext;
            headNode.next = tailNextNode;
            tailNode = headNode.next;
        }
    }

    /*逆转链表递归*/
    void reverseListResursive(Node t) {
        // TODO: 2017/3/2 thinking
    }

    /*求倒数第k个element*/
    Node backwardKElement(int k) {
        int real = k - 1;
        if (k < 0 || k >= size) {
            return null;
        }
        Node node = header.next;
        Node tagNode = header.next;
        int i = 0;
        while (i <= real) {
            i++;
            tagNode = tagNode.next;
        }
        while (tagNode.next != null) {
            node = node.next;
            tagNode = tagNode.next;
        }
        return node;
    }

    /*求中间节点位置*/
    Node midNode() {
        Node slowNode = header.next;
        Node fastNode = header.next;
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode.next != null) {
                fastNode = fastNode.next;
            } else {
                break;
            }
        }
        return slowNode;
    }


    private static int count = 0;

    /*交换节点*/
    void swapItems(int index1, int index2) {
        if ((index1 < 0 || index1 >= size) || (index2 < 0 || index2 >= size) || (index1 == index2))
            return;
        Node firstLastNode = null, secondLastNode = null;
        int minIndex = Math.min(index1, index2);
        int maxIndex = Math.max(index1, index2);
        firstLastNode = secondLastNode = header;
        int i = 0, j = 0;
        while (true) {
            if (i < minIndex && firstLastNode.next != null) {
                i++;
                firstLastNode = firstLastNode.next;
            }
            if (j < maxIndex && secondLastNode.next != null) {
                j++;
                secondLastNode = secondLastNode.next;
            } else {
                break;
            }
        }
        if (Math.abs(index1 - index2) == 1) {
            if (firstLastNode.next == secondLastNode) {
                System.out.println("caclute right,the swap node between each other " + (++count));
                Node secondNodeNext = secondLastNode.next.next;
                Node firstNode = firstLastNode.next;
                firstLastNode.next = secondLastNode.next;
                secondLastNode.next.next = firstNode;
                firstNode.next = secondNodeNext;
            }
        } else {
            Node firstNode = firstLastNode.next;
            Node secondNodeNext = secondLastNode.next.next;
            firstLastNode.next = secondLastNode.next;
            secondLastNode.next.next = firstNode.next;
            firstNode.next = secondNodeNext;
            secondLastNode.next = firstNode;
        }
    }


    private static void findTest(ListPratise listPratise) {
        for (int i = 0; i < 10; i++) {
            if (listPratise.findElement(i) != null)
                System.out.print(listPratise.findElement(i).value + " ");
        }
        System.out.println(listPratise.findElement(10).value);
        System.out.println("");
    }

    private static void deleteTest(ListPratise listPratise) {
        for (int i = 0; i < 10; i++) {
            listPratise.deleteElement(i);
        }
        listPratise.printAllNodes();
    }

    private static void insertTest(ListPratise listPratise) {
        for (int i = 0; i < 10; i++) {
            listPratise.insertIndexElement(i, i);
        }
        listPratise.insertIndexElement(20, 30);
        listPratise.insertIndexElement(30, 40);
    }

}

class Node<T> {
    T value;
    Node next;
}