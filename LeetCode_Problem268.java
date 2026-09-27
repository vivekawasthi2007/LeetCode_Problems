class LP268{
    static int missingNumber(int[] nums){
        int i = 0;
        while(i<nums.length){
            int correctIdx = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIdx]){
               swap(nums,i,correctIdx);
            }else{
                i++;
            }
        }
        //find missing index
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index){
                return index;
            }
        }
        return nums.length;
    }
    static void swap(int[] nums,int i,int correctIdx){
         int temp = nums[i];
         nums[i] = nums[correctIdx];
        nums[correctIdx] = temp;
    }
    public static void main(String args[]){
        int[] nums = {3,0,1};
        
        System.out.println(missingNumber(nums));
    }
}