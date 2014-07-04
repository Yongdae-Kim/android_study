package kr.ac.jejunu.capston.attendanceserver.dataheader;

import java.io.Serializable;

import kr.ac.jejunu.capston.attendanceserver.datafactory.SendData;
import kr.ac.jejunu.capston.common.AdministratorData;

public class StartClass implements SendData {

	private AdministratorData data;

	public StartClass(AdministratorData data) {
		this.data = data;
	}

	@Override
	public String getDataHeader() {
		return "Start";
	}

	@Override
	public Serializable getData() {
		return "Start a class";
	}
}
