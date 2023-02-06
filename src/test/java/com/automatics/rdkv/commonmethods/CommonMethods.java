package com.automatics.rdkv.commonmethods;

import com.automatics.test.AutomaticsTestBase;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

public class CommonMethods{

	public static String path;
	public static void execCommand(String command) {
		try {

			Thread.sleep(2000L);

			Process p=Runtime.getRuntime().exec(command);
			System.out.println("The terminal command which is executed is : "+command);
		//	java.io.OutputStream out = p.getOutputStream();  

		//	LOGGER.info("The command executed"+command);

		}catch(Exception e) {

			System.out.println("Error in terminal command execution: "+command);
			e.printStackTrace();

		}
		
	
	}
	public static void execCommand1(String command) {
		try {

			Thread.sleep(2000L);

			Process p=Runtime.getRuntime().exec("gst-launch-1.0 v4l2src device=/dev/video1 num-buffers=1 ! jpegenc ! filesink location=/var/lib/jenkins/workspace/RDKV_Peacock/src/test/java/com/automatics/rdkv/liveimage/XfinityHomeScreen.jpg");
			System.out.println("The terminal command which is executed is : "+command);
		//	java.io.OutputStream out = p.getOutputStream();  

		//	LOGGER.info("The command executed"+command);

		}catch(Exception e) {

			System.out.println("Error in terminal command execution: "+command);
			e.printStackTrace();

		}
	}

	public static void AppButtonHighlight() {

	}

	public static String currentDirectoryPath() {
		System.out.println("BeforePath");

		path =System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
}
