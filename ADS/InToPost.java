public class InToPost {

    public static void main(String[] args) {
        String infix = "A+B*C^D-E";
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Expression: " + postfix);
    }

    public static String infixToPostfix(String infix) {
        char[] stack = new char[infix.length()];
        int tos = -1;
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < stack.length; i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (tos != -1 && precedance(stack[tos]) > precedance(ch)) {
                    postfix.append(stack[tos--]);
                }
                stack[++tos] = ch;
            }
        }

        while (tos != -1) {
            postfix.append(stack[tos--]);
        }

        return postfix.toString();
    }

    static int precedance(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}