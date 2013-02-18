package com.xinlan.russiacube.role;

import java.util.LinkedList;

import com.xinlan.russiacube.config.Config;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cell {
	public static final int MAX_R = 20;
	public static final int MIN_R = 10;
	public static final float MAX_DR = 0.4f;
	public static final float MIN_DR = 0.1f;

	private int x, y;
	private float r;
	private int dx, dy;
	private float dr;
	private int color;
	private Paint paint;
	private LinkedList<Cell> cellsRoot;

	public Cell(LinkedList<Cell> cellList) {
		cellsRoot = cellList;
		color = Color.rgb(Common.genRand(0, 255), Common.genRand(0, 255),
				Common.genRand(0, 255));
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(color);
		r = Common.genRand(MIN_R, MAX_R);
		dr = Common.genRand(MIN_DR, MAX_DR);

		do {
			x = Common.genRand(0, Config.SCREEN_WIDTH);
			y = Common.genRand(0, Config.SCREEN_HEIGHT);
		} while (isHitOther(x, y, r));
		// x=Common.genRand(0, Config.SCREEN_WIDTH);
		// y=Common.genRand(0, Config.SCREEN_HEIGHT);

		cellsRoot.add(this);
	}

	private boolean isHitOther(int x, int y, float r) {
		for (int i = 0; i < cellsRoot.size(); i++) {
			Cell cell = cellsRoot.get(i);
			if (Common.isBallHit(x, y, r, cell.x, cell.y, cell.r)) {
				return true;
			}
		}// end for
		return false;
	}

	public void draw(Canvas canvas) {
		canvas.drawCircle(x, y, r, paint);
	}

	public void logic() {
		// x+=dx;
		// y+=dy;

		r += dr;
		if (r >= 21 || r <= 10) {
			dr *= -1;
		}

		dx = Common.genRand(-2, 3);
		dy = Common.genRand(-2, 3);
		if (x <= 0 || x >= Config.SCREEN_WIDTH) {
			x += dx;
		}

		if (y <= 0 || y >= Config.SCREEN_HEIGHT) {
			y += dy;
		}
	}
}// end class
