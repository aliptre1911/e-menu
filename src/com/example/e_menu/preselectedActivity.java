package com.example.e_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class preselectedActivity extends Activity {

	public static preselectedActivity preselected;
	TextView titleBar;
	EditText et_last_name;
	EditText et_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.preselected_meal);
		preselected = this;
		titleBar = (TextView) findViewById(R.id.titleBar);
		titleBar.setText(MainActivity.titleBar);
		et_last_name = (EditText) findViewById(R.id.et_last_name);
		et_name = (EditText) findViewById(R.id.et_name);
		orderFlight.name = et_name.getText().toString() + " "
				+ et_last_name.getText().toString();
	}

	public void back(View v) {
		preselectedActivity.this.finish();
	}

	public void confirm(View v) {
		startActivity(new Intent(this, orderFlight.class));
		this.finish();
	}
}