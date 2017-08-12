package ExceptionPratise;

import java.io.IOException;

/**
 * Created by liudeyu on 2017/7/30.
 */
public class TestParentException {
    
    public static void raiseIoException() throws Exception{
        System.out.println("hello");
        throw  new IllegalAccessException();
    }
    public static void main(String[]argv){
        try {
            raiseIoException();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("IO Exception sub class");
        }catch (IllegalAccessException p){
            System.out.println("Illeageal Exception");
        }
        catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Exception ");
        }

    }
}
