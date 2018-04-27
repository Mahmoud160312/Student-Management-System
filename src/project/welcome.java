package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class welcome extends JFrame {

    ImageIcon image=new ImageIcon("img/welcome.jpg");
    Font butnfont = new Font("Bernard MT condensed", Font.PLAIN, 18);
    
    private JLabel label;
    private JButton button;
    
    public welcome() {
        getContentPane().setLayout(null);
        
       
    
       button=new JButton("Next");
       button.setFont(butnfont);
       button.setBackground(Color.LIGHT_GRAY);
       button.setForeground(Color.darkGray);
       
       getContentPane().add(button);
       button.setBounds(650,400,98,35);
        
      event e = new event() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    loginform frame = new loginform();
                    frame.execute();
               
            }
        };
        //****************************************************************************

        button.addActionListener(e);
       
        //******** background *********************
         label=new JLabel(image);
        getContentPane().add(label);
       label.setBounds(0,0,800,517);
       
    }

     public abstract class event implements ActionListener {
    }
   
    public static void main(String[] args) {

       welcome frame=new welcome();
       
       frame.setTitle("Student Management System");
        frame.setSize(800, 517);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
      
    }

}
