package xuehui.Test;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlTest {
	@Test
	public void Test() {
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance(); 
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
		    Document document=db.parse("./src/demo.xml");
		    NodeList bookList= document.getElementsByTagName("bookstore");
		    System.out.println("һ����"+bookList.getLength()+"����");
		    
		    for(int i=0;i<bookList.getLength();i++) {
		    	System.out.println("-----------���濪ʼ������"+(i+1)+"����");
		    	Node book=bookList.item(i);
		    	NamedNodeMap attrs=book.getAttributes();
		    	System.out.println("��"+(i+1)+"����,��"+attrs.getLength()+"������");
		    	for(int j=0;j<attrs.getLength();j++) {
		    		Node attr=attrs.item(j);
		    		System.out.println("������"+attr.getNodeName());
		    		System.out.println("����ֵ"+attr.getNodeValue());
		    	}
		    	//����book�ڵ���ӽڵ�
		    	NodeList childNodes=book.getChildNodes();
		    	System.out.println("��"+(i+1)+"������"+childNodes.getLength()+"���ӽڵ�");
		    	
		    	for(int k=0;k<childNodes.getLength();k++) {
		    		if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE) {
		    			System.out.println("��"+(k+1)+"���ڵ�Ľڵ���"+childNodes.item(k).getNodeName());	
		    		}
		    	}
		    
		    }
		    
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void xmlTest() {
		//����ĵ���������Ĺ�����
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			//newһ���ĵ���������
			DocumentBuilder db=	dbf.newDocumentBuilder();
			//����ĵ���
			Document document=db.parse("./src/demo.xml");
			//��ýڵ�
		    NodeList bookStore= document.getElementsByTagName("bookstore");
		    System.out.println("һ����"+bookStore.getLength()+"�����");
		    for(int i=0;i<bookStore.getLength();i++) {
		    	System.out.println("��"+(i+1)+"�����");
		    	NamedNodeMap attrs=bookStore.item(i).getAttributes(); //��ȡ����
		    	for(int j=0;j<attrs.getLength();j++) {
		    		System.out.println("����:"+attrs.item(j).getNodeName());
		    		System.out.println("Value:��"+attrs.item(j).getNodeValue());
		    	}
		    	NodeList book =bookStore.item(i).getChildNodes();
		    	System.out.println("��"+(i+1)+"���������"+book.getLength()+"����");
		    	for(int b=0;b<book.getLength();b++) {
		    		if(book.item(b).getNodeType()==Node.ELEMENT_NODE) {
		    		  NodeList bChildE= book.item(b).getChildNodes();
		    		  for(int bE=0;bE<bChildE.getLength();bE++) {
		    			  if(bChildE.item(bE).getNodeType()==Node.ELEMENT_NODE) {
		    				  System.out.println(bChildE.item(bE).getNodeName());
		    			  }
		    		  }
		    		}
		    	}
		    	
		    	
		    }
		    System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
