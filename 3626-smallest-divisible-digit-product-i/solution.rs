impl Solution {
    pub fn smallest_number(n: i32, t: i32) -> i32 {
        for i in n..=n+10 {
            let d_sum = Solution::digit_sum(i);

            if d_sum % t == 0 {
                return i;
            }
        }

        return -1;
    }

    pub fn digit_sum(mut n: i32) -> i32 {
        let mut res = 1;

        while n > 0 {
            res *= n % 10;
            n /= 10;
        }

        return res;
    }
}
