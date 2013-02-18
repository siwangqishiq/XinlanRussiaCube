package com.xinlan.russiacube.role;

import java.util.LinkedList;

import android.graphics.Canvas;

public class CellGroup {
	public static final int CELL_NUM_MAX=50;
	
	private LinkedList<Cell> cellGroup;

	public CellGroup() {
		cellGroup = new LinkedList<Cell>();
		genCells();
	}

	private void genCells() {
		for (int i = 0; i < CELL_NUM_MAX; i++) {
			new Cell(cellGroup);
		}
	}

	public void draw(Canvas canvas) {
		for (int i = 0; i < cellGroup.size(); i++) {
			cellGroup.get(i).draw(canvas);
		}// end for i
	}

	public void logic() {
		for (int i = 0; i < cellGroup.size(); i++) {
			cellGroup.get(i).logic();
		}// end for i
	}
}// end class
