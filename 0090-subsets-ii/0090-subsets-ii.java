class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        solve(result,subset,nums,0);
        return result;
    }

    public void solve(List<List<Integer>> result, List<Integer> subset, int[] nums, int idx){
        if(idx==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        solve(result,subset,nums,idx+1);
        subset.remove(subset.size()-1);

        while(idx+1<nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        solve(result,subset,nums,idx+1);
    }
}