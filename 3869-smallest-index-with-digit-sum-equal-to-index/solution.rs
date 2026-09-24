impl Solution {
    pub fn smallest_index(nums: Vec<i32>) -> i32 {
        for (idx, val) in nums.iter().enumerate() {
            let mut num = *val;
            let mut sum = 0;

            while num > 0 {
                sum += num % 10;
                num /= 10;
            }

            if idx as i32 == sum {
                return idx as i32;
            }
        }    

        return -1;
    }
}
