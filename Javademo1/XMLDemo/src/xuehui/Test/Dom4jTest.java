package xuehui.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class clazz=Class.forName("xuehui.Test.Student");
		System.out.println(clazz);
		System.out.println("===============================");
		System.out.println("获取公共的构造函数");	
		Constructor[] cons=clazz.getConstructors();
		for(Constructor c:cons) {
			System.out.println(c);
		}
		System.out.println("===============================");
		System.out.println("获取所有的构造函数");
	    Constructor[] constru=clazz.getDeclaredConstructors();
	    for(Constructor c:constru) {
	    	System.out.println(c);
	    }
	    System.out.println("===============================");
	    try {
	    System.out.println("获取无参数的构造函数");
	    Constructor c1=clazz.getConstructor(null);
	    System.out.println(c1);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.println("===============================");
	    try {
	    System.out.println("获取私有的构造函数");
	    Constructor c2= clazz.getDeclaredConstructor(int.class);
	    c2.setAccessible(true);
	    Object o= c2.newInstance(2);
	    Student s=(Student)o;
	    s.age=10;
	    System.out.println(s.age);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	    
	}
	@Test
	public void test() {
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(new File("./src/demo.xml"));
			Element bookStore=document.getRootElement();
			Iterator it=bookStore.elementIterator();
			while(it.hasNext()) {
				System.out.println("=====开始遍历某一本数======");
				Element book=(Element)it.next();
				//获取book的属性名以及属性值
				List<Attribute> bookAttrs=book.attributes();
				for(Attribute attr:bookAttrs) {
					System.out.println("属性名："+attr.getName()+"属性值："+attr.getValue());
				}
				
				Iterator itt=book.elementIterator();
				while(itt.hasNext()) {
					Element bookChild=(Element)itt.next();
					System.out.println("节点名："+bookChild.getName()+"节点值："+bookChild.getStringValue());
				}
				System.out.println("-----结束谋一本书的遍历----");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDom4j() {
		SAXReader reader=new SAXReader();
		try {
			//加载xml文档
			Document document=reader.read(new File("./src/demo.xml"));
			//获取文档根节点
			Element bookStore=document.getRootElement();
			//获取根节点下所有元素
			Iterator it=bookStore.elementIterator();
			int n=1;
			while(it.hasNext()) {
				System.out.println("遍历第"+n+"本书");
			
				//获取根节点下的子节点
				Element book=(Element)it.next();
				//获取节点属性
				List<Attribute> listAttrs=book.attributes();
				for(Attribute attr:listAttrs) {
					System.out.println("属性名："+attr.getName()+"属性值："+attr.getValue());
				}
				//遍历子节点下的节点
				Iterator itt=book.elementIterator();
				while(itt.hasNext()) {
					Element bookChild=(Element)itt.next();
					System.out.println("节点名："+bookChild.getName()+",节点值："+bookChild.getStringValue());
				}
				System.out.println("第"+n+"本书遍历完毕");
				n++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Student{
	public int age;
	public String name;
	protected String gender;
	private String email;
	
	@Override
	public String toString() {
		return "Student："+this.name+",年龄："+this.age;
	}
	public Student() {
		System.out.println("无参数的构造函数");
	}
	
	public Student(String name) {
		System.out.println("一个参数的构造函数"+name);
	}
	
	public Student(String name,int age) {
		System.out.println("两个参数的构造函数"+name+age);
	}
	protected Student(Boolean b) {
		System.out.println("受保护的构造函数");
	}
	private Student(int age) {
		System.out.println("私有的构造函数");
	}
}

class Book{
	private String name;
	private String author;
	private String year;
	private String price;
	private String language;
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	public String getAuthor() {
		return this.author;
	}
	
	public void setYear(String year) {
		this.year=year;
	}
	public String getYear() {
		return this.year;
	}
	public void setPrice(String price) {
		this.price=price;
	}
	public String getPrice() {
		return this.price;
	}
	public void setLanguage(String language) {
		this.language=language;
	}
	public String getLanguage() {
		return this.language;
	}
}