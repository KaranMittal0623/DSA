class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums,int l,int r){
        if(l>=r) return;
        int m=l+(r-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,r);
        merge(nums,l,m,r);
    }
    public void merge(int[] nums,int l,int m,int r){
        int[] buf = new int[r-l+1];
        int i = l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(nums[i] <=nums[j]) buf[k++] = nums[i++];
            else buf[k++] = nums[j++];
        }
        while(i<=m) buf[k++] = nums[i++];
        while(j<=r) buf[k++] = nums[j++];
        for(int x=0;x<buf.length;x++) nums[l+x] = buf[x];
    }
}