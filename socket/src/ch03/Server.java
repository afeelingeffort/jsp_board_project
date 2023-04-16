package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket serverSocket;
	Socket socket;
	
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(10002);
			socket = serverSocket.accept(); // 클라이언트와 연결 완료
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new FileWriter("c:/tmp/hw.txt"));
			
			String str;
			while((str = bufferedReader.readLine())!= null) {
				System.out.println("여기까지 들어왔나요");
				bufferedWriter.write(str);
			}
			System.out.println("hello");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
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
