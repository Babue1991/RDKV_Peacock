package com.automatics.rdkv.PeacockTC;

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
import com.automatics.rdkv.commonmethods.CommonMethods;
import com.automatics.rdkv.commonmethods.GrabText;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ConvertImage;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;

public class PeacockChannel extends AutomaticsTestBase {
	
	/**
	 * String to store the value for resource usage compute window
	 */
	/**
	 * 
	 * This test is to verify user can launch linear channels successfully from Peacock menu using remote keys	 * 
	 * <ol>
	 * <li>Step 1 : Verify the subtitle is displayed successfully or not</li>
	 * </ol>
	 * 
	 * @param device Dut to be used for execution
	 * 
	 * @author Tejaswi KY
	 * @throws InterruptedException 
	 * 
	 */
	static Process p;
	@Test(priority=1,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4008")
	public void testVerifySubtitleIsEnabled(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-008";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4008");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify subtile text");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Enable subtitle and then verify text");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify subtitle text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify subtile text");
			LOGGER.info("STEP 1: ACTION :Enable subtitle and then verify text");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Calling disable subtitle to make sure the subtitle is off ");
			CommonMethods.disableChannelSubtitle();
			
			LOGGER.info("Calling enable subtitle method ");
			CommonMethods.enableChannelSubtitle();
			
			LOGGER.info("Calling method to check subtitle");
			status = CommonMethods.checkSubtitle();
			
			if (status) {
				LOGGER.info("Subtitle text is shown and status is : " + status);
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
			LOGGER.error("Exception while verifying subtitle text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4008");

	}
	@Test(priority=2,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4010")
	public void testVerifyAudioSubtitleSetting(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-010";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4010");
		LOGGER.info("TEST DESCRIPTION:This test is to verify Spanish subtitle text");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Enable spanish lanaguage and verify text");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify Spanish subtitle text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Spanish subtitle text");
			LOGGER.info("STEP 1: ACTION : Enable spanish lanaguage and verify text");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Calling disable subtitle to make sure the subtitle is off ");
			CommonMethods.disableChannelSubtitle();
			
			LOGGER.info("Calling enable subtitle method ");
			CommonMethods.enableChannelSpanishSubtitle();
			
			LOGGER.info("Calling method to check subtitle");
			status = CommonMethods.checkSubtitle();
			
			if (status) {
				LOGGER.info("Subtitle text is shown and status is : " + status);
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
			LOGGER.error("Exception while verifying subtitle text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		try {
			stepNum = "S2";
			errorMessage = "Failed to verify subtitle text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify different audio and subtitle text");
			LOGGER.info("STEP 1: ACTION : Enable english auido and spanish subtitle");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Calling enable audio method");
			CommonMethods.enableChannelAudio();
			
			LOGGER.info("Calling method to check subtitle");
			status = CommonMethods.checkSubtitle();
			
			if (status) {
				LOGGER.info("Spanish subtitle text is shown and status is : " + status);
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
			LOGGER.error("Exception while verifying subtitle text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4010");

	}
	@Test(priority=3,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4011")
	public void testVerifyAds(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-011";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4011");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify ads screen");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Fastforward play and then check for ads");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify ads";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify ads screen");
			LOGGER.info("STEP 1: ACTION : Press fast forward button and play button");
			LOGGER.info("STEP 1: EXPECTED : Ads should be displayed");
			LOGGER.info("*****************************************************************************************");
            
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Click Xfinity right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			Thread.sleep(10000);
			
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			Thread.sleep(3000);
			
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNEL_ADS_TIMER);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNEL_ADS_TIMER));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 68,638,35,35);

			File outputFile = new File("/var/lib/jenkins/workspace/timerimage.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/timerimage.jpg"));
			
			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);
			
			File outputFiletwo = new File("/var/lib/jenkins/workspace/timerimage2.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			String actual = grabText.crackImage(greyImage);
			
			LOGGER.info("Calling method to read number in image");
			status = CommonMethods.checkNumber(actual);
			
			if (status) {
				LOGGER.info("Timer number is : " + status);
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
			LOGGER.error("Exception while verifying subtitle text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4011");

	}
}
