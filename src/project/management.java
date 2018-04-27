package project;

import project.managing.student;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import project.managing.grade;
import project.managing.subject;

public class management extends JFrame {

    ImageIcon image = new ImageIcon("img/management.jpg");
    ImageIcon logoutimage = new ImageIcon("img/mlogout.jpg");
    
    
    Font butnfont = new Font("Bernard MT condensed", Font.PLAIN, 17);
    Color btncolor = new Color(255, 204, 102);
    Color lettercolor = new Color(153, 0, 0);
    
    Font butnfont_log = new Font("sanserif", Font.PLAIN, 15);
    Color btncolor_log = new Color(153, 153, 255);

    private JLabel label,logoutlabel;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
   

    public management() {
        getContentPane().setLayout(null);

        label = new JLabel(image);

        btn1 = new JButton("Students");
        btn1.setBackground(btncolor);
        btn1.setForeground(lettercolor);
        btn1.setFont(butnfont);
        getContentPane().add(btn1);
        btn1.setBounds(210, 345, 90, 35);

        btn2 = new JButton("Subjects");
        btn2.setBackground(btncolor);
        btn2.setForeground(lettercolor);
        btn2.setFont(butnfont);
        getContentPane().add(btn2);
        btn2.setBounds(355, 345, 90, 35);

        btn3 = new JButton("Grades");
        btn3.setBackground(btncolor);
        btn3.setForeground(lettercolor);
        btn3.setFont(butnfont);
        getContentPane().add(btn3);
        btn3.setBounds(500, 345, 90, 35);
       
        
         logoutlabel = new JLabel("Logout", logoutimage,JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        getContentPane().add(logoutlabel);
        logoutlabel.setBounds(670,10, 140, 90);
        
        
        getContentPane().add(label);
        label.setBounds(0, 0, 800, 517);
        
        btn1.addActionListener(e1);
        btn2.addActionListener(e2);
        btn3.addActionListener(e3);
        logoutlabel.addMouseListener(logout);
    }

    //********************************************************** actions on buttons and label ****************************************
     event e1 = new event() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                student frame = new student();
                frame.execute();

            }
        };
        //****************************************************************************
        event e2 = new event() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                setVisible(false);
                subject frame = new subject();
                frame.execute();

            }
        };
        //*********************************************************************************
        event e3 = new event() {
            @Override
            public void actionPerformed(ActionEvent e3) {
                setVisible(false);
                grade frame = new grade();
                frame.execute();

            }
        };
        
        //***********************************************************************************
       mouseevent logout=new mouseevent() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                loginform frame=new loginform();
                frame.execute();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }
        };
    
    public abstract class event implements ActionListener {

    }
         public abstract  class mouseevent implements MouseListener {
         
    }

    public void execute() {
        setTitle("Management");
        setSize(800, 517);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

}
