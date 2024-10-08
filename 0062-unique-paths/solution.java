class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return uniquePaths(m,n,map);     
    }

    private int uniquePaths(int m, int n, HashMap<String, Integer> map) {
        // Check if we have already computed the result
        if (map.containsKey(m + "," + n)) {
            return map.get(m + "," + n);
        }

        // Base cases
        if (m == 1 || n == 1) {
            return 1; // If either dimension is 1, there's only one path
        }

        // Recursive calculation with memoization
        int paths = uniquePaths(m - 1, n, map) + uniquePaths(m, n - 1, map);
        map.put(m + "," + n, paths); // Store the result in the map

        return paths; // Return the computed number of unique paths
    }
}
