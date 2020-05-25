public class _278_FirstBadVersion {
    public int firstBadVersion(int n){
        for(int i = 1; i < n; i++){
            if(isBadVersion(i)){
                return i;
            }
        }
        return n;
    }

    public int firstBadVersion_A(int n){
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int n){
        int max = 10;
        int min = 1;
        int badVersion = min + (int)(Math.random()*(max - min) + 1);
        return n==badVersion;
    }
}
