/*
372. Super Pow
Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
Credits:
Special thanks to @Stomach_ache for adding this problem and creating all test cases.


 */
public class SuperPow {
    //a^15 =(a^1)^10*a^5;
    //a^156=((a^1)^10*a^5)^10*a^6;
    //8ms;
    int M=1337;
    public int superPow(int a, int[] b) {
        //对数据预处理，极大简化后续运算；
        a%=M;
        int result=1;
        for(int i=0;i<b.length;i++){
            result=pow(result,10)*pow(a,b[i])%M;
        }
        return result;

    }
    int pow(int a, int b){
        if(b==0) return 1;
        if(b==1) return a;
        //-3/2=-1
        //use variable t can largely reduce the complexity.
        int t=pow(a,b/2);
        if(b%2==0)
            return t*t%M;
        else {
            //1334^3>Integer.MAX_VALUE;
            return t*t%M*a%M;
        }
    }



    //a^15 =(a^1)^10*a^5;
    //a^156=((a^1)^10*a^5)^10*a^6;
    public int superPow2(int a, int[] b) {
        int result=1;
        for(int i=0;i<b.length;i++){
            result=pow2(result,10)*pow2(a,b[i])%1337;
        }
        return result;

    }
    int pow2(int a, int b){
        //78267^2 越界；
        if(b==0)
            return 1;
        if(b==1)
            return a%1337;
        //-3/2=-1
        //use variable t can largely reduce the complexity.
        int t=pow(a,b/2)%1337;
        if(b%2==0)
            return t*t%1337;
        else {
            //1334^2*78267越界；
            //1334*1931497越界；
            return (t*t%1337)*(a%1337);
        }
    }
}

