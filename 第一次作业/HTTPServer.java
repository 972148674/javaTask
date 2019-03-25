package 第一次作业;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

	 
public class HTTPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8080, 12);
			while (true) {
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				is.read(new byte[2048]);
				//is.close();
				OutputStream os = socket.getOutputStream();
				
				os.write("HTTP/1.1 200 OK\r\n".getBytes());
				os.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
				os.write("Content-Length:50\r\n".getBytes());
				os.write("Server:gybs\r\n".getBytes());
				os.write(("Date:"+new Date()+"\r\n").getBytes());
				os.write("\r\n".getBytes());
				os.write("<h1>hello!</h1>".getBytes());
				os.write("<h1>hello!</h1>".getBytes());
				os.write("<h1>hello!</h1>".getBytes());
				os.write("<h1>hello!</h1>".getBytes());
				os.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}