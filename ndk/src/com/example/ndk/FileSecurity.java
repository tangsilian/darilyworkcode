package com.example.ndk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FileSecurity extends Activity {
	TextView text1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		Toast.makeText(
				getApplicationContext(),
				jiemifacebook
						.b("rAQxGe4eB8bHF8bxn9Ti+QTQM1mRdsX3UgMWt2CkMpq7Pwv/4ZCn6hFfbvZg zEww"),
				0).show();
		text1 = (TextView) findViewById(R.id.text1);
	}
}
