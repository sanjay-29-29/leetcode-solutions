class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] s) {
        boolean[] visited = new boolean[recipes.length];
        Set<String> supplies = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (String s1 : s) {
            supplies.add(s1);
        }

        cook(supplies, recipes, ingredients, visited, 0, res);
        return res;
    }

    private void cook(Set<String> supply,
            String[] recipies,
            List<List<String>> ingredients,
            boolean[] visited,
            int index,
            List<String> res) {
        if (index >= recipies.length) {
            return;
        }
        if(visited[index]){
            return;
        }
        boolean can = canCook(supply, ingredients.get(index));
        if(can){
            visited[index] = true;
            supply.add(recipies[index]);
            res.add(recipies[index]);
            for(int i = 0; i < recipies.length; i++){
                cook(supply, recipies, ingredients, visited, i, res);
            }
        }else{
            cook(supply, recipies, ingredients, visited, index + 1, res);
        }
    }

    private boolean canCook(Set<String> supplies, List<String> ingredients) {
        for (String s : ingredients) {
            if (!supplies.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
