class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length){
            int v1 = cleanText(arr1[i]);
            int v2 = cleanText(arr2[j]);

            // System.out.println(v1);
            // System.out.println(v2);

            if(v1 > v2){
                return 1;
            }
            if(v1 < v2){
                return -1;
            }

            i++;
            j++;
        }

        while(i < arr1.length){
            if(cleanText(arr1[i]) != 0){
                return 1;
            }
            i++;
        }

        while(j < arr2.length){
            if(cleanText(arr2[j]) != 0){
                return -1;
            }
            j++;
        }

        return 0;
    }

    private int cleanText(String s){
        String res = "";
        boolean flag = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0' && !flag){
                continue;
            }
            res += s.charAt(i);
            flag = true;
        }

        if(res.equals("")){
            return 0;
        }

        return Integer.valueOf(res);
    }
}
