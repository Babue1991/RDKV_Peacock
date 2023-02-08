package com.automatics.rdkv.commonmethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.test.AutomaticsTestBase;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

public class CommonMethods{

	public static String path;
	static String command;
	static Process p;
	public static void execCommand(String command) {
		try {

			Thread.sleep(2000L);
			p=Runtime.getRuntime().exec(command);
			printResults(p);
			Thread.sleep(3000L);
			System.out.println("The terminal command which is executed is : "+command);
			
		}catch(Exception e) {
			System.out.println("Error in terminal command execution: "+command);
			e.printStackTrace();
		}
	}

	public static void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		p.destroy();
	}

	public static void execCaptureCommand(String imagePath) {
		try {

			System.out.println(imagePath);
			String command=ImageCaptureConstants.CAPTURE_COMMAND+imagePath;
			CommonMethods.execCommand(command);
			
			

			System.out.println("The command value is: "+command);

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
