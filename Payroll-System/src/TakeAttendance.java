import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeAttendance extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2,fh,sh;
    
    TakeAttendance(){
       super("Take_Attendant");
        setLayout(new GridLayout(4,2,40,50));
        c2 = new Choice();
        try{
            conn c = new conn();
            // collect all the data from employee table in database
            ResultSet rs = c.s.executeQuery("select * from employee");
            // add all the employee ID as option
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select Empno"));
        add(c2);
      
        l1 = new JLabel("First Half");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
       
        add(l1);
        add(fh);
        
        l2 = new JLabel("Second Half");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
       
        add(l2);
        add(sh);
       
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();
        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        String dt = new java.util.Date().toString();
        String id=c2.getSelectedItem();
        // Search whatever is match with above input from database
        String qry = "INSERT INTO attendance (id,data_tm,f_half,s_half) VALUES( '"+ id +"','"+dt+"','"+f+"','"+s+"')";
        if(msg.equals("Submit")){
            try{
                // Connect and execute the command create above
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Attendance confirmed");
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
        new TakeAttendance();
    }
}
