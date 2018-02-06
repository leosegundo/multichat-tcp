
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MultiChatClient{
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		DataInputStream in = null;
		DataOutputStream out = null;
		Socket s = null;
		int serverPort = 5555;
		String ip,msg,nome;

		
		
		System.out.println("Digite o IP:"); 
		ip = sc.nextLine();

		System.out.println("Digite seu nome: ");
		nome =sc.nextLine();
		
		try{
			s = new Socket(ip, serverPort);    
			in = new DataInputStream( s.getInputStream());
			out =new DataOutputStream( s.getOutputStream());

			out.writeUTF(nome);
				
		}catch(Exception e){
			System.out.println("Socket:"+e.getMessage());
		}
		
		while(!ip.equals("\\out")){
			try{
				DataInputStream in2 = in;
				DataOutputStream out2 = out;

				//Thread para escrita
				Thread write = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							String msg =  sc.nextLine();
							out2.writeUTF(msg); 
							
						}catch(Exception e){
							
						}
					}
				});
				write.start();

				String data = in2.readUTF();	
				System.out.print(data) ;
				
			}catch(Exception e){
				System.err.println("Server not found");
				break;
			}
		}
		System.out.println("CHAT Finalizado");
     }
}