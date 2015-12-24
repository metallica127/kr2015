package com.example.helloandroid;

import android.app.Activity;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ElementActivity extends Activity implements OnClickListener {
	public static TextView assembler;
	public static TextView compiler;
	public static TextView fortran;
	public static TextView algol60;
	public static TextView algol68;
	public static TextView bcpl;
	public static TextView c;
	public static TextView linux;
	public static TextView java;
	public static TextView bytecode;
	public static TextView kostil;
	public static TextView windows;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablelayout);

		assembler = (TextView) findViewById(R.id.assembler);
		compiler = (TextView) findViewById(R.id.compiler);
		fortran = (TextView) findViewById(R.id.fortran);
		algol60 = (TextView) findViewById(R.id.algol60);
		algol68 = (TextView) findViewById(R.id.algol68);
		bcpl = (TextView) findViewById(R.id.bcpl);
		c = (TextView) findViewById(R.id.c);
		linux = (TextView) findViewById(R.id.linux);
		java = (TextView) findViewById(R.id.java);
		bytecode = (TextView) findViewById(R.id.bytecode);
		kostil = (TextView) findViewById(R.id.kostil);
		windows = (TextView) findViewById(R.id.windows);
		
		assembler.setText("assembler");
		assembler.setTextColor(Color.GREEN);
		compiler.setText("compiler");
		compiler.setTextColor(Color.GREEN);
		assembler.setOnClickListener(this);
		compiler.setOnClickListener(this);

		fortran.setText("locked");
		algol60.setText("locked");
		algol68.setText("locked");
		bcpl.setText("locked");
		c.setText("locked");
		linux.setText("locked");
		java.setText("locked");
		bytecode.setText("locked");
		kostil.setText("super locked");
		windows.setText("ultra locked");
		
		if (MainActivity.fortran != null && MainActivity.fortran.isFound()) {
			fortran.setText("fortran");
			fortran.setTextColor(Color.GREEN);
			fortran.setOnClickListener(this);
		}
		if (MainActivity.algol60 != null && MainActivity.algol60.isFound()) {
			algol60.setText("algol60");
			algol60.setTextColor(Color.GREEN);
			algol60.setOnClickListener(this);
		}
		if (MainActivity.algol68 != null && MainActivity.algol68.isFound()) {
			algol68.setText("algol68");
			algol68.setTextColor(Color.GREEN);
			algol68.setOnClickListener(this);
		}
		if (MainActivity.bcpl != null && MainActivity.bcpl.isFound()) {
			bcpl.setText("bcpl");
			bcpl.setTextColor(Color.GREEN);
			bcpl.setOnClickListener(this);
		}
		if (MainActivity.c != null && MainActivity.c.isFound()) {
			c.setText("C");
			c.setTextColor(Color.GREEN);
			c.setOnClickListener(this);
		}
		if (MainActivity.linux != null && MainActivity.linux.isFound()) {
			linux.setText("linux");
			linux.setTextColor(Color.GREEN);
			linux.setOnClickListener(this);
		}
		if (MainActivity.java != null && MainActivity.java.isFound()) {
			java.setText("java");
			java.setTextColor(Color.GREEN);
			java.setOnClickListener(this);
		}
		if (MainActivity.bytecode != null && MainActivity.bytecode.isFound()) {
			bytecode.setText("bytecode");
			bytecode.setTextColor(Color.GREEN);
			bytecode.setOnClickListener(this);
		}
		if (MainActivity.kostil != null && MainActivity.kostil.isFound()) {
			kostil.setText("kostil");
			kostil.setTextColor(Color.GREEN);
			kostil.setOnClickListener(this);
		}
		if (MainActivity.windows != null && MainActivity.windows.isFound()) {
			windows.setText("windows");
			windows.setTextColor(Color.GREEN);
			windows.setOnClickListener(this);
		}
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == fortran) {
			MainActivity.addElement(MainActivity.fortran);
			finish();
		}
		if (v == compiler) {
			MainActivity.addElement(MainActivity.compiler);
			finish();
		}
		if (v == assembler) {
			MainActivity.addElement(MainActivity.assembler);
			finish();
		}
		if (v==algol60){
			MainActivity.addElement(MainActivity.algol60);
			finish();
		}
		if (v==algol68){
			MainActivity.addElement(MainActivity.algol68);
			finish();
		}
		if (v==bcpl){
			MainActivity.addElement(MainActivity.bcpl);
			finish();
		}
		if (v==c){
			MainActivity.addElement(MainActivity.c);
			finish();
		}
		if(v==linux){
			MainActivity.addElement(MainActivity.linux);
			finish();
		}
		if(v==java){
			MainActivity.addElement(MainActivity.java);
			finish();
		}
		if(v==bytecode){
			MainActivity.addElement(MainActivity.bytecode);
			finish();
		}
		if(v==kostil){
			MainActivity.addElement(MainActivity.kostil);
			finish();
		}
		if(v==windows){
			MainActivity.addElement(MainActivity.windows);
			finish();
		}

	}



}
