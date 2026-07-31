use std::collections::{BTreeMap};

impl Solution {
    pub fn minimum_pushes(word: String) -> i32 {
        let mut map: BTreeMap<char, i32> = BTreeMap::new();

        for i in word.chars() {
            map.entry(i).and_modify(|x| *x += 1).or_insert(1);
        }

        let mut freq = map.iter().map(|(k, v)| (v, k)).collect::<Vec<(&i32, &char)>>();
        freq.sort_unstable_by(|a, b| b.0.cmp(a.0));

        let mut res: i32 = 0;

        for (i, (key, val)) in freq.iter().enumerate() {
            match i {
                0..=7 =>{
                    res += *key;
                } 
                8..=15 => {
                    res += 2 * (*key);
                }
                16..=23 => {
                    res += 3 * (*key);
                }
                _ => {
                    res += 4 * (*key);
                }
            }
        }

        return res;
    }
}
