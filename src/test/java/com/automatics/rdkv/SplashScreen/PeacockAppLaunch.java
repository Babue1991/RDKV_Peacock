package com.automatics.rdkv.SplashScreen;

import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.testng.annotations.Test;

import com.automatics.annotations.TestDetails;
import com.automatics.constants.DataProviderConstants;
import com.automatics.device.Dut;
import com.automatics.rdkb.BroadBandTestGroup;
import com.automatics.rdkb.utils.CommonUtils;
import com.automatics.rdkv.captureimage.CaptureLiveImage;
import com.automatics.rdkv.commonmethods.CommonMethods;
import com.automatics.rdkv.commonmethods.HomeScreenTabSwitch;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;

public class PeacockAppLaunch extends AutomaticsTestBase {

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
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1001")
	public void testVerifySplashScreenSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-101";
		String errorMessage = null;
		String stepNum = null;
		Mat referenceImage;
		Mat liveImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1001");
		LOGGER.info("TEST DESCRIPTION: This test is to verify user can launch peacock app successfully from Xfinity menu using remote keys");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press Xfinity button on the comcast remote");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to launch Xfinity Menu";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can launch peacock app successfully from Xfinity menu using remote keys");
			LOGGER.info("STEP 1: ACTION : ACTION: Press Xfinity button on the comcast remote");
			LOGGER.info("STEP 1: EXPECTED : Xfinity menu should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Redirecting to STB home screen: ");
			LOGGER.info("Click Xfinity button ");
			CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);
			Thread.sleep(5000L);
			nu.pattern.OpenCV.loadLocally();
			LOGGER.info("Taking live screenshot in "+ImageCaptureConstants.XFINITY_HOME_SCREEN);
			CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_HOME_SCREEN);
			Thread.sleep(5000L);
			ImageCompare imgCompare = new ImageCompare();

			referenceImage = Imgcodecs.imread(ImageCaptureConstants.STB_HOME_APPS_BUTTON_IMAGE);
			
			HomeScreenTabSwitch tab = new HomeScreenTabSwitch();
			
			LOGGER.info("Calling apps button click method: ");
			status = tab.clickAppsButton();
			
		
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1010");

	}
	
	@Test(dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
		BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1002")
	public void testVerifyApplicationScreen(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-102";
		String errorMessage = null;
		String stepNum = null;
		Mat referenceImage;
		Mat liveImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1002");
		LOGGER.info("TEST DESCRIPTION: This test is to verify application screen launch");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press Xfinity button on the comcast remote");
		LOGGER.info("#######################################################################################");

		try {
			stepNum = "S1";
			errorMessage = "Failed to Application screen";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can launch application screen using remote keys");
			LOGGER.info("STEP 1: ACTION : ACTION: Take screen shot of the live screen and compare it with reference image");
			LOGGER.info("STEP 1: EXPECTED : Application screen should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Take screenshot in application screen ");
			LOGGER.info(" ");
			nu.pattern.OpenCV.loadLocally();
			LOGGER.info("Reading reference image");
			referenceImage = Imgcodecs.imread(ImageCaptureConstants.STB_APP_TITLE_IMAGE);
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_APPLICATION_SCREEN);
			
			LOGGER.info("Reading live image");
			liveImage = Imgcodecs.imread(ImageCaptureConstants.XFINITY_APPLICATION_SCREEN);
			
			ImageCompare imgCompare =new ImageCompare();
			
			LOGGER.info("Calling screen compare method");

			status = imgCompare.templateMatch(referenceImage, liveImage);
		
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1002");

	}
}



