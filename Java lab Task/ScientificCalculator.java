import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;
    private boolean isNewInput = true;

    private double currentValue;
    private String currentOperator;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        inputField = new JTextField(20);
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(inputField, BorderLayout.NORTH);

        resultLabel = new JLabel("", SwingConstants.RIGHT);
        frame.add(resultLabel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 5));
        String[] buttonLabels = {
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "sin",
                "1", "2", "3", "-", "cos",
                "0", ".", "=", "+", "tan"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (isNewInput) {
                inputField.setText("");
                isNewInput = false;
            }

            if ("0123456789.".contains(command)) {
                inputField.setText(inputField.getText() + command);
            } else if ("+-*/".contains(command)) {
                if (!currentOperator.isEmpty()) {
                    performCalculation();
                }
                currentValue = Double.parseDouble(inputField.getText());
                currentOperator = command;
                isNewInput = true;
            } else if ("sqrt".equals(command)) {
                double value = Double.parseDouble(inputField.getText());
                inputField.setText(Double.toString(Math.sqrt(value)));
            } else if ("sin".equals(command)) {
                double value = Double.parseDouble(inputField.getText());
                inputField.setText(Double.toString(Math.sin(Math.toRadians(value))));
            } else if ("cos".equals(command)) {
                double value = Double.parseDouble(inputField.getText());
                inputField.setText(Double.toString(Math.cos(Math.toRadians(value))));
            } else if ("tan".equals(command)) {
                double value = Double.parseDouble(inputField.getText());
                inputField.setText(Double.toString(Math.tan(Math.toRadians(value))));
            } else if ("=".equals(command)) {
                performCalculation();
            }
        }
    }

    private void performCalculation() {
        double newValue = Double.parseDouble(inputField.getText());

        switch (currentOperator) {
            case "+":
                currentValue += newValue;
                break;
            case "-":
                currentValue -= newValue;
                break;
            case "*":
                currentValue *= newValue;
                break;
            case "/":
                if (newValue != 0) {
                    currentValue /= newValue;
                } else {
                    inputField.setText("Error");
                    return;
                }
                break;
        }

        resultLabel.setText("Result: " + Double.toString(currentValue));
        currentOperator = "";
        isNewInput = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}