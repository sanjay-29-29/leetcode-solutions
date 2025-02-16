class Solution {
    class Node{
        String edge;
        double val;

        Node(String _edge, double _val){
            edge = _edge;
            val = _val;
        }

        public int hashCode(){
            return edge.hashCode();
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Set<Node>> adjList = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            String node1 = edge.get(0);
            String node2 = edge.get(1);

            Set<Node> list1 = adjList.getOrDefault(node1, new HashSet<>());
            list1.add(new Node(node2, values[i]));
            adjList.put(node1, list1);

            Set<Node> list2 = adjList.getOrDefault(node2, new HashSet<>());
            list2.add(new Node(node1, 1 / values[i]));
            adjList.put(node2, list2);
        } 


        double[] ret = new double[queries.size()];

        for(int i = 0; i < ret.length; i++){
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet<>();
            ret[i] = traverse(adjList, query.get(0), query.get(1), visited);
        }
        return ret;
    }

    private double traverse(Map<String, Set<Node>> adjList, String current, String target, Set<String> visited){ 
        if(visited.contains(current)){
            return -1;
        }
        visited.add(current);
        Set<Node> currList = adjList.get(current);
        if(currList == null){
            return -1;
        }
        for(Node node : currList){
            if(node.edge.equals(target)){
                return node.val;
            }
            double val = traverse(adjList, node.edge, target, visited);
            if(val != -1){
                return val * node.val;
            }
        }

        return -1;
    }
}
