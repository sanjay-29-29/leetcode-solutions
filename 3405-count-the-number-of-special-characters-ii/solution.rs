use std::collections::{HashMap};

impl Solution {
    pub fn number_of_special_chars(word: String) -> i32 {
        let mut map: HashMap<char, usize> = HashMap::new();
        let mut res = 0;

        for (idx, c) in word.chars().enumerate() {
            if c.is_ascii_uppercase() {
                if !map.contains_key(&c) {
                    map.insert(c, idx);
                }
            } else {
                map.insert(c, idx);
            }
        }

        for (key, idx1) in &map {
            if key.is_ascii_uppercase() {
                match map.get(&key.to_ascii_lowercase()) {
                    Some(idx2) =>  {
                        if idx2 < idx1 {
                            res += 1;
                        }
                    },
                    None => {

                    }
                }
            }
        }

        res
    }
}
