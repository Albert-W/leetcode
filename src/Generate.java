import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Generate {
    //也可以不用结果，直接利用数学公式C(4,2)=4*3/(1*2);
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0)return res;
        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                temp.add(c(i,j));
            }
            res.add(temp);
        }
        return res;
    }

    //数学公式C(4,2)=4*3/(1*2);
    int c(int a,int b){
        int res=1;
        for(int i=1;i<=b;i++){
            //res*=(a+1-i)/i; //发生了四舍入五，导致错误；
            res=res*(a+1-i)/i;
        }
        return res;
    }



    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0)return res;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for(int i=1;i<numRows;i++){
            //照搬上一层；
            temp = new ArrayList<>(res.get(i-1));//temp.lengh = i;
            for(int j=1;j<i;j++){
                temp.set(j,res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;



    }
}
