class LP9 {
    public boolean isPalindrome(int x) {
       if(x<0){
        return false;
       }
       int original = x;
       int rev = 0;
       while(x>0){
        int digit = x%10;
        rev = rev*10 + digit;
        x = x/10;

       }
      return original == rev;
    }
    public static void main(String args[]){
      LP9 obj1 = new LP9();
      int x = 1221;
      boolean ans = obj1.isPalindrome(x);
      System.out.println(ans);
    }
}
