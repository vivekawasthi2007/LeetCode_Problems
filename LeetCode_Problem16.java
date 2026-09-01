import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0;i<nums.length - 2;i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }
                else if(Math.abs(sum - target)< Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }     

        


        }
      return closestSum;  
    }
    public static void main(String args[]){
        Solution obj1 = new Solution();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int ans = obj1.threeSumClosest( nums, target);
        System.out.println(ans);
    }
}