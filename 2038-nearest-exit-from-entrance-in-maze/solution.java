class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<List> queue = new LinkedList<>();
        List<Integer> startPos = new ArrayList<Integer>();

        startPos.add(entrance[0]);
        startPos.add(entrance[1]);
        startPos.add(0);
        
        System.out.println(startPos);
        queue.add(startPos);
        
        while(!queue.isEmpty()){
            List<Integer> current = queue.remove();
            int i = current.get(0);
            int j = current.get(1);
            int distance = current.get(2);
            
            boolean exp1 = (0 <= i && i < maze.length);
            boolean exp2 = (0 <= j && j < maze[0].length);
            boolean startCondition = (i == entrance[0] && j == entrance[1]);
            boolean isBorder = (i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1);

            if(!exp1 || !exp2){
                continue;
            }
            if(maze[i][j] == '+'){
                continue;
            }
            if(!startCondition && isBorder && maze[i][j] == '.'){
                return distance;
            }
            maze[i][j] = '+';

            queue.add(List.of(i+1, j, distance+1));
            queue.add(List.of(i-1, j, distance+1));
            queue.add(List.of(i, j+1, distance+1));
            queue.add(List.of(i, j-1, distance+1));

        }
        return -1;
    }
}
// System.out.println(startPos);
// class Solution {
//     HashSet<String> set;
//     int[] start;
//     int return_val = Integer.MAX_VALUE;

//     public int nearestExit(char[][] maze, int[] entrance) {
//         start = entrance;
//         set = new HashSet<String>();
//         dfs(maze, entrance[0], entrance[1], 0);
//         if(return_val == Integer.MAX_VALUE){
//             return -1;
//         } 
//         return return_val;
//     }
    
//     public void dfs(char[][] maze, int i, int j, int distance){
//         boolean exp1 = (0 <= i && i < maze.length);
//         boolean exp2 = (0 <= j && j < maze[0].length);
        
//         if(!exp1 || !exp2){
//             return;
//         }

//         if(maze[i][j] == '+'){
//             return;
//         }
        
//         boolean exp3 = (i == 0 || j == 0 || j == maze[0].length-1  || i == maze.length-1);
//         boolean exp4 = (start[0] == i && start[1] == j);
        
//         if(exp3 && maze[i][j] == '.' && !exp4){
//             return_val = Math.min(distance, return_val);
//             return;
//         }
//         maze[i][j] = '+';
//         distance++;
//         dfs(maze, i+1, j, distance);
//         dfs(maze, i-1, j, distance);
//         dfs(maze, i, j+1, distance);
//         dfs(maze, i, j-1, distance);
//     }
// }
