package com.example.helloandroid;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
public class Game extends Activity
{
 @Override
 public void onCreate(Bundle savedInstanceState)
 {
 super.onCreate(savedInstanceState);
 setContentView(new DrawView(this));
 }

 class DrawView extends View {

   public DrawView(Context context) {
     super(context);
   }
   
   @Override
   protected void onDraw(Canvas canvas) {
     canvas.drawColor(Color.GREEN);
   }
   
 }
 
}
 
