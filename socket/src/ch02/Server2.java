package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	// 서버 소켓 필요 - 연결만 주고받고 끊김.
	ServerSocket serverSocket;
	
	// 메세지를 주고받을 소켓 필요
	Socket socket;
	BufferedReader bufferedReader;
	
	public Server2() {
		System.out.println("클라이언트 접속 대기중");
		
		try {
			// !!! 서버 소켓을 포트 번호와 함께 생성 
			serverSocket = new ServerSocket(11001);
			
			socket = serverSocket.accept();
			System.out.println("클라이언트 접속 완료");

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String getMsg = bufferedReader.readLine();
				System.out.println("getMsg : " + getMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server2();
	}

}
