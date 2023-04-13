package ch01;

import java.io.FileWriter;
import java.io.IOException;

// FileWriter
// 문자 기반
public class Stream_FileWriter {

	public static void main(String[] args) {
		FileWriter fw = null;

		try {
			// String, char 가능
			fw = new FileWriter("c:/tmp/writer1.txt");
			
			String msg = "asfdasdf";
			char[] buf = { 'H', 'I' };

			fw.write('A');
			fw.write(msg);
			fw.write(buf);
		} catch (IOException e) {
			System.out.println("출력 안됨");
			e.printStackTrace();
		} finally {
			try {
				// close() 안하면 출력 안됨. (close 안해서 출력 안됐었음.)
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
