class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        class Node{
            TreeNode element;
            int level;
            Node(TreeNode element, int level){
                this.element = element;
                this.level = level;
            }
        }
        
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        HashSet<Integer> set = new HashSet<>();
        Stack<Node> queue = new Stack<>();
        List<Integer> list = new ArrayList<Integer>();
        
        queue.add(new Node(root,0));

        while(!queue.isEmpty()){
            Node node = queue.pop();
            if(node.element == null) continue;
            if(set.contains(node.level)){
                List<Integer> l = returnList.get(node.level);
                l.add(node.element.val);
            }else{
                List<Integer> ls = new ArrayList<Integer>();
                ls.add(node.element.val);
                returnList.add(ls);
                set.add(node.level);
            }
            queue.push(new Node(node.element.right, node.level+1));
            queue.push(new Node(node.element.left, node.level+1));
        }

        return returnList;
    }
}
