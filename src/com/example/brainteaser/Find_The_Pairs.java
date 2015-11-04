package com.example.brainteaser;

//package com.example.sha;

//import com.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
//import com.example.Find.R;

public class Find_The_Pairs extends Activity implements OnClickListener {
    
	
	Button s;
	TextView test;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			//test=(TextView) findViewById(R.id.textView1);
			//Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/FFF_Tusj.ttf");
			//test.setTypeface(custom_font);
			setContentView(R.layout.rules);
			//getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
			s=(Button) findViewById(R.id.button1);
			s.setBackgroundColor(Color.BLACK);
			s.setOnClickListener(this);
			
		//	Intent data = getIntent();
	//	Bundle baskt = data.getExtras();
		//	s = baskt.getString("ans");//("ans");
			
			//Intent a = new Intent(MainActivity.this, OpenedClass.class);
			// android:theme="@android:style/Theme.Dialog";
			//Dialog mDialog = new Dialog(getBaseContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
			
			//finish();
			
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent a = new Intent(Find_The_Pairs.this, MainActivity.class);
			startActivity(a);
		}
		
		public void onBackPressed(){
			Intent a = new Intent(Find_The_Pairs.this,Menu.class);
		//	a.addCategory(Intent.CATEGORY_HOME);
		//	a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(a);

			}
}
