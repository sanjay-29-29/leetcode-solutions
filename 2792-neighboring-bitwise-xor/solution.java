class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int count = 0;

        for(int i = 0; i < derived.length; i++){
            if(derived[i] == 1){
                count++;
            }
        }

        if(count % 2 == 0){
            return true;
        }
        return false;
    }
}
