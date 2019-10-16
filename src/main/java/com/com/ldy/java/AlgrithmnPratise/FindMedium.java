package com.com.ldy.java.AlgrithmnPratise;

/**
 * Created by liudeyu on 2017/3/12.
 */
public class FindMedium {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }

        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i]<nums2[j]) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }
        while(i<nums1.length){
            result[index++]=nums1[i++];
        }
        while(j<nums2.length){
            result[index++]=nums2[j++];
        }
        double tmp = 0;
        if (isOdd) {
            tmp = (double)result[(nums1.length + nums2.length) / 2];
        } else {
            int right = (nums1.length + nums2.length) / 2;
            int left = right - 1;
            tmp = (double) (result[left] + result[right]) / 2.0;
        }
        return tmp;

    }

    public static void main(String[] args) {
        FindMedium medium = new FindMedium();
        double m = medium.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println("m is "+m);
    }
}
