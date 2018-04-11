import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

/*
    *digits.substring(0,1) means the string of first letter.
    * substring(i,i+1) means the string of i th letter.
 */

public class LetterCombinations {
    public List<String> letterCombinations2(String digits) {
        if(digits.length()==0)
            return new ArrayList<String >();

        HashMap<String,String> map = new HashMap<>();
        map.put("1","");
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        map.put("0","");

        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> tem = (ArrayList<String>) letterCombinations2(digits.substring(1));
        for(int i=0;i<map.get(digits.substring(0,1)).length();i++){
            if(tem.size()==0)
                res.add(map.get(digits.substring(0,1)).substring(i,i+1));
            for(String item:tem){
                res.add(map.get(digits.substring(0,1)).substring(i,i+1).concat(item));
            }
        }
        return res;

    }

    private static final String [] Dict ={
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",

    };
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<String >();
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> tem = (ArrayList<String>) letterCombinations(digits.substring(1));
        for(int i=0;i<Dict[digits.charAt(0)-'0'].length();i++){
            if(tem.size()==0)
                res.add(Dict[digits.charAt(0)-'0'].substring(i,i+1));
            for(String item:tem){
                res.add(Dict[digits.charAt(0)-'0'].substring(i,i+1) + item);
            }
        }
        return res;
    }
}
