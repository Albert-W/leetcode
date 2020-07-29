/*
Codility
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).


*/


public class CyclicRotation {
    
}
class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] res = A.clone();
        for(int i = 0;i<A.length;i++){
            res[(i+K)%A.length] = A[i];
        }
        return res;
    }
}