package com.automatics.rdkv.tvshows;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
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
import com.automatics.rdkv.constants.IntergerCount;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;

public class PeacockTVShows extends AutomaticsTestBase {
	
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
	 * @author Babu
	 * @throws InterruptedException 
	 * 
	 */
	static Process p;
	@Test(priority=5,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1031")
	public void testVerifyPeacockMenu(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-031";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1031");
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
			
			LOGGER.info("Reading reference image");
			//referenceImage = Imgcodecs.imread(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_SCREEN);
			 referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_SCREEN));

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

			status = imgCompare.compare(referenceImage, subImage);
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1031");

	}

	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1032")
	public void testVerifyMoviesOption(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-032";
		String errorMessage = null;
		String stepNum = null;
		Mat referenceImage;
		BufferedImage liveImage;
		String actual;
		String expected = "esd";
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1032");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify TV Shows option present in the menu using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Navigate to TV shows option form the Peacock left menu");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to TV Shows button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify TV shows option present in the menu using remote keys");
			LOGGER.info("STEP 1: ACTION : Press down button twice and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : TV Shows option should be there in the menu.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			Thread.sleep(3000L);
			
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			Thread.sleep(3000L);
			
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MENU_TVSHOW_OPTION);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			//liveImage = Imgcodecs.imread(ImageCaptureConstants.PEACOCK_MENU_MOVIE_OPTION);
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MENU_TVSHOW_OPTION));
			
			LOGGER.info("Calling crop method");
			
			subImage = CropImage.cropImage(liveImage, 95,320,120,32);
			
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
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
			LOGGER.error("Exception while launching TV Shows screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1032");

	}
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1033")
	public void testVerifyTVShows(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-033";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		String actual;
		String expected ="Featured TV Shows";
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1033");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to Peacock TV Shows screen using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Click on TV Shows option from Peacock Menu");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to TV Shows section";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can navigate to Peacock TV Shows screen using remote keys");
			LOGGER.info("STEP 1: ACTION : Press ok button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : TV Shows section should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click TV Shows option on Peacock menu ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOW_SCREEN);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");

			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOW_SCREEN));
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1033");

	}
	
	@Test(priority=9, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1034")
	public void testVerifyTVShowsSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-034";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected = "My Stuft";
		String actual;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1034");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock TVShows screen MyStuff icon ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock TVShows screen and verify my stuff icon");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the TVShows My stuff icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the TVShows screen My stuff icon");
			LOGGER.info("STEP 1: ACTION : ACTION: Launch My Shows screen and click ok ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison of my stuff is successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			
			LOGGER.info("Click one LEFT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOWS_MYSTUFF_LIVE_IMAGE);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_MYSTUFF_LIVE_IMAGE));
			
            LOGGER.info("Calling Crop Image method");
			subImage = CropImage.cropImage(liveImage, 130,630,90,50);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expected, actual);
		
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
			LOGGER.error("Exception while searching search screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1034");
	}
	
	@Test(priority=10, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1035")
	public void testVerifySearchResumeSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-035";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected = "Resume";
		String actual;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1035");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock TVShows screen Resume icon ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock TVShows screen and verify Resume icon");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search Resume icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the TVShows screen Resume icon");
			LOGGER.info("STEP 1: ACTION : ACTION: Launch My Shows screen and click right ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison of my Resume is successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one RIGHT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOWS_RESUME_LIVE_IMAGE);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_RESUME_LIVE_IMAGE));
			
            LOGGER.info("Calling Crop Image method");
			subImage = CropImage.cropImage(liveImage, 260,630,80,50);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.partialTextCompare(expected, actual);
		
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
			LOGGER.error("Exception while searching search screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1035");
	}

	@Test(priority=11, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1036")
	public void testVerifyShowsResumeButtonSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-036";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage nextliveImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1036");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock TV Shows screen play content ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock TV Shows screen and verify play content");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to play the video and compare";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the TV Shows screen play content");
			LOGGER.info("STEP 1: ACTION : ACTION: Launch My Shows screen and click ok ");
			LOGGER.info("STEP 1: EXPECTED : content is playing successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture peacock search screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOWS_PLAY_LIVE_IMAGE);
			Thread.sleep(10000L);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_PLAY_LIVE_IMAGE));
			
			LOGGER.info("Capture peacock search screen next live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOWS_PLAY_NEXT_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading next live image"); 
			nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_PLAY_NEXT_LIVE_IMAGE));
			
			LOGGER.info("Calling image compare method");
			ImageCompare imgCompare =new ImageCompare();
			status = imgCompare.compare(liveImage, nextliveImage);
     
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
			LOGGER.error("Exception while playing the video: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1036");
	}
	
	@Test(priority=12, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1037")
	public void testVerifySearchButtonSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-037";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage referenceImage;
		BufferedImage subImage;
		BufferedImage livePauseImage;
		BufferedImage livePauseNextImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1037");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock TV Show screen pause content ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock TV Show screen and verify pause content");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to pause the video and compare";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the TV Show screen pause content");
			LOGGER.info("STEP 1: ACTION : ACTION: Launch My Shows screen and click ok ");
			LOGGER.info("STEP 1: EXPECTED : content is paused successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Capture application screen screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_TVSHOWS_PAUSE_CONTENT);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_PAUSE_CONTENT));
			
			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_REFERENCE_PLAY_ICON));
			
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
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOWS_PAUSE_CONTENT_SCREEN);
			
			LOGGER.info("Reading next live image");
			livePauseImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_PAUSE_CONTENT_SCREEN));
			
			LOGGER.info("Capture after 5seconds application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TVSHOWS_PAUSE_CONTENT_SCREEN_NEXT);
			
			LOGGER.info("Reading next live image");
			livePauseNextImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_PAUSE_CONTENT_SCREEN_NEXT));
			
	        LOGGER.info("Calling image compare method");
            status = imgCompare.compare(livePauseImage, livePauseNextImage);
     
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
			LOGGER.error("Exception while playing the video: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1037");
	}
	
	@Test(priority=13, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1038")
	public void testVerifySearchSubtitleButtonSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-038";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected ="Subtitles";
		String actual;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1038");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock tv shows screen subtile button text");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Click on left button and Up button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify subtitle button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify peacock tv shows screen subtile button text");
			LOGGER.info("STEP 1: ACTION : ACTION: Press left button and click up button ");
			LOGGER.info("STEP 1: EXPECTED : Subtile option should be there");
			LOGGER.info("*****************************************************************************************");
			

			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_TVSHOWS_SUBTITLE_BUTTON);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TVSHOWS_SUBTITLE_BUTTON));
			
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
			LOGGER.error("Exception while playing the video: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1038");
	}
	
	@Test(priority=14,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1039")
	public void testVerifySubtitleText(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-039";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1039");
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
            
			LOGGER.info("Calling disable subtitle to make sure the subtitle is off ");
			CommonMethods.disablesubtitle();
			
			LOGGER.info("Calling enable subtitle method ");
			CommonMethods.enablesubtitle();
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1039");

	}
}
