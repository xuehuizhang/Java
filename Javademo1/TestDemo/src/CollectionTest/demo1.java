package CollectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
public class demo1 {
	
	public static void main(String[] args) {
		 String path1="C:\\Users\\zhangxuehui\\Desktop\\1.txt";
		 String path2="C:\\Users\\zhangxuehui\\Desktop\\2.txt";
		 String path3="C:\\Users\\zhangxuehui\\Desktop\\3.txt";
		 String path4="C:\\Users\\zhangxuehui\\Desktop\\4.txt";
		 Boolean b= writeFile(path1);
		/* b=appendFile(path1);
		 copyFile(path1,path2);
		 copyFile1(path1,path3);*/
		 copyFile2(path1,path4);
		 System.out.println(b==true?"ok":"no");
	}
	
	public static Boolean writeFile(String filePath) {
		Boolean flag=false;
		FileWriter fw=null;
		try {
		 fw=new FileWriter(filePath);
		 fw.write("Hello Worrld");
		 flag=true;
		}catch(Exception e) {
			e.printStackTrace();;
		}
		finally {
			try {
				fw.flush();
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static Boolean appendFile(String filePath) {
		Boolean flag=false;
		FileWriter fw=null;
		try {
			fw=new FileWriter(filePath,true);
			fw.write("ÄãºÃ ÊÀ½ç");
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fw.flush();
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static Boolean copyFile(String sPath,String ePath) {
		Boolean flag=false;
		FileWriter fw=null;
		FileReader fr=null;
		try {
			fw=new FileWriter(ePath,true);
			fr=new FileReader(sPath);
			
			char[] buff=new char[1024];
			
			int len=0;
			while((len=fr.read(buff))!=-1) {
				fw.write(buff, 0, len);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(fw!=null) {
				try {
					fw.flush();
					fw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public static Boolean copyFile1(String sPath,String ePath) {
		Boolean flag=false;
		FileReader fr=null;
		FileWriter fw=null;
		try {
		 fr=new FileReader(sPath);
		 fw=new FileWriter(ePath);
		
		int ch=0;
		while((ch=fr.read())!=-1) {
			fw.write(ch);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
			fr.close();
			fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return flag;
	}

	public static Boolean copyFile2(String sPath,String ePath) {
		FileReader fr=null;
		FileWriter fw=null;
		Boolean flag=false;
		try {
			 fr=new FileReader(sPath);
			 fw=new FileWriter(ePath,true);
			 char[] buff=new char[1024];
			 int len=0;
			 while((len=fr.read(buff))!=-1) {
				 fw.write(buff,0,len);
			 }
			 flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
				   fr.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(fw!=null) {
				try {
					fw.flush();
					fw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	
}
