package com.example.brainteaser;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
//import android.widget.ImageImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.brainteaser.R;
//import com.example.Find.R;


public class MainActivity extends Activity implements OnClickListener {
ImageButton image[]=new ImageButton[24];
 int flag[]=new int[24];int k;
int chk[]=new int[24];
int index=-1,index1=-1;
int counter[]=new int[4];
 int n2=-1;
int cnt=0;
TextView text1;

private  final String FORMAT = "%02d:%02d:%02d";

int seconds , minutes;

//private Thread thread;    
int i;
public void pairs(final int i1,final int i2,final int nn1,final int nn2){
	final int[] cards={R.drawable.guava,R.drawable.apple,R.drawable.red,R.drawable.pineapple};//,R.drawable.card5,R.drawable.card6,R.drawable.card7};
	 //if(cnt!=10){
	image[i1].setImageResource(cards[nn1]);
	// flag[i1]=1;
	 image[i1].setTag(Integer.valueOf(nn1)); 
	 
	 Runnable clickButton = new Runnable() { 
        @Override
        public void run() {
            // whatever you would like to implement when or after clicking button
       	 /*image[i1].setImageResource(cards[nn1]);  
       	 if(nn2!=-1 && i2!=-1)
       	image[i2].setImageResource(cards[nn2]); */  
        	  if(i1!=-1 && i2!=-1 &&  flag[i1]!=2 && flag[i2]!=2){
        			if(image[i1].getTag()!=image[i2].getTag()){
        				
        			 image[i1].setImageResource(R.drawable.door);
        				image[i2].setImageResource(R.drawable.door);
        				index=-1;
        				index1=-1;
        				n2=-1;
        				
        				}
        			else if(image[i1].getTag()==image[i2].getTag())
        			{
        				cnt++;
        				index=-1;
        				index1=-1;
        				//n1=-1;
        				n2=-1;
        				flag[i1]=2;
        				flag[i2]=2;
        			}
        	  }
}
    };
    
    image[i1].postDelayed(clickButton, 250); 
    
	
	if(cnt==11)
	{
		 Bundle result = new Bundle();
         Intent returnIntent = new Intent(MainActivity.this,Myclass.class);
         
 		result.putString("ans", "Congratz..YOU FOUND ALL THE PAIRS!!");//("key", j);// ("key",setdata);
 		
         returnIntent.putExtras(result);
         startActivity(returnIntent);
		//Toast.makeText(this, "WON BABY", Toast.LENGTH_SHORT).show();
	}
	 //}
	 
		//flag[i1]=0;
	//	flag[i2]=0;
		
	//i1=0;

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // image[]=new ImageImageButton[41];
       // ImageView 
       // k=0;
        setContentView(R.layout.activity_main);
        text1=(TextView)findViewById(R.id.textView1);

        new CountDownTimer(61000, 1000) { // adjust the milli seconds here

            @SuppressLint("NewApi") public void onTick(long millisUntilFinished) {

                text1.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
      TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                          TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));              
            }

            public void onFinish() {
            	if(cnt!=11){
            	Bundle result = new Bundle();
                Intent returnIntent = new Intent(MainActivity.this,Myclass.class);
                
        		result.putString("ans", "Ooops!Times up!");//("key", j);// ("key",setdata);
        		
                returnIntent.putExtras(result);
                startActivity(returnIntent);
                //finish();
            	}
            }
         }.start();             

      //setWillNotDraw(false);
        for(i=0;i<24;i++)
        	{flag[i]=0;}//chk[i]=0;}
        for(i=0;i<4;i++)
        	counter[i]=0;
        image[0] = (ImageButton) findViewById(R.id.imageButton1);
		image[1] = (ImageButton) findViewById(R.id.imageButton2);
		image[2] = (ImageButton) findViewById(R.id.ImageButton01);
		image[3] = (ImageButton) findViewById(R.id.ImageButton02);
		image[4] = (ImageButton) findViewById(R.id.ImageButton03);
		//image[5] = (ImageButton) findViewById(R.id.ImageButton04);
		image[5] = (ImageButton) findViewById(R.id.ImageButton05);
		image[6] = (ImageButton) findViewById(R.id.ImageButton06);
		image[7] = (ImageButton) findViewById(R.id.ImageButton07);
//		image[9] = (ImageButton) findViewById(R.id.ImageButton08);
		image[8] = (ImageButton) findViewById(R.id.ImageButton09);
		image[9] = (ImageButton) findViewById(R.id.ImageButton10);
		image[10] = (ImageButton) findViewById(R.id.ImageButton11);
		image[11] = (ImageButton) findViewById(R.id.ImageButton12);
	 
			//image[14] = (ImageButton) findViewById(R.id.ImageButton13);
			image[12] = (ImageButton) findViewById(R.id.ImageButton14);
			image[13] = (ImageButton) findViewById(R.id.ImageButton15);
			image[14] = (ImageButton) findViewById(R.id.ImageButton16);
			image[15] = (ImageButton) findViewById(R.id.ImageButton17);
			//image[1] = (ImageButton) findViewById(R.id.ImageButton18);
			image[16] = (ImageButton) findViewById(R.id.ImageButton19);
			image[17] = (ImageButton) findViewById(R.id.ImageButton20);
			//image[22] = (ImageButton) findViewById(R.id.ImageButton21);
			//image[23] = (ImageButton) findViewById(R.id.ImageButton22);
			image[18] = (ImageButton) findViewById(R.id.ImageButton23);
			//image[25] = (ImageButton) findViewById(R.id.ImageButton24);
			//image[26] = (ImageButton) findViewById(R.id.ImageButton25);
			image[19] = (ImageButton) findViewById(R.id.ImageButton26);
			image[20] = (ImageButton) findViewById(R.id.ImageButton27);
			//image[25] = (ImageButton) findViewById(R.id.ImageButton28);
			image[21] = (ImageButton) findViewById(R.id.ImageButton29);
			//image[] = (ImageButton) findViewById(R.id.ImageButton30);
			//image[32] = (ImageButton) findViewById(R.id.ImageButton31);
			image[22] = (ImageButton) findViewById(R.id.ImageButton32);
			//image[34] = (ImageButton) findViewById(R.id.ImageButton33);
			//image[35] = (ImageButton) findViewById(R.id.ImageButton34);
			image[23] = (ImageButton) findViewById(R.id.ImageButton35);
			//image[37] = (ImageButton) findViewById(R.id.ImageButton37);
			//image[38] = (ImageButton) findViewById(R.id.ImageButton38);
		//	image[29] = (ImageButton) findViewById(R.id.ImageButton39);
			//image[37] = (ImageButton) findViewById(R.id.ImageButton36);
		
	
        //image =(ImageView) findViewById(R.id.imageView1);
      /*  TableLayout table = new TableLayout(this);
        for (int i = 0; i < 8; i++) {
            TableRow row = new TableRow(this);
            for (int j = 0; j < 5; j++) {
            	//image = new ImageImageButton;
               image[k].setImageResource(R.drawable.door);
                k++;
                row.addView(image[k]);
            }
            table.addView(row);
        }
        setContentView(table);*/
			for(k=0;k<24;k++)
			image[k].setImageResource(R.drawable.door);
		
    // for( k=0;k<24;k++)
    /*    image[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 Random r = new Random();
		    	 int n=r.nextInt(4);
				if(flag[0]!=1){
				 int[] cards={R.drawable.guava,R.drawable.apple,R.drawable.red,R.drawable.pineapple};//,R.drawable.card5,R.drawable.card6,R.drawable.card7};
		    	
		    	 image[0].setImageResource(cards[n]);
		    	// chk[n]++;
				
		    	 flag[0]=1;
		    	 
		    	//image[0].setTag(Integer.valueOf(n)); 
				}
				//if(chk[n]%2==0){
					//if(image[0].getTag()!=image[index].getTag()){
					//image[0].setImageResource(R.drawable.door);
					//image[index].setImageResource(R.drawable.door);
					//}
				//}
				index=0;
				
				
			}
			
        });
image[1].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Random r = new Random();
		    	 int n=r.nextInt(4);
				if(flag[1]!=1){
				 int[] cards={R.drawable.guava,R.drawable.apple,R.drawable.red,R.drawable.pineapple};//,R.drawable.card5,R.drawable.card6,R.drawable.card7};
		    	 
                 //  chk[n]++;
		    	 flag[1]=1;
		    //	 image[1].setTag(Integer.valueOf(n)); 
				}
				index=1;
			}
			
			
        });*/
image[0].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[0]!=2)
		index1=0;//int n1=-1;
		int n1;
		if(flag[0]==0){
			do{
			Random r = new Random();
		     n1=r.nextInt(4);
			
			}while(counter[n1]>=6);
			counter[n1]++;
			chk[0]=n1;
			flag[0]=1;
			
		 pairs(index1,index,n1,n2);
		 index=0;
			n2=n1;
			
			
			
		}
		
			
		else if(flag[0]==1 && index!=0){
			pairs(index1,index,chk[0],n2);
			index=0;
			n2=chk[0];
		    
		}
	}
	
});
image[1].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[1]!=2)
		index1=1;
		int n1;
		if(flag[1]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			
			 chk[1]=n1;flag[1]=1;
		pairs(index1,index,n1,n2);
		index=1;
		n2=n1;
		
	}
		else if(flag[1]==1 && index!=1)
		{	pairs(index1,index,chk[1],n2);
		index=1;
		n2=chk[1];}
	
	}
});
image[2].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[2]!=2)
index1=2;
		int n1;
		if(flag[2]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			 chk[2]=n1;flag[2]=1;
		pairs(index1,index,n1,n2);
		index=2;
		n2=n1;
		
	}
		else if(flag[2]==1&& index!=2)
		{	pairs(index1,index,chk[2],n2);
		index=2;
		n2=chk[2];}
	
	}
	
});
image[3].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[3]!=2)
index1=3;
		int n1;
		
		if(flag[3]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			 chk[3]=n1;flag[3]=1;
		pairs(index1,index,n1,n2);
		index=3;
		n2=n1;
		
	}
		else if(flag[3]==1 && index!=3)
			{pairs(index1,index,chk[3],n2);
		index=3;
		n2=chk[3];
			}
		
	}
	
});
image[4].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[4]!=2)
index1=4;
		int n1;
		if(flag[4]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[4]=n1;flag[4]=1;
		pairs(index1,index,n1,n2);
		index=4;
		n2=n1;
		
	}
		else if(flag[4]==1 && index!=4)
		{	pairs(index1,index,chk[4],n2);
		index=4;
		n2=chk[4];
		}
	}
	
});
image[5].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[5]!=2)
index1=5;
		int n1;
		if(flag[5]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			
			 chk[5]=n1;flag[5]=1;
		pairs(index1,index,n1,n2);
		index=5;
		n2=n1;
		
	}
		else if(flag[5]==1 && index!=5){
			pairs(index1,index,chk[5],n2);
			index=5;
			n2=chk[5];
			
	
	}}
});
image[6].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[6]!=2)
index1=6;
		int n1;
		if(flag[6]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[6]=n1;flag[6]=1;
		pairs(index1,index,n1,n2);
		index=6;
		n2=n1;
		
	}
		else if(flag[6]==1 && index!=6){
			pairs(index1,index,chk[6],n2);
			index=6;
			n2=chk[6];	
		}
		}
	
});
image[7].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[7]!=2)
index1=7;
		int n1;
		if(flag[7]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
		//	Random r = new Random();
			// final int n1=r.nextInt(4);
			 chk[7]=n1;flag[7]=1;
		pairs(index1,index,n1,n2);
		index=7;
		n2=n1;
		
	}
		else if(flag[7]==1 && index!=7)
			{pairs(index1,index,chk[7],n2);
			index=7;
			n2=chk[7];
			}
	}
	
});
image[8].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[8]!=2)
		index1=8;
		int n1;
		if(flag[8]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
		//	Random r = new Random();
			// final int n1=r.nextInt(4);
			 chk[8]=n1;flag[8]=1;
		pairs(index1,index,n1,n2);
		index=8;
		n2=n1;
		
	}
		else if(flag[8]==1&& index!=8)
		{			pairs(index1,index,chk[8],n2);
		index=8;
		n2=chk[8];
		}
	}
	
});image[9].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[9]!=2)
index1=9;
		int n1;
		if(flag[9]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			//Random r = new Random();
		//	 final int n1=r.nextInt(4);
			 chk[9]=n1;flag[9]=1;
		pairs(index1,index,n1,n2);
		index=9;
		n2=n1;
		
	}
		else if(flag[9]==1 && index!=9)
		{	pairs(index1,index,chk[9],n2);
		index=9;
		n2=chk[9];
		}
	
	}
	
});image[10].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[10]!=2)
index1=10;
		int n1;
		
		if(flag[10]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
		//	Random r = new Random();
			// final int n1=r.nextInt(4);
			 chk[10]=n1;flag[10]=1;
		pairs(index1,index,n1,n2);
		index=10;
		n2=n1;
		
	}
		else if(flag[10]==1&& index!=10)
		{	pairs(index1,index,chk[10],n2);
		index=10;
		n2=chk[10];
		}
	
		
	}
	
});image[11].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[11]!=2)
index1=11;
		int n1;
		if(flag[11]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[11]=n1;flag[11]=1;
		pairs(index1,index,n1,n2);
		index=11;
		n2=n1;
		
	}
		else if(flag[11]==1 && index!=11)
			{pairs(index1,index,chk[11],n2);
			index=11;
			n2=chk[11];
			}
	
		
	}
	
});image[12].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[12]!=2)
index1=12;
		int n1;
		if(flag[12]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[12]=n1;flag[12]=1;
		pairs(index1,index,n1,n2);
		index=12;
		n2=n1;
		
	}
		else if(flag[12]==1 && index!=12){
			pairs(index1,index,chk[12],n2);
			index=12;
			n2=chk[12];	
		}
	
		
	}
	
});image[13].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[13]!=2)
index1=13;
		int n1;
		if(flag[13]==0){
		//	Random r = new Random();
			// final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[13]=n1;flag[13]=1;
		pairs(index1,index,n1,n2);
		index=13;
		n2=n1;
		
	}
		else if(flag[13]==1 && index!=13)
			{pairs(index1,index,chk[13],n2);
			index=13;
			n2=chk[13];
			}
	}
	
});image[14].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[14]!=2)
index1=14;
		int n1;
		if(flag[14]==0){
		//	Random r = new Random();
			// final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[14]=n1;flag[14]=1;
		pairs(index1,index,n1,n2);
		index=14;
		n2=n1;
		
	}
		else if(flag[14]==1 && index!=14){
			pairs(index1,index,chk[14],n2);
			index=14;
			n2=chk[14];
	}}
	
});image[15].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[15]!=2)index1=15;
		int n1;
		if(flag[15]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[15]=n1;flag[15]=1;
		pairs(index1,index,n1,n2);
		index=15;
		n2=n1;
		
	}
		else if(flag[15]==1&& index!=15){
			pairs(index1,index,chk[15],n2);
			index=15;
			n2=chk[15];
		}
	}
	
});image[16].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[16]!=2)
index1=16;
		int n1;
		if(flag[16]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			 chk[16]=n1;flag[16]=1;
		pairs(index1,index,n1,n2);
		index=16;
		n2=n1;
		
	}
		else if(flag[16]==1 && index!=16){
			pairs(index1,index,chk[16],n2);
			index=16;
			n2=chk[16];
		}
	}
	
});image[17].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[17]!=2)
index1=17;
		int n1;
		if(flag[17]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[17]=n1;flag[17]=1;
		pairs(index1,index,n1,n2);
		index=17;
		n2=n1;
		
	}
		else if(flag[17]==1 && index!=17){
			pairs(index1,index,chk[17],n2);
			index=17;
			n2=chk[17];
		}
	}
	
});image[18].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[18]!=2)
index1=18;
		int n1;
		if(flag[18]==0){
			//Random r = new Random();
			// final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[18]=n1;flag[18]=1;
		pairs(index1,index,n1,n2);
		index=18;
		n2=n1;
		
	}
		else if(flag[18]==1 && index!=18){
			pairs(index1,index,chk[18],n2);
			index=18;
			n2=chk[18];
		}
		
	}
	
});image[19].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[19]!=2)
index1=19;
		int n1;
		if(flag[19]==0){
//			Random r = new Random();
	//		 final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[19]=n1;flag[19]=1;
		pairs(index1,index,n1,n2);
		index=19;
		n2=n1;
		
	}
		else if(flag[19]==1&& index!=19){
			pairs(index1,index,chk[19],n2);
			index=19;
			n2=chk[19];
		}
	}
	
});image[20].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[20]!=2)
index1=20;
		int n1;
		if(flag[20]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[20]=n1;flag[20]=1;
		pairs(index1,index,n1,n2);
		index=20;
		n2=n1;
		
	}
		else if(flag[20]==1&& index!=20){
			pairs(index1,index,chk[20],n2);
			index=20;
			n2=chk[20];
	}}
	
});image[21].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[21]!=2)
index1=21;
		int n1;
		if(flag[21]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[21]=n1;flag[21]=1;
		pairs(index1,index,n1,n2);
		index=21;
		n2=n1;
		
	}
		else if(flag[21]==1 && index!=21){
			pairs(index1,index,chk[21],n2);
			index=21;
			n2=chk[21];
		}
	}
	
});image[22].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[22]!=2)
index1=22;
		int n1;
		if(flag[22]==0){
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			 chk[22]=n1;flag[22]=1;
		pairs(index1,index,n1,n2);
		index=22;
		n2=n1;
		
	}
		else if(flag[22]==1&& index!=22){
			pairs(index1,index,chk[22],n2);
			index=22;
			n2=chk[22];
		}
	}
	
});image[23].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag[23]!=2)
index1=23;
		int n1;
		if(flag[23]==0){
			do{
				Random r = new Random();
			     n1=r.nextInt(4);
				
				}while(counter[n1]>=6);
				counter[n1]++;
			//Random r = new Random();
			 //final int n1=r.nextInt(4);
			 chk[23]=n1;flag[23]=1;
		pairs(index1,index,n1,n2);
		index=23;
		n2=n1;
		
	}
		else if(flag[23]==1&& index!=23)
		{	pairs(index1,index,chk[23],n2);
		index=23;
		n2=chk[23];
		}}
	
});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
   

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up ImageButton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
    

	//@Override
	//public void onClick(View v) {
		
		//return false;
	//}
}

	
