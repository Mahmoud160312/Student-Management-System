package project.managing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import project.loginform;
import project.management;

public class grade extends JFrame {

    ImageIcon addimage = new ImageIcon("img/add grade.jpg");
    ImageIcon updateimage = new ImageIcon("img/update grade.jpg");
    ImageIcon deleteimage = new ImageIcon("img/delete grade.jpg");
    ImageIcon totalimage = new ImageIcon("img/total grade.jpg");
    ImageIcon homeimage = new ImageIcon("img/home.jpg");
    ImageIcon logoutimage = new ImageIcon("img/logout.jpg");

    Font labelfont = new Font("calibri", Font.BOLD, 19);
    Font butnfont = new Font("Bernard MT condensed", Font.PLAIN, 17);
    Color btncolor = new Color(204, 204, 255);
    Color lettercolor = new Color(0, 153, 204);
    Font butnfont_log = new Font("sanserif", Font.PLAIN, 15);
    Color btncolor_log = new Color(153, 153, 255);

    private JTabbedPane tabbed;
    private JPanel pane1, pane2, pane3, pane4;
    private JButton addbtn, searchbtn1, searchbtn2, updatebtn, deletebtn, getbtn;
    private JLabel addlabel, updatelabel, deletelabel, totallabel, homelabel, logoutlabel;
    private JLabel idlabel, codelabel, gradelabel, namelabel;
    private JTextField id1, id2, id3, id4, code1, code2, code3, grade1, grade2, grade3, grade4, name;

    public grade() {

        tabbed = new JTabbedPane();
        pane1 = new JPanel();
        pane2 = new JPanel();
        pane3 = new JPanel();
        pane4 = new JPanel();
        //******************************************************************************* panel 1 *********************************
        pane1.setLayout(null);

        addbtn = new JButton("Add");
        addbtn.setFont(butnfont);
        addbtn.setBackground(btncolor);
        pane1.add(addbtn);
        addbtn.setBounds(600, 200, 100, 45);
        addbtn.addActionListener(add);

        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage, JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane1.add(homelabel);
        homelabel.setBounds(660, 55, 50, 60);
        homelabel.addMouseListener(home);

        logoutlabel = new JLabel("logout", logoutimage, JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane1.add(logoutlabel);
        logoutlabel.setBounds(720, 55, 50, 60);
        logoutlabel.addMouseListener(logout);

        //****************** Text fields for input data(each text field after its label) ****************
        idlabel = new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane1.add(idlabel);
        idlabel.setBounds(40, 180, 120, 30);

        id1 = new JTextField();
        pane1.add(id1);
        id1.setBounds(175, 180, 140, 30);
        //****************************************
        codelabel = new JLabel("Subject Code :");
        codelabel.setForeground(lettercolor);
        codelabel.setFont(labelfont);
        pane1.add(codelabel);
        codelabel.setBounds(40, 260, 120, 30);

        code1 = new JTextField();
        pane1.add(code1);
        code1.setBounds(175, 260, 140, 30);
        //****************************************
        gradelabel = new JLabel("Grade :");
        gradelabel.setForeground(lettercolor);
        gradelabel.setFont(labelfont);
        pane1.add(gradelabel);
        gradelabel.setBounds(255, 370, 120, 30);

        grade1 = new JTextField();
        pane1.add(grade1);
        grade1.setBounds(350, 370, 140, 30);

        //******** for add the background of panel **********
        addlabel = new JLabel(addimage);
        pane1.add(addlabel);
        addlabel.setBounds(0, 0, 800, 550);

        //*************************************************************************** panel 2 **********************************
        pane2.setLayout(null);

        updatebtn = new JButton("Update");
        updatebtn.setFont(butnfont);
        updatebtn.setBackground(btncolor);
        pane2.add(updatebtn);
        updatebtn.setBounds(600, 200, 100, 45);
        updatebtn.addActionListener(update);

        searchbtn1 = new JButton("Search");
        searchbtn1.setFont(butnfont);
        searchbtn1.setBackground(btncolor);
        pane2.add(searchbtn1);
        searchbtn1.setBounds(400, 200, 100, 45);
        searchbtn1.addActionListener(search1);

        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage, JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane2.add(homelabel);
        homelabel.setBounds(660, 55, 50, 60);
        homelabel.addMouseListener(home);

        logoutlabel = new JLabel("logout", logoutimage, JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane2.add(logoutlabel);
        logoutlabel.setBounds(720, 55, 50, 60);
        logoutlabel.addMouseListener(logout);

        //****************** Text fields for input data(each text field after its label) ****************
        idlabel = new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane2.add(idlabel);
        idlabel.setBounds(40, 180, 120, 30);

        id2 = new JTextField();
        pane2.add(id2);
        id2.setBounds(175, 180, 140, 30);
        //****************************************
        codelabel = new JLabel("Subject Code :");
        codelabel.setForeground(lettercolor);
        codelabel.setFont(labelfont);
        pane2.add(codelabel);
        codelabel.setBounds(40, 260, 120, 30);

        code2 = new JTextField();
        pane2.add(code2);
        code2.setBounds(175, 260, 140, 30);
        //****************************************
        gradelabel = new JLabel("Grade :");
        gradelabel.setForeground(lettercolor);
        gradelabel.setFont(labelfont);
        pane2.add(gradelabel);
        gradelabel.setBounds(255, 370, 120, 30);

        grade2 = new JTextField();
        pane2.add(grade2);
        grade2.setBounds(350, 370, 140, 30);

        //******** for add the background of panel **********
        updatelabel = new JLabel(updateimage);
        pane2.add(updatelabel);
        updatelabel.setBounds(0, 0, 800, 550);

        //************************************************************************************* panel 3 ************************************
        pane3.setLayout(null);

        deletebtn = new JButton("Delete");
        deletebtn.setFont(butnfont);
        deletebtn.setBackground(btncolor);
        pane3.add(deletebtn);
        deletebtn.setBounds(600, 200, 100, 45);
        deletebtn.addActionListener(delete);

        searchbtn2 = new JButton("Search");
        searchbtn2.setFont(butnfont);
        searchbtn2.setBackground(btncolor);
        pane3.add(searchbtn2);
        searchbtn2.setBounds(400, 200, 100, 45);
        searchbtn2.addActionListener(search2);

        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage, JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane3.add(homelabel);
        homelabel.setBounds(660, 55, 50, 60);
        homelabel.addMouseListener(home);

        logoutlabel = new JLabel("logout", logoutimage, JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane3.add(logoutlabel);
        logoutlabel.setBounds(720, 55, 50, 60);
        logoutlabel.addMouseListener(logout);

        //****************** Text fields for input data(each text field after its label) ****************
        idlabel = new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane3.add(idlabel);
        idlabel.setBounds(40, 180, 120, 30);

        id3 = new JTextField();
        pane3.add(id3);
        id3.setBounds(175, 180, 140, 30);
        //****************************************
        codelabel = new JLabel("Subject Code :");
        codelabel.setForeground(lettercolor);
        codelabel.setFont(labelfont);
        pane3.add(codelabel);
        codelabel.setBounds(40, 260, 120, 30);

        code3 = new JTextField();
        pane3.add(code3);
        code3.setBounds(175, 260, 140, 30);
        //****************************************
        gradelabel = new JLabel("Grade :");
        gradelabel.setForeground(lettercolor);
        gradelabel.setFont(labelfont);
        pane3.add(gradelabel);
        gradelabel.setBounds(255, 370, 120, 30);

        grade3 = new JTextField();
        pane3.add(grade3);
        grade3.setBounds(350, 370, 140, 30);

        //******** for add the background of panel **********
        deletelabel = new JLabel(deleteimage);
        pane3.add(deletelabel);
        deletelabel.setBounds(0, 0, 800, 550);
//************************************************************************************** pane 4 *******************************************

        pane4.setLayout(null);

        getbtn = new JButton("Get");
        getbtn.setFont(butnfont);
        getbtn.setBackground(btncolor);
        pane4.add(getbtn);
        getbtn.setBounds(500, 180, 100, 45);
        getbtn.addActionListener(get);

        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage, JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane4.add(homelabel);
        homelabel.setBounds(660, 55, 50, 60);
        homelabel.addMouseListener(home);

        logoutlabel = new JLabel("logout", logoutimage, JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane4.add(logoutlabel);
        logoutlabel.setBounds(720, 55, 50, 60);
        logoutlabel.addMouseListener(logout);
        //****************** Text fields for input data(each text field after its label) ****************
        idlabel = new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane4.add(idlabel);
        idlabel.setBounds(40, 190, 120, 30);

        id4 = new JTextField();
        pane4.add(id4);
        id4.setBounds(175, 190, 140, 30);
        //****************************************
        namelabel = new JLabel("Student Name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane4.add(namelabel);
        namelabel.setBounds(100, 290, 130, 30);

        name = new JTextField();
        pane4.add(name);
        name.setBounds(240, 290, 300, 30);

        //******************************************
        gradelabel = new JLabel("Grade :");
        gradelabel.setForeground(lettercolor);
        gradelabel.setFont(labelfont);
        pane4.add(gradelabel);
        gradelabel.setBounds(240, 370, 130, 30);

        grade4 = new JTextField();
        pane4.add(grade4);
        grade4.setBounds(320, 370, 140, 30);

        //******** for add the background of panel **********
        totallabel = new JLabel(totalimage);
        pane4.add(totallabel);
        totallabel.setBounds(0, 0, 800, 550);

        //*****************************************************************************************************************    
        tabbed.add("Add Grade", pane1);
        tabbed.add("Update Grade", pane2);
        tabbed.add("Delete Grade", pane3);
        tabbed.add("Total Grade", pane4);

        add(tabbed);
    }

    mouseevent home = new mouseevent() {
        @Override
        public void mouseClicked(MouseEvent e) {

            setVisible(false);
            management frame = new management();
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
    //**********************************************************************
    mouseevent logout = new mouseevent() {
        @Override
        public void mouseClicked(MouseEvent e) {

            setVisible(false);
            loginform frame = new loginform();
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
    //********************************************************************** Buttons for data base ***********************************************
    buttonevent add = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent a) {
            //your textfields( id1 , code1 , grade1 )
            String Student_ID = id1.getText();
            String Subject_code = code1.getText();
            String Grade = grade1.getText();
            String ID = "";
            String subcode = "";

            try {

                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs?autoReconnect=true&useSSL=false", "root", "root");
                PreparedStatement s = c.prepareStatement("insert into grade values(?,?,?)");

                // ResultSet stm=s.executeQuery();
                if ("".equals(Student_ID) || "".equals(Subject_code) || "".equals(Grade)) {
                    JOptionPane.showMessageDialog(null, "please fill all data carefully before press \"Add\"");

                } else {
                    s.setDouble(1, Double.parseDouble(Grade));

                    s.setString(2, Student_ID);

                    s.setString(3, Subject_code);

                    s.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Done...your data is added ;)");

                }

            } catch (SQLException ex) {
                //        if(!Student_ID.equals(ID) || !subcode.equals(Subject_code))
                JOptionPane.showMessageDialog(null, "The \"student ID\" is not exist \n OR The \"Subject Code\" is not exist \n please check them again :(", "Sorry ", 2);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };
    //****************************************************************************************

    buttonevent search1 = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent s) {
            //your textfields( id2 , code2 , grade2 )
            String Stud_ID = id2.getText();
            String Sub_code = code2.getText();
            String Grade = grade2.getText();

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs?autoReconnect=true&useSSL=false", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from grade");

                ResultSet set = stmt.executeQuery();

                String ID = "";
                String code = "";

                while (set.next()) {
                    ID = set.getString("student_id");
                    code = set.getString("code");

                    if (Sub_code.equals(code) && Stud_ID.equals(ID)) {

                        grade2.setText(set.getString("grade"));

                        id2.enable(false);

                        code2.enable(false);

                        break;
                    }

                }
                if (Stud_ID.equals("") || Sub_code.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please,Check that you enter an \"Student_ID\" and \"Subject_Code\" \n"
                            + "to Search about its grade ", "Sorry", 2);
                } else if (!Stud_ID.equals(ID) || !Sub_code.equals(code)) {
                    JOptionPane.showMessageDialog(null, "there is a problem with \"Student_ID\" OR \"Subject_Code\" :( \n "
                            + "please Check your data carefully ", "wrong", 0);
                    grade2.setText("");

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "there is a problem with \"Student_ID\" OR \"Subject_Code\" :( \n "
                        + "please Check your data carefully ", "wrong", 0);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };
    //****************************************************************************************
    buttonevent search2 = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent s) {
            ////your textfields( id3 , code3 , grade3 )
            String Stud_ID = id3.getText();
            String Sub_code = code3.getText();
            String Grade = grade3.getText();

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs?autoReconnect=true&useSSL=false", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from grade");

                ResultSet set = stmt.executeQuery();

                String ID = "";
                String code = "";

                while (set.next()) {
                    ID = set.getString("student_id");
                    code = set.getString("code");

                    if (Sub_code.equals(code) && Stud_ID.equals(ID)) {

                        grade3.setText(set.getString("grade"));

                        break;
                    }

                }
                if (Stud_ID.equals("") || Sub_code.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please,Check that you enter an \"Student_ID\" and \"Subject_Code\" \n"
                            + "to Search about its Grade ", "Sorry", 2);
                } else if (!Stud_ID.equals(ID) || !Sub_code.equals(code)) {
                    JOptionPane.showMessageDialog(null, "there is a problem with \"Student_ID\" OR \"Subject_Code\" :( \n "
                            + "please Check your data carefully ", "wrong", 0);
                    grade2.setText("");

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "there is a problem with \"Student_ID\" OR \"Subject_Code\" :( \n "
                        + "please Check your data carefully ", "wrong", 0);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };

    //************************************************************************************************
    buttonevent update = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent u) {

            //your textfields( id2 , code2 , grade2 )
            String Stud_ID = id2.getText();
            String Sub_code = code2.getText();
            String Grade = grade2.getText();

            double grade;

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs?autoReconnect=true&useSSL=false", "root", "root");
                PreparedStatement stmt = con.prepareStatement("update grade set grade=? where student_id=? AND code=?");

                //******************* to check if it search before enter update by getting data **************
                if ("".equals(Stud_ID) || "".equals(Sub_code) || "".equals(Grade)) {
                    JOptionPane.showMessageDialog(null, "Please search for \"Student_ID\" and \"Subject_Code\" before press \"Update\" :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    grade = Double.parseDouble(Grade);

                    stmt.setDouble(1, grade);
                    stmt.setString(2, Stud_ID);
                    stmt.setString(3, Sub_code);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Done... DATA Saved ;) ", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                    //id2.setText("");
                    // code2.setText("");
                    //grade2.setText("");

                    id2.enable(true);
                    code2.enable(true);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "You made some thing wrong :( ", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };

    //****************************************************************************************************
    buttonevent delete = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent d) {

            //your textfields( id3 , code3 , grade3 )
            String Stud_ID = id3.getText();
            String Sub_code = code3.getText();
            String Grade = grade3.getText();

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs?autoReconnect=true&useSSL=false", "root", "root");
                PreparedStatement stm = con.prepareStatement("delete from grade where student_id=? AND code=?");

                //******************* to check if it search before enter delete by getting data **************
                if ("".equals(Stud_ID) || "".equals(Sub_code) || "".equals(Grade)) {
                    JOptionPane.showMessageDialog(null, "Please search for \"Student_ID\" and \"Subject_Code\" before press \"Delete\" :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    int warning = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Grade :o)", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    if (warning == JOptionPane.YES_OPTION) {
                        //************************** to delete ******************

                        stm.setString(1, Stud_ID);
                        stm.setString(2, Sub_code);
                        stm.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Done... DATA Saved ;) ", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                        id3.setText("");
                        code3.setText("");
                        grade3.setText("");

                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "You make some thing wrong :( ", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };

    //*************************************************************************************************************  
    buttonevent get = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent g) {

            //your textfields( id3 ,name , grade4 )
            String studentId = id4.getText();
            String studentName = "", studentID = "";
            int grade = 0;
            String Grade="";

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from student");
                ResultSet set = stmt.executeQuery();
                while (set.next()) {
                    studentID = set.getString("student_id");
                    if (studentID.equals(studentId)) {
                        name.setText(set.getString("studentName"));
                        break;
                    }

                }
                if (studentId.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please, enter an ID to search about its Subject", "Sorry", 2);
                } else if (!studentId.equals(studentID)) {
                    JOptionPane.showMessageDialog(null, "this ID doesn't exist", "wrong", 0);
                    name.setText("");
                    grade4.setText("");
                    id4.setText("");

                }
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getErrorCode());
            }
            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from grade");
                ResultSet set = stmt.executeQuery();
                while (set.next()) {
                    studentID = set.getString("student_id");
                     if (studentID.equals(studentId)) {
                        Grade=set.getString("grade");
                        grade+=Integer.parseInt(Grade);
                        grade4.setText(String.valueOf(grade));
                    } 

                }
                
                if (studentId.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please, enter an ID to search about its Subject", "Sorry", 2);
                } 
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };

    public abstract class mouseevent implements MouseListener {

    }

    public abstract class buttonevent implements ActionListener {

    }

    public void execute() {

        setTitle("Grade Management");
        setSize(800, 550);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

}
