class Solution {
    HashMap<Integer,Integer> mp = new HashMap<>();
    public int climbStairs(int n) {
    if(n <= 1){
        return 1;
    }
    if(mp.containsKey(n - 1) && mp.containsKey(n -2)){
        return (mp.get(n - 1)+ mp.get(n -2));
    }
    int val = climbStairs(n-1) + climbStairs(n - 2);
    mp.put(n , val);
    return val;
    }
}
