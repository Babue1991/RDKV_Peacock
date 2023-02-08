package com.automatics.rdkv.SplashScreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.testng.annotations.Test;

import com.automatics.annotations.TestDetails;
import com.automatics.constants.DataProviderConstants;
import com.automatics.device.Dut;
import com.automatics.rdkb.BroadBandTestGroup;
import com.automatics.rdkb.utils.CommonUtils;
import com.automatics.rdkv.commonmethods.CommonMethods;
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
			BroadBandTestGroup.NEW_FEATURE, BroadBandTestGroup.WEBPA })
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
		ImageCompare mg = new ImageCompare();
		
		//	BufferedImage originalImg = ImageIO.read(new File(ConstantsSTB.REFRENCE_IMAGE_PATH));
			
	//	LOGGER.info("The tapEnv data: " +tapEnv);
			try {
				stepNum = "S1";
				errorMessage = "Failed to launch Xfinity Menu";
				LOGGER.info("*****************************************************************************************");
				LOGGER.info("STEP 1: DESCRIPTION : This test is to verify user can launch peacock app successfully from Xfinity menu using remote keys");
				LOGGER.info("STEP 1: ACTION : ACTION: Press Xfinity button on the comcast remote");
				LOGGER.info("STEP 1: EXPECTED : Xfinity menu should launch successfully.");
				LOGGER.info("*****************************************************************************************");
				
				
			//	CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);
				
			//	com.automatics.rdkv.STBhomescreen.CaptureLiveImage obj = new CaptureLiveImage();
			//	obj.ca
				
				PeacockAppLaunch obj =new PeacockAppLaunch();
				
				String port = "/dev/video1";
				String location = "/var/lib/jenkins/workspace/homescreen1.jpg";
				String cmd="sudo v4l2-ctl --device /dev/video1 --set-input=1";
				String ifconfig="ifconfig";
				String ss = "gst-launch-1.0 v4l2src device="+ port+" num-buffers=1 ! jpegenc ! filesink location="+location;
			//	CommonMethods.execCommand("v4l2-ctl --device " + port + " --set-input=1");
				p = Runtime.getRuntime().exec(cmd);
				p.waitFor();
				p = Runtime.getRuntime().exec("root123");
			    p.waitFor();
				Thread.sleep(5000L);
				System.out.println("The command is "+ss);
				obj.printResults(p);
				Thread.sleep(3000L);
				//CommonMethods.execCommand("gst-launch-1.0 v4l2src device=" + port + " num-buffers=1 ! jpegenc ! filesink location=" + location);
				/*
				 * String cmd1="gst-launch-1.0 v4l2src device=" + port +
				 * " num-buffers=1 ! jpegenc ! filesink location=" + location; p =
				 * Runtime.getRuntime().exec(cmd1); Thread.sleep(5000L);
				 * 
				 * System.out.println("The command is "+cmd1);
				 * 
				 * //CommonMethods.execCaptureCommand(
				 * "/var/lib/jenkins/workspace/homescreen1.png"); obj.printResults(p);
				 * 
				 * Thread.sleep(3000L);
				 */
				
			//	CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_HOME_SCREEN);
				
				///home/user/eclipse-workspace/RDKV_Peacock/src/test/java/com/automatics/rdkv/liveimage/XfinityHomeScreen.jpg
				
				
				liveImage=Imgcodecs.imread("/var/lib/jenkins/workspace/homescreen1.jpg");
				referenceImage = Imgcodecs.imread("/home/user/eclipse-workspace/RDKV_Peacock/src/test/java/com/automatics/rdkv/referenceimage/Xfinity_Home.jpg");
				
				ImageCompare img = new ImageCompare();
				
				status = img.templateMatch(referenceImage, liveImage);
				
		//		  BufferedImage image = ImageIO.read(new File("c:\\test\\image.png"));
			//	  CommonMethods.AppButtonHighlight();
				
//				referenceImage = ImageIO.read(new File(ReferenceImageConstants.SPLASH_SCREEN_REFERENCE_IMG));
				
//				liveImage = ImageIO.read(new File(ReferenceImageConstants.SPLASH_SCREEN_LIVE_IMG));
				
				LOGGER.info("STEP 1: Entering to image comparision method ");
				
//				status = mg.compare(referenceImage, liveImage);
				LOGGER.info("STEP 1: Image comparison exection completed");
				
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
				LOGGER.error("Exception while reading the image file: " + errorMessage);
				CommonUtils.updateTestStatusDuringException(tapEnv, device, testId, stepNum, status, errorMessage, false);
				
			}finally {
				p.destroy();
			}
			LOGGER.info("ENDING TEST CASE: TC-RDKV-STB-1010");
		
	}
	public void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println("The terminal response is: "+line);
		}
	//	p.destroy();
	}

}



