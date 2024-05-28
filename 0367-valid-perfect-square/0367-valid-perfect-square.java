class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1, high = num;

        while(low <= high) {
            long mid = low + (high - low)/2;
            if(num == mid * mid)
                return true;
            if(mid * mid > num)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }
}