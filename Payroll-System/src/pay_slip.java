import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class pay_slip extends JFrame implements ActionListener{

    Choice c1;
    JTextArea t1;
    JButton b1;

    pay_slip(){
        
        super("Pay_Slip");
        setSize(800,700);
        setLocation(400,150);
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c1.add(rs.getString("id"));
            }
        }catch(Exception e) { }
    
        setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Select Id"));
        p1.add(c1);
        add(p1,"North");
    
        t1 = new JTextArea(30,80);
        JScrollPane jsp = new JScrollPane(t1);
     
        Font f1 = new Font("arial",Font.BOLD,20);
        t1.setFont(f1);
        
        b1 = new JButton("Generate Pay Slip");
    
        add(b1,"South");
        add(jsp,"Center");
        b1.addActionListener(this);
    
    }
   
    public void actionPerformed(ActionEvent e) {
     
        try{
            conn c = new conn();
            // Get the name of the empoyee with choosen ID
            ResultSet rs = c.s.executeQuery("select * from employee where id="+c1.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();
         
            // Get the salary information with the choosen ID
            rs = c.s.executeQuery("select * from salary where id="+c1.getSelectedItem());
            double gross=0;
            double net=0;
 
            // Print out a list
            LocalDate curDate = LocalDate.now();
            t1.setText(" ----------------   PAY SLIP FOR THE MONTH OF "+curDate+" ,2023  ------------------------");
            t1.append("\n");
  
            if(rs.next()){
          
                t1.append("\n     Employee ID "+rs.getString("id"));
                t1.append("\n     Employee Name "+name);
 
                t1.append("\n----------------------------------------------------------------");
                t1.append("\n");

                double hra = rs.getDouble("hra");
                t1.append("\n                  HRA         : "+hra);
                double da  = rs.getDouble("da");
                t1.append("\n                  DA          : "+da);
                double med  = rs.getDouble("med");
                t1.append("\n                  MED         : "+med);
                double pf  = rs.getDouble("pf");
                t1.append("\n                  PF          : "+pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra+da+med+pf+basic;
                net = gross - pf;
                double stateTax=0;

                if(gross>26050&&gross<46100){
                    stateTax = (gross-26050)*2.76/100;
                }else if(gross>26050){
                    stateTax = (46100-26050)*2.76/100;
                }
                if(gross>46101&&gross<92150){
                    stateTax += (gross-46100)*3.22/100;
                }else if(gross>46101){
                    stateTax += (92150-46100)*3.22/100;
                }
                if(gross>92151&&gross<115300){
                    stateTax += (gross-92151)*3.68/100;
                }else if(gross>92151){
                    stateTax += (115300-92151)*3.68/100;
                }
                if(gross>115301) stateTax += (gross-115301)*3.99/100;

                t1.append("\n                  BASIC SALARY : "+basic);

                t1.append("\n-------------------------------------------------------");
                t1.append("\n");
 
                t1.append("\n       GROSS SALARY :"+gross+"    \n       NET SALARY : "+net);
                t1.append("\n       STATE TAX   :  of gross "+ (stateTax));   
                t1.append("\n       SALARY AFTER STATE TAX   :  "+ (gross-stateTax));   
                t1.append("\n -------------------------------------------------");
                t1.append("\n");
                t1.append("\n");    
                t1.append("\n");
                t1.append("   (  Signature  )      ");

            }
        }catch(Exception ee) {
            ee.printStackTrace();
        }
 
   
    }
    public static void main(String[] args){
        new pay_slip().setVisible(true);
    }
}
