package com.automatics.rdkv.imagevalidation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.automatics.rdkv.constants.ImageCaptureConstants;

public class compare {

	public static void main(String[] args) throws IOException {
		
		BufferedImage referenceImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));
		BufferedImage liveImage = ImageIO.read(new File("/home/user/eclipse-workspace/RDKV_Peacock/src/test/java/com/automatics/rdkv/referenceimage/Play.jpg"));
		compare cm = new compare();
		cm.compareImage(referenceImage,liveImage);
		
		
		// TODO Auto-generated method stub

	}
	
	public boolean compareImage(BufferedImage imgA, BufferedImage imgB)
	{

		boolean status;
		// Assigning dimensions to image
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		//LOGGER.info("The reference image dimension is: "+ "Width" +width1 + "Height" +height1);
		//LOGGER.info("The live image dimension is: "+ "Width" +width2 + "Height" +height2);
		
		System.out.println("The reference image dimension is: "+ "Width" +width1 + "Height" +height1);
		System.out.println("The live image dimension is: "+ "Width" +width2 + "Height" +height2);
		
		
		// Checking whether the images are of same size or
		// not
		if ((width1 != width2) || (height1 != height2)) {

			// Display message straightaway
			//LOGGER.error("Error: Images dimensions" + " mismatch");
			System.out.println("Error: Images dimensions" + " mismatch");
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
			//LOGGER.info("The image match percentage value" +percentage);
			System.out.println("The image match percentage value" +percentage);
			if(percentage == 0) {
					status=true;
			}else {
					status=false;
			}
		}

		return status;
	}

}
