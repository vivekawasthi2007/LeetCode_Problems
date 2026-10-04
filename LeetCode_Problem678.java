class LP678 {
    static boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for(int i = 0;i<s.length();i++){
            char ch  = s.charAt(i);
            if(ch == '('){
                minOpen++;
                maxOpen++;
            }else if(ch ==')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen<0){
                return false;
            }
            if(minOpen<0){
                minOpen = 0;
            }
        }
        return minOpen == 0;
    }
     public static void main(String args[]){
       String s = "(*)";
        System.out.println(checkValidString(s));
    }
}
