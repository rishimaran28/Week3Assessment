public class MaximumSubarrayFinder {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide to extend the current subarray or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubarrayFinder finder = new MaximumSubarrayFinder();

        // Sample 1: Mixed numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(finder.maxSubArray(nums1));
        // Output: 6

        // Sample 2: All negative numbers
        int[] nums2 = {-3, -1, -2};
        System.out.println(finder.maxSubArray(nums2));
        // Output: -1
    }
}