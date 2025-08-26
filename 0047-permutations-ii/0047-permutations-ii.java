class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        getPermutations(res,used,new ArrayList<>(),nums);
        return res;
    }

    public void getPermutations(List<List<Integer>> res,boolean[] used,List<Integer> subList,int[] nums){
        if(subList.size() == nums.length){
            res.add(new ArrayList<>(subList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1] || used[i]) continue;
            subList.add(nums[i]);
            used[i] = true;
            getPermutations(res,used,subList,nums);
            subList.remove(subList.size()-1);
            used[i] = false;
        }
        
    }
}