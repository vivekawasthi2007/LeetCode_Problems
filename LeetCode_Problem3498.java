class LP3498 {
    static int reverseDegree(String s) {
       int sum = 0;
       for(int i=0;i<s.length();i++){
        int reverseValue = 26-(s.charAt(i) - 'a');
        int position = i+1;
        sum += reverseValue*position;

       } 
       return sum;
    }
    public static void main(String args[]){
        String s = "abc";
        System.out.println(reverseDegree(s));
    }
}