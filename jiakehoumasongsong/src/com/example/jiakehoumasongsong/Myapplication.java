package com.example.jiakehoumasongsong;

import android.app.Application;
import android.content.res.AssetManager;

public class Myapplication extends Application {
	static {
		System.loadLibrary("wuhahah");
	}

	public Myapplication() {
		super();
	}

	public void onCreate() {
		Myapplication.load(this, this.getAssets());
		super.onCreate();
	}

	private static native void load(Myapplication myapplication,
			AssetManager assets);

}