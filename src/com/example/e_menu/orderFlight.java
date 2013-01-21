package com.example.e_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

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

	OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			try {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				// 設定activity
				intent.setClass(orderFlight.this, orderDinner.class);
				// 包裹資料
				bundle.putStringArray("data", data[position]);
				startActivity(intent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	private void findView() {
		listview = (ListView) findViewById(R.id.list_flight);
	}

	private void init() {
		listview.setAdapter(new flightAdapter(this, data));
		listview.setOnItemClickListener(listener);
	}

	public void back(View v) {
		this.finish();
	}
}
