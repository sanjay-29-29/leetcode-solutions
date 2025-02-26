class Allocator {
    int[] memory;
    public Allocator(int n) {
       memory = new int[n];
    }

    private int isSpaceAvailable(int size) {
        for(int i = 0; i < memory.length; i++){
            int curr = i; 
            while(curr < memory.length && memory[curr] == 0){
                if(curr - i + 1 == size){
                    return i;
                }
                curr++;
            }
        }

        return -1;
    }

    public int allocate(int size, int mID) {
        int idx = isSpaceAvailable(size);

        if(idx == -1){
            return idx;
        }

        for(int i = idx; i < idx + size; i++){
            memory[i] = mID;
        }

        return idx;
    }
    
    public int freeMemory(int mID) {
        int count = 0;
        for(int i = 0; i < memory.length; i++){
            if(memory[i] == mID){
                count++;
                memory[i] = 0;
            }
        }

        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
