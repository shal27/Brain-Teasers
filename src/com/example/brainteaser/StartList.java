package com.example.brainteaser;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartList extends ListActivity
	{
		String str[] = { "Single Player", "MultiPlayer" };

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setListAdapter(new ArrayAdapter<String>(StartList.this,
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
						Intent it = new Intent(StartList.this, Start.class);
						startActivity(it);
						break;
					case 1:
						Intent it1 = new Intent(StartList.this,
								StartMulti.class);
						startActivity(it1);
						break;

					}
			}

	}
