package com.automatics.rdkv.commonmethods;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import com.automatics.rdkv.STBhomescreen.CropImage;
import com.automatics.rdkv.captureimage.CaptureLiveImage;
import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.IntergerCount;
import com.automatics.rdkv.constants.RemoteKeyContstants;
import com.automatics.rdkv.imagevalidation.ImageCompare;
import com.automatics.test.AutomaticsTestBase;


public class CommonMethods extends AutomaticsTestBase{

	public static String path;
	static String command;
	static Process p;
	static boolean status;
	static BufferedImage referenceImage;
	static BufferedImage liveImage;
	static BufferedImage subImage;
	static BufferedImage outputImage;
	public static void execCommand(String command) {
		try {

			Thread.sleep(2000L);
			p=Runtime.getRuntime().exec(command);
			printResults(p);
			Thread.sleep(3000L);
			LOGGER.info("The terminal command which is executed is : "+command);
			System.out.println();

		}catch(Exception e) {
			LOGGER.info("Error in terminal command execution : "+command);

			System.out.println();
			e.printStackTrace();
		}finally {
			p.destroy();
			System.out.println("Process destroyed in finally block");
		}
	}
	public static void execCommand1(String command) {
		try {

			//	Thread.sleep(2000L);
			p=Runtime.getRuntime().exec(command);
			printResults(p);
			//	Thread.sleep(3000L);
			LOGGER.info("The terminal command which is executed is : "+command);
			System.out.println();

		}catch(Exception e) {
			LOGGER.info("Error in terminal command execution : "+command);

			System.out.println();
			e.printStackTrace();
		}finally {
			p.destroy();
			System.out.println("Process destroyed in finally block");
		}
	}
	public static void execCommandIcon(String command) {
		try {

			p=Runtime.getRuntime().exec(command);
			printResults(p);
			LOGGER.info("The terminal command which is executed is : "+command);
			System.out.println();

		}catch(Exception e) {
			LOGGER.info("Error in terminal command execution : "+command);
			System.out.println();
			e.printStackTrace();
		}finally {
			p.destroy();
			System.out.println("Process destroyed in finally block");
		}
	}

	public static void execCommandRepeat(String command, int count) {

		for(int i = 1 ; i <= count; i++) {
			try {

				Thread.sleep(1000L);
				p=Runtime.getRuntime().exec(command);
				printResults(p);
				Thread.sleep(2000L);
				LOGGER.info("The terminal command which is executed is : "+command);
				System.out.println();

			}

			catch(Exception e) {
				LOGGER.info("Error in terminal command execution : "+command);

				System.out.println();
				e.printStackTrace();
			}
		}
		p.destroy();
	}
	public static void execCommandRepeat2(String command, int count) {

		for(int i = 1 ; i <= count; i++) {
			try {

				//				Thread.sleep(2000L);
				p=Runtime.getRuntime().exec(command);
				printResults(p);
				//				Thread.sleep(3000L);
				LOGGER.info("The terminal command which is executed is : "+command);
				System.out.println();

			}

			catch(Exception e) {
				LOGGER.info("Error in terminal command execution : "+command);

				System.out.println();
				e.printStackTrace();
			}
		}
		p.destroy();
	}

	public static void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			LOGGER.info("Terminal logs "+line);
			//	System.out.println(line);
		}
	}

	public static void execCaptureCommand(String imagePath) {
		try {
			Thread.sleep(3000L);
			CommonMethods.execCommand(ImageCaptureConstants.SET_VIDEO_PORT);
			System.out.println("The live image path: "+imagePath);

			String command=ImageCaptureConstants.CAPTURE_COMMAND+imagePath;
			CommonMethods.execCommand(command);

		}catch(Exception e) {

			System.out.println("Error in terminal command execution: "+command);
			e.printStackTrace();
		}


	}
	public static void setPort() {
		CommonMethods.execCaptureCommand(ImageCaptureConstants.SET_VIDEO_PORT);
	}

	public static boolean textCompare(String exepected, String actual) {

		LOGGER.info("The values are: "+exepected+" and "+actual);
		if(exepected.equals(actual)) {
			LOGGER.info("Both the text matching "+actual);
			status = true;
		}else {
			LOGGER.error("The actual string not returns exepected value: "+actual);
			status =false;
		}
		return status;

	}

	public static boolean partialTextCompare(String exepected, String actual) {

		LOGGER.info("The values are: "+exepected+" and "+actual);
		if(actual.contains(exepected)) {
			LOGGER.info("Search keyword found "+exepected);
			status = true;
		}else {
			LOGGER.error("Keyword not present: "+actual);
			status =false;
		}
		return status;
	}

	public static boolean checkText(String text) {

		LOGGER.info("The text is: "+text);
		if(text.isEmpty()) {
			LOGGER.error("String is empty ");
			status =false;		
		}
		else {
			LOGGER.info("Subtitle is present");
			status =true;
		}
		return status;

	}

	public static boolean checkNumber(String text) {
		LOGGER.info("The number is: "+text);

		if(isNumeric(text)){

			LOGGER.info("String has number ");
			status =true;	
		}
		else {
			LOGGER.error("Number not present: "+text);
			status =false;
		}

		return status;
	}
	public static boolean isNumeric(String string) {
		int intValue;

		System.out.println(String.format("Parsing string: \"%s\"", string));

		if(string == null || string.equals("")) {
			System.out.println("String cannot be parsed, it is null or empty.");
			return false;
		}

		try {
			intValue = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input String cannot be parsed to Integer.");
		}
		return false;
	}
	public static boolean checkEmptyText(String text) {

		if(text.isEmpty()) {
			LOGGER.info("String is empty ");
			status =true;		
		}
		else {
			LOGGER.error("Subtitle is present");
			status =false;
		}
		return status;

	}
	public static boolean checkSubtitle() throws IOException, InterruptedException {

		BufferedImage liveImage;
		BufferedImage subImage;
		String actual;

		nu.pattern.OpenCV.loadLocally();
		int i = 0;
		while (i < 10) {

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_MOVIE_SUBTITLE);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_MOVIE_SUBTITLE));

			LOGGER.info("Calling image cropping method");
			subImage = CropImage.cropImage(liveImage, 320,570,540,80);

			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			LOGGER.info("Calling method to read text in image");
			GrabText grabText = new GrabText();
			actual = grabText.crackImage(subImage);

			LOGGER.info("Calling text verify method");
			status = CommonMethods.checkText(actual);
			if(status == true) {
				LOGGER.info("The status of Subtile text verification is: " + status);
				LOGGER.info("Click Xfinity OK button ");
				CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
				break;
			}else {
				i++;
				LOGGER.info("The status of Subtile text verification is: " + status);
			}

		}
		return status;
	}
	public static void disablesubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity right button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000L);
	}
	public static void enablesubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity right button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity right button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000L);
	}

	public static void disableChannelSubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(5000L);
	}

	public static void disableSLEAssetSubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		TimeUnit. MINUTES. sleep(1);

		LOGGER.info("Click Xfinity Down button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);
		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);
		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);
		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(5000L);
	}
	public static void enableSLEAssetSubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity Down button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity right button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

		Thread.sleep(1000L);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000L);
	}

	public static void enableChannelSubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000L);
	}

	public static void enableChannelSpanishSubtitle() throws InterruptedException {

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000L);
	}
	public static void enableChannelAudio() throws InterruptedException {

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity right button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000L);
	}


	public static String currentDirectoryPath() {
		System.out.println("BeforePath");

		path =System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}

	public static void launchPeacockApp() throws InterruptedException {
		LOGGER.info("Click Xfinity button ");
		CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);
		Thread.sleep(2000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(3000);

		LOGGER.info("Click Xfinity down button ");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);
		Thread.sleep(2000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(30000);

	}

	public static void tuneChannels() throws InterruptedException {

		LOGGER.info("Click Xfinity LEFT button ");
		CommonMethods.execCommand(RemoteKeyContstants.LEFT_BUTTON);
		Thread.sleep(2000);

		LOGGER.info("Click six DOWN_BUTTON ");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.SIX);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);
		Thread.sleep(30000);

	}

	public static void Trickplay() throws InterruptedException, IOException {
		int i=5;
		for(i=1;i<=5;i++) {
			LOGGER.info("Click Xfinity DOWN button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.DOWN_BUTTON, IntergerCount.TWO);
			LOGGER.info("Click Xfinity OK button ");
			CommonMethods.execCommandRepeat2(RemoteKeyContstants.OK_BUTTON, IntergerCount.TWO);
			Thread.sleep(15000L);

			LOGGER.info("Click Xfinity Right button ");
			CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

			LOGGER.info("Capture application screen live image");
			CaptureLiveImage.captureIcon(ImageCaptureConstants.PEACOCK_CHANNELS);

			LOGGER.info("Reading live image");
			liveImage = ImageIO.read(new File(ImageCaptureConstants.PEACOCK_CHANNELS));

			LOGGER.info("Reading reference image");
			referenceImage =ImageIO.read(new File(ImageCaptureConstants.PEACOCK_TRICK_PLAY_VERIFY));

			LOGGER.info("Calling crop method");
			subImage = CropImage.cropImage(liveImage, 540,640,200,40);


			File outputFile = new File("/var/lib/jenkins/workspace/image1.jpg");
			ImageIO.write(subImage, "jpg", outputFile);

			outputImage = ImageIO.read(new File("/var/lib/jenkins/workspace/image1.jpg"));

			ImageCompare imgCompare =new ImageCompare();
			LOGGER.info("Calling screen compare method");
			status = imgCompare.compare2(referenceImage, outputImage);
			Thread.sleep(10000);

			if(status==true) {
				LOGGER.info("It's supports trick play");
			}
			else {

				LOGGER.info("It does not supports trick play");


			}

		}
	}

	public static void navigateToChannelFour() throws InterruptedException {
		LOGGER.info("Click Xfinity button ");
		CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Pressing apps button icon ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Switching to popular entertainment section ");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Launching peacock application ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(30000);

		LOGGER.info("Switching to menu screen");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Moving to channel section ");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,6);

		LOGGER.info("Selecting channel menu");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(5000);

		LOGGER.info("Switching to channel 4");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,4);
	}
	
	
	public static void navigateToChannelFive() throws InterruptedException {
		LOGGER.info("Click Xfinity button ");
		CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Pressing apps button icon ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Switching to popular entertainment section ");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Launching peacock application ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(30000);

		LOGGER.info("Switching to menu screen");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Moving to channel section ");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,6);

		LOGGER.info("Selecting channel menu");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(5000);

		LOGGER.info("Switching to channel 5");
		//CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,6);
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		
		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		
		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		
		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

	}
	public static void navigateToChannelSeven() throws InterruptedException {
		LOGGER.info("Click Xfinity button ");
		CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Pressing apps button icon");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Switching to popular entertainment section");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Launching peacock application");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(30000);

		LOGGER.info("Switching to menu screen ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Moving to channel section");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,6);

		LOGGER.info("Selecting channel menu");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(5000);
		LOGGER.info("Switching to channel 7");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,7);
		
		/*
		 * LOGGER.info("Tune to channel 2");
		 * CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		 * 
		 * LOGGER.info("Tune to channel 3");
		 * CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		 * 
		 * LOGGER.info("Tune to channel 4");
		 * CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		 * 
		 * LOGGER.info("Tune to channel 5");
		 * CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		 * 
		 * LOGGER.info("Tune to channel 6");
		 * CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		 * 
		 * LOGGER.info("Tune to channel 7");
		 * CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);
		 */
	}
	public static void navigateToLinearChannel() throws InterruptedException {
		LOGGER.info("Click Xfinity button ");
		CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Click Xfinity down button ");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(30000);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity down button 6 times ");
		CommonMethods.execCommandRepeat(RemoteKeyContstants.DOWN_BUTTON,6);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
	}
	public static void navigateToSLE() throws InterruptedException {

		LOGGER.info("Click Xfinity button ");
		CommonMethods.execCommand(RemoteKeyContstants.XFINITY_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(3000);

		LOGGER.info("Click Xfinity down button ");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(30000);

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		LOGGER.info("Click Xfinity up button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.UP_BUTTON);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(5000);

		LOGGER.info("Click Xfinity right button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.RIGHT_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Click Xfinity down button ");
		CommonMethods.execCommand(RemoteKeyContstants.DOWN_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(10000);

		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);

		LOGGER.info("Click Xfinity down button");
		CommonMethods.execCommandIcon(RemoteKeyContstants.DOWN_BUTTON);


		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.OK_BUTTON);

	}

	public static void rewindSLE() throws InterruptedException {

		LOGGER.info("Click Xfinity left button ");
		CommonMethods.execCommandIcon(RemoteKeyContstants.LEFT_BUTTON);

		Thread.sleep(10000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);

		Thread.sleep(2000);

		LOGGER.info("Click Xfinity OK button ");
		CommonMethods.execCommand(RemoteKeyContstants.OK_BUTTON);
	}

	public static boolean checkGOLive(String text) {
		LOGGER.info("The text is: "+text);
		if (text.matches("Go Live")) {
			LOGGER.info("Go Live present");
			status =false;	
		}else {
			LOGGER.info("Go Live is not present");
			status =true;
		}
		return status;
	}
}
