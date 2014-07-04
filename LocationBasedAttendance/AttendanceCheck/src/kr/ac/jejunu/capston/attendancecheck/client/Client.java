package kr.ac.jejunu.capston.attendancecheck.client;

import java.io.Serializable;
import java.net.Socket;

import kr.ac.jejunu.capston.attendancecheck.callback.CallBack;
import kr.ac.jejunu.capston.attendancecheck.threadpolicy.ThreadPolicy;
import android.util.Log;

public class Client {

	private Socket socket;
	private String dataHeader;
	private Serializable data;
	private CallBack callBackEvent;

	private final String serverIP = "117.17.102.54";
	private final int serverPort = 3335;

	public Client(String dataHeader, Serializable data, CallBack callBackEvent) {
		new ThreadPolicy();
		this.dataHeader = dataHeader;
		this.data = data;
		this.callBackEvent = callBackEvent;
	}

	public void connectToServer() {
		try {
			socket = new Socket(serverIP, serverPort);
			new Sender(socket, dataHeader, data).run();
			new Receiver(socket, callBackEvent).run();
		} catch (Exception e) {
			Log.e("TCP", "C: Connecting error", e);
		}
	}
}
