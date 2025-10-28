class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subList = new ArrayList();
        helper(nums,0,subList);
        return ans;
    }

    public void helper(int[] nums,int start,List<Integer> subList){
        ans.add(new ArrayList<>(subList));

        for(int i=start;i<nums.length;i++){
            subList.add(nums[i]);

            helper(nums,i+1,subList);

            subList.remove(subList.size()-1);
        }
    }
}