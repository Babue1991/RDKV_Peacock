package com.automatics.rdkv.moviescreen;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import org.testng.annotations.Test;
import com.automatics.annotations.TestDetails;
import com.automatics.constants.DataProviderConstants;
import com.automatics.device.Dut;
import com.automatics.rdkb.BroadBandTestGroup;
import com.automatics.rdkb.utils.CommonUtils;
import com.automatics.rdkv.STBhomescreen.CropImage;
import com.automatics.rdkv.captureimage.CaptureLiveImage;
import com.automatics.rdkv.commonmethods.CommonMethods;
import com.automatics.rdkv.commonmethods.GrabText;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;


public class PeacockMovieScreen extends AutomaticsTestBase {
	
	/**
	 * String to store the value for resource usage compute window
	 */
	/**
	 * 
	 * This test is to verify user can launch movies screen successfully from Peacock menu using remote keys	 * 
	 * <ol>
	 * <li>Step 1 : Verify the movie screen is getting launched successfully or not</li>
	 * </ol>
	 * 
	 * @param device Dut to be used for execution
	 * 
	 * @author Tejaswi KY
	 * @throws InterruptedException 
	 * 
	 */
	static Process p;
	@Test(priority=5,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1011")
	public void testVerifyPeacockMenu(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-011";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage subrefImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1011");
		LOGGER.info("TEST DESCRIPTION: This test is to verify user can navigate to Peacock left menu using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left button for the Peacock left menu");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to Peacock menu section";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can naviagte to Peacock menu using remote keys");
			LOGGER.info("STEP 1: ACTION : Press left button and do screen capture");
			LOGGER.info("STEP 1: EXPECTED :Peacock menu section should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Redirecting to Peacock menu screen: ");
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			Thread.sleep(5000L);
			
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture application screen reference live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_SCREEN);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live reference image");
			//referenceImage = Imgcodecs.imread(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_SCREEN);
			 referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_SCREEN));
			 
			LOGGER.info("Calling Crop Image method");
				
			subrefImage = CropImage.cropImage(referenceImage, 35,150,250,420);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_LEFTMENU_LIVE_SCREEN);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			//liveImage = Imgcodecs.imread(ImageCaptureConstants.PEACOCK_LEFTMENU_LIVE_SCREEN);
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LEFTMENU_LIVE_SCREEN));
			
			LOGGER.info("Calling Crop Image method");
			
			subImage = CropImage.cropImage(liveImage, 35,150,250,420);
			
            ImageCompare imgCompare =new ImageCompare();
			
			LOGGER.info("Calling screen compare method");

			status = imgCompare.compare(subrefImage, subImage);
			
			if (status) {
				LOGGER.info("The status of image comparision is: " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1011");

	}

	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1012")
	public void testVerifyMoviesOption(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-012";
		String errorMessage = null;
		String stepNum = null;
//		Mat referenceImage;
		BufferedImage liveImage;
		String actual;
		String expected = "Lo";
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1012");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify movies option present in the menu using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press down button form the Peacock left menu");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to Movies button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify movies option present in the menu using remote keys");
			LOGGER.info("STEP 1: ACTION : Press down button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Movies option should be there in the menu.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			Thread.sleep(3000L);
			
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MENU_MOVIE_OPTION);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			//liveImage = Imgcodecs.imread(ImageCaptureConstants.PEACOCK_MENU_MOVIE_OPTION);
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MENU_MOVIE_OPTION));
			
			LOGGER.info("Calling crop method");
			
			subImage = CropImage.cropImage(liveImage, 95,280,120,32);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expected, actual);
			
			LOGGER.info("Calling comapre text method");
		
			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1012");

	}
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1013")
	public void testVerifyMovieScreen(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-013";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		String actual;
		String expected ="Featured Movies";
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1013");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to Peacock movie screen using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on Movies option from Peacock Menu");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to Movies section";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can navigate to Peacock movie screen using remote keys");
			LOGGER.info("STEP 1: ACTION : Press ok button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Movies section should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Movies option on Peacock menu ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_SCREEN);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");

			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_SCREEN));
			
            LOGGER.info("Calling crop method");
			

			subImage = CropImage.cropImage(liveImage, 70,380,300,60);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expected, actual);
			
			LOGGER.info("Calling comapre text method");
		
			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1013");

	}

	@Test(priority=8,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1014")
	public void testVerifyMovie(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-014";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		String expected = "Resume";
		String actual;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1014");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can Select movie content using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on any Movie");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to play Movies";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can Select movie content using remote keys");
			LOGGER.info("STEP 1: ACTION : Press ok button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Movies player screen should be shown.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_PLAY_CONTENT);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_PLAY_CONTENT));
			
            LOGGER.info("Calling crop method");
			
			subImage = CropImage.cropImage(liveImage, 260,630,80,50);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.partialTextCompare(expected, actual);
			
			LOGGER.info("Calling comapre text method");
			if (status) {
				LOGGER.info("The status of image comparision is: " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching home screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1014");

	}
	@Test(priority=9,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1015")
	public void testVerifyMoviePlay(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-015";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage liveNextImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1015");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can play movie content using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on Play icon");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to play Movies";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can play movie content using remote keys");
			LOGGER.info("STEP 1: ACTION : Press ok button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Movies should play successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_PLAY_CONTENT_SCREEN);
			Thread.sleep(10000L);
			
			LOGGER.info("Reading live image");
			
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_PLAY_CONTENT_SCREEN));
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_PLAY_NEXT_CONTENT);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live next image");
			
			liveNextImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_PLAY_NEXT_CONTENT));
			
			LOGGER.info("Calling image compare method");
			
            ImageCompare imgCompare =new ImageCompare();

			status = imgCompare.compare(liveImage, liveNextImage);
			
			if (status) {
				
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
				
			} else {
				LOGGER.info("The status of image comparision is: " + status + "and movie is playing");
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while playing movie: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1015");

	}
	@Test(priority=10,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1016")
	public void testVerifyMoviePause(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-016";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage livePauseImage;
		BufferedImage livePauseNextImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1016");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can pause movie content using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on Pause icon");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to pause Movies";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can pause movie content using remote keys");
			LOGGER.info("STEP 1: ACTION : Press left button and click ok button");
			LOGGER.info("STEP 1: EXPECTED : Movies should pause playing.");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			//Thread.sleep(3000L);
			nu.pattern.OpenCV.loadLocally();
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_MOVIE_PAUSE_CONTENT);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_PAUSE_CONTENT));
			
			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_REFERENCE_PLAY_ICON));
			
			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 50,630,40,44);
			
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
			
			LOGGER.info("Calling image compare method");
			
            ImageCompare imgCompare =new ImageCompare();

			status = imgCompare.compare(referenceImage, output);
			
			if (status) {
				
				LOGGER.info("The status of image comparision is: " + status + "and Play icon verified");
				
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			
			Thread.sleep(3000L);
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			Thread.sleep(2000L);
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN);
			
			LOGGER.info("Reading next live image");
			livePauseImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN));
			
			LOGGER.info("Capture after 5seconds application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN_NEXT);
			
			LOGGER.info("Reading next live image");
			livePauseNextImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN_NEXT));
			
	        LOGGER.info("Calling image compare method");

			status = imgCompare.compare(livePauseImage, livePauseNextImage);
			
			if (status) {
				
				LOGGER.info("The status of image comparision is: " + status + "and Pause verified");
				
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while pausing movie: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1016");

	}
	@Test(priority=11,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1017")
	public void testVerifySubtitleButton(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-017";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected ="Subtitles";
		String actual;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1017");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify subtile button text");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on left button and Up button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify subtitle button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify subtile button text");
			LOGGER.info("STEP 1: ACTION : Press left button and click up button");
			LOGGER.info("STEP 1: EXPECTED : Subtile option should be there");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			
			nu.pattern.OpenCV.loadLocally();
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_MOVIE_SUBTITLE_BUTTON);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_SUBTITLE_BUTTON));
			
			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 220,515,140,40);
			
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			
			LOGGER.info("Calling comapre text method");
			status = CommonMethods.partialTextCompare(expected, actual);
			
			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while verifying subtitle button: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1017");

	}
	@Test(priority=11,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1018")
	public void testVerifySubtitleText(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-018";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1018");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify subtile text");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on left button and then on ok button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify subtitle text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify subtile text");
			LOGGER.info("STEP 1: ACTION : Press left button and click ok button");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(3000L);
			
			LOGGER.info("Calling method to check subtitle");
			status = CommonMethods.checkSubtitle();
			
			if (status) {
				LOGGER.info("Subtitle text is shown and status is : " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while verifying subtitle text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1018");

	}
	@Test(priority=11,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1019")
	public void testVerifyDisableSubtitle(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-019";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1018");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify disable subtitle");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on left button twice and then on ok button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify disable subtitle";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify disable subtitle");
			LOGGER.info("STEP 1: ACTION : Press left button twice and click ok button");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);
			
			LOGGER.info("Click Xfinity right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			Thread.sleep(10000L);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Calling method to check subtitle");
			status = CommonMethods.checkSubtitle();
			
			if (status) {
				LOGGER.info("Subtitle text is shown and status is : " + status);
			} else {
				LOGGER.info("Subtitle text is not shown and status is : " + status);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while verifying disabling subtitle : " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1019");

	}
}
