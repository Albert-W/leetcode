/*
476. Number Complement
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to outpu
 */
//bit manipulation
public class FindComplement {
    //
    public int findComplement5(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '0' ? 1 : 0);
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    //
    public int findComplement4(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);

    }

    //11ms;
    public int findComplement3(int num) {
        /*
        num =   0000...1010;
        mask=   1111...1010;
        ~mask;  0000...0101;
         */
        int bits = 0, temp = num;
        while (temp != 0) {
            bits++;
            temp = temp >> 1;
        }
        int mask = (~0) << bits | num;
        return ~mask;
    }

    public int findComplement2(int num) {
        //先统计num的位数；
        //12ms; ^;
        int bits = 0, temp = num;
        while (temp != 0) {
            bits++;
            temp = temp >> 1;
        }
        /*
        num =   0000...1010;
        mask=   0000...1111;
        mask^num;000...0101;
         */
        int mask = ~((~0) << bits);
        return num ^ mask;
    }

    //13ms; << |;
    public int findComplement(int num) {
        int res = 0;
        //从高位开始取,一定要32次；
        int i = 0;
        //前部虚位过滤掉；
        while (num > 0) {
            num = num << 1;
            i++;
        }
        while (i < 32) {
            //当取到位数为1时；
            if (num < 0) {
                res = (res << 1) | 0;
            } else {
                res = (res << 1) | 1;
            }
            num = num << 1;
            i++;
        }
        return res;
    }
}
