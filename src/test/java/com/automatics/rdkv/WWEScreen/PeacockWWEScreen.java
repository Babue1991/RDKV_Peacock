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
import com.automatics.rdkv.constants.IntergerCount;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;

import net.sourceforge.tess4j.Tesseract;


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
		@Test(priority=5,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1041")
		public void testVerifyPeacockMenu(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-041";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage referenceImage;
			BufferedImage liveImage;
			BufferedImage subImage;
			// Variables declaration Ends

			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1041");
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
				referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_SCREEN));

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_LEFTMENU_LIVE_SCREEN);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
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
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1041");

	}
		@Test(priority=9,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1042")
		public void testVerifyWWEScreen(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-042";
			String errorMessage = null;
			String stepNum = null;
//			Mat referenceImage;
			BufferedImage liveImage;
			String actual;
			String expected = "s";

			//String expected ="WWE";
			BufferedImage subImage;
			
	
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1042");
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
	

			LOGGER.info("Click Xfinity down button four times ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.FOUR);
			Thread.sleep(3000L);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_WWE_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");

			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_WWE_LIVE_IMAGE));
			
			LOGGER.info("Calling crop method");
			
			subImage = CropImage.cropImage(liveImage,90,410,80,30);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expected, actual);
			
			LOGGER.info("Calling compare text method");
			
		
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
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1042");
	}

	
		@Test(priority=10,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1043")
		public void testVerifyWWETitle(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-043";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			String actual;
			String expected ="Featured";
			BufferedImage subImage;
			// Variables declaration Ends
	
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1043");
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1043");

	}
		@Test(priority=11,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1044")
		public void testVerifyWWEMyStuff(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-044";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			String actual;
			String expected ="+ My Stuff";
			BufferedImage subImage;
			// Variables declaration Ends
	
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1044");
		LOGGER.info("TEST DESCRIPTION: This test is to verify MyStuff content in WWE screen ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.click WWE option");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to compare Title of the WWE screen with the live image";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify MyStuff content in WWE screen ");
			LOGGER.info("STEP 1: ACTION : ACTION: Launch WWE screen and check MyStuff icon ");
			LOGGER.info("STEP 1: EXPECTED : MyStuff verified successful.");
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1044");

	}
		@Test(priority=12,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1024")
		public void testVerifySubtitle(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-124";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			String actual;
			String expected = "WWE";
			BufferedImage subImage;
			// Variables declaration Ends

			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1024");
			LOGGER.info("TEST DESCRIPTION: This test is to verify subtitle button present in the WWE Content video ");
			LOGGER.info("TEST STEPS : ");
			LOGGER.info("1.click 2 up button and click left button");
			LOGGER.info("#######################################################################################");
			try {
				stepNum = "S1";
				errorMessage = "Failed to compare Title of the subtitle button present in the WWE Content video";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : This test is to verify subtitle button present in the WWE Content video");
				LOGGER.info("STEP 1: ACTION :compare subtitle button with the live image ");
				LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");

				LOGGER.info("Redirecting to Peacock menu screen: ");
				LOGGER.info("Click Xfinity left button ");
				CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
				Thread.sleep(5000L);
				
				nu.pattern.OpenCV.loadLocally();
				

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.WWE_SUBTITLE_BUTTON_LIVE_IMAGE);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.WWE_SUBTITLE_BUTTON_LIVE_IMAGE));
				
	            LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 180,500,200,80);
				
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
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1024");

}
		@Test(priority=13,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1025")
		public void testVerifyEnglishsubtitle(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-125";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			String actual;
			String expected = "WWE";
			BufferedImage subImage;
			// Variables declaration Ends

			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1025");
			LOGGER.info("TEST DESCRIPTION: This test is to verify english subtitle button present in the WWE content video");
			LOGGER.info("TEST STEPS : ");
			LOGGER.info("1.click up button");
			LOGGER.info("#######################################################################################");
			try {
				stepNum = "S1";
				errorMessage = "Failed to compare english subtitle present in the WWE content video";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : This test is to compare english subtitle button present in the WWE content video");
				LOGGER.info("STEP 1: ACTION : compare english subtitle reference image with the live image ");
				LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
				LOGGER.info("*****************************************************************************************");
				
				LOGGER.info("Redirecting to Peacock menu screen: ");
				LOGGER.info("Click Xfinity left button ");
				CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
				Thread.sleep(5000L);
				nu.pattern.OpenCV.loadLocally();

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.WWE_ENGLISH_SUBTITLE_BUTTON_LIVE_IMAGE);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.WWE_ENGLISH_SUBTITLE_BUTTON_LIVE_IMAGE));
				
	            LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 220,460,140,50);
				
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
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1025");

		}
		@Test(priority=14,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-1026")
		public void testVerifySplashforwardbackward(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-126";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage referenceImage;
			BufferedImage liveImage;
			BufferedImage subImage = null;
			// Variables declaration Ends

			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1026");
			LOGGER.info("TEST DESCRIPTION: This test is to verify fast forward button in present in the WWE content video ");
			LOGGER.info("TEST STEPS : ");
			LOGGER.info("1.click Right button");
			LOGGER.info("#######################################################################################");
			try {
				stepNum = "S1";
				errorMessage = "Failed to compare fast forward fast forward button in present in the WWE content video";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : This test is to compare fast forward button in present in the WWE content video");
				LOGGER.info("STEP 1: ACTION :compare fast forward button with the live image ");
				LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
				LOGGER.info("*****************************************************************************************");

				LOGGER.info("switching to the WWE content video");
				LOGGER.info("Click RIGHT_BUTTON");
				CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
				nu.pattern.OpenCV.loadLocally();

				
				LOGGER.info("Reading reference image");
				referenceImage = ImageIO.read(new File(ImageCaptureConstants.WWE_FASTFORWORD));

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.WWE_FASTFORWORD_LIVE_IMAGE);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.WWE_FASTFORWORD_LIVE_IMAGE));

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
				LOGGER.error("Exception while launching home screen file: " + errorMessage);
				CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

			}
			LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1026");
		}


	@Test(priority=15,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1027")
	public void testVerifySplashScreenSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-127";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1027");
		LOGGER.info("TEST DESCRIPTION: This test is to verify Back forward button in present in the WWE content video ");
		LOGGER.info("TEST STEPS : "); 
		LOGGER.info("1.click left button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to compare Back forward  button in present in the WWE content video";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare Back forward button in present in the WWE content video");
			LOGGER.info("STEP 1: ACTION :compare Title of the Back forward with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("switching to the WWE content video");
			LOGGER.info("Click LEFT_BUTTON");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.WWE_BACKFORWORD));

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.WWE_BACKFORWORD_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.WWE_BACKFORWORD_LIVE_IMAGE));
			
			
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
			LOGGER.error("Exception while launching home screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1027");
	}

}
