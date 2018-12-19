package jerry.wu.no1.twosum;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length ==0) {
            return null;
        }
        //容易忽略重复数得问题，重复数刚好等于和 比如 3 ＋ 3 ＝ 6
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        for (int i = 0; i< nums.length; i++) {
            int remain = target - nums[i];
            if (indices.containsKey(remain)) {
                return new int[] {indices.get(remain), i};
            }
            if (!indices.containsKey(nums[i])) {
                indices.put(nums[i], i);
            }
        }
        return null;
    }
    
}
