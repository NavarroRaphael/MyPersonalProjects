
//Navarro Sean Ray Raphael N.
//CITCS 1N-A
//CC2
import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;
public class LyricaPrototype {
    public static void main (String[]args){
        JOptionPane.showMessageDialog(null, "Are you new user?", "Welcome user", JOptionPane.YES_NO_CANCEL_OPTION);
        
        String name = JOptionPane.showInputDialog(null, "What is your name stranger?");
        String birthyear = JOptionPane.showInputDialog(null,"When were you born?");
        int Byear = Integer.parseInt(birthyear);
        int currentYear = 2025;
        int age = currentYear - Byear;

        JOptionPane.showMessageDialog(null, "Hello" + name);
        JOptionPane.showMessageDialog(null, "I am the Godess");
        JOptionPane.showMessageDialog(null,"If I rember correctly" );
        JOptionPane.showMessageDialog(null,"You're" + age + "Years old Right?");
        JOptionPane.showMessageDialog(null,"Very well let us Begin " );

        String[] characters = {"Alestiel","Zeraquiel","Sasquiel","Zadikiel","Nilim","Omiel"};
        int choice = JOptionPane.showOptionDialog(null, "Please select character", "Character selection", JOptionPane.DEFAULT_OPTION, 
        JOptionPane.PLAIN_MESSAGE, null, characters, characters [0]);
        JOptionPane.showMessageDialog(null,"You choose:" + characters[choice], "My choice", JOptionPane.INFORMATION_MESSAGE); 

        String[] clss = {"Pianist","Drummer","Bassist","Guitarist","Singer"};
        int lane = JOptionPane.showOptionDialog(null, "Please selsct class", "Class selection", JOptionPane.DEFAULT_OPTION, 
        JOptionPane.PLAIN_MESSAGE, null, clss, clss[0]);
        JOptionPane.showMessageDialog(null, "You selected:" + clss[lane], "class", JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, "Welcome to project Lyrica ");

        
    }
}
