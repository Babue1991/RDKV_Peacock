package com.automatics.rdkv.STBhomescreen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.automatics.test.AutomaticsTestBase;
import javax.imageio.ImageIO;
import org.testng.annotations.Test;
import com.automatics.annotations.TestDetails;
import com.automatics.constants.DataProviderConstants;
import com.automatics.image.imagick.MagickComparison;
import com.automatics.rdkb.BroadBandTestGroup;
import com.automatics.rdkb.constants.BroadBandTestConstants;
import com.automatics.rdkb.constants.BroadBandWebPaConstants;
import com.automatics.tap.AutomaticsTapApi;
import com.automatics.device.Dut;
import com.automatics.rdkb.utils.CommonUtils;
import com.automatics.rdkv.constants.ReferenceImageConstants;


public class XfinityHomeScreenValidatoin extends AutomaticsTestBase{

	/**
	 * String to store the value for resource usage compute window
	 */
	public static final String RESOURCE_USAGE_COMPUTE_WINDOW = "15";

	/**
	 * 
	 * This method verifies that webpa request to get value of Webpa.version
	 * parameter gives the value of WebPA version
	 * 
	 * <ol>
	 * <li>Step 1 : Verify retrieval of WebPA version in TR181 parameter</li>
	 * </ol>
	 * 
	 * @param device Dut to be used for execution
	 * 
	 * @author Babu Eagambaram
	 * 
	 */
	@Test(dataProvider = DataProviderConstants.PARALLEL_DATA_PROVIDER, dataProviderClass = AutomaticsTapApi.class, alwaysRun = true, enabled = true, groups = {
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA })
	@TestDetails(testUID = "TC-RDKV-STB-1001")   //Change testUID
	public void testVerifyHomeScreenSTB(Dut device) {  // Change method
		// Variables declaration starts
		boolean status = false;
		String testId = "TC-RDKV-STB-100"; //Change manual ID
		String errorMessage = null;
		String stepNum = null;
		BufferedImage reference_image;
		BufferedImage live_Image;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: TC-RDKV-STB-1001");
		LOGGER.info("TEST DESCRIPTION: Verify the STB home screen matches with the reference image");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Verify the home screen with reference image");
		LOGGER.info("#######################################################################################");
		MagickComparison magicCompare = new MagickComparison();
		ImageComparision mg = new ImageComparision();
		
		//	BufferedImage originalImg = ImageIO.read(new File(ConstantsSTB.REFRENCE_IMAGE_PATH));
			
	//	LOGGER.info("The tapenv data: " +tapEnv);
			try {
				stepNum = "S1";
				errorMessage = "The home screen and the current screen doesn't match";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : Verify the home screen with reference image.");
				LOGGER.info("STEP 1: ACTION : ACTION: Capture the live screen image of the home screen and compare it with actual image.");
				LOGGER.info("STEP 1: EXPECTED : The live image should match with home screen reference image.");
				LOGGER.info("*****************************************************************************************");
				
				reference_image = ImageIO.read(new File(ReferenceImageConstants.HOME_SCREEN_REFERENCE_IMG)); //change
				
				live_Image = ImageIO.read(new File(ReferenceImageConstants.HOME_SCREEN_LIVE_IMG)); //Change
				
				LOGGER.info("STEP 1: Entering to image comparision method ");
				
				status = mg.compare(reference_image, live_Image);
				LOGGER.info("STEP 1: Image comparison exection completed");
				
				if (status) {
					LOGGER.info("The status of image comparision is: " + status);
				} else {
					LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
				}
				LOGGER.info("**********************************************************************************");
				
				
				
				
				tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);
				
			} catch (IOException e) {
				LOGGER.error("Exception occured while reading the image file " + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.info("Inside catch");
				errorMessage = e.getMessage();
				LOGGER.error("Exception while reading the image file: " + errorMessage);
				CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
				
			}
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1001");
		
	}
	@TestDetails(testUID = "TC-RDKV-STB-1002")
	public void testVerifyHomeScreenSTB1(Dut device) {
		// Variables declaration starts
		boolean status = false;
		String testId = "TC-RDKV-STB-101";
		String errorMessage = null;
		String stepNum = null;
		BufferedImage originalImg;
		BufferedImage actualImg;

		// Variables declaration Ends

		LOGGER.info("#######################################################################################");
		LOGGER.info("STARTING TEST CASE: TC-RDKV-STB-1001");
		LOGGER.info("TEST DESCRIPTION: Verify the STB home screen matches with the reference image");
		LOGGER.info("TEST STEPS : ");
		LOGGER.info("1. Verify the home screen with reference image");
		LOGGER.info("#######################################################################################");
		MagickComparison magicCompare = new MagickComparison();
		ImageComparision mg = new ImageComparision();
		
		//	BufferedImage originalImg = ImageIO.read(new File(ConstantsSTB.REFRENCE_IMAGE_PATH));
			
		LOGGER.info("The tapenv data: " +tapEnv);
			try {
				stepNum = "S1";
				errorMessage = "The home screen and the current screen doesn't match";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : Verify the home screen with reference image.");
				LOGGER.info("STEP 1: ACTION : ACTION: Capture the live screen image of the home screen and compare it with actual image.");
				LOGGER.info("STEP 1: EXPECTED : The live image should match with home screen reference image.");
				LOGGER.info("*****************************************************************************************");
				
				originalImg = ImageIO.read(new File(ReferenceImageConstants.HOME_SCREEN_REFERENCE_IMG));
				
				actualImg = ImageIO.read(new File(ReferenceImageConstants.HOME_SCREEN_LIVE_IMG));
				
				LOGGER.info("STEP 1: Entering to image comparision method ");
				
		//		status = mg.compare(originalImg, actualImg);
				status = mg.compare(originalImg, actualImg);
				LOGGER.info("STEP 1: Image comparison exection completed");
				
				if (status) {
					LOGGER.info("The status of image comparision is: " + status);
				} else {
					LOGGER.error("STEP 1: ACTUAL : " + errorMessage);
				}
				LOGGER.info("**********************************************************************************");
				
				
				
				tapEnv.updateExecutionStatus(device, testId, stepNum, status, errorMessage, false);
				
			} catch (IOException e) {
				LOGGER.error("Exception occured while reading the image file " + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.info("Inside catch");
				errorMessage = e.getMessage();
				LOGGER.error("Exception while reading the image file: " + errorMessage);
				CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
				
			}
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1001");
		
	}
}
