package kr.ac.jejunu.capston.attendanceadmin.view;

import kr.ac.jejunu.capston.attendanceadmin.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class StartImagePager extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_image_pager);

		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				finish();
			}
		};
		handler.sendEmptyMessageDelayed(0, 1200);
	}
}
