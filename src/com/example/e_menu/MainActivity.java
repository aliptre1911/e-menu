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
	// �M��ﶵ�W��
	protected String[] listValue = { "�w���\�I", "�q�\����", "�s�����" };
	// �M��ﶵ�Ϥ�
	protected int[] listImg = { R.drawable.list_icon01, R.drawable.list_icon02,
			R.drawable.list_icon03 };

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
				// �w���\�I
				intent.setClass(MainActivity.this, preselectedActivity.class);
				startActivity(intent);
				break;
			case 1:
				// �q�\����
			case 2:
				// �s�����
				break;
			}
		}
	};
}