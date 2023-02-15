package com.automatics.rdkv.constants;

import com.automatics.rdkv.commonmethods.CommonMethods;

public class ImageCaptureConstants {

	/********The variable used to send capture card port to capture image**/
	public static String VIDEO_PORT="/dev/video1";
	
	/********The variable used to send capture card port to capture image**/
//	public static String SET_VIDEO_PORT="/dev/video1";
	
	
	public static String SET_VIDEO_PORT="sudo v4l2-ctl --device /dev/video1 --set-input=1";
	
	
	
	/********The variable used to send capture card port to capture image**/
	public static String ROOT_DIRECTORY=System.getProperty("user.dir");
	
	public static String REFERENCE_IMAGE_PATH=ROOT_DIRECTORY+"/src/test/java/com/automatics/rdkv/referenceimage/";

	public static String STB_HOME_APPS_BUTTON_IMAGE=REFERENCE_IMAGE_PATH+"Xfinity_Home.jpg";
	
	public static String STB_APP_TITLE_IMAGE=REFERENCE_IMAGE_PATH+"ApplicationTextImage.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String LIVE_IMAGE_PATH=ROOT_DIRECTORY+"/src/test/java/com/automatics/rdkv/liveimage/";
	

	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_HOME_SCREEN=LIVE_IMAGE_PATH+"XfinityHomeScreen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_APPLICATION_SCREEN=LIVE_IMAGE_PATH+"ApplicationScreen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_APPLICATION_FOCUS_PEACOCK=LIVE_IMAGE_PATH+"ApplicationFocusPeacock.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_PEACOCK_SPLASH_SCREEN=LIVE_IMAGE_PATH+"SplashScreen.jpg";
	
	
	/********The variable used to send capture card port to capture image**/
	public static String PEACOCK_HOME_SCREEN=LIVE_IMAGE_PATH+"Peacock_home_screen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String PEACOCK_HOME_LEFT_HIDDEN_MENU=REFERENCE_IMAGE_PATH+"PeacockHomeLeftHiddenMenu.jpg";
	
	/********The variable used to send capture card port to capture image**/
//	public static String XFINITY_APPLICATION_SCREEN=LIVE_IMAGE_PATH+"ApplicationScreen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String homescren=LIVE_IMAGE_PATH+"ApplicationScreen.jpg";
	

	/********The variable used to send capture card port to capture image**/
	public static String BEGIN_COMMAND="sudo gst-launch-1.0 v4l2src device=";
	
	public static String COMP_PATH="sudo gst-launch-1.0 v4l2src device="+VIDEO_PORT+" "+"num-buffers=1 ! jpegenc ! filesink location="+XFINITY_HOME_SCREEN;
	
	/********The variable used to send capture card port to capture image**/
	public static String EMPTY_SPACE=" ";
	
	/********The variable used to send capture card port to capture image**/
	public static String MIDDLE_COMMAND="num-buffers=1 ! jpegenc ! filesink location=";
	
	/********The variable used to send capture card port to capture image**/
	public static String CAPTURE_COMMAND=BEGIN_COMMAND+VIDEO_PORT+EMPTY_SPACE+MIDDLE_COMMAND;
}
