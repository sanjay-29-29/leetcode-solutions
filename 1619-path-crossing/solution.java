class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int[] origin = {0,0};
        set.add(0 + " " + 0);

        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N'){
                origin[0] += directions[1][0];
                origin[1] += directions[1][1];
            }
            if(path.charAt(i) == 'S'){
                origin[0] += directions[3][0];
                origin[1] += directions[3][1];
            }
             if(path.charAt(i) == 'E'){
                origin[0] += directions[2][0];
                origin[1] += directions[2][1];
            }
             if(path.charAt(i) == 'W'){
                origin[0] += directions[0][0];
                origin[1] += directions[0][1];
            }

            String key = origin[0] + " " + origin[1];
            if(set.contains(key)){
                return true;
            }

            set.add(key);
        }

        return false;
    }
}
