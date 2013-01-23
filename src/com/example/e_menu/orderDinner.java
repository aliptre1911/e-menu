package com.example.e_menu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

public class orderDinner extends Activity {
	TextView tv_name;
	TextView tv_seat_number;
	TextView tv_seat;
	TextView tv_departure_date;
	TextView tv_storke;
	ListView mainDinnerList;
	ListView pairDinnerList;
	String name = "Mary Lin";
	String storke = "AKL-BNE-TPE";
	Bundle bData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_dinner);
		findview();
		init();
	}

	public void back(View v) {
		this.finish();
	}

	private void init() {
		bData = this.getIntent().getExtras();
		// 文字顏色
		tv_name.setTextColor(Color.WHITE);
		tv_seat_number.setTextColor(Color.WHITE);
		tv_seat.setTextColor(Color.WHITE);
		tv_departure_date.setTextColor(Color.WHITE);
		tv_storke.setTextColor(Color.rgb(255, 255, 120));
		// 內容
		tv_name.setText(this.name);
		tv_departure_date.setText("出發日期：" + bData.getStringArray("data")[0]);
		tv_seat_number.setText("訂位代號：KJQ801");
		tv_seat.setText(bData.getStringArray("data")[2] + " "
				+ bData.getStringArray("data")[4]);
		tv_storke.setText(this.storke);
		// { "2012-09-15", "10:35", "CI0054", "AKLTPE", "商務艙"
	}

	private void findview() {
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_seat_number = (TextView) findViewById(R.id.tv_seat_number);
		tv_seat = (TextView) findViewById(R.id.tv_seat);
		tv_departure_date = (TextView) findViewById(R.id.tv_departure_date);
		tv_storke = (TextView) findViewById(R.id.tv_stroke);
	}
}