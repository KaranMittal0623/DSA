class Solution {

    List<List<Integer>> finalAns = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,target,0);
        return finalAns;
    }
    public void solve(int[] candidates,int target,int idx){
        if(target==0){
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            ans.add(candidates[i]);
            solve(candidates,target-candidates[i],i);
            ans.remove(ans.size()-1);
        }

    }
}