impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack: Vec<char> = Vec::new();

        for i in s.chars() {
            if i == '(' || i == '[' || i == '{' {
                stack.push(i);
            } else {
                if let Some(val) = stack.pop() {
                    if i == ']' && val != '[' {
                        return false;
                    }
                    if i == ')' && val != '(' {
                        return false; 
                    }
                    if i == '}' && val != '{' {
                        return false; 
                    }
                } else {
                    return false;
                }
            }
        }

        stack.len() == 0
    }
}
