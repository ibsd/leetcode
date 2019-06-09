import java.util.HashMap;

class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (target - num == num) {
                    return new int[]{map.get(num), index};
                }
            }
            map.put(num, index++);
        }
        for (int num : nums) {
            int another = target - num;
            if (another == num) {
                continue;
            }
            if (map.containsKey(another)) {
                return new int[]{map.get(num), map.get(another)};
            }
        }
        return null;
    }
}