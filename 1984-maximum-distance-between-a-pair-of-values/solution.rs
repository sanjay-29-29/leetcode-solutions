use std::cmp::{max};

impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        let mut res: i32 = 0;

        for (idx, val) in nums1.iter().enumerate() {
            let max_idx = Solution::binary_search(
                            &nums2, 
                            idx.clone() as i32 + 1, 
                            nums2.len() as i32 - 1, 
                            val.clone() as i32
                        );
            
            // println!("{max_idx}");

            if max_idx == -1 {
                continue;
            }

            res = max(
                res,
                max_idx - idx as i32
            );
        }

        res
    }

    pub fn binary_search(arr: &Vec<i32>, mut left: i32, mut right: i32, target: i32) -> i32 {
        let mut res = -1;

        // println!("In binary_search: {left} {right} {target}");

        while left <= right {
            let mid = ((right - left) / 2) + left;

            if arr[mid as usize] >= target {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            // println!("{left} {right}");
        }

        res
    }
}
