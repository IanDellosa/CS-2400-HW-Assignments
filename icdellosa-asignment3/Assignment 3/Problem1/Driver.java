package Problem1;

public class Driver {

  public static void main(String[] args) {
    // You may change this expression to test but the following is what I will use
    // to test against your code
    String infix = "(7-2)*2+(6*5^2+3)";
    System.out.println("Infix: " + infix);

    String postfix = convertInfixToPostfix(infix);
    System.out.println("Postfix: " + postfix);

    int result = evaluatePostfix(postfix);
    System.out.println("Evaluation: " + result);

  }

  public static String convertInfixToPostfix(String infix) {
    MyStack<Character> opStack = new MyStack<>();
    String post = "";
    char curr;
    for (int i = 0; i < infix.length(); i++) {
      curr = infix.charAt(i);
      if (Character.isDigit(curr)) {
        post = post + curr;
      } else if (curr == '^') {
        opStack.push(curr);
      } else if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {
        while(!opStack.isEmpty() && (evalPrecedence(curr) <= evalPrecedence(opStack.peek()))) {
          post += opStack.pop();
        }
        opStack.push(curr);
      } else if (curr == '(') {
        opStack.push(curr);
      } else if (curr == ')'){
        while (opStack.peek() != '(') {
          post += opStack.pop();
        }
        opStack.pop();
      } else {
        break;
      }
    }
    while (!opStack.isEmpty()) {
      post += opStack.pop();
    }

    return post;
  }

  public static int evaluatePostfix(String postfix) {
    MyStack<Integer> valueStack = new MyStack<>();
    char curr;
    for (int i = 0; i < postfix.length(); i++) {
      curr = postfix.charAt(i);
      if(Character.isDigit(curr)) {
        valueStack.push(Character.getNumericValue(curr));
      } else if (curr == '+') {
        valueStack.push(valueStack.pop() + valueStack.pop());
      } else if (curr == '-') {
        int temp = valueStack.pop();
        valueStack.push(valueStack.pop() - temp);
      } else if (curr == '*') {
        valueStack.push(valueStack.pop() * valueStack.pop());
      } else if (curr == '/') {
        valueStack.push(valueStack.pop() / valueStack.pop());
      } else if (curr == '^') {
        int exponent = valueStack.pop();
        int base = valueStack.pop();
        int result = base;
        for (int j = 1; j < exponent; ++j) {
          result *= base;
        }
        valueStack.push(result);
      } else {
        break;
      }
    }
    return valueStack.pop();
  }

  public static int evalPrecedence(char op) {
    switch (op) {
      case '+': case'-':
        return 1;
      case '*': case '/':
        return 2;
      case '^':
        return 3;
      default:
        return 0;
    }
  }
}
