package com.example.brainteaser;

//package com.example.akshat.kata_zero;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TicTacToe extends ListActivity
	{
		String str[] = { "Single Player", "MultiPlayer" };

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setListAdapter(new ArrayAdapter<String>(TicTacToe.this,
						android.R.layout.simple_list_item_1, str));

			}

		@Override
		protected void onListItemClick(ListView l,View v,int position,long id)
			{
				// TODO Auto-generated method stub
				super.onListItemClick(l, v, position, id);
				switch (position)
					{
					case 0:
						Intent it = new Intent(TicTacToe.this, Start.class);
						startActivity(it);
						break;
					case 1:
						Intent it1 = new Intent(TicTacToe.this,
								StartMulti.class);
						startActivity(it1);
						break;

					}
			}
		
		public void onBackPressed(){
			Intent a = new Intent(TicTacToe.this,Menu.class);
		//	a.addCategory(Intent.CATEGORY_HOME);
		//	a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(a);

			}
	}

