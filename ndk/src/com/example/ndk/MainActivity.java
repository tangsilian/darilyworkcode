package com.example.ndk;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	String result = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String runinwhereString = isrunninginEmualtor();
		Toast.makeText(getApplicationContext(), runinwhereString, 0).show();

	}

	// 查询os
	public String getOs() {
		String os = System.getProperty("os.name").substring(0, 3);

		// kdfgh
		return os;
	}

	// 查询是否在模拟器中运行,
	public String isrunninginEmualtor() {
		Process ps = null;
		DataOutputStream doStream = null;
		BufferedReader inBufferedReader = null;
		try {
			ps = Runtime.getRuntime().exec("getprop ro.kernel.qemu");
			// 执行getprop
			doStream = new DataOutputStream(ps.getOutputStream());
			inBufferedReader = new BufferedReader(new InputStreamReader(
					ps.getInputStream(), "GBK"));
			doStream.writeBytes("exit\n");
			doStream.flush();
			ps.wait();
			result = inBufferedReader.readLine();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (doStream != null) {
				try {
					doStream.close();
					inBufferedReader.close();
					ps.destroy();// 結束進程
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return result;

	}

}
