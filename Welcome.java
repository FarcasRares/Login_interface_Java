package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelloPanel extends JFrame {
   JFrame Hello;
   JLabel welcome;
   JButton close;
HelloPanel(JFrame f)
{
	JFrame Hello=new JFrame("Hello world!");
	Hello.setLayout(null);
	Hello.setBounds(400,300,350,200);
	Hello.getContentPane().setBackground(new Color(180,200,255));
	
	close=new JButton("Close");
	close.setBounds(120,110,100,30);
	close.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Hello.setVisible(false);
		}
	});
	Hello.add(close);
	
	welcome=new JLabel("Welcome!");
	welcome.setFont(new Font("Arial",Font.BOLD,33));
	welcome.setBounds(100,40,200,50);
	welcome.setForeground(new Color(255,0,0));
	Hello.add(welcome);
	
	Hello.setVisible(true);
}
}
