import java.util.HashMap;

class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {

            // case: {3, 3} 6
            if (map.containsKey(num)) {
                if (target - num == num) {
                    return new int[]{map.get(num), index};
                } else {
                    index++;
                }
            } else {
                map.put(num, index++);
                int another = target - num;

                // case: {3, 2, 4} 6
                if (another == num) {
                    continue;
                }

                // case: normal
                if (map.containsKey(another)) {
                    return new int[]{map.get(another), map.get(num)};
                }
            }
        }
        return null;
    }
}