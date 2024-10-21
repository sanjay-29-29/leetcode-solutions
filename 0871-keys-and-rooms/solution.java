class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<rooms.get(0).size();i++){
            stack.push(0);
        }

        while(!stack.isEmpty()){
            int current = stack.pop();
            if(set.contains(current)){
                continue;
            }
            set.add(current);
            System.out.println(current);
            for(int i=0;i<rooms.get(current).size();i++){
                int val = rooms.get(current).get(i);
                stack.push(val);
            }
        }
        if(set.size() == rooms.size()){
            return true;
        }
        return false;
    }
}
