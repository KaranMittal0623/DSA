class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums,res,new ArrayList<>());
        return res;
    }
    public void backtracking(int[] nums, List<List<Integer>> res, List<Integer> subList){
        if(subList.size()==nums.length){
            res.add(new ArrayList<>(subList));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(subList.contains(nums[i])){
                    continue;
                }
                subList.add(nums[i]);
                backtracking(nums,res,subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}