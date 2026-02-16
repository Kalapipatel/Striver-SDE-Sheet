/*
Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.

Examples:

Input: root[] = [1, 2, 3, 4, 5, N, N]
ex-3
Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3
Input: root[] = [1, 2, 3]

Output: [[1, 2], [1, 3]] 
Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 and 1 -> 3
Input: root[] = [10, 20, 30, 40, 60, N, N]

Output: [[10, 20, 40], [10, 20, 60], [10, 30]]
Explanation: All the possible paths from root node to leaf nodes are: 10 -> 20 -> 40, 10 -> 20 -> 60 and 10 -> 30
Constraints:
1 <= number of nodes <= 104
1 <= node->data <= 104
*/

class Solution {
    public static boolean isLeaf(Node node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
    
    public static void fun(ArrayList<ArrayList<Integer>> ans, Node root, ArrayList<Integer> list){
        if(root == null) return;
        
        list.add(root.data);
        if(isLeaf(root) == true){
            ans.add(new ArrayList<>(list));
        }
        else{
            fun(ans, root.left, list);
            fun(ans, root.right, list);
        }
        
        
        list.remove(list.size()-1);
        
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        if(root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new  ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
         
        fun(ans, root, list);
         
        return ans;
        
    }
}
