package edu.centennial.college.sws_410;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
	}

    public void updateProfile(View view) {
    	
    	startActivity( new Intent(MainPage.this, UpdateProfile.class) );
    }
}
