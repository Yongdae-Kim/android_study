package kr.ac.jejunu.capston.common;

import java.io.Serializable;

public class SerializableData implements Serializable {

	private static final long serialVersionUID = -3741834196276980645L;

	private String dataHeader;
	private Object data;

	public SerializableData(String dataHeader, Object data) {
		this.dataHeader = dataHeader;
		this.data = data;
	}

	public String getDataHeader() {
		return dataHeader;
	}

	public Object getData() {
		return data;
	}

}
