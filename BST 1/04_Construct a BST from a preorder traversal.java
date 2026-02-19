/*
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
Example 1:
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
Example 2:
Input: preorder = [1,3]
Output: [1,null,3]
 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
*/

/*
so we follow steps:
1>we create the node
2>we traverse the array for values which are less than the current node!-- these values will become our left subtree.we stop whenever we get a value larger than the current root of the subtree!
3>we take the rest of the array(values whuch are greater than the value of the current root)-these are the values which will make out right subtree!

so we make a root!
make the left subtree(recursively)
then make right subtree(recursively)

code here!!
do a couple of dry runs!
u will get it!
*/

class Solution {
    public TreeNode fun(int[] pre, int s, int e){
        if(s > e) return null;

        TreeNode node = new TreeNode(pre[s]);
        int i = 0;
        for(i = s; i<=e; i++){
            if(pre[i] > node.val) break;
        }

        node.left = fun(pre, s+1, i-1);
        node.right = fun(pre, i, e);

        return node;
    }
    public TreeNode bstFromPreorder(int[] pre) {
        int n = pre.length;
        if(n == 0) return null;

        TreeNode root = fun(pre, 0, n-1);
        return root;
    }
}

// lower bound and upper bound approach
class Solution {
    int nodeIndex;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) {
            return null;
        }
        nodeIndex = 0;
        return bstHelper(preorder, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    private TreeNode bstHelper(int[] preorder, int start, int end) {
        if(nodeIndex == preorder.length || preorder[nodeIndex]<start || preorder[nodeIndex]>end) {
            return null;
        }
        int val = preorder[nodeIndex++];
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);
        return node;   
    }   
} 

// upper bound approach
class Solution {
int i = 0;
    public TreeNode bstFromPreorder(int[] arr) {
        return helper(arr, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] arr, int bound) {
        if (i == arr.length || arr[i] > bound) return null;
        TreeNode root = new TreeNode(arr[i++]);
        root.left = helper(arr, root.val);
        root.right = helper(arr, bound);
        return root;
    }
}

/*	
EXPLANATON-
"explanation- It is  possible to do this because when we construct the " left child " the upper bound will be the node value itself and no lower bound will be needed!
	-no lower bound is required for "right child" because we have arrived at this point of creating the right child only because these elements failed to satisfy the left subtree conditions!"
*/
 
