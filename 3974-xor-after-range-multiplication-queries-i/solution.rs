impl Solution {
    pub fn xor_after_queries(mut nums: Vec<i32>, queries: Vec<Vec<i32>>) -> i32 {
        let mut res: i32 = 0;
        // let mut nums = nums2.clone();
        
        for i in &queries {
            let mut j = i[0];
            while j <= i[1] {
                let mul: i64 = nums[j as usize] as i64 * i[3] as i64;
                nums[j as usize] = (mul % (1000000000+7)) as i32;
                j += i[2]
            }
        }

        for i in nums {
            res ^= i;
        }

        return res;
    }
}
