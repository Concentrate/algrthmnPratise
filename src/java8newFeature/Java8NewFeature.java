package java8newFeature;

import java.util.Arrays;

/**
 * Created by liudeyu on 2017/3/5.
 */
public class Java8NewFeature {
    public static void main(String []argv){
        Arrays.asList("a","b","c").forEach( t->System.out.print(t+" "));
    }
}
