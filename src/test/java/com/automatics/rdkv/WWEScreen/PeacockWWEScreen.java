package com.automatics.rdkv.WWEScreen;

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


public class PeacockWWEScreen extends AutomaticsTestBase {

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
		 * @author Anusha P
		 * @throws InterruptedException 
		 * 
		 */
		static Process p;
		@Test(priority=9,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1021")
		public void testVerifyWWEScreen(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-121";
			String errorMessage = null;
			String stepNum = null;
			Mat referenceImage;
			BufferedImage liveImage;
			String actual;
			String expected = "WWE";
			BufferedImage subImage;
			
	
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1021");
		LOGGER.info("TEST DESCRIPTION: This test is to verify WWE option present in the menu by using the remote keys");
		LOGGER.info("TEST STEPS :");
		LOGGER.info("1.Press 4 down button from the peacock menu");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to WWE button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify WWE option present in the menu by using the remote keys");
			LOGGER.info("STEP 1: ACTION :compare peacock WWE button with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
			LOGGER.info("*****************************************************************************************");
	

			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			Thread.sleep(3000L);
			
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_WWE_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");

			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_WWE_LIVE_IMAGE));
			
			LOGGER.info("Calling crop method");
			
			subImage = CropImage.cropImage(liveImage, 35,400,250,60);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expected, actual);
			
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
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1021");
	}

	
		@Test(priority=10,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1022")
		public void testVerifyWWETitle(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-122";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			String actual;
			String expected ="Featured";
			BufferedImage subImage;
			// Variables declaration Ends
	
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1022");
		LOGGER.info("TEST DESCRIPTION: This test is to verify Title of the WWE screen ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.click WWE option");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to compare Title of the WWE screen with the live image";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare Title of the WWE screen with the reference image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare Title of the WWE screen with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
			LOGGER.info("*****************************************************************************************");
	
			LOGGER.info("Click WWE option on Peacock menu ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.WWE_TITLE_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.WWE_TITLE_LIVE_IMAGE));
			
            LOGGER.info("Calling crop method");
			

			subImage = CropImage.cropImage(liveImage, 70,380,160,60);
			
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
		@Test(priority=11,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1023")
		public void testVerifyWWEMyStuff(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-123";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			String actual;
			String expected ="My Stuff";
			BufferedImage subImage;
			// Variables declaration Ends
	
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1023");
		LOGGER.info("TEST DESCRIPTION: This test is to verify Title of the WWE screen ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.click WWE option");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to compare Title of the WWE screen with the live image";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare Title of the WWE screen with the reference image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare Title of the WWE screen with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
			LOGGER.info("*****************************************************************************************");
	
			LOGGER.info("Click WWE content ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.WWE_MY_STUFF_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.WWE_MY_STUFF_LIVE_IMAGE));
			
            LOGGER.info("Calling crop method");
			

			subImage = CropImage.cropImage(liveImage, 70,620,160,60);
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1023");

	}
}

	
