package com.lscript.example.rain;
import android.app.*;
import android.content.*;
import android.util.*;
import android.view.*;

public class GameObject
{
	public static int WIDTH,HEIGHT;
	public static DisplayMetrics dm;
	
	private static Context ctx;
	
	public static void start(DisplayMetrics d,Context c){
		dm=d;
		ctx=c;
	}
	
	
	
	
	
	
	public static int ScreenWidth(){
		
		if(android.os.Build.VERSION.SDK_INT>=17){
			int uiFlags = ((Activity)ctx).getWindow().getDecorView().getSystemUiVisibility();
			if((uiFlags&View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)==0){
				DisplayMetrics metrics = new DisplayMetrics();
				((Activity)ctx).getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
				int width_ = metrics.widthPixels;
				int height_ = metrics.heightPixels;
				if(height_>width_){
					int x = height_;
					height_ = width_;
					width_ = x;
				}
				return width_;
			}else{
				return WIDTH;
			}
		}else{
			return WIDTH;
		}
		
	}
	public static int ScreenHeight(){
		if(android.os.Build.VERSION.SDK_INT>=17){
			int uiFlags = ((Activity)ctx).getWindow().getDecorView().getSystemUiVisibility();
			if((uiFlags&View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)==0){
				DisplayMetrics metrics = new DisplayMetrics();
				((Activity)ctx).getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
				int width_ = metrics.widthPixels;
				int height_ = metrics.heightPixels;
				if(height_>width_){
					int x = height_;
					height_ = width_;
					width_ = x;
				}
				return height_;
			}else{
				return HEIGHT;
			}
		}else{
			return HEIGHT;
		}
		
		
	}
}
