package com.automatics.rdkv.PeacockTC;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
import com.automatics.rdkv.imagevalidation.ConvertImage;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;


public class TrickPlayVerification extends AutomaticsTestBase {

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
	@Test(priority=11, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-3001")
	public void testVerifyTrickPlayVerification(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-301";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String actual;
		String actualLinear;
		// Variables declaration Ends

		/**
		 * Step 2 :using appropriate keys on remote,go to channels option in the peacock menu and press OK
		 */
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to the channels content");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left button and go six down");

		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to Channels button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 2: DESCRIPTION : This test is to verify user can navigate to the channels content");
			LOGGER.info("STEP 2: ACTION : Press down button and take screenshot");
			LOGGER.info("STEP 2: EXPECTED : Channels option should launch successfully.");
			LOGGER.info("*****************************************************************************************");


			LOGGER.info("Calling method to launch peacock app");
			CommonMethods.launchPeacockApp();

			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Click six DOWN_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.SIX);

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNELS_OPTION);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_OPTION));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 200,400,80,40);

			File outputFile = new File("/var/lib/jenkins/workspace/channelsSection.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/channelsSection.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/channelsSection2.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImage);

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(10000);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);


			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_OPTION);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_OPTION));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 50,450,115,40);

			GrabText grabTextLinear = new GrabText();
			actualLinear = grabTextLinear.crackImage(subImage);
			status = CommonMethods.partialTextCompare(actualLinear, actual);

			if (status) {

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


		/**
		 * Step 3 :Tune to linear channels which support trick play
		 */

<<<<<<< HEAD
		static Process p;
		@Test(priority=11, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-3001")
		public void testVerifyTrickPlayVerification(Dut device) throws InterruptedException {
			// Variables declaration starts
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-301";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage liveImage;
			BufferedImage subImage;
			String actual;
			String actualLinear;
			// Variables declaration Ends
   
			/**
		     * Step 1 and 2 :  Launch Peacock app and using appropriate keys on remote,go to channels option in the peacock menu and press OK
		     */
			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
			LOGGER.info("TEST DESCRIPTION:  This test is to verify Using appropriate keys on remote, go to Channels option in the Peacock menu and press OK");
			LOGGER.info("TEST STEPS : ");
			LOGGER.info("1. Press left button and go six down");
			
			try {
				stepNum = "S1";
				errorMessage = "Failed to navigate to Channels button";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Using appropriate keys on remote, go to Channels option in the Peacock menu and press OK");
				LOGGER.info("STEP 1: ACTION : Press left button and go six down");
				LOGGER.info("STEP 1: EXPECTED : Control should tune successfully to the first available Peacock linear channel in the channel list without any AV issues");
				LOGGER.info("*****************************************************************************************");
				
				
				LOGGER.info("Calling method to launch peacock app");
				CommonMethods.launchPeacockApp();
			
				LOGGER.info("Click Xfinity left button ");
				CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

				LOGGER.info("Click six DOWN_BUTTON ");
				CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.SIX);

				LOGGER.info("Click Xfinity ok button ");
				CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
				nu.pattern.OpenCV.loadLocally();

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNELS_OPTION);

				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_OPTION));

				LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 200,400,80,40);

				File outputFile = new File("/var/lib/jenkins/workspace/channelsSection.jpg");
				ImageIO.write(subImage, "jpg", outputFile);

				BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/channelsSection.jpg"));

				ConvertImage ci = new ConvertImage();
				BufferedImage greyImage =ci.ConvertGrayScale(output);

				File outputFiletwo = new File("/var/lib/jenkins/workspace/channelsSection2.jpg");
				ImageIO.write(greyImage, "jpg", outputFiletwo);

				LOGGER.info("Calling method to read text in image");
				GrabText grabText = new GrabText();
				actual = grabText.crackImage(greyImage);

				LOGGER.info("Click Xfinity ok button ");
				CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
				Thread.sleep(10000);
				nu.pattern.OpenCV.loadLocally();
				
				LOGGER.info("Click Xfinity ok button ");
				CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
				

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_OPTION);

				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_OPTION));

				LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 50,450,115,40);

				GrabText grabTextLinear = new GrabText();
				actualLinear = grabTextLinear.crackImage(subImage);
				status = CommonMethods.partialTextCompare(actualLinear, actual);

				if (status) {

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
			
		
	/**
     * Step 3 :Tune to linear channels which support trick play
     */
		
=======
>>>>>>> 1094df4908b369ab751231819cb7abf96989e270
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify linear channels which support trick play");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press down button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S2";
			errorMessage = "The user is not in the application screen";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 2: DESCRIPTION : This test is to verify Tune to linear channels which support trick play");
			LOGGER.info("STEP 2: ACTION : Press down button and take screenshot and repeat");
			LOGGER.info("STEP 2: EXPECTED : Tune should be successful, no AV issues should be seen.");
			LOGGER.info("*****************************************************************************************");


			LOGGER.info("Linear channels which supporttrick play");		
			CommonMethods.Trickplay();

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);


		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-3001");

	}
	@Test(priority=12, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-3002")
	public void testVerifyfast(Dut device) throws InterruptedException {

		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-302";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;;
		BufferedImage subImage;
		String actualfast6;
		String expectedfast6="Lo";
		String actualfast12;
		String expectedfast12="x12";
		String actualfast24;
		String expectedfast24="x24";

		/**
		 * Step 5 :Perform fast forward operation at different speed and play using on screen controls
		 */

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3002");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify fast forward operation at different speed and play using on screen controls");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press right and ok button ");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify fast forward operation";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Perform Fast forward operation at differrent speed & play using on screen controls");
			LOGGER.info("STEP 1: ACTION : Press right button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : fast forward operation is verified at different speed.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Two right button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.RIGHT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click OK BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);


			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_FAST_FORWARD);
			Thread.sleep(5000L);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_FAST_FORWARD));

			LOGGER.info("Click one left button ");
			CommonMethods.execCommand1(RemoteKeyContstants.LEFT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand1(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(60000L);

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 730,600,60,120);


			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actualfast6 = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expectedfast6, actualfast6);

			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}

			//x12


			LOGGER.info("Click Two right button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.RIGHT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click two OK BUTTON ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.OK_BUTTON, IntergerCount.TWO);	

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_FAST_FORWARD);
			Thread.sleep(5000L);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_FAST_FORWARD));
			LOGGER.info("Click one left button ");
			CommonMethods.execCommand1(RemoteKeyContstants.LEFT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand1(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(60000L);

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 730,600,60,120);



			LOGGER.info("Calling read text in image method");
			GrabText grabText12 = new GrabText();
			actualfast12 = grabText12.crackImage(subImage);
			status = CommonMethods.textCompare(expectedfast12, actualfast12);

			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}

			//x24

			LOGGER.info("Click Two right button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.RIGHT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click 3 OK BUTTON ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.OK_BUTTON, IntergerCount.THREE);	

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_FAST_FORWARD);
			LOGGER.info("Click one left button ");
			CommonMethods.execCommand1(RemoteKeyContstants.LEFT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand1(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_FAST_FORWARD));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 730,600,60,120); 

			LOGGER.info("Calling read text in image method");
			GrabText grabText24 = new GrabText();
			actualfast24 = grabText24.crackImage(subImage);
			status = CommonMethods.textCompare(expectedfast24, actualfast24);

			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}
		}

		catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-3002");
	}


	@Test(priority=13, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-3003")
	public void testVerify(Dut device) throws InterruptedException {

		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-303";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String actualspeed;
		String expectedspeed="x6";
		String actualspeed12;
		String expectedspeed12="x12";
		String actualspeed24;
		String expectedspeed24="x24";

		/**
		 * Step 4 :Perform Rewind operation at different speed and play using on screen controls
		 */	

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3003");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify Rewind operation at different speed and play using on screen controls");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left button and take screenshot");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify rewind operation";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Rewind operation at different speed and play using on screen controls");
			LOGGER.info("STEP 1: ACTION : Press left button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Rewind operation is verified at different speed.");
			LOGGER.info("*****************************************************************************************");


			LOGGER.info("Click Two left button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.LEFT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click OK BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);


			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_REWIND);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_REWIND));

			LOGGER.info("Click one right button ");
			CommonMethods.execCommand1(RemoteKeyContstants.RIGHT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand1(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(60000L);

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,60,120);


			LOGGER.info("Calling read text in image method");
			GrabText grabText = new GrabText();
			actualspeed = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expectedspeed, actualspeed);



			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}


			//x12

			LOGGER.info("Click Two left button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.LEFT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click Two OK button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.OK_BUTTON, IntergerCount.TWO);


			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_REWIND);
			Thread.sleep(5000L);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_REWIND));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,60,120);

			LOGGER.info("Click one right button ");
			CommonMethods.execCommand1(RemoteKeyContstants.RIGHT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand1(RemoteKeyContstants.OK_BUTTON);
			//			Thread.sleep(60000L);

			LOGGER.info("Calling read text in image method");
			GrabText grabText12 = new GrabText();
			actualspeed12 = grabText12.crackImage(subImage);
			status = CommonMethods.textCompare(expectedspeed12, actualspeed12);

			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}

			//x24


			LOGGER.info("Click Two left button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.LEFT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click Three OK button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.OK_BUTTON, IntergerCount.THREE);


			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_REWIND);
			Thread.sleep(5000L);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_REWIND));
			LOGGER.info("Click one right button ");
			CommonMethods.execCommand1(RemoteKeyContstants.RIGHT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand1(RemoteKeyContstants.OK_BUTTON);
			//			Thread.sleep(60000L);


			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,60,120);


			LOGGER.info("Calling read text in image method");
			GrabText grabText24 = new GrabText();
			actualspeed24 = grabText24.crackImage(subImage);
			status = CommonMethods.textCompare(expectedspeed24, actualspeed24);

			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}

			LOGGER.info("**********************************************************************************");
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

		}

		catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-3003");
	}


	@Test(priority=14, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-3004")
	public void testVerifyPause(Dut device) throws InterruptedException {

		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-304";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage outputImage;
		BufferedImage subImage;


		/**
		 * Step 6 :Perform Pause/play using on screen controls
		 */
		//Play
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3004");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify Pause/play using on screen controls");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press right and ok button ");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify Pause/play operation";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Pause/play using on screen controls");
			LOGGER.info("STEP 1: ACTION : Press right button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Pause/Play functionality should work fine without any issues");
			LOGGER.info("*****************************************************************************************");


			LOGGER.info("Click one left button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_PAUSE);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_PAUSE));

			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_PAUSE_REF));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 620,640,40,40); 

			File outputFile = new File("/var/lib/jenkins/workspace/image4.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image4.jpg"));

			ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare2(referenceImage, outputImage);

			if (status) {

				LOGGER.info("The status of image comparision is: " + status + "and Pause icon verified");

			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);

			}

			Thread.sleep(10000);
			//Pause

			//			LOGGER.info("Click one right button ");
			//			CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Click OK BUTTON ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Click OK BUTTON ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_PLAY);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_PLAY));

			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_PLAY_REF));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 620,640,40,40); 

			File outputFileTPlay = new File("/var/lib/jenkins/workspace/image3.jpg");
			ImageIO.write(subImage, "jpg", outputFileTPlay);

			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image3.jpg"));

			ImageCompare imgComparePlay =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgComparePlay.compare(referenceImage, outputImage);

			if (status) {

				LOGGER.info("The status of image comparision is: " + status + "and Play icon verified");

			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);

			}
		}

		catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-3004");
	}


	@Test(priority=14, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-3005")
	public void testVerifyZero(Dut device) throws InterruptedException {

		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-305";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage outputImage;
		BufferedImage subImage;

		//		/**
		//	     * Step 7 :Perform Rewind operation until control has reached at the start position of the content 
		//	     */

<<<<<<< HEAD
		//
		@Test(priority=14, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
				BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
		@TestDetails(testUID = "PEACOCK-AAMP-TC-3005")
		public void testVerifyZero(Dut device) throws InterruptedException {
			
			boolean status = false;
			String testId = "PEACOCK-AAMP-TC-305";
			String errorMessage = null;
			String stepNum = null;
			BufferedImage referenceImage;
			BufferedImage liveImage;
			BufferedImage outputImage;
			BufferedImage subImage;
			
//		/**
//	     * Step 7 :Perform Rewind operation until control has reached at the start position of the content 
//	     */
		
=======
>>>>>>> 1094df4908b369ab751231819cb7abf96989e270
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3005");
		LOGGER.info("TEST DESCRIPTION: This test is to verify Rewind operation until control has reached at the start position of the content ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left and ok button ");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to verify Rewind operation";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify Rewind operation until control has reached at the start position of the content");
			LOGGER.info("STEP 1: ACTION : Press left and ok button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Rewind operation is verified");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click two Left button ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.LEFT_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click OK BUTTON ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(10000L);


			LOGGER.info("Capture Pause screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_TRICK_REWIND);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_TRICK_REWIND));

			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_REWIND_REF));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 40,580,90,40); 

			File outputFileTPlay = new File("/var/lib/jenkins/workspace/image5.jpg");
			ImageIO.write(subImage, "jpg", outputFileTPlay);

			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image5.jpg"));

			ImageCompare imgComparePlay =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgComparePlay.compare(referenceImage, outputImage);

			if (status) {

				LOGGER.info("The status of image comparision is: " + status);

			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);

			}
		}
		catch (Exception e) {
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
