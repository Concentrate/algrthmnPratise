package ThreadPratise;

import com.oracle.tools.packager.Log;
import sun.jvm.hotspot.debugger.ThreadProxy;

import java.io.IOException;
import java.text.Format;
import java.util.Random;
import java.util.logging.*;

/**
 * Created by liudeyu on 2017/3/12.
 */
public class ThreadLocalPratise implements Runnable {

    private static ThreadLocal<Student> threadLocal = new ThreadLocal<>();
    public static String TAG = "ThreadLocalPratise";
    public static Logger logger = Logger.getLogger(TAG);
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public ThreadLocalPratise() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        try {
            FileHandler fileHandler = new FileHandler("/Users/liudeyu/logger.txt", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getLevel() + " : " + record.getMessage() + "\n";
                }
            });
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Student getStudent() {
        Student student = threadLocal.get();
        if (student == null) {
            threadLocal.set(new Student("k",9));
        }
        Student mm = threadLocal.get();
        logger.info("The student in the " + Thread.currentThread().getName() + " " + mm.hashCode() + "");
        return mm;
    }

    @Override
    public void run() {
        Student student = getStudent();
        student.name = Thread.currentThread().getName();
        student.age = new Random().nextInt(100);
        System.out.println(student);

    }

    public static class Student {
        String name;
        int age;
        private static volatile Student student;


        private Student(){

        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static Student getStudent() {
            if (student == null) {
                synchronized (Student.class) {
                    if (student == null) {
                        student = new Student();
                    }
                }
            }
            return student;
        }

        @Override
        public String toString() {
            return " the name is " + name + " and the age is " + age;
        }
    }

    public static void main(String[] args) {
        ThreadLocalPratise pratise = new ThreadLocalPratise();
        Student student=new Student("xiaogong",10);
        pratise.setStudent(student);
        Thread a = new Thread(pratise, "a");
        Thread b = new Thread(pratise, "b");
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(student);
    }
}

