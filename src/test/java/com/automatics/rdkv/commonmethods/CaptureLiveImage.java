package com.automatics.rdkv.commonmethods;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.automatics.rdkv.constants.ImageCaptureConstants;

public class CaptureLiveImage {
	/*
	 * 
	 * Command to take live image screenshot
	 * // gst-launch-1.0 v4l2src device="/dev/video0" num-buffers=1 ! jpegenc ! filesink location=/home/user/Desktop/new1
	 * 
	 * Author Babu Eagambaram
	 * 
	 */

	private static Process p;
	private static String ScreenCapturCommand;
	private static Runtime runtime;
	public static void main(String args[]) throws IOException {

		System.out.println("Image capture start");
    //    BufferedImage image = ImageIO.read(CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_HOME_SCREEN));
	//	RenderedImage bufferedImage=null;
	//	  ImageIO.write(image , "jpg", new File("/home/user/Desktop/image.jpg"));
	}
	
	/*
	 * This method is used for capturing live screen 
	 */
	public static void capture(String imagePath) throws IOException {
		
		System.out.println(imagePath);
		String command =ImageCaptureConstants.CAPTURE_COMMAND+imagePath;
		//runtime = Runtime.getRuntime();
				
		ScreenCapturCommand = ImageCaptureConstants.COMP_PATH;
		System.out.println("The screen capture command is: " +ScreenCapturCommand);
		
		CommonMethods.execCommand(ImageCaptureConstants.CAPTURE_COMMAND+imagePath);

	//	File file =new File(imagePath);
		
		
		
//		return file;

	}
}
