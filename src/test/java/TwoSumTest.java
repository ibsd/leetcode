import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    @Test
    public void normal() {
        int[] nums = {2, 7, 11};
        int target = 9;
        int[] expected = {0, 1};

        assertArrayEquals(expected, TwoSum.twoSum(nums, target));
    }

    @Test
    public void should_use_only_once() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};

        assertArrayEquals(expected, TwoSum.twoSum(nums, target));
    }

    @Test
    public void when_meet_more_than_once() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};

        assertArrayEquals(expected, TwoSum.twoSum(nums, target));
    }

    @Test
    public void when_duplicate_not_replace_origin_index() {
        int[] nums = {230, 863, 916, 585, 981, 404, 316, 785, 88, 12,
                70, 435, 384, 778, 887, 755, 740, 337, 86, 92,
                325, 422, 815, 650, 920, 125, 277, 336, 221, 847,
                168, 23, 677, 61, 400, 136, 874, 363, 394, 199,
                863, 997, 794, 587, 124, 321, 212, 957, 764, 173,
                314, 422, 927, 783, 930, 282, 306, 506, 44, 926,
                691, 568, 68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365, 430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789};
        int target = 542;
        int[] expected = {28, 45};

        assertArrayEquals(expected, TwoSum.twoSum(nums, target));
    }
}