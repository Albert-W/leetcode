/*
686. Repeated String Match
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch2(String A, String B) {
        String s=new String();
        for(int i=0;i<=B.length()/A.length()+1;i++){
            s = s+A;
            if(s.contains(B)) //内部调用的indexOf()
                return i+1;
        }
        return -1;
    }


    public int repeatedStringMatch3(String A, String B) {
        StringBuilder s=new StringBuilder();
        for(int i=0;i<=B.length()/A.length()+1;i++){
            s.append(A);
            if(s.indexOf(B)!=-1)
                return i+1;
        }
        return -1;
    }
    public int repeatedStringMatch(String A, String B) {
        int i=0;
        StringBuilder s=new StringBuilder();
        while(s.length()<B.length()){
            i++;
            s.append(A);
        }
        for(;i<=B.length()/A.length()+2;i++){
            if(s.indexOf(B)!=-1)
                return i;
            s.append(A);
        }
        return -1;
    }
}
