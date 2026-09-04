class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }


    
    public int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                answer = mid;

               
                right = mid - 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }


   
    public int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                answer = mid;

              
                left = mid + 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }
    public static void main(String args[]){
        Solution obj1 = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int first = obj1.findFirst(nums,target);
        int last = obj1.findLast(nums,target);
        int[] res = {first,last};
        System.out.println(java.util.Arrays.toString(res));
    }
}