/*
10. Regular Expression Matching
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

/*
It has to use Dynamic Programming.
It is a complete match. both sides have to the same.
 */
public class IsMatch {
    //76ms;
    public boolean isMatch2(String s, String p) {
        return isMatch(s,0,p,0);

    }
    public boolean isMatch(String s, int s1,String p, int p1){
        //the outlet;
        if(s1<s.length() && p1==p.length())return false; //"a","";
        if(s1==s.length()){
            if(p1==p.length())
                return true;
            if(p1+1<p.length() && p.charAt(p1+1)=='*')
                return isMatch(s,s1,p,p1+2); //"","c*C*C*"
            else
                return false;
        }

        //start dynamic programming

        // else the next pattern has to be '*' or return false;
        if(p1+1<p.length() && p.charAt(p1+1)=='*'){
            //if the current can march.
            if(p.charAt(p1)==s.charAt(s1)||p.charAt(p1)=='.')
                //either '*'stands for more, or none.
                return isMatch(s,s1+1,p,p1)||isMatch(s,s1,p,p1+2);
            else
                //'*' has to stand for none.
                return isMatch(s,s1,p,p1+2);
        }


        //if the current is match;
        // if change the order to front, it's wrong.
        if(p.charAt(p1)==s.charAt(s1)||p.charAt(p1)=='.')
            return isMatch(s,s1+1,p,p1+1);

        return false;
    }



    //130ms;
    public boolean isMatch(String s, String p){
        if(s.length()>0 && p.length()==0)return false;
        if(s.length()==0){
            if(p.length()==0)
                return true;
            if(p.length()>1 && p.charAt(1)=='*')
                return isMatch(s,p.substring(2));
            else
                return false;
        }

        if(p.length()>1 && p.charAt(1)=='*'){
            if(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.')
                return isMatch(s.substring(1),p)||isMatch(s,p.substring(2));
            else
                return isMatch(s,p.substring(2));
        }

        if(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.')
            return isMatch(s.substring(1),p.substring(1));

        return false;

    }

}
