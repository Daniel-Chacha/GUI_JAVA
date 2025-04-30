//Adding event listeners

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{
    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField pwfPassword;
    private JButton btnLogin, btnClear, btnExit;

    public LoginForm(){
        super();

        lblUsername = new JLabel("UserName");
        lblPassword = new JLabel("Password");
        txtUsername = new JTextField(20);
        pwfPassword = new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");
        btnExit =  new JButton("Exit");

        add(lblUsername);   add(txtUsername);   
        add(lblPassword);   add(pwfPassword);
        add(btnLogin);      add(btnClear);  add(btnExit);

        setVisible(true); setSize(300, 200);  setTitle("LOGIN FORM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnExit.addActionListener(this);        //By implementing the Interface
        btnClear.addActionListener(new Clear());  //Using a named class

        //using an anonymous class to add an event listener
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = txtUsername.getText();
                String password = pwfPassword.getText();

                if ( username.equalsIgnoreCase("daniel") && password.equals("1234")){
                    setVisible(false);
                    int x =JOptionPane.showConfirmDialog(null, "Successfully Logged In");
                    // mathOp= new MathOperations();
                    System.exit(0);
                    
                }else{
                    int y =JOptionPane.showConfirmDialog(null, "Wrong Username or Password");
                };
            }
        });

    }

     //Using a named class
    private class Clear implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            txtUsername.setText("");
            pwfPassword.setText("");
        }
    }    

    public static void main(String[] args) {
        new LoginForm();
    }

    public void actionPerformed(ActionEvent e){
        int x = JOptionPane.showConfirmDialog(null, "Confirm Exit!");
        if (x == 0){
            System.exit(0);
        }

    }
}