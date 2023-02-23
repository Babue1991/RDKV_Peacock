package com.automatics.rdkv.STBhomescreen;

import java.io.IOException;

public class TerminalCommands {

	public static void main(String[] args) throws InterruptedException {
		String XfinityButton = "irsend SEND_ONCE Apple Comcast_Xfinity";
		String Left_Move ="irsend SEND_ONCE Apple Comcast_Left";
		String Click_OK = "irsend SEND_ONCE Apple Comcast_OK";
		String Click_Down = "irsend SEND_ONCE Apple Comcast_Down";
		executeCommand(XfinityButton);
	//	executeCommand(Left_Move);
	//	executeCommand(Left_Move);
		executeCommand(Click_OK);
		executeCommand(Click_Down);
		executeCommand(Click_OK);
	}

	public static void executeCommand(String command) throws InterruptedException {
		try {
			Thread.sleep(2000L);
			Runtime.getRuntime().exec(command);
			System.out.println("Terminal command executed: "+command);
		} catch (IOException e) {
			System.out.println("Error in command execution: "+command);
			e.printStackTrace();
		}
	}

}
