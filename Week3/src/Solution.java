public class Solution {

    // Kadane's Algorithm: O(n) Time, O(1) Extra Space
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decision: Extend existing subarray sum or start fresh from current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the maximum sum found across all subarrays
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample 1: Standard case with mixed positive and negative numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(nums1)); // Output: 6

        // Sample 2: All negative values
        int[] nums2 = {-3, -1, -2};
        System.out.println(sol.maxSubArray(nums2)); // Output: -1
    }
}