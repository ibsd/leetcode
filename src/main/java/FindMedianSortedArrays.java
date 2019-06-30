public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = mergeSort(nums1, nums2);
        if (result.length % 2 == 1) {
            return result[result.length / 2];
        } else {
            return (double)(result[result.length / 2] + result[result.length / 2 - 1]) / 2;
        }
    }

    public int[] mergeSort(int[] nums1, int[] nums2) {
        // define vars
        int length = nums1.length + nums2.length;
        int[] result = new int[length];
        int index1 = 0;
        int index2 = 0;
        int indexResult = 0;

        // define loop cond
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                result[indexResult++] = nums1[index1++];
            } else {
                result[indexResult++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) {
            result[indexResult++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            result[indexResult++] = nums2[index2++];
        }
        return result;
    }
}
