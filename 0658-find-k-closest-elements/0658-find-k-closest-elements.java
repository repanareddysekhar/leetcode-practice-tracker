class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;

        while(low < high) {
            int mid = low + (high - low)/2;
            // mid as reference
            // x-arr[mid] lies in the left side
            // arr[mid+k]-x lies in the right side
            // we will shift the window to the right side if it is too far in the left side
            if((x - arr[mid]) > (arr[mid+k] - x))
                low = mid + 1;
            else
                high = mid;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=low; i<low+k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}