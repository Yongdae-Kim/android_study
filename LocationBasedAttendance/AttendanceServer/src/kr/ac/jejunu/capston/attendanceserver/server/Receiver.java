package kr.ac.jejunu.capston.attendanceserver.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import kr.ac.jejunu.capston.attendanceserver.callback.CallBack;

public class Receiver implements Runnable {
	private Socket socket;
	private CallBack callBackEvent;

	public Receiver(Socket socket, CallBack callBackEvent) {
		this.socket = socket;
		this.callBackEvent = callBackEvent;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			BufferedInputStream bufFilterIn = new BufferedInputStream(in);
			ObjectInputStream objFilterIn = new ObjectInputStream(bufFilterIn);

			callBackEvent.callBackMethod(objFilterIn.readObject());
		} catch (IOException ioe) {
			System.out.println("S : Receive IO Error " + ioe.getMessage());
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("S : Receive Class Error " + cnfe.getMessage());
			cnfe.printStackTrace();
		}
	}
}
