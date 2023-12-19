import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteAccount extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JButton b1,b2;
    JTable j;
    
    DeleteAccount(){
        super("Delete Account Page");
        setLayout(new BorderLayout());
        t1 = new JTextField(10);
        t2 = new JPasswordField(10);
        
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
        b1 = new JButton("Delete", loginIcon);
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
        p2.add(t1);
        p2.add(new JLabel("Password "));
        p2.add(t2);
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
            String u=t1.getText();
            String v=t2.getText();
            
            //command for mysql database
            String q="DELETE FROM login WHERE username='"+u+"' AND password='"+v+"'";
            
            int rowcount = c1.s.executeUpdate(q);
            
            if(rowcount!=0){ //check if the username and password match with record
                JOptionPane.showMessageDialog(null, "Delete Successful!");
                new login().setVisible(true); //show new page
                setVisible(false);  //close login page
            }else{
                JOptionPane.showMessageDialog(null, "Username or Password is not match with our record");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new DeleteAccount();
    }
}
