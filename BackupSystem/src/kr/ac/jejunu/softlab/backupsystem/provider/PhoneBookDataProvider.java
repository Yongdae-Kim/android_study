package kr.ac.jejunu.softlab.backupsystem.provider;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

public class PhoneBookDataProvider implements DataProvider {

	private Cursor cursor;

	private List<String> phoneBookDataList = new ArrayList<String>();

	public PhoneBookDataProvider(Context context) {
		cursor = context.getContentResolver().query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
				null, null);

		while (cursor.moveToNext()) {
			String name = getColumnContents(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
			String phoneNum = getColumnContents(ContactsContract.CommonDataKinds.Phone.NUMBER);
			phoneBookDataList.add(getFormattedString(name, phoneNum));
		}
		cursor.close();
	}

	private String getColumnContents(String columnName) {
		return cursor.getString(cursor.getColumnIndex(columnName));
	}

	private String getFormattedString(String name, String phoneNum) {
		return "\nName: " + name + " \nPhoneNum: " + phoneNum + "\n";
	}

	@Override
	public List<String> getDataList() {
		return phoneBookDataList;
	}
}
