use std::collections::{HashMap};

impl Solution {
    pub fn contains_cycle(grid: Vec<Vec<char>>) -> bool {
        let mut visited: Vec<Vec<bool>> = Vec::new();
        let mut map: HashMap<String, bool> = HashMap::new();

        for row in 0..grid.len() {
            let mut vec = Vec::new();
            for col in 0..grid[row].len() {
                vec.push(false);
            }
            
            visited.push(vec);
        }
        
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if Solution::cycle_exists(&grid, &mut visited, i as i32, j as i32, i as i32, j as i32, true, &mut map) {
                    return true;
                }
            }
        }

        return false;
    }

    pub fn cycle_exists(grid: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, x: i32, y: i32, prev_x: i32, prev_y: i32, start: bool, map: &mut HashMap<String, bool>) -> bool {
        if x >= grid.len() as i32 || y >= grid[0].len() as i32 || x < 0 || y < 0 {
            return false;
        }

        if grid[prev_x as usize][prev_y as usize] != grid[x as usize][y as usize] {
            return false;
        }

        if visited[x as usize][y as usize] == true {
            return true;
        }

        let key = String::from(format!("{x} {y}"));

        match map.get(&key) {
            Some(val) => {
                return *val;
            }
            None => {

            }
        }

        visited[x as usize][y as usize] = true;

        let dir = vec![
            vec![0, 1],
            vec![1, 0],
            vec![0, -1 as i32],
            vec![-1, 0]
        ];

        let mut res = false;

        for d in dir {
            let (new_x, new_y) = (x + d[0] as i32, y + d[1] as i32);

            if new_x == prev_x && new_y == prev_y {
                continue;
            }

            res = res || Solution::cycle_exists(
                grid, visited, new_x, new_y, x, y, false, map
            );
        }

        visited[x as usize][y as usize] = false;

        map.insert(key, res);

        return res;
    }
}
