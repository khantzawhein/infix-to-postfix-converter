public class InfixToPostfixConverter {
    private String infix;

    InfixToPostfixConverter(String infix) {
        this.infix = infix;
    }

    public String convert() throws InvalidInfixExpressionException {
        Stack<Character> stack = new Stack<Character>();
        String postfix = "";

        try {
            for (int i = 0; i < this.infix.length(); i++) {
                char symbol = this.infix.charAt(i);

                if (Character.isAlphabetic(symbol) || Character.isDigit(symbol)) {
                    postfix += symbol;
                } else if (symbol == '(') {
                    stack.push(symbol);
                } else if (symbol == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix += stack.pop();
                    }
                    // Pop the '(' from the stack
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && this.getPrecedence(symbol) <= this.getPrecedence(stack.peek())) {
                        postfix += stack.pop();
                    }
                    stack.push(symbol);
                }
            }
            while (!stack.isEmpty()) {
                postfix += stack.pop();
            }

        } catch (StackException exception) {
            throw new InvalidInfixExpressionException("Invalid Infix Expression");
        }

        return postfix;
    }

    private int getPrecedence(char symbol) {
        switch (symbol) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }

        return -1;
    }
}
