package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	// 연결만 주고 받을 서버 소켓 (연결만 하고 끊어짐.)
	ServerSocket serverSocket;
	// 실제 통신을 할 소켓 필요 
	Socket socket;
	
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	public Server() {
		try {
			// 서버 소켓을 생성함과 동시에 연결할 포트 번호
			serverSocket = new ServerSocket(10002);
			socket = serverSocket.accept(); // 클라이언트와 연결 완료
			
			// 입력을 위한 socket의 기반스트림을 불러와야 함.(?)
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// mj.txt파일로 출력할 예정
			bufferedWriter = new BufferedWriter(new FileWriter("c:/tmp/mj.txt"));
			
			// 문자열을 null일 때까지 읽음 
			String str;
			while((str = bufferedReader.readLine())!= null) {
				bufferedWriter.write(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				// 물내려주고 닫음.
				bufferedWriter.flush();
				bufferedWriter.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}

}
