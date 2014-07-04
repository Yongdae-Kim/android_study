package kr.ac.jejunu.capston.attendancecheck.view;

import kr.ac.jejunu.capston.attendancecheck.R;
import kr.ac.jejunu.capston.attendancecheck.callback.CallBack;
import kr.ac.jejunu.capston.attendancecheck.client.Client;
import kr.ac.jejunu.capston.attendancecheck.location.LocationFetcher;
import kr.ac.jejunu.capston.attendancecheck.systemtool.BackPressCloseSystem;
import kr.ac.jejunu.capston.attendancecheck.systemtool.ToastSystem;
import kr.ac.jejunu.capston.attendancecheck.time.CurrentTime;
import kr.ac.jejunu.capston.common.AttendanceData;
import kr.ac.jejunu.capston.common.SerializableData;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AttendanceCheckPager extends Activity {

	private BackPressCloseSystem backPressCloseSystem;

	private EditText studentNumEt, studentNameEt, phoneNumEt;
	private Button attendBtn;
	private double[] locations;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fetchMyLocation();
		moveTo(StartImagePager.class);
		init();

		attendBtn.setOnClickListener(attendBtnClickListener);
		backPressCloseSystem = new BackPressCloseSystem(this);
	}

	private void fetchMyLocation() {
		LocationFetcher fetcher = new LocationFetcher(getApplicationContext());
		locations = fetcher.getLocations();
	}

	private void moveTo(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}

	private void init() {
		studentNumEt = (EditText) findViewById(R.id.student_num);
		studentNameEt = (EditText) findViewById(R.id.student_name);
		phoneNumEt = (EditText) findViewById(R.id.phone_num);
		phoneNumEt.setText(getMyPhoneNum());
		attendBtn = (Button) findViewById(R.id.attend);
	}

	private String getMyPhoneNum() {
		TelephonyManager mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		return PhoneNumberUtils.formatNumber(mTelephonyMgr.getLine1Number());
	}

	private OnClickListener attendBtnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			GetLocations();
		}
	};

	public void GetLocations() {
		// 텍스트뷰를 찾음
		TextView latText = (TextView) findViewById(R.id.latitude);
		TextView lngText = (TextView) findViewById(R.id.longitude);

		latText.setText(String.valueOf(locations[0]));
		lngText.setText(String.valueOf(locations[1]));

		String studentNum = studentNumEt.getText().toString();
		String studentName = studentNameEt.getText().toString();
		String phoneNum = phoneNumEt.getText().toString();
		String time = new CurrentTime().getNow();

		AttendanceData data = new AttendanceData(studentNum, studentName, phoneNum, time, locations);

		Client client = new Client("AttendanceCheck", data, clientCallBack);
		client.connectToServer();
	}

	private CallBack clientCallBack = new CallBack() {
		@Override
		public void callBackMethod(Object obj) {
			SerializableData serialObj = (SerializableData) obj;
			Boolean attendanceYesOrNo = (Boolean) serialObj.getData();

			new ToastSystem(getApplicationContext(), getAttendanceResult(attendanceYesOrNo));
		}
	};

	private String getAttendanceResult(boolean attendanceYesOrNo) {
		if (attendanceYesOrNo == true) {
			return "Attendance has been confirmed.";
		} else {
			return "Please try again.";
		}
	}

	@Override
	public void onBackPressed() {
		backPressCloseSystem.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}