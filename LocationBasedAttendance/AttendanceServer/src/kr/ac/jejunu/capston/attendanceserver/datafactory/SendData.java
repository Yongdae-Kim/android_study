package kr.ac.jejunu.capston.attendanceserver.datafactory;

import java.io.Serializable;

public interface SendData {
	String getDataHeader();

	Serializable getData();
}
