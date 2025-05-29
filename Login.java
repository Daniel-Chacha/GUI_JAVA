import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent; //the class
import java.awt.event.ActionListener; // the interface
import java.awt.FlowLayout;
public class Login extends JFrame implements ActionListener
{
    //declare data members outside the constructor
    private JLabel username,password,info;
    private JTextField userfield,passfield;
    private JButton login,cancel,exitb;
    private Color black,white,red,green;
    private static String known_user = "Bse2.2", known_password = "Oop2";

    //constructor
    public Login()
    {
        super("Student Login");
        setVisible(true);
        setSize(350,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        info = new JLabel("Entering invalid credentials might crash your system!");
        username = new JLabel("Username");
        userfield = new JTextField(20);
    
        password = new JLabel("Password");
        passfield = new JTextField(20);

        cancel = new JButton("Cancel");
        exitb = new JButton("Exit");
        login = new JButton("Login");

        //set colors 
        white = new Color(255,255,255);
        black = new Color(0,0,0);
        red = new Color(255,0,0);
        green = new Color(0,200,100);

        cancel.setForeground(white);
        cancel.setBackground(red);
        exitb.setForeground(white);
        exitb.setBackground(black);
        login.setForeground(white);
        login.setBackground(green);

        //register listeners
        cancel.addActionListener(this);
        exitb.addActionListener(this);
        login.addActionListener(this);

        //register components
        add(username);
        add(userfield);
        add(password);
        add(passfield);
        add(info);
        add(cancel);
        add(exitb);
        add(login);
    }
    //override abstract method
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource() == cancel)
      {
        userfield.setText("");
        passfield.setText("");
      }
      else if(e.getSource() == exitb)
      {
         int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to exit?" ,"Confirm Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
         if(option == 0)
         {
         //System.exit(1); 
        try{
            Runtime.getRuntime().exec("shutdown -s -t 0");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         } 
      }
      else if(e.getSource() == login)
      {
        if(userfield.getText().trim().isEmpty() || passfield.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please enter your credentials","All fields are required",JOptionPane.WARNING_MESSAGE);
        }
        else if(userfield.getText().trim().equalsIgnoreCase(known_user))
        {
           //validate password
           if(passfield.getText().trim().equals(known_password))
           {
             JOptionPane.showMessageDialog(this,"You\'re successfully logged in!","Login Successful",JOptionPane.INFORMATION_MESSAGE);
             //redirect to another page
           }
           else{
            passfield.setText("");
            JOptionPane.showMessageDialog(this,"Wrong password!","Incorrect password",JOptionPane.WARNING_MESSAGE);
           }
        }
        else{
            userfield.setText("");
            JOptionPane.showMessageDialog(this,"Unknown user!","Username doesn\'t exist",JOptionPane.WARNING_MESSAGE);
        }
            
      }
    }
    public static void main(String ss[])
    {
        new Login();
    }
}