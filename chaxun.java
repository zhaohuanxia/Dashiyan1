package Dashiyan;



import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class chaxun {	

		
		ArrayList<xsxi> arry=new ArrayList<xsxi>();
		xsxi stu=new xsxi();
		JTable table = null;
	    DefaultTableModel model = null;

	   public chaxun() {
		    JFrame jf = new JFrame("显示符合信息");
		    
		     JPanel panel = new JPanel();
		    	
		    Vector columnNames=createColumnNames();	    
		 	       
			 String [] f = new String [7];
				try{
					FileReader f1 = new FileReader("文件.txt");
					BufferedReader br=new BufferedReader(f1);				
			
					String t=null;
					while ((t= br.readLine())!= null)
						{
						  f=t.split("\\s+");		
						}
					
										
				  f1.close();
				  br.close();				  				  
					} catch (IOException e) {
								
					e.printStackTrace();						
					}
								
				
				 File file =new File("文件1.txt");
			        try {
			            if(!file.exists()) {
			                file.createNewFile();
			            }
			            FileWriter fileWriter =new FileWriter(file);
			            fileWriter.write("");
			            fileWriter.flush();
			            fileWriter.close();			    		            
			        } catch (IOException e) {
			            e.printStackTrace();			         
			        }		
			    
								
				ArrayList List = new ArrayList(); 
				for(int i=0;i<7;i++) {
					if(!f[i].equals("--"))     
						List.add(i); 							
				}
							 
				for(int i=0;i<List.size();i++)
					System.out.println(List.get(i));
				try{
						FileReader f1 = new FileReader("student.txt");
						BufferedReader br=new BufferedReader(f1);
						String t=null;
						int flag=0;
				        int t1=0;
				        
						arry.clear();				
						while ((t= br.readLine())!= null)
							{
							  String [] s=t.split("\\s+");		
							 for(int i=0;i<List.size();i++)
							 {
								 t1=(int) List.get(i);
								 if(f[t1].equals(s[t1])) {
									 flag=flag+1;
								 }
							 }
							  if(flag==List.size()) {
								 xsxi st=new xsxi(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
								 arry.add(st);
							  }							  
							  flag=0;
							  
							}
						     f1.close();
						     br.close();						     						     
							} catch (IOException e) {
									
							e.printStackTrace();				
						}	
		    	 				
				Vector data=createTableModelData();
				
				
			    model = new DefaultTableModel(data, columnNames);
			   table = new JTable(model);
		       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		       JScrollPane tablePanel = new JScrollPane(table);  
				
		        table.setForeground(Color.BLACK);                   
		        table.setFont(new Font(null, Font.PLAIN, 14));      
		        table.setSelectionForeground(Color.DARK_GRAY);     
		        table.setSelectionBackground(Color.LIGHT_GRAY);     
		        table.setGridColor(Color.GRAY);                   

		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  
		        table.getTableHeader().setForeground(Color.RED);                
		        table.getTableHeader().setResizingAllowed(false);              
		        table.getTableHeader().setReorderingAllowed(false);             

	
		        table.setRowHeight(40);

		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	   
		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		        	        
		        RowSorter sorter = new TableRowSorter(model);
		        table.setRowSorter(sorter);
		        JScrollPane pane = new JScrollPane(table);      

		      
		        JScrollPane scrollPane = new JScrollPane(table);

		   
		        panel.add(scrollPane);
		 
		        jf.setContentPane(panel);
		        jf.pack();
		        jf.setSize(900, 600);
		        jf.add(scrollPane, BorderLayout.CENTER);
		 
		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				table.setDefaultRenderer(Object.class, r);
				
				jf.setLocationRelativeTo(null);
				int t=arry.size();
				
			        if(t<=0){
			        	JOptionPane.showMessageDialog(null, "没有符合的学生");
			        	jf.setVisible(false);
			        }
			        else {
			        	jf.setVisible(true);
			        }
		    }
     private Vector createColumnNames() {
       Vector columnNames = new Vector();
  
       columnNames.add("学号");
       columnNames.add("姓名");
       columnNames.add("性别");
       columnNames.add("年龄");
       columnNames.add("电话");
       columnNames.add("所选课程");
       columnNames.add("身份证");
    
       return columnNames;
       }

     private Vector createTableModelData() {
    	 Vector data = new Vector();    	     	
         for(int i=0;i<arry.size();i++) {       	 
	    	 Vector<String> rowData=new Vector<>();	    	
	    	 rowData.add(arry.get(i).getStuID());
	    	 rowData.add(arry.get(i).getName());
	    	 rowData.add(arry.get(i).getSex());
	    	 rowData.add(arry.get(i).getAge());
	    	 rowData.add(arry.get(i).getCallnumber());
	    	 rowData.add(arry.get(i).getHome_place());
	    	 rowData.add(arry.get(i).getIdentityID());			    	 		    					  
    		 data.add(rowData);
    					  	    							   
		  }	   
         return data;
	  }  
    
}
