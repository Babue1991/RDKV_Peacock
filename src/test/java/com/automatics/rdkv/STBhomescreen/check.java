package com.automatics.rdkv.STBhomescreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class check {
static Process p;
	public static void main(String[] args) throws IOException, InterruptedException {

		String port = "/dev/video1";
		String location = "/var/lib/jenkins/workspace/homescreen1.jpg";
		String cmd="v4l2-ctl --device " + port + " --set-input=1";
		check obj = new check();
	//	CommonMethods.execCommand("v4l2-ctl --device " + port + " --set-input=1");
		p = Runtime.getRuntime().exec(cmd);
		Thread.sleep(5000L);
		System.out.println("The command is "+cmd);
		obj.printResults(p);
		Thread.sleep(3000L);
		//CommonMethods.execCommand("gst-launch-1.0 v4l2src device=" + port + " num-buffers=1 ! jpegenc ! filesink location=" + location);
		String cmd1="gst-launch-1.0 v4l2src device=" + port + " num-buffers=1 ! jpegenc ! filesink location=" + location;
		p = Runtime.getRuntime().exec(cmd1);
		Thread.sleep(5000L);

		System.out.println("The command is "+cmd1);
	}
	public void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println("The terminal response is: "+line);
		}
		p.destroy();
	}

}
