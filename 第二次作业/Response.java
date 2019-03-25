package 第二次作业;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class Response {
	
	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;
	public Response(OutputStream output){
		this.output = output;
	}
	
	public void sendStaticResource() throws IOException{
		output.write("HTTP/1.1 200 OK\r\n".getBytes());
		output.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
		output.write("Content-Length:45\r\n".getBytes());
		output.write("Server:gybs\r\n".getBytes());
		output.write(("Date:"+new Date()+"\r\n").getBytes());
		output.write("\r\n".getBytes());
		output.write("<h1>hello!</h1>".getBytes());
		output.write("<h1>hello!</h1>".getBytes());
		output.write("<h1>hello!</h1>".getBytes());
		output.write("<h1>hello!</h1>".getBytes());
		output.close();
		
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public OutputStream getOutput() {
		return output;
	}
	public void setOutput(OutputStream output) {
		this.output = output;
	}
	public static int getBUFFER_SIZE() {
		return BUFFER_SIZE;
	}
}
