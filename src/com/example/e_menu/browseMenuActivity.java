package com.example.e_menu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class browseMenuActivity extends Activity {
	Button btn_location;
	Button btn_flight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.browse_menu);
		findview();
		init();
	}

	public void back(View v) {
		this.finish();
	}

	public void findview() {
		btn_location = (Button) findViewById(R.id.btn_location);
		btn_flight = (Button) findViewById(R.id.btn_flight);
	}

	public void init() {
		btn_location.setTextColor(Color.rgb(255, 255, 255));
		btn_flight.setTextColor(Color.rgb(50, 50, 50));
		btn_flight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setBlueBg(btn_flight);
				setWhiteBg(btn_location);
			}
		});
		btn_location.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setBlueBg(btn_location);
				setWhiteBg(btn_flight);
			}
		});
	}

	private void setBlueBg(Button v) {
		v.setBackgroundResource(R.drawable.plan4);
		v.setTextColor(Color.rgb(255, 255, 255));
	}

	private void setWhiteBg(Button v) {
		v.setBackgroundResource(R.drawable.plan5);
		v.setTextColor(Color.rgb(50, 50, 50));
	}
}