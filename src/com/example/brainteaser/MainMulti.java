package com.example.brainteaser;


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainMulti extends Activity implements OnTouchListener
	{
		MainMultiView mmv;
		boolean bugflagmulti = false, fmulti = false, f12multi = false;
		Random randommulti = new Random();;
		int cnt = 0;
		float xmulti = 0, ymulti = 0;
		int kmulti, mmulti;
		int cpuchoicemulti = -1, i, j;
		public static boolean flagmulti[] = new boolean[9];
		public static boolean cpuflagmulti[] = new boolean[9];
		int winmulti[] = new int[8];
		int losemulti[] = new int[8];
		public static Bitmap bmpmulti[] = new Bitmap[2];
		boolean completionflagmulti = true;
		String name1, name2;
		public static int result = -1;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				mmv = new MainMultiView(this);

				mmv.setOnTouchListener(this);
				setContentView(mmv);
				for (i = 0; i < 9; ++i)
					{
						flagmulti[i] = false;

						cpuflagmulti[i] = false;
					}
				
				Bundle biduaa = getIntent().getExtras();
				name1 = biduaa.getString("name1");
				name2 = biduaa.getString("name2");

			}

		@Override
		public boolean onTouch(View arg0,MotionEvent event)

			{
				// TODO Auto-generated method stub
				xmulti = event.getX();
				ymulti = event.getY();

				int W = MainMultiView.w;
				int H = MainMultiView.h;
				int A = MainMultiView.a;
				int x_coordinates[] = { W / 2 - A / 2 - A, W / 2 - A / 2,
						W / 2 + A / 2, W / 2 - A / 2 - A, W / 2 - A / 2,
						W / 2 + A / 2, W / 2 - A / 2 - A, W / 2 - A / 2,
						W / 2 + A / 2 };
				int y_coordinates[] = { H / 2 - A / 2 - A, H / 2 - A / 2 - A,
						H / 2 - A / 2 - A, H / 2 - A / 2, H / 2 - A / 2,
						H / 2 - A / 2, H / 2 + A / 2, H / 2 + A / 2,
						H / 2 + A / 2 };

				if (cnt % 2 == 0)
					{
						forWin(x_coordinates, y_coordinates);
						checkForWin();
					} else
					{
						forLose(x_coordinates, y_coordinates);
						checkForLose();
					}
				if (bugflagmulti == false)
					++cnt;
				checkForCompletion();

				bugflagmulti = false;

				return false;

			}

		private void checkForCompletion()
			{
				// TODO Auto-generated method stub
				completionflagmulti = true;
				for (j = 0; j < 9; ++j)
					{
						if (cpuflagmulti[j] == false && flagmulti[j] == false)
							{
								completionflagmulti = false;
								break;
							}
					}

			}

		@Override
		protected void onPause()
			{
				// TODO Auto-generated method stub
				super.onPause();
				mmv.pause();
			}

		@Override
		protected void onResume()
			{
				// TODO Auto-generated method stub
				super.onResume();
				result = -1;
				mmv.resume();
			}

		private void forWin(int x_coordinates[],int y_coordinates[])
			{
				if (((xmulti > x_coordinates[0] && xmulti < x_coordinates[1]) && (ymulti > y_coordinates[0] && ymulti < y_coordinates[3])))
					{
						if (flagmulti[0] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[0] == false)
							{

								flagmulti[0] = true;
								++winmulti[1];
								++winmulti[4];
								++winmulti[0];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[1] && xmulti < x_coordinates[2]) && (ymulti > y_coordinates[0] && ymulti < y_coordinates[3])))
					{
						if (flagmulti[1] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[1] == false)
							{

								flagmulti[1] = true;
								++winmulti[5];
								++winmulti[1];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[2] && xmulti < MainMultiView.w
						/ 2 + MainMultiView.a / 2 + MainMultiView.a) && (ymulti > y_coordinates[0] && ymulti < y_coordinates[3])))
					{
						if (flagmulti[2] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[2] == false)
							{

								flagmulti[2] = true;
								++winmulti[1];
								++winmulti[6];
								++winmulti[7];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[0] && xmulti < x_coordinates[1]) && (ymulti > y_coordinates[3] && ymulti < y_coordinates[6])))
					{
						if (flagmulti[3] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[3] == false)
							{

								flagmulti[3] = true;
								++winmulti[2];
								++winmulti[4];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[1] && xmulti < x_coordinates[2]) && (ymulti > y_coordinates[3] && ymulti < y_coordinates[6])))
					{
						if (flagmulti[4] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[4] == false)
							{

								flagmulti[4] = true;
								++winmulti[2];
								++winmulti[5];
								++winmulti[0];
								++winmulti[7];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[2] && xmulti < MainMultiView.w
						/ 2 + MainMultiView.a / 2 + MainMultiView.a) && (ymulti > y_coordinates[3] && ymulti < y_coordinates[6])))
					{
						if (flagmulti[5] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[5] == false)
							{

								flagmulti[5] = true;
								++winmulti[2];
								++winmulti[6];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[0] && xmulti < x_coordinates[1]) && (ymulti > y_coordinates[6] && ymulti < MainMultiView.h
						/ 2 + MainMultiView.a / 2 + MainMultiView.a)))
					{
						if (flagmulti[6] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[6] == false)
							{

								flagmulti[6] = true;
								++winmulti[3];
								++winmulti[4];
								++winmulti[7];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[1] && xmulti < x_coordinates[2]) && (ymulti > y_coordinates[6] && ymulti < MainMultiView.h
						/ 2 + MainMultiView.a / 2 + MainMultiView.a)))
					{
						if (flagmulti[7] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[7] == false)
							{

								flagmulti[7] = true;
								++winmulti[3];
								++winmulti[5];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[2] && xmulti < MainMultiView.w
						/ 2 + MainMultiView.a / 2 + MainMultiView.a) && (ymulti > y_coordinates[6] && ymulti < MainMultiView.h
						/ 2 + MainMultiView.a / 2 + MainMultiView.a)))
					{
						if (flagmulti[8] == true)
							bugflagmulti = true;
						else if (cpuflagmulti[8] == false)
							{

								flagmulti[8] = true;
								++winmulti[3];
								++winmulti[6];
								++winmulti[0];
							} else
							bugflagmulti = true;

					} else
					{
						bugflagmulti = true;
					}
			}

		private void forLose(int x_coordinates[],int y_coordinates[])
			{
				if (((xmulti > x_coordinates[0] && xmulti < x_coordinates[1]) && (ymulti > y_coordinates[0] && ymulti < y_coordinates[3])))
					{
						if (cpuflagmulti[0] == true)
							bugflagmulti = true;
						else if (flagmulti[0] == false)
							{

								cpuflagmulti[0] = true;
								++losemulti[1];
								++losemulti[4];
								++losemulti[0];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[1] && xmulti < x_coordinates[2]) && (ymulti > y_coordinates[0] && ymulti < y_coordinates[3])))
					{
						if (cpuflagmulti[1] == true)
							bugflagmulti = true;
						else if (flagmulti[1] == false)
							{

								cpuflagmulti[1] = true;
								++losemulti[5];
								++losemulti[1];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[2] && xmulti < MainMultiView.w
						/ 2 + MainMultiView.a / 2 + MainMultiView.a) && (ymulti > y_coordinates[0] && ymulti < y_coordinates[3])))
					{
						if (cpuflagmulti[2] == true)
							bugflagmulti = true;
						else if (flagmulti[2] == false)
							{

								cpuflagmulti[2] = true;
								++losemulti[1];
								++losemulti[6];
								++losemulti[7];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[0] && xmulti < x_coordinates[1]) && (ymulti > y_coordinates[3] && ymulti < y_coordinates[6])))
					{
						if (cpuflagmulti[3] == true)
							bugflagmulti = true;
						else if (flagmulti[3] == false)
							{

								cpuflagmulti[3] = true;
								++losemulti[2];
								++losemulti[4];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[1] && xmulti < x_coordinates[2]) && (ymulti > y_coordinates[3] && ymulti < y_coordinates[6])))
					{
						if (cpuflagmulti[4] == true)
							bugflagmulti = true;
						else if (flagmulti[4] == false)
							{

								cpuflagmulti[4] = true;
								++losemulti[2];
								++losemulti[5];
								++losemulti[0];
								++losemulti[7];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[2] && xmulti < MainMultiView.w
						/ 2 + MainMultiView.a / 2 + MainMultiView.a) && (ymulti > y_coordinates[3] && ymulti < y_coordinates[6])))
					{
						if (cpuflagmulti[5] == true)
							bugflagmulti = true;
						else if (flagmulti[5] == false)
							{

								cpuflagmulti[5] = true;
								++losemulti[2];
								++losemulti[6];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[0] && xmulti < x_coordinates[1]) && (ymulti > y_coordinates[6] && ymulti < MainMultiView.h
						/ 2 + MainMultiView.a / 2 + MainMultiView.a)))
					{
						if (cpuflagmulti[6] == true)
							bugflagmulti = true;
						else if (flagmulti[6] == false)
							{

								cpuflagmulti[6] = true;
								++losemulti[3];
								++losemulti[4];
								++losemulti[7];
							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[1] && xmulti < x_coordinates[2]) && (ymulti > y_coordinates[6] && ymulti < MainMultiView.h
						/ 2 + MainMultiView.a / 2 + MainMultiView.a)))
					{
						if (cpuflagmulti[7] == true)
							bugflagmulti = true;
						else if (flagmulti[7] == false)
							{

								cpuflagmulti[7] = true;
								++losemulti[3];
								++losemulti[5];

							} else
							bugflagmulti = true;

					} else if (((xmulti > x_coordinates[2] && xmulti < MainMultiView.w
						/ 2 + MainMultiView.a / 2 + MainMultiView.a) && (ymulti > y_coordinates[6] && ymulti < MainMultiView.h
						/ 2 + MainMultiView.a / 2 + MainMultiView.a)))
					{
						if (cpuflagmulti[8] == true)
							bugflagmulti = true;
						else if (flagmulti[8] == false)
							{

								cpuflagmulti[8] = true;
								++losemulti[3];
								++losemulti[6];
								++losemulti[0];
							} else
							bugflagmulti = true;

					} else
					{
						bugflagmulti = true;
					}
			}

		private void checkForWin()
			{
				// TODO Auto-generated method stub
				for (j = 0; j < 8; ++j)
					{
						if (winmulti[j] == 3)

							{
								result = j;
								bugflagmulti = true;

								Intent it1 = new Intent(MainMulti.this,
										Result.class);
								Bundle b = new Bundle();
								b.putString("result", name1 + " has won");
								it1.putExtras(b);
								finish();
								startActivity(it1);

							}
					}

			}

		private void checkForLose()
			{
				// TODO Auto-generated method stub
				for (j = 0; j < 8; ++j)
					{
						if (losemulti[j] == 3)

							{
								result = j;
								bugflagmulti = true;

								Intent it1 = new Intent(MainMulti.this,
										Result.class);
								Bundle b = new Bundle();
								b.putString("result", name2 + " has won");
								it1.putExtras(b);
								finish();
								startActivity(it1);

							}
					}

			}

	}
