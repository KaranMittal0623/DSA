class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> traverseArray=new HashSet<>();
        for(int num:nums){
            traverseArray.add(num);
        }
        int ans = k;
        while(traverseArray.contains(ans)){
            ans+=k;
        }
        return ans;
    }
}