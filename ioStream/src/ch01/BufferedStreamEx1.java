package ch01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamEx1 {

	public static void main(String[] args) {
		// BufferedStream 보조 스트림 활용
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("c:/tmp/a.txt");
			fos = new FileOutputStream("c:/tmp/buffered.txt");

			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int i;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
