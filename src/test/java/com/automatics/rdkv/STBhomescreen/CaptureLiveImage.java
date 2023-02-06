package com.automatics.rdkv.STBhomescreen;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import com.automatics.rdkv.commonmethods.CommonMethods;

public class CaptureLiveImage {

	static Process p;
	public static void main(String[] args) throws IOException {
		CaptureLiveImage.capture();
		
	}

	public static void capture() throws IOException {
		String port="/dev/video1";
		System.out.println("Working dir:  " + System.getProperty("user.dir"));
		String path=System.getProperty("user.dir");
		
		String liveImage ="homescreen.jpg";
				
		String completedPath="/var/lib/jenkins/workspace/RDKV_Peacock/"+"/src/test/java/com/automatics/rdkv/liveimage/"+liveImage;
		   
		String location="/home/user/eclipse-workspace/currentImage.jpg";
	//	String cmd1 = "chmod 777 -R"+" "+completedPath;
//		Runtime.getRuntime().exec(cmd1);
		System.out.println("Image location"+completedPath);
		//
		String command = "gst-launch-1.0 v4l2src device="+port+" num-buffers=1 ! jpegenc ! filesink location="+completedPath;
		System.out.println("The command is " +command);

		System.out.println("Working dir:  " + System.getProperty("user.dir"));

		CommonMethods.execCommand(command);
		
		/*
		 * String output = CommonMethods.execCommand(cmd);
		 * System.out.println("The Output is" +output);
		 */


	}
}
