use std::cmp::{min};
use std::collections::{HashMap};

struct Point(i32, i32);

impl Solution {
    pub fn minimum_distance(word: String) -> i32 {
        let char_vec: Vec<char> = word.chars().collect();
        let mut map: HashMap<String, i32> = HashMap::new();

        return recurse(0, -1, 1, &char_vec, &mut map);
    }
}

fn recurse(finger1: i32, finger2: i32, index: usize, word: &Vec<char>, map: &mut HashMap<String, i32>) -> i32 {
    if index >= word.len() {
        return 0;
    }
    
    let key = format!("{} {} {}", finger1, finger2, index);

    match map.get(
        &key
    ) {
        Some(&val) => return val,
        _ => {}
    };

    if finger2 == -1 {
        let val = min(
            recurse(finger1, index as i32, index + 1, word, map), 
            get_distance(get_coordinate(word[finger1 as usize]), get_coordinate(word[index])) + recurse(
                index as i32, finger2, index + 1, word, map
            )
        );
        map.insert(key, val);
        return val
    }

    let val = min(
        get_distance(get_coordinate(word[finger1 as usize]), get_coordinate(word[index])) + recurse(
            index as i32, finger2, index + 1, word, map
        ),
        get_distance(get_coordinate(word[finger2 as usize]), get_coordinate(word[index])) + recurse(
            finger1, index as i32, index + 1, word, map
        )
    );
    map.insert(key, val);
    return val
}

fn get_coordinate(letter: char) -> Point {
    let int_val = letter as i32 - 65;
    Point(int_val / 6, int_val % 6)
}

fn get_distance(p1: Point, p2: Point) -> i32 {
    let Point(x1, y1) = p1;
    let Point(x2, y2) = p2;

    (x1.abs_diff(x2) + y1.abs_diff(y2)) as i32
}
