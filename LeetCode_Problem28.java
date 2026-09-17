class LP28 {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String args[]){
        LP28 obj = new LP28();
        String haystack = "sadbutsad";
        String needle = "sad";
        int ans = obj.strStr(haystack, needle);
        System.out.println(ans);

    }
}