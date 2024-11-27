//time complexity:O(n)
//space complexity:O(h)
//aaproach: we do dfs on the tree and if the node is equal to the x/y we save the level of the node an its parent. when 
//we find y again we save its level and parent and compare its parent and level to the x values and return. 
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class cousins {
     int xlevel;
    int ylevel;
    TreeNode xparent,yparent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        this.xlevel=-1;
        this.ylevel=-1;
        this.xparent=null;
        this.yparent=null;
        helper(root,x,y,0,null);
        return xlevel==ylevel && (xparent!=yparent);
    }
    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        if(root==null) return;
        if(root.val==x)
        {
            xlevel=depth;
            xparent=parent;
        }
        if(root.val==y)
        {
            ylevel=depth;
            yparent=parent;
        }

        helper(root.left,x,y,depth+1,root);
        helper(root.right,x,y,depth+1,root);
    }
}


//time complexity:O(n)
//space complexity:O(n/2)
//approach: we do bfs on the tree, has check if the node are in the same level,if they are in the same level if both have same parents then return false
//if they are not same then return true.

Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parent =new LinkedList<>();
        boolean xfound=false,yfound=false;
        TreeNode xparent=null,yparent=null;
        q.add(root);
        parent.add(null);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                TreeNode par=parent.poll();
                if(temp.val==x)
                {
                    xfound=true;
                    xparent=par;
                }
                if(temp.val==y)
                {
                    yfound=true;
                    yparent=par;
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    parent.add(temp);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    parent.add(temp);
                }

            }
            if(xfound==true && yfound==true)    return xparent!=yparent;
            if(xfound || yfound)    return false;
        }
        return true;
