/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int flag = 1;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<len; i++){
                TreeNode curr = q.remove();

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);

                if(flag < 0) list.add(0, curr.val);
                else list.add(curr.val);
            }

            ans.add(list);
            flag = flag * -1;
        }

        return ans;
    }
}
