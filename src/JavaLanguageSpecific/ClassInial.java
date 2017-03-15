package JavaLanguageSpecific;

/**
 * Created by liudeyu on 2017/3/13.
 */
public class ClassInial {

    public static void main(String[] args) {
        System.out.println(new Const().B);
    }
}

class Const {
    static final int A = 100;
    final int B=10;

    static {
        System.out.println("Const init");
    }
}
