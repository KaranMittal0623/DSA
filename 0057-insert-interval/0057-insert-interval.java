class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        boolean inserted= false;
        
        for(int[] interval : intervals){
            if(inserted || interval[1] < newInterval[0]){
                ans.add(interval);
            }
            else if(interval[0] > newInterval[1]){
                ans.add(newInterval);
                ans.add(interval);
                inserted = true;
            }
            else{
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
        }
        if(!inserted){
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}