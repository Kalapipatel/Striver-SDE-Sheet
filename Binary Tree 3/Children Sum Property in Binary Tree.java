/*
Given the root of a binary tree, determine whether the tree satisfies the Children Sum Property. In this property, each non-leaf node must have a value equal to the sum of its left and right children's values. A NULL child is considered to have a value of 0, and all leaf nodes are considered valid by default.
Return true if every node in the tree satisfies this condition, otherwise return false.

Examples:

Input: root = [35, 20, 15, 15, 5, 10, 5]

Output: True
Explanation: Here, every node is sum of its left and right child.
Input: root = [1, 4, 3, 5]
  
Output: False
Explanation: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 105
*/


class Solution {
    public boolean isLeaf(Node root){
        if(root.left == null && root.right == null) return true;
        return false;
    }
    public int fun(Node root){
        if(root == null) return 0;
        if(isLeaf(root) == true) return root.data;
        
        if(root.left == null){
            if(root.data != root.right.data) return -1;
        }
        else if(root.right == null){
            if(root.data != root.left.data) return -1;
        }
        else
            if(root.data != root.left.data + root.right.data) return -1;
        
        int left = fun(root.left);
        if(left == -1) return -1;
        int right = fun(root.right);
        if(right == -1) return -1;
        
        return root.data;
        
    }
    public boolean isSumProperty(Node root) {
        if(isLeaf(root)) return true;
        int ans = fun(root);
        
        if(ans == -1) return false;
        return true;
    }
}

// -------------------- change the tree which follow this property. 
// you can increment data by 1 any num of times but you can't decerement it

class Solution {
    public void change(TreeNode root) {
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;

        if(child >= root.data) root.data = child;
        else{
            if(root.left != null) root.left.data = root.data;
            else if(root.right != null) root.right.data = root.data;
        }

        change(root.left);
        change(root.right);

        int tot = 0;
        if(root.left != null) tot += root.left.data;
        if(root.right != null) tot += root.right.data;

        if(root.left != null || root.right != null) root.data = tot;
    }
}
