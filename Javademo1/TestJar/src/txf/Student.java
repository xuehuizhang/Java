package txf;
import zxh.Person;

public class Student extends Person{
	public void sayHello() {
		System.out.println("����ѧ��ѽ");
		super.sayHello();
		super.run();
	}
	
	protected void Sing() {
		System.out.println("�һᳪ��ѽ");
	}
}
