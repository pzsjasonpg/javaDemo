package demo.io.inputOrOutputStreamDemo;

import java.io.Serializable;
/***
 * 
 * @author ln
 * 序列化，反序列化需要注意的事项
 * 1.一个对象想要做持久化储存，就要进行序列化操作，前提是必须实现Serializable接口
 * 2.当类内部发生变化，而反序列化正常执行，则需要手动添加类的版本ID
 *
 */

public class Person implements Serializable {
	/**
	    很重要的一个属性
	    给类指定一个序列化版本Id,如果此类发生了变化，不会影响反序列化
	 */
//	private static final long seriaVersionUID = 1L;
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(){
		
	}
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	

}

