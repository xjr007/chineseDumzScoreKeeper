package com.example.chinesedumz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class WinnerSelector extends Activity {
	String[] winners;
	String userP1, userP2, userP3, userP4;
	Button btnP1, btnP2, btnP3, btnP4;

	private void getBundle() {
		Bundle bundle = this.getIntent().getExtras();
		userP1 = bundle.getString("P1");
		userP2 = bundle.getString("P2");
		userP3 = bundle.getString("P3");
		userP4 = bundle.getString("P4");
	}

	private void loadControls() {
		btnP1 = (Button) findViewById(R.id.btn_winner_p1);
		btnP2 = (Button) findViewById(R.id.btn_winner_p2);
		btnP3 = (Button) findViewById(R.id.btn_winner_p3);
		btnP4 = (Button) findViewById(R.id.btn_winner_p4);

		btnP1.setText(userP1);
		btnP2.setText(userP2);
		btnP3.setText(userP3);
		btnP4.setText(userP4);

		btnP1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				bundle.putString("WinnerID", "P1");
	            Intent intent = new Intent();
	            intent.putExtras(bundle);
	            setResult(RESULT_OK,intent);   
	            finish();
			}
		});
		
		btnP2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				bundle.putString("WinnerID", "P2");
	            Intent intent = new Intent();
	            intent.putExtras(bundle);
	            setResult(RESULT_OK,intent);   
	            finish();
			}
		});
		
		btnP3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				bundle.putString("WinnerID", "P3");
	            Intent intent = new Intent();
	            intent.putExtras(bundle);
	            setResult(RESULT_OK,intent);   
	            finish();
			}
		});
		
		btnP4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				bundle.putString("WinnerID", "P4");
	            Intent intent = new Intent();
	            intent.putExtras(bundle);
	            setResult(RESULT_OK,intent);   
	            finish();
			}
		});
		
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		android.view.WindowManager.LayoutParams params = getWindow().getAttributes();
		params.height = 400;
		params.width = 560;
		params.alpha = 1.0f;
		params.dimAmount = 0.5f;
		getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

		setContentView(R.layout.activity_winner_selector);

		getBundle();
		loadControls();

	}
}
