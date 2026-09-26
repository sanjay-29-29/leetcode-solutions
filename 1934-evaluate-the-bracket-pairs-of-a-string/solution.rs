use std::collections::{HashMap};

impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        let mut map: HashMap<String, String> = HashMap::new();

        for k in knowledge {
            map.insert(k[0].clone(), k[1].clone());
        }

        let c = s.as_bytes();
        let mut i = 0;
        let mut res = String::from("");

        while i < c.len() {
            if c[i] == b'(' {
                let mut key = String::from("");
                i += 1;
                while i < c.len() && c[i] != b')' {
                    key.push(c[i] as char);
                    i += 1;
                }

                if let Some(val) = map.get(&key) {
                    res += &val.clone();
                } else {
                    res.push_str("?");
                }

                i += 1;
            }
            else {
                res.push(c[i] as char);
                i += 1;
            }
        } 

        res
    }
}
