//time complexity:O(n)
//space complexity:O(n/2)
//approach: we do bfs on the tree and in every level when we reach the last elemt, we
//add into the reulst. we do this by taking the size of the q in each level.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return result;
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(i==size-1)
                    result.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return result;

    }
}