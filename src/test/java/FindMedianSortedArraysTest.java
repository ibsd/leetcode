import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianSortedArraysTest {
    private FindMedianSortedArrays solution;

    @BeforeEach
    void setUp() {
        this.solution = new FindMedianSortedArrays();
    }

    @Test
    void should_merge_sort_two_sorted_arrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int[] expected = {1, 2, 3, 4};
        int[] actual = this.solution.mergeSort(nums1, nums2, nums1.length + nums2.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void should_merge_sort_two_sorted_arrays2() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        int[] expected = {1, 2, 3};
        int[] actual = this.solution.mergeSort(nums1, nums2, nums1.length + nums2.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void should_find_median_two_sorted_arrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double actual = this.solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    void should_find_median_two_sorted_arrays2() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2;
        double actual = this.solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    void should_find_median_two_sorted_arrays_one_empty_and_another_one() {
        int[] nums1 = new int[0];
        int[] nums2 = {1};
        double expected = 1;
        double actual = this.solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    void should_find_median_two_sorted_arrays_one_empty_and_another_two() {
        int[] nums1 = new int[0];
        int[] nums2 = {2, 3};
        double expected = 2.5;
        double actual = this.solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }
}