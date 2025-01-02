class Solution {
    public int compareTo(int a1, int b1) {
        String a = String.valueOf(a1) + String.valueOf(b1);
        String b = String.valueOf(b1) + String.valueOf(a1);

        int i = 0;
        int j = 0;

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) > b.charAt(j)){
                return 1;
            }else if(a.charAt(i) < b.charAt(j)){
                return -1;
            }else{
                i++;
                j++;
            }
        }

        if(a.length() > b.length()){
            return 1;
        }
        return -1;
    }

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (compareTo(nums[i], nums[j]) == 1) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            str.append(nums[i]);
            // System.out.println(nums[i]);
        }

       String res = str.toString();
       int i = 0;
       while(res.charAt(i) == '0' && i < res.length() - 1){
        i++;
       }
       return res.substring(i, res.length());
    }
}
