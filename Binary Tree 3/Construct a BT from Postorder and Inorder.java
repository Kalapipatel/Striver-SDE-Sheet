/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
*/

class Solution {
    public TreeNode fun(int preorder[], int prestart, int preend, int inorder[], int instart, int inend, Map<Integer, Integer> map){

        if(prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot = map.get(root.val);
        int nodesleft = inroot - instart;

        root.left = fun(preorder, prestart+1, prestart + nodesleft, inorder, instart, inroot - 1, map);
        root.right = fun(preorder, prestart + nodesleft + 1, preend, inorder,  inroot + 1, inend, map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = preorder.length;

        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = fun(preorder, 0, len-1, inorder, 0, len-1, map);
        return root;
    }
}
