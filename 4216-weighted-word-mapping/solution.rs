impl Solution {
    pub fn map_word_weights(words: Vec<String>, weights: Vec<i32>) -> String {
        let mut res = String::from(""); 

        for i in &words {
            let mut word_weights = 0;

            for c in i.chars() {
                word_weights += weights[c as usize - 97];
            }

            res.push((122 - (word_weights % 26) as u8) as char);
        }    

        // println!("{}", 'z' as i32);

        res
    }
}
