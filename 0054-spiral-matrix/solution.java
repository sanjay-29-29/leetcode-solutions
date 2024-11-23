class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        while(count < matrix.length * matrix[0].length){
            System.out.println(count);
            while(j < matrix[0].length && i < matrix.length && !set.contains(i + " " + j)){
                list.add(matrix[i][j]);
                set.add(i + " " + j);
                count++;
                j++;
            }
            j = j - 1;
            i = i + 1;
            while(j < matrix[0].length && i < matrix.length && !set.contains(i + " " + j)){
                list.add(matrix[i][j]);
                set.add(i + " " + j);
                count++;
                i++;
            }
            i = i - 1;
            j = j - 1;
            while(j >= 0 && i < matrix.length  && !set.contains(i + " " + j)){
                list.add(matrix[i][j]);
                set.add(i + " " + j);
                count++;
                j--;
            }
            j = j + 1;
            i = i - 1;
            while(j < matrix[0].length && i >= 0  && !set.contains(i + " " + j)){
                list.add(matrix[i][j]);
                set.add(i + " " + j);
                count++;
                i--;
            }
            i = i + 1;
            j = j + 1;
        }

        return list;
    }
}
