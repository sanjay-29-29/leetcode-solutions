class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        List<Integer> roomZero = rooms.get(0);
        visited.add(0);
        for(int i = 0; i < roomZero.size(); i++){
            stack.add(roomZero.get(i));
        }

        while(!stack.isEmpty()){
            int currentIndex = stack.pop();
            
            if(visited.contains(currentIndex)){
                continue;
            }
            
            visited.add(currentIndex);
            
            List<Integer> currentRoom = rooms.get(currentIndex);

            for(int i = 0; i < currentRoom.size(); i++){
                stack.add(currentRoom.get(i));
            }
        }

        if(visited.size() == rooms.size())
            return true;
        return false;
    }
}
