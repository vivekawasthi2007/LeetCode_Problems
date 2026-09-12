class LP12 {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<values.length;i++){
            while(num>=values[i]){
                sb.append(symbol[i]);
                num  = num - values[i];
            }
        }
        return sb.toString();

    }
    public static void main(String args[]){
        LP12 obj1 = new LP12();
        int num = 3343;
        String ans = obj1.intToRoman(num);
        System.out.println(ans);
    }
}