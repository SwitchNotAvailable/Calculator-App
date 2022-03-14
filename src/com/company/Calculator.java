package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton subtractButton, additionButton, deleteButton, divisionButton, decimalButton, equalsButton, multiplicationButton, clearButton;
    JButton sineButton, cosineButton;
    JPanel panel;

    Font textFont = new Font(Font.DIALOG_INPUT, Font.BOLD|Font.ITALIC, 25);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    String operation;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 570);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(75, 15, 300, 43);
        textField.setFont(textFont);
        textField.setEditable(false); //Text in text box cannot be edited by the user, will have to use buttons.

        //Assigning function buttons
        additionButton = new JButton("+");
        subtractButton = new JButton("-");
        deleteButton = new JButton("del");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        multiplicationButton = new JButton("x");
        clearButton = new JButton("AC");
        sineButton = new JButton("sin");
        cosineButton = new JButton("cos");

        //defining array of function buttons
        functionButtons[0] = additionButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = deleteButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = multiplicationButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = sineButton;
        functionButtons[9] = cosineButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(textFont);
            functionButtons[i].setFocusable(false); //removing focused dotted lines
        }

        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(textFont);
            numberButton[i].setFocusable(false); //removing focused dotted lines
        }

        //putting the delete button and clear button in their own frame, away from fundamental functions
        cosineButton.setBounds(49, 470, 85, 50);
        sineButton.setBounds(140, 470, 85, 50);
        deleteButton.setBounds(229, 470, 85, 50);
        clearButton.setBounds(319, 470, 85, 50);

        panel = new JPanel();
        panel.setBounds(50, 75, 350, 370);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(additionButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subtractButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multiplicationButton);
        panel.add(decimalButton);
        panel.add(numberButton[0]);
        panel.add(equalsButton);
        panel.add(divisionButton);





        frame.add(panel);
        frame.add(sineButton);
        frame.add(cosineButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == additionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == divisionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == multiplicationButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        //conditions for the different functions
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;

            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            textField.setText("");//clearing the text field with empty quotes
        }
        if (e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == sineButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operation) {
                case "sin":
                    Math.sin(Math.toRadians(result));
                    break;
                case "cos":
                    Math.cos(Math.toRadians(result));
                    break;
            }
            textField.setText(String.valueOf(result));
            num2 = result;
        }

    }
}
