/**
 * Ethan Gordon
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainClass {
    private static JTextField textNum, textBase, textOutBase, textOut;
    private static JLabel labelNum, labelBase, labelOutBase, labelOut;
    private static JTextArea preamble;
    private static String inNum, outNum;
    private static int inBase, outBase;
    //prints output in the output textfield
    public static void giveOutput() {
        if(!textNum.equals("-") && !textBase.equals("-") && !textOutBase.equals("-")) {
            outNum = decToBase( baseToDec(inNum, inBase), outBase);
            textOut.setText(outNum);
        }
    }
    //updates input textfield to match what has previously been entered
    public static void updateTextFields() {
        textNum.setText(inNum);
        textBase.setText(String.valueOf(inBase));
        textOutBase.setText(String.valueOf(outBase));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyPanel panel = new MyPanel();
        
        preamble = new JTextArea("Hey, This is my app thing. If it's not updating press ENTER. base must be between 2 and 36 inclusive.",
            2, 20);
        preamble.setLineWrap(true);
        preamble.setWrapStyleWord(true);
        panel.add(preamble);
        
        labelNum = new JLabel("Enter a number");
        panel.add(labelNum);
        textNum = new JTextField(11);
        textNum.setFont(textNum.getFont().deriveFont(20f));
        panel.add(textNum);
        textNum.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) { // When clicked on
                try {
                    inNum = textNum.getText();
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
            
            @Override
            public void focusLost(FocusEvent fe) { // When user clicks on something else
                focusGained(fe);
            }
        });
        textNum.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) { // When user presses [ENTER]
                try {
                    inNum = textNum.getText();
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
        });
        
        
        labelBase = new JLabel("Enter it's base");
        panel.add(labelBase);
        textBase = new JTextField(12);
        textBase.setFont(textBase.getFont().deriveFont(20f));
        panel.add(textBase);
        textBase.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                try {
                    inBase = Integer.parseInt(textBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                focusGained(fe);
            }
        });
        textBase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    inBase = Integer.parseInt(textBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
        });
        
        labelOutBase = new JLabel("Enter the output base");
        panel.add(labelOutBase);
        textOutBase = new JTextField(9);
        textOutBase.setFont(textBase.getFont().deriveFont(20f));
        panel.add(textOutBase);
        textOutBase.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                try {
                    outBase = Integer.parseInt(textOutBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                focusGained(fe);
            }
        });
        textOutBase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    outBase = Integer.parseInt(textOutBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
        });
        
        labelOut = new JLabel("OUT");
        panel.add(labelOut);
        textOut = new JTextField("-", 20);
        textOut.setFont(textBase.getFont().deriveFont(17f));
        panel.add(textOut);
        
        frame.add(panel);
        frame.setSize(310, 300);
        frame.setResizable(false);
        frame.setTitle("Base Converter by Ethan Gordon");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.requestFocus();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
        
    }
    
    /*
     * PRECONDITION: base must be between 2 and 36 (inclusive)
     * @param n - input number
     * @param base - input base
     * @return a number string in decimal
     */
    public static int baseToDec(String n, int base) {
        char c = n.charAt(0);
        int digit = 0;
        if(c == '0')      digit = 0;
        else if(c == '1') digit = 1;
        else if(c == '2') digit = 2;
        else if(c == '3') digit = 3;
        else if(c == '4') digit = 4;
        else if(c == '5') digit = 5;
        else if(c == '6') digit = 6;
        else if(c == '7') digit = 7;
        else if(c == '8') digit = 8;
        else if(c == '9') digit = 9;
        else if(c == 'A') digit = 10;
        else if(c == 'B') digit = 11;
        else if(c == 'C') digit = 12;
        else if(c == 'D') digit = 13;
        else if(c == 'E') digit = 14;
        else if(c == 'F') digit = 15;
        else if(c == 'G') digit = 16;
        else if(c == 'H') digit = 17;
        else if(c == 'I') digit = 18;
        else if(c == 'J') digit = 19;
        else if(c == 'K') digit = 20;
        else if(c == 'L') digit = 21;
        else if(c == 'M') digit = 22;
        else if(c == 'N') digit = 23;
        else if(c == 'O') digit = 24;
        else if(c == 'P') digit = 25;
        else if(c == 'Q') digit = 26;
        else if(c == 'R') digit = 27;
        else if(c == 'S') digit = 28;
        else if(c == 'T') digit = 29;
        else if(c == 'U') digit = 30;
        else if(c == 'V') digit = 31;
        else if(c == 'W') digit = 32;
        else if(c == 'X') digit = 33;
        else if(c == 'Y') digit = 34;
        else if(c == 'Z') digit = 35;
        if(n.length() == 1) return digit;
        return (digit * (int)Math.pow(base, n.length()-1)) + baseToDec(n.substring(1), base);
    }
    /*
     * PRECONDITION: base must be between 2 and 36 (inclusive)
     * @param n - input number
     * @param base - output base
     * @return a number string in the base provided
     */
    public static String decToBase(long n, int base) {
        int digit = (int)(n % base);
        char c = '!';
        if(digit == 0) c = '0';
        else if(digit == 1) c = '1';
        else if(digit == 2) c = '2';
        else if(digit == 3) c = '3';
        else if(digit == 4) c = '4';
        else if(digit == 5) c = '5';
        else if(digit == 6) c = '6';
        else if(digit == 7) c = '7';
        else if(digit == 8) c = '8';
        else if(digit == 9) c = '9';
        else if(digit == 10) c = 'A';
        else if(digit == 11) c = 'B';
        else if(digit == 12) c = 'C';
        else if(digit == 13) c = 'D';
        else if(digit == 14) c = 'E';
        else if(digit == 15) c = 'F';
        else if(digit == 16) c = 'G';
        else if(digit == 17) c = 'H';
        else if(digit == 18) c = 'I';
        else if(digit == 19) c = 'J';
        else if(digit == 20) c = 'K';
        else if(digit == 21) c = 'L';
        else if(digit == 22) c = 'M';
        else if(digit == 23) c = 'N';
        else if(digit == 24) c = 'O';
        else if(digit == 25) c = 'P';
        else if(digit == 26) c = 'Q';
        else if(digit == 27) c = 'R';
        else if(digit == 28) c = 'S';
        else if(digit == 29) c = 'T';
        else if(digit == 30) c = 'U';
        else if(digit == 31) c = 'V';
        else if(digit == 32) c = 'W';
        else if(digit == 33) c = 'X';
        else if(digit == 34) c = 'Y';
        else if(digit == 35) c = 'Z';
        if(n < base) return "" + c;
        return "" + decToBase((int)(n/base), base) + c;
    }
}
