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
	 * @author Tejaswi KY
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
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1021");
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1021");

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
		String expected = "uesd";
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1022");
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1012");

	}
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1033")
	public void testVerifyMovieScreen(Dut device) throws InterruptedException {
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
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1013");
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1023");

	}

}
