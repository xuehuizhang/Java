package txf;

import zxh.Util;
import java.util.ArrayList;
import java.util.*;
public class Pck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  LinkedList l=new LinkedList();
	  l.add(1);
	  l.add(2);
	  l.add(3);
	  l.addFirst(0);
	  l.addLast(4);
	  
	 // printFor(l);
	 // printForeach(l);
	 // printLinkIterator(l);
	  
	  //printFor(l);
	  
	  printIterator(l);
	  
	}
	
	public static void printFor(LinkedList l) {
      for(int i=0;i<l.size();i++) {
    	 
    	  System.out.println(l.get(i));
      }
	}
	
	public static void printForeach(LinkedList l) {
		for(Object i:l) {
			if((int)i==1) {
				l.add(6);
			}
			System.out.println(i);
		}
	}
	
	public static void printIterator(LinkedList l) {
		Iterator i=l.iterator();
		while(i.hasNext()) {
			if((int)i.next()==2) {
				l.add(6);
			}
		}
	}
	
	public static void printLinkIterator(LinkedList l) {
	    ListIterator it=l.listIterator();
	    while(it.hasNext()) {
	    	if((int)it.next()==1) {
	    		it.remove();
	    	}
	    }
	}
}
