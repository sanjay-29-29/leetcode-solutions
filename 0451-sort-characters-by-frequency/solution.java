class Solution {
    class Helper{
        char c;
        int count;

        Helper(char _c, int _count){
            c = _c;
            count = _count;
        }
    }

    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Helper> heap = new PriorityQueue<>(new Comparator<Helper>(){
            public int compare(Helper a, Helper b){
                return Integer.compare(b.count, a.count);
            }
        });

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        for(char c : map.keySet()){
            heap.offer(new Helper(c, map.get(c)));
        }

        while(!heap.isEmpty()){
            Helper curr = heap.poll();
            for(int i = 0; i < curr.count; i++){
                res.append(curr.c);
            }
        }

        return res.toString();
    }
}
