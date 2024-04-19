import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {
       
    project(){

        //build the fronted of the main page
        setSize(1200,900);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
    
        //Build the menu bar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu m1 = new JMenu("Master");
        m1.setForeground(Color.blue);
    
        JMenuItem t1 = new JMenuItem("New Employee");
    
        t1.setForeground(Color.blue);
        t1.setFont(new Font("monospaced",Font.PLAIN,12));
        t1.setMnemonic('N');
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
        

    
        JMenuItem t3 = new JMenuItem("Salary");
        t3.setForeground(Color.blue);
        t3.setFont(new Font("monospaced",Font.PLAIN,12));
        t3.setMnemonic('S');
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
        
    
        JMenuItem t4 = new JMenuItem("List Employee");
      
        t4.setForeground(Color.blue);
        t4.setFont(new Font("monospaced",Font.PLAIN,12));
        t4.setMnemonic('L');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
        
    
        m1.add(t1);
        m1.add(t3);
        m1.add(t4);
        mb.add(m1);
    
        t1.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);
        
        JMenu edit =new JMenu("Update");
        edit.setForeground(Color.blue);
   
        mb.add(edit);
        JMenuItem s1 = new JMenuItem("Update Salary");
        s1.setForeground(Color.blue);
        s1.setFont(new Font("monospaced",Font.PLAIN,12));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EditOpen.png")));
        
        edit.add(s1);
    
        JMenuItem s2 = new JMenuItem("Update Employee");
   
        s2.setForeground(Color.blue);
        s2.setFont(new Font("monospaced",Font.PLAIN,12));
        s2.setMnemonic('p');
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        
        
        edit.add(s2);
        JMenuItem s3 = new JMenuItem("Take Attendance");

        s3.setForeground(Color.blue);
        s3.setFont(new Font("monospaced",Font.PLAIN,12));
        s3.setMnemonic('T');
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
        
    
        edit.add(s3);
        
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        
        JMenu rep =new JMenu("Reports");
        rep.setForeground(Color.blue);
    
        mb.add(rep);
        JMenuItem p1 = new JMenuItem("Generate PaySlip");
   
    
        p1.setForeground(Color.blue);
        p1.setFont(new Font("monospaced",Font.PLAIN,12));
        p1.setMnemonic('P');
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        
        rep.add(p1);
        JMenuItem p2 = new JMenuItem("List Attendance");
   
        p2.setForeground(Color.blue);
        p2.setFont(new Font("monospaced",Font.PLAIN,12));
        p2.setMnemonic('L');
        p2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        
        rep.add(p2);
        p1.addActionListener(this);
        p2.addActionListener(this);
 
        JMenu util =new JMenu("Utilities");
        util.setForeground(Color.blue);
    
        mb.add(util);
        JMenuItem u1 = new JMenuItem("Notepad");
    
    
        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
   
        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        u1.setMnemonic('o');
        
        util.add(u1);
        JMenuItem u2 = new JMenuItem("Calculator");
        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
  
        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
        u2.setMnemonic('C');
       
    
        util.add(u2);
        JMenuItem u3 = new JMenuItem("Web Browser");
        u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
  
        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced",Font.PLAIN,12));
        u3.setMnemonic('E');
        
        util.add(u3);
   
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);

    
    
        JMenu m8=new JMenu("Exit");
        m8.setForeground(Color.red);
        mb.add(m8);
        JMenuItem m8i1=new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        m8i1.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();  
      
        if(msg.equals("New Employee")){
            new New_Employee().setVisible(true);
            setVisible(false);
        }else if(msg.equals("List Employee")){
            new List_Employee().setVisible(true);
        }else if(msg.equals("Update Employee")){
            new Update_employee().setVisible(true);
            setVisible(false);
        }else if(msg.equals("Salary")){
            new Salary().setVisible(true);
            setVisible(false);
        }else if(msg.equals("Update Salary")){
            new Update_salary().setVisible(true);
            setVisible(false);
        }else if(msg.equals("Notepad")){
            try{
               Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Calculator")){
            try{
               Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Web Browser")){
            try{
               Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Take Attendance")){
            new TakeAttendance().setVisible(true);
            setVisible(false);
        }
        else if(msg.equals("Exit"))
            System.exit(0);
        else if(msg.equals("Generate PaySlip"))
            new pay_slip().setVisible(true);
        else if(msg.equals("List Attendance"))
            new List_Attendance().setVisible(true);
    }
    
    public static void main(String[] args){
        new project().setVisible(true);
    }
    
}
