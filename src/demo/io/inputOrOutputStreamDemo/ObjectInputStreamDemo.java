package demo.io.inputOrOutputStreamDemo;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;

	public class ObjectInputStreamDemo {
		
		/*
		 	序列化流(对象流) 把对象以流的形式存储在硬盘或者数据库中，就是序列化(输出)
		 	ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream
		 	ObjectInputStream对写入的对象进行读取，称为反序列化
		 */
		//序列化方法
		public static void writeObject() {
			//创建序列化流对象
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
				//创建对象
				Person person = new Person("李东兴",58);
				Person person2 = new Person("李子生",2);
				Person person3 = new Person("li",28);
				
				ArrayList<Person> list = new ArrayList<Person>();
				
				list.add(person);
				list.add(person2);
				list.add(person3);
				
				

				
//				objectOutputStream.writeObject(person);
				objectOutputStream.writeObject(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (objectOutputStream != null) {
					try {
						objectOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//反序列化方法
		public static void readObject() {
			//创建反序列化流对象
			ObjectInputStream objectInputStream = null;
			try {
				objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
				
				Object object = objectInputStream.readObject();
//				Person person = (Person)object;
//				System.out.println(person);
				
				ArrayList<Person> list = (ArrayList<Person>)object;
				for (Person person : list) {
					System.out.println(person);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) { 
				e.printStackTrace();
			} finally {
				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
		

		public static void main(String[] args) {
//			writeObject();
			readObject();
		}

	}

