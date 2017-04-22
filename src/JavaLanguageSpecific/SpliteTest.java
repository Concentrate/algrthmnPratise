package JavaLanguageSpecific;

/**
 * Created by liudeyu on 2017/4/10.
 */
public class SpliteTest {
    public static void main(String[] args) {
        String t = "\\nメルカリ\\n落札\\n试试\\n";
//        t = replaceLineSperator(t);
        t=t.replace("\\n","\n");
        spliteText(t);
        String aOne="abcd";
        System.out.print(aOne.substring(4));

    }

    private static String replaceLineSperator(String t) {
        if (t.indexOf("\\n") != -1) {
            StringBuilder builder = new StringBuilder();
            int beginIndex = 0;
            while (t.indexOf("\\n") != -1) {
                int index = t.indexOf("\\n");
                builder.append(t.substring(0, index));
                builder.append("\n");
                t = t.substring(index + 2);
            }
            builder.append(t);
            t = builder.toString();
        }
        return t;
    }

    private static void spliteText(String t) {
        String[] m = t.split("\n");
        for (String a1 : m) {
            System.out.print(a1 + " ");
        }
        System.out.println("");
    }
}
