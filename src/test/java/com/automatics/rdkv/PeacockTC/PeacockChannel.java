package com.automatics.rdkv.PeacockTC;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

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
import com.automatics.rdkv.imagevalidation.ImageCompare;
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
		LOGGER.info("TEST DESCRIPTION:  This test is to verify subtitle text in Linear channels");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Enable subtitle and then verify text");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify subtitle text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION :This test is to verify subtile text in Linear channels");
			LOGGER.info("STEP 1: ACTION :Enable subtitle and then verify text");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channel ");
			CommonMethods.navigateToChannelSeven();

			Thread.sleep(2000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

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

			LOGGER.info("Calling method to navigate to linear channel ");
			CommonMethods.navigateToChannelFour();

			Thread.sleep(2000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

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


			LOGGER.info("Calling method to navigate to linear channel ");
			CommonMethods.navigateToChannelSeven();

			Thread.sleep(2000);

			LOGGER.info("Selecting the channel");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(30000);

			LOGGER.info("Click Ok button to see progress bar");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
			
			Thread.sleep(10000);

			LOGGER.info("Click Xfinity right button to fastward the video ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

			LOGGER.info("Multiplying the speed with 6x ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Multiplying the speed with 12x ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(10000);

			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Click Xfinity OK button to play the video");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(5000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Capturing the live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNEL_ADS_TIMER);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNEL_ADS_TIMER));

			LOGGER.info("Cropping the image with give hieght and width 68,638,35,35");
			subImage = CropImage.cropImage(liveImage, 68,638,35,35);

			LOGGER.info("Saving the cropped image in /var/lib/jenkins/workspace/timerimage.jpg");
			File outputFile = new File("/var/lib/jenkins/workspace/timerimage.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			LOGGER.info("Reading the saved live image /var/lib/jenkins/workspace/timerimage.jpg");
			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/timerimage.jpg"));

			LOGGER.info("Converting the image into grey scale");
			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			LOGGER.info("String the converted grey scale image to /var/lib/jenkins/workspace/timerimage2.jpg");
			File outputFiletwo = new File("/var/lib/jenkins/workspace/timerimage2.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Grab the advertisement duration from the grey scale image");
			GrabText grabText = new GrabText();
			String actual = grabText.crackNumber(greyImage);

			LOGGER.info("Calling method to check number in image");
			status = CommonMethods.checkNumber(actual);

			if (status) {
				LOGGER.info("Timer has number : " + status);
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
			LOGGER.error("Exception while verifying ads: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4011");

	}
	@Test(priority=4,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4012")
	public void testVerifyContentToAds(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-012";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4012");
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


			LOGGER.info("Calling method to navigate to linear channel ");
			CommonMethods.navigateToChannelFour();

			Thread.sleep(2000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

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
			String actual = grabText.crackNumber(greyImage);

			LOGGER.info("Calling method to read number in image");
			status = CommonMethods.checkNumber(actual);

			if (status) {
				LOGGER.info("Timer has number: " + status);
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
			LOGGER.error("Exception while verifying ads: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4012");

	}
	@Test(priority=5,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4013")
	public void testVerifyLongTermStability(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-013";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected = "NoW";
		String actual;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4013");
		LOGGER.info("TEST DESCRIPTION:This test is to verify Long term stability of linear channels");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Tune to  linear channels  which plays true linear content");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify linear channels";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Long term stability of linear channels");
			LOGGER.info("STEP 1: ACTION : Tune to  linear channels  which plays true linear content");
			LOGGER.info("STEP 1: EXPECTED : Peacock Linear channel should continue to play without any AV issue for about 2 mins");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channels ");
			CommonMethods.navigateToLinearChannel();

			Thread.sleep(3000);

			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
			
			Thread.sleep(2000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_NOW);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_NOW));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 97,390,60,25);

			File outputFile = new File("/var/lib/jenkins/workspace/linear.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/linear.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/linear2.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImage);

			LOGGER.info("Calling method to compare text in image");

			status = CommonMethods.partialTextCompare(expected, actual);

			if (status) {
				LOGGER.info("Channel playing with no AV issues : " + status);
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
			LOGGER.error("Exception while verifying linear channel: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("2. Play linear channel content for  2 mins");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S2";
			errorMessage = "Failed to  play linear channel content for  2 mins";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 2: DESCRIPTION : Play linear channel content for  2 mins");
			LOGGER.info("STEP 2: ACTION : Tune to  linear channels  which plays true linear content");
			LOGGER.info("STEP 2: EXPECTED : Peacock Linear channel should continue to play without any AV issue for about 2 mins");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

			TimeUnit. MINUTES. sleep(1);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_NOW);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_NOW));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 98,390,60,25);

			File outputFile = new File("/var/lib/jenkins/workspace/linear.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/linear.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/linear2.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImage);

			LOGGER.info("Calling method to read number in image");

			status = CommonMethods.textCompare(expected, actual);

			if (status) {
				LOGGER.info("Channel playing with no AV issues : " + status);
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
			LOGGER.error("Exception while verifying linear channel: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4013");

	}
	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4027")
	public void testVerifyMovieAssetTransition(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-027";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected;
		String actual;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4027");
		LOGGER.info("TEST DESCRIPTION: This test is to verify movie asset transition");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Fast forward movie and check for next movie to play");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify asset transition";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION :  This test is to verify movie asset transition");
			LOGGER.info("STEP 1: ACTION : Fast forward movie and check for next movie to play");
			LOGGER.info("STEP 1: EXPECTED : Movie should continue to play without any issues");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity button ");
			CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);

			Thread.sleep(3000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(3000);

			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

			Thread.sleep(2000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(30000);

			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(3000);

			LOGGER.info("Click Xfinity down button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(5000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			//Thread.sleep(10000);
			TimeUnit. MINUTES. sleep(1);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity Right button 3 times to fast forward ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.RIGHT_BUTTON,3);

			Thread.sleep(20000);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_MOVIE_ASSET_TRANSITION);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_ASSET_TRANSITION));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 1052,530,120,100);

			File outputFile = new File("/var/lib/jenkins/workspace/nextasset.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			expected = grabText.crackImage(subImage);

			TimeUnit. MINUTES. sleep(1);

			//Thread.sleep(10000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_MOVIE_NEXT_ASSET_TRANSITION);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_NEXT_ASSET_TRANSITION));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 98,54,400,50);

			LOGGER.info("Calling method to read text in image");
			actual = grabText.crackImage(subImage);

			LOGGER.info("Calling method to compare text in image");

			status = CommonMethods.partialTextCompare(expected, actual);

			if (status) {
				LOGGER.info("Asset transition successfull : " + status);
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
			LOGGER.error("Exception while verifying linear channel: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4027");

	}
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4026")
	public void testVerifyPreviousEpisodeContents(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-026";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected;
		String actual;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4026");
		LOGGER.info("TEST DESCRIPTION: Verify Previous/Next functionality  in Linear channels which supports multi episode contents");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Tune to  linear channels  which has multiple episodes");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify multi episode contents";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : Verify Previous/Next functionality  in Linear channels which supports multi episode contents");
			LOGGER.info("STEP 1: ACTION :Tune to  linear channels  which has multiple episodes");
			LOGGER.info("STEP 1: EXPECTED : Peacock Linear channel should continue to play without any AV issues");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channels");
			CommonMethods.navigateToChannelFour();

			Thread.sleep(3000);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_EPISODES);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_EPISODES));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 210,395,425,50);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			expected = grabText.crackImage(subImage);

			Thread.sleep(5000);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity left button twice");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.LEFT_BUTTON,2);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			TimeUnit. MINUTES. sleep(2);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity Down button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_PREVIOUS_EPISODE);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_PREVIOUS_EPISODE));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 210,395,425,50);

			File outputFile = new File("/var/lib/jenkins/workspace/preepisode.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/preepisode.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/greyepisode.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			actual = grabText.crackImage(greyImage);

			LOGGER.info("Calling method to compare text in image");

			status = CommonMethods.partialTextCompare(expected, actual);

			if (status) {
				LOGGER.info("Channel playing with no AV issues : " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while verifying linear channel: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}

		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4026");

	}

	@Test(priority=8,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4028")
	public void testVerifyMultiEpisodeContents(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-028";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String expected;
		String actual;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4028");
		LOGGER.info("TEST DESCRIPTION: Test verify next episode transition functionality  in Linear channels which supports multi episode contents");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Tune to  linear channels  which has multiple episodes");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify multi episode contents";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : Test verify next episode transition functionality  in Linear channels which supports multi episode contents");
			LOGGER.info("STEP 1: ACTION :Tune to  linear channels  which has multiple episodes");
			LOGGER.info("STEP 1: EXPECTED : Peacock Linear channel should continue to play without any AV issues");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channels");
			CommonMethods.navigateToChannelFour();

			Thread.sleep(2000);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PLCHANNEL_EPISODES);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PLCHANNEL_EPISODES));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 820,395,425,60);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			expected = grabText.crackImage(subImage);

			Thread.sleep(5000);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

			LOGGER.info("Click Xfinity right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			TimeUnit. MINUTES. sleep(2);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity Down button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

			Thread.sleep(2000);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_NEXT_EPISODE);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNEL_NEXT_EPISODE));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 450,395,475,50);

			File outputFile = new File("/var/lib/jenkins/workspace/nextepisode.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/nextepisode.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/greyepisode.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			actual = grabText.crackImage(greyImage);

			LOGGER.info("Calling method to compare text in image");

			status = CommonMethods.partialTextCompare(expected, actual);

			if (status) {
				LOGGER.info("Channel playing with no AV issues : " + status);
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
			LOGGER.error("Exception while verifying linear channel: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}

		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4028");

	}
	@Test(priority=9,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4024")
	public void testVerifyTrickPlayAds(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-024";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage referenceImage;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4024");
		LOGGER.info("TEST DESCRIPTION: Test Verify Trick Play operations during Ads");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Tune to  linear channels  which has ads");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify trick play(pause) operations";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : Test Verify Trick Play operations during Ads");
			LOGGER.info("STEP 1: ACTION :Tune to  linear channels  which has ads");
			LOGGER.info("STEP 1: EXPECTED : FFWD/RWD functionalities should not work when Ad is in progress");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channels");
			CommonMethods.navigateToChannelFour();

			Thread.sleep(2000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(20000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(15000);

			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(3000);

			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(3000);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PLC_ADS_TP_PAUSE_REF);

			LOGGER.info("Reading first live ads screen");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PLC_ADS_TP_PAUSE_REF));

			Thread.sleep(5000);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PLC_ADS_TP_PAUSE_LIVE);

			LOGGER.info("Reading second live ads screen");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PLC_ADS_TP_PAUSE_LIVE));

			LOGGER.info("Calling image compare method");

			ImageCompare imgCompare =new ImageCompare();

			status = imgCompare.compare(referenceImage, liveImage);

			if (status) {
				LOGGER.info("Ads puase option verified : " + status);
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
			LOGGER.error("Exception while verifying linear channel: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}

		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4024");

	}
	@Test(priority=10,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4022")
	public void testVerifySubtitleSLEAsset(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-022";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4022");
		LOGGER.info("TEST DESCRIPTION: This test is to verify subtile text for SLE asset");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Enable subtitle and then verify text");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify subtitle text";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify subtile text for SLE asset");
			LOGGER.info("STEP 1: ACTION :Enable subtitle and then verify text");
			LOGGER.info("STEP 1: EXPECTED : Subtitle should displayed");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channel ");
			CommonMethods.navigateToSLE();

			TimeUnit. MINUTES. sleep(2);

			LOGGER.info("Calling disable subtitle to make sure the subtitle is off ");
			CommonMethods.disableSLEAssetSubtitle();

			LOGGER.info("Calling enable subtitle method ");
			CommonMethods.enableSLEAssetSubtitle();

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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4022");

	}
	@Test(priority=11,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-4019")
	public void testVerifyLiveEdgeSLEAsset(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-019";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String actual;
		String expected = "co uive";
		String expectedLive = "Live";
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-4019");
		LOGGER.info("TEST DESCRIPTION: This test is to Seek to Live Edge verification on Peacock SLE asset");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Perform Rewind operation at until Live edge indicator is off");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify Go Live icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to Seek to Live Edge verification on Peacock SLE asset");
			LOGGER.info("STEP 1: ACTION : Perform Rewind operation at until Live edge indicator is off");
			LOGGER.info("STEP 1: EXPECTED : Go Live icon should be enabled");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Calling method to navigate to linear channel ");
			CommonMethods.navigateToSLE();

			TimeUnit. MINUTES. sleep(2);

			LOGGER.info("Calling rewind method ");
			CommonMethods.rewindSLE();

			TimeUnit. MINUTES. sleep(1);


			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

			Thread.sleep(2000L);

			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

			Thread.sleep(2000L);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_SLE);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SLE));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage,  98,575,67,35);

			File outputFile = new File("/var/lib/jenkins/workspace/golive.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/golive.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/greygolive.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			BufferedImage greyImageOutput = ImageIO.read(new File("/var/lib/jenkins/workspace/greygolive.jpg"));

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImageOutput);

			LOGGER.info("Calling method to compare text in image");
			status = CommonMethods.partialTextCompare(expected, actual);
			
			if (status) {
				LOGGER.info("Go Live icon is shown and status is : " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while verifying go live text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		try {
			stepNum = "S2";
			errorMessage = "Failed to verify Live icon";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to Seek to Live Edge verification on Peacock SLE asset");
			LOGGER.info("STEP 1: ACTION : Seek to Live edge position by pressing on the Go Live icon near subtitles");
			LOGGER.info("STEP 1: EXPECTED :Live icon near title should be enabled");
			LOGGER.info("*****************************************************************************************");

			TimeUnit. MINUTES. sleep(2);

			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

			Thread.sleep(2000L);

			LOGGER.info("Click Xfinity up button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);
			
			Thread.sleep(2000L);

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			Thread.sleep(2000L);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_SLE_LIVE);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SLE_LIVE));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage,  598,65,45,20);

			File outputFile = new File("/var/lib/jenkins/workspace/slelive.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/slelive.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/greylive.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			BufferedImage greyImageOutput = ImageIO.read(new File("/var/lib/jenkins/workspace/greylive.jpg"));

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImageOutput);

			LOGGER.info("Calling method to compare text in image");
			status = CommonMethods.partialTextCompare(expectedLive, actual);
			
			if (status) {
				LOGGER.info("Live icon is shown and status is : " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while verifying live text: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-4019");

	}


}
