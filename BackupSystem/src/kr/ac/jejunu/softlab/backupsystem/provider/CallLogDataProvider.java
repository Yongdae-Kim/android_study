package kr.ac.jejunu.softlab.backupsystem.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.provider.CallLog;

public class CallLogDataProvider implements DataProvider {

	private Cursor cursor;

	private List<String> callLogDataList = new ArrayList<String>();

	public CallLogDataProvider(Activity activity) {
		cursor = activity.managedQuery(CallLog.Calls.CONTENT_URI, null, null,
				null, null);
		while (cursor.moveToNext()) {
			String phNumber = getColumnContents(CallLog.Calls.NUMBER);

			String type = getColumnContents(CallLog.Calls.TYPE);
			String typeOfCall = getTypeOfCall(Integer.parseInt(type));

			String callDate = getColumnContents(CallLog.Calls.DATE);
			Date callDayTime = new Date(Long.valueOf(callDate));

			String callDuration = getColumnContents(CallLog.Calls.DURATION);

			callLogDataList.add(getFormattedString(phNumber, typeOfCall,
					callDayTime, callDuration));
		}
		cursor.close();
	}

	private String getColumnContents(String columnName) {
		return cursor.getString(cursor.getColumnIndex(columnName));
	}

	private String getTypeOfCall(int type) {
		switch (type) {
		case CallLog.Calls.OUTGOING_TYPE:
			return "Outgoing";
		case CallLog.Calls.INCOMING_TYPE:
			return "Incoming";
		case CallLog.Calls.MISSED_TYPE:
			return "Missed";
		default:
			return null;
		}
	}

	private String getFormattedString(String number, String typeOfCall,
			Date callDayTime, String callDuration) {
		return "\nPhoneNum: " + number + " \nCallType: " + typeOfCall
				+ " \nCallDate: " + callDayTime + " \nCallDuration: "
				+ callDuration + " sec\n";
	}

	@Override
	public List<String> getDataList() {
		return callLogDataList;
	}
}