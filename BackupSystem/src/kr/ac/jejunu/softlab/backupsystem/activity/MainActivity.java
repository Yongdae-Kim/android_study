package kr.ac.jejunu.softlab.backupsystem.activity;

import kr.ac.jejunu.softlab.backupsystem.R;
import kr.ac.jejunu.softlab.backupsystem.callback.CallBack;
import kr.ac.jejunu.softlab.backupsystem.observer.NetworkObserver;
import kr.ac.jejunu.softlab.backupsystem.observer.ProcessObserver;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);

		/*
		 * // DataProvider provider = new CallLogDataProvider(this); //
		 * DataProvider provider = new SmsDataProvider(getApplicationContext());
		 * DataProvider provider = new PhoneBookDataProvider(
		 * getApplicationContext());
		 * 
		 * List<String> a = provider.getDataList(); for (int i = 0; i <
		 * a.size(); i++) tv.append(a.get(i));
		 */

		// getPackageList();

		NetworkObserver observer = new NetworkObserver(getApplicationContext());
		observer.observe(callback);

	}

	private CallBack callback = new CallBack() {

		@Override
		public void callBackMethod(Object obj) {
			boolean temp = new ProcessObserver(getApplicationContext())
					.isRunningProcess("com.iloen.melon");
			Toast.makeText(getApplicationContext(), "" + temp,
					Toast.LENGTH_LONG).show();
		}
	};
}
