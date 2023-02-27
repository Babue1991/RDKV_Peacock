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

public class PeacockSearchFeatureAntz extends AutomaticsTestBase {

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
	@Test(priority=53, dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA, "AppLaunch"  })
	@TestDetails(testUID = "PEACOCK-AAMP-TC-1053")
	public void testVerifySearchResumeButtonSTB(Dut device) throws InterruptedException {
		// Variables declaration starts
		boolean status = false;
		String testId = "PEACOCK-AAMP-TC-153";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage liveImage;
		BufferedImage referenceImage;
		BufferedImage subImage;
		BufferedImage livePauseImage;
		BufferedImage livePauseNextImage;
		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: PEACOCK-AAMP-TC-1053");
		LOGGER.info("TEST DESCRIPTION: This test is to verify peacock search screen pause content ");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1.Launch peacock search screen and verify pause content");
		LOGGER.info("#######################################################################################");
		try {
			stepNum = "S1";
			errorMessage = "Failed to pause the video and compare";
			LOGGER.info("*****************************************************************************************");
			LOGGER.info("STEP 1: DESCRIPTION : This test is to verify the search screen pause content");
			LOGGER.info("STEP 1: ACTION : ACTION: compare search screen pause content reference image with the live image ");
			LOGGER.info("STEP 1: EXPECTED : content is paused successful.");
			LOGGER.info("*****************************************************************************************");
			
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			nu.pattern.OpenCV.loadLocally();
			
			LOGGER.info("Click Xfinity ok button ");
			CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
			
			LOGGER.info("Capture application screen screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_SEARCH_PAUSE_CONTENT);
			
			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_PAUSE_CONTENT));
			
			LOGGER.info("Reading reference image");
			referenceImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_REFERENCE_PLAY_ICON));
			
			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 50,630,40,44);
			
			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);
			BufferedImage output = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
			
			LOGGER.info("Calling image compare method");
			ImageCompare imgCompare =new ImageCompare();
			status = imgCompare.compare(referenceImage, output);
			
			if (status) {
				
				LOGGER.info("The status of image comparision is: " + status + "and Play icon verified");
				
			} else {
				LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
			}
			
			Thread.sleep(3000L);
			LOGGER.info("Click Xfinity left button ");
			CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
			Thread.sleep(2000L);
			
			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN);
			
			LOGGER.info("Reading next live image");
			livePauseImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN));
			
			LOGGER.info("Capture after 5seconds application screen live image");
			CaptureLiveImage.capture(ImageCaptureConstants.PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN_NEXT);
			
			LOGGER.info("Reading next live image");
			livePauseNextImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN_NEXT));
			
	        LOGGER.info("Calling image compare method");
            status = imgCompare.compare(livePauseImage, livePauseNextImage);
     
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
			LOGGER.error("Exception while playing the video: " + errorMessage);
			CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);

		}
		LOGGER.info("ENDING TEST CASE: PEACOCK-AAMP-TC-1053");
	}
	
	
}