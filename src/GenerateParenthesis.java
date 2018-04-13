/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();

        generateParenthesis(n,n,res,"");
        return res;



    }
    void generateParenthesis(int left,int right,
                             ArrayList<String> res, String s){
        if(left>right)
            return;
        if(left==0&&right==0){
            res.add(s);
            return;
        }
        if(left==right){
            generateParenthesis(left-1,right,res,s+"(");
        }
        else if(left<right){
            generateParenthesis(left-1,right,res,s+"(");
            generateParenthesis(left,right-1,res,s+")");
        }

    }

}
