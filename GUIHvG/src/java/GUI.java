import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel gameInstruct;
    private static JLabel gameFeed;


    public static void main (String [] args){

        frame = new JFrame(); // creates a new frame object
        panel = new JPanel(); // creates a new panel object

        frame.setSize(450, 500); // sets the size of the frame to 100 by 100
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the default close operation of the frame

        frame.add(panel); // adds the panel to the frame

        panel.setLayout(null);  // sets the layout of the panel to null

        gameInstruct = new JLabel("Type n,s,e,w"); // creates a new label object
        gameInstruct.setBounds(10, 400, 80, 25); // sets the bounds of the label
        panel.add(gameInstruct); // adds the label to the panel

        userText = new JTextField(20); // creates a new text field object with a width of 20
        userText.setBounds(110, 400, 100, 25); // sets the bounds of the text field
        panel.add(userText); // adds the text field to the panel

        button = new JButton("Enter"); // creates a new button object
        button.setBounds(110, 430, 100, 25); // sets the bounds of the button
        button.addActionListener(new GUI()); // adds an action listener to the button
        panel.add(button); // adds the button to the panel

        gameFeed = new JLabel("Game Feed"); // creates a new label object
        gameFeed.setBounds(130, -10, 300, 250); // sets the bounds of the label
        panel.add(gameFeed); // adds the label to the panel


        frame.setVisible(true); // makes the frame visible
    }

    public void actionPerformed(ActionEvent e) {

        String user = userText.getText(); // gets the text from the user text field

        if(user.equals("Alex"))  { // checks if the user and password are correct
            gameInstruct.setText("Login Successful"); // sets the text of the success label to "Login Successful"
        } else {
            gameInstruct.setText("Login Failed"); // sets the text of the success label to "Login Failed"
        }

    }
}
