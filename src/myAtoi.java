public class myAtoi {
    /*
    I think it the right one;
    intput:"  -0012a42"
    output:0
    but the ide don't let me pass.
     */
    public int myAtoi2(String str) {
        if(str.length()==0)return 0;
        int result=0;
        int i=0;
        boolean flag=true;
        while(str.charAt(i)==' ')i++;
        if(str.charAt(i)!='+'&&str.charAt(i)!='-'&&
            str.charAt(i)<'0'||str.charAt(i)>'9')
            return 0;
        if(str.charAt(i)=='+'){
            i++;
        }
        else if(str.charAt(i)=='-'){
            flag =false;
            i++;
        }
        while(i<str.length()){
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
                return 0;
            result *=10;
            result +=str.charAt(i++)-'0';
        }
        return (flag?result:-result);


    }

    public int myAtoi(String str) {
        if(str.length()==0)return 0;
        long result=0;
        int i=0;
        boolean flag=true;
        while(str.charAt(i)==' ')i++;
        if(str.charAt(i)!='+'&&str.charAt(i)!='-'&&
            str.charAt(i)<'0'||str.charAt(i)>'9')
            return 0;
        if(str.charAt(i)=='+'){
            i++;
        }
        else if(str.charAt(i)=='-'){
            flag =false;
            i++;
        }
        while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'
            && result<Integer.MAX_VALUE){
//            if(str.charAt(i)<'0'||str.charAt(i)>'9')
//                return 0;
            result *=10;
            result +=str.charAt(i++)-'0';
        }
        result = (flag?result:-result);

        if(result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int)result;

    }
}
