package ch01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocket {

	public static void main(String[] args) {

		// 소켓(Socket)은 TCP/IP 기반 네트워크 통신에서 데이터 송수신의 접점을 말한다.

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {

			// 서버 소켓 생성
			serverSocket = new ServerSocket(8080);

			// 클라이언트 접속 대기
			socket = serverSocket.accept();

			// 데이터 송수신을 위한 input/output 스트림
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			// input 스트림을 통한 데이터 수신 (클라이언트 -> 서버)
			byte[] inputData = new byte[100];
			int length = inputStream.read(inputData);
			String inputMsg = new String(inputData, 0, length);

			// output 스트림을 통한 데이터 송신 (서버 -> 클라이언트)
			String outputMsg = "하잉";
			outputStream.write(outputMsg.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				serverSocket.close();
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	} // end of main

} // end of class
