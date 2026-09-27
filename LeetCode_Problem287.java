class LP287 {
    static int findDuplicate(int[] nums) {
       
            int i = 0;
            while(i<nums.length){
            if(nums[i] != i+1){
                int correctIdx = nums[i] - 1;
                if(nums[i] != nums[correctIdx]){
                    int temp = nums[i];
                    nums[i] = nums[correctIdx];
                    nums[correctIdx] = temp;
                }else{
                    return nums[i];
                }
            }
        
        else{
                i++;
        } 
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = {1,3,6,3,5,2,4};
        System.out.println(findDuplicate(nums));
    }
}