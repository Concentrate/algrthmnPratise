package processPratise;

/**
 * Created by liudeyu on 2017/3/2.
 */
public class processOne {
    public static void main(String []argvs){
        Runtime runtime=Runtime.getRuntime();
        System.out.println(runtime.availableProcessors()+" process num");
        System.out.println(runtime.freeMemory()+" free memory");
        System.out.println(runtime.maxMemory()+" max memory");
        System.out.println(runtime.totalMemory()+" total memory");
    }
}
