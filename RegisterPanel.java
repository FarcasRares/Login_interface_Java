package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel {
	JPanel register;
	JLabel confirmation;
	JLabel informations;
	int index=0;
RegisterPanel(JFrame f,JPanel i)
{
register=new JPanel();
register.setLayout(null);

confirmation=new JLabel("");
confirmation.setBounds(240,270,280,30);
confirmation.setFont(new Font("Arial",Font.BOLD,22));
confirmation.setVisible(false);
register.add(confirmation);

informations=new JLabel("<html>Please enter an username with more than six characters, and <br> a password with more than three characters</html>");
informations.setBounds(100,10,600,70);
informations.setFont(new Font("Arial",Font.PLAIN,20));
register.add(informations);

JLabel enter_username=new JLabel("Username :");
enter_username.setBounds(205,80,300,30);
enter_username.setFont(new Font("Arial",Font.BOLD,20));
register.add(enter_username);

JLabel enter_password=new JLabel("Password :");
enter_password.setBounds(210,130,200,30);
enter_password.setFont(new Font("Arial",Font.BOLD,20));
register.add(enter_password);

JLabel repeat_password=new JLabel("Repeat :");
repeat_password.setBounds(235,180,200,30);
repeat_password.setFont(new Font("Arial",Font.BOLD,20));
register.add(repeat_password);

JTextField register_username=new JTextField();
register_username.setBounds(320,80,180,30);
register_username.setFont(new Font("Arial",Font.PLAIN,20));
register.add(register_username);

JPasswordField register_password=new JPasswordField();
register_password.setBounds(320,130,180,30);
register_password.setFont(new Font("Arial",Font.PLAIN,20));
register.add(register_password);

JPasswordField register_repeat_password=new JPasswordField();
register_repeat_password.setBounds(320,180,180,30);
register_repeat_password.setFont(new Font("Arial",Font.PLAIN,20));
register.add(register_repeat_password);

JButton submit=new JButton("Submit");
submit.setBounds(360,220,120,30);
submit.setFont(new Font("Arial",Font.BOLD,22));
submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String s1,s2,s3;
				s1=register_password.getText();
				s2=register_repeat_password.getText();
				s3=register_username.getText();
				if (s1.equals(s2) && s3.length()>6 && s1.length()>3) {
					confirmation.setText("Registration Successful!");
					confirmation.setForeground(Color.GREEN);
					confirmation.setVisible(true);
					register_password.setText("");
					register_repeat_password.setText("");
					register_username.setText("");
					File file = new File("Users_Database.txt");
					FileWriter fw;
					try {
						fw = new FileWriter(file, true);
						fw.write("\n"+s3+"\n"+s1);
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
				}
				else {
					confirmation.setText("Invalid!");
					confirmation.setForeground(Color.RED);
					confirmation.setVisible(true);
				}
				
			}
	
		});
register.add(submit);

JButton close=new JButton("Close");
close.setBounds(220,220,120,30);
close.setFont(new Font("Arial",Font.BOLD,22));
register.add(close);
close.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		register.setVisible(false);
	    i.setVisible(true);
	}
	
});

register_username.setDocument(new JTextFieldLimit(15));
register_password.setDocument(new JTextFieldLimit(15));
register_repeat_password.setDocument(new JTextFieldLimit(15));


register.setBackground(new Color(204,221,255));
register.setBounds(0,0,700,400);
register.setVisible(true);
f.add(register);
}
}
