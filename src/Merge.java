/*
88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //如果num2消化完，可以返回；
        while(n>0){
            //如果nums1消化完，用Interger.MIN_VALUE代替；
            int k=0;
            if(m-1<0)
                k=Integer.MIN_VALUE;
            else k=nums1[m-1];
            //取较大的值放在尾部；
            if(k>=nums2[n-1]){
                nums1[m+n-1]=k;
                m--;
            }
            else if(k<nums2[n-1]){
                nums1[m+n-1]=nums2[n-1];
                n--;
            }
        }
        return;

    }
}
