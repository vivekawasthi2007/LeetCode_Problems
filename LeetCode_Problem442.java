import java.util.*;
class LP442 {
    static  List<Integer> findDuplicates(int[] nums) {
       int i = 0;
        while(i<nums.length){
            
           
            int correctIdx = nums[i] - 1;
            if(nums[i] != nums[correctIdx]){
                 int temp = nums[i];
                 nums[i] = nums[correctIdx];
                 nums[correctIdx] = temp;
                }
                
              
               else{
                   i++;
                } 
        }
        List<Integer> ans = new ArrayList<>();
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index+1){
                ans.add(nums[index]);
            }

        }

        return ans;
    }  
public static void main(String args[]){
  int[] nums = {4,3,2,7,8,2,3,1};
  System.out.println(findDuplicates(nums));

}   
    
}