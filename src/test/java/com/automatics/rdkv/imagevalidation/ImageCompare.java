package com.automatics.rdkv.imagevalidation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.test.AutomaticsTestBase;

import nu.pattern.OpenCV;


public class ImageCompare extends AutomaticsTestBase {
	static Mat reference_image;
	static Mat live_Image;
	static boolean status;
	
	public static void main(String args[]) throws IOException {
		File file = new File("home/user");
		System.out.println("Start");
		nu.pattern.OpenCV.loadLocally();
	//	OpenCV.loadShared();
	//	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		reference_image = Imgcodecs.imread("/home/user/Downloads/forward.jpg");
		live_Image = Imgcodecs.imread("/home/user/Desktop/forward.jpg");
		
		ImageCompare obj = new ImageCompare();
		obj.templateMatch(reference_image,live_Image);
		System.out.println("end");

	}
	public boolean templateMatch(Mat reference_image, Mat live_Image) {

		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat source=null;
		Mat template=null;
		String filePath=ImageCaptureConstants.LIVE_IMAGE_PATH;
		System.out.println("The path is: "+filePath);
		//Load image file
		source=live_Image;
		template=reference_image;

		Mat outputImage=new Mat();    
		int machMethod=Imgproc.TM_CCOEFF;
		//Template matching method
		try {
		Imgproc.matchTemplate(source, template, outputImage, machMethod);


		MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
		Point matchLoc=mmr.maxLoc;
		//Draw rectangle on result image
	
		Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
			matchLoc.y + template.rows()), new Scalar(255, 255, 255));

		Imgcodecs.imwrite(filePath+"matched.jpg", source);
		System.out.println("Completed");
		status=true;
		}catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}
	public boolean compare(BufferedImage imgA, BufferedImage imgB)
	{

		boolean status;
		// Assigning dimensions to image
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		LOGGER.info("The reference image dimension is: "+ "Width" +width1 + "Height" +height1);
		LOGGER.info("The live image dimension is: "+ "Width" +width2 + "Height" +height2);
		
		// Checking whether the images are of same size or
		// not
		if ((width1 != width2) || (height1 != height2)) {

			// Display message straightaway
			LOGGER.error("Error: Images dimensions" + " mismatch");
			status=false;
		}else {

			// By now, images are of same size

			long difference = 0;

			// treating images likely 2D matrix

			// Outer loop for rows(height)
			for (int y = 0; y < height1; y++) {

				// Inner loop for columns(width)
				for (int x = 0; x < width1; x++) {

					int rgbA = imgA.getRGB(x, y);
					int rgbB = imgB.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA)&0xff;
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB)&0xff;

					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}

			// Total number of red pixels = width * height
			// Total number of blue pixels = width * height
			// Total number of green pixels = width * height
			// So total number of pixels = width * height *
			// 3
			double total_pixels = width1 * height1 * 3;

			// Normalizing the value of different pixels
			// for accuracy

			// Note: Average pixels per color component
			double avg_different_pixels = difference / total_pixels;

			// There are 255 values of pixels in total
			double percentage = (avg_different_pixels / 255) * 100;

			// Lastly print the difference percentage
			LOGGER.info("The image match percentage value" +percentage);
			
			if(percentage == 0) {
					status=true;
			}else {
					status=false;
			}
		}

		return status;
	}
	
	public void imageSizeValidation() {
		
	}

}
