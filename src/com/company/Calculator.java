package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton subtractButton, additionButton, deleteButton, divisionButton, decimalButton, equalsButton, multiplicationButton, clearButton;
    JPanel panel;

    Font textFont = new Font(Font.DIALOG_INPUT, Font.BOLD|Font.ITALIC, 25);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 570);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(75, 15, 300, 39);
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

        //defining array of function buttons
        functionButtons[0] = additionButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = deleteButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = multiplicationButton;
        functionButtons[7] = clearButton;

        for (int i = 0; i < 8; i++) {
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
        deleteButton.setBounds(63, 470, 145, 50);
        clearButton.setBounds(220, 470, 145, 50);

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
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
