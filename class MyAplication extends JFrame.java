package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class MyAplication extends JFrame{
	JLabel username;
	JLabel password;
	JFrame f;
	JTextField user_text;
	JPasswordField user_password;
	JButton Login_Button;
	JButton Register_Button;
	public JPanel intro;
	JLabel confirmation;
	JButton Quit;
	String[] getDatabase=new String[100];
	MyAplication(String title)
	{
		f=new JFrame(title);
		f.setLayout(null);
		intro=new JPanel();
		intro.setLayout(null);
		
		
		username=new JLabel("Username");
		username.setBounds(200,90,120,20);
		username.setFont(new Font("Arial",Font.BOLD,22));
		intro.add(username);
		
		user_text=new JTextField();
		user_text.setBounds(330,90,180,25);
		user_text.setFont(new Font("Arial",Font.PLAIN,20));
		intro.add(user_text);
		user_text.setDocument(new JTextFieldLimit(15));
		
		password=new JLabel("Password");
		password.setBounds(200,150,120,20);
		password.setFont(new Font("Arial",Font.BOLD,22));
		intro.add(password);
		
		user_password=new JPasswordField();
		user_password.setBounds(330,150,180,25);
		user_password.setFont(new Font("Arial",Font.PLAIN,22));
		intro.add(user_password);
		user_password.setDocument(new JTextFieldLimit(15));
		
		confirmation=new JLabel("");
		confirmation.setBounds(240,270,350,30);
		confirmation.setFont(new Font("Arial",Font.BOLD,22));
		confirmation.setVisible(false);
		intro.add(confirmation);
		
		Login_Button=new JButton("Login");
		Login_Button.setFont(new Font("Arial",Font.BOLD,22));
		Login_Button.setBounds(360,200,100,50);
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader in=new BufferedReader(new FileReader("Users_Database.txt"));
					int i=0;
					int nr=0;
					int ok=0;
					while((getDatabase[i]=in.readLine()) != null) {
						i++;
						nr++;
					}
					for (i=0;i<nr;i++)
					{
						if (getDatabase[i].equals(user_text.getText()) && getDatabase[i+1].equals(user_password.getText()))
						{
							confirmation.setText("Authentification Successful!");
							confirmation.setForeground(Color.GREEN);
							confirmation.setVisible(true);
							ok=1;
							HelloPanel h=new HelloPanel(f);
						}
					}
					if (ok==0)
					{
						confirmation.setText("Invalid!");
						confirmation.setForeground(Color.RED);
						confirmation.setVisible(true);
					}
					in.close();
				}
				catch(IOException e1)
				{
					System.out.println("Error "+e1);
				}
			
				
			}
			
		});
		intro.add(Login_Button);
		
		
		Register_Button=new JButton("Register");
		Register_Button.setFont(new Font("Arial",Font.BOLD,22));
		Register_Button.setBounds(210,200,140,50);
		Register_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intro.setVisible(false);
				RegisterPanel register=new RegisterPanel(f,intro);
			
			}
			
		});
		intro.add(Register_Button);
		
		Quit=new JButton("Quit");
		Quit.setFont(new Font("Arial",Font.BOLD,22));
		Quit.setBounds(20,320,100,30);
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}			
		});
		intro.add(Quit);
		
		intro.setBounds(0,0,700,400);
		intro.setVisible(true);
		intro.setBackground(new Color(204,221,255));
		f.add(intro);

		f.getContentPane().setBackground(new Color(204,221,255));
		f.setVisible(true);
		f.setBounds(200,200,700,400);
	}
}
