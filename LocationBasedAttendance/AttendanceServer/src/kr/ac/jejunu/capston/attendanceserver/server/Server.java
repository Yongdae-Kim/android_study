package kr.ac.jejunu.capston.attendanceserver.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.jejunu.capston.attendanceserver.calc.AttendanceCalculator;
import kr.ac.jejunu.capston.attendanceserver.calc.DistanceCalculable;
import kr.ac.jejunu.capston.attendanceserver.calc.DistanceCalculator1;
import kr.ac.jejunu.capston.attendanceserver.callback.CallBack;
import kr.ac.jejunu.capston.attendanceserver.datafactory.SendData;
import kr.ac.jejunu.capston.attendanceserver.datafactory.SendDataFactory;
import kr.ac.jejunu.capston.attendanceserver.dataheader.StartClass;
import kr.ac.jejunu.capston.attendanceserver.dataheader.AttendanceCheck;
import kr.ac.jejunu.capston.attendanceserver.dataheader.FinishClass;
import kr.ac.jejunu.capston.common.AdministratorData;
import kr.ac.jejunu.capston.common.AttendanceData;
import kr.ac.jejunu.capston.common.SerializableData;

public class Server {

	private final int serverPort = 3335;

	private String dataHeader;
	private Serializable data;
	private List<AttendanceData> attDataList = new ArrayList<AttendanceData>();
	Map<String, AttendanceData> attDataMap = new HashMap<String, AttendanceData>();

	@SuppressWarnings("resource")
	public void connectToClient() {
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			while (true) {
				System.out.println("S : Connecting ...");
				Socket socket = serverSocket.accept();
				System.out.println("S : "
						+ socket.getInetAddress().getHostAddress());

				new Receiver(socket, clientCallBack).run();
				new Sender(socket, dataHeader, data).run();
			}
		} catch (IOException e) {
			System.out.println("S : Error " + e.getMessage());
			e.printStackTrace();
		}
	}

	private CallBack clientCallBack = new CallBack() {
		@Override
		public void callBackMethod(Object obj) {
			SerializableData serialObj = (SerializableData) obj;
			SendDataFactory factory = new SendDataFactory();
			SendData sendData = factory.getDataMaker(serialObj, attDataMap);
			dataHeader = sendData.getDataHeader();
			data = sendData.getData();
		}
	};

}
