package com.automatics.rdkv.STBhomescreen;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ssh {

	public static void main(String[] args) {

		        try {
		            JSch jsch = new JSch();
		            String username = "root"; // your username
		            String host = "127.0.0.1"; // your remote server address
		            int port = 33000; // your remote server port
		            String password = "root123"; // your username's password
		 
		            Session session = jsch.getSession(username, host, port);
		            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
		            session.setPassword(password);
		            session.setConfig("StrictHostKeyChecking", "no");
		            session.setTimeout(15000);
		            session.connect();
		        } catch (JSchException e) {
		            e.printStackTrace();
		        }
		    }
		 
	

}
