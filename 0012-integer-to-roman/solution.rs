impl Solution {
    pub fn int_to_roman(mut num: i32) -> String {
        let mut res = String::from("");

        while num > 0 {
            if num >= 1000 {
                res.push_str("M");
                num -= 1000;
            } 
            else if num >= 900 {
                res.push_str("CM");
                num -= 900;
            }
            else if num >= 500 {
                res.push_str("D");
                num -= 500;
            } else if num >= 400 {
                res.push_str("CD");
                num -= 400;
            } 
            else if num >= 100 {
                res.push_str("C");
                num -= 100;
            }
            else if num >= 90 {
                res.push_str("XC");
                num -= 90;
            }
            else if num >= 50 {
                res.push_str("L");
                num -= 50;
            }
            else if num >= 40 {
                res.push_str("XL");
                num -= 40; 
            }
            else if num >= 10 {
                res.push_str("X");
                num -= 10;
            } 
            else if num >= 9 {
                res.push_str("IX");
                num -= 10;
            }
            else if num >= 5 {
                res.push_str("V");
                num -= 5;
            }
            else if num >= 4 {
                res.push_str("IV");
                num -= 4;
            } else {
                res.push_str("I");
                num -= 1;
            }
        }

        res
    }
}
