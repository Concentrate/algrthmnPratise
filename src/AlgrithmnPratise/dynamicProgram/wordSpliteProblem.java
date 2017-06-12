package AlgrithmnPratise.dynamicProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liudeyu on 2017/6/10.
 */
public class wordSpliteProblem {

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || dict == null) {
            return false;
        }
        if (dict.isEmpty() && s.equals("")) {
            return true;
        }
        if (s.equals("") && dict.isEmpty()) {
            return true;
        }
        boolean[] result = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                result[i] = true;
                continue;
            }
            for (int j = i-1; j >= 1; j--) {
                if (result[j] && (dict.contains(s.substring(j + 1 - 1, i)))) {
                    result[i] = true;
                    break;
                }
            }

        }
        return result[s.length()];

    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream("/Users/liudeyu/data.txt"));
            String raw = scanner.nextLine();
            int setSize = scanner.nextInt();
            Set<String> words = new HashSet<>();
            while (setSize != 0) {
                words.add(scanner.next());
                setSize--;
            }
            wordSpliteProblem wordSpliteProblem = new wordSpliteProblem();
            System.out.println("result is " + wordSpliteProblem.wordBreak(raw, words));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
