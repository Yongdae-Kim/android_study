package kr.ac.jejunu.capston.attendanceserver.main;

import kr.ac.jejunu.capston.attendanceserver.server.Server;

public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		server.connectToClient();
	}
}
