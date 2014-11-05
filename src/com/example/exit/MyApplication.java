package com.example.exit;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {

	private List<Activity> ats = new ArrayList<Activity>();

	public void addAt(Activity at) {
		ats.add(at);
	}

	public void remove(Activity at) {

		ats.remove(at);
	}

	public boolean exit() {
		for (Activity at : ats) {
			at.finish();
		}
		return true;
	}

}
