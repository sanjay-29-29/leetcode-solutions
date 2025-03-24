// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         Set<List<Integer>> res = new HashSet<>();
//         uniqueWays(nums, 0, 0, target, new ArrayList<>(), res);
//         System.out.println(res);
//         return 0;
//         // int []re = new int[targer]
//     }

//     public int permute(List<Integer> list){
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i : list){
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }

//     }

//     class Helper {
//         List<Integer> 
//     }

//     public void uniqueWays(
//             int[] nums,
//             int index,
//             int currSum,
//             int target,
//             List<Integer> list,
//             Set<List<Integer>> res) {

//         if (currSum == target) {
//             Collections.sort(list);
//             res.add(list);
//             return;
//         }
//         if(currSum > target){
//             return;
//         }
//         if(index > nums.length - 1){
//             return;
//         }
//         if(nums[index] + currSum <= target){
//             List<Integer> newL = new ArrayList<>(list);
//             newL.add(nums[index]);
//             uniqueWays(
//                 nums,
//                 index,
//                 currSum + nums[index],
//                 target,
//                 newL,
//                 res
//             );
//             uniqueWays(
//                 nums,
//                 index + 1,
//                 currSum + nums[index],
//                 target,
//                 newL,
//                 res
//             );
//         }
//         uniqueWays(
//             nums,
//             index + 1,
//             currSum,
//             target,
//             list,
//             res
//         );
//     }
// }

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] re = new int [target+1];
        re[0]=1;
        for(int i=1;i<target+1;i++){
            for(int num : nums){
                if(i-num >=0){
                    re[i]+= re[i-num];
                }
            }
        }
        return re[target];
    }
}
