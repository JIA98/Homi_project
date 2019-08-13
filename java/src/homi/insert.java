package homi;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.omg.CORBA_2_3.portable.OutputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class insert {

	public static String path() {
		String path = "/home/pi/camera/";

		Date date = new Date();
		SimpleDateFormat pformat = new SimpleDateFormat("yyyy-MM-dd_HHmm");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String timePath = pformat.format(calendar.getTime());

		return path + timePath + ".jpg";
	}

	public static String week() {
		String[] weekDay = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		Calendar cal = Calendar.getInstance();

		int num = cal.get(Calendar.DAY_OF_WEEK) - 1;

		String today = weekDay[num];

		return today;

	}

	public static String DateLoader() {
		Date date = new Date();
		SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = sformat.format(calendar.getTime());
		// System.out.println(now);
		return now;

	}

	public static int temp() {
		String lon = "127.01";// 한성대학교 위/경도
		String lat = "37.58";
		String urlstr = "http://api.openweathermap.org/data/2.5/weather?" + "lat=" + lat + "&lon=" + lon
				+ "&appid=9961b6f4baedbed3785dbc72b0fb6c3f";
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bf = null;
		String line;
		String result = "";
		try {
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 버퍼에 있는 정보를 문자열로 변환.
		try {
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				// System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) jsonParser.parse(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject mainArray = (JSONObject) jsonObj.get("main");
		double ktemp = Double.parseDouble(mainArray.get("temp").toString());
		double temp = ktemp - 273.15;
		int ktemps = (int) Math.round(ktemp);// 소수점반올림하기위해
		int temps = (int) Math.round(temp);

		return temps;

	}

	public static int humidity() {
		String lon = "127.01";// 한성대학교 위/경도
		String lat = "37.58";
		String urlstr = "http://api.openweathermap.org/data/2.5/weather?" + "lat=" + lat + "&lon=" + lon
				+ "&appid=9961b6f4baedbed3785dbc72b0fb6c3f";
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bf = null;
		String line;
		String result = "";
		try {
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 버퍼에 있는 정보를 문자열로 변환.
		try {
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				// System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) jsonParser.parse(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject mainArray = (JSONObject) jsonObj.get("main");
		int humidity = Integer.parseInt(mainArray.get("humidity").toString());

		return humidity;

	}

	public static String weather() {
		String lon = "127.01";// 한성대학교 위/경도
		String lat = "37.58";
		String urlstr = "http://api.openweathermap.org/data/2.5/weather?" + "lat=" + lat + "&lon=" + lon
				+ "&appid=9961b6f4baedbed3785dbc72b0fb6c3f";
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bf = null;
		String line;
		String result = "";
		try {
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 버퍼에 있는 정보를 문자열로 변환.
		try {
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				// System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) jsonParser.parse(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
		JSONObject obj = (JSONObject) weatherArray.get(0);
		String weather = (String) obj.get("main");

		return weather;

	}

	public static void main(String[] args)
			throws MalformedURLException, ProtocolException, UnsupportedEncodingException, IOException {

		JSONObject jo1 = new JSONObject();

		jo1.put("path", path());
		jo1.put("date", DateLoader());
		jo1.put("week", week());
		jo1.put("temp", temp());
		jo1.put("humidity", humidity());
		jo1.put("weather", weather());

		System.out.println(jo1);

		// _____________________________________________________________________________________//
		// 연결
		URL url = new URL("http://172.30.1.55:3000/insert");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST"); // 보내는 타입
		conn.setRequestProperty("Content-Type", "application/json");
		// 데이터
		// String param = "{\"title\": \"asdasd\", \"body\" : \"ddddddddd\"}";
		// 전송
		OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
		try {
			osw.write(jo1.toString());
			osw.flush();
			// 응답
			BufferedReader br = null;
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			// 닫기
			osw.close();
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
