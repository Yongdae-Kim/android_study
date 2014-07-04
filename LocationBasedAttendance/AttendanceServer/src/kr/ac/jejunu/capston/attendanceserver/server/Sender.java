package kr.ac.jejunu.capston.attendanceserver.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

import kr.ac.jejunu.capston.common.SerializableData;

public class Sender implements Runnable {
	private Socket socket;

	private String dataHeader;
	private Object data;

	public Sender(Socket socket, String dataHeader, Serializable data) {
		this.socket = socket;
		this.dataHeader = dataHeader;
		this.data = data;
	}

	@Override
	public void run() {
		try {
			OutputStream out = socket.getOutputStream();
			BufferedOutputStream bufFilterOut = new BufferedOutputStream(out);
			ObjectOutputStream objFilterOut = new ObjectOutputStream(
					bufFilterOut);

			objFilterOut.writeObject(new SerializableData(dataHeader, data));
			objFilterOut.flush();
		} catch (IOException ioe) {
			System.out.println("S : Send IO Error  " + ioe.getMessage());
			ioe.printStackTrace();
		} finally {
			System.out.println("S : Send " + "(" + data + ")");
		}

	}
}
