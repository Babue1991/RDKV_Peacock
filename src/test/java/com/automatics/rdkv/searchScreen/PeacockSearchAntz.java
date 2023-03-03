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

	// step 1 and step 2 are same as TC-2002
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2003")
	public void testVerifyChannelOption(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-203";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage outputImage;
		BufferedImage nextliveImage;
		BufferedImage subImage;
		// Variables declaration Ends
		/**
	     * Step 3 : Tune to all linear channels and verify
	     */
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2003");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify all the linear channels");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press down button and click ok");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S3";
			errorMessage = "Failed to verify linear channels";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify all the linear channels");
			LOGGER.info("STEP 1: ACTION : Press down button and click ok");
			LOGGER.info("STEP 1: EXPECTED : Linear channels verified successfully.");
			LOGGER.info("*****************************************************************************************");	
			
			for(int i=0; i<=3; i++) {
				//Total number of channels is 63
				//as of now i have taken i=3
				LOGGER.info("Click two DOWN_BUTTON ");
				CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
				Thread.sleep(1000);
				
				LOGGER.info("Click Xfinity OK button ");
				CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
				Thread.sleep(2000);
				
				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TUNE_VERIFY);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TUNE_VERIFY));
				
				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_NEXT_TUNE_VERIFY);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
				nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_NEXT_TUNE_VERIFY));
				
				LOGGER.info("Calling image compare method");
				ImageCompare imgCompare =new ImageCompare();
				status = imgCompare.compare(liveImage, nextliveImage);
			}
		
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
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2003");
}
	}
