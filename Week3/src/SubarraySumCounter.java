import java.util.HashMap;
import java.util.Map;

public class SubarraySumCounter {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;

        // Hash map to store frequency of prefix sums encountered so far
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Base Case: A prefix sum of 0 has occurred once (represents an empty prefix)
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            currentPrefixSum += num;

            // If (currentPrefixSum - k) exists in map, add its frequency to total count
            if (prefixSumFreq.containsKey(currentPrefixSum - k)) {
                count += prefixSumFreq.get(currentPrefixSum - k);
            }

            // Update frequency of currentPrefixSum in the map
            prefixSumFreq.put(currentPrefixSum, prefixSumFreq.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumCounter counter = new SubarraySumCounter();

        // Sample 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(counter.subarraySum(nums1, k1));
        // Output: 2

        // Sample 2 (Includes negative and zero elements)
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(counter.subarraySum(nums2, k2));
        // Output: 3
    }
}