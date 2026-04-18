impl Solution {
    pub fn mirror_distance(n: i32) -> i32 {
        return n.abs_diff(Solution::reverse(n.clone())) as i32;
    }

    pub fn reverse(mut n: i32) -> i32 {
        let mut res = 0;

        while n > 0 {
            res = (res * 10) + (n % 10);
            n /= 10;
        }

        res
    }
}
