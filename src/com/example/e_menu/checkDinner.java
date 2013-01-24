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

public class checkDinner extends Activity {
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
	ArrayList<String> mainList;
	ArrayList<String> pairList;
	String mainDinnerArray[] = { "������įæ��������������B��ۣ�B���ڽ��Φ̶�",
			"���Τ���O����X����B�ɦ̬v���T�κ�J����", "�\����-�k���C�Ūo�N���m�ԡB�`�ʡBĪ���B���ڽ��B�q���[����Υ��oĨۣ��" };
	String pairDinnerArray[] = { "�����������z�����C���B���ڽ��B��ۣ�ζ�������" };

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
		// ��r�C��
		tv_name.setTextColor(Color.WHITE);
		tv_seat_number.setTextColor(Color.WHITE);
		tv_seat.setTextColor(Color.WHITE);
		tv_departure_date.setTextColor(Color.WHITE);
		tv_storke.setTextColor(Color.rgb(255, 255, 120));
		// ���e
		tv_name.setText(this.name);
		tv_departure_date.setText("�X�o����G" + bData.getStringArray("data")[0]);
		tv_seat_number.setText("�q��N���GKJQ801");
		tv_seat.setText(bData.getStringArray("data")[2] + " "
				+ bData.getStringArray("data")[4]);
		tv_storke.setText(this.storke);
		// list
		mainList = new ArrayList<String>();
		pairList = new ArrayList<String>();
		arrayPushDatatoList(mainList, mainDinnerArray);
		arrayPushDatatoList(pairList, pairDinnerArray);
		mainDinnerList.setAdapter(new itemAdapter(this, mainList, 0));
		pairDinnerList.setAdapter(new itemAdapter(this, pairList, 0));
	}

	public void next(View v) {
		Intent intent = new Intent();
		intent.setClass(this, checkDinner.class);
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