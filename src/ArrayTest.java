import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        // System.out.println({2,3,4});
        int[] a = {2,3,4};
        System.out.println(a.toString());
        System.out.println(Arrays.toString(a));
        Student[] b = new Student[3];
        System.out.println(b.getClass().getName());

        //import java.math.BigInteger;
        // BigInteger c = 10;
        BigInteger c = new BigInteger("10");
        System.out.println(c);


    }

    class Student{

    }
    
}