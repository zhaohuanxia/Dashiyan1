package Dashiyan;

import java.awt.*;
import javax.swing.*;

import Dashiyan.xsxi;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class luru extends JFrame implements  ActionListener{
	
	cunchu fun=new cunchu();
	
	JLabel lb1=new JLabel("当前是信息管理人员登录界面" );
	JLabel lb2=new JLabel("请输入");
	
JTextField 学号,姓名,年龄,电话号码,所选课程,身份证号码;
JRadioButton 男,女;
ButtonGroup group=null;
JButton 录入,查询,删除,修改,显示,返回;
JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;

public luru(){       
    super("学生信息管理系统");
    学号=new JTextField(10);
    姓名=new JTextField(10);
    电话号码=new JTextField(15);
    年龄=new JTextField(5);
    所选课程=new JTextField(15);
    身份证号码=new JTextField(18);
    
    group=new ButtonGroup();
    男=new JRadioButton("男");
    女=new JRadioButton("女");
    group.add(男);
    group.add(女);
    录入=new JButton("增加学生信息");
    查询=new JButton("查询符合条件的学生信息");
    删除=new JButton("删除学生信息");
    修改=new JButton("修改学生信息");
    显示=new JButton("显示全部学生信息");
    返回=new JButton("返回登录界面");

    pb=new JPanel();
    pb.add(lb1,JLabel.CENTER);
            
    p1=new JPanel();     
   
    p1.add(lb2,JLabel.CENTER);
    p1.add(new JLabel("学号:",JLabel.CENTER));
    p1.add(学号);
    
    p2=new JPanel();
    p2.add(new JLabel("姓名:",JLabel.CENTER));
    p2.add(姓名);
    p3=new JPanel();
    p3.add(new JLabel("性别:",JLabel.CENTER));
    p3.add(男);
    p3.add(女);
    p4=new JPanel();
    p4.add(new JLabel("年龄:",JLabel.CENTER));
    p4.add(年龄);
    p5=new JPanel();
    p5.add(new JLabel("电话号码:",JLabel.CENTER));
    p5.add(电话号码);    
    p6=new JPanel();
    p6.add(new JLabel("所选课程:",JLabel.CENTER));
    p6.add(所选课程);
    p7=new JPanel();
    p7.add(new JLabel("身份证号码:",JLabel.CENTER));
    p7.add(身份证号码);
   
    pv=new JPanel();
    pv.setLayout(new GridLayout(7,1)); 
        
    pv.add(p1);
    pv.add(p2);
    pv.add(p3);
    pv.add(p4);
    pv.add(p5);
    pv.add(p6);
    pv.add(p7);
           
    ph=new JPanel();      
    ph.add(录入);
ph.add(查询);
    ph.add(修改);
    ph.add(删除);    
    ph.add(显示);
    ph.add(返回);
           
    Container con=getContentPane();
    con.setLayout(new BorderLayout());
    con.add(pb, BorderLayout.NORTH);  
    con.add(pv, BorderLayout.CENTER);
    con.add(ph, BorderLayout.SOUTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100,100,900,450);
    setVisible(true);
      
    xsxi stu=new xsxi();
    ArrayList<xsxi> arry=new ArrayList<xsxi>();
    
    录入.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {		     		     
		 String sID = 学号.getText(); 
		 if(fun.find(sID)!=-1)
		 {
			 JOptionPane.showMessageDialog(null, "该学号对应的学生已经存在！！！\n\n请重新输入或者修改已经录入的学生");   			 

			 学号.setText("");
			 姓名.setText("");
			 年龄.setText("");
			 电话号码.setText("");
			所选课程.setText("");
			 身份证号码.setText("");
			 return;
		 }      		 
		 String sname = 姓名.getText();  		 
		
		 if(sID.equals("")||sname.equals(""))
		 {
			 JOptionPane.showMessageDialog(null, "录入的学生学号或姓名为空！！！\n\n请重新输入");
			 return;
		 }  	   		 	 
  		 String sage = 年龄.getText();     		 
  		 if(sage.equals(""))
			    sage="--";  		 
  		 String scall = 电话号码.getText();
  		 if(scall.equals(""))
  			  scall="--";
  		 String shome = 所选课程.getText();
  		if(shome.equals(""))
  		    shome="--";
  		 String siden = 身份证号码.getText();
  		if(siden.equals(""))
  		   siden="--";
  		 String ssex=null;
         if(男.isSelected()){
            ssex=男.getText();
         }
         else{
             ssex=女.getText();
         }   
        
  		 stu.setStuID(sID);
  		 stu.setAge(sage);
  		 stu.setName(sname);
  		 stu.setSex(ssex);
  		 stu.setCallnummber(scall);
  		 stu.setHome_place(shome);
  		 stu.setIdentityID(siden);
  		 
  		 System.out.println("信息管理员");
  		 System.out.println(stu.fileString());
  		 
  		 fun.add(stu);
  		 fun.writefile();
  		 
  		 JOptionPane.showMessageDialog(null, "录入成功！！！");

  		 setVisible(false); 
  		 new cunchu();
  		 
	   }   	   
   });
    
               

      显示.addActionListener(new ActionListener() {
 	   public void actionPerformed(ActionEvent e) {     		   
    
 		   new dayin();   		     		   
 	    }	     		   
      });
                    
    查询.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {      		  
    		   String sID = 学号.getText();   
    		   if(sID.equals(""))
    		     sID="--";       		   
      		  String sname = 姓名.getText();  		 
      		  if(sname.equals(""))
    			   sname="--";      		 	 
        	  String sage = 年龄.getText();     		 
        	  if(sage.equals(""))         
     			    sage="--";  		 
        	  String scall = 电话号码.getText();
        	 if(scall.equals(""))
        			  scall="--";
        		 String shome = 所选课程.getText();
        		if(shome.equals(""))
        		    shome="--";
        		 String siden = 身份证号码.getText();
        		if(siden.equals(""))
        		   siden="--";
        		 String ssex=null;
               if(男.isSelected()){
                  ssex=男.getText();
               }
               else {
            	    if(女.isSelected())
                     ssex=女.getText();
                   else {
						  ssex="--";
					   }
               }          		            
    	 		
    	 		FileWriter fw=null;
				BufferedWriter out=null; 
				try {
					 fw = new FileWriter("查询时暂时存放的文件.txt");
					 out = new BufferedWriter(fw);

					 out.write(sID+"  ");
					 out.write(sname+"  ");
					 out.write(ssex+"  ");
					 out.write(sage+"  "); 					   					 
					 out.write(scall+"  ");
					 out.write(shome+"  ");
					 out.write(siden+"  "); 
				   					 
					out.close();
					fw.close();
						
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}     				
		
				new chaxun();  
				
		
				学号.setText("");
				姓名.setText("");
				年龄.setText("");
				电话号码.setText("");
				所选课程.setText("");
				身份证号码.setText("");
				group.clearSelection();
				
    	    }	     		   
         }); 
   

   

      删除.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   String sID = 学号.getText(); 
    		   int flag=fun.find(sID);
    		   if(flag==-1)
    		   {
    			   JOptionPane.showMessageDialog(null, "未查找到该学号的学生！！！\n\n请重新输入");       			    
    		   }
    		   else {
					 fun.delete(sID); 
    		     fun.writefile();
    		     JOptionPane.showMessageDialog(null, "删除成功！！！\n");
				 }
   		
   			学号.setText("");
   			姓名.setText("");
   			年龄.setText("");
   			电话号码.setText("");
   			所选课程.setText("");
   			身份证号码.setText("");
   			group.clearSelection();
    		   
    	    }	     		   
         });       
      

      修改.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {
      		  String sID = 学号.getText();
      		 int flag=fun.find(sID);     		
     		 if (flag==-1)
     		 {
 			   JOptionPane.showMessageDialog(null, "未查找到该学号的学生！！！\n\n请重新输入");
  			   return;  
 		    }    
     		else
  			   JOptionPane.showMessageDialog(null, "该系统中存在该学生数据\n\n,确认返回后请输入需要修改后的数据");
   			 		    		     		 
      		 String sage = 年龄.getText();     		 
      		 if(sage.equals(""))
   			    sage="--";  		 
      		 String scall = 电话号码.getText();
      		 if(scall.equals(""))
      			  scall="--";
      		 String shome = 所选课程.getText();
      		if(shome.equals(""))
      		    shome="--";
      		 String siden = 身份证号码.getText();
      		if(siden.equals(""))
      		   siden="--";
      		 String ssex=null;
             if(男.isSelected()){
                ssex=男.getText();
             }
             else{
                 ssex=女.getText();
             }   
             String sname = 姓名.getText();  		 
  
    		 if(sname.equals(""))
    		 {
    			 JOptionPane.showMessageDialog(null, "录入的学生姓名为空！！！\n\n请重新输入");
    			 return;
    		 }  	
    
      		 stu.setStuID(sID);
      		 stu.setAge(sage);
      		 stu.setName(sname);
      		 stu.setSex(ssex);
      		 stu.setCallnummber(scall);
      		 stu.setHome_place(shome);
      		 stu.setIdentityID(siden);
     		 
      		 fun.update(stu);   
      		 fun.writefile();
      		 JOptionPane.showMessageDialog(null, "修改成功！！！");

 			学号.setText("");
 			姓名.setText("");
 			年龄.setText("");
 			电话号码.setText("");
 			所选课程.setText("");
 			身份证号码.setText("");
 			group.clearSelection();	 		 			          		         		 
      	    }	     		             	   
           });
                    
返回.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);    
			new denglu();
		}
	});
 }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}


