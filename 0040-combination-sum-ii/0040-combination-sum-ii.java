class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        makePermutations(candidates,target, 0,0,new ArrayList<>(), res);
        return res;
    }

    public void makePermutations(int[] candidates, int target, int idx, int totalSum, List<Integer> comb, List<List<Integer>> res){
        if(totalSum == target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(totalSum > target || idx==candidates.length){
            return;
        }

        for(int j=idx;j<candidates.length;j++){
            if(j>idx && candidates[j]==candidates[j-1]){
                continue;
            }
            comb.add(candidates[j]);
            makePermutations(candidates,target,j+1,totalSum + candidates[j], comb, res);
            comb.remove(comb.size()-1);
        }

    }
}