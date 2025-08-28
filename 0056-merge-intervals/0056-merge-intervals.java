class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        // Pehle sort krenge on the basis of first 
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));

        // Hr ek interval ko get krenge
        for(int[] interval : intervals){
            // Agr hmara ans khali hai ya fr voh interval overlap nhi krra toh new add krdo
            if(ans.isEmpty() || interval[0] > ans.get(ans.size()-1)[1]){
                ans.add(interval);
            }
            else{
                // Agr interval overlap kr rha hai toh last vaale interval ko get krke usko update krdo
                int[] lastInterval = ans.get(ans.size()-1);
                lastInterval[1] = Math.max(interval[1], lastInterval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}