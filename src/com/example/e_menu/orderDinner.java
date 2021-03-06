package com.example.e_menu;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

public class orderDinner extends Activity {
	static orderDinner orderdinnerLayout;
	TextView tv_name;
	TextView tv_seat_number;
	TextView tv_seat;
	TextView tv_departure_date;
	TextView tv_storke;
	ListView mainDinnerList;
	ListView pairDinnerList;
	Bundle bData;
	ArrayList<String> mainList;
	ArrayList<String> pairList; 
	String mainDinnerArray[] = { "������įæ��������������B��ۣ�B���ڽ��Φ̶�",
			"���Τ���O����X����B�ɦ̬v���T�κ�J����", "�\����-�k���C�Ūo�N���m�ԡB�`�ʡBĪ���B���ڽ��B�q���[����Υ��oĨۣ��" };
	String pairDinnerArray[] = { "�������������z�����C���B���ڽ��B��ۣ�ζ�������" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_dinner);
		orderdinnerLayout = this;
		findview();
		init();
	}

	public void back(View v) {
		this.finish();
	}

	private void init() {

		// ��r�C��
		tv_name.setTextColor(Color.WHITE);
		tv_seat_number.setTextColor(Color.WHITE);
		tv_seat.setTextColor(Color.WHITE);
		tv_departure_date.setTextColor(Color.WHITE);
		tv_storke.setTextColor(Color.rgb(255, 255, 120));
		// ���e
		tv_name.setText(passengerInfomation.name);
		tv_departure_date.setText("�X�o����G" + passengerInfomation.date);
		tv_seat_number.setText("�q��N���G" + passengerInfomation.bookingClass);
		tv_seat.setText(passengerInfomation.seat_number + " "
				+ passengerInfomation.seat);
		tv_storke.setText(passengerInfomation.stroke);
		// list
		mainList = new ArrayList<String>();
		pairList = new ArrayList<String>();
		arrayPushDatatoList(mainList, mainDinnerArray);
		arrayPushDatatoList(pairList, pairDinnerArray);
		mainDinnerList.setAdapter(new itemAdapter(this, mainList, 0));
		pairDinnerList.setAdapter(new itemAdapter(this, pairList, 0));
	}

	public void next(View v) {
		Bundle bundle = new Bundle();
		bundle.putString("mainDinner",
				((itemAdapter) mainDinnerList.getAdapter()).getDinnerName());
		bundle.putString("pairDinner",
				((itemAdapter) pairDinnerList.getAdapter()).getDinnerName());
		Intent intent = new Intent();
		intent.setClass(this, checkDinner.class);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	private void arrayPushDatatoList(ArrayList<String> list, String arr[]) {
		for (String data : arr)
			list.add(data);
	}

	private void findview() {
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_seat_number = (TextView) findViewById(R.id.tv_seat_number);
		tv_seat = (TextView) findViewById(R.id.tv_seat);
		tv_departure_date = (TextView) findViewById(R.id.tv_departure_date);
		tv_storke = (TextView) findViewById(R.id.tv_stroke);
		mainDinnerList = (ListView) findViewById(R.id.mainDinnerList);
		pairDinnerList = (ListView) findViewById(R.id.pairDinnerList);
	}
}