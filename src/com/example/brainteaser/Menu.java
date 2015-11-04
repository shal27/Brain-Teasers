package com.example.brainteaser;




//package com.example.com.thenewboston.travis;

//import com.example.Find.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
  

	String classes[]={"Find_The_Pairs","TicTacToe"};//Startingpoint","TextPlay","Email","Camera","Data","GFXSUR","GFX","Soundstuff","slider","sqlite"};
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.back);
		//full screen
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
		getListView().setBackgroundDrawable(getResources().getDrawable(R.drawable.brainteas));
		
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese=classes[position];
		
		try{
	    Class<?> ourClass=Class.forName("com.example.brainteaser." + cheese);
		Intent ourIntent=new Intent(Menu.this,ourClass);
		startActivity(ourIntent);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	}

		public boolean onCreateOptionsMenu(android.view.Menu menu) {
			// TODO Auto-generated method stub
			 super.onCreateOptionsMenu(menu);
			MenuInflater blowup=getMenuInflater();
			blowup.inflate(R.menu.cool_menu, menu);
			return true;
			
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			switch(item.getItemId())
			{
			
			case R.id.exit:finish();break;
			}
			return false;
			
		}
		
		public void onBackPressed(){
			Intent a = new Intent(Intent.ACTION_MAIN);
		a.addCategory(Intent.CATEGORY_HOME);
			a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(a);

			}
	
} 
	



	


