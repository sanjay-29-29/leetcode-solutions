impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        let mut visited: Vec<bool> = Vec::new();
        
        for i in 0..arr.len() {
            visited.push(false);
        }

        return Solution::recurse(&arr, start, &mut visited);
    }

    pub fn recurse(arr: &Vec<i32>, start: i32, visited: &mut Vec<bool>) -> bool {
        if start > (arr.len() - 1) as i32 || 0 > start {
            return false;
        }

        if visited[start as usize] {
            return false;
        }

        if arr[start as usize] == 0 {
            return true;
        }

        visited[start as usize] = true;

        return Solution::recurse(
            arr,
            start + arr[start as usize],
            visited
        ) || Solution::recurse(
            arr, 
            start - arr[start as usize],
            visited
        );
    }
}
