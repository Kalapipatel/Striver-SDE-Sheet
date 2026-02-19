/*
Given a BST, and a reference to a Node k in the BST. Find the Inorder Successor of the given node in the BST. If there is no successor, return -1. 

Examples :

Input: root = [2, 1, 3], k = 2
      2
    /   \
   1     3
Output: 3 
Explanation: Inorder traversal : 1 2 3 Hence, inorder successor of 2 is 3.
Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 8
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
Output: 10
Explanation: Inorder traversal: 4 8 10 12 14 20 22. Hence, successor of 8 is 10.
Input: root = [2, 1, 3], k = 3
      2
    /   \
   1     3
Output: -1 
Explanation: Inorder traversal : 1 2 3 Hence, inorder successor of 3 is null.
Constraints:
1 <= n <= 105, where n is the number of nodes
*/


class Solution {
    public void fun(Node root, ArrayList<Integer> in){
        if(root == null) return;
        
        fun(root.left, in);
        in.add(root.data);
        fun(root.right, in);
    }
    
    public int inorderSuccessor(Node root, Node x) {
        int ans = -1;
        
        ArrayList<Integer> list = new ArrayList<>();
        fun(root, list);
        
        int idx = -1;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == x.data){
                idx = i;
            }
        }
        
        if(idx + 1 < list.size()) return list.get(idx+1);
        else return -1;
    }
}
