package kr.ac.jejunu.capston.attendancecheck.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import kr.ac.jejunu.capston.attendancecheck.callback.CallBack;
import android.util.Log;

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
			Log.e("TCP", "C: receive io error", ioe);
		} catch (ClassNotFoundException cnfe) {
			Log.e("TCP", "C: receive class error", cnfe);
		}

	}

	// private void socketClose(ObjectInputStream objFilterIn) {
	// try {
	// objFilterIn.close();
	// } catch (IOException ioe) {
	// Log.e("TCP", "C: socket closing io error", ioe);
	// }
	// }
}
