class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int j = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
               nums[j] = nums[i];
               j++;
            }
        }
        return j;
    }
    public static void main(String args[]){
        Solution obj1 = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ans  = obj1.removeDuplicates(nums);
        System.out.println(ans);
    }
}