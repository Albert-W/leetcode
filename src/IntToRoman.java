/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */

import java.util.TreeMap;

public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] syms ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;

        StringBuilder s=new StringBuilder();
        while(num!=0){
            if (num>=nums[i]){
                s.append(syms[i]);
                num-=nums[i];
            } else i++;

        }
        return s.toString();
    }


}
