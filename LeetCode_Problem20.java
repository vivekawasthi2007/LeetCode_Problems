import java.util.Stack;
class LP20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray() ){
            if(ch == '(' || ch =='{' || ch =='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if(ch == ')' && top != '(' ||
                   ch == '}' && top != '{' ||
                   ch == ']' && top != '[' ){
                    return false;
                   }

            }

        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        LP20 obj = new LP20();
        String s = "(){}{[]}";
        boolean ans = obj.isValid(s);
        System.out.println(ans);
    }
}