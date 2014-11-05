package com.example.exit;

import android.os.Bundle;
import android.os.Process;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends TActivity implements OnClickListener {

	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO 自动生成的方法存根
		if (view == btn) {

			// Process.killProcess(Process.myPid());
			 startActivity(new Intent(this, SecondActivity.class));
			// System.exit(0);
//			ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//			manager.restartPackage(getPackageName());

		}

	}

}
