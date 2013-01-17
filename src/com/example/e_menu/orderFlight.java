package com.example.e_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class orderFlight extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_flight);
	}

	public void back(View v) {
		orderFlight.this.finish();
	}
}
