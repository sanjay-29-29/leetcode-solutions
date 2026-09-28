use std::collections::{HashMap};

struct LRUCache {
    size: i32,
    map: HashMap<i32, i32>,
    list: Vec<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LRUCache {

    fn new(capacity: i32) -> Self {
        LRUCache {
            size: capacity,
            map: HashMap::new(),
            list: Vec::new()
        }
    }
    
    fn get(&mut self, key: i32) -> i32 {
        match self.map.get(&key) {
            Some(val) => {
                let mut idx = 0;

                for i in 0..self.list.len() {
                    if key == self.list[i] {
                        idx = i;
                        break;
                    }
                }

                self.list.remove(idx as usize);
                self.list.push(key);

                return *val;
            }
            None => {
                return -1;
            }
        }
    }
    
    fn put(&mut self, key: i32, value: i32) {
        if self.list.len() == self.size as usize {
            match self.map.get(&key) {
                Some(val) => {
                    let mut idx = 0;

                    for i in 0..self.list.len() {
                        if key == self.list[i] {
                            idx = i;
                            break;
                        }
                    }

                    self.list.remove(idx as usize);
                    self.list.push(key);
                    self.map.insert(key, value);
                }
                None => {
                    let mut ele_to_remove = 0;

                    for i in &self.list {
                        ele_to_remove = *i;
                        break;
                    }

                    self.map.remove(&ele_to_remove);
                    self.list.remove(0);
                    self.list.push(key);
                    self.map.insert(key, value);
                }
            }
        } else {
            match self.map.get(&key) {
                Some(val) => {

                    let mut idx = 0;

                    for i in 0..self.list.len() {
                        if key == self.list[i] {
                            idx = i;
                            break;
                        }
                    }

                    self.list.remove(idx as usize);
                    self.list.push(key);
                    self.map.insert(key, value);
                }
                None => {
                    self.map.insert(key, value);
                    self.list.push(key);
                }
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache::new(capacity);
 * let ret_1: i32 = obj.get(key);
 * obj.put(key, value);
 */
