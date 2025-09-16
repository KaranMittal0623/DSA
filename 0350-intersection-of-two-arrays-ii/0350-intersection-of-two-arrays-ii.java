class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        ArrayList<Integer> result = new ArrayList<>();

        int i=0,j=0;
        while(i<l1 && j<l2){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] finalResult = new int[result.size()];
        for(int k=0;k<result.size();k++){
            finalResult[k] = result.get(k);
        }
        return finalResult;
    }
}