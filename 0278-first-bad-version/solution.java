/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int badVersion = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                badVersion = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return badVersion;
    }
}
