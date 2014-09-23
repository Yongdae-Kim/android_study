package kr.ac.jejunu.softlab.backupsystem.provider;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SmsDataProvider implements DataProvider {

	private final Uri uri = Uri.parse("content://sms");
	private Cursor cursor;

	private List<String> smsDataList = new ArrayList<String>();

	public SmsDataProvider(Context context) {
		cursor = context.getContentResolver()
				.query(uri, null, null, null, null);

		while (cursor.moveToNext()) {

			String number = getColumnContents("address");

			String type = getColumnContents("type");
			String typeOfSMS = getTypeOfSMS(Integer.parseInt(type));

			String date = getColumnContents("date");
			Date smsDayTime = new Date(Long.valueOf(date));

			String contents = getColumnContents("body");

			smsDataList.add(getFormattedString(number, typeOfSMS, smsDayTime,
					contents));
		}
		cursor.close();
	}

	private String getColumnContents(String columnName) {
		return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
	}

	private String getTypeOfSMS(int type) {
		switch (type) {
		case 1:
			return "Received";
		case 2:
			return "Sent";
		case 3:
			return "Draft";
		default:
			return null;
		}
	}

	private String getFormattedString(String number, String typeOfSMS,
			Date smsDayTime, String body) {
		return "\nPhone Number: " + number + " \nMessage Type: " + typeOfSMS
				+ " \nMessage Date: " + smsDayTime + " \nMessage Body: " + body
				+ "\n";
	}

	@Override
	public List<String> getDataList() {
		return smsDataList;
	}
}
