package com.example.e_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView list;
	// 清單選項名稱
	protected String[] listValue = { "預選餐點", "訂餐明細", "瀏覽菜單" };
	// 清單選項圖片
	protected int[] listImg = { R.drawable.list_icon01, R.drawable.list_icon02,
			R.drawable.list_icon03 };
	public static String titleBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		findview();
		init();
	}

	private void findview() {
		list = (ListView) findViewById(R.id.list);
	}

	private void init() {
		list.setAdapter(new myAdapter(this, listValue, listImg));
		list.setOnItemClickListener(listener);
	}

	OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			switch ((int) id) {
			case 0:
				// 預選餐點
				titleBar = dinnerMenu.selected ? listValue[0] : listValue[1];
				if (orderFlight.name != null && orderFlight.name != "") {
					intent.setClass(MainActivity.this, orderFlight.class);
				} else {
					intent.setClass(MainActivity.this,
							preselectedActivity.class);
				}
				startActivity(intent);
				break;
			case 1:
				// 訂餐明細
				titleBar = listValue[1];
				if (orderFlight.name != null && orderFlight.name != "") {
					intent.setClass(MainActivity.this, orderFlight.class);
				} else {
					intent.setClass(MainActivity.this,
							preselectedActivity.class);
				}
				startActivity(intent);
				break;
			case 2:
				// 瀏覽菜單
				titleBar = listValue[2];
				intent.setClass(MainActivity.this, browseMenuActivity.class);
				startActivity(intent);
				break;
			}
		}
	};
}