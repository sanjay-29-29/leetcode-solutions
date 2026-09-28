impl Solution {
    pub fn max_depth(s: String) -> i32 {
        let mut stack: Vec<char> = Vec::new();
        let mut res = 0; 

        for i in s.chars() {
            if i == '(' {
                stack.push(i);
            }
            if i == ')' {
                res = std::cmp::max(res, stack.len() as i32);
                stack.pop();
            }
        }

        return res;
    }
}
