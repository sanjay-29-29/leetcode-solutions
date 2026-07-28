use std::collections::{BTreeMap};

impl Solution {
    pub fn smallest_palindrome(s: String) -> String {
        let mut map: BTreeMap<char, usize> = BTreeMap::new();

        for (i, c) in s.chars().enumerate() {
            if let Some(val) = map.get(&c) {
                map.insert(c, val + 1);
            } else {
                map.insert(c, 1);
            }
        }

        let mut c: Option<char> = None;

        let mut arr: Vec<String> = map.iter().map(|(k , v)| {
            if v % 2 != 0 {
                c = Some(k.clone());
            }
            return k.to_string().repeat(v / 2)
        }).collect();

        arr.sort_unstable();

        let reverse_str: String = arr.join("").chars().rev().collect();

        if let Some(middle) = c {
            return format!("{}{}{}", arr.join(""), middle.to_string() ,reverse_str);
        } else {
            return format!("{}{}", arr.join(""), reverse_str);
        }
    }
}
