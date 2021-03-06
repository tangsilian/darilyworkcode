package com.example.jiemijar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

	static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		String string = this.getFilesDir() + File.separator + "igpi.jar";
		Toast.makeText(context, string, 0).show();
		if (!new File(string).exists()) {
			Toast.makeText(context, "12", 0).show();
			a(context, string, "igpi.jar", true);

		}
		// Toast.makeText(context, "12", 0).show();
	}

	public static boolean a(Context arg8, String arg9, String arg10,
			boolean arg11) {
		boolean v0 = false;
		try {
			File v1_1 = new File(arg9);
			InputStream v2 = arg8.getResources().getAssets().open(arg10);
			if ((v1_1.exists()) && v1_1.length() > 0) {
				v2.close();
				return v0;
			}
			Log.d("uzi", "duqule");
			Toast.makeText(context, "12", 0).show();
			FileOutputStream v1_2 = new FileOutputStream(arg9);
			byte[] v3 = new byte[8192];
			while (true) {
				int v4 = v2.read(v3);
				if (v4 == -1) {
					break;
				}

				v1_2.write(v3, 0, v4);
			}

			v2.close();
			v1_2.close();
			if (arg11) {
				b(arg9);
			}

			return true;
		} catch (Exception v1) {
			v1.printStackTrace();
			return v0;
		}

	}

	public static boolean b(String arg11) {
		int v2_2;
		byte[] v7;
		byte[] v6;
		byte[] v4_1;
		boolean v0 = false;
		String v3 = String.valueOf(arg11) + ".ac";
		try {
			FileInputStream v2 = new FileInputStream(arg11);
			int v4 = v2.available();
			if (v4 < 30) {
				v2.close();
				return v0;
			}

			v4_1 = new byte[v4];
			v2.read(v4_1);
			v2.close();
			byte[] v2_1 = new byte[5];
			byte[] v5 = new byte[5];
			v6 = new byte[5];
			v7 = new byte[5];
			System.arraycopy(v4_1, 0, v2_1, 0, 5);
			System.arraycopy(v4_1, 5, v5, 0, 5);
			System.arraycopy(v4_1, v4_1.length - 5, v6, 0, 5);
			System.arraycopy(v4_1, v4_1.length - 10, v7, 0, 5);
			if (!Arrays.equals(v2_1, v6)) {
				v2_2 = 0;
			} else if (Arrays.equals(v5, v7)) {
				v2_2 = 1;
			} else {
				v2_2 = 0;
			}

			if (v2_2 != 0) {
				FileOutputStream v5_1 = new FileOutputStream(v3);
				v6 = new byte[10];
				System.arraycopy(v4_1, 10, v6, 0, 10);
				v7 = new byte[v4_1.length - 30];
				System.arraycopy(v4_1, 20, v7, 0, v7.length);
				for (v2_2 = 0; v2_2 < v7.length; ++v2_2) {
					v7[v2_2] = ((byte) (v6[v2_2 % 10] ^ v7[v2_2]));
				}

				v5_1.write(v7);
				v5_1.close();
				new File(arg11).delete();
				new File(v3).renameTo(new File(arg11));
				v0 = true;
			}

			return v0;
		} catch (Exception v1) {
			v1.printStackTrace();
			return v0;
		}

	}
}
