public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int top = (nums1.length + nums2.length) / 2 + 1;
        int[] result = mergeSort(nums1, nums2, top);
        if ((nums1.length + nums2.length) % 2 == 1) {
            return result[result.length - 1];
        } else {
            return (double) (result[result.length - 2] + result[result.length - 1]) / 2;
        }
    }

    public int[] mergeSort(int[] nums1, int[] nums2, int top) {
        // define vars
        int[] result = new int[top];
        int index1 = 0;
        int index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int indexResult = 0;

        // define loop cond
        while (index1 < length1 && index2 < length2) {
            if (indexResult >= top) {
                break;
            }
            if (nums1[index1] < nums2[index2]) {
                result[indexResult++] = nums1[index1++];
            } else {
                result[indexResult++] = nums2[index2++];
            }
        }
        while (index1 < length1) {
            if (indexResult >= top) {
                break;
            }
            result[indexResult++] = nums1[index1++];
        }
        while (index2 < length2) {
            if (indexResult >= top) {
                break;
            }
            result[indexResult++] = nums2[index2++];
        }
        return result;
    }
}
