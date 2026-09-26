use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        let mut map: HashMap<char, char> = HashMap::new();    
        let mut map2: HashMap<char, char> = HashMap::new();    
        
        let mut i = 0;
        let (a, b) = (s.as_bytes(), t.as_bytes());

        while i < a.len() {

            match map.get(&(a[i] as char)) {
                Some(val) => {
                    if *val != b[i] as char {
                        return false;
                    }
                }
                None => {
                    map.insert(a[i] as char, b[i] as char);
                }
            }

            match map2.get(&(b[i] as char)) {
                Some(val) => {
                    if *val != a[i] as char {
                        return false;
                    }
                }
                None => {
                    map2.insert(b[i] as char, a[i] as char);
                }
            }

            i += 1;
        }  

        return true;
    }
}
