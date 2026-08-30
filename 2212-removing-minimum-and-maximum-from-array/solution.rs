impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        let (mut min_idx, mut min_val): (usize, i32) = (0, i32::MAX);
        let (mut max_idx, mut max_val): (usize, i32) = (0, i32::MIN);

        for i in 0..nums.len() {
            if nums[i] > max_val {
                max_val = nums[i];
                max_idx = i;
            }
            if min_val > nums[i] {
                min_val = nums[i];
                min_idx = i;
            }
        }

        let mut res = i32::MAX;

        res = std::cmp::min(
            res,
            std::cmp::max(min_idx, max_idx) as i32 + 1
        );

        res = std::cmp::min(
            res,
            (nums.len() - std::cmp::min(min_idx, max_idx)) as i32
        );

        res = std::cmp::min(
            res, 
            (std::cmp::min(min_idx, max_idx) + 1 + nums.len() - std::cmp::max(min_idx, max_idx)) as i32
        );

        return res;
    }
}
