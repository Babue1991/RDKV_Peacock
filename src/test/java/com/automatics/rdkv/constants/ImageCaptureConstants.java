package com.automatics.rdkv.constants;

import com.automatics.rdkv.commonmethods.CommonMethods;

public class ImageCaptureConstants {

	/********The variable used to send capture card port to capture image**/
	public static String VIDEO_PORT="/dev/video1";
	
	/********The variable used to send capture card port to capture image**/
//	public static String SET_VIDEO_PORT="/dev/video1";
	
	
	public static String SET_VIDEO_PORT="sudo v4l2-ctl --device /dev/video1 --set-input=1";
	
	
	
	/********The variable used to send capture card port to capture image**/
	public static String ROOT_DIRECTORY=System.getProperty("user.dir");
	
	public static String REFERENCE_IMAGE_PATH=ROOT_DIRECTORY+"/src/test/java/com/automatics/rdkv/referenceimage/";

	public static String STB_HOME_APPS_BUTTON_IMAGE=REFERENCE_IMAGE_PATH+"Xfinity_Home.jpg";
	
	public static String STB_APP_TITLE_IMAGE=REFERENCE_IMAGE_PATH+"ApplicationTextImage.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String LIVE_IMAGE_PATH=ROOT_DIRECTORY+"/src/test/java/com/automatics/rdkv/liveimage/";
	

	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_HOME_SCREEN=LIVE_IMAGE_PATH+"XfinityHomeScreen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_APPLICATION_SCREEN=LIVE_IMAGE_PATH+"ApplicationScreen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_APPLICATION_FOCUS_PEACOCK=LIVE_IMAGE_PATH+"ApplicationFocusPeacock.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String XFINITY_PEACOCK_SPLASH_SCREEN=LIVE_IMAGE_PATH+"SplashScreen.jpg";
	
	
	/********The variable used to send capture card port to capture image**/
	public static String PEACOCK_HOME_SCREEN=LIVE_IMAGE_PATH+"Peacock_home_screen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String PEACOCK_HOME_LEFT_HIDDEN_MENU=REFERENCE_IMAGE_PATH+"PeacockHomeLeftHiddenMenu.jpg";
	
	/********The variable used to send capture card port to capture image**/
//	public static String XFINITY_APPLICATION_SCREEN=LIVE_IMAGE_PATH+"ApplicationScreen.jpg";
	
	/********The variable used to send capture card port to capture image**/
	public static String homescren=LIVE_IMAGE_PATH+"ApplicationScreen.jpg";
	

	/********The variable used to send capture card port to capture image**/
	public static String BEGIN_COMMAND="sudo gst-launch-1.0 v4l2src device=";
	
	public static String COMP_PATH="sudo gst-launch-1.0 v4l2src device="+VIDEO_PORT+" "+"num-buffers=1 ! jpegenc ! filesink location="+XFINITY_HOME_SCREEN;
	
	/********The variable used to send capture card port to capture image**/
	public static String EMPTY_SPACE=" ";
	
	/********The variable used to send capture card port to capture image**/
	public static String MIDDLE_COMMAND="num-buffers=1 ! jpegenc ! filesink location=";
	
	/********The variable used to send capture card port to capture image**/
	public static String CAPTURE_COMMAND=BEGIN_COMMAND+VIDEO_PORT+EMPTY_SPACE+MIDDLE_COMMAND;
	
	/********The variable used to send capture card port to capture Peacock menu reference Screen image**/
	public static String PEACOCK_LEFTMENU_REFERENCE_SCREEN=REFERENCE_IMAGE_PATH+"Menu.jpg";
	
	/********The variable used to send capture card port to capture Peacock menu live Screen image**/
	public static String PEACOCK_LEFTMENU_LIVE_SCREEN=REFERENCE_IMAGE_PATH+"MenuLiveScreen.jpg";
	
	/********The variable used to send capture card port to capture Peacock menu movies option image**/
	public static String PEACOCK_MENU_MOVIE_OPTION=REFERENCE_IMAGE_PATH+"MovieOption.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_SCREEN=LIVE_IMAGE_PATH+"MovieSection.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PLAY_CONTENT=LIVE_IMAGE_PATH+"MovieContent.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PLAY_CONTENT_SCREEN=LIVE_IMAGE_PATH+"MovieContentScreen.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PLAY_NEXT_CONTENT=LIVE_IMAGE_PATH+"MovieNextContent.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PAUSE_CONTENT=LIVE_IMAGE_PATH+"MovieContentPause.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN=LIVE_IMAGE_PATH+"MovieContentPauseScreen.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_REFERENCE_PAUSE_ICON=REFERENCE_IMAGE_PATH+"Pause_icon.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"Play.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN_NEXT=LIVE_IMAGE_PATH+"MovieContentPauseScreenTwo.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_SUBTITLE_BUTTON=LIVE_IMAGE_PATH+"MovieSubtitleButton.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_SUBTITLE=LIVE_IMAGE_PATH+"MovieSubtitle.jpg";

	
	//Search Bar 
	/********The variable used to send capture card port to capture Peacock search menu option image**/
	public static String PEACOCK_SEARCH_BUTTON_HIGHLIGHT=REFERENCE_IMAGE_PATH+"SearchbarHighlight.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_BUTTON_HIGHLIGHT_LIVE=LIVE_IMAGE_PATH+"SearchMenu.jpg";
	
	/********The variable used to send capture card port to capture Peacock search menu option image**/
	public static String PEACOCK_SEARCH_BAR=REFERENCE_IMAGE_PATH+"Searchbarkeys.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_BAR_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchKeyboard.jpg";
	
	/********The variable used to send capture card port to capture Peacock search bar text image**/
	public static String PEACOCK_SEARCH_BAR_TEXT=REFERENCE_IMAGE_PATH+"SearchbarTextVerify.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCHBAR_TEXT_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchText.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String PEACOCK_SEARCH_FEATURE=REFERENCE_IMAGE_PATH+"SearchAntz.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_FEATURE_LIVE_IMAGE=LIVE_IMAGE_PATH+"AntzSearch.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String PEACOCK_SEARCH_MYSTUFF=REFERENCE_IMAGE_PATH+"SearchMystuff.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_MYSTUFF_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchMystuff.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_RESUME_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchResume.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PLAY_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchPlay.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PLAY_NEXT_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchPlay.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PAUSE_CONTENT=LIVE_IMAGE_PATH+"SearchPause.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
<<<<<<< HEAD
	public static String PEACOCK_SEARCH_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"SearchPlayReference.jpg";
=======
	public static String PEACOCK_SEARCH_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"SearchPlayIcon.jpg";
>>>>>>> da0a08f3d45e4feee750f3f1370079959704c597
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN=LIVE_IMAGE_PATH+"SearchPause.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
<<<<<<< HEAD
	public static String PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN_NEXT=LIVE_IMAGE_PATH+"SearchPause.jpg";
	
=======
	public static String PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN_NEXT=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_SUBTITLE_BUTTON=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_SUBTITLE=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";
>>>>>>> da0a08f3d45e4feee750f3f1370079959704c597
	//Search
	
	/********The variable used to send capture card port to capture Peacock menu movies option image**/
	public static String PEACOCK_MENU_TVSHOW_OPTION=REFERENCE_IMAGE_PATH+"TvShowOption.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOW_SCREEN=LIVE_IMAGE_PATH+"TvShowSection.jpg";
	
	
	
	//WWE Screen
	/********The variable used to send capture card port to capture Peacock WWE menu option image**/
	public static String PEACOCK_SCREEN_WWE_BUTTON=REFERENCE_IMAGE_PATH+"WWE.jpg";

	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String PEACOCK_WWE_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEButton.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String WWE_TITLE_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWETitle.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String WWE_SUBTITLE_BUTTON_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWESubtitlebutton.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String WWE_ENGLISH_SUBTITLE_BUTTON_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEEnglishSubtitlebutton.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String WWE_FASTFORWORD_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEfastforword.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String WWE_BACKFORWORD_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEbackforword.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String WWE_BACKFORWORD=REFERENCE_IMAGE_PATH+"WWE_BackForward.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String WWE_FASTFORWORD=REFERENCE_IMAGE_PATH+"WWE_Fastforword.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String WWE_MY_STUFF_LIVE_IMAGE=REFERENCE_IMAGE_PATH+"WWE_Fastforword.jpg";
	
	
	
	
}
