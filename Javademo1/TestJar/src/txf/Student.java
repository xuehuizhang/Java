package txf;
import zxh.Person;

public class Student extends Person{
	public void sayHello() {
		System.out.println("我是学生呀");
		super.sayHello();
		super.run();
	}
	
	protected void Sing() {
		System.out.println("我会唱歌呀");
	}
}
