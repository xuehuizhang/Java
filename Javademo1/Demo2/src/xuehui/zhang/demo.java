package xuehui.zhang;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d=new Dog();
	
	int i=	d.divide(3, 1);
	System.out.println(i);
	}
}

class Animail{
	 void sayHello() {};
	 void sleep() {};
}

 class Dog extends Animail{
	
	public  void sleep() {
		
	}
	
	public int divide(int a,int b) {
		
		int s=0;
		try {
				s=a/b;
				return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("ÄãºÃ");
		}
		
		return s;
	}
}