class LP1672 {
    public int maximumWealth(int[][] accounts) {
        int ans  = Integer.MIN_VALUE;
        for(int i = 0; i<accounts.length;i++){
            int sum = 0;
            for(int j = 0; j<accounts[i].length;j++){
               sum += accounts[i][j];
               
            }
            if(sum>ans){
                 ans = sum;
               }
            
        }
        return ans;
    }
    public static void main(String args[]){
        LP1672 obj = new LP1672();
        int[][] accounts = {{1,3,6},{2,3,6,},{1,2,3,4}};
        int answer = obj.maximumWealth(accounts);
        System.out.println(answer);
    }
}