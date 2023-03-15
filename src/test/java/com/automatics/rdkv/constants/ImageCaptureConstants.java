package com.automatics.rdkv.constants;

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
	public static String PEACOCK_MOVIE_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"play_icon.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_PAUSE_CONTENT_SCREEN_NEXT=LIVE_IMAGE_PATH+"MovieContentPauseScreenTwo.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_SUBTITLE_BUTTON=LIVE_IMAGE_PATH+"MovieSubtitleButton.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_MOVIE_SUBTITLE=LIVE_IMAGE_PATH+"MovieSubtitle.jpg";
	
	/********The variable used to read reference Peacock movie forward icon image**/
	public static String PEACOCK_MOVIE_REFERENCE_FORWARD=REFERENCE_IMAGE_PATH+"WWE_Fastforword.jpg";
	
	/********The variable used to send capture card port to capture live Peacock movie forward icon image**/
	public static String PEACOCK_MOVIE_LIVE_FORWARD=LIVE_IMAGE_PATH+"forward.jpg";
	
	/********The variable used to read reference Peacock movie back forward icon image**/
	public static String PEACOCK_MOVIE_REFERENCE_BACKFORWARD=REFERENCE_IMAGE_PATH+"WWE_BackForward.jpg";
	
	/********The variable used to send capture card port to capture live Peacock movie back forward icon image**/
	public static String PEACOCK_MOVIE_LIVE_BACKFORWARD=LIVE_IMAGE_PATH+"backward.jpg";
	
	//tv shows
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_PAUSE_CONTENT=LIVE_IMAGE_PATH+"TvshowsPause.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"Play.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_PAUSE_CONTENT_SCREEN=LIVE_IMAGE_PATH+"TVShowsSubtitle.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_PAUSE_CONTENT_SCREEN_NEXT=LIVE_IMAGE_PATH+"TVSubtitle.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_SUBTITLE_BUTTON=LIVE_IMAGE_PATH+"TVShowsSubtitle.jpg";

	//TV SHOWS
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_MYSTUFF_LIVE_IMAGE=LIVE_IMAGE_PATH+"TVShowsMyStuff.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_RESUME_LIVE_IMAGE=LIVE_IMAGE_PATH+"TVShowsMyStuff.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_PLAY_LIVE_IMAGE=LIVE_IMAGE_PATH+"TVShows.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOWS_PLAY_NEXT_LIVE_IMAGE=LIVE_IMAGE_PATH+"TVShowsNextLive.jpg";
	
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
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String PEACOCK_CHANNEL_VERIFY=REFERENCE_IMAGE_PATH+"Channels.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_MYSTUFF_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchMystuff.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_RESUME_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchResume.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PLAY_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchPlay.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String SLE_LIVE_CHECK=LIVE_IMAGE_PATH+"SLE.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PLAY_NEXT_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchNextPlay.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PAUSE_CONTENT=LIVE_IMAGE_PATH+"SearchPause.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String PEACOCK_SEARCH_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"SearchPlayReference.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN=LIVE_IMAGE_PATH+"SearchPauseImg.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_SUBTITLE_BUTTON=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_SUBTITLE=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";
	
	/********The variable used to send capture card port to capture Peacock search Feature Antz image**/
	public static String PEACOCK_LEFTMENU_REFERENCE_IMAGE=REFERENCE_IMAGE_PATH+"SearchPlayReference.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_LEFTMENU_LIVE_IMAGE=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";

	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_SEARCH_PAUSE_CONTENT_SCREEN_NEXT=LIVE_IMAGE_PATH+"SearchAntzPause.jpg";

	//Search
	
	/********The variable used to send capture card port to capture Peacock menu movies option image**/
	public static String PEACOCK_MENU_TVSHOW_OPTION=REFERENCE_IMAGE_PATH+"TvShowOption.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_TVSHOW_SCREEN=LIVE_IMAGE_PATH+"TvShowSection.jpg";
	
	/********The variable used to send capture card port to capture Movies Section Screen image**/
	public static String PEACOCK_CHANNELS_OPTION=LIVE_IMAGE_PATH+"ChannelsSection.jpg";
	
	/********The variable used to send capture card port to capture Peacock search menu option image**/
	public static String PEACOCK_TUNE_CHANNELS_VERIFY=REFERENCE_IMAGE_PATH+"TuneChannels.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String PEACOCK_CHANNELS_TUNE_VERIFY=LIVE_IMAGE_PATH+"ChannelsTune.jpg";
	
	/********The variable used to send capture card port to capture Search Section Screen image**/
	public static String CHANNELS_CHEERS_LIVE=LIVE_IMAGE_PATH+"ChannelsCheers.jpg";
	
	//WWE Screen
	/********The variable used to send capture card port to capture Peacock WWE menu option image**/
	public static String PEACOCK_SCREEN_WWE_BUTTON=REFERENCE_IMAGE_PATH+"WWE.jpg";

	
	/********The variable used to send capture card port to capture WWE Section Screen image**/
	public static String PEACOCK_WWE_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEButton.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Title Screen image**/
	public static String WWE_TITLE_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWETitle.jpg";
	
	/********The variable used to send capture card port to capture WWE section My stuff image**/
	public static String WWE_MY_STUFF_LIVE_IMAGE=REFERENCE_IMAGE_PATH+"WWEmystuff.jpg";
	
	/********The variable used to send capture card port to capture WWE Section Subtitle Screen image**/
	public static String WWE_SUBTITLE_BUTTON_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWESubtitlebutton.jpg";
	
	/********The variable used to send capture card port to capture WWE Section English subtitle Screen image**/
	public static String WWE_ENGLISH_SUBTITLE_BUTTON_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEEnglishSubtitlebutton.jpg";
	
	/********The variable used to send capture card port to capture WWE Section fast forward Screen image**/
	public static String WWE_FASTFORWORD_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEfastforword.jpg";
	
	/********The variable used to send capture card port to capture WWE Section back forward Screen image**/
	public static String WWE_BACKFORWORD_LIVE_IMAGE=LIVE_IMAGE_PATH+"WWEbackforword.jpg";
	
	/********The variable used to read reference Peacock WWE Back forward icon image**/
	public static String WWE_BACKFORWORD=REFERENCE_IMAGE_PATH+"WWE_BackForward.jpg";
	
	/********The variable used to read reference Peacock wwe fast forward icon image**/
	public static String WWE_FASTFORWORD=REFERENCE_IMAGE_PATH+"WWE_Fastforword.jpg";
	

	/********The variable used to send capture card port to capture wwe content video pause image**/
	public static String PEACOCK_WWE_PAUSE_CONTENT=REFERENCE_IMAGE_PATH+"WWEpause.jpg";
	
	
	/********The variable used to read reference Peacock wwe play icon image**/
	public static String PEACOCK_WWE_REFERENCE_PLAY_ICON=REFERENCE_IMAGE_PATH+"WWE_Fastforword.jpg";
	
	/********The variable used to send capture card port to capture wwe content video pause screen image**/
	public static String PEACOCK_WWE_PAUSE_CONTENT_SCREEN=REFERENCE_IMAGE_PATH+"WWEpausescreen.jpg";
	
	/********The variable used to send capture card port to capture wwe content video pause next image**/
	public static String PEACOCK_WWE_PAUSE_CONTENT_SCREEN_NEXT=REFERENCE_IMAGE_PATH+"WWEpausescreennext.jpg";

	//channels
	/********The variable used to send capture card port to channels image**/

	public static String PEACOCK_CHANNELS=LIVE_IMAGE_PATH+"Trickplay.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_LINEAR_OPTION=LIVE_IMAGE_PATH+"PeacockLinear.jpg";
	
	/********The variable used to send capture card port to capture wwe content video pause next image**/
	public static String PEACOCK_LINEAR_REF_IMG_VERIFY=REFERENCE_IMAGE_PATH+"LinearRef.jpg";
	
	/********The variable used to send capture card port to channels option image**/
	public static String TRICK_PLAY=LIVE_IMAGE_PATH+"Channelsoption.jpg";
	
	/********The variable used to send capture card port to capture linear channels image**/


	public static String PEACOCK_LINEAR_CHANNELS_VERIFY=REFERENCE_IMAGE_PATH+"linearchannel.jpg";
	
	/********The variable used to send capture card port to capture linear channels image**/
	public static String TRICK_PLAY_REF=REFERENCE_IMAGE_PATH+"LinearRef.jpg";

	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_NEXT_TUNE_VERIFY=LIVE_IMAGE_PATH+"Tune.jpg";
	
	public static String LINEARCHANNELS_OPTION=REFERENCE_IMAGE_PATH+"LinearRef.jpg";
	
	
	/********The variable used to send capture card port to capture linear channels image**/
	public static String PEACOCK_TPLAY_VERIFY=REFERENCE_IMAGE_PATH+"Channels.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_TRIPLAY_OPTION=LIVE_IMAGE_PATH+"TPlay.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_CHANNELS_NEXT_TUNE_VERIFY=LIVE_IMAGE_PATH+"Play.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_TUNE_VERIFY=LIVE_IMAGE_PATH+"TuneVerify.jpg";

	/********The variable used to send capture card port to capture linear channels image**/
	public static String PEACOCK_TRICK_PLAY_VERIFY=REFERENCE_IMAGE_PATH+"Trickplayref.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String CHANNELS_REWIND=LIVE_IMAGE_PATH+"Rewind.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_CHANNELS_NEXT_IMG=LIVE_IMAGE_PATH+"NextImg.jpg";
	
	/********The variable used to send capture card port to capture linear channels image**/
	public static String REWIND_REF=REFERENCE_IMAGE_PATH+"Channels.jpg";


	/********The variable used to send capture card port to capture linear channels image**/
	public static String PEACOCK_TRICK_PLAY=REFERENCE_IMAGE_PATH+"Trickplayref.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String CHANNELS_FAST_FORWARD=LIVE_IMAGE_PATH+"Fastforward.jpg";

	
	/********The variable used to send capture card port to channels image**/
	public static String CHANNELS_PAUSE=LIVE_IMAGE_PATH+"PauseTrick.jpg";


	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_CHANNEL_ADS_TIMER=LIVE_IMAGE_PATH+"timer.jpg";
	

	/********The variable used to send capture card port to capture linear channels image**/

	public static String PEACOCK_PAUSE_REF=REFERENCE_IMAGE_PATH+"PausePP.jpg";

	public static String PEACOCK_PAUSE_REF_TWO=REFERENCE_IMAGE_PATH+"Trickplayref.jpg";
	
	/********The variable used to send capture card port to capture linear channels image**/
	public static String PEACOCK_PLAY_REF=REFERENCE_IMAGE_PATH+"PlayPP.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String CHANNELS_PLAY=LIVE_IMAGE_PATH+"ChannelTrickPlay.jpg";
	
	/********The variable used to send capture card port to capture linear channels image**/
	public static String PEACOCK_REWIND_REF=REFERENCE_IMAGE_PATH+"Zeroref.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String CHANNELS_TRICK_REWIND=LIVE_IMAGE_PATH+"ChannelTrickRewind.jpg";
	
	/********The variable used to send capture card port to capture linear channels image**/
	public static String CHANNELS_PLAY_TRICK_REFERENCE=REFERENCE_IMAGE_PATH+"Trickplayref.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String CHANNELS_PLAY_TRICK=LIVE_IMAGE_PATH+"ChannelsLivImg.jpg";

	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_LINEAR_CHANNEL_NOW=LIVE_IMAGE_PATH+"linear.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_MOVIE_ASSET_TRANSITION=LIVE_IMAGE_PATH+"asset.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_MOVIE_NEXT_ASSET_TRANSITION=LIVE_IMAGE_PATH+"assetNext.jpg";

	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_CHANNELS_NEXT_OPTION=LIVE_IMAGE_PATH+"NextImg.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_LINEAR_CHANNEL_EPISODES=LIVE_IMAGE_PATH+"episodes.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_LINEAR_CHANNEL_NEXT_EPISODE=LIVE_IMAGE_PATH+"nextepisode.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_LINEAR_CHANNEL_PREVIOUS_EPISODE=LIVE_IMAGE_PATH+"previousepisode.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PLC_ADS_TP_PAUSE_REF=REFERENCE_IMAGE_PATH+"Adspause.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PLC_ADS_TP_PAUSE_LIVE=LIVE_IMAGE_PATH+"Adspause.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PLCHANNEL_EPISODES=LIVE_IMAGE_PATH+"multiepisode.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String PEACOCK_SLE=LIVE_IMAGE_PATH+"SLE.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String SLE_2_LIVE=LIVE_IMAGE_PATH+"SLEsecondl2.jpg";
	
	/********The variable used to send capture card port to channels image**/
	public static String SLE_FIRST_LIVE=LIVE_IMAGE_PATH+"SLEFirstl1.jpg";
	
}


