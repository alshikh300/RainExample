package com.lscript.example.rain;

import android.app.*;
import android.content.pm.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.widget.TableRow.*;
import com.lscript.example.rain.utils.*;
import java.io.*;

public class MainActivity extends Activity 
{

	private GameView gv;

	private DisplayMetrics dm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		GameObject.WIDTH=dm.widthPixels;
		GameObject.HEIGHT=dm.heightPixels;
		GameObject.start(dm,this);
		
		gv=new GameView(this);
        setContentView(gv);

		
		boolean soundRain = PlaySound.playSound(this, "chuva.mp3",true);
		
		
    }

	@Override
	protected void onResume()
	{
		
			
		try{gv.resume();}catch(Exception e){}
			
		super.onResume();
	}

	@Override
	protected void onPause()
	{
		try{
			gv.pause();
		}catch(Exception e){}
		
		super.onPause();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus){
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_FULLSCREEN| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		}
	}

	@Override
	public void onBackPressed()
	{
		
		super.onBackPressed();
	}
	
	
	
	
	
	
	
}
