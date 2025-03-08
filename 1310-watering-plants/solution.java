class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int tempCapacity = capacity;
        int distance = 0;

        for(int i = 0; i < plants.length; i++){
            if(plants[i] <= capacity){
                distance += 1;
                capacity = capacity - plants[i];
            }
            else{
                distance += (2 * i) + 1;
                capacity = tempCapacity;
                capacity -= plants[i];
            }
        }

        return distance;
    }
}
