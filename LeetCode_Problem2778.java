class LP2778 {
    static int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i<n;i++){
            if(n % (i+1) == 0){
              sum += nums[i]*nums[i];
            
        }
        }
        return sum;
    }
       public static void main(String args[]){
       
        int[] nums = {1,2,3,4};
        System.out.println(sumOfSquares(nums));
    }
}