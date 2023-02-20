package com.automatics.rdkv.captureimage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import com.automatics.rdkv.commonmethods.CommonMethods;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.test.AutomaticsTestBase;

public class CaptureLiveImage extends AutomaticsTestBase {

	static Process p;
	static String command;
	
	  public static void main(String[] args) throws IOException,
	  InterruptedException {
		  CaptureLiveImage.cap1();
	  
	  }
	 

	public static void capture(String destPath) throws IOException, InterruptedException {
		try {
			//Thread.sleep(3000L);
			CommonMethods.execCommand(ImageCaptureConstants.SET_VIDEO_PORT);
			LOGGER.info("The live image path: "+destPath);
			
			command=ImageCaptureConstants.CAPTURE_COMMAND+destPath;
			CommonMethods.execCommand(command);

		}catch(Exception e) {
			LOGGER.info("Error in terminal command execution: "+command);
			e.printStackTrace();
		}
	}

	public static void cap1() throws InterruptedException {
		String port = "/dev/video1";
		String location = "/var/lib/jenkins/workspace/homescreen1.jpg";
		CommonMethods.execCommand("v4l2-ctl --device " + port + " --set-input=1");
		Thread.sleep(3000L);
		CommonMethods.execCommand(
				"gst-launch-1.0 v4l2src device=" + port + " num-buffers=1 ! jpegenc ! filesink location=" + location);
	}

	public static void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		p.destroy();
	}

}
