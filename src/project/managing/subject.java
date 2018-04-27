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
import javax.swing.table.DefaultTableModel;
import project.loginform;
import project.management;

public class subject extends JFrame {

    ImageIcon addimage = new ImageIcon("img/add subject.jpg");
    ImageIcon updateimage = new ImageIcon("img/update subject.jpg");
    ImageIcon deleteimage = new ImageIcon("img/delete subject.jpg");
    ImageIcon homeimage = new ImageIcon("img/Home.jpg");
    ImageIcon logoutimage = new ImageIcon("img/logout.jpg");

    Font labelfont = new Font("calibri", Font.BOLD, 19);
    Font butnfont = new Font("Bernard MT condensed", Font.PLAIN, 17);
    Color btncolor = new Color(204, 204, 255);
    Color lettercolor = new Color(0, 153, 204);
    Font butnfont_log = new Font("sanserif", Font.PLAIN, 15);
    Color btncolor_log = new Color(153, 153, 255);

    private JTabbedPane tabbed;
    private JPanel pane1, pane2, pane3;
    private JButton addbtn, searchbtn1, searchbtn2, updatebtn, deletebtn, viewbtn;
    private JLabel addlabel, updatelabel, deletelabel, homelabel, logoutlabel;
    private JLabel codelabel, namelabel, numofhourlabel;
    private JTextField code1, code2, code3, name1, name2, name3, numofhour1, numofhour2, numofhour3;
    
    

    public subject() {
        tabbed = new JTabbedPane();
        pane1 = new JPanel();
        pane2 = new JPanel();
        pane3 = new JPanel();
        

        //********************************************************************* pane 1 ***************************************
        pane1.setLayout(null);

        addbtn = new JButton("Add");
        addbtn.setFont(butnfont);
        addbtn.setBackground(btncolor);
        pane1.add(addbtn);
        addbtn.setBounds(600, 195, 100, 45);
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
        codelabel = new JLabel("Subject Code :");
        codelabel.setForeground(lettercolor);
        codelabel.setFont(labelfont);
        pane1.add(codelabel);
        codelabel.setBounds(40, 200, 120, 30);

        code1 = new JTextField();
        pane1.add(code1);
        code1.setBounds(175, 200, 140, 30);
        //******************************************** 
        namelabel = new JLabel("Subject Name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane1.add(namelabel);
        namelabel.setBounds(40, 310, 120, 30);

        name1 = new JTextField();
        pane1.add(name1);
        name1.setBounds(175, 310, 140, 30);
        //***********************************************
        numofhourlabel = new JLabel("Num of Hours:");
        numofhourlabel.setForeground(lettercolor);
        numofhourlabel.setFont(labelfont);
        pane1.add(numofhourlabel);
        numofhourlabel.setBounds(330, 310, 130, 30);

        numofhour1 = new JTextField();
        pane1.add(numofhour1);
        numofhour1.setBounds(460, 310, 140, 30);

        //******** for add the background of panel **********
        addlabel = new JLabel(addimage);
        pane1.add(addlabel);
        addlabel.setBounds(0, 0, 800, 550);

        //********************************************************************* pane 2 ***************************************
        pane2.setLayout(null);

        updatebtn = new JButton("Update");
        updatebtn.setFont(butnfont);
        updatebtn.setBackground(btncolor);
        pane2.add(updatebtn);
        updatebtn.setBounds(600, 195, 100, 45);
        updatebtn.addActionListener(update);

        searchbtn1 = new JButton("Search");
        searchbtn1.setFont(butnfont);
        searchbtn1.setBackground(btncolor);
        pane2.add(searchbtn1);
        searchbtn1.setBounds(400, 195, 100, 45);
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
        codelabel = new JLabel("Subject Code :");
        codelabel.setForeground(lettercolor);
        codelabel.setFont(labelfont);
        pane2.add(codelabel);
        codelabel.setBounds(40, 200, 120, 30);

        code2 = new JTextField();
        pane2.add(code2);
        code2.setBounds(175, 200, 140, 30);
        //******************************************** 
        namelabel = new JLabel("Subject Name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane2.add(namelabel);
        namelabel.setBounds(40, 310, 120, 30);

        name2 = new JTextField();
        pane2.add(name2);
        name2.setBounds(175, 310, 140, 30);
        //***********************************************
        numofhourlabel = new JLabel("Num of Hours:");
        numofhourlabel.setForeground(lettercolor);
        numofhourlabel.setFont(labelfont);
        pane2.add(numofhourlabel);
        numofhourlabel.setBounds(330, 310, 130, 30);

        numofhour2 = new JTextField();
        pane2.add(numofhour2);
        numofhour2.setBounds(460, 310, 140, 30);

        //******** for add the background of panel **********
        updatelabel = new JLabel(updateimage);
        pane2.add(updatelabel);
        updatelabel.setBounds(0, 0, 800, 550);

        //********************************************************************** pane 3 *******************************************
        pane3.setLayout(null);

        deletebtn = new JButton("Delete");
        deletebtn.setFont(butnfont);
        deletebtn.setBackground(btncolor);
        pane3.add(deletebtn);
        deletebtn.setBounds(600, 195, 100, 45);
        deletebtn.addActionListener(delete);

        searchbtn2 = new JButton("Search");
        searchbtn2.setFont(butnfont);
        searchbtn2.setBackground(btncolor);
        pane3.add(searchbtn2);
        searchbtn2.setBounds(400, 195, 100, 45);
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
        codelabel = new JLabel("Subject Code :");
        codelabel.setForeground(lettercolor);
        codelabel.setFont(labelfont);
        pane3.add(codelabel);
        codelabel.setBounds(40, 200, 120, 30);

        code3 = new JTextField();
        pane3.add(code3);
        code3.setBounds(175, 200, 140, 30);
        //******************************************** 
        namelabel = new JLabel("Subject Name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane3.add(namelabel);
        namelabel.setBounds(40, 310, 120, 30);

        name3 = new JTextField();
        pane3.add(name3);
        name3.setBounds(175, 310, 140, 30);
        //***********************************************
        numofhourlabel = new JLabel("Num of Hours:");
        numofhourlabel.setForeground(lettercolor);
        numofhourlabel.setFont(labelfont);
        pane3.add(numofhourlabel);
        numofhourlabel.setBounds(330, 310, 130, 30);

        numofhour3 = new JTextField();
        pane3.add(numofhour3);
        numofhour3.setBounds(460, 310, 140, 30);

        //******** for add the background of panel **********
        deletelabel = new JLabel(deleteimage);
        pane3.add(deletelabel);
        deletelabel.setBounds(0, 0, 800, 550);
        //*************************************************************************************
        tabbed.add("Add Subject", pane1);
        tabbed.add("Update Subject", pane2);
        tabbed.add("Delete Subject", pane3);
        add(tabbed);
    }

    //************************ ************************************ actions for home and logout labels ****************************
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
            //your textfields( name1 , code1 , numofhour1 )
            String code;
            String checkCode;
            checkCode = code1.getText();
            String numberOfHour = numofhour1.getText();
            String name = name1.getText();
            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from subject");
                ResultSet set = stmt.executeQuery();
                while (set.next()) {
                    code = set.getString("code");
                    if (checkCode.equals(code)) {
                        JOptionPane.showMessageDialog(null, "this ID is exist please choose another one", "Sorry", 2);
                        return;
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please, review the user guide you made something wrong", "Sorry", 3);
                System.out.println("Error" + ex.getErrorCode());
            }
            try {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement s = c.prepareStatement("insert into subject values(?,?,?)");
                if ("".equals(checkCode) || "".equals(numberOfHour) || "".equals(name)) {
                    JOptionPane.showMessageDialog(null, "Please Fill all Data carefully before press \"ADD\"", "Sorry", 2);
                } else {
                    s.setString(1, checkCode);
                    s.setString(2, name);
                    s.setInt(3, Integer.parseInt(numberOfHour));
                    s.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Added successfully :D", "done!", JOptionPane.PLAIN_MESSAGE);
                    numofhour1.setText("");
                    code1.setText("");
                    name1.setText("");

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please, review the user guide you made something wrong", "Sorry", 3);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };
    //****************************************************************************************

    buttonevent search1 = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent s) {
            //your textfields( name2 , code2 , numofhour2 )

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from subject");
                ResultSet set = stmt.executeQuery();

                String code = "";
                String checkCode;
                checkCode = code2.getText();
                String numberOfHour = numofhour2.getText();
                String name = name2.getText();
                while (set.next()) {
                    code = set.getString("code");
                    if (checkCode.equals(code)) {
                        name2.setText(set.getString("name"));
                        numofhour2.setText(set.getString("numberOfHours"));
                        code2.enable(false);
                        break;
                    }

                }
                if (checkCode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please, enter an ID to search about its Subject", "Sorry", 2);
                } else if (!checkCode.equals(code)) {
                    JOptionPane.showMessageDialog(null, "this ID doesn't exist", "wrong", 0);
                    name2.setText("");
                    numofhour2.setText("");
                    code2.setText("");

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please, review the user guide you made something wrong", "Sorry", 3);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };
    //****************************************************************************************
    buttonevent search2 = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent s) {

            ////your textfields( name3 , code3 , numofhour3 )
            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from subject");
                ResultSet set = stmt.executeQuery();

                String code = "";
                String checkCode;
                checkCode = code3.getText();
                String numberOfHour = numofhour3.getText();
                String name = name3.getText();
                while (set.next()) {
                    code = set.getString("code");
                    if (checkCode.equals(code)) {
                        name3.setText(set.getString("name"));
                        numofhour3.setText(set.getString("numberOfHours"));
                        break;
                    }

                }
                if (checkCode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please, enter an ID to search about its Subject", "Sorry", 2);
                } else if (!checkCode.equals(code)) {
                    JOptionPane.showMessageDialog(null, "this ID doesn't exist", "wrong", 0);
                    name3.setText("");
                    numofhour3.setText("");
                    code3.setText("");

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please, review the user guide you made something wrong", "Sorry", 3);
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };

    //************************************************************************************************
    buttonevent update = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent u) {

            //your textfields( name2 , code2 , numofhour2 )
            String code = "";
            String checkCode;
            checkCode = code2.getText();
            String numberOfHour = numofhour2.getText();
            String name = name2.getText();

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("update subject set name=?,numberOfHours=? where code=?");

                //******************* to check if it search before enter update by getting data **************
                if ("".equals(numberOfHour) || "".equals(checkCode) || "".equals(name)) {
                    JOptionPane.showMessageDialog(null, "Please search for subject before you enter Update :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int NumberOfHour = Integer.parseInt(numberOfHour);

                    stmt.setString(1, name);
                    stmt.setInt(2, NumberOfHour);
                    stmt.setString(3, checkCode);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Done... DATA Saved", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                    numofhour2.setText("");
                    name2.setText("");
                    code2.setText("");

                    // ******to enable entering (patient_id) data after search*************
                    code2.enable(true);
                }

            } catch (SQLException ex) {
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };

    //****************************************************************************************************
    buttonevent delete = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent d) {

            //your textfields( name3 , code3 , numofhour3 )
            String code = "";
            String checkCode;
            checkCode = code3.getText();
            String numberOfHour = numofhour3.getText();
            String name = name3.getText();

            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement delete = con.prepareStatement("delete from subject where code=?");

                //******************* to check if it search before enter delete by getting data **************
                if ("".equals(numberOfHour) || "".equals(checkCode) || "".equals(name)) {
                    JOptionPane.showMessageDialog(null, "Please search for subject before you enter Delete :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int NumberOfHour = Integer.parseInt(numberOfHour);

                    int replay = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Subject", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (replay == JOptionPane.YES_OPTION) {
                        //************************** to delete ******************
                        delete.setString(1, checkCode);
                        delete.executeUpdate();
                        name3.setText("");
                        numofhour3.setText("");
                        code3.setText("");

                    }
                }

            } catch (SQLException ex) {
                System.out.println("Error" + ex.getErrorCode());
            }

        }
    };
    //*************************************

    buttonevent view = new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent v) {
            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from subject");
                ResultSet set = stmt.executeQuery();
                DefaultTableModel dm = new DefaultTableModel();
                dm.addColumn("code");
                dm.addColumn("name");
                dm.addColumn("number of hours");

                while (set.next()) {

                    String r[] = {set.getString(1), set.getString(2),
                        set.getString(3)};
                    dm.addRow(r);
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

        setTitle("Subject Management");
        setSize(800, 550);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

}
