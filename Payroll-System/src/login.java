import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JTextField t2;
    JButton b1,b2;
    
    login(){
        super("Login Page");
        setLayout(new BorderLayout());
        t2 = new JPasswordField(10);
        t1 = new JTextField(10);
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
        b1 = new JButton("Login", loginIcon);
        b2 = new JButton("Cancel", CancelIcon);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel p1,p2,p3,p4;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();

        JMenuItem sign_up = new JMenuItem("Sign Up");
    
        sign_up.setForeground(Color.blue);
        sign_up.setFont(new Font("monospaced",Font.PLAIN,12));
        sign_up.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
 
        JMenuItem deleteAccount = new JMenuItem("Delete Account");
    
        deleteAccount.setForeground(Color.blue);
        deleteAccount.setFont(new Font("monospaced",Font.PLAIN,12));
        deleteAccount.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
        add(l,BorderLayout.WEST);

        //build the front end login page 
        p2.add(new JLabel("User Name  "));
        p2.add(t1);
        p2.add(new JLabel("Password "));
        p2.add(t2);
        add(p2,BorderLayout.CENTER);
        p2.add(sign_up);
        p2.add(deleteAccount);

        p4.add(b1);
        p4.add(b2);

        add(p4,BorderLayout.SOUTH);

        sign_up.addActionListener(this);
        deleteAccount.addActionListener(this);
      
        setSize(350,250);
        setLocation(600,400);	
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();
        if(msg.equals("Sign Up")){
            new SignUp().setVisible(true);
            setVisible(false);
            return;
        }
        if(msg.equals("Delete Account")){
            new DeleteAccount().setVisible(true);
            setVisible(false);
            return;
        }
        if(msg.equals("Cancel")){
            setVisible(false);
            return;
        }
        try
        {
            conn c1=new conn();
            String u=t1.getText();
            String v=t2.getText();
            
            //command for mysql database
            String q="select * from login where username='"+u+"' and password='"+v+"'"; 
            ResultSet rs=c1.s.executeQuery(q); // query execute
            if(rs.next()){  //check if the username and password match with record
                new project().setVisible(true); //show new page
                setVisible(false);  //close login page
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new login();
    }
}
