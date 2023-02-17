package _07_重建二叉树;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/4 09:40
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (left == null && right ==null){
            return val+"";
        }
        return val+","+left+","+right;
    }
    /**
     * 	Your input:[3,9,20,15,7]
     * 			[9,3,15,20,7]
     * 	Output:[3,9,20,null,null,15,7]
     * 	Expected:[3,9,20,null,null,15,7]
     */


}
