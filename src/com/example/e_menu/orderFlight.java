package com.example.e_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

public class orderFlight extends Activity {
	private ListView listview;
	// 10:35 15:20 商務艙
	private String[][] data = {
			{ "2012-09-15", "10:35", "CI0054", "AKLTPE", "商務艙" },
			{ "2012-09-19", "15:20", "CI0018", "TPEHNL", "商務艙" } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_flight);
		findView();
		init();
	}

	private void findView() {
		listview = (ListView) findViewById(R.id.list_flight);
	}

	private void init() {
		listview.setAdapter(new flightAdapter(this, data));
	}

	public void back(View v) {
		orderFlight.this.finish();
	}
}
