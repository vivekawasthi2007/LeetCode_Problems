class LP1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
        
    }
    static boolean even(int num){
       int digitOfNumber = digits(num);
       if(digitOfNumber%2 ==0){
         return true;
       }else{
        return false;
       }
    }
    static int digits(int num){
        int count = 0;
        while(num>0){
            count++;
            num = num/10;
        }
        return count;
    }
    public static void main(String args[]){
        LP1295 obj1 = new LP1295();
        int[] nums = {12,3,5,56,7,234563,567,6787};
        int ans = obj1.findNumbers(nums);
        System.out.println(ans);
    }
}