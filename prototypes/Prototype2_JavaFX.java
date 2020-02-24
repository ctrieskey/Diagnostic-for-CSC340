import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.*;

public class Prototype2_JavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Another prototype");

        ComboBox comboBox = new ComboBox();
        comboBox.setEditable(true);

        comboBox.getItems().add("2 + 2");
        comboBox.getItems().add("8 * 15");
        comboBox.getItems().add("74566 / 36");

        Button evaluate = new Button("Evaluate expression");

        evaluate.setOnAction(value -> {

            String expression = (String) comboBox.getValue();
            int val = evaluateExpression(expression);
            Stage answerScreen = new Stage();
            Label label = new Label(Integer.toString(val));
            Scene answer = new Scene(label, 200, 100);
            
            answerScreen.setScene(answer);
            answerScreen.show();
        });

        HBox hbox = new HBox(comboBox, evaluate);

        Scene scene = new Scene(hbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    public static int evaluateExpression(String expression) {

        Stack<Integer> operandStack = new Stack<>();

        Stack<Character> operatorStack = new Stack<>();

        expression = insertBlanks(expression);

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {

                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '+'
                        || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*'
                        || operatorStack.peek() == '/'
                        || operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {

                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '*'
                        || operatorStack.peek() == '/'
                        || operatorStack.peek() == '%')) {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '^') {

                while (!operatorStack.isEmpty()
                        && operatorStack.peek() == '^') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {

                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.pop();
            } else {

                operandStack.push(new Integer(token));
            }
        }

        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+') {
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            operandStack.push(op2 - op1);
        } else if (op == '*') {
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            operandStack.push(op2 / op1);
        } else if (op == '^') {
            operandStack.push((int) Math.pow(op2, op1));
        } else if (op == '%') {
            operandStack.push(op2 % op1);
        }
    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }
}