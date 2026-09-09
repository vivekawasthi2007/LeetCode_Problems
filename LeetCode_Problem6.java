class LP6 {
    public String convert(String s, int numRows) {
        if(numRows ==1 || numRows>=s.length()){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i<numRows;i++){
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = true;

        for(int i = 0;i<s.length();i++){
            rows[row].append(s.charAt(i));

            if(row == numRows - 1){
                down = false;
            }
            if(row ==0){
                down = true;
            }
            if(down){
                row++;
            }else{
                row--;
            }
        } 
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<numRows;i++){
            ans.append(rows[i]);
        }
        return ans.toString();
    }
    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        LP6 obj1 = new LP6();
        String ans = obj1.convert(s,numRows);
        System.out.println(ans);
    }
}