
package project;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class loginform extends JFrame{
   
   
 Font butnfont = new Font("Bernard MT condensed", Font.PLAIN, 18);
    Font labelfont = new Font("lucida calligraphy", Font.BOLD, 22);

    
    private ImageIcon image = new ImageIcon("img/login_frame.jpg");
    private ImageIcon imageicon = new ImageIcon("img/login.jpg");

    private JButton btn_1;
    private JPanel input;
    private JTextField user_id;
    private JPasswordField user_pass;

    public loginform() {

        getContentPane().setLayout(null);

        JLabel id = new JLabel("  ID");
        id.setForeground(Color.WHITE);
        id.setFont(labelfont);
        getContentPane().add(id);
        id.setBounds(50, 90, 60, 30);

        JLabel pass = new JLabel("Password");
        pass.setForeground(Color.WHITE);
        pass.setFont(labelfont);
        getContentPane().add(pass);
        pass.setBounds(30, 180, 140, 30);

        user_id = new JTextField();
        getContentPane().add(user_id);
        user_id.setBounds(180, 95, 160, 25);

        user_pass = new JPasswordField();
        getContentPane().add(user_pass);
        user_pass.setBounds(180, 182, 160, 25);

        JButton btn_1 = new JButton("Log In");
        btn_1.setFont(butnfont);
        btn_1.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(btn_1);
        //first:- for horizental spaces , second:- for vertical spaces ,3-for horizental size , 4-for vertical size 
        btn_1.setBounds(210, 260, 95, 35);

        JLabel label = new JLabel(image);
        getContentPane().add(label);
        label.setBounds(0, 0, 600, 400);

        //****** this to make an even to add it to specific compenent *********
        event e = new event() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id, pass;

                id = user_id.getText();
                pass = user_pass.getText();

                if ("123".equals(id) && "123".equals(pass)) {
                    setVisible(false);
                    management frame = new management();
                    frame.execute();
                } 
                else 
                {
                            JOptionPane.showMessageDialog(null,"it seems that the username or the password are invaild try again :( \nTip:- check spaces is important", "Sorry", JOptionPane.ERROR_MESSAGE);
                            user_pass.setText("");
                }
            }
        };
        //****************************************************************************

        btn_1.addActionListener(e);

    }

    //to make any event in any compoent using this class
    public abstract class event implements ActionListener {
        
    }
    
    public void execute(){
    
       
        setTitle("Log In");
        setSize(600, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
    }

    
        
}
