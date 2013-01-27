package com.example.e_menu;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

public class queryDinnerActivity extends Activity {

	ListView list;
	ArrayList<String> flightNumber = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> meals = new ArrayList<String>();
	String arr[][] = { { "CI0833", "07:15", "�Y���������ѻP���\�I���A��\n�Ӱȿ����\" },
			{ "CI0835", "13:55", "�Y���������ѻP���\�I���A��\n�Ӱȿ����\" },
			{ "CI0065", "22:20", "�L�w���\�I" } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.query_dinner);
		findview();
		init();
	}

	public void back(View v) {
		this.finish();
	}

	private void init() {
		for (int i = 0; i < arr.length; i++) {
			flightNumber.add(arr[i][0]);
			time.add(arr[i][1]);
			meals.add(arr[i][2]);
		}
		list.setAdapter(new mealsAdapter(this, flightNumber, time, meals));
	}

	private void findview() {
		list = (ListView) findViewById(R.id.mealsList);
	}
}