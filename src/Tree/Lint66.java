package Tree;
/*
给出一棵二叉树，返回其节点值的前序遍历。

您在真实的面试中是否遇到过这个题？
样例
给出一棵二叉树 {1,#,2,3},

   1
    \
     2
    /
   3
 返回 [1,2,3].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}
public class Lint66 {

    // 常规递归调用
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> resu = new ArrayList<>();
        trace(root, resu);
        return resu;
    }

    private void trace(TreeNode root, List<Integer> resu){
        if(root == null)
            return;
        resu.add(root.val);
        trace(root.left, resu);
        trace(root.right, resu);
    }

    // 使用栈代替递归
    public List<Integer> preorderTraversal2(TreeNode root){
        if(root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resu = new ArrayList<>();

        stack.push(root);
        // Note: isEmpty
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            resu.add(node.val);

            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return resu;
    }
}
