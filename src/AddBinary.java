/*
67. Add Binary
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */
//Math;String;
public class AddBinary {
    //充分利用长链的数据；
    public String addBinary(String a, String b) {
        if(a.length()>b.length())
            return addBinary(b,a);
        char[] result = b.toCharArray();
        for(int i=0;i<a.length();i++){
            result[b.length()-1-i]=(char)(b.charAt(b.length()-1-i)-'0'
            +a.charAt(a.length()-1-i));
        }
        //"2021"
        for(int i=result.length-1;i>0;i--){
            if(result[i]>='2'){ //有可能出现3的情况。
                result[i]-=2; //有可能出现3的情况。
                result[i-1]++;
            }
        }
        if(result[0]<'2'){
            //return Arrays.toString(result);//[0,0,1,0]
            //valueof 只能用于char[];
            return String.valueOf(result);//[I@4554617c
        } else {
            result[0]-=2;
            return "1"+ String.valueOf(result);
        }
    }

    //纯新建char[]
    public String addBinary2(String a, String b) {
        if(a.length()>b.length())
            return addBinary(b,a);

        char[] result = new char[b.length()];
        for(int i=0;i<b.length();i++){
            int indexb=b.length()-1-i;
            int indexa=a.length()-1-i;
            if(indexa>=0){
                result[indexb]=(char)(b.charAt(indexb)-'0'+a.charAt(indexa));
            } else result[indexb]=b.charAt(indexb);
        }
        //"2021"
        for(int i=result.length-1;i>0;i--){
            if(result[i]>='2'){ //有可能出现3的情况。
                result[i]-=2; //有可能出现3的情况。
                result[i-1]++;
            }
        }
        if(result[0]<'2'){
            //return Arrays.toString(result);//[0,0,1,0]
            //valueof 只能用于char[];
            return String.valueOf(result);//[I@4554617c
        } else {
            result[0]-=2;
            return "1"+ String.valueOf(result);
        }

    }
}
