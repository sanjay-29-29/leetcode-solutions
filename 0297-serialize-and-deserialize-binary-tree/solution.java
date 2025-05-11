/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            
            if(t == null) {
                res.append("null" + " ");
                continue;
            }
            res.append(String.valueOf(t.val) + " ");
            q.add(t.left);
            q.add(t.right);
        }
        System.out.println(res);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = null; 

        for(int i = 0; i < list.length; i++) {
            if(root == null) {
                root = valueOf(list[i]);
                q.add(root);
            }
            else {
                TreeNode par = q.poll();
                par.left = valueOf(list[i]);
                
                if(par.left != null) {
                    q.add(par.left);
                }

                if(i != list.length - 1) { 
                    i += 1;
                    par.right = valueOf(list[i]);
                    if(par.right != null) {
                        q.add(par.right);
                    }
                }
            }
        }

        return root;
    }

    private TreeNode valueOf(String data) {
        if(data.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(data));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
