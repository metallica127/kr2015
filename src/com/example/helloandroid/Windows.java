package com.example.helloandroid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;

public class Windows extends TextView implements Element {

	private Rect rect;
	private boolean found;

	// private ElementHelper elh;

	public Windows(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setText("Windows");
		this.setTextColor(Color.rgb(255, 51, 123));

	}

	@Override
	public boolean intersect(Element e) {
		if (!this.isShown() || !((View) e).isShown()) {
			return false;
		}
		if (this.getRect().intersect(e.getRect())) {
			return true;
		} else
			return false;
	}

	@Override
	public Rect getRect() {
		rect = new Rect(this.getLeft(), this.getTop(), this.getRight(),
				this.getBottom());
		return rect;
	}

	@Override
	public boolean isFound() {
		// TODO Auto-generated method stub
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

}
