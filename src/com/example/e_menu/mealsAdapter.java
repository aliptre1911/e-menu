package com.example.e_menu;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class mealsAdapter extends BaseAdapter {

	private LayoutInflater myInflater;
	private List<String> flightNumberList;
	private List<String> mealsList;
	private List<String> timeList;

	public mealsAdapter(Context ctxt, ArrayList<String> flightNumberList,
			ArrayList<String> timeList, ArrayList<String> mealsList) {
		myInflater = LayoutInflater.from(ctxt);
		this.flightNumberList = flightNumberList;
		this.timeList = timeList;
		this.mealsList = mealsList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return flightNumberList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return flightNumberList.get(arg0);
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
			convertView = myInflater.inflate(R.layout.meals_adapter, null);

			view = new MyView(
					(TextView) convertView.findViewById(R.id.tv_flightNumber),
					(TextView) convertView.findViewById(R.id.tv_time),
					(TextView) convertView.findViewById(R.id.tv_meals));
			convertView.setTag(view);
		} else {
			view = (MyView) convertView.getTag();
		}
		
		view.flight.setText(flightNumberList.get(position));
		view.time.setText(timeList.get(position));
		view.meals.setText(mealsList.get(position));
		
		return convertView;
	}

	class MyView {
		TextView flight;
		TextView meals;
		TextView time;

		public MyView(TextView a, TextView b, TextView c) {
			this.flight = a;
			this.time = b;
			this.meals = c;
		}
	}
}