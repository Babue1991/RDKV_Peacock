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
		/*
		 * BufferedImage cropImage; Mat compare;
		 */
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1006");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search button menu is highlighted ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Launch peacock home screen and press Left_button and press up");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify peacock search button menu is highlighted";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare peacock search button with the reference image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare peacock search menu button with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison successful.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Redirecting to Peacock menu screen: ");
			LOGGER.info("Click one LEFT_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
	        //Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Click one UP_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			
			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BUTTON_HIGHLIGHT);
			
			LOGGER.info("Capture peacock home screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_BUTTON_HIGHLIGHT_LIVE);
			
			LOGGER.info("Reading live image");
			liveImage =  ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BUTTON_HIGHLIGHT_LIVE));
			
            LOGGER.info("Calling Crop Image method");
			
			subImage = CropImage.cropImage(liveImage, 40,170,240,60);
			
            ImageCompare imgCompare =new ImageCompare();
			
			LOGGER.info("Calling screen compare method");

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
		Mat referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		BufferedImage cropImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1007");
		LOGGER.info("TEST DESCRIPTION: This test is to verify search bar screen ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock home screen and press Left_button and press up ");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare search bar reference image with the live image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search bar reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison successful.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Crop the reference image from the search bar menu");
			
			/*
			 * LOGGER.info("Click one LEFT_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			 * 
			 * LOGGER.info("Click one UP_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			 */
			
			LOGGER.info("Click OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			
			LOGGER.info("Capture peacock search screen live image ");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_BAR_LIVE_IMAGE);	
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_BAR_LIVE_IMAGE));
			
			LOGGER.info("Croping the live search keyboard image");
		    subImage = CropImage.cropImage(liveImage, 80,100,1180,180);
			
			LOGGER.info(" ");
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Reading reference image");
			referenceImage = Imgcodecs.imread(ImageCaptureConstants.PEACOCK_SEARCH_BAR);
			
			ImageCompare imgCompare =new ImageCompare();
			
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
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1008");
		LOGGER.info("TEST DESCRIPTION: This test is to verify search bar screen ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock home screen and press Left_button and press up");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare search bar reference image with the live image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search bar reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Crop the reference image from the search bar menu");
			
			/*
			 * LOGGER.info("Click one LEFT_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			 * 
			 * LOGGER.info("Click one UP_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			 */
			
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
		    
			/*
			 * LOGGER.info(" "); nu.pattern.OpenCV.loadLocally();
			 * 
			 * LOGGER.info("Reading reference image"); referenceImage =
			 * Imgcodecs.imread(ImageCaptureConstants.PEACOCK_SEARCH_BAR_TEXT);
			 */
		
		
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
}