package Stack.Opgave3;

import java.util.Stack;


public class Validator {

    private stack.StackI bracketStack;

    public Validator(stack.StackI bracketStack) {
        this.bracketStack = bracketStack;
    }

    public boolean validadateBrackets(){
String brackets = "({[()]}";
        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                bracketStack.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (bracketStack.isEmpty()) {
                    return false;
                }
                char top = (char) bracketStack.pop();
                if ((top == '(' && bracket != ')') || (top == '[' && bracket != ']') || (top == '{' && bracket != '}')) {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();

    }

}





