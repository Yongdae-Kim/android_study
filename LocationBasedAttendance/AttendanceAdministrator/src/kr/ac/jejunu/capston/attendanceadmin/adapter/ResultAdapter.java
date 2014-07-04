package kr.ac.jejunu.capston.attendanceadmin.adapter;

import java.util.List;

import kr.ac.jejunu.capston.attendanceadmin.R;
import kr.ac.jejunu.capston.common.AttendanceData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultAdapter extends BaseAdapter {
	private List<AttendanceData> attDataList;

	private LayoutInflater inflater;

	public ResultAdapter(Context context, List<AttendanceData> attDataList) {
		this.attDataList = attDataList;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return attDataList.size();
	}

	public Object getItem(int position) {
		return attDataList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.attendance_list, parent, false);
		}

		setImageView(convertView, R.id.std_img, R.drawable.ic_launcher);

		setTextView(convertView, R.id.std_num, attDataList.get(position).getStudentNum());
		setTextView(convertView, R.id.std_name, attDataList.get(position).getStudentName());
		setTextView(convertView, R.id.att_result, attDataList.get(position).getStudentName());
		setTextView(convertView, R.id.att_time, attDataList.get(position).getTime());
		setTextView(convertView, R.id.phone_num, attDataList.get(position).getPhoneNum());

		return convertView;
	}

	private void setImageView(View view, int id, int resource) {
		ImageView iv = (ImageView) view.findViewById(id);
		iv.setImageResource(resource);
	}

	private void setTextView(View view, int id, String text) {
		TextView tv = (TextView) view.findViewById(id);
		tv.setText(text);
	}
}
