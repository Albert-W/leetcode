/*
43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class Multiply {
    //string to int, int to string;
    //预处理，当charAt操作多时，转换为char[]大幅提高效率,
    public String multiply(String num1, String num2) {
        char[] m = num1.toCharArray();
        char[] n = num2.toCharArray();

        int[] pos = new int[m.length+n.length];
        for(int i=m.length-1;i>=0;i--){
            for(int j=n.length-1;j>=0;j--){
                //由于int[]的读取顺序与个十百相反；
                //此位上的乘积会放在i+j+1位置上，并且有进位在i+j上；
                int multi = (m[i]-'0')*(n[j]-'0');
                pos[i+j+1]+=multi%10;//有出现大于100的可能,但是也没有损失信息。
                pos[i+j]+=multi/10;
//                pos[i+j+1]+=multi;
//                pos[i+j]+=pos[i+j+1]/10;
//                pos[i+j+1]%=10;
            }
        }
        //把各位置上的理顺；
        for(int i=pos.length-1;i>0;i--){
            pos[i-1]+=pos[i]/10;
            pos[i]%=10;
        }

        //得到成绩的int[] pos;
        //String.valueof只能转化char[]
        StringBuilder sb = new StringBuilder();
        //首部可能存在一个0；9133*0;四个0;
        int i=0;
        while(i<pos.length && pos[i]==0)i++;
        for(;i<pos.length;i++)
            sb.append(pos[i]);
        //0*0=0;
        return sb.length()==0? "0": sb.toString();
    }




    public String multiply2(String num1, String num2) {
//        int i=Integer.parseInt(num1);//"6913259244"out of range;2billion;
//        int j=Integer.parseInt(num2);
//        i=i*j;
//        return String.valueOf(i);
        //string to int[] and reverse;

        int m=num1.length(),n=num2.length();
        int[] pos = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                //由于int[]的读取顺序与个十百相反；
                //此位上的乘积会放在i+j+1位置上，并且有进位在i+j上；
                int multi = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=pos[i+j+1]+multi;//与原有数据相+；

                pos[i+j+1]=sum%10; //此处不能用+= 会超过10；
                pos[i+j]+=sum/10;

            }
        }
        //得到成绩的int[] pos;
        //String.valueof只能转化char[]
        StringBuilder sb = new StringBuilder();
        for(int c:pos)
            sb.append(c);
        //首部可能存在一个0；9133*0;四个0;
        int i=0;
        while(i<sb.length() && sb.charAt(i)=='0')i++;
        //0*0=0;
        return i==sb.length()? "0": sb.substring(i);
    }
}
