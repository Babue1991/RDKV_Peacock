package com.automatics.rdkv.constants;

import com.automatics.rdkv.commonmethods.CommonMethods;

public class ImageCaptureConstants {

	/********The variable used to send capture card port to capture image**/
	public static String VIDEO_PORT="/dev/video1";
	
	/********The variable used to send capture card port to capture image**/
	public static String SET_VIDEO_PORT="/dev/video1";
	
	/********The variable used to send capture card port to capture image**/
	public static String ROOT_DIRECTORY=System.getProperty("user.dir");
	
	
	/********The variable used to send capture card port to capture image**/
	public static String LIVE_IMAGE_PATH=ROOT_DIRECTORY+"/src/test/java/com/automatics/rdkv/liveimage/";
	

	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_HOME_SCREEN=LIVE_IMAGE_PATH+"XfinityHomeScreen.jpg";

	/********The variable used to send capture card port to capture image**/
	public static String BEGIN_COMMAND="gst-launch-1.0 v4l2src device=";
	
	/********The variable used to send capture card port to capture image**/
	public static String EMPTY_SPACE=" ";
	
	/********The variable used to send capture card port to capture image**/
	public static String MIDDLE_COMMAND="num-buffers=1 ! jpegenc ! filesink location=";
	
	/********The variable used to send capture card port to capture image**/
	public static String CAPTURE_COMMAND=BEGIN_COMMAND+VIDEO_PORT+EMPTY_SPACE+MIDDLE_COMMAND;
}
