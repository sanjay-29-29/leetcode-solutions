/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        while(left <= right){
            int mid = (int) (((long) left + right) / 2);
            int res = guess((int)mid);
            if(res == 0){
                return mid;
            }else if(res == -1){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return 0;
    }
}
