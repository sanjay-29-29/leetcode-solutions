impl Solution {
    pub fn count_commas(n: i32) -> i32 {
        if n <= 999 {
            return 0;
        } 

        return n - 999;
    }
}
