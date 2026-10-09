public class RotatedArrayMinFinder {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element,
            // the minimum must be in the right unsorted half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Otherwise, the minimum is either mid itself or in the left half
            else {
                right = mid;
            }
        }

        // When left == right, it points to the smallest element
        return nums[left];
    }

    public static void main(String[] args) {
        RotatedArrayMinFinder finder = new RotatedArrayMinFinder();

        // Sample 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(finder.findMin(nums1));
        // Output: 1

        // Sample 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(finder.findMin(nums2));
        // Output: 0

        // Sample 3: No rotation occurred
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(finder.findMin(nums3));
        // Output: 11
    }
}