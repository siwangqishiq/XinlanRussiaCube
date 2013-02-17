package com.xinlan.russiacube.config;

public class Config {
	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;
	
	public static int getPercentByHeight(float percent){
		return (int)(SCREEN_HEIGHT * percent);
	}
	
	public static int getPercentByWidth(float percent){
		return (int)(SCREEN_WIDTH* percent);
	}
}//end class
