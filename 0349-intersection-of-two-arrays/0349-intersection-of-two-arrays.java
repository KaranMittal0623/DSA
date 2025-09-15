class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<l1 && j<l2){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                while(i<l1-1 && nums1[i] == nums1[i+1]) i++;
                while(j<l2-1 && nums2[j] == nums2[j+1]) j++;
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for(int k=0;k<list.size();k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}