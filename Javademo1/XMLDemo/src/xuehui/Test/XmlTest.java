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
		    System.out.println("一共有"+bookList.getLength()+"本书");
		    
		    for(int i=0;i<bookList.getLength();i++) {
		    	System.out.println("-----------下面开始遍历第"+(i+1)+"本书");
		    	Node book=bookList.item(i);
		    	NamedNodeMap attrs=book.getAttributes();
		    	System.out.println("第"+(i+1)+"本书,共"+attrs.getLength()+"个属性");
		    	for(int j=0;j<attrs.getLength();j++) {
		    		Node attr=attrs.item(j);
		    		System.out.println("属性名"+attr.getNodeName());
		    		System.out.println("属性值"+attr.getNodeValue());
		    	}
		    	//解析book节点的子节点
		    	NodeList childNodes=book.getChildNodes();
		    	System.out.println("第"+(i+1)+"本书有"+childNodes.getLength()+"个子节点");
		    	
		    	for(int k=0;k<childNodes.getLength();k++) {
		    		if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE) {
		    			System.out.println("第"+(k+1)+"个节点的节点名"+childNodes.item(k).getNodeName());	
		    		}
		    	}
		    
		    }
		    
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void xmlTest() {
		//获得文档创建对象的工厂类
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			//new一个文档创建对象
			DocumentBuilder db=	dbf.newDocumentBuilder();
			//获得文档树
			Document document=db.parse("./src/demo.xml");
			//获得节点
		    NodeList bookStore= document.getElementsByTagName("bookstore");
		    System.out.println("一共有"+bookStore.getLength()+"个书店");
		    for(int i=0;i<bookStore.getLength();i++) {
		    	System.out.println("第"+(i+1)+"个书店");
		    	NamedNodeMap attrs=bookStore.item(i).getAttributes(); //获取属性
		    	for(int j=0;j<attrs.getLength();j++) {
		    		System.out.println("名字:"+attrs.item(j).getNodeName());
		    		System.out.println("Value:："+attrs.item(j).getNodeValue());
		    	}
		    	NodeList book =bookStore.item(i).getChildNodes();
		    	System.out.println("第"+(i+1)+"个书店下有"+book.getLength()+"本书");
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

