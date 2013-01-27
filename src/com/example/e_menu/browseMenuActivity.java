package com.example.e_menu;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
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
	Button query;

	TextView tv_selectPlaceOfDeparture;
	TextView tv_selectDestination;
	TextView tv_depatureDate;
	TextView tv_year;
	TextView tv_day;
	TextView tv_date;
	TextView tv_inputFlightNumber;

	String days[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
	Date now;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.browse_menu);
		setLocationView();
		listenerFlightBtn();
	}

	public void back(View v) {
		this.finish();
	}

	// 設置日期
	public void setDateTextView() {
		tv_depatureDate = (TextView) findViewById(R.id.tv_departureDate);
		tv_year = (TextView) findViewById(R.id.tv_year);
		tv_day = (TextView) findViewById(R.id.tv_day);
		tv_date = (TextView) findViewById(R.id.tv_date);
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

	// 重新監聽地點查詢畫面元件
	public void setLocationView() {
		setDateTextView();
		tv_selectPlaceOfDeparture = (TextView) findViewById(R.id.tv_selectPlaceOfDeparture);
		tv_selectDestination = (TextView) findViewById(R.id.tv_selectDestination);
		tv_selectPlaceOfDeparture.setTextColor(Color.rgb(150, 150, 150));
		tv_selectDestination.setTextColor(Color.rgb(150, 150, 150));
		query = (Button) findViewById(R.id.query);
		query.setOnClickListener(locationListener);
	}

	// 重新監聽航班查詢畫面元件
	public void setFlightView() {
		setDateTextView();
		tv_inputFlightNumber = (TextView) findViewById(R.id.tv_inputFlightNumber);
		tv_inputFlightNumber.setTextColor(Color.rgb(150, 150, 150));
		query = (Button) findViewById(R.id.query);
		query.setOnClickListener(flightListener);
	}

	private void listenerFlightBtn() {
		btn_flight = (Button) findViewById(R.id.btn_flight);
		btn_flight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				flightQuery();
			}
		});
	}

	// 切到地點查詢畫面
	private void locationQuery() {
		setContentView(R.layout.browse_menu);
		setLocationView();
		listenerFlightBtn();
	}

	// 切到航班查詢畫面
	private void flightQuery() {
		setContentView(R.layout.browse_menu_for_flight);
		setFlightView();
		btn_location = (Button) findViewById(R.id.btn_location);
		btn_location.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				locationQuery();
			}
		});
	}

	// 航班編號查詢
	private OnClickListener flightListener = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			startActivity(new Intent(browseMenuActivity.this,
					MainActivity.class));
		}
	};
	// 起訖地點查詢
	private OnClickListener locationListener = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			startActivity(new Intent(browseMenuActivity.this,
					MainActivity.class));
		}
	};

}