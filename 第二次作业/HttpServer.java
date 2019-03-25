package 第二次作业;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	 
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}
	public void await(){
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
			System.out.println("等待来自浏览器的连接...");
    while(true){
		try {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			socket = serverSocket.accept();
			input  = socket.getInputStream();
			output = socket.getOutputStream();
			//封装request请求
			Request request = new Request(input);
			request.parse();
			//封装response对象
			Response response = new Response(output);
			response.setRequest(request);
			response.sendStaticResource();
			socket.close();
			} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}