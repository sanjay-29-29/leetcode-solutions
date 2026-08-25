impl Solution {
    pub fn missing_multiple(nums: Vec<i32>, k: i32) -> i32 {
        let mut set: std::collections::HashSet<i32> = std::collections::HashSet::new();

        for i in nums {
            if i % k == 0 {
                // res = std::cmp::min(res, i / k);
                set.insert(i / k);
            }
        }

        let mut vec: Vec<&i32> = set.iter().collect();
        vec.sort_unstable();

        let mut res = 1;
        println!("{:?}", vec);
        for i in vec {
            if *i != res {
                return k * res;
            }
            res += 1;
        } 

        return res * k;
    }
}
