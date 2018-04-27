package project.managing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import project.loginform;
import project.management;

public class student extends JFrame {

    ImageIcon addimage = new ImageIcon("img/add student.jpg");
    ImageIcon updateimage = new ImageIcon("img/update student.jpg");
    ImageIcon deleteimage = new ImageIcon("img/delete student.jpg");
    ImageIcon homeimage = new ImageIcon("img/home.jpg");
    ImageIcon logoutimage = new ImageIcon("img/logout.jpg");
    

    Font labelfont = new Font("calibri", Font.BOLD, 19);
    Font butnfont = new Font("Bernard MT condensed", Font.PLAIN, 17);
    Color btncolor = new Color(204,204, 255);
    Color lettercolor=new Color(0,153,204);
    Font butnfont_log = new Font("sanserif", Font.PLAIN, 15);
    Color btncolor_log = new Color(153, 153, 255);
    
    
    private JTabbedPane tabbed;
    private JPanel pane1, pane2, pane3;
    private JButton addbtn,searchbtn1,searchbtn2,updatebtn,deletebtn;
    private JLabel addlabel, updatelabel, deletelabel,homelabel,logoutlabel;
    private JLabel idlabel,namelabel,genderlabel,agelabel,addresslabel,phonelabel,yearlabel,semesterlabel,datelabel;
    private JTextField id1,id2,id3,name1,name2,name3,age1,age2,age3,address1,address2,address3,phone1,phone2,phone3,date1,date2,date3;
    private JComboBox gender1,gender2,gender3,year1,year2,year3,semester1,semester2,semester3;
    
    
    public student() {

        tabbed = new JTabbedPane();
        pane1 = new JPanel();
        pane2 = new JPanel();
        pane3 = new JPanel();

        //******************************************************** for panel 1 ********************************************
        pane1.setLayout(null);

        addbtn = new JButton("Add");
        addbtn.setFont(butnfont);
        addbtn.setBackground(btncolor);
        pane1.add(addbtn);
        addbtn.setBounds(600, 155, 100, 45);
        addbtn.addActionListener(add);
        
        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage,JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane1.add(homelabel);
        homelabel.setBounds(660,55, 50, 60); 
        homelabel.addMouseListener(home);
           
        
        logoutlabel = new JLabel("logout", logoutimage,JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane1.add(logoutlabel);
        logoutlabel.setBounds(720,55, 50, 60); 
        logoutlabel.addMouseListener(logout);
       
        //****************** Text fields for input data(each text field after its label) ****************
        idlabel=new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane1.add(idlabel);
        idlabel.setBounds(40, 160, 100, 30);
        
        id1 = new JTextField();
        pane1.add(id1);
        id1.setBounds(175, 160, 140, 30);
       //******************************************** 
        namelabel=new JLabel("Student name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane1.add(namelabel);
        namelabel.setBounds(40, 220, 120, 30);
        
         name1 = new JTextField();
        pane1.add(name1);
        name1.setBounds(175, 220, 392, 30);
        //**************************************************
        genderlabel=new JLabel("Gender :");
        genderlabel.setForeground(lettercolor);
        genderlabel.setFont(labelfont);
        pane1.add(genderlabel);
        genderlabel.setBounds(40, 270, 120, 30);
        
        gender1 =new JComboBox();
        gender1.addItem("Select");
        gender1.addItem("Male");
        gender1.addItem("Female");
        pane1.add(gender1);
        gender1.setBounds(175, 270, 140, 30);
        //******************************************************
        agelabel=new JLabel("Age :");
        agelabel.setForeground(lettercolor);
        agelabel.setFont(labelfont);
        pane1.add(agelabel);
        agelabel.setBounds(330, 270, 120, 30);
        
        age1=new JTextField();
        pane1.add(age1);
        age1.setBounds(430, 270,140 , 30);
        //******************************************************
        addresslabel=new JLabel("Address :");
         addresslabel.setForeground(lettercolor);
        addresslabel.setFont(labelfont);
        pane1.add(addresslabel);
        addresslabel.setBounds(40, 320, 120, 30);
        
        
        address1=new JTextField();
         pane1.add(address1);
        address1.setBounds(175, 320, 392, 30);
        //******************************************************
        yearlabel=new JLabel("Year :");
        yearlabel.setForeground(lettercolor);
        yearlabel.setFont(labelfont);
        pane1.add(yearlabel);
        yearlabel.setBounds(40, 370, 120, 30);
        
        year1=new JComboBox();
        year1.addItem("Select");
        year1.addItem("1");
        year1.addItem("2");
        year1.addItem("3");
        year1.addItem("4");
        pane1.add(year1);
        year1.setBounds(175, 370, 140, 30);
        //*******************************************************
        semesterlabel=new JLabel("Semester :");
        semesterlabel.setForeground(lettercolor);
        semesterlabel.setFont(labelfont);
        pane1.add(semesterlabel);
        semesterlabel.setBounds(330, 370, 120, 30);
        
        
        semester1=new JComboBox();
        semester1.addItem("Select");
        semester1.addItem("First term");
        semester1.addItem("Second term");
        pane1.add(semester1);
        semester1.setBounds(430,370,140 , 30);
        //*******************************************************
        phonelabel=new JLabel("Phone :");
        phonelabel.setForeground(lettercolor);
        phonelabel.setFont(labelfont);
        pane1.add(phonelabel);
        phonelabel.setBounds(40, 420, 120, 30);
        
        phone1=new JTextField();
        pane1.add(phone1);
        phone1.setBounds(175, 420, 140, 30);
        //****************************************************************
        datelabel=new JLabel("Date :");
        datelabel.setForeground(lettercolor);
        datelabel.setFont(labelfont);
        pane1.add(datelabel);
        datelabel.setBounds(330, 420, 120, 30);
        
        date1=new JTextField();
        pane1.add(date1);
        date1.setBounds(430,420,140 , 30);
        
       
       
        //******** for add the background of panel **********
        addlabel = new JLabel(addimage);
        pane1.add(addlabel);
        addlabel.setBounds(0, 0, 800, 550);
              
                
        //************************************************************************************************************
        //**************************************************** for panel 2 **********************************************
        pane2.setLayout(null);

        updatebtn = new JButton("Update");
        updatebtn.setFont(butnfont);
        updatebtn.setBackground(btncolor);
        pane2.add(updatebtn);
        updatebtn.setBounds(600, 155, 100, 45);
        updatebtn.addActionListener(update);
        
        searchbtn1 = new JButton("Search");
        searchbtn1.setFont(butnfont);
        searchbtn1.setBackground(btncolor);
        pane2.add(searchbtn1);
        searchbtn1.setBounds(400, 155, 100, 45);
        searchbtn1.addActionListener(search1);
        
        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage,JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane2.add(homelabel);
        homelabel.setBounds(660,55, 50, 60); 
        homelabel.addMouseListener(home);
        
        logoutlabel = new JLabel("logout", logoutimage,JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane2.add(logoutlabel);
        logoutlabel.setBounds(720,55, 50, 60); 
        logoutlabel.addMouseListener(logout);
        
       //*************** labels and textfields ************************
               idlabel=new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane2.add(idlabel);
        idlabel.setBounds(40, 160, 100, 30);
        
        id2 = new JTextField();
        pane2.add(id2);
        id2.setBounds(175, 160, 140, 30);
       //******************************************** 
        namelabel=new JLabel("Student name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane2.add(namelabel);
        namelabel.setBounds(40, 220, 120, 30);
        
        name2 = new JTextField();
        pane2.add(name2);
        name2.setBounds(175, 220, 392, 30);
        //**************************************************
        genderlabel=new JLabel("Gender :");
        genderlabel.setForeground(lettercolor);
        genderlabel.setFont(labelfont);
        pane2.add(genderlabel);
        genderlabel.setBounds(40, 270, 120, 30);
        
        gender2 =new JComboBox();
        gender2.addItem("Select");
        gender2.addItem("Male");
        gender2.addItem("Female");
        pane2.add(gender2);
        gender2.setBounds(175, 270, 140, 30);
        //******************************************************
        agelabel=new JLabel("Age :");
        agelabel.setForeground(lettercolor);
        agelabel.setFont(labelfont);
        pane2.add(agelabel);
        agelabel.setBounds(330, 270, 120, 30);
        
        age2=new JTextField();
        pane2.add(age2);
        age2.setBounds(430, 270,140 , 30);
        //******************************************************
        addresslabel=new JLabel("Address :");
        addresslabel.setForeground(lettercolor);
        addresslabel.setFont(labelfont);
        pane2.add(addresslabel);
        addresslabel.setBounds(40, 320, 120, 30);
        
        
        address2=new JTextField();
         pane2.add(address2);
        address2.setBounds(175, 320, 392, 30);
        //******************************************************
        yearlabel=new JLabel("Year :");
        yearlabel.setForeground(lettercolor);
        yearlabel.setFont(labelfont);
        pane2.add(yearlabel);
        yearlabel.setBounds(40, 370, 120, 30);
        
        year2=new JComboBox();
        year2.addItem("Select");
        year2.addItem("1");
        year2.addItem("2");
        year2.addItem("3");
        year2.addItem("4");
        pane2.add(year2);
        year2.setBounds(175, 370, 140, 30);
        //*******************************************************
        semesterlabel=new JLabel("Semester :");
        semesterlabel.setForeground(lettercolor);
        semesterlabel.setFont(labelfont);
        pane2.add(semesterlabel);
        semesterlabel.setBounds(330, 370, 120, 30);
        
        
        semester2=new JComboBox();
        semester2.addItem("Select");
        semester2.addItem("First term");
        semester2.addItem("Second term");
        pane2.add(semester2);
        semester2.setBounds(430,370,140 , 30);
        //*******************************************************
        phonelabel=new JLabel("Phone :");
        phonelabel.setForeground(lettercolor);
        phonelabel.setFont(labelfont);
        pane2.add(phonelabel);
        phonelabel.setBounds(40, 420, 120, 30);
        
        phone2=new JTextField();
        pane2.add(phone2);
        phone2.setBounds(175, 420, 140, 30);
        //****************************************************************
        datelabel=new JLabel("Date :");
        datelabel.setForeground(lettercolor);
        datelabel.setFont(labelfont);
        pane2.add(datelabel);
        datelabel.setBounds(330, 420, 120, 30);
        
        date2=new JTextField();
        pane2.add(date2);
        date2.setBounds(430,420,140 , 30);
       //*********************************************************************
       
        
        
        
         //******** for add the background of panel **********
        updatelabel = new JLabel(updateimage);
        pane2.add(updatelabel);
        updatelabel.setBounds(0, 0, 800, 550);

        //********************************************************************************************************************
        //*********************************************************** for panel 3 ********************************************
        
        pane3.setLayout(null);

        deletebtn = new JButton("Delete");
        deletebtn.setFont(butnfont);
        deletebtn.setBackground(btncolor);
        pane3.add(deletebtn);
        deletebtn.setBounds(600, 155, 100, 45);
        deletebtn.addActionListener(delete);
        
        searchbtn2 = new JButton("Search");
        searchbtn2.setFont(butnfont);
        searchbtn2.setBackground(btncolor);
        pane3.add(searchbtn2);
        searchbtn2.setBounds(400, 155, 100, 45);
        searchbtn2.addActionListener(search2);
        
        //********* Home and logout *********************
        homelabel = new JLabel("Home", homeimage,JLabel.CENTER);
        homelabel.setFont(butnfont_log);
        homelabel.setForeground(Color.WHITE);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        pane3.add(homelabel);
        homelabel.setBounds(660,55, 50, 60); 
        homelabel.addMouseListener(home);
        
        logoutlabel = new JLabel("logout", logoutimage,JLabel.CENTER);
        logoutlabel.setFont(butnfont_log);
        logoutlabel.setForeground(Color.WHITE);
        logoutlabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoutlabel.setHorizontalTextPosition(JLabel.CENTER);
        pane3.add(logoutlabel);
        logoutlabel.setBounds(720,55, 50, 60);  
       logoutlabel.addMouseListener(logout);
        
        //***************** labels and textfields **************
                idlabel=new JLabel("Student ID :");
        idlabel.setForeground(lettercolor);
        idlabel.setFont(labelfont);
        pane3.add(idlabel);
        idlabel.setBounds(40, 160, 100, 30);
        
        id3 = new JTextField();
        pane3.add(id3);
        id3.setBounds(175, 160, 140, 30);
       //******************************************** 
        namelabel=new JLabel("Student name :");
        namelabel.setForeground(lettercolor);
        namelabel.setFont(labelfont);
        pane3.add(namelabel);
        namelabel.setBounds(40, 220, 120, 30);
        
         name3 = new JTextField();
        pane3.add(name3);
        name3.setBounds(175, 220, 392, 30);
        //**************************************************
        genderlabel=new JLabel("Gender :");
        genderlabel.setForeground(lettercolor);
        genderlabel.setFont(labelfont);
        pane3.add(genderlabel);
        genderlabel.setBounds(40, 270, 120, 30);
        
        gender3 =new JComboBox();
        gender3.addItem("Select");
        gender3.addItem("Male");
        gender3.addItem("Female");
        pane3.add(gender3);
        gender3.setBounds(175, 270, 140, 30);
        //******************************************************
        agelabel=new JLabel("Age :");
        agelabel.setForeground(lettercolor);
        agelabel.setFont(labelfont);
        pane3.add(agelabel);
        agelabel.setBounds(330, 270, 120, 30);
        
        age3=new JTextField();
        pane3.add(age3);
        age3.setBounds(430, 270,140 , 30);
        //******************************************************
        addresslabel=new JLabel("Address :");
         addresslabel.setForeground(lettercolor);
        addresslabel.setFont(labelfont);
        pane3.add(addresslabel);
        addresslabel.setBounds(40, 320, 120, 30);
        
        
        address3=new JTextField();
         pane3.add(address3);
        address3.setBounds(175, 320, 392, 30);
        //******************************************************
        yearlabel=new JLabel("Year :");
        yearlabel.setForeground(lettercolor);
        yearlabel.setFont(labelfont);
        pane3.add(yearlabel);
        yearlabel.setBounds(40, 370, 120, 30);
        
        year3=new JComboBox();
        year3.addItem("Select");
        year3.addItem("1");
        year3.addItem("2");
        year3.addItem("3");
        year3.addItem("4");
        pane3.add(year3);
        year3.setBounds(175, 370, 140, 30);
        //*******************************************************
        semesterlabel=new JLabel("Semester :");
        semesterlabel.setForeground(lettercolor);
        semesterlabel.setFont(labelfont);
        pane3.add(semesterlabel);
        semesterlabel.setBounds(330, 370, 120, 30);
        
        
        semester3=new JComboBox();
        semester3.addItem("Select");
        semester3.addItem("First term");
        semester3.addItem("Second term");
        pane3.add(semester3);
        semester3.setBounds(430,370,140 , 30);
        //*******************************************************
        phonelabel=new JLabel("Phone :");
        phonelabel.setForeground(lettercolor);
        phonelabel.setFont(labelfont);
        pane3.add(phonelabel);
        phonelabel.setBounds(40, 420, 120, 30);
        
        phone3=new JTextField();
        pane3.add(phone3);
        phone3.setBounds(175, 420, 140, 30);
        //****************************************************************
        datelabel=new JLabel("Date :");
        datelabel.setForeground(lettercolor);
        datelabel.setFont(labelfont);
        pane3.add(datelabel);
        datelabel.setBounds(330, 420, 120, 30);
        
        date3=new JTextField();
        pane3.add(date3);
        date3.setBounds(430,420,140 , 30);
        
        
        
        //******** for add the background of panel **********
        deletelabel = new JLabel(deleteimage);
        pane3.add(deletelabel);
        deletelabel.setBounds(0, 0, 800, 550);
        
        //****************************************************************************************
        
        tabbed.add("Add Student", pane1);
        tabbed.add("Update Student", pane2);
        tabbed.add("Delete Student", pane3);

        add(tabbed);
    }
    
    
    //************************ ************************************ actions for home and logout labels ****************************
    mouseevent home=new mouseevent() {
        @Override
            public void mouseClicked(MouseEvent e) {
               
                setVisible(false);
                management frame=new management();
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
     //********************************************************************** Buttons for data base ***********************************************
  
     buttonevent add = new buttonevent() {
            @Override
            public void actionPerformed(ActionEvent a) {
                //your textfields (id1 , name1 , age1 , address1 , phone1 , date1,gender1 ,year1,semester1 )
               
        String student_id = id1.getText();
        String name = name1.getText();
        String age = age1.getText();
        String gender = gender1.getSelectedItem().toString();
        String date = date1.getText();
        String address = address1.getText();
        String phone = phone1.getText();
       String year = year1.getSelectedItem().toString();
        String semester = semester1.getSelectedItem().toString();

        try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
            PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");

            if ("".equals(student_id) || "".equals(name) || "".equals(age) || "".equals(address) || "select".equals(gender) || "".equals(phone) || "".equals(date) || "Select".equals(year) || "Select".equals(semester) ) {
                JOptionPane.showMessageDialog(null, "Please Fill all Data carefully before you enter ADD :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                int mage = Integer.parseInt(age);
                int myear = Integer.parseInt(year);
                

                stmt.setString(1, student_id);
                stmt.setString(2, name);
                stmt.setInt(3, mage);
                stmt.setString(4, gender);
                stmt.setString(5, address);
                stmt.setString(6, phone);
                stmt.setString(7, semester);
                stmt.setString(8, date);
                stmt.setInt(9, myear);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Done... DATA Saved","Confirm",JOptionPane.INFORMATION_MESSAGE);
                id1.setText("");
                name1.setText("");
                address1.setText("");
                phone1.setText("");
                gender1.setSelectedIndex(0);
                year1.setSelectedIndex(0);
                semester1.setSelectedIndex(0);
                age1.setText("");
                date1.setText("");
             
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,""+"Can't Add this student\n"+"Check these reseason:-\n"+"1-Duplicated ID, sol:- enter anthor data with different ID "
                    + "\n2- the type of your data does't match standard one like age=\'chachter\',firstname=number...etc \n" 
                    +"Error code"+ ex.getErrorCode(),"Check",JOptionPane.ERROR_MESSAGE ); 
        }

                
               
               
            }
        };
     //****************************************************************************************
     
     buttonevent search1 =new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent s) {
             //your textfields (id2 , name2 , age2 , address2 , phone2 , date2,gender2 ,year2,semester2 )
            
             try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
            PreparedStatement stmt = con.prepareStatement("select *from student");

            ResultSet set = stmt.executeQuery();

            String check_id;
            check_id = id2.getText();

            String id = "", name = "", age = "", address = "", gender = "", phone = "", date = "", year = "",semester="";

            while (set.next()) {
                id = set.getString("student_id");

                if (check_id.equals(id)) {
                    name = set.getString("studentName");
                    age = set.getString("age");
                    address = set.getString("address");
                    gender = set.getString("gender");
                    phone = set.getString("phone");
                    semester = set.getString("semester");
                    date = set.getString("date");
                    year = set.getString("years");
                   
                    break;
                }

            }
            //check if it empty********************************
            if ("".equals(check_id)) {
                JOptionPane.showMessageDialog(null, "please write Student ID first before click search", "ALARM", JOptionPane.ERROR_MESSAGE);
            } //**********check for exit ***********
            else if (!check_id.equals(id)) {

                JOptionPane.showMessageDialog(null, "The Student isn't Exist", "Sorry", JOptionPane.INFORMATION_MESSAGE);
               
                // AS if he enter vaild ID and finsh and then enter another invaild it remove all data in fields
                id2.setText("");
                name2.setText("");
                age2.setText("");
                phone2.setText("");
                date2.setText("");
                year2.setSelectedIndex(0);
                gender2.setSelectedIndex(0);
                semester2.setSelectedIndex(0);
            } else {
                name2.setText(name);
                age2.setText(age);
                date2.setText(date);
                address2.setText(address);
                phone2.setText(phone);
                date2.setText(date);
           
                //************* check for semester ***********
     
                 if ("First term".equals(semester)) 
                    semester2.setSelectedIndex(1);
                 else 
                    semester2.setSelectedIndex(1);
                
                //**********************************************************************
                
                 //************* check for semester ***********
     
                 if ("1".equals(year)) 
                    year2.setSelectedIndex(1);
                 else if("2".equals(year)) 
                    year2.setSelectedIndex(2);
                  else if("3".equals(year))
                      year2.setSelectedIndex(3);
                else
                      year2.setSelectedIndex(4);
                
                //******************* check for gender ***********************
                if ("Male".equals(gender)) 
                    gender2.setSelectedIndex(1);
                    
                else if ("Female".equals(gender)) 
                    gender2.setSelectedIndex(2);
                
                    //********* to disable  entereing data(student_id)after search done well **************
                    
                id2.enable(false);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
              
             
             
        }
    };
     //****************************************************************************************
      buttonevent search2 =new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent s) {
            
          //your textfields (id3 , name3 , age3 , address3 , phone3 , date3,gender3 ,year3,semester3 )
          
             try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
            PreparedStatement stmt = con.prepareStatement("select *from student");

            ResultSet set = stmt.executeQuery();

            String check_id;
            check_id = id3.getText();

            String id = "", name = "", age = "", address = "", gender = "", phone = "", date = "", year = "",semester="";

            while (set.next()) {
                id = set.getString("student_id");

                if (check_id.equals(id)) {
                    name = set.getString("studentName");
                    age = set.getString("age");
                    address = set.getString("address");
                    gender = set.getString("gender");
                    phone = set.getString("phone");
                    semester = set.getString("semester");
                    date = set.getString("date");
                    year = set.getString("years");
                   
                    break;
                }

            }
            //check if it empty********************************
            if ("".equals(check_id)) {
                JOptionPane.showMessageDialog(null, "please write Student ID first before click search", "ALARM", JOptionPane.ERROR_MESSAGE);
            } //**********check for exit ***********
            else if (!check_id.equals(id)) {

                JOptionPane.showMessageDialog(null, "The Student isn't Exist", "Sorry", JOptionPane.INFORMATION_MESSAGE);
               
                // AS if he enter vaild ID and finsh and then enter another invaild it remove all data in fields
                id3.setText("");
                name3.setText("");
                age3.setText("");
                phone3.setText("");
                date3.setText("");
                year3.setSelectedIndex(0);
                gender3.setSelectedIndex(0);
                semester3.setSelectedIndex(0);
            } else {
                name3.setText(name);
                age3.setText(age);
                date3.setText(date);
                address3.setText(address);
                phone3.setText(phone);
                date3.setText(date);
           
                //************* check for semester ***********
     
                 if ("First term".equals(semester)) 
                    semester3.setSelectedIndex(1);
                 else 
                    semester3.setSelectedIndex(1);
                
                //**********************************************************************
                
                 //************* check for semester ***********
     
                 if ("1".equals(year)) 
                    year3.setSelectedIndex(1);
                 else if("2".equals(year)) 
                    year3.setSelectedIndex(2);
                  else if("3".equals(year))
                      year3.setSelectedIndex(3);
                else
                      year3.setSelectedIndex(4);
                
                //******************* check for gender ***********************
                if ("Male".equals(gender)) 
                    gender3.setSelectedIndex(1);
                    
                else if ("Female".equals(gender)) 
                    gender3.setSelectedIndex(2);
                
                    //********* to disable  entereing data(student_id)after search done well **************
                    
                

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
              
         
                 
               
        }
    };
     
    //************************************************************************************************
    buttonevent update=new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent u) {
             //your textfields (id2 , name2 , age2 , address2 , phone2 , date2,gender2 ,year2,semester2 )
           
        String student_id = id2.getText();
        String name = name2.getText();
        String age = age2.getText();
        String gender = gender2.getSelectedItem().toString();
        String year = year2.getSelectedItem().toString();
        String semester = semester2.getSelectedItem().toString();
        String date = date2.getText();
        String address = address2.getText();
        String phone = phone2.getText();
        

        try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
            PreparedStatement stmt = con.prepareStatement("update  student set studentName=?,"
                    + "age=?,gender=?,address=?,phone=?,semester=?,date=?,years=? where student_id=?");

            //******************* to check if it search before enter update by getting data **************
            if ("".equals(name)  || "".equals(age) || "".equals(address) ||
                    "select".equals(gender) || "".equals(phone) || "".equals(date) || "select".equals(semester) ) 
            {
                JOptionPane.showMessageDialog(null, "Please search for student before you enter Update :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                
                int mage = Integer.parseInt(age);
                
                int myear = Integer.parseInt(year);

                stmt.setString(1, name);
                stmt.setInt(2, mage);
                stmt.setString(3, gender);
                stmt.setString(4, address);
                stmt.setString(5, phone);
                stmt.setString(6, semester);
                stmt.setString(7, date);
                stmt.setInt(8, myear);
                stmt.setString(9, student_id);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Done... DATA Saved","Confirm",JOptionPane.INFORMATION_MESSAGE);
                id2.setText("");
                date2.setText("");
                name2.setText("");
                age2.setText("");
                gender2.setSelectedIndex(0);
                semester2.setSelectedIndex(0);
                year2.setSelectedIndex(0);
                address2.setText("");
                phone2.setText("");
                
                 
                // ******to enable entering (patient_id) data after search*************
                id2.enable(true);
           }

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
           
           
        }
    };
     
     //****************************************************************************************************
    
     buttonevent delete=new buttonevent() {
        @Override
        public void actionPerformed(ActionEvent d) {
            
              //your textfields (id3 , name3 , age3 , address3 , phone3 , date3,gender3 ,year3,semester3 )
              
        String student_id = id3.getText();
        String name = name3.getText();
        String age = age3.getText();
        String gender = gender3.getSelectedItem().toString();
        String year = year3.getSelectedItem().toString();
        String semester = semester3.getSelectedItem().toString();
        String date = date3.getText();
        String address = address3.getText();
        String phone = phone3.getText();
              
        if ("".equals(name)  || "".equals(age) || "".equals(address) ||
                    "select".equals(gender) || "".equals(phone) || "".equals(date) || "select".equals(semester) ) 
            {
                JOptionPane.showMessageDialog(null, "Please search for student before you enter Update :)", "Sorry", JOptionPane.INFORMATION_MESSAGE);
            }
            else {      
              
     
        
        
        try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbs", "root", "root");
            PreparedStatement stmt = con.prepareStatement("delete from student where student_id=?");
            
            stmt.setString(1, student_id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null," Delete Done :) ","Information",JOptionPane.INFORMATION_MESSAGE);
            
            id3.setText("");
            name3.setText("");
            age3.setText("");
            address3.setText("");
            gender3.setSelectedIndex(0);
            year3.setSelectedIndex(0);
            semester3.setSelectedIndex(0);
            phone3.setText("");
            date3.setText("");
           

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
        
        // to active enter another id.
        id3.enable(true);
           
        }    
              
        }
    };
     
      
     
     public abstract class mouseevent implements MouseListener {
         
     }
     
      public abstract class buttonevent implements ActionListener {

    }

    public void execute() {

        setTitle("Student Management");
        setSize(800, 550);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

}
