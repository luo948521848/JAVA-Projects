package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Getconnection {
	
	private Socket socket;
	public Getconnection(String ip,String word) throws IOException
	{
		try {
			this.socket=new Socket(ip,9913);
			OutputStream out=socket.getOutputStream();
			PrintWriter wr=new PrintWriter(out);
			wr.write(word);
			wr.flush();
			wr.close();
			out.close();
			socket.close();
			System.out.print("发生成功");
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		
	}

}
