package kr.ac.jejunu.capston.attendanceserver.dataheader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kr.ac.jejunu.capston.attendanceserver.datafactory.SendData;
import kr.ac.jejunu.capston.common.AttendanceData;

public class FinishClass implements SendData {

	Map<String, AttendanceData> attDataMap;

	public FinishClass(Map<String, AttendanceData> attDataMap) {
		this.attDataMap = attDataMap;
	}

	@Override
	public String getDataHeader() {
		return "Finish";
	}

	@Override
	public Serializable getData() {

		// Iterator<String> iterator = attDataMap.keySet().iterator();
		// while (iterator.hasNext()) {
		// String key = (String) iterator.next();
		// System.out.print("key=" + key);
		// System.out.println(" value=" + attDataMap.get(key));
		// }

		return (Serializable) getArrayListFromHashMap(attDataMap);
	}

	private List<AttendanceData> getArrayListFromHashMap(
			Map<String, AttendanceData> attDataMap2) {
		return new ArrayList<AttendanceData>(attDataMap.values());
	}

}
