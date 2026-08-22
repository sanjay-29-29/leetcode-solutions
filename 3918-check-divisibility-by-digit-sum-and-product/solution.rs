impl Solution {
    pub fn check_divisibility(n: i32) -> bool {
        let vec = Solution::get_nums(n);

        let sum: i32 = vec.iter().sum();
        let product: i32 = vec.into_iter().product(); 

        n % (sum + product) == 0
    }

    pub fn get_nums(mut n: i32) -> Vec<i32> {
        let mut vec = Vec::new();

        while n > 0 {
            vec.push(n % 10);
            n /= 10;
        }

        vec
    }
}
