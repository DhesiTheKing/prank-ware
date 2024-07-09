import java.io.*;
import java.net.*;
import javax.swing.*;
public class ChatWithClient {
	public static void Chat(int port){
		JFrame j=new JFrame();
		j.setAlwaysOnTop(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.setVisible(false);
		try {
			System.out.println("chat here...");
			ServerSocket ss = new ServerSocket(port);
			Socket s = ss.accept();
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String send="",recive="";
			
			while(!send.equals("stop") || !recive.equals("stop")){
				String temp = "client :";
				temp+=recive;
				send = JOptionPane.showInputDialog(j,temp);
				dout.writeUTF(send);
				recive = din.readUTF();
			}
			
			s.close();
			ss.close();
		} 
		catch (Exception e) {
			System.out.println("Error in chatting ..");
			return;
		}
		
	}
	
	public static void main(String[] args){
		
	}
	
}
