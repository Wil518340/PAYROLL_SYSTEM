import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JButton b1,b2;
    
    SignUp(){
        super("Sign Up Page");
        setLayout(new BorderLayout());

        tf1 = new JTextField(10);
        tf2 = new JPasswordField(10);
        tf3 = new JPasswordField(10);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));
        
        ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("icon\\Login_new.png"));
        ImageIcon CancelIcon = new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png"));
        // Get the image from the ImageIcon
        Image loginImage = loginIcon.getImage();
        Image CancelImage = CancelIcon.getImage();
        Image resizedLogin = loginImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image resizedCancel = CancelImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        // Create a new ImageIcon from the resized image
        loginIcon = new ImageIcon(resizedLogin);
        CancelIcon = new ImageIcon(resizedCancel);

        
        //name the buttone as 'Submit' with the second input as its image
        b1 = new JButton("Sign UP", loginIcon);
        b2 = new JButton("Cancel", CancelIcon);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel p1,p2,p3,p4;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();

        add(l,BorderLayout.WEST);

        //build the front end login page 
        p2.add(new JLabel("User Name  "));
        p2.add(tf1);
        p2.add(new JLabel("Password "));
        p2.add(tf2);
        p2.add(new JLabel("Confirm Password "));
        p2.add(tf3);
        add(p2,BorderLayout.CENTER);

        p4.add(b1);
        p4.add(b2);

        add(p4,BorderLayout.SOUTH);

      
        setSize(380,250);
        setLocation(600,400);	
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();
        if(msg.equals("Cancel")){
            new login().setVisible(true);
            setVisible(false);
            return;
        }
        try
        {
            conn c1=new conn();
            String u=tf1.getText();
            String v=tf2.getText();
            String v2 = tf3.getText();

            if(u.isEmpty()){
                JOptionPane.showMessageDialog(null, "Username Cannot Be Empty!");
                return;
            }else if(v.isEmpty()){
                JOptionPane.showMessageDialog(null, "Password Cannot Be Empty!");
                return;
            }
            if(!v.equals(v2)){
                JOptionPane.showMessageDialog(null, "Password are not match!");
                return;
            }

            //Check if the username is exist
            String check = "SELECT username FROM login WHERE username ='"+u +"'";
            ResultSet resultSet = c1.s.executeQuery(check);

            if (resultSet.next()) {
                // Username exists in the database
                
                JOptionPane.showMessageDialog(null, "Username exists");
                return;
            }
            
            //command for mysql database
            String q="INSERT INTO  login (username, password)  VALUES('"+u+"' ,'"+v+"');";

            int rowcount = c1.s.executeUpdate(q);
            
            if(rowcount!=0){  
                JOptionPane.showMessageDialog(null, "Sign Up Successful!");
                new login().setVisible(true); //back to login page
                setVisible(false);  //close Sign Up page
            }else{
                
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new SignUp();
    }
}
