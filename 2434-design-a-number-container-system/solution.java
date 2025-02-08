class NumberContainers {
    Map<Integer, Integer> valueMap = new HashMap<>();
    Map<Integer, Set<Integer>> indexMap = new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(valueMap.containsKey(index)){
            int prevVal = valueMap.get(index);
            Set<Integer> prevSet = indexMap.get(prevVal);
            prevSet.remove(index);

            valueMap.put(index, number);
            Set<Integer> indexSet = indexMap.getOrDefault(number, new TreeSet<>());
            indexSet.add(index);
            indexMap.put(number, indexSet);
        }
        else{
            valueMap.put(index, number);
            Set<Integer> indexSet = indexMap.getOrDefault(number, new TreeSet<>());
            indexSet.add(index);
            indexMap.put(number, indexSet);
        }
    }
    
    public int find(int number) {
        Set<Integer> set = indexMap.get(number);
        if(set == null){
            return -1;
        }
        for(int i : set){
            return i;
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
