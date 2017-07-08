package com.lscript.example.rain;
import android.graphics.*;

public class Rain
{
	
	private int x ,y=(int)(Math.random()*-100)-200,yspeed=(int)(Math.random()*45)+25;
	
	
	public Rain(){
		x=(int)(Math.random()*(GameObject.ScreenWidth()));
	}
	
	
	public void draw(Canvas canvas){
		Paint p= new Paint();
		p.setColor(Color.BLUE);
		canvas.drawRect(x,y,x+5,y+12,p);
	}
	
	public void update(){
		y=y+yspeed;
		
		if(y>GameObject.ScreenHeight()){
			y=(int)(Math.random()*-100)-200;
		}
	}
}
