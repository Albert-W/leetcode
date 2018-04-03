public class isPalindrome {
    public boolean isPalindrome(int x) {
        if(x==0)return true;
        if(x%10==0||x<0)return false;
        int t=0;
        //half of the loop.
        while(x>t){
            t=t*10+x%10;
            x/=10;
        }
        //example: 12321
        return x==t||x==t/10;

    }
}
