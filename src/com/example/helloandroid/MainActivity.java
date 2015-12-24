package com.example.helloandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint({ "NewApi", "ClickableViewAccessibility" })
public class MainActivity extends Activity implements View.OnTouchListener,
		OnClickListener {

	private TextView tv;

	private View selected_item = null;
	int topY, leftX, rightX, bottomY;
	int eX, eY;
	private int offset_x = 0;
	private int offset_y = 0;

	public static Compiler compiler;
	public static Assembler assembler;
	public static Fortran fortran;
	public static Algol60 algol60;
	public static Algol68 algol68;
	public static BCPL bcpl;
	public static C c;
	public static Linux linux;
	public static Java java;
	public static ByteCode bytecode;
	public static Kostil kostil;
	public static Windows windows;
	

	// public static ArrayList<Element> elements = new ArrayList<>();
	Button btn;
	public static Object obj;
	public static RelativeLayout mainLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		obj = this;
		mainLayout = (RelativeLayout) findViewById(R.id.main);
		tv = (TextView) findViewById(R.id.tv);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);

		initializeElements();

		// RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.main);
		// fire = new Fire(this);
		// air = new Air(this);

		// elements.add(fire);
		// elements.add(air);
		View root = findViewById(android.R.id.content).getRootView();

		root.setOnTouchListener(new View.OnTouchListener() {
			@SuppressWarnings("deprecation")
			public boolean onTouch(View v, MotionEvent event) {
				if (selected_item == null) {
					return false;
				}
				switch (event.getActionMasked()) {
				case MotionEvent.ACTION_DOWN:

					topY = selected_item.getTop();
					leftX = selected_item.getLeft();
					rightX = selected_item.getRight();
					bottomY = selected_item.getBottom();
					break;
				case MotionEvent.ACTION_MOVE:
					eX = (int) event.getX();
					eY = (int) event.getY();
					int x = (int) event.getX() - offset_x;
					int y = (int) event.getY() - offset_y;
					int w = getWindowManager().getDefaultDisplay().getWidth() - 50;
					int h = getWindowManager().getDefaultDisplay().getHeight() - 10;
					if (x > w)
						x = w;
					if (y > h)
						y = h;
					RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
							new ViewGroup.MarginLayoutParams(
									RelativeLayout.LayoutParams.WRAP_CONTENT,
									RelativeLayout.LayoutParams.WRAP_CONTENT));
					lp.setMargins(x, y - 100, 0, 0);
					selected_item.setLayoutParams(lp);
					selected_item.bringToFront();
					break;
				case MotionEvent.ACTION_UP:
					tv.setText("bottom test: " + selected_item.getBottom());
					checkIntersections();

					break;
				default:
					break;
				}

				return true;
			}
		});

	}

	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:

			offset_x = (int) event.getX();
			offset_y = (int) event.getY();
			selected_item = v;

			break;
		case MotionEvent.ACTION_UP:

			selected_item = null;

			break;
		default:
			break;
		}
		return false;
	}

	public void initializeElements() {
		RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.main);

		assembler = new Assembler(this);
		compiler = new Compiler(this);

		myLayout.addView(assembler, 1);
		myLayout.addView(compiler, 2);

		assembler.setOnTouchListener(this);
		compiler.setOnTouchListener(this);//

	}

	public void checkIntersections() {
		RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.main);
		
		fortran = (Fortran) elementCreator(assembler,compiler,fortran,"fortran");
		//algol60 = (Algol60) elementCreator(fortran,assembler,algol60,"algol60");
		//algol68 = (Algol68) elementCreator(fortran,algol60,algol68,"algol68");
		
		if (assembler.intersect(compiler)) {
			tv.setText("intersections");
			LayoutParams lparams = assembler.getLayoutParams();
			fortran = new Fortran(this);
			fortran.setLayoutParams(lparams);
			fortran.setOnTouchListener(this);
			fortran.setFound(true);
			myLayout.addView(fortran);

			myLayout.removeView(assembler);
			myLayout.removeView(compiler);
		}

		if (fortran != null && fortran.intersect(assembler)) {
			tv.setText("intersections");
			LayoutParams lparams = fortran.getLayoutParams();
			algol60 = new Algol60(this);
			algol60.setLayoutParams(lparams);
			algol60.setOnTouchListener(this);
			algol60.setFound(true);
			myLayout.addView(algol60);

			myLayout.removeView(assembler);
			myLayout.removeView(fortran);
		}
		if (fortran != null && algol60 != null && fortran.intersect(algol60)) {
			tv.setText("intersections");
			LayoutParams lparams = fortran.getLayoutParams();
			algol68 = new Algol68(this);
			algol68.setLayoutParams(lparams);
			algol68.setOnTouchListener(this);
			algol68.setFound(true);
			myLayout.addView(algol68);

			myLayout.removeView(algol60);
			myLayout.removeView(fortran);
		}
		if (algol68 != null  && algol68.intersect(assembler)) {
			tv.setText("intersections");
			LayoutParams lparams = algol68.getLayoutParams();
			bcpl = new BCPL(this);
			bcpl.setLayoutParams(lparams);
			bcpl.setOnTouchListener(this);
			bcpl.setFound(true);
			myLayout.addView(bcpl);

			myLayout.removeView(algol68);
			myLayout.removeView(assembler);
		}
		if (bcpl != null  && fortran!= null && bcpl.intersect(fortran)) {
			tv.setText("intersections");
			LayoutParams lparams = fortran.getLayoutParams();
			c = new C(this);
			c.setLayoutParams(lparams);
			c.setOnTouchListener(this);
			c.setFound(true);
			myLayout.addView(c);

			myLayout.removeView(bcpl);
			myLayout.removeView(fortran);
		}
		
		if (c != null  && compiler!= null && c.intersect(compiler)) {
			tv.setText("intersections");
			LayoutParams lparams = fortran.getLayoutParams();
			linux = new Linux(this);
			java = new Java(this);
			linux.setLayoutParams(lparams);
			java.setLayoutParams(lparams);
			
			linux.setOnTouchListener(this);
			java.setOnTouchListener(this);
			
			linux.setFound(true);
			java.setFound(true);
			
			myLayout.addView(linux);
			myLayout.addView(java);

			myLayout.removeView(c);
			myLayout.removeView(compiler);
		}
		if (java != null  && compiler!= null && java.intersect(compiler)) {
			tv.setText("intersections");
			LayoutParams lparams = java.getLayoutParams();
			bytecode = new ByteCode(this);
			bytecode.setLayoutParams(lparams);
			bytecode.setOnTouchListener(this);
			bytecode.setFound(true);
			myLayout.addView(bytecode);

			myLayout.removeView(java);
			myLayout.removeView(compiler);
		}
		if (bytecode != null  && compiler!= null && bytecode.intersect(compiler)) {
			tv.setText("intersections");
			LayoutParams lparams = java.getLayoutParams();
			kostil = new Kostil(this);
			kostil.setLayoutParams(lparams);
			kostil.setOnTouchListener(this);
			kostil.setFound(true);
			myLayout.addView(kostil);

			myLayout.removeView(bytecode);
			myLayout.removeView(compiler);
		}
		if (kostil != null  && c!= null && kostil.intersect(c)) {
			tv.setText("intersections");
			LayoutParams lparams = java.getLayoutParams();
			windows = new Windows(this);
			windows.setLayoutParams(lparams);
			windows.setOnTouchListener(this);
			windows.setFound(true);
			myLayout.addView(windows);

			myLayout.removeView(kostil);
			myLayout.removeView(c);
		}
		
	}

	public static void addElement(Element e) {
		mainLayout.removeView((View) e);
		mainLayout.addView((View) e);
	}
	
	public Element elementCreator(Element e1, Element e2, Element e3, String s){
		RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.main);
		if (e1 != null && e2 != null && e1.intersect(e2)) {
			tv.setText("intersections");
			//e3.getClass();
			LayoutParams lparams = ((View) e1).getLayoutParams();
			e3 =  ElementHelper.elementFactory(s,this);
			((View) e3).setLayoutParams(lparams);
			((View) e3).setOnTouchListener(this);
			((Fortran) e3).setFound(true);
			myLayout.addView((View) e3);

			myLayout.removeView((View) e1);
			myLayout.removeView((View) e2);
			return e3;
		}
		return null;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ElementActivity.class);
		startActivity(intent);
	}
}
