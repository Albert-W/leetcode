/*
415. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
 //math;
public class AddStrings {
    //int('0')=48;
    public String addStrings(String num1, String num2) {
        if(num1.length()>num2.length())
            return addStrings(num2,num1);
        char[] sum=num2.toCharArray();
        //进行相加
        for(int i=0;i<num1.length();i++){
            sum[num2.length()-1-i]=(char)(num2.charAt(num2.length()-1-i)-'0'
                +num1.charAt(num1.length()-1-i));
        }
        //进位；
        for(int i=sum.length-1;i>0;i--){
            if(sum[i]>'9'){
                sum[i]=(char)(sum[i]-10);
                sum[i-1]++;
            }
        }
        StringBuilder sb=new StringBuilder();
        //首位如果是‘A',"9"+"9"
        if(sum[0]-'0'>=10){
            sb.append("1"+(char)(sum[0]-10));
        } else sb.append(sum[0]);
        for(int i=1;i<sum.length;i++)
            sb.append(sum[i]);

        return sb.toString();
    }
}
