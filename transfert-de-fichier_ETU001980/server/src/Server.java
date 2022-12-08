

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket server= new ServerSocket(2125);
		Socket sock = server.accept();
		Scanner in = new Scanner(sock.getInputStream());
		InputStream is = sock.getInputStream();
		PrintWriter pr= new PrintWriter(sock.getOutputStream(),true); 
		String FileName = in.nextLine();
		int Filesize = in.nextInt();
		FileOutputStream fos = new FileOutputStream(FileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] bitearray = new byte[Filesize];
		
		int file = is.read(bitearray ,0 , bitearray.length);
		bos.write(bitearray,0,file);
		
		System.out.println("File :" + FileName);
		System.out.println("Size :" + Filesize + "Byte");
		pr.println("Nety le izy");
		bos.close();
		sock.close(); 
		 
		
		
		
		} 


}
