/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int[] nums ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] syms ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int indexofs=0;
        int result=0,i=0;
        while(indexofs<s.length()){
            if(s.startsWith(syms[i],indexofs)){
                indexofs+=syms[i].length();
                result+=nums[i];
            } else i++;
        }
        return result;
    }
}
