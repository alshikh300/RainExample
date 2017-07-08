package com.lscript.example.rain.utils;

import android.content.*;
import android.content.res.*;
import android.media.*;
import android.net.*;
import android.widget.*;
import java.io.*;


/*
	PlaySound by @Lscript23
*/

public class PlaySound
{

	private static MediaPlayer p;
 	
	
	public static boolean playSound(Context ctx,String fileName,boolean bool){
		
		
		try
		{
			p = new MediaPlayer();
			AssetFileDescriptor afd = ctx.getAssets().openFd(fileName);
			p.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
			afd.close();
			p.prepare();
			p.setLooping(bool);
			p.start();
			
			
			
			
			return true;
		} catch (Exception e) {
			Toast.makeText(ctx,""+e,Toast.LENGTH_LONG).show();
			return false;
		}
		
	}
	
	
	
	
}
