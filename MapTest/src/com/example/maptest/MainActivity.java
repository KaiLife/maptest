package com.example.maptest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.maptest.MarkObject.MarkClickListener;
import com.example.opengltest.R;

public class MainActivity extends Activity {

	private MyMap sceneMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sceneMap = (MyMap) findViewById(R.id.sceneMap);
		Bitmap b = BitmapFactory
				.decodeResource(getResources(), R.drawable.test);
		sceneMap.setBitmap(b);
		
		MarkObject markObject = new MarkObject();
		markObject.setMapX(0.34f);
		markObject.setMapY(0.5f);
		markObject.setmBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.icon_marka));
		markObject.setMarkListener(new MarkClickListener() {

			@Override
			public void onMarkClick(int x, int y) {
				Toast.makeText(MainActivity.this, "点击覆盖物", Toast.LENGTH_SHORT)
						.show();
			}
		});
		sceneMap.addMark(markObject);
		
		findViewById(R.id.button_in).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sceneMap.zoomIn();
			}
		});

		findViewById(R.id.button_out).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sceneMap.zoomOut();
			}
		});		
	}
}
