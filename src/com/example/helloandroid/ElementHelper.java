package com.example.helloandroid;

import android.content.Context;

public class ElementHelper{
	public static Element elementFactory(String s, Context context){
		if (s.equals("fortran")){
			return new Fortran(context);
		}
		if (s.equals("algol60")){
			return new Algol60(context);
		}
		if (s.equals("algol68")){
			return new Algol68(context);
		}
		return null;
	}
	
}
