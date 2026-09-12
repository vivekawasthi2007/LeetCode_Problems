class LP3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int maxLength = 0;
        for(int right = 0;right<s.length();right++){
            for(int i =left;i<right;i++){
                if(s.charAt(i) == s.charAt(right)){
                    left = i+1;
                    break;
                }
            }
            maxLength = Math.max(maxLength,right - left +1);
        }
        return maxLength;
    }
    public static void main(String args[]){
        String s = "abcabcbb";
        LP3 obj1 = new LP3();
        int ans = obj1.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}