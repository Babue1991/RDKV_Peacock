package com.automatics.rdkv.searchScreen;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
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
import com.automatics.rdkv.commonmethods.HomeScreenTabSwitch;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.IntergerCount;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;

public class PeacockSearchMenu extends AutomaticsTestBase {

	/**
	 * String to store the value for resource usage compute window
	 */
	/**
	 * 
	 * This test is to verify user can launch peacock app successfully from Xfinity menu using remote keys	 * 
	 * <ol>
	 * <li>Step 1 : Verify the Xfinity menu is getting launched successfully or not</li>
	 * </ol>
	 * 
	 * @param device Dut to be used for execution
	 * 
	 * @author Babitha
	 * @throws InterruptedException 
	 * 
	 */
	

	static Process p;
	@Test(priority=6, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1006")
	public void testVerifySearchMenu(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-106";
		String errorMessage = null;
		String stepNum = null;
	    BufferedImage referenceImage;
	    BufferedImage liveImage;
		BufferedImage subImage;
		String actual;
		String expected = "Ees";

		/*
		 * BufferedImage cropImage; Mat compare;
		 */
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1006");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search button is highlighted ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Launch peacock application and press Left_button and UP_BUTTON");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify peacock search button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to read peacock search button text");
			LOGGER.info("STEP 1: ACTION : ACTION: crop and read the search button icon");
			LOGGER.info("STEP 1: EXPECTED : Search text read successful.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BUTTON_HIGHLIGHT));
			
			LOGGER.info("Redirecting to Peacock menu screen: ");
			
			LOGGER.info("Click one LEFT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
	        //Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Click one UP_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_BUTTON_HIGHLIGHT_LIVE);
			
			LOGGER.info("Reading live image");
			liveImage =  ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BUTTON_HIGHLIGHT_LIVE));
			
            LOGGER.info("Calling Crop Image method");
			subImage = CropImage.cropImage(liveImage, 95,185,120,32);
			
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
			LOGGER.error("Exception while launching search screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1006");
	}
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1007")
	public void testVerifySearchScreenKeyboard(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-107";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		BufferedImage cropImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1007");
		LOGGER.info("TEST DESCRIPTION: This test is to verify search screen keyboard ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock application and press Left_button and UP_BUTTON ");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search screen keyboard";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare search keyboard screen reference image with the live image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search keyboard screen reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Redirecting to Peacock search screen: ");
			LOGGER.info("Click OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BAR));
			
			LOGGER.info("Capture peacock search screen live image ");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_BAR_LIVE_IMAGE);	
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BAR_LIVE_IMAGE));
			
			LOGGER.info("Croping the live search keyboard image");
		    subImage = CropImage.cropImage(liveImage, 80,100,1180,180);
		    
		    File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			ImageCompare imgCompare =new ImageCompare();
			status = imgCompare.compare(referenceImage, subImage);
			LOGGER.info("Calling screen compare method");
		
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
			LOGGER.error("Exception while launching search screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1007");
		
	}
	@Test(priority=8, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1008")
	public void testVerifySplashScreenSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-108";
		String errorMessage = null;
		String stepNum = null;
		String actual;
		String expected = "Popular Searches";
		BufferedImage liveImage;
		BufferedImage referenceImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1008");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search screen text");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock application screen and press Left_button and UP_BUTTON");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the peacock search screen text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify search screen text");
			LOGGER.info("STEP 1: ACTION : ACTION: verify search screen text with the live image ");
			LOGGER.info("STEP 1: EXPECTED : verification of search screen text is successful.");
			LOGGER.info("*****************************************************************************************");
			
			 LOGGER.info("Reading reference image"); 
			 referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BAR_TEXT));
			
			LOGGER.info("Capture peacock search screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCHBAR_TEXT_LIVE_IMAGE);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCHBAR_TEXT_LIVE_IMAGE));
			
			LOGGER.info("Croping the live search image");
		    subImage = CropImage.cropImage(liveImage, 100,280,380,50);
		    
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
			LOGGER.error("Exception while launching home screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1008");
	}
	
	@Test(priority=9, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1009")
	public void testVerifySearchScreenSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-109";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		BufferedImage cropImage;
		BufferedImage outputImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1009");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search feature ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock application and press Left_button and UP_BUTTON");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify peacock search feature";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify search feature in the search screen");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search feature reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one DOWN_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Click five RIGHT_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.RIGHT_BUTTON, IntergerCount.FIVE);
			
			LOGGER.info("Click one DOWN_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Click one LEFT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click two UP_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.UP_BUTTON, IntergerCount.TWO);
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Click four LEFT_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.LEFT_BUTTON, IntergerCount.FOUR);
			
			LOGGER.info("Click two DOWN_BUTTON");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			LOGGER.info("ANTZ");
			
			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_FEATURE));
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_FEATURE_LIVE_IMAGE);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_FEATURE_LIVE_IMAGE));
			Thread.sleep(5000L);
			
            LOGGER.info("Calling Crop Image method");
			subImage = CropImage.cropImage(liveImage, 90,340,290,180);
			
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
			
			ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare(referenceImage, outputImage);

		
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
			LOGGER.error("Exception while searching feature screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1009");
	}
	
	
	
	@Test(priority=10, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1010")
	public void testVerifySearchSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-110";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		BufferedImage cropImage;
		BufferedImage outputImage;
		String expected = "My Stuft";
		String actual;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1010");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search screen My stuff icon ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock search screen and verify my stuff icon");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search My stuff icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the search screen My stuff icon");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search screen my stuff reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison of my stuff is successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click two DOWN_BUTTON");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			
			LOGGER.info("Click one LEFT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_MYSTUFF_LIVE_IMAGE);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_MYSTUFF_LIVE_IMAGE));
			
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
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1010");
	}
	
	@Test(priority=51, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1051")
	public void testVerifySearchResumeSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-151";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected = "Resume";
		String actual;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1051");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search screen Resume icon ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock search screen and verify Resume icon");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search Resume icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the search screen Resume icon");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search screen Resume reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison of my Resume is successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one RIGHT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_RESUME_LIVE_IMAGE);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_RESUME_LIVE_IMAGE));
			
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
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1051");
	}
	
}

