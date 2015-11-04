package com.example.brainteaser;



import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity
	{
		TextView tv;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.result);
				tv = (TextView) findViewById(R.id.tvresult);
				Bundle bidi = getIntent().getExtras();
				String str = bidi.getString("result");
				tv.setText(str);
			}

	}
