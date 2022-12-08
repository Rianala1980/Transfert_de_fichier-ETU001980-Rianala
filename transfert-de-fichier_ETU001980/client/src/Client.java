

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Socket socket = new Socket("localhost",2125);
		String nomFile="izy.txt"; 
		File myfile = new File(nomFile);
		int filesize = (int)myfile.length();
		OutputStream here = socket.getOutputStream();
		PrintWriter pr = new PrintWriter(socket.getOutputStream(),true);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
		Scanner sc =new Scanner(socket.getInputStream());
		
		pr.println(nomFile);
		pr.println(filesize );
		byte[]  filebyte = new byte[filesize];
		bis.read(filebyte,0,filebyte.length);
		here.write(filebyte,0,filebyte.length);
		System.out.println(sc.nextLine());
		here.flush();
		socket.close();
		
	}

}
