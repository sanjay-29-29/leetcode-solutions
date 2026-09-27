impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        let mut stack: Vec<char> = Vec::new();
        let mut res = String::new();

        for i in s.chars() {
            if i == ')' {
                let mut inner_str = String::new();

                while let Some(val) = res.pop() {
                    if val == '(' {
                       break;
                    }

                    inner_str.push(val);
                }

                res += &inner_str;
            } else {
                res.push(i);
            }       
        }

        res
    }
}
