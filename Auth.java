import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;


public class Auth extends JFrame{
    private JLabel lblUsername, lblPassword;
    private JTextField txtUserName;
    private JPasswordField pwfPassword;
    private JButton btnSubmit;

    public Auth(){
        super("Authentication");
        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        txtUserName = new JTextField(20);
        pwfPassword = new JPasswordField(20);
        btnSubmit = new JButton("Submit");

        add(lblUsername);   add(txtUserName); add(lblPassword);
        add(pwfPassword);   add(btnSubmit);

        setVisible(true);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                            if ((txtUserName.getText()).equals("MMU") &&  (new String(pwfPassword.getPassword())).equals("Students")){
                int x = JOptionPane.showConfirmDialog(Auth.this,"Login Successful");

                if (x == 0){
                    System.exit(0);
                }
            }else{
                int y = JOptionPane.showConfirmDialog(Auth.this,"Login Credentials incorrect. Try Again");
                txtUserName.setText("");
                pwfPassword.setText("");
            }
            }
        });

    }

    public static void main(String[] S){
        new Auth();
    }
}
