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
	
	@Test(priority=5,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1005")
	public void testVerifyPeacockMenu(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-005";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1005");
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
			 referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LEFTMENU_REFERENCE_IMAGE));

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_LEFTMENU_LIVE_IMAGE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LEFTMENU_LIVE_IMAGE));
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1005");

	}
		
	
}