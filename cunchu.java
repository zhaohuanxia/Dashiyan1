package Dashiyan;
import java.io.*;
import java.util.*;
import Dashiyan.xsxi;

class cunchu {
    ArrayList<xsxi> arry=new ArrayList<xsxi>();
	public Object mainJFrame;  			
	public cunchu()      
	{
		this.readfile();
	}

	public int find(String str) 
	{		
	    for (int i = 0; i<arry.size(); i++)
	      if (arry.get(i).getStuID().equals(str))
						return i;
			return -1;
	}	
	
	public void update(xsxi stu) {
		int flag=find(stu.getStuID());  
		arry.set(flag, stu);		  
	}	

	public boolean readfile() {					 
			String t=null;
			try{
				FileReader f1 = new FileReader("student.txt");
				BufferedReader br=new BufferedReader(f1);				
				arry.clear();  			
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");				 
					  xsxi st=new xsxi(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
					  arry.add(st);
					  System.out.println("读取");
					  System.out.println(s[0]);
					}
				     f1.close();
				     br.close();				     
				     return true;
					} catch (IOException e) {
		
					e.printStackTrace();
					return false;
				}	
		     }					

	public boolean add(xsxi stu)
	     {		
		System.out.println();	
		System.out.println("要添加的");	
		System.out.println(stu.fileString());
		System.out.println();
		if (find(stu.getStuID())!=-1)
			return false;		
		arry.add(stu); 
		return true;			
	}
	
	public boolean writefile() {
				FileWriter fw=null;
				BufferedWriter out=null;
				try {
					 fw = new FileWriter("student.txt");    
					 out = new BufferedWriter(fw);

						for(int i=0;i<arry.size();i++){
							String s=arry.get(i).fileString();
							System.out.println("数据");
							System.out.println(arry.get(i).fileString());
					    	out.write(s);
					    	out.newLine();
					    }
						out.close();
						fw.close();
						return true;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
		   }
	
	public boolean delete(String s)	
	{  
		int pos=find(s);
		if (pos==-1)
			return false;
		
		arry.remove(pos);    
		return true;
	}
}