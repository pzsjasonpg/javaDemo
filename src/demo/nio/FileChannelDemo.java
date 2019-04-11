package demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * 该程序步骤：
 * 1. 读取文件获取FileChannel；
 * 2. 将ByteBuffer分配大小，并得到ByteBuffer
 * 3. 将通道的数据读取到buffer（读取的数据是将数据一次性读到buffer，如果buffer太小，那么读到的文件数据就会缺失）；返回值为读取数，读完为-1；
 * 4. 将buffer中的limit定位到文件尾，也就是如果文件大小229，你设置buffer的limit为1000，他会将limit设为229；
 * 5. 如果读取位置和limit之间还有数据，打印byte数据
 * 6. 关闭buffer；
 * 7. 关闭channel；
 */

public class FileChannelDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\28256\\Desktop\\test.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		//分配缓存区大小
		ByteBuffer buf = ByteBuffer.allocate(1000);
		int bytesRead = 0;
		while((bytesRead = inChannel.read(buf)) != -1) {
			System.out.println("Read" + bytesRead);
			buf.flip();
			
			while(buf.hasRemaining()) {
				System.out.println((char)buf.get());
			}
			
			buf.clear();
			inChannel.read(buf);
		}
		aFile.close();

	}

}
