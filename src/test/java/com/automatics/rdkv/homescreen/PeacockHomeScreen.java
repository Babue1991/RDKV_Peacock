package com.automatics.rdkv.homescreen;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.testng.annotations.Test;
import com.automatics.annotations.TestDetails;
import com.automatics.constants.DataProviderConstants;
import com.automatics.device.Dut;
import com.automatics.rdkb.BroadBandTestGroup;
import com.automatics.rdkb.utils.CommonUtils;
import com.automatics.rdkv.STBhomescreen.CropImage;
import com.automatics.rdkv.captureimage.CaptureLiveImage;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;

public class PeacockHomeScreen extends AutomaticsTestBase {

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
	 * @author Babu Eagambaram
	 * @throws InterruptedException 
	 * 
	 */
	

	static Process p;
	@Test(dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1010")
	public void testVerifySplashScreenSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-110";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1003");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock home screen screen ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. compare peacock home reference image with the live image");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to compare reference inage with the live image";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to compare peacock home screen with the reference image");
			LOGGER.info("STEP 1: ACTION : ACTION: compare reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : Image comparision successful.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Take screenshot of peacock home screen: ");
			LOGGER.info(" ");
			nu.pattern.OpenCV.loadLocally();
			LOGGER.info("Reading reference image");
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_HOME_SCREEN);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_HOME_SCREEN));
			
			LOGGER.info("Crop the live image");
			subImage = CropImage.subImage(liveImage, 70,380,380,70);
			
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_HOME_LEFT_HIDDEN_MENU));
			
			
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
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1010");
	}
}

