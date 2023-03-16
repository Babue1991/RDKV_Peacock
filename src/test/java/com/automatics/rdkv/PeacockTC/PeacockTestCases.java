package com.automatics.rdkv.PeacockTC;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
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
import com.automatics.rdkv.imagevalidation.ConvertImage;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.test.AutomaticsTestBase;


public class PeacockTestCases extends AutomaticsTestBase {

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

	static Process p;
	@Test(priority=10, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2001")
	public void testVerifySplashScreenSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-201";
		String errorMessage = null;
		String stepNum = null;
		Mat referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		String actual;
		String expected;
		String expectedpopularapp = "Popular entertainment apps";
		String Expectedpeacock = "Peacock";
		String SplashText = "peacock:";
		// Variables declaration Ends


		/**
		 * Step 1 : Press Xfinity button on the comcast remote
		 */

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
			Thread.sleep(2000L);
			CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);
			Thread.sleep(3000L);

			nu.pattern.OpenCV.loadLocally();
			LOGGER.info("Taking live screenshot in "+ImageCaptureConstants.XFINITY_HOME_SCREEN);
			CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_HOME_SCREEN);
			Thread.sleep(5000L);

			ImageCompare imgCompare = new ImageCompare();

			referenceImage=Imgcodecs.imread(ImageCaptureConstants.STB_HOME_APPS_BUTTON_IMAGE);

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


		/**
		 * Step 2 : select apps and press ok 
		 */

		LOGGER.info("#######################################################################################");
		LOGGER.info("TEST DESCRIPTION: This test is to verify application screen launch");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press Xfinity button on the comcast remote");
		LOGGER.info("#######################################################################################");

		try {
			stepNum = "S2";
			errorMessage = "Failed to load Application screen";
			expected="BMdeucis";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can launch application screen using remote keys");
			LOGGER.info("STEP 1: ACTION : Take screen shot of the live screen and compare it with reference image");
			LOGGER.info("STEP 1: EXPECTED : Application screen should launch successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Take screenshot in application screen ");
			LOGGER.info(" ");
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_APPLICATION_SCREEN);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.XFINITY_APPLICATION_SCREEN));
			LOGGER.info("Crop the live image");
			subImage = CropImage.cropImage(liveImage, 70,25,160,60);

			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expected, actual);

			LOGGER.info("Calling screen compare method");


			if (status) {
				LOGGER.info("The status of image comparision is: " + status);
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
			LOGGER.error("Exception while launching home screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		/**
		 * Step 3 : verify popular entertainment section in STB
		 */

		LOGGER.info("#######################################################################################");
		LOGGER.info("TEST DESCRIPTION: This test is to verify popular entertainment section in STB");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Switch to application screen from Xfinity screen");
		LOGGER.info("#######################################################################################");

		try {
			stepNum = "S3";
			errorMessage = "The user is not in the application screen";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user popular entertainment section in STB");
			LOGGER.info("STEP 1: ACTION : Take screen shot of the live screen and compare it with reference image");
			LOGGER.info("STEP 1: EXPECTED : Application screen should display popular entertainment screen. ");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Take live screen screenshot");
			LOGGER.info(" ");
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_APPLICATION_SCREEN);


			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.XFINITY_APPLICATION_SCREEN));

			LOGGER.info("Crop the live image");
			subImage = CropImage.subImage(liveImage, 70,380,380,70);

			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(expectedpopularapp, actual);

			if(status) {
				LOGGER.info("The user is application screen: " + actual);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}

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
		 * Step 4 :  Go to popular entertainment section and select peacock app title and press ok
		 */


		LOGGER.info("#######################################################################################");
		LOGGER.info("TEST DESCRIPTION: This test is to verify popular entertainment section peacock app title");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Switch to application screen from Xfinity screen");
		LOGGER.info("#######################################################################################");

		try {
			stepNum = "S4";
			errorMessage = "The user is not in the application screen";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user popular entertainment section in STB");
			LOGGER.info("STEP 1: ACTION : Take screen shot of the live screen and compare it with reference image");
			LOGGER.info("STEP 1: EXPECTED : Application screen should display popular entertainment screen. ");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info(" ");
			nu.pattern.OpenCV.loadLocally();

			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

			Thread.sleep(3000L);
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.XFINITY_APPLICATION_FOCUS_PEACOCK);


			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.XFINITY_APPLICATION_FOCUS_PEACOCK));

			LOGGER.info("Crop the live image");
			subImage = CropImage.cropImage(liveImage, 50,300,160,45);

			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);
			status = CommonMethods.textCompare(Expectedpeacock, actual);

			if(status) {
				LOGGER.info("Click and launch peacock application");
				CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

			}else {
				LOGGER.error(" Peacock Application not found");
			}


			if(status) {
				LOGGER.info("The user is application screen: " + actual);
				CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.captureIcon(ImageCaptureConstants.XFINITY_PEACOCK_SPLASH_SCREEN);


				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.XFINITY_PEACOCK_SPLASH_SCREEN));

				LOGGER.info("Crop the live image");
				subImage = CropImage.cropImage(liveImage, 120,230,1000,250);

				actual = grabText.crackImage(subImage);
				status = CommonMethods.textCompare(SplashText, actual);

			}
			else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}

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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2001");
	}
	
	
	@Test(priority=1,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2002")
	public void testVerifyMoviesOption(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-002";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage nextliveImage;
		BufferedImage subImage;
		BufferedImage subImagenext;
		String actual;
		String actualLinear;
		String actualchannel;
		String actualNext;
		// Variables declaration Ends
		
		/**
		 * Step 1 :Launch peacock application
		 */
		
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.launchPeacockApp();
		/**
		 * Step 2 : Go to channel option in peacock menu and press ok
		 */
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2002");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to the channels content");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left button and go down");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S2";
			errorMessage = "Failed to navigate to Channels button";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 2: DESCRIPTION : This test is to verify user can navigate to the channels  2002 content");
			LOGGER.info("STEP 2: ACTION : Press down button and take screenshot");
			LOGGER.info("STEP 2: EXPECTED : Channels option should launch successfully.");
			LOGGER.info("*****************************************************************************************");

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
			subImage = CropImage.cropImage(liveImage, 50,450,110,40);

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
		 * Step 3 : Tune to couple of other linear channels randomly
		 */
		LOGGER.info("#######################################################################################");
		LOGGER.info("TEST DESCRIPTION:  This test is to Tune to couple of other linear channels randomly and verify");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press up button and verify");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S3";
			errorMessage = "Failed to tune other linear channel";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 3: DESCRIPTION : This test is to Tune to couple of other linear channels randomly and verify");
			LOGGER.info("STEP 3: ACTION : Press up button and verify");
			LOGGER.info("STEP 3: EXPECTED : Linear Channels option verified successfully.");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click two DOWN_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click two OK_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.OK_BUTTON, IntergerCount.TWO);
			Thread.sleep(15000);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_CHANNELS_TUNE_VERIFY);
			Thread.sleep(5000L);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_TUNE_VERIFY));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 40,370,130,70);

			File outputFile = new File("/var/lib/jenkins/workspace/ChannelsTune.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/ChannelsTune.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImagenew =ci.ConvertGrayScale(output);

			File outputFileChannel = new File("/var/lib/jenkins/workspace/ChannelsTune2.jpg");
			ImageIO.write(greyImagenew, "jpg", outputFileChannel);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actualNext = grabText.crackImage(greyImagenew);

			LOGGER.info("Click two DOWN_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);

			LOGGER.info("Click two OK_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.OK_BUTTON, IntergerCount.TWO);
			Thread.sleep(15000);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_TUNE_VERIFY);
			Thread.sleep(5000L);

			LOGGER.info("Reading live image");
			nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_TUNE_VERIFY));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 40,370,130,70);

			GrabText grabTextLinear = new GrabText();
			actualchannel = grabTextLinear.crackImage(subImage);
			status = CommonMethods.textCompare(actualchannel, actualNext);

			if (actualNext != actualchannel) {
				LOGGER.info("TRUE");
			}
			else {
				LOGGER.info("FALSE");
			}

		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2002");
	}

	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-40001")
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
		String actual;
		String actualNew;
		// Variables declaration Ends
		
		/**
		 * Step 1 :Launch peacock application
		 */
		
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.launchPeacockApp();
		
		/**
		 * Step 2 :Go to channels and press ok
		 */
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.tuneChannels();
		
		/**
		 * Step 3 : Tune to all linear channels one by one till the end and verify
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
			LOGGER.info("STEP 3: DESCRIPTION : This test is to verify all the linear channels");
			LOGGER.info("STEP 3: ACTION : Press down button and click ok");
			LOGGER.info("STEP 3: EXPECTED : Linear channels verified successfully.");
			LOGGER.info("*****************************************************************************************");	
			Process p;
			LOGGER.info("My code start");
			p = Runtime.getRuntime().exec("irsend SEND_ONCE Apple Comcast_Down");
			LOGGER.info("My code end");
			
			
			p = Runtime.getRuntime().exec("irsend SEND_ONCE Apple Comcast_Down");
			p = Runtime.getRuntime().exec("irsend SEND_ONCE Apple Comcast_OK");
			Thread.sleep(20000L);
//			LOGGER.info("Calling method to navigate to linear channel ");
//			CommonMethods.navigateToChannelFour();
//			
//			Thread.sleep(2000);
//			
//			LOGGER.info("Click Xfinity OK button ");
//			CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
//			
			
			for(int i=0; i<=3; i++) {
				//i=63
				
				LOGGER.info("Click Xfinity down button ");
				//irsend SEND_ONCE Apple Comcast_Down
				
				CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
				CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
				
				LOGGER.info("Click Xfinity 0k button ");
				CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
				Thread.sleep(2000);
				
				LOGGER.info("Click Xfinity 0k button ");
				CaptureLiveImage.capture2(ImageCaptureConstants.PEACOCK_TUNE_VERIFY, RemoteKeyContstants.RIGHT_BUTTON, IntergerCount.ONE);
				Thread.sleep(15000);

//				LOGGER.info("Capture application screen live image");
//				CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_TUNE_VERIFY);
				
				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TUNE_VERIFY));
				
				LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 40,370,130,70);
				
				File outputFile = new File("/var/lib/jenkins/workspace/TuneVerify.jpg");
				ImageIO.write(subImage, "jpg", outputFile);

				BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/TuneVerify.jpg"));

				ConvertImage ci = new ConvertImage();
				BufferedImage greyImagenew =ci.ConvertGrayScale(output);

				File outputFileChannel = new File("/var/lib/jenkins/workspace/TuneVerify2.jpg");
				ImageIO.write(greyImagenew, "jpg", outputFileChannel);

				LOGGER.info("Calling method to read text in image");
				GrabText grabText = new GrabText();
				actual = grabText.crackImage(greyImagenew);
				
				LOGGER.info("Click two DOWN_BUTTON 2003");
				CommonMethods.execCommandRepeat2(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);

				LOGGER.info("Click OK_BUTTON ");
				CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
				Thread.sleep(10000);

				LOGGER.info("Capture application screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_IMG);
				Thread.sleep(5000L);

				LOGGER.info("Reading live image");
				nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_IMG));

				LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 40,370,130,70);

				GrabText grabTextLinear = new GrabText();
				actualNew = grabTextLinear.crackImage(subImage);
				status = CommonMethods.textCompare(actualNew, actual);
				
				if (actualNew != actual) {
					LOGGER.info("TRUE");
				}
				else {
					LOGGER.info("FALSE");
				}
				
			}

//			if (status) {
//				LOGGER.info("The status of image comparision is: " + status);
//			} else {
//				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
//			}
//			LOGGER.info("**********************************************************************************");
//			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);


		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching movie screen: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-40001");
	}
	
	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2004")
	public void testVerifyChannel(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-204";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage referenceImage;
		BufferedImage liveImage;
		BufferedImage subImage;
		BufferedImage outputImage;
		// Variables declaration Ends
		
		/**
		 * Step 1 :Launch peacock application
		 */
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.launchPeacockApp();
		
		/**
		 * Step 2 :Go to channels option in peacock menu and press ok
		 */
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.tuneChannels();
		
		/**
		 * Step 3: Tune to linear channel which do not support trick play
		 */
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2004");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify linear channel which do not support trick play");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press ok and take screenshot");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to linear channels";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 3: DESCRIPTION : This test is to verify linear channel which do not support trick play");
			LOGGER.info("STEP 3: ACTION : Press ok and take screenshot");
			LOGGER.info("STEP 3: EXPECTED : Linear channel which do not support trick play should launch successfully");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity down button");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(8000);
			nu.pattern.OpenCV.loadLocally();

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_PLAY_TRICK);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_PLAY_TRICK));

			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_PLAY_TRICK_REFERENCE));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,260,120);

			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));

			ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare(referenceImage, outputImage);

			if(status==true) {
				LOGGER.info("It's supports trick play");
			}
			else {

				LOGGER.info("It does not supports trick play");
			}

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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2004");
	}
	/**
	 * Step 1 :Launch peacock application
	 */
	
	/**
	 * Step 2 :using appropriate keys on remote,go to channels option in the peacock menu and press OK
	 */
	/**
	 * Step 3 :Tune to linear channel which do not support trick play
	 */
	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2005")
	public void testChannelVerification(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-205";
		String errorMessage = null;
		String stepNum = null;
		// Variables declaration Ends
		/**
		 * Step 4 : Attempt Rewind operation using remote keys 
		 */
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2005");
		LOGGER.info("TEST DESCRIPTION:  This test is to Attempt Rewind operation using remote keys ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Go to channels and press ok");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S4";
			//errorMessage = "Rewind operation cannot be performed in the channels which do not support trick play";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 4: DESCRIPTION : This test is to Attempt Rewind operation using remote keys ");
			LOGGER.info("STEP 4: ACTION : Go to channels and press ok");
			LOGGER.info("STEP 4: EXPECTED : Rewind operation should held successfully");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Rewind operation cannot be performed in the channels which do not support trick play");
			
		} catch (Exception e) {
			LOGGER.error("Exception occured while reading the image file " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Inside catch");
			errorMessage = e.getMessage();
			LOGGER.error("Exception while launching home screen file: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
		}
		
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2005");
	}

	@Test(priority=6,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2006")
	public void testSLEChannels(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-206";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String actual;
		String expected = "Started";
		// Variables declaration Ends

		/**
		 * Step 1: Launch peacock app
		 */
		
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.launchPeacockApp();
		
		/**
		 * Step 2: Go to search and type S for live channel
		 */
		
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2006");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify SLE events are being broadcast");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Go to search icon and press ok");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to navigate to SLE events";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 3: DESCRIPTION : This test is to verify SLE events are being broadcast");
			LOGGER.info("STEP 3: ACTION : Go to search iceon and press ok");
			LOGGER.info("STEP 3: EXPECTED : SLE events are being broadcast successfully ");
			LOGGER.info("*****************************************************************************************");

			LOGGER.info("Click Xfinity left button");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

			LOGGER.info("Click Xfinity up button");
			CommonMethods.execCommand(RemoteKeyContstants.UP_BUTTON);
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(8000);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Click one Xfinity right button");
			CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
			
			LOGGER.info("Click one Xfinity down button");
			CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(4000);
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.SLE_LIVE_CHECK);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.SLE_LIVE_CHECK));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 110,450,50,35);
			
			File outputFile = new File("/var/lib/jenkins/workspace/SLE.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/SLE.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFileSLE = new File("/var/lib/jenkins/workspace/TuneVerify2.jpg");
			ImageIO.write(greyImage , "jpg", outputFileSLE);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImage);
			
			LOGGER.info("Calling method to compare text in image");
			status = CommonMethods.partialTextCompare(expected, actual);
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2006");
	}
	@Test(priority=7,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2007")
	public void testLiveEvents(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-207";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		BufferedImage referenceImage;
		String actualtime;
		String expected = "ume";
		
		// Variables declaration Ends
		
		/**
		 * Step 1 : Launch peacock app 
		 */
		
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.launchPeacockApp();
		
//		/**
//		 * Step 2: Go to sports/wwe and check if any SLE events are being broadcast
//		 */
//		LOGGER.info("#######################################################################################");
//		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2007");
//		LOGGER.info("TEST DESCRIPTION:  This test is to check SLE events are being broadcast in sports channel");
//		LOGGER.info("TEST STEPS : ");
//		LOGGER.info("1. Click left and press ok");
//		LOGGER.info("#######################################################################################");
//		try {
//			stepNum = "S2";
//			errorMessage = "No SLE is being broadcast in sports channel";
//			LOGGER.info("*****************************************************************************************");
//			LOGGER.info("STEP 2: DESCRIPTION : This test is to check SLE events are being broadcast in sports channel");
//			LOGGER.info("STEP 2: ACTION : Click left and press ok");
//			LOGGER.info("STEP 2: EXPECTED : SLE events are being broadcast successfully ");
//			LOGGER.info("*****************************************************************************************");
//		
//		LOGGER.info("Click Xfinity left button");
//		CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
//
//		LOGGER.info("Click three DOWN_BUTTON ");
//		CommonMethods.execCommandRepeat2(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.THREE);
//		
//		LOGGER.info("Click Xfinity ok button ");
//		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
//		Thread.sleep(3000);
//		
//		LOGGER.info("Capture application screen live image");
//		CaptureLiveImage.captureIcon(ImageCaptureConstants.SLE_LIVE_SPORTS);
//
//		LOGGER.info("Reading live image");
//		liveImage = ImageIO.read(new File(ImageCaptureConstants.SLE_LIVE_SPORTS));
//
//		LOGGER.info("Calling crop method");
//		subImage = CropImage.cropImage(liveImage, 100,680,50,30);
//		
//		File outputFile = new File("/var/lib/jenkins/workspace/SLESports.jpg");
//		ImageIO.write(subImage, "jpg", outputFile);
//
//		BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/SLESports.jpg"));
//		
//		LOGGER.info("Calling method to read text in image");
//		GrabText grabText = new GrabText();
//		actual = grabText.crackImage(output);
//		
//		LOGGER.info("Calling method to compare text in image");
//		status = CommonMethods.partialTextCompare(expected, actual);
//		
//		if (status) {
//
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
//		LOGGER.error("Exception while launching home screen file: " + errorMessage);
//		CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
//	}
		/**
		 * Step 3: Tune to SLE assests available  
		 */

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2007");
		LOGGER.info("TEST DESCRIPTION: Test to Verify Ads in SLE content");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Tune to SLE content");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S3";
			errorMessage = "Failed to verify Ads in SLE content";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 3: DESCRIPTION : Test to Verify Ads in SLE content");
			LOGGER.info("STEP 3: ACTION :Tune to SLE content");
			LOGGER.info("STEP 3: EXPECTED : Ad break should come up");
			LOGGER.info("*****************************************************************************************");
	
		
		LOGGER.info("Click Xfinity left button");
		CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
		
		LOGGER.info("Click one UP_BUTTON ");
		CommonMethods.execCommandRepeat2(RemoteKeyContstants.UP_BUTTON, IntergerCount.ONE);
		
		LOGGER.info("Click Xfinity ok button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(3000);
		
		LOGGER.info("Click one Xfinity right button");
		CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
		
		LOGGER.info("Click one Xfinity down button");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
		
		LOGGER.info("Click Xfinity ok button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(4000);
		
		LOGGER.info("Click three DOWN_BUTTON ");
		CommonMethods.execCommandRepeat2(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.THREE);
		
		LOGGER.info("Click Xfinity ok button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(5000);
		
		LOGGER.info("Capture SLE screen live image");
		CaptureLiveImage.captureIcon(ImageCaptureConstants.SLE_ADS_REF);

		LOGGER.info("Reading first live ads screen");
		liveImage = ImageIO.read(new File(ImageCaptureConstants.SLE_ADS_REF));
		Thread.sleep(5000);
		
		LOGGER.info("Calling image cropping method");
		subImage = CropImage.cropImage(liveImage, 68,638,35,35);

		File outputFile = new File("/var/lib/jenkins/workspace/timeimage.jpg");
		ImageIO.write(subImage, "jpg", outputFile);

		BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/timeimage.jpg"));

		ConvertImage ci = new ConvertImage();
		BufferedImage greyImage =ci.ConvertGrayScale(output);

		File outputFiletwo = new File("/var/lib/jenkins/workspace/timeimage2.jpg");
		ImageIO.write(greyImage, "jpg", outputFiletwo);

		LOGGER.info("Calling method to read text in image");
		GrabText grabText = new GrabText();
		actualtime = grabText.crackImage(greyImage);

		LOGGER.info("Calling method to read number in image");
		status = CommonMethods.checkNumber(actualtime);

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
		LOGGER.error("Exception while verifying linear channel: " + errorMessage);
		CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
	}
	
	LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2007");
}
	@Test(priority=8,dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-2008")
	public void testSLEChannel(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-208";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage subImage;
		String actual;
		String expected = "GoLive";
		// Variables declaration Ends

		
		/**
		 * Step 2: go to sports and check for SLE
		 */
		/**
		 * Step 1 & 3: Launch peacock app and Navigate to SLE 
		 */
		LOGGER.info("Method to Launch peacock app");
		CommonMethods.navigateToSLE();
		/**
		 * Step 4: Wait for Ad break to come up 
		 */

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-2008");
		LOGGER.info("TEST DESCRIPTION:  This test is to check whether SLE is playing at the livepoint");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Go to SLE and click ok");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S4";
			errorMessage = "Failed to check whether SLE is playing at the livepoint";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 4: DESCRIPTION : This test is to check whether SLE is playing at the livepoint");
			LOGGER.info("STEP 4: ACTION : Go to SLE and click ok");
			LOGGER.info("STEP 4: EXPECTED : SLE is playing at the livepoint successfully ");
			LOGGER.info("*****************************************************************************************");

			TimeUnit. MINUTES. sleep(5);
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.SLE_LIVE_IMG);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.SLE_LIVE_IMG));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage,  95,575,80,38);
			
			File outputFile = new File("/var/lib/jenkins/workspace/SLEgoLive.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/SLEgoLive.jpg"));

			ConvertImage ci = new ConvertImage();
			BufferedImage greyImage =ci.ConvertGrayScale(output);

			File outputFiletwo = new File("/var/lib/jenkins/workspace/SLEgoLive1.jpg");
			ImageIO.write(greyImage, "jpg", outputFiletwo);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(greyImage);
			
			LOGGER.info("Calling method to compare text in image");

			status = CommonMethods.partialTextCompare(expected, actual);
			
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2008");
	}
				
}

