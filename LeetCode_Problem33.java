class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left +(right-left)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[left]<= nums[mid]){
                if(nums[left]<= target && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
             if(nums[mid]< target && target<=nums[right]){
                left = mid+1;
             }else{
                right = mid-1;
             }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution obj1 = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int ans = obj1.search(nums,target);
        System.out.println(ans);
    }
}