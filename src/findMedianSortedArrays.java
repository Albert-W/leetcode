public class findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        if(l1>l2)return findMedianSortedArrays(nums2,nums1);//make sure l1<=l2;


        int target = (l1+l2+1)/2;//右中位数，大的哪个。
        int min=0; //l1 中取出的个数;
        int max=l1; //
        //it's the core part. to get the slide place.
        {
            while (min < max) {
                int ofn1 = (max + min -1) / 2;//l1 中的中位数下标（0~l1-1）
                int ofn2 = target - ofn1;//((l2-l1+3)/2,(l1+l2+1)/2)
                if (nums1[ofn1] < nums2[ofn2-1]) {
                    min = ofn1+1;
                } else {
                    max = ofn1;
                }
            }
        }
        int m1=min;
        int m2=target-min;

        //如果m1=0,全从l2中取，如果m2=0,全从l1中取；
        //否则在num[m1-1]与nums2[m2-1]中取大值
        //even (k-1,k)
        //odd (k-1)

        int cleft = Math.max(
            m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
            m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if ((l1 + l2) % 2 == 1)
            return cleft;

        int cright = Math.min(
            m1 >= l1 ? Integer.MAX_VALUE : nums1[m1],
            m2 >= l2 ? Integer.MAX_VALUE : nums2[m2]);

        return (cleft + cright) * 0.5;

    }

    public int halfsearch(int[] num,int key){
        int max,min,mid;
        min=0;
        max=num.length-1;
        mid=(min+max)/2;
        while(min<max){
            if(num[mid]==key)return mid;
            else if(num[mid]<key)min=mid;
            else if(num[mid]>key)max=key;
            mid=(min+max)/2;

        }
        return mid;
    }
}

