import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
public class SimpleGUI {
    public static void main(String[] args ){
        /* 
        String firstNumber = JOptionPane.showInputDialog(null,"Enter the first number","Input",JOptionPane.QUESTION_MESSAGE);
        String secondNumber = JOptionPane.showInputDialog(null,"Enter the first number","Input",JOptionPane.QUESTION_MESSAGE);        
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        int sum = num1+num2;
        JOptionPane.showMessageDialog(null, "The sum of "+num1 + "and" + num2+ "is"+sum, "result",JOptionPane.INFORMATION_MESSAGE);
        */

        JOptionPane.showMessageDialog(null, "Welcome to the multi-dialog app!","welcome to JOptionPane",JOptionPane.INFORMATION_MESSAGE);
        String name =  JOptionPane.showMessageDialog(null, "Please enter your name: ","Name Input",JOptionPane.QUESTION_MESSAGE);

        int confirm = JOptionPane.showMessageDialog(null,"Hello"+name + ",do you want to proceed?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirm == JOption.YES_NO_CANCEL_OPTION){
        String fNum= JOptionPane.showMessageDialog(null, "Enter first number","First number input",JOptionPane.QUESTION_MESSAGE);
        String sNum= JOptionPane.showMessageDialog(null, "Enter second number","First number input",JOptionPane.QUESTION_MESSAGE);
        int num1 = Integer.parseInt(fNum);
        int num2 = Integer.parseInt(sNum);
        int sum = num1+num2;
        JOptionPane.showMessageDialog(null,"the sum of "+num1 +"and"+num2 +"is"+sum,"result",JOptionPane.INFORMATION_MESSAGE);
        String [] options = {"burger","fries","ice cream"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Option selection",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, options [0]);
        JOptionPane.showMessageDialog(null, "You chose:"+options [choice],"your choice",JOptionPane.INFORMATION_MESSAGE);
       }
       else{
        JOptionPane.showMessageDialog(null, "Goodbye"+name +"! have a great day!","Exit message",JOptionPane.INFORMATION_MESSAGE);
       }
     }
}
