import java.util.*;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable<Integer, List<Integer>> track = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            track.putIfAbsent(nums[i], new ArrayList<>());
            track.get(nums[i]).add(i);
        }

        for (List<Integer> indices : track.values()) {
            for (int i = 1; i < indices.size(); i++) {
                if (indices.get(i) - indices.get(i - 1) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
