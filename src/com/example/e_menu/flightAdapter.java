package com.example.e_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class flightAdapter extends BaseAdapter {

	private LayoutInflater myInflater;
	private String[][] list = null;

	public flightAdapter(Context ctxt, String[][] list) {
		myInflater = LayoutInflater.from(ctxt);
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MyView view = null;

		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.flight_adapter, null);

			view = new MyView(
					(TextView) convertView.findViewById(R.id.a_departure_date),
					(TextView) convertView.findViewById(R.id.a_flight_number),
					(TextView) convertView.findViewById(R.id.a_stroke));
			convertView.setTag(view);
		} else {
			view = (MyView) convertView.getTag();
		}

		view.departureDate.setText(list[position][0]);
		view.flight_number.setText(list[position][1]);
		view.stroke.setText(list[position][2]);

		return convertView;
	}

	class MyView {
		TextView departureDate;
		TextView flight_number;
		TextView stroke;

		public MyView(TextView a, TextView b, TextView c) {
			this.departureDate = a;
			this.flight_number = b;
			this.stroke = c;
		}
	}
}