package com.example.e_menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class timeOutDinnerActivity extends Activity {
	TextView tv_name;
	TextView tv_seat_number;
	TextView tv_seat;
	TextView tv_departure_date;
	TextView tv_storke;
	TextView tv_mainDinner;
	TextView tv_pairDinner;
	TextView tv_no_main_dinner;
	TextView tv_no_pair_dinner;
	TextView titleBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.time_out_dinner);
		findview();
		init();
	}

	public void back(View v) {
		this.finish();
	}

	private void init() {
		// 文字顏色
		tv_name.setTextColor(Color.WHITE);
		tv_seat_number.setTextColor(Color.WHITE);
		tv_seat.setTextColor(Color.WHITE);
		tv_departure_date.setTextColor(Color.WHITE);
		tv_storke.setTextColor(Color.rgb(255, 255, 120));
		// 內容
		tv_name.setText(passengerInfomation.name);
		tv_departure_date.setText("出發日期：" + passengerInfomation.date);
		tv_seat_number.setText("訂位代號：" + passengerInfomation.bookingClass);
		tv_seat.setText(passengerInfomation.seat_number + " "
				+ passengerInfomation.seat);
		tv_storke.setText(passengerInfomation.stroke);
		tv_no_main_dinner.setText(dinnerMenu.mainDinner.split("\\.")[0] + ".");
		tv_mainDinner.setText(dinnerMenu.mainDinner.split("\\.")[1]);
		tv_no_pair_dinner.setText(dinnerMenu.pairDinner.split("\\.")[0] + ".");
		tv_pairDinner.setText(dinnerMenu.pairDinner.split("\\.")[1]);
		titleBar.setText(MainActivity.titleBar);
	}

	private void findview() {
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_seat_number = (TextView) findViewById(R.id.tv_seat_number);
		tv_seat = (TextView) findViewById(R.id.tv_seat);
		tv_departure_date = (TextView) findViewById(R.id.tv_departure_date);
		tv_storke = (TextView) findViewById(R.id.tv_stroke);
		tv_mainDinner = (TextView) findViewById(R.id.tv_mainDinner);
		tv_pairDinner = (TextView) findViewById(R.id.tv_pairDinner);
		tv_no_main_dinner = (TextView) findViewById(R.id.tv_no_main_dinner);
		tv_no_pair_dinner = (TextView) findViewById(R.id.tv_no_pair_dinner);
		titleBar = (TextView) findViewById(R.id.titleBar);
	}
}