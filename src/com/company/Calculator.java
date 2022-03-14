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
        textField.setBounds(50, 25, 300, 50);
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
        clearButton = new JButton("clr");

        //defining array of function buttons
        functionButtons[0] = additionButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = deleteButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = multiplicationButton;
        functionButtons[7] = clearButton;


        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
