class LP58 {
    static int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }
        int count = 0;
        while(i>=0 && s.charAt(i) != ' '){
           count++;
            i--;
        }
     return count;
    }
   public static void main(String args[]){
     String s = "Hello World";
     System.out.println(lengthOfLastWord(s));
   }
}