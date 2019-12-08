package Dashiyan;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public  class denglu extends JFrame implements  ActionListener{

	JFrame frame=new JFrame();
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	
	
	public denglu(){
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		
		jlb1=new JLabel("登陆身份");
		
		
		jb1=new JButton("学生");
		jb2=new JButton("教师");

	
		frame.setLayout(new GridLayout(4, 1));
		

		jp1.add(jlb1);
			
		jp3.add(jb1);
		jp3.add(jb2);
		
		
		frame.add(jp2);
		frame.add(jp1);

		frame.add(jp3);
		
		
		frame.setTitle("登陆平台");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	
				
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new luru();
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new lurul();
			}
		});
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

