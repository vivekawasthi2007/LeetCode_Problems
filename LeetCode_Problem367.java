class LP367 {
    static boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        while(start<=end){
            int mid = start +(end-start)/2;
            long square = mid*mid;
            if(square == num){
                return true;
            }
            else if(square < num){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int num = 16;
        System.out.println( isPerfectSquare( num));
    }
}