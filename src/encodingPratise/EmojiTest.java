package encodingPratise;

/**
 * Created by liudeyu on 2017/5/19.
 */
public class EmojiTest {

    public static void main(String[]args){
        char a1='我';
        char c=(char) 0x597d;
        char b=(char)0x1F600;

        int frownyFace = 0x1F607;
        String s = Character.toString((char)frownyFace);
        System.out.println(s);
// Turn that frown upside down!
        s = Character.toString((char)(s.codePointAt(0) + 1));
        System.out.println(s);
    }
}
