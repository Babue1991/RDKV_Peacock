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
		@Test(priority=0, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
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
		/**
	     * Step 1 :Launch peacock application
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
			BufferedImage nextliveImage;
			BufferedImage outputImage;
			BufferedImage subImage;
			String expectedtext ="Cheers";
			String actualCheers;
			String expectedCheers= "Cheers";
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
				subImage = CropImage.cropImage(liveImage, 200,400,100,40);
				
				LOGGER.info("Calling read text in image method");
				GrabText grabTextChannels=new GrabText();
				actualCheers = grabTextChannels.crackImage(subImage);
				status = CommonMethods.textCompare(expectedtext,actualCheers);
				
				if(status) {
					LOGGER.info("Click ok to navigate to linear channels");
					CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

				}else {
					LOGGER.error(" Linear Channels not found");
				}


				if(status) {
					LOGGER.info("The user is application screen: " + actualCheers);
					CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
					LOGGER.info("Capture application screen live image");
					CaptureLiveImage.captureIcon(ImageCaptureConstants.CHANNELS_CHEERS_LIVE);
					
					LOGGER.info("Reading live image");
					liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_CHEERS_LIVE));

					LOGGER.info("Crop the live image");
					subImage = CropImage.cropImage(liveImage, 60,440,150,60);

					GrabText grabTextCheers=new GrabText();
					actualCheers = grabTextCheers.crackImage(subImage);
					status = CommonMethods.textCompare(expectedCheers, actualCheers);
					
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
		/**
	     * Step 2 : Tune to couple of other linear channels randomly
	     */
		LOGGER.info("#######################################################################################");
		LOGGER.info("TEST DESCRIPTION:  This test is to Tune to couple of other linear channels randomly and verify");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press up button and verify");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S2";
			errorMessage = "Failed to tune other linear channel";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 2: DESCRIPTION : This test is to Tune to couple of other linear channels randomly and verify");
			LOGGER.info("STEP 2: ACTION : Press up button and verify");
			LOGGER.info("STEP 2: EXPECTED : Linear Channels option verified successfully.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click two DOWN_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(15000);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_CHANNELS_TUNE_VERIFY);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_TUNE_VERIFY));
			
			LOGGER.info("Click two DOWN_BUTTON ");
			CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			Thread.sleep(15000);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_TUNE_VERIFY);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS_NEXT_TUNE_VERIFY));
			
			LOGGER.info("Calling image compare method");
			ImageCompare imgCompare =new ImageCompare();
			status = imgCompare.compare(liveImage, nextliveImage);
		
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
		LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-2002");
	}

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
				
				LOGGER.info("Linear channels which supporttrick play");		
				CommonMethods.Trickplay();
				
				
//				for(int i=0; i<=3; i++) {
//					//Total number of channels is 63
//					//as of now i have taken i=3
//					LOGGER.info("Click two DOWN_BUTTON ");
//					CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
//					Thread.sleep(1000);
//					
//					LOGGER.info("Click Xfinity OK button ");
//					CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
//					Thread.sleep(20000);
//					
//					LOGGER.info("Capture application screen live image");
//					CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_TUNE_VERIFY);
//					Thread.sleep(5000L);
//					
//					LOGGER.info("Reading live image");
//					liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TUNE_VERIFY));
//					
//					LOGGER.info("Capture application screen live image");
//					CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_NEXT_TUNE_VERIFY);
//					Thread.sleep(5000L);
//					
//					LOGGER.info("Reading live image");
//					nextliveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_NEXT_TUNE_VERIFY));
//					
//					LOGGER.info("Calling image compare method");
//					ImageCompare imgCompare =new ImageCompare();
//					status = imgCompare.compare(liveImage, nextliveImage);
//				}
//			
//				if (status) {
//					LOGGER.info("The status of image comparision is: " + status);
//				} else {
//					LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
////				}
//				LOGGER.info("**********************************************************************************");
//				tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

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
		/**
	     * Step 1 :Launch peacock application
	     */
		/**
	     * Step 2 :Go to channels option in peacock menu and press ok
	     */
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
				LOGGER.info("STEP 1: DESCRIPTION : This test is to verify linear channel which do not support trick play");
				LOGGER.info("STEP 1: ACTION : Press ok and take screensho");
				LOGGER.info("STEP 1: EXPECTED : Linear channel which do not support trick play should launch successfully");
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
		
	}
	}
	