import java.util.ArrayList;
import java.util.List;

/*
119. Pascal's Triangle II
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?


 */
public class Generate2 {
    //ArrayList 的set,get O(1); 与Array[]一样；

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i=1;i<=rowIndex;i++){
//            res.add(res.get(i-1)*(rowIndex+1-i)/i);
            //当值为30时出错
//            res.add((int)((double)(res.get(i-1)*(rowIndex+1-i))/i));
            //当值为30时出错
//            res.add((int)(double)(res.get(i-1))*(rowIndex+1-i)/i);
            //当值为30时出错
//            res.add((int)((double)(res.get(i-1)))*(rowIndex+1-i)/i);
            //当值为30时出错
//            double t= res.get(i-1)*(rowIndex+1-i);
//            t=t/i;
//            res.add((int)t);
            //通过
//            double t= res.get(i-1);
//            t=t*(rowIndex+1-i)/i;
//            res.add((int)t);
            //通过；第一个double强转是不能有多余括号，要立马强转第一个值；
            res.add((int)((double)res.get(i-1)*(rowIndex+1-i)/i));
        }
        return res;

    }

    //O(n2);
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            res.add(c(rowIndex,i));
        }
        return res;

    }

    //数学公式C(4,2)=4*3/(1*2);
    int c(int a,int b){
        double res=1;
        for(int i=1;i<=b;i++){
            //res*=(a+1-i)/i; //发生了四舍入五，导致错误；
//            res=res/i*(a+1-i);//防止溢出，先除后乘；为了防止进位错误，改float;
            //在高位(27)时余数出错；
            res=res*(a+1-i)/i;
        }
        return (int)res;
    }
}
