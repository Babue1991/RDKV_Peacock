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
			String expectedchannels="Eccd";
			// Variables declaration Ends
   
			/**
		     * Step 2 :using appropriate keys on remote,go to channels option in the peacock menu and press OK
		     */
			LOGGER.info("#######################################################################################");
			LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
			LOGGER.info("TEST DESCRIPTION:  This test is to verify user can navigate to the channels content");
			LOGGER.info("TEST STEPS : ");
			LOGGER.info("1. Press left button and go six down");
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
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-3001");

			
		
	/**
     * Step 3 :Tune to linear channels which support trick play
     */
		
		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-3001");
		LOGGER.info("TEST DESCRIPTION:  This test is to verify linear channels which support trick play");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Press four down button");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S2";
			errorMessage = "The user is not in the application screen";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify linear channels which support trick play");
			LOGGER.info("STEP 1: ACTION : Press four down button and take screenshot");
			LOGGER.info("STEP 1: EXPECTED : Channels option should launch successfully.");
			LOGGER.info("*****************************************************************************************");
	
			
			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNELS_VERIFY));
			
			
			LOGGER.info("Capture Channels screen live image");
			CaptureLiveImage.capture2(ImageCaptureConstants.LINEARCHANNELS_OPTION,RemoteKeyContstants.DOWN_BUTTON,IntergerCount.FOUR);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.LINEARCHANNELS_OPTION));
			
			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 750,400,60,120);
			
						
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
			
			ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare(referenceImage, outputImage);
			
			if (status) {
				LOGGER.info("The status of text comparision is: " + status);
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			
			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_LINEAR_CHANNELS_VERIFY));
			
			LOGGER.info("Capture Channels screen live image");
			CaptureLiveImage.capture2(ImageCaptureConstants.LINEARCHANNELS_OPTION,RemoteKeyContstants.DOWN_BUTTON,IntergerCount.FOUR);
			Thread.sleep(5000L);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.LINEARCHANNELS_OPTION));
			
			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 750,400,60,120);
			
						
			//File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			
			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
			
			//ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare(referenceImage, outputImage);
			
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
		
		}
	}