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
}