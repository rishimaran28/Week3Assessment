import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumFinder {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to enable two-pointer traversal and easy duplicate skipping
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Optimization: If the fixed element is positive, no three numbers can sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate outer elements to avoid identical triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            // Step 2: Two-pointer scan for the remaining two numbers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate elements for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward after processing a valid triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Increase sum by moving left pointer right
                } else {
                    right--; // Decrease sum by moving right pointer left
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumFinder finder = new ThreeSumFinder();

        // Sample 1: Standard input with positive and negative numbers
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(finder.threeSum(nums1));
        // Output: [[-1, -1, 2], [-1, 0, 1]]

        // Sample 2: Input with zeroes
        int[] nums2 = {0, 0, 0};
        System.out.println(finder.threeSum(nums2));
        // Output: [[0, 0, 0]]
    }
}