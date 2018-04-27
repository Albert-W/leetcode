/*
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

//sublime....     2324sdfas
//secondtime

public class convert {
    /**
     *
     * @param s
     * @param numRows
     * @return
     * method: 1.use the StringBuilder to get the optimum performance.
     *          2. use j as the current index. the next char is at j+round-2i;
     */
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;
        if(s.length()<=1)return s;
        StringBuilder result=new StringBuilder();
        int round = numRows*2-2;
        for(int i=0;i<numRows;i++){
            int j=i;

            while(j<s.length()){
                result.append(s.charAt(j));
                j+=round;
                if((j-2*i<(s.length()))&&(2*i%round!=0))
                    result.append(s.charAt(j-2*i));
            }
        }
        return result.toString();
    }
}
