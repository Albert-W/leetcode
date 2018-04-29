import java.util.Stack;

/*
443. String Compression
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
Note:
All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.

 */
public class Compress {
    //count ->string ->charArray[]
    public int compress(char[] chars) {
        int index=0;
        int front=0;
        //while 循环中的index:front 是关键，否则会与for()循环中的index冲突。
        while(front<chars.length){
            int count =0;
            int back=front;
            while (front<chars.length && chars[back]==chars[front]){
                front++;
                count++;
            }

            chars[index++]=chars[back];//无论无何都需要存这个字符。
            if(count!=1){
                //String s=Integer.toString(count);
                //for(char c:s.toCharArray()){
                for(char c:Integer.toString(count).toCharArray()){
                    chars[index++]=c;
                }
            }

        }
        return index;

    }


    //count ->int(0,9)->char.
    public int compress2(char[] chars) {
        int index=0;
        int count=1;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                count++;
            } else {
                if(count==1){
                    chars[index++]=chars[i];
                } else {

                    //存储压缩后的字母；'b'
                    chars[index]=chars[i];
                    index++;
                    //存储数字；"12"  forDigit(15,16)='f';
                    Stack<Integer> s = new Stack<>();
                    while(count!=0){
                        s.push(count%10);
                        count/=10;
                    }
                    while (!s.empty()){
                        chars[index++]=Character.forDigit(s.pop(),10);
                    }
                    count=1;
                }
            }
        }
        if(count==1){
            chars[index++]=chars[chars.length-1];
        } else {

            //存储压缩后的字母；'b'
            chars[index]=chars[chars.length-1];
            index++;
            //存储数字；"12"  forDigit(15,16)='f';
            Stack<Integer> s = new Stack<>();
            while(count!=0){
                s.push(count%10);
                count/=10;
            }
            while (!s.empty()){
                chars[index++]=Character.forDigit(s.pop(),10);
            }
        }
        return index;

    }
}
