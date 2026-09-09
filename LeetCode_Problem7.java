class LP7 {
    public int reverse(int x) {
        int rev = 0;
        while(x!=0){
            int digit = x % 10;
            x = x/10;
            if(rev > Integer.MAX_VALUE/10 ||(rev ==Integer.MAX_VALUE/10 && digit >7)){
                return 0;
            }
            if(rev < Integer.MIN_VALUE/10 ||(rev ==Integer.MIN_VALUE/10 && digit <-8)){
                return 0;
            }
            rev = rev*10+digit;
        }
        return rev;
    }
    public static void main(String args[]){
        LP7 obj1 = new LP7();
        int x = 123;
        int ans = obj1.reverse(x);
        System.out.println(ans);
        
    }
}
