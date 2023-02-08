package com.automatics.rdkv.commonmethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.test.AutomaticsTestBase;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

public class CommonMethods extends AutomaticsTestBase{

	public static String path;
	static String command;
	static Process p;
	public static void execCommand(String command) {
		try {

			Thread.sleep(2000L);
			p=Runtime.getRuntime().exec(command);
			printResults(p);
			Thread.sleep(3000L);
			LOGGER.info("The terminal command which is executed is : "+command);
			System.out.println();

		}catch(Exception e) {
			LOGGER.info("Error in terminal command execution : "+command);
			
			System.out.println();
			e.printStackTrace();
		}finally {
			//	p.destroy();
			System.out.println("Process destroyed in finally block");
		}
	}

	public static void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			LOGGER.info("Terminal logs "+line);
		//	System.out.println(line);
		}
	}

	public static void execCaptureCommand(String imagePath) {
		try {
			Thread.sleep(3000L);
			CommonMethods.execCommand(ImageCaptureConstants.SET_VIDEO_PORT);
			System.out.println("The live image path: "+imagePath);

			String command=ImageCaptureConstants.CAPTURE_COMMAND+imagePath;
			CommonMethods.execCommand(command);

		}catch(Exception e) {

			System.out.println("Error in terminal command execution: "+command);
			e.printStackTrace();
		}


	}
	public static void setPort() {
		CommonMethods.execCaptureCommand(ImageCaptureConstants.SET_VIDEO_PORT);
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
