package com.automatics.rdkv.STBhomescreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import com.automatics.rdkv.commonmethods.CommonMethods;
import com.automatics.rdkv.constants.ImageCaptureConstants;

public class CaptureLiveImage {

	static Process p;
	public static void main(String[] args) throws IOException, InterruptedException {
		CaptureLiveImage.cap();

	}

	public static void capture() throws IOException, InterruptedException {
		String port="/dev/video1";
		System.out.println("Working dir:  " + System.getProperty("user.dir"));
		String path=System.getProperty("user.dir");

		String liveImage ="homescreen1.jpg";

		String completedPath="/var/lib/jenkins/workspace/RDKV_Peacock"+"/src/test/java/com/automatics/rdkv/liveimage/"+liveImage;

		String location="/home/user/eclipse-workspace/currentImage.jpg";
		String cmd1 = "sudo chmod 777 -R"+" "+completedPath;
		//	String pwd="root123";
		//	Process p = Runtime.getRuntime().exec(cmd1);

		Thread.sleep(3000L);
		//	Runtime.getRuntime().exec(pwd);
		System.out.println("Image location"+completedPath);
		//
		String command = "gst-launch-1.0 v4l2src device="+port+" num-buffers=1 ! jpegenc ! filesink location="+"/var/lib/jenkins/workspace/RDKV_Peacock/src/test/java/com/automatics/rdkv/liveimage/homescreen1.jpg";
		System.out.println("The command is " +command);

		System.out.println("Working dir:  " + System.getProperty("user.dir"));

		CommonMethods.execCommand(command);

		/*
		 * String output = CommonMethods.execCommand(cmd);
		 * System.out.println("The Output is" +output);
		 */


	}

	public static void cap(){ {
		String path="/home/user/Live_Image/homescreen1.jpg";
		String command=ImageCaptureConstants.CAPTURE_COMMAND+path;
		

		CommonMethods.execCommand(command);
	}
	}

}
