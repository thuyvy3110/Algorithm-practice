//https://leetcode.com/problems/first-missing-positive/

//Runtime: 1 ms, faster than 43.11% of Java online submissions for First Missing Positive.
//Memory Usage: 36.8 MB, less than 60.96% of Java online submissions for First Missing Positive.

class Solution {

    public int firstMissingPositive(int[] nums) {
        int max = 0;

        for (int i = 0 ; i < nums.length;i++) {
            for (int j = i+1 ; j< nums.length;j++) {
                if(nums[i] > nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i=0; i< nums.length;i++) {
            if (max < nums[i]) {
                if (max+1 < nums[i])
                    return max + 1;
                max = nums[i];
            }
        }

        return max+1;
    }
}
