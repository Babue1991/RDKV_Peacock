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
			BufferedImage referenceImage;
			BufferedImage liveImage;
			BufferedImage subImage;
			BufferedImage outputImage;
			String actual;
			String expectedchannels="cicd";
			String actualspeed;
			String expectedspeed="x6";
			String actualspeed12;
			String expectedspeed12="x12";
			String actualspeed24;
			String expectedspeed24="x24";
			String actualfast6;
			String expectedfast6="x6";
			String actualfast12;
			String expectedfast12="x12";
			String actualfast24;
			String expectedfast24="x24";
			// Variables declaration Ends
   
			/**
		     * Step 2 :using appropriate keys on remote,go to channels option in the peacock menu and press OK
		     */
			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
			LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to the channels content");
			LOGGER.info("TEST STEPS : ");
			LOGGER.info("1. Press left button and go six down");
			LOGGER.info("##############			String actualspeed12;\n"
					+ "			String expectedspeed12=\"x12\";#########################################################################");
			try {
				stepNum = "S1";
				errorMessage = "Failed to navigate to Channels button";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 2: DESCRIPTION : This test is to verify user can navigate to the channels content");
				LOGGER.info("STEP 2: ACTION : Press down button and take screenshot");
				LOGGER.info("STEP 2: EXPECTED : Channels option should launch successfully.");
				LOGGER.info("*****************************************************************************************");

				LOGGER.info("Click Xfinity left button ");
				CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
				
				LOGGER.info("Click six DOWN_BUTTON ");
				CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.SIX);
						
				LOGGER.info("Capture Channels screen live image");
				CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_CHANNELS);
				Thread.sleep(5000L);
				
				LOGGER.info("Reading live image");
				liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS));
				
				LOGGER.info("Calling crop method");
				subImage = CropImage.cropImage(liveImage, 90,500,100,30);
				
				GrabText grabText = new GrabText();
				actual = grabText.crackImage(subImage);
				status = CommonMethods.textCompare(expectedchannels, actual);
				Thread.sleep(5000L);
						
							
				LOGGER.info("Click Xfinity ok button ");
				CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
				nu.pattern.OpenCV.loadLocally();
			
				if (status) {
					LOGGER.info("The status of text comparision is: " + status);
				} else {
					LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
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
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-3001");

			
		
	/**
     * Step 3 :Tune to linear channels which support trick play
     */
		
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify linear channels which support trick play");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press down button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S3";
			errorMessage = "The user is not in the application screen";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 3: DESCRIPTION : This test is to verify linear channels which support trick play");
			LOGGER.info("STEP 3: ACTION : Press down button and take screenshot");
			LOGGER.info("STEP 3: EXPECTED : Channels option should launch successfully.");
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
		
		
		
		/**
	     * Step 4 :Perform Rewind operation at different speed and play using on screen controls
	     */	
		
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify Rewind operation at different speed and play using on screen controls");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press left button and take screenshot");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S4";
			errorMessage = "Failed to verify rewind operation";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 4: DESCRIPTION : This test is to verify Rewind operation at different speed and play using on screen controls");
			LOGGER.info("STEP 4: ACTION : Press left button and take screenshot");
			LOGGER.info("STEP 4: EXPECTED : Rewind operation is verified at different speed.");
			LOGGER.info("*****************************************************************************************");
			
			
			LOGGER.info("Click one left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click OK BUTTON ");
			//CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
					
			LOGGER.info("Capture Rewind screen live image");
			//CaptureLiveImage.capture(ImageCaptureConstants.CHANNELS_REWIND);
			CaptureLiveImage.capture2(ImageCaptureConstants.CHANNELS_REWIND,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_REWIND));
			
			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,60,120);
			
			LOGGER.info("Click one right button ");
			CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
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
			
			LOGGER.info("Click one left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click OK BUTTON ");
			
			LOGGER.info("Capture Rewind screen live image");
			CaptureLiveImage.capture2(ImageCaptureConstants.CHANNELS_REWIND,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_REWIND));
			
			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,60,120);
			
			LOGGER.info("Click one right button ");
			CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
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

			
			LOGGER.info("Click one left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click OK BUTTON ");
			
			LOGGER.info("Capture Rewind screen live image");
			CaptureLiveImage.capture2(ImageCaptureConstants.CHANNELS_REWIND,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_REWIND));
			
			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 490,600,60,120);
			
			LOGGER.info("Click one right button ");
			CommonMethods.execCommand(RemoteKeyContstants.RIGHT_BUTTON);
			LOGGER.info("Click ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Calling read text in image method");
			GrabText grabText24 = new GrabText();
			actualspeed24 = grabText24.crackImage(subImage);
			status = CommonMethods.textCompare(expectedspeed24, actualspeed24);
		
			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 2: ACTUAL : " + errorMessage);
			}

			
			tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);

			
		}
		
		
		catch (Exception e) {
		LOGGER.error("Exception occured while reading the image file " + e);

		e.printStackTrace();
		LOGGER.info("Inside catch");
		errorMessage = e.getMessage();
		LOGGER.error("Exception while launching movie screen: " + errorMessage);
		CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

	}
		/**
	     * Step 5 :Perform fast forward operation at different speed and play using on screen controls
	     */
		
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify fast forward operation at different speed and play using on screen controls");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press right and ok button ");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S5";
			errorMessage = "Failed to verify fast forward operation";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 4: DESCRIPTION : This test is to verify fast forward operation at different speed and play using on screen controls");
			LOGGER.info("STEP 4: ACTION : Press right button and take screenshot");
			LOGGER.info("STEP 4: EXPECTED : fast forward operation is verified at different speed.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click one right button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			
			LOGGER.info("Click OK BUTTON ");
					
			LOGGER.info("Capture fast forward screen live image");
			//CaptureLiveImage.capture(ImageCaptureConstants.CHANNELS_REWIND);
			CaptureLiveImage.capture2(ImageCaptureConstants.CHANNELS_FAST_FORWARD,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_FAST_FORWARD));
			
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
			

			LOGGER.info("Click one right button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			

			LOGGER.info("Click OK BUTTON ");
					
			LOGGER.info("Capture fast forward screen live image");
			//CaptureLiveImage.capture(ImageCaptureConstants.CHANNELS_REWIND);
			CaptureLiveImage.capture2(ImageCaptureConstants.CHANNELS_FAST_FORWARD,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.CHANNELS_FAST_FORWARD));
			
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

			LOGGER.info("Click one right button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

			
			LOGGER.info("Click OK BUTTON ");
					
			LOGGER.info("Capture fast forward screen live image");
			//CaptureLiveImage.capture(ImageCaptureConstants.CHANNELS_REWIND);
			CaptureLiveImage.capture2(ImageCaptureConstants.CHANNELS_FAST_FORWARD,RemoteKeyContstants.OK_BUTTON,IntergerCount.ONE);
			Thread.sleep(5000L);
			
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
	}	
		
}
