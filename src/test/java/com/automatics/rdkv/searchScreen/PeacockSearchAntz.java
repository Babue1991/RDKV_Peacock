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

public class PeacockSearchAntz extends AutomaticsTestBase {

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
	
	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2002")
	public void testVerifyMoviesOption(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-202";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage outputImage;
		BufferedImage subImage;
		// Variables declaration Ends
		/**
	     * Step 1 : Go to channel option in peacock menu and press ok
	     */
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2002");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to the channels content");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left button and go down");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to Channels button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can navigate to the channels content");
			LOGGER.info("STEP 1: ACTION : Press down button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Channels option should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNEL_VERIFY));
			
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click six DOWN_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.SIX);
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Click four down button ");
		//	CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.FOUR);
			
			LOGGER.info("Capture Channels screen live image");
		    CaptureLiveImage.capture2(ImageCaptureConstants.PEACOCK_CHANNELS_OPTION,RemoteKeyContstants.DOWN_BUTTON,IntergerCount.EIGHT);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_OPTION));
			
			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 750,400,60,120);
			
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
			
			ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare(referenceImage, outputImage);
		
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
	}
}
//	/**
//     * Step 2 : Tune to couple of other linear channels randomly
//     */
//	LOGGER.info("#######################################################################################");
//	LOGGER.info("TEST DESCRIPTION:  This test is to Tune to couple of other linear channels randomly and verify");
//	LOGGER.info("TEST STEPS : ");
//	LOGGER.info("1. Press up button and verify");
//	LOGGER.info("#######################################################################################");
//	try {
//		stepNum = "S2";
//		errorMessage = "Failed to tune other linear channel";
//		LOGGER.info("*****************************************************************************************");
//		LOGGER.info("STEP 2: DESCRIPTION : This test is to Tune to couple of other linear channels randomly and verify");
//		LOGGER.info("STEP 2: ACTION : Press up button and verify");
//		LOGGER.info("STEP 2: EXPECTED : Linear Channels option verified successfully.");
//		LOGGER.info("*****************************************************************************************");
//
//		
//		LOGGER.info("Reading reference image");
//		referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TUNE_CHANNELS_VERIFY));
//		
//		LOGGER.info("Click two DOWN_BUTTON ");
//		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
//		
//		LOGGER.info("Click Xfinity ok button ");
//		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
//		Thread.sleep(10000);
//		nu.pattern.OpenCV.loadLocally();
//		
//		LOGGER.info("Click Xfinity right button ");
//		//CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
//
//		
//		LOGGER.info("Capture Channels screen live image");
//		CaptureLiveImage.capture2(ImageCaptureConstants.PEACOCK_CHANNELS_TUNE_VERIFY,RemoteKeyContstants.RIGHT_BUTTON,IntergerCount.ONE);
//		Thread.sleep(5000L);
//		
//		LOGGER.info("Reading live image");
//		liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_TUNE_VERIFY));
//		
//		LOGGER.info("Calling crop method");
//		subImage = CropImage.cropImage(liveImage, 620,630,40,44);
//		
//		File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
//		ImageIO.write(subImage, "jpg", outputFile);
//		
//		outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
//		
//		ImageCompare imgCompare =new ImageCompare();
//		LOGGER.info("Calling screen compare method");
//		status = imgCompare.compare(referenceImage, outputImage);
//	
//		if (status) {
//			LOGGER.info("The status of text comparision is: " + status);
//		} else {
//			LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
//		}
//		LOGGER.info("**********************************************************************************");
//		tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);
//
//	} catch (Exception e) {
//		LOGGER.error("Exception occured while reading the image file " + e);
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		LOGGER.info("Inside catch");
//		errorMessage = e.getMessage();
//		LOGGER.error("Exception while launching movie screen: " + errorMessage);
//		CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
//
//	}
//	LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2002");
//}
//	// step 1 and step 2 are same as TC-2002
//	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
//			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
//	@TestDetails(testUID = "PEACOCK-AAMP-TC-2003")
//	public void testVerifyChannelOption(Dut device) throws InterruptedException {
//		// Variables declaration starts
//		boolean status = false;
//		String testId = "PEACOCK-AAMP-TC-203";
//		String errorMessage = null;
//		String stepNum = null;
//		BufferedImage referenceImage;
//		BufferedImage liveImage;
//		BufferedImage outputImage;
//		BufferedImage subImage;
//		// Variables declaration Ends
//		/**
//	     * Step 3 : Tune to all linear channels and verify
//	     */
//		LOGGER.info("#######################################################################################");
//		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2003");
//		LOGGER.info("TEST DESCRIPTION:  This test is to verify all the linear channels");
//		LOGGER.info("TEST STEPS : ");
//		LOGGER.info("1. Press down button and click ok");
//		LOGGER.info("#######################################################################################");
//		try {
//			stepNum = "S3";
//			errorMessage = "Failed to verify linear channels";
//			LOGGER.info("*****************************************************************************************");
//			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify all the linear channels");
//			LOGGER.info("STEP 1: ACTION : Press down button and click ok");
//			LOGGER.info("STEP 1: EXPECTED : Linear channels verified successfully.");
//			LOGGER.info("*****************************************************************************************");
//			
//			LOGGER.info("Reading reference image");
//			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_REF_IMG_VERIFY));
//			
//			LOGGER.info("Click Xfinity up button ");
//			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
//			
//			LOGGER.info("Click Xfinity down button ");
//			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.SIX);
//			
//			LOGGER.info("Click Xfinity ok button ");
//			LOGGER.info("Capture Channels screen live image");
//		    CaptureLiveImage.capture2(ImageCaptureConstants.PEACOCK_LINEAR_OPTION,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
//		    Thread.sleep(10000L);
//		    nu.pattern.OpenCV.loadLocally();
//			
//			LOGGER.info("Reading live image");
//			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_OPTION));
//			
//			LOGGER.info("Calling crop method");
//			subImage = CropImage.cropImage(liveImage, 530,630,250,44);
//			
//			for(int i=0; i<=3; i++) {
//				if(referenceImage!=null)
//				{
//					LOGGER.info("It is an Linear channel ");
//				}
//					else {
//						LOGGER.info("It is not Linear channel ");
//		}
//	}
//			
//			//Should add for loop to check whether it is linear channel or not
//			
//			
//			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
//			ImageIO.write(subImage, "jpg", outputFile);
//			
//			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
//			
//			ImageCompare imgCompare =new ImageCompare();
//			LOGGER.info("Calling screen compare method");
//			status = imgCompare.compare(referenceImage, outputImage);
//		
//			if (status) {
//				LOGGER.info("The status of text comparision is: " + status);
//			} else {
//				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
//			}
//			LOGGER.info("**********************************************************************************");
//			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);
//
//		} catch (Exception e) {
//			LOGGER.error("Exception occured while reading the image file " + e);
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			LOGGER.info("Inside catch");
//			errorMessage = e.getMessage();
//			LOGGER.error("Exception while launching movie screen: " + errorMessage);
//			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
//
//		}
//		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2003");
//}
	//}
