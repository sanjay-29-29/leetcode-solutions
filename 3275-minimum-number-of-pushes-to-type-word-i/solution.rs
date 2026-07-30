impl Solution {
    pub fn minimum_pushes(word: String) -> i32 {
        return (0..word.len()).map(|x| {
            match x {
                0..=7 => {
                    return 1;
                }
                8..=15 => {
                    return 2;
                }
                16..=23 => {
                    return 3;
                }
                24..=26 => {
                    return 4
                }
                _ => {
                    return 0;
                }
            } 
        }).collect::<Vec<i32>>().iter().sum()
    }
}
