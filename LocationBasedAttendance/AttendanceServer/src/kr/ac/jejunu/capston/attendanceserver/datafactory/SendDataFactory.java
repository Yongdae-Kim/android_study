package kr.ac.jejunu.capston.attendanceserver.datafactory;

import java.util.List;
import java.util.Map;

import kr.ac.jejunu.capston.attendanceserver.dataheader.AttendanceCheck;
import kr.ac.jejunu.capston.attendanceserver.dataheader.FinishClass;
import kr.ac.jejunu.capston.attendanceserver.dataheader.StartClass;
import kr.ac.jejunu.capston.common.AdministratorData;
import kr.ac.jejunu.capston.common.AttendanceData;
import kr.ac.jejunu.capston.common.SerializableData;

public class SendDataFactory {

	public SendData getDataMaker(SerializableData serialObj,
			Map<String, AttendanceData> attDataMap) {
		String dataHeader = serialObj.getDataHeader();

		switch (dataHeader) {

		case "StartClass":

			return new StartClass((AdministratorData) serialObj.getData());

		case "AttendanceCheck":

			return new AttendanceCheck((AttendanceData) serialObj.getData(),
					attDataMap);

		case "FinishClass":

			return new FinishClass(attDataMap);

		default:
			return null;
		}
	}
}
