package demo.io.inputOrOutputStreamDemo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * BufferedInputStream是字节流，带有一个缓存区。
 * @author 28256
 *
 */
public class BufferInputStreamDemo {

	public static void main(String[] args) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("C:\\Users\\28256\\Desktop\\test.txt");
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,2048);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = bufferedInputStream.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
