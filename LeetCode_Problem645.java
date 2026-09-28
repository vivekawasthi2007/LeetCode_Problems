import java.util.Arrays;
class LP645 {
    static int[] findErrorNums(int[] nums) {
     int i = 0;
        while(i<nums.length){
            int correctIdx = nums[i] - 1;
            if(nums[i] != nums[correctIdx]){
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }else{
                i++;
            }
        }
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index+1){
                return new int[]{nums[index],index+1};
            }
        }
    return new int[]{-1,-1};
    }   
   public static void main(String args[]){
    int[] nums = {3,2,2};
    int[] ans = findErrorNums(nums);
    System.out.println(Arrays.toString(ans));
   } 
}