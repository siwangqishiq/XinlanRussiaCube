package com.xinlan.russiacube.role;

import java.util.LinkedList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cell {
	private int x, y, r;
	private int dir_x, dir_y;
	private int color;
	private Paint paint;
	private LinkedList<Cell> cellsRoot;
	
	public Cell(LinkedList<Cell> cellList) {
		color = Color.rgb(Common.genRand(0, 255), Common.genRand(0, 255),
				Common.genRand(0, 255));
		paint = new Paint();
		paint.setColor(color);
		r=5;
	}

	public void draw(Canvas canvas) {
		canvas.drawCircle(x, y, r, paint);
	}

	public void logic() {
		
	}
}// end class
