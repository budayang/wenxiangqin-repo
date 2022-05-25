package bytedance;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2,7,5,7,8,8};
        int[] add = add(nums, 9);
        System.out.println(add);
    }

    public static int[] add(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = i;
                index[1] = map.get(nums[i]);
                return index;
            }
            map.put(target - nums[i], i);
        }
        return index;
    }
}
