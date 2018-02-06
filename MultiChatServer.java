
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class MultiChatServer {
	public static void main (String args[]) {
		Map<Socket,String> sockets = new HashMap<>();
		Frases frases = new Frases();
		
		try{
			System.out.println("Server is on");
			int serverPort = 5555; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			
			while(true) {
				Socket clientSocket = listenSocket.accept();
				
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							DataInputStream in = new DataInputStream( clientSocket.getInputStream());;
							DataOutputStream out =new DataOutputStream( clientSocket.getOutputStream());
							sockets.put(clientSocket,in.readUTF());
							boolean chave;
							while (true){
								chave = false;

								String name = sockets.get(clientSocket);
								String data = in.readUTF();
								
								if(data.equals("\\?")){
									chave = true;
									data = name + ": \\?\n" + "server: \n \\frases - to see frases , \n \\list - to see the list of users on chat\n"; 
								}
								if(data.equals("\\frases")){
									chave = true;
									data = name+": \\frases\n"+"server: "+ frases.getAFrase()+"\n";
								}
								if(data.equals("\\list")){
									chave = true;
									data = name+": \\list\n"+ "server: \n";
									int i = 0;
									for(Map.Entry<Socket,String> list : sockets.entrySet()){
										data = data+""+ i+" - " + list.getValue()+"\n";
										i++;
									}
								}
								
								for(Map.Entry<Socket,String> list : sockets.entrySet()){
									DataOutputStream outt =new DataOutputStream( list.getKey().getOutputStream());
									if(chave){
										outt.writeUTF(data);
									}
									else{
										if(!list.getKey().equals(clientSocket)){
											outt.writeUTF(name+": "+ data+"\n");
										}else{
											outt.writeUTF("");
										}
									}
								}

								/*for(Map.Entry<Socket,String> lis : sockets.entrySet()){
									DataOutputStream outt =new DataOutputStream( lis.getKey().getOutputStream());
									if(!lis.getKey().equals(clientSocket)){
										outt.writeUTF(name+": "+ data+"\n");
									}else{
										outt.writeUTF("");
									}
								}*/
								
							} 
						}catch(IOException e){
							System.out.println("Connection:"+e.getMessage());
						}
						
					}
					
				});
				th.start();
			}
		}catch(IOException e){
			System.out.println("Listen socket:"+e.getMessage());
		}
	}
}
