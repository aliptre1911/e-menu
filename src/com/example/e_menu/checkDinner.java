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

public class checkDinner extends Activity {
	TextView tv_name;
	TextView tv_seat_number;
	TextView tv_seat;
	TextView tv_departure_date;
	TextView tv_storke;
	TextView tv_mainDinner;
	TextView tv_pairDinner;
	TextView tv_no_main_dinner;
	TextView tv_no_pair_dinner;
	String name = "Mary Lin";
	String storke = "AKL-BNE-TPE";
	Bundle bData;
	Button dialogBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.check_dinner);
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
		tv_no_main_dinner.setText(bData.getString("mainDinner").split("\\.")[0]
				+ ".");
		tv_mainDinner.setText(bData.getString("mainDinner").split("\\.")[1]);
		tv_no_pair_dinner.setText(bData.getString("pairDinner").split("\\.")[0]
				+ ".");
		tv_pairDinner.setText(bData.getString("pairDinner").split("\\.")[1]);
	}

	public void confirm(View v) {
		final Dialog dialog = getOKDialog("預選餐點完成");
		dialog.show();
		// startActivity(new Intent(this, dinnerActivity.class));
	}

	private Dialog getOKDialog(String message) {
		Dialog dialog = new Dialog(this);
		Context mContext = getApplicationContext();
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.dialog,
				(ViewGroup) findViewById(R.id.layout_dialog));
		// textview
		TextView dialog_message = (TextView) layout
				.findViewById(R.id.dialog_message);
		dialog_message.setText(message);
		// button
		Button dialog_ok = (Button) layout.findViewById(R.id.dialog_ok);
		dialog_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dinnerMenu.mainDinner = bData.getString("mainDinner");
				dinnerMenu.pairDinner = bData.getString("pairDinner");
				dinnerMenu.selected = true;
				// finish選擇餐點
				orderDinner.orderdinnerLayout.finish();
				// finish選擇位置
				orderFlight.orderflightLayout.finish();
				// finish this
				checkDinner.this.finish();
				// startActivity
				// Bundle bundle = new Bundle();
				// bundle.putStringArray("data", bData.getStringArray("data"));
				Intent intent = new Intent();
				intent.setClass(checkDinner.this, dinnerActivity.class);
				// intent.putExtras(bundle);
				startActivity(intent);

			}

		});
		dialog.setContentView(layout);
		dialog.getWindow().setLayout(400, 400);
		dialog.getWindow().setBackgroundDrawableResource(
				android.R.color.transparent);
		return dialog;
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
		dialogBtn = (Button) findViewById(R.id.dialog_ok);
	}
}