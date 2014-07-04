package kr.ac.jejunu.capston.attendanceadmin.view;

import java.util.List;

import kr.ac.jejunu.capston.attendanceadmin.R;
import kr.ac.jejunu.capston.attendanceadmin.adapter.ResultAdapter;
import kr.ac.jejunu.capston.attendanceadmin.callback.CallBack;
import kr.ac.jejunu.capston.attendanceadmin.client.Client;
import kr.ac.jejunu.capston.attendanceadmin.systemtool.BackPressCloseSystem;
import kr.ac.jejunu.capston.attendanceadmin.systemtool.ToastSystem;
import kr.ac.jejunu.capston.common.AttendanceData;
import kr.ac.jejunu.capston.common.SerializableData;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ResultPager extends Activity {

	private List<AttendanceData> attDataList;

	private BackPressCloseSystem backPressCloseSystem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_page);

		Client client = new Client("FinishClass", null, finishCallBack);
		client.connectToServer();

		ListView menuLv = (ListView) findViewById(R.id.list_view);
		menuLv.setAdapter(new ResultAdapter(this, attDataList));

		backPressCloseSystem = new BackPressCloseSystem(this);
	}

	@SuppressWarnings("unchecked")
	private CallBack finishCallBack = new CallBack() {
		@Override
		public void callBackMethod(Object obj) {
			SerializableData serialObj = (SerializableData) obj;

			String dataHeader = serialObj.getDataHeader();
			attDataList = (List<AttendanceData>) serialObj.getData();
		}
	};

	@Override
	public void onBackPressed() {
		backPressCloseSystem.onBackPressed();
	}

}