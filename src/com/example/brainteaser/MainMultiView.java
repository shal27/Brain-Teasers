package com.example.brainteaser;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainMultiView extends SurfaceView implements Runnable
	{

		boolean isRunningmulti;
		Thread threadmulti;
		SurfaceHolder holdermulti;
		public static int w;
		public static int h;
		public static int a;

		public MainMultiView(Context context)
			{
				super(context);
				holdermulti = getHolder();

			}

		@Override
		public void run()
			{
				// TODO Auto-generated method stub

				while (isRunningmulti)
					{
						if (!holdermulti.getSurface().isValid())
							continue;

						Paint paint = new Paint();
						paint.setColor(Color.WHITE);
						paint.setStrokeWidth(5);
						Paint pt=new Paint();
						pt.setColor(Color.GREEN);
						pt.setStrokeWidth(8);
						Paint pt2=new Paint();
						

						Canvas canvas = holdermulti.lockCanvas();

					//	Bitmap bbb = BitmapFactory.decodeResource(
						//		getResources(), R.drawable.superman);
					//	canvas.drawBitmap(bbb, 0, 0, null);
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
								h / 2 - a / 2, h / 2 - a / 2, h / 2 - a / 2,
								h / 2 + a / 2, h / 2 + a / 2, h / 2 + a / 2 };
						canvas.drawLine(w / 2 - a / 2 - a, h / 2 - a / 2, w / 2
								+ a + a / 2, h / 2 - a / 2, paint);
						canvas.drawLine(w / 2 - a / 2 - a, h / 2 + a / 2, w / 2
								+ a + a / 2, h / 2 + a / 2, paint);
						canvas.drawLine(w / 2 - a / 2, h / 2 - a - a / 2, w / 2
								- a / 2, h / 2 + a + a / 2, paint);
						canvas.drawLine(w / 2 + a / 2, h / 2 - a - a / 2, w / 2
								+ a / 2, h / 2 + a + a / 2, paint);
						int xextreme=w/2+a/2+a;
						int yextreme=h/2+a/2+a;
						if (MainMulti.flagmulti[0] == true)
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

						if (MainMulti.flagmulti[1] == true)
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
						if (MainMulti.flagmulti[2] == true)
							{if(Start.character==1)
								{
									canvas.drawLine(x_coordinates[2]+a/5, y_coordinates[2]+a/5, xextreme-a/5, y_coordinates[4]-a/5, pt);
									canvas.drawLine(x_coordinates[2]+a/5, y_coordinates[5]-a/5, xextreme-a/5, y_coordinates[2]+a/5, pt);
									
								}
							else
								{
									canvas.drawCircle(x_coordinates[2]+a/2, y_coordinates[2]+a/2, a/2-a/5, pt);
									canvas.drawCircle(x_coordinates[2]+a/2, y_coordinates[2]+a/2, a/2-a/5-8, pt2);
								}}
						if (MainMulti.flagmulti[3] == true)
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
						if (MainMulti.flagmulti[4] == true)
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
						if (MainMulti.flagmulti[5] == true)
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
						if (MainMulti.flagmulti[6] == true)
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
						if (MainMulti.flagmulti[7] == true)
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
						if (MainMulti.flagmulti[8] == true)
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

						if (MainMulti.cpuflagmulti[0] == true)
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
						if (MainMulti.cpuflagmulti[1] == true)
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
						if (MainMulti.cpuflagmulti[2] == true)
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
						if (MainMulti.cpuflagmulti[3] == true)
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
						if (MainMulti.cpuflagmulti[4] == true)
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
						if (MainMulti.cpuflagmulti[5] == true)
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
						if (MainMulti.cpuflagmulti[6] == true)
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
						if (MainMulti.cpuflagmulti[7] == true)
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
						if (MainMulti.cpuflagmulti[8] == true)
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
						
						
						int result=MainMulti.result;
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

						holdermulti.unlockCanvasAndPost(canvas);
					}

			}

		public void pause()
			{
				isRunningmulti = false;
				while (true)
					{
						try
							{
								threadmulti.join();
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
				isRunningmulti = true;
				threadmulti = new Thread(this);
				threadmulti.start();

			}

	}
