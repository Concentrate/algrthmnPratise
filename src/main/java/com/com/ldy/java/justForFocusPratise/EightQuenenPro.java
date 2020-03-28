package com.com.ldy.java.justForFocusPratise;

public class EightQuenenPro {


    int[] quenenList = new int[1000];

    int totalCount = 0;

    void printEightQuenenPro(int n) {
        int[] resultTmp = new int[n];
        totalCount = 0;
        toImplementNQuenen(resultTmp, 0, n);
        System.out.println("total count is "+totalCount);
    }

    private void toImplementNQuenen(int[] resultTmp, int i, int n) {
        if (i >= n) {
            toPrintResult(resultTmp);
            totalCount++;
            return;
        }

        for (int a1 = 0; a1 < n; a1++) {
            resultTmp[i] = a1;
            if (detectCurrentValueOk(resultTmp, i)) {
                toImplementNQuenen(resultTmp, i + 1, n);
            }
        }

    }

    private boolean detectCurrentValueOk(int[] resultTmp, int i) {
        int before = 0;
        while (before < i) {
            if (resultTmp[before] == resultTmp[i] || Math.abs(i - before) == Math.abs(resultTmp[i] - resultTmp[before])) {
                return false;
            }
            before++;
        }
        return true;
    }

    private void toPrintResult(int[] resultTmp) {

        for(int a1=0;a1<resultTmp.length;a1++){
            char[]tPrint= new char[resultTmp.length];
            for (int b1 = 0; b1 < tPrint.length; b1++) {
                tPrint[b1]='*';
            }
            tPrint[resultTmp[a1]]='#';
            for (int c1 = 0; c1 < tPrint.length; c1++) {
                System.out.print(tPrint[c1]);
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }


    public static void main(String[] args) {

        EightQuenenPro eightQuenenPro=new EightQuenenPro();
        eightQuenenPro.printEightQuenenPro(18);
    }

}
