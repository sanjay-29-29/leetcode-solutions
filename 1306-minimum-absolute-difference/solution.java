class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; i++) {
            set.add(arr[i]);
            diff = Math.min(diff, Math.abs(arr[i] - arr[i + 1]));
        }

        set.add(arr[arr.length - 1]);

        // System.out.println(diff);

        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i] - diff)) {
                res.add(Arrays.asList(arr[i] - diff, arr[i]));
            }
        }

        return res;
    }
}
