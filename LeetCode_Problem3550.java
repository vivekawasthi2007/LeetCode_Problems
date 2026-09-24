class LP3550 {
    static int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++)
        {
            int num = nums[i];
            int digit = 0;
            while(num>0){
                digit += num%10;
                num = num/10;
            }
            if(digit == i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = {1,3,2};
        System.out.println(smallestIndex(nums));
    }
}