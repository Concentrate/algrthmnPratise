package com.com.ldy.java.justForFocusPratise;

import java.util.HashSet;
import java.util.Set;

public class PermutationsPratise {

    int totalCount = 0;
    Character[] result;

    void permutaionString(String tmpOne) {
        Set<Integer> recordUse = new HashSet<>();
        totalCount = 0;
        result = new Character[tmpOne.length()];
        toImplementPermutationString(0, tmpOne, recordUse);
        System.out.println("total count is "+totalCount);
    }

    private void toImplementPermutationString(int index, String tmpOne, Set<Integer> recordUse) {
        if (index >= tmpOne.length()) {
            for (char c1 : result) {
                System.out.print(c1);
            }
            System.out.println();
            totalCount++;
            return;
        }
        for (int i = 0; i < tmpOne.length(); i++) {
            if (!recordUse.contains(i)) {
                recordUse.add(i);
                result[index] = tmpOne.charAt(i);
                toImplementPermutationString(index + 1, tmpOne, recordUse);
                recordUse.remove(i);
            }
        }

    }


    public static void main(String[] args) {

        PermutationsPratise permutationsPratise = new PermutationsPratise();
        permutationsPratise.permutaionString("abcd");

    }
}
