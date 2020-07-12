import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(9);
        l.add(7);
        // list to array;
        // int[] il = l.toArray(new int[]);
        Integer[] il = l.toArray(new Integer[3]);
        Integer[] il2 = l.toArray(new Integer[l.size()]);
        // Integer[] il3 = l.toArray(Integer[]::new);

        int[]il4 = l.stream().mapToInt(i->i).toArray();
        List<Integer> l2 = Arrays.asList(il2);

        System.out.println(Arrays.toString(il4));
        System.out.println(l);
        System.out.println(il4); 
    }
    
}