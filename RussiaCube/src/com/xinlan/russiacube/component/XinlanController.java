package com.xinlan.russiacube.component;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.xinlan.russiacube.R;
import com.xinlan.russiacube.abstracts.Controller;
import com.xinlan.russiacube.config.Config;

public class XinlanController implements Controller {
	private Resources res;
	private Bitmap mCrossBitmap;
	
	public static final int DELTA=10;
	private int cross_left,cross_top,cross_height,cross_width;
	private Rect srcRect,dstRect;
	
	public XinlanController(Resources _res){
		this.res=_res;
		cross_height=Config.getPercentByHeight(0.3f);
		cross_width=Config.getPercentByWidth(0.48f);
		cross_left = DELTA;
		cross_top=Config.SCREEN_HEIGHT-(DELTA+cross_height);
		mCrossBitmap = BitmapFactory.decodeResource(res, R.drawable.cross);
		
		srcRect = new Rect(0,0,mCrossBitmap.getWidth(),mCrossBitmap.getHeight());
		dstRect=  new Rect(cross_left,cross_top,cross_left+cross_width , cross_top+cross_height);
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(mCrossBitmap, srcRect, dstRect, null);
	}
	
	@Override
	public void clickUpBtn() {
		
	}

	@Override
	public void clickDownBtn() {
		
	}

	@Override
	public void clickLeftBtn() {
		
	}

	@Override
	public void clickRightBtn() {
		
	}

	@Override
	public void clickAButton() {
		
	}

	@Override
	public void clickBButton() {
		
	}

	@Override
	public boolean onTouch(MotionEvent event) {
		return false;
	}

	@Override
	public void logic() {
	}
}
