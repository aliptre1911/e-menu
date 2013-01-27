package com.example.e_menu;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class browseMenuActivity extends Activity {
	Button btn_location;
	Button btn_flight;

	TextView tv_selectPlaceOfDeparture;
	TextView tv_selectDestination;
	TextView tv_depatureDate;
	TextView tv_year;
	TextView tv_day;
	TextView tv_date;
	String days[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
	Date now;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.browse_menu);
		findview();
		init();
	}

	public void back(View v) {
		this.finish();
	}

	public void findview() {
		btn_location = (Button) findViewById(R.id.btn_location);
		btn_flight = (Button) findViewById(R.id.btn_flight);
		tv_selectPlaceOfDeparture = (TextView) findViewById(R.id.tv_selectPlaceOfDeparture);
		tv_selectDestination = (TextView) findViewById(R.id.tv_selectDestination);
		tv_depatureDate = (TextView) findViewById(R.id.tv_departureDate);
		tv_year = (TextView) findViewById(R.id.tv_year);
		tv_day = (TextView) findViewById(R.id.tv_day);
		tv_date = (TextView) findViewById(R.id.tv_date);
	}

	public void init() {
		btn_location.setTextColor(Color.rgb(255, 255, 255));
		btn_flight.setTextColor(Color.rgb(50, 50, 50));
		btn_flight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setBlueBg(btn_flight);
				setWhiteBg(btn_location);
			}
		});
		btn_location.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setBlueBg(btn_location);
				setWhiteBg(btn_flight);
			}
		});
		tv_selectPlaceOfDeparture.setTextColor(Color.rgb(150, 150, 150));
		tv_selectDestination.setTextColor(Color.rgb(150, 150, 150));
		tv_depatureDate.setTextColor(Color.rgb(20, 20, 20));
		tv_year.setTextColor(Color.rgb(0, 60, 120));
		tv_day.setTextColor(Color.rgb(0, 60, 120));
		tv_date.setTextColor(Color.rgb(0, 60, 120));
		// 取得現在時間
		now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateArr[] = sdf.format(now).split("-");
		// 填入
		tv_year.setText(dateArr[0]);
		tv_date.setText(dateArr[1] + "/" + dateArr[2]);
		tv_day.setText(days[now.getDay()]);
	}

	private void setBlueBg(Button v) {
		v.setBackgroundResource(R.drawable.plan4);
		v.setTextColor(Color.rgb(255, 255, 255));
	}

	private void setWhiteBg(Button v) {
		v.setBackgroundResource(R.drawable.plan5);
		v.setTextColor(Color.rgb(50, 50, 50));
	}
}