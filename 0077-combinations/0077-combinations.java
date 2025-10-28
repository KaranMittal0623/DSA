class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subList = new ArrayList();

        helper(1,n,k,subList);
        return ans;
    }

    public void helper(int start,int n,int k,List<Integer> subList){
        if(k==0){
            ans.add(new ArrayList<>(subList));
            return;
        }

        if(start>n){
            return;
        }

        subList.add(start);
        helper(start+1,n,k-1,subList);

        subList.remove(subList.size()-1);
        helper(start+1,n,k,subList);
    }
}