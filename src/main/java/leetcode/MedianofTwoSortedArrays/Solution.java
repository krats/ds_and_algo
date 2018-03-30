package leetcode.MedianofTwoSortedArrays;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=-1;
        int n = nums1.length;
        int m = nums2.length;
        int median = ((n+m)/2)-1;
        int index1 = 0;
        int index2 = 0;
        double ans = 0;
        while (i < median && index1 < n && index2 < m) {
            if(nums1[index1] > nums2[index2]) {
                ans = nums2[index2];
                index2++;
            } else {
                ans = nums1[index1];
                index1++;
            }
            i++;
        }
        if(i != median) {
            if(index1 == n) {
                while (i < median) {
                    i++;
                    ans = nums2[index2];
                    index2++;
                }
            } else {
                while (i < median) {
                    i++;
                    ans = nums1[index1];
                    index1++;
                }
            }
        }
        if((m+n)%2 == 0) {
            if(index1 == n) {
                ans = ans + nums2[index2];
            } else if(index2 == m) {
                ans = ans + nums1[index1];
            } else {
                ans = ans + Math.min(nums1[index1], nums2[index2]);
            }
            ans = ans/2;
        } else {
            if(index1 == n) {
                ans = nums2[index2];
            } else if(index2 == m) {
                ans = nums1[index1];
            } else {
                ans = Math.min(nums1[index1], nums2[index2]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3,4}, new int[]{2,5,6}));
    }
}
