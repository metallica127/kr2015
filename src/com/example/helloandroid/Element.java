package com.example.helloandroid;

import android.graphics.Rect;

public interface Element {

	public boolean intersect(Element e);

	public Rect getRect();

	public boolean isFound();

}
