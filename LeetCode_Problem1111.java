import java.util.Arrays;
class LP1111 {
    static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                ans[i] = depth % 2;
            } else {
                ans[i] = depth % 2;
                depth--;
            }
        }

        return ans;
    }
    public static void main(String args[]){
        String seq =  "()(())()";
        int[] ans = maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(ans));
    }
}