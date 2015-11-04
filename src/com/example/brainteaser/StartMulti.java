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

public class StartMulti extends Activity implements OnClickListener,
		OnCheckedChangeListener
	{
		public static int character1 = 1;
		public static int character2 = 0;
		Button b;

		EditText et1, et2;

		RadioGroup rg;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{

				super.onCreate(savedInstanceState);
				setContentView(R.layout.main_activity_multi);
				initialize();
				b.setOnClickListener(this);
				rg.setOnCheckedChangeListener(this);

			}

		private void initialize()
			{

				b = (Button) findViewById(R.id.bProceedmulti);

				rg = (RadioGroup) findViewById(R.id.rgSelectionmulti);
				et1 = (EditText) findViewById(R.id.etname1);
				et2 = (EditText) findViewById(R.id.etname2);

			}

		@Override
		public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				switch (arg0.getId())
					{
					case R.id.bProceedmulti:

						Intent it = new Intent(StartMulti.this, MainMulti.class);
						Bundle bidi = new Bundle();
						String set1 = et1.getText().toString();
						String set2 = et2.getText().toString();
						if (set1.length() == 0)
							set1 = "Player 1";
						if (set2.length() == 0)
							set2 = "Player 2";
						bidi.putString("name1", set1);
						bidi.putString("name2", set2);
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
						character1 = 1;
						character2 = 0;
						break;
					case R.id.rb2:
						character1 = 0;
						character2 = 1;
						break;
					}
			}
	}
