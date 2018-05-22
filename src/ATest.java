public class ATest {
    public static void main(String[] args) {
        //System.out.println(new CountAndSay().countAndSay(4));
        //System.out.println(new RolveNQueens().solveNQueens(4));
//        List<List<String>> results = new RolveNQueens().solveNQueens(4);
//        for(int i=0;i<results.size();i++){
//            for(int j=0;j<results.get(i).size();j++){
//                System.out.println(results.get(i).get(j));
//
//            }
//        }
//        System.out.println(new TotalNQueens().totalNQueens(4));
        //53. Maximum Subarray
//        int[] i=new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(new MaxSubArray().maxSubArray(i));
        //123. Best Time to Buy and Sell Stock III
//        int[] i=new int[]{3,3,5,0,0,3,1,4};
//        System.out.println(new MaxProfit3().maxProfit(i));
        //188. Best Time to Buy and Sell Stock IV
//        int[] i=new int[]{2,6,8,7,8,7,9,4,1,2,4,5,8};
//        System.out.println(new MaxProfit4().maxProfit(3,i));
        //67. Add Binary
//        System.out.println(new AddBinary().addBinary("100","110010"));
        //43. Multiply Strings
//        System.out.println(new Multiply().multiply("123",
//            "456")); //56088;
        //415. Add Strings
//        System.out.println(new AddStrings().addStrings("9","9"));
        //69. Sqrt(x)
//        System.out.println(new MySqrt().mySqrt(5));
        //367. Valid Perfect Square
//        System.out.println(new IsPerfectSquare().isPerfectSquare(10));
        //633. Sum of Square Numbers
//        System.out.println(new JudgeSquareSum().judgeSquareSum(1000));
//        System.out.println(-3/2);
//      70. Climbing Stairs
//        System.out.println(new ClimbStairs().climbStairs(3));
//746. Min Cost Climbing Stairs
//        int[] i= new int[]{0,0, 1, 1};
//        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(i));
//82. Remove Duplicates from Sorted List II
//        int[] l=new int[]{1,2,3,3,4,4,5};
//        ListNode n=new ListNode(0);
//        ListNode c=n;
//        for(int i=0;i<l.length;i++){
//            c.next=new ListNode(l[i]);
//            c=c.next;
//        }
//        System.out.println(new DeleteDuplicates2().deleteDuplicates(n.next));
//102. Binary Tree Level Order Traversal
//        int[] l=new int[]{3,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7};
//        TreeNode head = new TreeNode(l[0]);
//        Queue<Integer> q = new LinkedList<>();
//        q.add(null);
//        q.add(null);
//        q.add(3);
//        System.out.println(q.size());//两个null,就size为3；
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(null);
//        a.add(3);
//        System.out.println(a.size());//size为2；
//113. Path Sum II
//        int[] l=new int[]{5,4,8,11,0,13,4,7,2,0,0,5,1};
//        TreeNode head= new BuildTree().buildTree(l);
//        List<List<Integer>>res = new PathSum2().pathSum2(head,22);
//        System.out.println(res.toString());//toString可以直接输出
//437. Path Sum III
//        int[] l= new int[]{10,5,-3,3,2,0,11,3,-2,0,1};
//        TreeNode head=new BuildTree().buildTree(l);
//        System.out.println(new PathSum3().pathSum(head,8));
//257. Binary Tree Paths
//        int[] l= new int[]{5,4,8,11,0,13,4,7,2,0,0,5,1};
//        TreeNode head=new BuildTree().buildTree(l);
//        System.out.println(new BinaryTreePaths().binaryTreePaths(head).toString());
//118. Pascal's Triangle
//        System.out.println(new Generate().c(4,4));
//125. Valid Palindrome
//        System.out.println(new IsPalindromeS().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new IsPalindromeS().isPalindrome("p0P"));
//680. Valid Palindrome II
//        System.out.println(new IsPalindromeS2().validPalindrome("cbbcc"));
//        System.out.println(new IsPalindromeS2().validPalindrome("abac"));
//        System.out.println(0|1^2&3);//3
//        int a = 423457932;
//        int b = 3;
//        int c= a | (a & b);
//        int d = ( 4 | 3 )^ 1;
//        int e =( 4 ^ 1 ) | (3 ^ 1 );
//        return;
//693. Binary Number with Alternating Bits
//        System.out.println(new HasAlternatingBits().hasAlternatingBits(12));
//191. Number of 1 Bits
//        System.out.println(new HammingWeight().hammingWeight(11));
//326. Power of Three
//        System.out.println(new IsPowerOfThree().isPowerOfThree(243));
//342. Power of Four
//        System.out.println(new IsPowerOfFour().isPowerOfFour(16));
//287. Find the Duplicate Number
//        int[] i= new int[]{1, 4, 0, 0, 3, 2 };
//        int[] i = new int[]{3, 1, 3, 4, 2};
//        System.out.println(new FindDuplicate().findDuplicate2(i));
//561. Array Partition I
//        int[] i = new int[]{1, 2, 3, 2};
//        System.out.println(new ArrayPairSum().arrayPairSum2(i));
//169. Majority Element
//        int[] i = new int[]{8, 8, 7, 7, 7};
//        System.out.println(new MajorityElement().majorityElement5(i));
//
//476. Number Complement
//        System.out.println(new FindComplement().findComplement3(8));
//371. Sum of Two Integers
//        System.out.println(new GetSum().getSum2(3, 50));
//762. Prime Number of Set Bits in Binary Representation
//        System.out.println(new CountPrimeSetBits().countPrimeSetBits3(842, 888));
//405. Convert a Number to Hexadecimal
        System.out.println(new ToHex().toHex3(-1));


    }


}
