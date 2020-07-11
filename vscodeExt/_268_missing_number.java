// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

// For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

// Given A = [1, 2, 3], the function should return 4.

// Given A = [−1, −3], the function should return 1.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [1..100,000];
// each element of array A is an integer within the range [−1,000,000..1,000,000].


class Solution {
    public int solution(int[] A) {
        int[] map = new int[A.length];
        for(int i:A){
            if(i>0 && i<A.length){
                map[i] = 1;
            }
        }
        int j = 1;
        for(;j<map.length;j++){
            if(map[j]<1){
                break;
            }
        }
        return j;

    }
    
}

public class _268_missing_number {
    public static void main(String[] args) {
        int[] A = {3,0,1};
        int[] B = {9,6,4,2,3,5,7,0,1};
        int[] C = new int[] {1, 3, 6, 4, 1, 2};
        int r = new Solution().solution(C);
        System.out.println(r);
        var x = 10;
        System.out.println(x);
        System.out.println(15);
        System.out.println(017);
        System.out.println(0xf);
        System.out.println(0b1111);

    }
}