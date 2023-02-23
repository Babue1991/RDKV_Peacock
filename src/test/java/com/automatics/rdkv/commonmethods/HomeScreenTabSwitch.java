package com.automatics.rdkv.commonmethods;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import com.automatics.rdkv.captureimage.CaptureLiveImage;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.test.AutomaticsTestBase;


public class HomeScreenTabSwitch extends AutomaticsTestBase{

	static boolean status;

	public boolean clickAppsButton() {
		Mat referenceImage;
		Mat liveImage;
		nu.pattern.OpenCV.loadLocally();
		
		LOGGER.info("Reading reference image from: "+ImageCaptureConstants.STB_HOME_APPS_BUTTON_IMAGE);
		referenceImage = Imgcodecs.imread(ImageCaptureConstants.STB_HOME_APPS_BUTTON_IMAGE);
		ImageCompare imgCompare = new ImageCompare();
		try {
			
			for (int iterator = 0; iterator <= 7; iterator++) {

				LOGGER.info("Reading live image from path: "+ImageCaptureConstants.XFINITY_HOME_SCREEN);
				liveImage=Imgcodecs.imread(ImageCaptureConstants.XFINITY_HOME_SCREEN);

				status =imgCompare.templateMatch(referenceImage, liveImage);

				if(status == true)
				{
					LOGGER.info("The image matche found and it's status " +status);
					LOGGER.info("Reading live image from path: "+ImageCaptureConstants.XFINITY_HOME_SCREEN);
					LOGGER.info("Click Ok button in remote");
					CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
					break;
				}
				else {

					LOGGER.info("Image not matching, So click left button "+iterator);
					CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

					LOGGER.info("Make another screenshot number "+iterator);
					CaptureLiveImage.capture(ImageCaptureConstants.XFINITY_HOME_SCREEN);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;

	}

}


