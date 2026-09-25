public class Main {

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {

            int digit1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {

                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : result) {

            if (sb.length() == 0 && num == 0) {
                continue;
            }

            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        String answer = multiply(num1, num2);

        System.out.println("Answer = " + answer);
    }
}
