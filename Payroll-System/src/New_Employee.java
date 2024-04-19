import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class New_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    
    New_Employee(){
        // Name the title of the page
        super("New Employee");
        
        setSize(600,650);
        setLocation(600,200);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1= new JPanel();
        p1.setBackground(Color.WHITE);
      
        //Set up the basic grid layout, elements will be add from left to right
        //top tp bottom
        p1.setLayout(new GridLayout(8,2,10,38));
        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);
       
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
       
        l2 = new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);
        l3 = new JLabel("Address");
        t3 = new JTextField(20);
        p1.add(l3);
        p1.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField(20);
        p1.add(l4);
        p1.add(t4); 
        l5 = new JLabel("City");
        t5 = new JTextField(20);
        p1.add(l5);
        p1.add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField(20);
        p1.add(l6);
        p1.add(t6);
        l7 = new JLabel("Phone");
        t7= new JTextField(20);
        p1.add(l7);
        p1.add(t7);
        b1 =new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);
       
        setLayout(new BorderLayout());
        ImageIcon EmployeeIcon = new ImageIcon(ClassLoader.getSystemResource("icon/new_employee.png"));
        
        Image resizedIcon = EmployeeIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        EmployeeIcon = new ImageIcon(resizedIcon);
        add(new JLabel(EmployeeIcon),"West");
        add(p1,"Center");
       
        // Decorte the button
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();
        
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        String num = "" + number;
        
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();
        // Add the input into SQL database
        String qry = "insert into employee values('"+num+"','"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";
        if(msg.equals("Submit")){
            try{
                // connect to database and execute the commend
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Employee Created");
                this.setVisible(false);  
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }else if (msg.equals("Cancel")){
            new project().setVisible(true); //show new page
            setVisible(false);
        }
    }
    public static void main(String s[]){
        new New_Employee().setVisible(true);
    }
}
