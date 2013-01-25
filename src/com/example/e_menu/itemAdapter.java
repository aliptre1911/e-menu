package com.example.e_menu;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class itemAdapter extends BaseAdapter {

	private LayoutInflater myInflater;
	private ArrayList<String> list = null;
	private int selectedIndex;
	private String indexArr[] = new String[26];
	public String dinner;

	public itemAdapter(Context ctxt, ArrayList<String> list, int selectedIndex) {
		myInflater = LayoutInflater.from(ctxt);
		this.list = list;
		this.selectedIndex = selectedIndex;
		// A ~ Z
		for (int i = 65; i <= 90; i++)
			indexArr[i - 65] = (char) i + ".";
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MyView holder;
		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.item, null);
			holder = new MyView(
					(RadioButton) convertView.findViewById(R.id.item_btn),
					(TextView) convertView.findViewById(R.id.item_no),
					(TextView) convertView.findViewById(R.id.item));
			convertView.setTag(holder);
		} else {
			holder = (MyView) convertView.getTag();
		}

		// ¿ï¨ú
		holder.itemBtn.setChecked(position == selectedIndex ? true : false);
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectedIndex = position;
				itemAdapter.this.notifyDataSetChanged();
			}
		});

		this.dinner = indexArr[selectedIndex] + list.get(selectedIndex);
		// set text
		holder.item_no.setText(indexArr[position]);
		holder.item.setText(list.get(position));
		return convertView;
	}

	public String getDinnerName() {
		return this.dinner;
	}

	class MyView {
		RadioButton itemBtn;
		TextView item_no;
		TextView item;

		public MyView(RadioButton itemBtn, TextView item_no, TextView item) {
			this.itemBtn = itemBtn;
			this.item_no = item_no;
			this.item = item;
		}
	}
}