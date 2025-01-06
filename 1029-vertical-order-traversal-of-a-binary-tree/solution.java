/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Helper{
        TreeNode node;
        int height;
        int width;

        Helper(TreeNode _node, int _height, int _width){
            node = _node;
            height = _height;
            width = _width;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Helper> queue = new LinkedList<>();

        queue.add(new Helper(root, 0, 0));

        while(!queue.isEmpty()){
            Helper curr = queue.poll();

            if(curr.node == null){
                continue;
            }
            
            Map<Integer, List<Integer>> levelMap = 
                map.getOrDefault(curr.width, new TreeMap<>());
            List<Integer> list = levelMap.getOrDefault(curr.height, new ArrayList<>());
            list.add(curr.node.val);
            levelMap.put(curr.height, list);
            map.put(curr.width, levelMap);
            
            queue.add(new Helper(curr.node.left, curr.height + 1, curr.width - 1));
            queue.add(new Helper(curr.node.right, curr.height + 1, curr.width + 1));
        }

        for(Map<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> newL = new ArrayList<>();
            for(List<Integer> a : levelMap.values()){
                Collections.sort(a);
                newL.addAll(a);
            }
            res.add(newL);
        }

        return res;
    } 
}
