class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(null == asteroids || asteroids.length < 2) return asteroids;

        Stack<Integer> stk = new Stack<>();

        for(int asteroid : asteroids) {
            if(asteroid < 0) {
                while(!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(asteroid))
                    stk.pop();
                
                if(!stk.isEmpty() && stk.peek() > 0) {
                    if(stk.peek() == Math.abs(asteroid))
                        stk.pop();
                }
                else
                    stk.push(asteroid);
            } else {
                stk.push(asteroid);
            }
        }

        ArrayList<Integer> res = new ArrayList<>(stk);
        // Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}