class LP167 {
    static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;
        while(first<last){
            int sum = numbers[first]+numbers[last];
            if(target < sum){
                
                last--;
            
            }if(target == sum){
                return new int[]{first + 1 , last + 1};
            }else if(target>sum){
                first++;
            }

            
        }
     return new int[]{};
    }
      public static void main(String args[]){
      int[] numbers = {2,7,11,15};
      int target = 9;
      int[] ans = twoSum(numbers,target);
      System.out.println(java.util.Arrays.toString(ans));
    }
}