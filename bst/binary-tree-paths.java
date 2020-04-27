// https://leetcode.com/problems/binary-tree-paths/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> btpList = new ArrayList<String>();
        String leafPath = "";
        return rootToLeaf(root, btpList, leafPath);
    }
    
    List<String> rootToLeaf(TreeNode root, List<String> btpList, String leafPath) {
        if(root == null)
            return btpList;
        if (root.left == null && root.right == null)
            btpList.add(leafPath + root.val);
        else{
            leafPath += root.val;
            leafPath += "->";
            
            rootToLeaf(root.left, btpList, leafPath);
            rootToLeaf(root.right, btpList, leafPath);
        }
        return btpList;
    } 
}
