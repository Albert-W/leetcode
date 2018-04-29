import java.util.ArrayList;
import java.util.HashMap;

/*
38. Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
/*
迭代法iterative method; repeat
中注意要点：
1、迭代法中，中间介质要清零，否则就会超限。
2、后一个与前一个比较，最后一个无人比较，需要分开讨论。
3、边界情况较多时，最好用Debugger调节，否则绕不出来的。
 */

/*
递归法 recurrence method; 重现，循环。


 */

public class CountAndSay {
    //the smart recurrence
    private String recurrence(String s){
        StringBuilder result= new StringBuilder();
        int count=0;
        int front=0;
        while(front<s.length()){
            int back=front;
            while(front<s.length() && s.charAt(back)==s.charAt(front) ){
                front++;
                count++;
            }
            result.append(count);
            result.append(s.charAt(back));
            count=0;
        }
        return result.toString();
    }



    //recurrence method;
    public String countAndSay(int n) {
        String result = new String("1");
        while(n-->1) //first while(n>1), then n--;
            result = recurrence(result);
        return result;
    }

    private String recurrence2(String s){
        StringBuilder result= new StringBuilder();
        //start to read every word.
        int count=1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else {
                result.append(count);
                result.append(s.charAt(i-1));
                count=1;
            }
        }
        result.append(count);
        result.append(s.charAt(s.length()-1));
        return result.toString();
    }


    //iteration method
    public String countAndSay4(int n) {
        //result 用于持久保存，先设置为1
        StringBuilder result = new StringBuilder("1");
        while(n-- >1){
            //
            StringBuilder temp = new StringBuilder();
            //开始读取上一轮的result
            //处理只有一个数没有比较的情况，其实可以很最后一种情形合并。
            if(result.length()==1){
                temp.append(1);
                temp.append(result.charAt(0));
                result=temp;
                continue;// 如何break 会结束while 循环；
            }

            int count=1; //i-1相同的个数
            for(int i=1;i<result.length();i++){

                if(result.charAt(i-1)==result.charAt(i)){
                    count++;
                } else{
                    temp.append(count);
                    temp.append(result.charAt(i-1));
                    count =1;
                }
            }
            temp.append(count);
            temp.append(result.charAt(result.length()-1));
            result =temp;

        }
        return result.toString();

    }




















    //Time Limit Exceeded;
    public String countAndSay2(int n) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        if (n == 1)
            return "1";
        temp.append("1");
        //循环n次
        for (int i = 2; i <= n; i++) {
            //每次对temp进行分解
            char k='0';
            if(temp.length()>0)
                k=temp.charAt(0);
            int count=1;

            //单次循环进行计算；
            for (int j = 1; j <= temp.length(); j++) {
                if (j < temp.length() && temp.charAt(j) == k) {
                    count++;

                } else{
                    result.append(count);
                    result.append(k);
                    count = 0;
                    if(j==temp.length())break;
                    k = temp.charAt(j);
                }


            }
            //进行迭代；
            temp = result;
        }
        return result.toString();
    }

    //faild because of wrong loop
    public String countAndSay3(int n) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        if (n == 1)
            return "1";
        temp.append("1");
        //循环n次
        for (int i = 2; i <= n; i++) {
//            result.delete(0,result.length()); //一些导致两者同时清空了。
            result = new StringBuilder();
            //每次对temp进行分解
            int count=0;

            //单次循环进行计算；
            for (int j = 0; j < temp.length(); j++) {
                char k = temp.charAt(j);
                while (j < temp.length() && temp.charAt(j) == k) {
                    count++;
                    j++; //两个j++ 在 “21”的情况下重复了。

                }
                result.append(count);
                result.append(k);

                count = 0;

            }
            //进行迭代；
            temp = result; //两者共指一块空间了。


        }
        return temp.toString();
    }
}
