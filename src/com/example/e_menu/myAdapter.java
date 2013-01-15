package com.example.e_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends BaseAdapter {

	private LayoutInflater myInflater;
	String[] list = null;
	int img[] = null;

	public myAdapter(Context ctxt, String[] list, int[] img) {
		myInflater = LayoutInflater.from(ctxt);
		this.list = list;
		this.img = img;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MyView view = null;

		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.layout_adapter, null);

			view = new MyView(
					(ImageView) convertView
							.findViewById(R.id.adapter_imageview_icon),
					(TextView) convertView
							.findViewById(R.id.adapter_textview_title));
			convertView.setTag(view);
		} else {
			view = (MyView) convertView.getTag();
		}

		view.icon.setBackgroundResource(img[position]);
		view.title.setText(list[position]);

		return convertView;
	}

	class MyView {
		ImageView icon;
		TextView title;

		public MyView(ImageView icon, TextView title) {
			this.icon = icon;
			this.title = title;
		}

	}
}