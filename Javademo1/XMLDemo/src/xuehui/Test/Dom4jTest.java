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
		System.out.println("��ȡ�����Ĺ��캯��");	
		Constructor[] cons=clazz.getConstructors();
		for(Constructor c:cons) {
			System.out.println(c);
		}
		System.out.println("===============================");
		System.out.println("��ȡ���еĹ��캯��");
	    Constructor[] constru=clazz.getDeclaredConstructors();
	    for(Constructor c:constru) {
	    	System.out.println(c);
	    }
	    System.out.println("===============================");
	    try {
	    System.out.println("��ȡ�޲����Ĺ��캯��");
	    Constructor c1=clazz.getConstructor(null);
	    System.out.println(c1);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.println("===============================");
	    try {
	    System.out.println("��ȡ˽�еĹ��캯��");
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
				System.out.println("=====��ʼ����ĳһ����======");
				Element book=(Element)it.next();
				//��ȡbook���������Լ�����ֵ
				List<Attribute> bookAttrs=book.attributes();
				for(Attribute attr:bookAttrs) {
					System.out.println("��������"+attr.getName()+"����ֵ��"+attr.getValue());
				}
				
				Iterator itt=book.elementIterator();
				while(itt.hasNext()) {
					Element bookChild=(Element)itt.next();
					System.out.println("�ڵ�����"+bookChild.getName()+"�ڵ�ֵ��"+bookChild.getStringValue());
				}
				System.out.println("-----����ıһ����ı���----");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDom4j() {
		SAXReader reader=new SAXReader();
		try {
			//����xml�ĵ�
			Document document=reader.read(new File("./src/demo.xml"));
			//��ȡ�ĵ����ڵ�
			Element bookStore=document.getRootElement();
			//��ȡ���ڵ�������Ԫ��
			Iterator it=bookStore.elementIterator();
			int n=1;
			while(it.hasNext()) {
				System.out.println("������"+n+"����");
			
				//��ȡ���ڵ��µ��ӽڵ�
				Element book=(Element)it.next();
				//��ȡ�ڵ�����
				List<Attribute> listAttrs=book.attributes();
				for(Attribute attr:listAttrs) {
					System.out.println("��������"+attr.getName()+"����ֵ��"+attr.getValue());
				}
				//�����ӽڵ��µĽڵ�
				Iterator itt=book.elementIterator();
				while(itt.hasNext()) {
					Element bookChild=(Element)itt.next();
					System.out.println("�ڵ�����"+bookChild.getName()+",�ڵ�ֵ��"+bookChild.getStringValue());
				}
				System.out.println("��"+n+"����������");
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
		return "Student��"+this.name+",���䣺"+this.age;
	}
	public Student() {
		System.out.println("�޲����Ĺ��캯��");
	}
	
	public Student(String name) {
		System.out.println("һ�������Ĺ��캯��"+name);
	}
	
	public Student(String name,int age) {
		System.out.println("���������Ĺ��캯��"+name+age);
	}
	protected Student(Boolean b) {
		System.out.println("�ܱ����Ĺ��캯��");
	}
	private Student(int age) {
		System.out.println("˽�еĹ��캯��");
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