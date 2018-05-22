/*
Bit manipulation summary;
1、位运算的优先级。

与算术运算（加减同优先级）不同，"与" "异或"“或”的优先级不同。

JAVA中：
“与”>“异或”>“或”
& > ^ > |
建议多用括号。


2、位运算的单向性

位运算中“与”、“或”会造成信息丢失，他们是单向运算，不可逆运算。

1 & x = y；
知道x 可以求出y,
知道y 不可能求出x。
当y = 0, x 可能等于0，2，6……
"左移"“右移”在数据溢出时也会信息丢失。

“异或”不会造成信息丢失，而且具有很好的性质。

x ^ a = y;
当a 确定时，x与y 一一对应，且
x = y ^ a;
正因为异或不会造成信息丢失，异或可以进行算杂的交换运算；（否则在交换中信息丢失，会导致无法还原）

a 与 b 互换
a ^= b;
b ^= a;
a ^= b;
由于位运算中可能的信息丢失，位运算的优先级特别重要，顺序不同，丢失的信息不同，结果就不同。

（3 | 1） & 2  = 2
3 | 1 & 2 = 3


3、运算性质

交换律:
a | b = b | a
a & b = b & a
a ^ b = b ^ a

结合律：
（3 | 1） & 2  = 2
3 | 1 & 2 = 3
证明结合律是失效的。


分配律:
( 4 | 3 )^ 1 = 6;
( 4 ^ 1 ) | (3 ^ 1 ) = 7
证明分配率是失效的。
因此，一般情况下，结合律和分配律是失效的，只有交换律能安全使用。

失效的原因与运算中的信息丢失有关。

可以证明纯异或运算是满足“结合律”和“交换律”的。

 */

/*
1、int最大值
(1<<31)-1

2、int最小值
1<<31

3、取绝对值
a ^ (a>>31) - (a>>31);

4、全1
~0 = -1 = 0xffffffff

5、负数
-a = ~a + 1


6、
a & a = a
a | a = a
a ^ a = 0 (去重常用)

7、
a & 0 = 0
a | 0 = a
a ^ 0 = a (置换常用)

8、
a & (~0) = a
a | (~0) = ~0
a ^ (~0) = ~a (取反的另一种写法)


9、置换
a ^= b;
b ^= a;
a ^= b;

10、判断奇偶(取出最后一位)
a & 1 等价于 a % 2(结果等于,位运算效率高)


11、比较两值是否相等
a ^ b ==0

12、判断最高位是否为1
a<0

13、判断符号是否相同
a ^ b >= 0

14、取出i+1位
a & (1<<i)

15、i+1位 置1
a |=1<<i

16、i+1位 置0
a &=~(1<<i)

17、i+1位 反转
a ^ (1<<i)

18、在对应i+1位，插入b的对应位；
a |=1<<i; （a的bit位置1）
a & (b & 1<<i) （与b的bit位相与）
(置1后相与=置0后相或)

19、保留最后i-1位；
a & ((1<<i)-1)

20、清零最后i-1位；
a & ~((1<<i)-1)

21、删除最后的1；
a & (a-1) (可用于判断2的幂数)

22、仅保留最后一个1;
a & (-a)

23、得到最高位的1；
a = a |(a>>1);
a = a |(a>>2);
a = a |(a>>4);
a = a |(a>>8);
a = a |(a>>16);
return (a+1)>>1;


*/


public class BitManipulation {
    public static void main(String[] args) {
        int a = 2;
        int b = -1;
        int c = ~0;
        int d = 0xffffffff;
        System.out.println(b == d && c == d);
    }


}
