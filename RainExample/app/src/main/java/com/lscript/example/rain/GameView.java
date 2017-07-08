package com.lscript.example.rain;
import android.view.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;
import android.widget.ActionMenuView.*;
import com.lscript.example.rain.utils.*;
import android.util.*;

public class GameView extends SurfaceView implements Runnable {

	
    
    volatile boolean playing;
    
    private Thread gameThread = null;
    
	private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
	public Context context;

	private Rain[] rain = new Rain[250];
	

	//private World world;
	
	
	
	

	
    
    public GameView(Context context) {
        super(context); 
		this.context=context;
		surfaceHolder=getHolder();
		paint=new Paint();
		for(int i=0;i<rain.length;i++){
			rain[i] = new Rain();
		}
		
		
    }

	
    @Override
    public void run() {
		
		
		
        while (playing) {
			
			//to update the frame 
            update();

			//to draw the frame 
            draw();

			
			try
			{
				gameThread.sleep(30);
			}
			catch (InterruptedException e)
			{}
			
			
			}
    }


    private void update() {
		for(int i=0;i<rain.length;i++){
			rain[i].update();
		}
	}

    private void draw() {
		if (surfaceHolder.getSurface().isValid()) {
            //locking the canvas
            canvas = surfaceHolder.lockCanvas();
			canvas.drawColor(Color.GRAY);
			
			
			
			
			for(int i=0;i<rain.length;i++){
				rain[i].draw(canvas);
			}
			
			
			
			
			
			
			
				
		
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    /*private void control() {
		
		
		
		totalTime = System.nanoTime()-startTime;
		FPS = (int) (targetTime-totalTime)/1000000;
		if(totalTime < targetTime){
			try {
				
				gameThread.sleep((int) (targetTime-totalTime)/1000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public void pause() {
		
        playing = false;
        try {
			
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
		
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
	
	
	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		return true;
	}

	
	
	
	
	public void print(String s){
		Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
	}
	
	
}
