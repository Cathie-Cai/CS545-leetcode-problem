// medium
// ref: https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class LC532_sorting {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (k == 0) {
                if (set.contains(k + nums[i]) || set.contains(nums[i] - k)) {
                    ans++;
                }
            } else {
                if (set.contains(k + nums[i])) {
                    ans++;
                }
                if (set.contains(nums[i] - k)) {
                    ans++;
                }
            }

            set.add(nums[i]);
        }
        return ans;
    }
}
