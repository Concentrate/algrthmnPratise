package com.recurseabout;

/**
 * Created by liudeyu on 2019/10/15.
 */
public class recurseExample {


    public static String reverStringOutput(String t) {
        if (t == null || t.length() <= 1) {
            System.out.print(t);
        }
        StringBuilder builder = new StringBuilder();
        recurserReverString(t, 0, t.length() - 1, builder);
        return builder.toString();
    }

    public static void recurserReverString(String tmp, int start, int end, StringBuilder builder) {
        System.out.print(tmp.charAt(end));
        builder.append(tmp.charAt(end));
        if (end > 0) {
            recurserReverString(tmp, start, end - 1, builder);
        }
    }

    public static void main(String[] argv) {
      reverStringOutput(reverStringOutput(reverStringOutput(reverStringOutput("hello,world"))));
    }
}
