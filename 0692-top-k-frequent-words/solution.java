class Solution {
    class Helper implements Comparable<Helper>{
        String word;
        int freq;

        Helper(String word, int freq){
            this.word = word;
            this.freq = freq;
        }

        public int compareTo(Helper h){
            if(h.freq == this.freq){
                return word.compareToIgnoreCase(h.word);
            }else{
                return Integer.compare(h.freq, this.freq);
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Queue<Helper> heap = new PriorityQueue<>();

        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for(String w : map.keySet()){
            heap.add(new Helper(w, map.get(w)));
        }

        List<List<String>> res = new ArrayList<>();
        List<String> l = new ArrayList<>();

        int prev = -1;
        
        for(int i = 0; i < k; i++){
            Helper h = heap.poll();
            if(h.freq != prev){
                prev = h.freq;
                Collections.sort(l);
                res.add(l);
                l = new ArrayList<>();
                l.add(h.word);
            }else{
                l.add(h.word);
            }
        }

        Collections.sort(l);
        res.add(l);

        List<String> test = new ArrayList<>();
        for(List<String> s : res){
            test.addAll(s);
        }
        return test;
    }
}
