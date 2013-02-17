package com.xinlan.russiacube.view;

import com.xinlan.russiacube.abstracts.Controller;
import com.xinlan.russiacube.component.XinlanController;
import com.xinlan.russiacube.config.Config;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * @author Administrator
 *
 */
public class MainView extends SurfaceView implements Callback, Runnable {
	private SurfaceHolder sfh;
	private Paint paint;
	private Thread th;
	private boolean flag;
	private Canvas canvas;
	private Context context;
	public static int screenW, screenH;
	private Resources res = this.getResources();
	
	public static int GAME_STATE=1;

	private Controller mController;
	
	public MainView(Context context) {
		super(context);
		this.context = context;
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setKeepScreenOn(true);
	}

	public void surfaceCreated(SurfaceHolder holder) {
		screenW = this.getWidth();
		screenH = this.getHeight();
		Config.SCREEN_HEIGHT=screenH;
		Config.SCREEN_WIDTH=screenW;
		init();
		flag = true;
		th = new Thread(this);
		th.start();
	}
	
	public void init() {
		GAME_STATE=1;
		
		mController = new XinlanController(res);
	}
	
	public void main(){
		switch(GAME_STATE){
		case 1:
			drawMain();
			logic();
			break;
		}
	}

	public void drawMain() {
		canvas = sfh.lockCanvas();
		try {
			if (canvas != null) {
				canvas.drawColor(Color.BLACK);//
				//TODO draw something
				
				mController.draw(canvas);
			}//end if
		}catch (Exception e) {
		} finally {
			if (canvas != null) {
				sfh.unlockCanvasAndPost(canvas);
			}
		}
	}

	public void logic() {
		mController.logic();
	}
	
	public void run() {
		while (flag) {
			long start = System.currentTimeMillis();
			main();
			long end = System.currentTimeMillis();
			//System.out.println(end - start);
			try {
				if (end - start < 30) {
					Thread.sleep(30- (end - start));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}// end while
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//mController.onTouch(event);
		return true;
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}
}// end class
