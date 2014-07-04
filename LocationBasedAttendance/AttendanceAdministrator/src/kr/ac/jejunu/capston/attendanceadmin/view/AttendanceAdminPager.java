package kr.ac.jejunu.capston.attendanceadmin.view;

import kr.ac.jejunu.capston.attendanceadmin.R;
import kr.ac.jejunu.capston.attendanceadmin.callback.CallBack;
import kr.ac.jejunu.capston.attendanceadmin.client.Client;
import kr.ac.jejunu.capston.attendanceadmin.location.LocationFetcher;
import kr.ac.jejunu.capston.attendanceadmin.systemtool.BackPressCloseSystem;
import kr.ac.jejunu.capston.attendanceadmin.systemtool.ToastSystem;
import kr.ac.jejunu.capston.attendanceadmin.time.CurrentTime;
import kr.ac.jejunu.capston.common.AdministratorData;
import kr.ac.jejunu.capston.common.SerializableData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AttendanceAdminPager extends Activity {

	private BackPressCloseSystem backPressCloseSystem;
	LocationFetcher fetcher;
	private double[] locations;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fetchMyLocation();
		moveTo(StartImagePager.class);

		Button startBtn = (Button) findViewById(R.id.start);
		startBtn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				GetLocations();
				Log.d("location", "button pressed");
			}
		});

		Button endBtn = (Button) findViewById(R.id.end);

		endBtn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				moveTo(ResultPager.class);
			}
		});

		backPressCloseSystem = new BackPressCloseSystem(this);
	}

	private void fetchMyLocation() {
		LocationFetcher fetcher = new LocationFetcher(getApplicationContext());
		locations = fetcher.getLocations();
	}

	public void GetLocations() {
		// 텍스트뷰를 찾음

		TextView latText = (TextView) findViewById(R.id.latitude);
		TextView lngText = (TextView) findViewById(R.id.longitude);

		latText.setText(String.valueOf(locations[0]));
		lngText.setText(String.valueOf(locations[1]));

		String time = new CurrentTime().getNow();

		AdministratorData data = new AdministratorData(time, locations);

		Client client = new Client("StartClass", data, startCallBack);
		client.connectToServer();
	}

	private CallBack startCallBack = new CallBack() {
		@Override
		public void callBackMethod(Object obj) {
			SerializableData serialObj = (SerializableData) obj;

			String dataHeader = serialObj.getDataHeader();
			String receivedData = (String) serialObj.getData();

			new ToastSystem(getApplicationContext(), receivedData);
		}
	};

	private void moveTo(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		backPressCloseSystem.onBackPressed();
	}
}