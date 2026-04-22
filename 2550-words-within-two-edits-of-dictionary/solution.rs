use std::cmp::{min};

impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        let mut res: Vec<String> = Vec::new();

        'outer1: for q in &queries {
            'outer: for word in &dictionary {
                let w1 = q.as_bytes();
                let w2 = word.as_bytes();

                let mut count = 0;

                for i in 0..q.len() {
                    if w1[i] != w2[i] {
                        count += 1;

                        if count == 3 {
                            continue 'outer;
                        }
                    }
                }

                res.push(q.clone());
                continue 'outer1;
            }
        }

        res
    }
}
