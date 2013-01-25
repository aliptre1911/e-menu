package com.example.e_menu;

public class passengerInfomation {
	public static String name;
	public static String date;
	public static String seat;
	public static String seat_number;
	public static String stroke;
	public static String bookingClass;
	// 預定時間
	public static int departure_y;
	public static int departure_m;
	public static int departure_d;
	// 假設現在時間
	public static String now_date = "2012-09-15";
	public static int now_y = Integer.parseInt(now_date.split("-")[0]);
	public static int now_m = Integer.parseInt(now_date.split("-")[1]);
	public static int now_d = Integer.parseInt(now_date.split("-")[2]);

	public static int diffTime(int a, int b) {
		return a - b;
	}

	public static boolean isTimeOut() {

		return passengerInfomation.diffTime(passengerInfomation.departure_y,
				passengerInfomation.now_y) <= 0
				&& passengerInfomation.diffTime(
						passengerInfomation.departure_m,
						passengerInfomation.now_m) <= 0
				&& passengerInfomation.diffTime(
						passengerInfomation.departure_d,
						passengerInfomation.now_d) <= 0 && dinnerMenu.selected;
	}
}
