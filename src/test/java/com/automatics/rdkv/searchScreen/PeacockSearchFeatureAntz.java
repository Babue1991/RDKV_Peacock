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

public class PeacockSearchFeatureAntz extends AutomaticsTestBase {

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
	@Test(priority=9, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1009")
	public void testVerifySplashScreenSTB(Dut device) throws InterruptedException {
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
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1007");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search feature ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock home screen and press Left_button and press up");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to get the search icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare search feature verification reference image with the live image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search feature reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparison successful.");
			LOGGER.info("*****************************************************************************************");
			
			/*
			 * LOGGER.info("Click one LEFT_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			 * 
			 * LOGGER.info("Click one UP_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			 * 
			 * LOGGER.info("Click one OK_BUTTON ");
			 * CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			 */
			
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
	@Test(priority=52, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1052")
	public void testVerifySearchResumeButtonSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-152";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage nextliveImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1052");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search screen play content ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock search screen and verify play content");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to play the video and compare";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the search screen play content");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search screen play content reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : content is playing successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one OK_BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture peacock search screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_PLAY_LIVE_IMAGE);
			Thread.sleep(10000L);
			
			LOGGER.info("Reading live image"); 
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_PLAY_LIVE_IMAGE));
			
			LOGGER.info("Capture peacock search screen next live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_PLAY_NEXT_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading next live image"); 
			nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_PLAY_NEXT_LIVE_IMAGE));
			
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
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1052");
	}
	
	
}