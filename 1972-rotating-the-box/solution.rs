impl Solution {
    pub fn rotate_the_box(mut box_grid: Vec<Vec<char>>) -> Vec<Vec<char>> {
       let mut res: Vec<Vec<char>> = Vec::new();

       'outer: for row in box_grid.iter_mut() {
            // let mut r: Vec<char> = Vec::new();
            let mut last_idx = -1;
            let mut j = 0;
            while j < row.len() {
                if row[j] == '.' {
                    let mut start_idx: i32 = j as i32;

                    loop {
                        if start_idx - 1 == last_idx {
                            break;
                        }

                        let temp = row[start_idx as usize];
                        row[start_idx as usize] = row[start_idx as usize - 1];
                        row[start_idx as usize - 1] = temp;

                        start_idx -= 1;
                    }
                    // break 'outer;
                    j = j + 1;

                    // last_idx = j as i32;
                }
                else if row[j] == '*' {
                    last_idx = j as i32;
                    j = j + 1;
                } else {
                    j += 1;
                }
            }
        }

        let mut res: Vec<Vec<char>> = Vec::new();

        for j in 0..box_grid[0].len() {
            let mut arr = Vec::new();
            let mut i : i32 = box_grid.len() as i32 - 1;
            while i > -1 {
                arr.push(box_grid[i as usize][j]);
                i -= 1;
            }

            res.push(arr);
        }

        res
    }
}
