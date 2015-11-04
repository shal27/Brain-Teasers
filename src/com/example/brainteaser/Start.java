package com.example.brainteaser;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Start extends Activity implements OnClickListener,
		OnCheckedChangeListener
	{
		public static int character = 1;
		Button b;
		TextView tv;
		RadioGroup rg;
		EditText et;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main_activity);
				initialize();
				b.setOnClickListener(this);
				rg.setOnCheckedChangeListener(this);

			}

		private void initialize()
			{
				// TODO Auto-generated method stub
				b = (Button) findViewById(R.id.bProceed);
				tv = (TextView) findViewById(R.id.tvSelectCharacter);
				rg = (RadioGroup) findViewById(R.id.rgSelect);
				et = (EditText) findViewById(R.id.etname);

			}

		@Override
		public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				switch (arg0.getId())
					{
					case R.id.bProceed:
						Intent it = new Intent(Start.this, Main.class);
						Bundle bidi = new Bundle();
						String set = et.getText().toString();
						if (set.length() == 0)
							set = "Player";
						bidi.putString("name", set);
						it.putExtras(bidi);
						startActivity(it);

						break;
					}

			}

		@Override
		public void onCheckedChanged(RadioGroup arg0,int x)
			{
				// TODO Auto-generated method stub
				switch (x)
					{
					case R.id.rb1:
						character = 1;
						break;
					case R.id.rb2:
						character = 0;
						break;
					}
			}
	}
