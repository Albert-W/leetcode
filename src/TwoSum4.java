import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
653. Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

 */
//tree; dfs;bfs;
public class TwoSum4 {
    //use the binary search method;28ms;
    //遍历每个结点，进行二分搜索O(nlgn),O(h)
    public boolean findTarget3(TreeNode root, int k) {
        //转换成深度优先函数
        return dfs(root, root, k);
    }

    boolean dfs(TreeNode root, TreeNode cur, int k) {
        //先判断当前结点cur 能来能达标；
        if (cur == null) return false;
        if (findPair(root, cur, k - cur.val)) return true;
        //遍历每一个结点；
        return dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    //找到不同于cur的结点，且值为k;
    boolean findPair(TreeNode root, TreeNode cur, int k) {
        if (root == null) return false;
        if (root.val == k && root != cur) return true;
        if (root.val > k) return findPair(root.left, cur, k);
        else return findPair(root.right, cur, k);

    }


    //record it with a HashSet
    //34ms; O(n),O(n)
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return dfs(root, k, s);
    }

    boolean dfs(TreeNode root, int k, Set<Integer> s) {
        if (root == null) return false;
        if (s.contains(k - root.val)) return true;
        else s.add(root.val);

        return dfs(root.left, k, s) || dfs(root.right, k, s);
    }


    //change it to Arraylist;
    //cannot create the list inside the function;
    //31ms;O(n),O(n);
    void toArrayList(TreeNode root, ArrayList<Integer> a) {
        if (root == null) return;
        toArrayList(root.left, a);
        a.add(root.val);
        toArrayList(root.right, a);
    }


    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        toArrayList(root, a);
        int i = 0, j = a.size() - 1;
        while (i < j) {
            if (a.get(i) + a.get(j) == k) return true;
            if (a.get(i) + a.get(j) > k) j--;
            else i++;
        }
        return false;

    }


    //深度有限遍历depth first search; it's wrong;
//    public boolean findTarget(TreeNode root, int k) {
//        if(root==null)return false;
//        if(root.val==k)return true;
//
//        return findTarget(root.left,k-root.val)||findTarget(root.right,k-root.val);
//
//    }

}
