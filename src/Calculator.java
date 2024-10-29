import java.awt.*;
import java.awt.event.*;
import java.io.*;
// swing imports
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Trebuchet MS", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;



    Calculator(){
        // when creating the calculator, everything in here happens
        frame = new JFrame("Calculator"); // inside parenthesis is the title of the app
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 100, 50);
        negButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(255, 430, 100, 50);

        //try to figure out how to round corners or something
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(new java.awt.Color(144, 222, 221)); // maybe change


        //adds all of the buttons necessary, puts them all in the center panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);



        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i ++){
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        // parseDouble accepts a string and returns a double value, if it is one that is
        if(e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }   

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if(e.getSource() == eqButton){
            num2=Double.parseDouble(textfield.getText());
            switch(operator) {
                case'+':
                    result = num1+num2;
                    break;
                case'-':
                    result = num1-num2;
                    break;           
                case'*':
                    result = num1*num2;
                    break;    
                case'/':
                    result = num1/num2;
                    break;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        //clears but doesnt actually remove it from memory
        if(e.getSource() == clrButton) {
            num1 = 0;
            textfield.setText("");
        }

        //
        if(e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < string.length()-1; i++){
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*= -1;
            textfield.setText(String.valueOf(temp));
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
