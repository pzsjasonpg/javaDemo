package demo.io.inputOrOutputStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream是字节流，
 * @author 28256
 *
 */
public class FileInputStreamDemo {

	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("C:\\Users\\28256\\Desktop\\test.txt");
			byte[] b = new byte[1024];
			int length = 0;
			while((length = fileInputStream.read(b)) != -1) {
				System.out.println(new String(b, 0, length));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
