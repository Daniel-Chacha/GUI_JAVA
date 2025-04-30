import  java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import  javax.swing.JTextField;


public  class MathOperations extends  JFrame implements ActionListener{
    private JLabel lblVal1, lblVal2, lblResult ;
    private JTextField txtVal1, txtVal2, txtResult;
    private JButton btnExecute;
    private JRadioButton rbtAdd, rbtSubtract, rbtProduct;
    private ButtonGroup operationGroup;
    private JComboBox sportsComboBox;

    private String[] sports= {"Soccer", "BasketBall", "NetBall", "HandBall"};

    public MathOperations(){
        super();

        lblVal1 = new JLabel("Value 1");
        lblVal2 = new JLabel("Value 2");
        lblResult = new JLabel("Result");
        txtVal1 = new JTextField(20);
        txtVal2 = new JTextField(20);
        txtResult = new JTextField(20);
        rbtAdd = new JRadioButton("Sum");
        rbtSubtract = new JRadioButton("Subtract");
        rbtProduct = new JRadioButton("Product");
        // btnExecute = new JButton("Execute");
        operationGroup = new ButtonGroup();
        sportsComboBox = new JComboBox(sports);

        operationGroup.add(rbtAdd);     operationGroup.add(rbtSubtract);       operationGroup.add(rbtProduct);
        txtResult.setEditable(false);
        rbtAdd.addActionListener(this);
        rbtSubtract.addActionListener(this);
        rbtProduct.addActionListener( this);

        add(lblVal1); add(txtVal1);
        add(lblVal2);   add(txtVal2);
        add(lblResult);     add(txtResult);
        add(rbtAdd);        add(rbtSubtract);       add(rbtProduct);
        // add(btnExecute);
        add(sportsComboBox);


        setVisible(true);   setSize(275,200);  setTitle("Simple Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e){
        int value1 = Integer.parseInt(txtVal1.getText());
        int value2 = Integer.parseInt(txtVal2.getText());
        int result;

        if (e.getActionCommand().equals("Sum")){
            result = value1 + value2;
            txtResult.setText(Integer.toString(result));
        }else if(e.getSource() == rbtSubtract){
            result = value1 - value2;
            txtResult.setText(Integer.toString(result));
        }else if(e.getSource() == rbtProduct){
            result = value1 * value2;
            txtResult.setText(Integer.toString(result));    
        }
    }

    public static void main(String[] args){
        new MathOperations();
    }
}