package com.example.brainteaser;



import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class Main extends Activity implements OnTouchListener
	{
		MainView mv;
		boolean bugflag = false, f = false, f12 = false;
		public static int result = -1;

		Random random = new Random();
		Start ob;
		float x = 0, y = 0;
		int k, m;
		int cpuchoice = -1, i, j;
		boolean flag[] = new boolean[9];
		boolean cpuflag[] = new boolean[9];
		int win[] = new int[8];
		int lose[] = new int[8];
		Bitmap bmp[] = new Bitmap[2];

		boolean completionflag = true;
		String name;

		@Override
		public boolean onTouch(View arg0,MotionEvent event)

			{
				// TODO Auto-generated method stub
				x = event.getX();
				y = event.getY();
				int W = mv.w;
				int H = mv.h;
				int A = mv.a;
				int x_coordinates[] = { W / 2 - A / 2 - A, W / 2 - A / 2,
						W / 2 + A / 2, W / 2 - A / 2 - A, W / 2 - A / 2,
						W / 2 + A / 2, W / 2 - A / 2 - A, W / 2 - A / 2,
						W / 2 + A / 2 };
				int y_coordinates[] = { H / 2 - A / 2 - A, H / 2 - A / 2 - A,
						H / 2 - A / 2 - A, H / 2 - A / 2, H / 2 - A / 2,
						H / 2 - A / 2, H / 2 + A / 2, H / 2 + A / 2,
						H / 2 + A / 2 };
				int x_extreme=W/2+A/2+2*A;
				int y_extreme=H/2+A/2+2*A;

				forWin(x_coordinates, y_coordinates);
				checkForWin();

				checkForCompletion();
				checkForPlayerChance();
				checkForCPUChance();
				CPUWork();
				bugflag = false;

				return false;

			}

		private void CPUWork()
			{
				// TODO Auto-generated method stub
				if (completionflag == false && bugflag == false)
					{
						if (m != 10)
							{
								switch (m)
									{
									case 0:
										for (k = 0; k <= 8; k += 4)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}

										break;
									case 1:
										for (k = 0; k <= 2; k += 1)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 2:
										for (k = 3; k <= 5; k += 1)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 3:
										for (k = 6; k <= 8; k += 1)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 4:
										for (k = 0; k <= 6; k += 3)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 5:
										for (k = 1; k <= 7; k += 3)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 6:
										for (k = 2; k <= 8; k += 3)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 7:
										for (k = 2; k <= 6; k += 2)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;

									}
							} else if (j != 10)
							{
								switch (j)
									{
									case 0:
										for (k = 0; k <= 8; k += 4)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}

										break;
									case 1:
										for (k = 0; k <= 2; k += 1)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 2:
										for (k = 3; k <= 5; k += 1)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 3:
										for (k = 6; k <= 8; k += 1)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 4:
										for (k = 0; k <= 6; k += 3)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 5:
										for (k = 1; k <= 7; k += 3)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 6:
										for (k = 2; k <= 8; k += 3)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;
									case 7:
										for (k = 2; k <= 6; k += 2)
											{
												if (cpuflag[k] == false
														&& flag[k] == false)
													{
														cpuchoice = k;
														break;
													}

											}
										break;

									}
							} else
							{
								while (true)
									{
										cpuchoice = random.nextInt(8);

										if (cpuflag[cpuchoice] == false
												&& flag[cpuchoice] == false)
											break;

									}
							}
						cpuflag[cpuchoice] = true;
						switch (cpuchoice)
							{
							case 0:
								++lose[1];
								++lose[4];
								++lose[0];
								break;
							case 1:
								++lose[5];
								++lose[1];
								break;
							case 2:
								++lose[1];
								++lose[6];
								++lose[7];
								break;
							case 3:
								++lose[2];
								++lose[4];
								break;
							case 4:
								++lose[2];
								++lose[5];
								++lose[0];
								++lose[7];
								break;
							case 5:
								++lose[2];
								++lose[6];
								break;
							case 6:
								++lose[3];
								++lose[4];
								++lose[7];
								break;
							case 7:
								++lose[3];
								++lose[5];
								break;
							case 8:
								++lose[3];
								++lose[6];
								++lose[0];
								break;
							}

						for (j = 0; j < 8; ++j)
							{
								if (lose[j] == 3)
									{
										result=j;
										Intent it2 = new Intent(Main.this,
												Result.class);
										Bundle b1 = new Bundle();
										b1.putString("result", name
												+ " is a LOSER!!");
										it2.putExtras(b1);
										finish();
										startActivity(it2);

									}
							}

					}

			}

		private void checkForCPUChance()
			{
				// TODO Auto-generated method stub
				f12 = false;
				for (m = 0; m < 8; ++m)
					{
						if (lose[m] == 2 && win[m] == 0)
							{
								f12 = true;
								break;
							}

					}
				if (f12 == false)
					m = 10;

			}

		private void checkForPlayerChance()
			{
				// TODO Auto-generated method stub
				f = false;
				for (j = 0; j < 8; ++j)
					{
						if (win[j] == 2 && lose[j] == 0)
							{
								f = true;
								break;
							}

					}
				if (f == false)
					j = 10;

			}

		private void checkForCompletion()
			{
				// TODO Auto-generated method stub
				completionflag = true;
				for (j = 0; j < 9; ++j)
					{
						if (cpuflag[j] == false && flag[j] == false)
							{
								completionflag = false;
								break;
							}
					}

			}

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				mv = new MainView(this);
				ob = new Start();
				mv.setOnTouchListener(this);
				setContentView(mv);

				for (i = 0; i < 9; ++i)
					{
						flag[i] = false;

						cpuflag[i] = false;
					}
				Bundle bidua = getIntent().getExtras();
				name = bidua.getString("name");

			}

		@Override
		protected void onPause()
			{
				// TODO Auto-generated method stub
				super.onPause();
				mv.pause();
			}

		@Override
		protected void onResume()
			{
				// TODO Auto-generated method stub
				super.onResume();
				result = -1;

				mv.resume();
			}

		public class MainView extends SurfaceView implements Runnable
			{
				boolean isRunning;
				Thread thread;
				SurfaceHolder holder;
				public int w;
				public int h;
				public int a;

				public MainView(Context context)
					{
						// TODO Auto-generated constructor stub

						super(context);
						holder = getHolder();

					}

				@Override
				public void run()
					{
						// TODO Auto-generated method stub

						while (isRunning)
							{
								if (!holder.getSurface().isValid())
									continue;

								Paint paint = new Paint();
								paint.setColor(Color.WHITE);
								paint.setStrokeWidth(5);
								Paint pt=new Paint();
								pt.setStrokeWidth(8);
								pt.setColor(Color.GREEN);
								Paint pt2=new Paint();
								

								Canvas canvas = holder.lockCanvas();
								//Bitmap bbb = BitmapFactory.decodeResource(
									//	getResources(), R.drawable.superman);
								//canvas.drawBitmap(bbb, 0, 0, null);
								w = canvas.getWidth();
								h = canvas.getHeight();
								a = w / 4;
								int x_coordinates[] = { w / 2 - a / 2 - a,
										w / 2 - a / 2, w / 2 + a / 2,
										w / 2 - a / 2 - a, w / 2 - a / 2,
										w / 2 + a / 2, w / 2 - a / 2 - a,
										w / 2 - a / 2, w / 2 + a / 2 };
								int y_coordinates[] = { h / 2 - a / 2 - a,
										h / 2 - a / 2 - a, h / 2 - a / 2 - a,
										h / 2 - a / 2, h / 2 - a / 2,
										h / 2 - a / 2, h / 2 + a / 2,
										h / 2 + a / 2, h / 2 + a / 2 };
								int xextreme=w/2+a/2+a;int yextreme=h/2+a/2+a;
								canvas.drawLine(w / 2 - a / 2 - a, h / 2 - a
										/ 2, w / 2 + a + a / 2, h / 2 - a / 2,
										paint);
								canvas.drawLine(w / 2 - a / 2 - a, h / 2 + a
										/ 2, w / 2 + a + a / 2, h / 2 + a / 2,
										paint);
								canvas.drawLine(w / 2 - a / 2, h / 2 - a - a
										/ 2, w / 2 - a / 2, h / 2 + a + a / 2,
										paint);
								canvas.drawLine(w / 2 + a / 2, h / 2 - a - a
										/ 2, w / 2 + a / 2, h / 2 + a + a / 2,
										paint);
								if (flag[0] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[0]+a/5, y_coordinates[0]+a/5, x_coordinates[4]-a/5, y_coordinates[4]-a/5, pt);
												canvas.drawLine(x_coordinates[0]+a/5, y_coordinates[3]-a/5, x_coordinates[1]-a/5, y_coordinates[0]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[0]+a/2, y_coordinates[0]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[0]+a/2, y_coordinates[0]+a/2, a/2-a/5-8, pt2);
											}

									}

								if (flag[1] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[1]+a/5, y_coordinates[1]+a/5, x_coordinates[5]-a/5, y_coordinates[5]-a/5, pt);
												canvas.drawLine(x_coordinates[1]+a/5, y_coordinates[4]-a/5, x_coordinates[2]-a/5, y_coordinates[1]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[1]+a/2, y_coordinates[1]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[1]+a/2, y_coordinates[1]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (flag[2] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[2]+a/5, y_coordinates[2]+a/5, xextreme-a/5, y_coordinates[4]-a/5, pt);
												canvas.drawLine(x_coordinates[2]+a/5, y_coordinates[5]-a/5, xextreme-a/5, y_coordinates[2]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[2]+a/2, y_coordinates[2]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[2]+a/2, y_coordinates[2]+a/2, a/2-a/5-8, pt2);
											}
									}
								if (flag[3] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[3]+a/5, y_coordinates[3]+a/5, x_coordinates[7]-a/5, y_coordinates[7]-a/5, pt);
												canvas.drawLine(x_coordinates[0]+a/5, y_coordinates[6]-a/5, x_coordinates[4]-a/5, y_coordinates[3]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[3]+a/2, y_coordinates[3]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[3]+a/2, y_coordinates[3]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (flag[4] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[4]+a/5, y_coordinates[4]+a/5, x_coordinates[8]-a/5, y_coordinates[8]-a/5, pt);
												canvas.drawLine(x_coordinates[4]+a/5, y_coordinates[7]-a/5, x_coordinates[5]-a/5, y_coordinates[4]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[4]+a/2, y_coordinates[4]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[4]+a/2, y_coordinates[4]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (flag[5] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[5]+a/5, y_coordinates[5]+a/5, xextreme-a/5, y_coordinates[8]-a/5, pt);
												canvas.drawLine(x_coordinates[5]+a/5, y_coordinates[8]-a/5, xextreme-a/5, y_coordinates[5]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[5]+a/2, y_coordinates[5]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[5]+a/2, y_coordinates[5]+a/2, a/2-a/5-8, pt2);
											}
									}
								if (flag[6] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[6]+a/5, y_coordinates[6]+a/5, x_coordinates[7]-a/5, yextreme-a/5, pt);
												canvas.drawLine(x_coordinates[6]+a/5, yextreme-a/5, x_coordinates[7]-a/5, y_coordinates[7]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[6]+a/2, y_coordinates[6]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[6]+a/2, y_coordinates[6]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (flag[7] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[7]+a/5, y_coordinates[7]+a/5, x_coordinates[8]-a/5, yextreme-a/5, pt);
												canvas.drawLine(x_coordinates[7]+a/5, yextreme-a/5, x_coordinates[8]-a/5, y_coordinates[8]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[7]+a/2, y_coordinates[7]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[7]+a/2, y_coordinates[7]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (flag[8] == true)
									{
										if(Start.character==1)
											{
												canvas.drawLine(x_coordinates[8]+a/5, y_coordinates[8]+a/5, xextreme-a/5, yextreme-a/5, pt);
												canvas.drawLine(x_coordinates[8]+a/5, yextreme-a/5, xextreme-a/5, y_coordinates[8]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[8]+a/2, y_coordinates[8]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[8]+a/2, y_coordinates[8]+a/2, a/2-a/5-8, pt2);
											}

									}

								/*
								 * try { thread.sleep(200); } catch
								 * (InterruptedException e) { // TODO
								 * Auto-generated catch block
								 * e.printStackTrace(); }
								 */
								if (cpuflag[0] == true)
									{
										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[0]+a/5, y_coordinates[0]+a/5, x_coordinates[4]-a/5, y_coordinates[4]-a/5, pt);
												canvas.drawLine(x_coordinates[0]+a/5, y_coordinates[3]-a/5, x_coordinates[1]-a/5, y_coordinates[0]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[0]+a/2, y_coordinates[0]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[0]+a/2, y_coordinates[0]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[1] == true)
									{
										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[1]+a/5, y_coordinates[1]+a/5, x_coordinates[5]-a/5, y_coordinates[5]-a/5, pt);
												canvas.drawLine(x_coordinates[1]+a/5, y_coordinates[4]-a/5, x_coordinates[2]-a/5, y_coordinates[1]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[1]+a/2, y_coordinates[1]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[1]+a/2, y_coordinates[1]+a/2, a/2-a/5-8, pt2);
											}


									}
								if (cpuflag[2] == true)
									{
										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[2]+a/5, y_coordinates[2]+a/5, xextreme-a/5, y_coordinates[4]-a/5, pt);
												canvas.drawLine(x_coordinates[2]+a/5, y_coordinates[5]-a/5, xextreme-a/5, y_coordinates[2]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[2]+a/2, y_coordinates[2]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[2]+a/2, y_coordinates[2]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[3] == true)
									{

										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[3]+a/5, y_coordinates[3]+a/5, x_coordinates[7]-a/5, y_coordinates[7]-a/5, pt);
												canvas.drawLine(x_coordinates[0]+a/5, y_coordinates[6]-a/5, x_coordinates[4]-a/5, y_coordinates[3]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[3]+a/2, y_coordinates[3]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[3]+a/2, y_coordinates[3]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[4] == true)
									{
										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[4]+a/5, y_coordinates[4]+a/5, x_coordinates[8]-a/5, y_coordinates[8]-a/5, pt);
												canvas.drawLine(x_coordinates[4]+a/5, y_coordinates[7]-a/5, x_coordinates[5]-a/5, y_coordinates[4]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[4]+a/2, y_coordinates[4]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[4]+a/2, y_coordinates[4]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[5] == true)
									{

										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[5]+a/5, y_coordinates[5]+a/5, xextreme-a/5, y_coordinates[8]-a/5, pt);
												canvas.drawLine(x_coordinates[5]+a/5, y_coordinates[8]-a/5, xextreme-a/5, y_coordinates[5]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[5]+a/2, y_coordinates[5]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[5]+a/2, y_coordinates[5]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[6] == true)
									{

										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[6]+a/5, y_coordinates[6]+a/5, x_coordinates[7]-a/5, yextreme-a/5, pt);
												canvas.drawLine(x_coordinates[6]+a/5, yextreme-a/5, x_coordinates[7]-a/5, y_coordinates[7]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[6]+a/2, y_coordinates[6]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[6]+a/2, y_coordinates[6]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[7] == true)
									{

										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[7]+a/5, y_coordinates[7]+a/5, x_coordinates[8]-a/5, yextreme-a/5, pt);
												canvas.drawLine(x_coordinates[7]+a/5, yextreme-a/5, x_coordinates[8]-a/5, y_coordinates[8]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[7]+a/2, y_coordinates[7]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[7]+a/2, y_coordinates[7]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (cpuflag[8] == true)
									{

										if(Start.character==0)
											{
												canvas.drawLine(x_coordinates[8]+a/5, y_coordinates[8]+a/5, xextreme-a/5, yextreme-a/5, pt);
												canvas.drawLine(x_coordinates[8]+a/5, yextreme-a/5, xextreme-a/5, y_coordinates[8]+a/5, pt);
												
											}
										else
											{
												canvas.drawCircle(x_coordinates[8]+a/2, y_coordinates[8]+a/2, a/2-a/5, pt);
												canvas.drawCircle(x_coordinates[8]+a/2, y_coordinates[8]+a/2, a/2-a/5-8, pt2);
											}

									}
								if (result != -1)
									{
										if (result == 0)
											{
												canvas.drawLine(
														x_coordinates[0],
														y_coordinates[0],
														x_coordinates[8] + a,
														y_coordinates[8] + a,
														paint);
											} else if (result == 1)
											{
												canvas.drawLine(
														x_coordinates[0],
														y_coordinates[0] + a
																/ 2,
														x_coordinates[2] + a,
														y_coordinates[0] + a
																/ 2, paint);
											} else if (result == 2)
											{
												canvas.drawLine(
														x_coordinates[0],
														y_coordinates[3] + a
																/ 2,
														x_coordinates[2] + a,
														y_coordinates[3] + a
																/ 2, paint);
											} else if (result == 3)
											{
												canvas.drawLine(
														x_coordinates[0],
														y_coordinates[6] + a
																/ 2,
														x_coordinates[2] + a,
														y_coordinates[6] + a
																/ 2, paint);
											} else if (result == 4)
											{
												canvas.drawLine(
														x_coordinates[0] + a
																/ 2,
														y_coordinates[0],
														x_coordinates[0] + a
																/ 2,
														y_coordinates[6] + a,
														paint);
											} else if (result == 5)
											{
												canvas.drawLine(
														x_coordinates[1] + a
																/ 2,
														y_coordinates[0],
														x_coordinates[1] + a
																/ 2,
														y_coordinates[6] + a,
														paint);
											} else if (result == 6)
											{
												canvas.drawLine(
														x_coordinates[2] + a
																/ 2,
														y_coordinates[0],
														x_coordinates[2] + a
																/ 2,
														y_coordinates[6] + a,
														paint);
											} else if (result == 7)
											{
												canvas.drawLine(
														x_coordinates[0],
														y_coordinates[6] + a,
														x_coordinates[2] + a,
														y_coordinates[0], paint);
											}
									}
								holder.unlockCanvasAndPost(canvas);

							}

					}

				public void pause()
					{
						isRunning = false;
						while (true)
							{
								try
									{
										thread.join();
									} catch (InterruptedException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								break;
							}

					}

				public void resume()
					{
						isRunning = true;
						thread = new Thread(this);
						thread.start();

					}
			}

		private void forWin(int[] x_coordinates,int[] y_coordinates)
			{
				if (((x > x_coordinates[0] && x < x_coordinates[1]) && (y > y_coordinates[0] && y < y_coordinates[3])))
					{
						if (flag[0] == true)
							bugflag = true;
						else if (cpuflag[0] == false)
							{

								flag[0] = true;
								++win[1];
								++win[4];
								++win[0];
							} else
							bugflag = true;

					} else if (((x > x_coordinates[1] && x < x_coordinates[2]) && (y > y_coordinates[0] && y < y_coordinates[4])))
					{
						if (flag[1] == true)
							bugflag = true;
						else if (cpuflag[1] == false)
							{

								flag[1] = true;
								++win[5];
								++win[1];

							} else
							bugflag = true;

					} else if (((x > x_coordinates[2] && x < mv.w / 2 + mv.a
						/ 2 + mv.a) && (y > y_coordinates[0] && y < y_coordinates[5])))
					{
						if (flag[2] == true)
							bugflag = true;
						else if (cpuflag[2] == false)
							{

								flag[2] = true;
								++win[1];
								++win[6];
								++win[7];
							} else
							bugflag = true;

					} else if (((x > x_coordinates[0] && x < x_coordinates[1]) && (y > y_coordinates[3] && y < y_coordinates[6])))
					{
						if (flag[3] == true)
							bugflag = true;
						else if (cpuflag[3] == false)
							{

								flag[3] = true;
								++win[2];
								++win[4];

							} else
							bugflag = true;

					} else if (((x > x_coordinates[1] && x < x_coordinates[2]) && (y > y_coordinates[3] && y < y_coordinates[6])))
					{
						if (flag[4] == true)
							bugflag = true;
						else if (cpuflag[4] == false)
							{

								flag[4] = true;
								++win[2];
								++win[5];
								++win[0];
								++win[7];
							} else
							bugflag = true;

					} else if (((x > x_coordinates[2] && x < mv.w / 2 + mv.a
						/ 2 + mv.a) && (y > y_coordinates[3] && y < y_coordinates[6])))
					{
						if (flag[5] == true)
							bugflag = true;
						else if (cpuflag[5] == false)
							{

								flag[5] = true;
								++win[2];
								++win[6];

							} else
							bugflag = true;

					} else if (((x > x_coordinates[0] && x < x_coordinates[1]) && (y > y_coordinates[6] && y < mv.h
						/ 2 + mv.a / 2 + mv.a)))
					{
						if (flag[6] == true)
							bugflag = true;
						else if (cpuflag[6] == false)
							{

								flag[6] = true;
								++win[3];
								++win[4];
								++win[7];
							} else
							bugflag = true;

					} else if (((x > x_coordinates[1] && x < x_coordinates[2]) && (y > y_coordinates[6] && y < mv.h
						/ 2 + mv.a / 2 + mv.a)))
					{
						if (flag[7] == true)
							bugflag = true;
						else if (cpuflag[7] == false)
							{

								flag[7] = true;
								++win[3];
								++win[5];

							} else
							bugflag = true;

					} else if (((x > x_coordinates[0] && x < mv.w / 2 + mv.a
						+ mv.a / 2) && (y > y_coordinates[6] && y < mv.h / 2
						+ mv.a / 2 + mv.a)))
					{
						if (flag[8] == true)
							bugflag = true;
						else if (cpuflag[8] == false)
							{

								flag[8] = true;
								++win[3];
								++win[6];
								++win[0];
							} else
							bugflag = true;

					} else
					{
						bugflag = true;
					}
			}

		private void checkForWin()
			{
				// TODO Auto-generated method stub
				for (j = 0; j < 8; ++j)
					{
						if (win[j] == 3)

							{
								bugflag = true;
								result = j;
								
								Intent it1 = new Intent(Main.this, Result.class);
								Bundle b = new Bundle();
								b.putString("result",
										"You were lucky this time " + name
												+ ". You won!");
								it1.putExtras(b);
								finish();
								startActivity(it1);

							}
					}

			}

	}

