class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] freq = new int[2];
        for(int student : students)
            freq[student]++;
        
        for(int i=0; i<sandwiches.length; i++) {
            if(--freq[sandwiches[i]] < 0)
                return sandwiches.length - i;
        }

        return 0;
    }
}