package com.leetcode.before;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InterserctionOfTwoArrays {
    public static void main(String[] args) {
        intersection_binary(new int[]{1,2,2,1}, new int[]{2,2});
        intersection_binary(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        intersection(new int[]{1,2,2,1}, new int[]{2,2});
        intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});

    }

    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> numSet2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();

        for (int num : numSet2) if (numSet1.contains(num)) result.add(num);
        return result.stream().mapToInt(x->x).toArray();
    }

    static int[] intersection_binary(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) if (binary_search(nums1, num)) result.add(num);
        return result.stream().mapToInt(x->x).toArray();
    }

    static boolean binary_search(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = arr[mid];

            if (midVal < key) {
                low = mid+1;
            } else if (midVal > key) {
                high = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
