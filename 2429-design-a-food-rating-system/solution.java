class FoodRatings {
    class FoodItem implements Comparable<FoodItem> {
        String food, cuisine;
        int rating;

        FoodItem(String f, int r, String c) {
            food = f;
            rating = r;
            cuisine = c;
        }

        public int compareTo(FoodItem f) {
            if(this.rating == f.rating)
                return this.food.compareTo(f.food);
            return Integer.compare(f.rating, this.rating);
        }

        public int hashCode() {
            return food.hashCode();
        }
    }

    Map<String, FoodItem> map = new HashMap<>();
    Map<String, Set<FoodItem>> c = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            FoodItem f = new FoodItem(foods[i], ratings[i], cuisines[i]);
            Set<FoodItem> s = c.getOrDefault(cuisines[i], new TreeSet<>());
            s.add(f);
            c.put(cuisines[i], s);
            map.put(foods[i], f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        FoodItem f = map.get(food);
        Set<FoodItem> set = c.get(f.cuisine);
        set.remove(f);
        FoodItem newItem = new FoodItem(food, newRating, f.cuisine);
        set.add(newItem);
        map.put(food, newItem);
    }
    
    public String highestRated(String cuisine) {
        Set<FoodItem> s = c.get(cuisine);
        for(FoodItem f : s) {
            return f.food;
        }
        return null;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
