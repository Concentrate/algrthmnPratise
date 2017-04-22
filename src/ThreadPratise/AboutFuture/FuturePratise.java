package ThreadPratise.AboutFuture;

import java.util.concurrent.*;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class FuturePratise {
    public static void main(String[]args){
        cancelableRunnable();
    }

    private static void cancelableRunnable(){
        ExecutorService service=Executors.newCachedThreadPool();
        Future<?>future=service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("模拟长时间计算");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        try {
            Thread.sleep(300);
            future.cancel(true);
            if(future.isCancelled()){
                System.out.println("the task have benn cancel");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void threadFutureTaskUser(){
        FutureTask<Integer>futureTask=new FutureTask<Integer>(new CacluTotalSum());
        new Thread(futureTask).run();
        System.out.println("主线程执行中...");
        try {
            System.out.println("计算线程得到结果为 "+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    private static void futureTaskUser(){
        ExecutorService service=Executors.newCachedThreadPool();
        FutureTask<Integer>futureTask=new FutureTask<Integer>(new CacluTotalSum());
        service.submit(futureTask);
        System.out.println("主线程正在执行");
        try {
            System.out.println("get the result is "+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void futureUser() {
        ExecutorService service= Executors.newCachedThreadPool();
        CacluTotalSum task=new CacluTotalSum();
        Future<Integer> result=service.submit(task);
        System.out.println("主线程正在执行");
        try {
            System.out.println("运算线程得到的结果为 "+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
class CacluTotalSum implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        System.out.println("call thread is executing");
        int sum=0;
        for(int i=0;i<1000;i++){
            sum+=i;
        }
        return sum;
    }
}
