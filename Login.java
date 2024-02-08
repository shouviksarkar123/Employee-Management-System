package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername,tfpassword;
    Login(){
        
        getContentPane().setBackground(Color.GREEN);
        setLayout(null);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
      
        tfusername =new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        
    JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.pink);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
       image.setBounds(350,100,200,200);
        add(image);
        
        tfpassword =new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        
        setSize(600,300);
        setLocation(450,209);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
           String username =tfusername.getText();
           String password =tfpassword.getText();
           
           Conn c =new Conn();
           String query ="select * from login where username = '"+username+"' and password ='"+password+"'";
           ResultSet rs = (ResultSet) c.s.executeQuery(query);
           if (rs.next()){
               
               Home h=new Home();
              setVisible(false);
           }else{
               JOptionPane.showMessageDialog(null,"Invalid username or password");
               setVisible(false);
           }
            }
        catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
        
    }
    public static void main (String[] args){
        new Login();
}
}