package com.example.e_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class preselectedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.preselected_meal);
	}

	public void back(View v) {
		preselectedActivity.this.finish();
	}

	public void confirm(View v) {
		startActivity(new Intent(this, orderFlight.class));
	}
}