package com.example.exit;

import android.app.Activity;
import android.os.Bundle;

public class TActivity extends Activity {

	private MyApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);

		app = (MyApplication) getApplication();

		app.addAt(this);

	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		if (app == null) {
			app = (MyApplication) getApplication();
		}
		app.remove(this);
	}

	protected void securityExit() {
		if (app == null) {
			app = (MyApplication) getApplication();
		}
		app.exit();
	}

}
