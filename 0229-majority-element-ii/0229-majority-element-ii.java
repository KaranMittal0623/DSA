import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Hashtable<Integer,Integer> result = new Hashtable<>();
        
        for(int i=0;i<nums.length;i++){
            if(result.containsKey(nums[i])){
                result.put(nums[i],result.get(nums[i]) + 1);
            }
            else{
                result.put(nums[i],1);
            }
        }
        int n = nums.length;
        ArrayList<Integer> resultArr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : result.entrySet()){
            if(entry.getValue() > n/3){
                resultArr.add(entry.getKey());
            }
        }
        return resultArr;
    }
}