package com.example.chinesedumz;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreTable extends Activity {

	public static int row = 6;

	EditText P1_header;
	EditText P2_header;
	EditText P3_header;
	EditText P4_header;

	EditText[] headers;

	TextView txt_P1_total;
	TextView txt_P2_total;
	TextView txt_P3_total;
	TextView txt_P4_total;

	// List<EditText> totals;

	EditText[] editText_group_6;
	EditText[] editText_group_5;
	EditText[] editText_group_4;
	EditText[] editText_group_3;
	EditText[] editText_group_2;
	EditText[] editText_group_1;
	EditText[] editText_group_0;
	EditText[] editText_totals;

	EditText edt_p1_double6;
	EditText edt_p2_double6;
	EditText edt_p3_double6;
	EditText edt_p4_double6;

	EditText edt_p1_double5;
	EditText edt_p2_double5;
	EditText edt_p3_double5;
	EditText edt_p4_double5;

	EditText edt_p1_double4;
	EditText edt_p2_double4;
	EditText edt_p3_double4;
	EditText edt_p4_double4;

	EditText edt_p1_double3;
	EditText edt_p2_double3;
	EditText edt_p3_double3;
	EditText edt_p4_double3;

	EditText edt_p1_double2;
	EditText edt_p2_double2;
	EditText edt_p3_double2;
	EditText edt_p4_double2;

	EditText edt_p1_double1;
	EditText edt_p2_double1;
	EditText edt_p3_double1;
	EditText edt_p4_double1;

	EditText edt_p1_double0;
	EditText edt_p2_double0;
	EditText edt_p3_double0;
	EditText edt_p4_double0;

	EditText edt_p1_total;
	EditText edt_p2_total;
	EditText edt_p3_total;
	EditText edt_p4_total;

	private List<EditText> edit_all_text = new ArrayList<EditText>();

	public ScoreTable() {
		/*
		 * totals = new ArrayList<EditText>(); totals.add(edt_p1_total);
		 * totals.add(edt_p2_total); totals.add(edt_p3_total);
		 * totals.add(edt_p4_total);
		 */
	}

	public void resetRow(EditText[] editTextGroup) {
		for (int i = 0; i < editTextGroup.length; i++) {
			if (editTextGroup[i].getText().toString().equals("W")) {
				editTextGroup[i].getText().clear();
				editTextGroup[i].setText("0");
				editTextGroup[i].setEnabled(true);
			}

		}
	}

	public void insertWinner(String winnerId, EditText[] editTextGroup) {
		if (winnerId.equals("P1")) {
			resetRow(editTextGroup);
			editTextGroup[0].setText("W");
			editTextGroup[0].setEnabled(false);
		}
		if (winnerId.equals("P2")) {
			resetRow(editTextGroup);
			editTextGroup[1].setText("W");
			editTextGroup[1].setEnabled(false);
		}
		if (winnerId.equals("P3")) {
			resetRow(editTextGroup);
			editTextGroup[2].setText("W");
			editTextGroup[2].setEnabled(false);
		}
		if (winnerId.equals("P4")) {
			resetRow(editTextGroup);
			editTextGroup[3].setText("W");
			editTextGroup[3].setEnabled(false);
		}

	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		String winnerId;
		try {
			switch (requestCode) {
			case 69:
				if (resultCode == RESULT_OK) {
					Bundle bundle = data.getExtras();
					if (bundle != null) {
						winnerId = bundle.getString("WinnerID");
						switch (row) {
						case 6:
							insertWinner(winnerId, editText_group_6);
							break;
						case 5:
							insertWinner(winnerId, editText_group_5);
							break;
						case 4:
							insertWinner(winnerId, editText_group_4);
							break;
						case 3:
							insertWinner(winnerId, editText_group_3);
							break;
						case 2:
							insertWinner(winnerId, editText_group_2);
							break;
						case 1:
							insertWinner(winnerId, editText_group_1);
							break;
						case 0:
							insertWinner(winnerId, editText_group_0);
							break;
						}

					}
				}
				break;
			}
		} catch (

		Exception ex) {
			Log.i("Error: onActivityResult", "Error: onActivityResult - " + ex.getMessage());
		}
	}

	void checkTotals() {
		TextWatcher lowestTotalWatcher = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void afterTextChanged(Editable editable) {
				// code here
				// getLowest();
				getLowest();
			}
		};

		for (EditText editText : editText_totals) {
			editText.addTextChangedListener(lowestTotalWatcher);
		}

	}

	public void getLowest() {
		Integer min = 1;
		Integer value = 0;
		EditText minEdit = null;
		min = Integer.parseInt(editText_totals[0].getText().toString());
		minEdit = editText_totals[0];

		for (EditText editText : editText_totals) {
			value = Integer.parseInt(editText.getText().toString());

			// breaking near min ^^
			if (value < min) {
				min = value;
				minEdit = editText;
			}

			editText.setBackgroundColor(Color.parseColor("#ffffff"));// resetting?
																		// reseting?
																		// textbox
																		// background
		}

		minEdit.setBackgroundColor(Color.parseColor("#31b13c"));
	}

	private void getBundle() {
		Bundle bundle = new Bundle();
		bundle.putString("P1", P1_header.getText().toString());
		bundle.putString("P2", P2_header.getText().toString());
		bundle.putString("P3", P3_header.getText().toString());
		bundle.putString("P4", P4_header.getText().toString());

		Intent intent = new Intent(getApplicationContext(), WinnerSelector.class);
		intent.putExtras(bundle);
		startActivityForResult(intent, 69);
	}

	public void setCursor(EditText editText) {
		if (!editText.requestFocus()) {
			return;
		}

		editText.requestFocus();
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		int position = editText.length();
		Editable editableText = editText.getText();
		Selection.setSelection(editableText, position);

	}

	public void setEditTextFocus(EditText editText) {
		editText.requestFocus();
	}

	public void setRow(int row) {
		ScoreTable.row = row;
	}

	private boolean validateRow(EditText[] row1, EditText[] row2) {
		boolean enableGroup = false;

		for (EditText editText : row1) {

			if (TextUtils.isEmpty(editText.getText().toString())) {
				enableGroup = false;
				break;
			} else {
				enableGroup = true;
			}
		}

		if (enableGroup) {
			setEnableEditText(row2, true);
		}

		return enableGroup;
	}

	private void hideGrid(EditText[] excludedEditText) {
		RelativeLayout relative_grid_layout = (RelativeLayout) findViewById(R.id.relative_grid_layout);
		for (View view : relative_grid_layout.getTouchables()) {
			if (view instanceof EditText && view.getVisibility() == View.VISIBLE) {
				EditText editText = (EditText) view;
				edit_all_text.add(editText);

				editText.setEnabled(false);
				editText.setFocusable(false);
				editText.setFocusableInTouchMode(false);
				editText.setVisibility(View.GONE);

			}
		}

		for (EditText editText : excludedEditText) {
			editText.setVisibility(View.VISIBLE);
		}

	}

	public void setEnableEditText(EditText[] editTextGroup, boolean val) {
		if (val) {
			for (EditText editText : editTextGroup) {
				editText.setEnabled(val);
				editText.setFocusable(val);
				editText.setFocusableInTouchMode(val);
				editText.setVisibility(View.VISIBLE);
			}
		} else {
			for (EditText editText : editTextGroup) {
				editText.setEnabled(val);
				editText.setFocusable(val);
				editText.setFocusableInTouchMode(val);
			}
		}

	}

	public void disableWinners(EditText[]... editTextGroups) {
		for (int i = 0; i < editTextGroups.length; i++) {
			for (EditText editText : editTextGroups[i]) {
				if (editText.getText().toString().equals("W")) {
					editText.setEnabled(false);
				}
			}
		}
	}

	@Override
	public void onBackPressed() {
		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case DialogInterface.BUTTON_POSITIVE:
					finish();
					break;

				case DialogInterface.BUTTON_NEGATIVE:
					// No button clicked
					break;
				}
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
				.setNegativeButton("No", dialogClickListener).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		disableWinners(editText_group_6, editText_group_5, editText_group_4, editText_group_3, editText_group_2,
				editText_group_1, editText_group_0);
	}

	protected void onCreate(Bundle savedInstanceState) {
		// Screen Settings
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_table);

		P1_header = (EditText) findViewById(R.id.score_r1_c1);
		P2_header = (EditText) findViewById(R.id.score_r1_c2);
		P3_header = (EditText) findViewById(R.id.score_r1_c3);
		P4_header = (EditText) findViewById(R.id.score_r1_c4);

		EditText[] headers = { P1_header, P2_header, P3_header, P4_header };

		edt_p1_double6 = (EditText) findViewById(R.id.score_r2_c1);
		edt_p2_double6 = (EditText) findViewById(R.id.score_r2_c2);
		edt_p3_double6 = (EditText) findViewById(R.id.score_r2_c3);
		edt_p4_double6 = (EditText) findViewById(R.id.score_r2_c4);

		editText_group_6 = new EditText[] { edt_p1_double6, edt_p2_double6, edt_p3_double6, edt_p4_double6 };

		edt_p1_double5 = (EditText) findViewById(R.id.score_r3_c1);
		edt_p2_double5 = (EditText) findViewById(R.id.score_r3_c2);
		edt_p3_double5 = (EditText) findViewById(R.id.score_r3_c3);
		edt_p4_double5 = (EditText) findViewById(R.id.score_r3_c4);

		editText_group_5 = new EditText[] { edt_p1_double5, edt_p2_double5, edt_p3_double5, edt_p4_double5 };

		edt_p1_double4 = (EditText) findViewById(R.id.score_r4_c1);
		edt_p2_double4 = (EditText) findViewById(R.id.score_r4_c2);
		edt_p3_double4 = (EditText) findViewById(R.id.score_r4_c3);
		edt_p4_double4 = (EditText) findViewById(R.id.score_r4_c4);

		editText_group_4 = new EditText[] { edt_p1_double4, edt_p2_double4, edt_p3_double4, edt_p4_double4 };

		edt_p1_double3 = (EditText) findViewById(R.id.score_r5_c1);
		edt_p2_double3 = (EditText) findViewById(R.id.score_r5_c2);
		edt_p3_double3 = (EditText) findViewById(R.id.score_r5_c3);
		edt_p4_double3 = (EditText) findViewById(R.id.score_r5_c4);

		editText_group_3 = new EditText[] { edt_p1_double3, edt_p2_double3, edt_p3_double3, edt_p4_double3 };

		edt_p1_double2 = (EditText) findViewById(R.id.score_r6_c1);
		edt_p2_double2 = (EditText) findViewById(R.id.score_r6_c2);
		edt_p3_double2 = (EditText) findViewById(R.id.score_r6_c3);
		edt_p4_double2 = (EditText) findViewById(R.id.score_r6_c4);

		editText_group_2 = new EditText[] { edt_p1_double2, edt_p2_double2, edt_p3_double2, edt_p4_double2 };

		edt_p1_double1 = (EditText) findViewById(R.id.score_r7_c1);
		edt_p2_double1 = (EditText) findViewById(R.id.score_r7_c2);
		edt_p3_double1 = (EditText) findViewById(R.id.score_r7_c3);
		edt_p4_double1 = (EditText) findViewById(R.id.score_r7_c4);

		editText_group_1 = new EditText[] { edt_p1_double1, edt_p2_double1, edt_p3_double1, edt_p4_double1 };

		edt_p1_double0 = (EditText) findViewById(R.id.score_r8_c1);
		edt_p2_double0 = (EditText) findViewById(R.id.score_r8_c2);
		edt_p3_double0 = (EditText) findViewById(R.id.score_r8_c3);
		edt_p4_double0 = (EditText) findViewById(R.id.score_r8_c4);

		editText_group_0 = new EditText[] { edt_p1_double0, edt_p2_double0, edt_p3_double0, edt_p4_double0 };

		edt_p1_total = (EditText) findViewById(R.id.score_r9_c1);
		edt_p2_total = (EditText) findViewById(R.id.score_r9_c2);
		edt_p3_total = (EditText) findViewById(R.id.score_r9_c3);
		edt_p4_total = (EditText) findViewById(R.id.score_r9_c4);

		editText_totals = new EditText[] { edt_p1_total, edt_p2_total, edt_p3_total, edt_p4_total };

		EditText[][] editTextGroups = { editText_group_6, editText_group_5, editText_group_4, editText_group_3,
				editText_group_2, editText_group_1, editText_group_0 };

		hideGrid(headers);

		setEnableEditText(headers, true);

		for (EditText editText : editText_totals) {
			editText.setVisibility(View.VISIBLE);
		}

		Button btnReset = (Button) findViewById(R.id.btn_reset);
		btnReset.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case DialogInterface.BUTTON_POSITIVE:
							EditText[][] editTextGroups = { editText_group_6, editText_group_5, editText_group_4,
									editText_group_3, editText_group_2, editText_group_1, editText_group_0 };
							for (int i = 0; i < editTextGroups.length; i++) {
								for (EditText editText : editTextGroups[i]) {
									editText.setText("");
									editText.setEnabled(false);
									editText.setVisibility(View.GONE);
								}
							}

							for (EditText editText : editText_totals) {
								editText.setBackgroundColor(Color.parseColor("#ffffff"));
							}

							break;

						case DialogInterface.BUTTON_NEGATIVE:
							// No button clicked
							break;
						}
					}
				};

				AlertDialog.Builder builder = new AlertDialog.Builder(ScoreTable.this);
				builder.setMessage("Would you like to start a new game?").setPositiveButton("Yes", dialogClickListener)
						.setNegativeButton("No", dialogClickListener).show();

			}
		});
		// calling it here
		// getLowest();

		Button btnDouble6 = (Button) findViewById(R.id.btn_double_6);
		btnDouble6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				setRow(6);
				getBundle();

				setEnableEditText(editText_group_6, true);
			}
		});

		Button btnDouble5 = (Button) findViewById(R.id.btn_double_5);
		btnDouble5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				setRow(5);

				if (validateRow(editText_group_6, editText_group_5)) {
					getBundle();
				}

			}
		});

		Button btnDouble4 = (Button) findViewById(R.id.btn_double_4);
		btnDouble4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				setRow(4);

				if (validateRow(editText_group_5, editText_group_4)) {
					getBundle();
				}
			}
		});

		Button btnDouble3 = (Button) findViewById(R.id.btn_double_3);
		btnDouble3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				setRow(3);

				if (validateRow(editText_group_4, editText_group_3)) {
					getBundle();
				}

			}
		});

		Button btnDouble2 = (Button) findViewById(R.id.btn_double_2);
		btnDouble2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

				setRow(2);

				if (validateRow(editText_group_3, editText_group_2)) {
					getBundle();
				}
			}
		});

		Button btnDouble1 = (Button) findViewById(R.id.btn_double_1);
		btnDouble1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				setRow(1);

				if (validateRow(editText_group_2, editText_group_1)) {
					getBundle();
				}
			}
		});

		Button btnDouble0 = (Button) findViewById(R.id.btn_double_0);
		btnDouble0.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				setRow(0);

				if (validateRow(editText_group_1, editText_group_0)) {
					getBundle();
				}
			}
		});

		// Calculate totals
		// P1

		txt_P1_total = (TextView) findViewById(R.id.score_r9_c1);
		TextWatcher totalWatcher_P1 = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				try {
					int total = 0, score6 = 0, score5 = 0, score4 = 0, score3 = 0, score2 = 0, score1 = 0, score0 = 0;

					if (edt_p1_double6.getText().toString().equals("W")) {
						score6 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double6.getText().toString().trim())) {
						score6 = Integer.parseInt(edt_p1_double6.getText().toString());
					}

					if (edt_p1_double5.getText().toString().equals("W")) {
						score5 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double5.getText().toString().trim()))
						score5 = Integer.parseInt(edt_p1_double5.getText().toString());

					if (edt_p1_double4.getText().toString().equals("W")) {
						score4 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double4.getText().toString().trim()))
						score4 = Integer.parseInt(edt_p1_double4.getText().toString());

					if (edt_p1_double3.getText().toString().equals("W")) {
						score3 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double3.getText().toString().trim()))
						score3 = Integer.parseInt(edt_p1_double3.getText().toString());

					if (edt_p1_double2.getText().toString().equals("W")) {
						score2 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double2.getText().toString().trim()))
						score2 = Integer.parseInt(edt_p1_double2.getText().toString());

					if (edt_p1_double1.getText().toString().equals("W")) {
						score1 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double1.getText().toString().trim()))
						score1 = Integer.parseInt(edt_p1_double1.getText().toString());

					if (edt_p1_double0.getText().toString().equals("W")) {
						score0 = 0;
					} else if (!TextUtils.isEmpty(edt_p1_double0.getText().toString().trim()))
						score0 = Integer.parseInt(edt_p1_double0.getText().toString());

					total = score6 + score5 + score4 + score3 + score2 + score1 + score0;

					txt_P1_total.setText(String.valueOf(total));
				} catch (Exception ex) {
					Log.i("error1", ex.getMessage());
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		};

		edt_p1_double6.addTextChangedListener(totalWatcher_P1);
		edt_p1_double5.addTextChangedListener(totalWatcher_P1);
		edt_p1_double4.addTextChangedListener(totalWatcher_P1);
		edt_p1_double3.addTextChangedListener(totalWatcher_P1);
		edt_p1_double2.addTextChangedListener(totalWatcher_P1);
		edt_p1_double1.addTextChangedListener(totalWatcher_P1);
		edt_p1_double0.addTextChangedListener(totalWatcher_P1);

		// Calculate totals
		// P2

		txt_P2_total = (TextView) findViewById(R.id.score_r9_c2);
		TextWatcher totalWatcher_P2 = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				try {
					int total = 0, score6 = 0, score5 = 0, score4 = 0, score3 = 0, score2 = 0, score1 = 0, score0 = 0;

					if (edt_p2_double6.getText().toString().equals("W")) {
						score6 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double6.getText().toString().trim())) {
						score6 = Integer.parseInt(edt_p2_double6.getText().toString());
					}

					if (edt_p2_double5.getText().toString().equals("W")) {
						score5 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double5.getText().toString().trim()))
						score5 = Integer.parseInt(edt_p2_double5.getText().toString());

					if (edt_p2_double4.getText().toString().equals("W")) {
						score4 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double4.getText().toString().trim()))
						score4 = Integer.parseInt(edt_p2_double4.getText().toString());

					if (edt_p2_double3.getText().toString().equals("W")) {
						score3 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double3.getText().toString().trim()))
						score3 = Integer.parseInt(edt_p2_double3.getText().toString());

					if (edt_p2_double2.getText().toString().equals("W")) {
						score2 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double2.getText().toString().trim()))
						score2 = Integer.parseInt(edt_p2_double2.getText().toString());

					if (edt_p2_double1.getText().toString().equals("W")) {
						score1 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double1.getText().toString().trim()))
						score1 = Integer.parseInt(edt_p2_double1.getText().toString());

					if (edt_p2_double0.getText().toString().equals("W")) {
						score0 = 0;
					} else if (!TextUtils.isEmpty(edt_p2_double0.getText().toString().trim()))
						score0 = Integer.parseInt(edt_p2_double0.getText().toString());

					total = score6 + score5 + score4 + score3 + score2 + score1 + score0;

					txt_P2_total.setText(String.valueOf(total));
				} catch (Exception ex) {
					Log.i("error1", ex.getMessage());
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		};

		edt_p2_double6.addTextChangedListener(totalWatcher_P2);
		edt_p2_double5.addTextChangedListener(totalWatcher_P2);
		edt_p2_double4.addTextChangedListener(totalWatcher_P2);
		edt_p2_double3.addTextChangedListener(totalWatcher_P2);
		edt_p2_double2.addTextChangedListener(totalWatcher_P2);
		edt_p2_double1.addTextChangedListener(totalWatcher_P2);
		edt_p2_double0.addTextChangedListener(totalWatcher_P2);

		// Calculate totals
		// P3

		txt_P3_total = (TextView) findViewById(R.id.score_r9_c3);
		TextWatcher totalWatcher_P3 = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				try {
					int total = 0, score6 = 0, score5 = 0, score4 = 0, score3 = 0, score2 = 0, score1 = 0, score0 = 0;

					if (edt_p3_double6.getText().toString().equals("W")) {
						score6 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double6.getText().toString().trim())) {
						score6 = Integer.parseInt(edt_p3_double6.getText().toString());
					}

					if (edt_p3_double5.getText().toString().equals("W")) {
						score5 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double5.getText().toString().trim()))
						score5 = Integer.parseInt(edt_p3_double5.getText().toString());

					if (edt_p3_double4.getText().toString().equals("W")) {
						score4 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double4.getText().toString().trim()))
						score4 = Integer.parseInt(edt_p3_double4.getText().toString());

					if (edt_p3_double3.getText().toString().equals("W")) {
						score3 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double3.getText().toString().trim()))
						score3 = Integer.parseInt(edt_p3_double3.getText().toString());

					if (edt_p3_double2.getText().toString().equals("W")) {
						score2 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double2.getText().toString().trim()))
						score2 = Integer.parseInt(edt_p3_double2.getText().toString());

					if (edt_p3_double1.getText().toString().equals("W")) {
						score1 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double1.getText().toString().trim()))
						score1 = Integer.parseInt(edt_p3_double1.getText().toString());

					if (edt_p3_double0.getText().toString().equals("W")) {
						score0 = 0;
					} else if (!TextUtils.isEmpty(edt_p3_double0.getText().toString().trim()))
						score0 = Integer.parseInt(edt_p3_double0.getText().toString());

					total = score6 + score5 + score4 + score3 + score2 + score1 + score0;

					txt_P3_total.setText(String.valueOf(total));
				} catch (Exception ex) {
					Log.i("error1", ex.getMessage());
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		};

		edt_p3_double6.addTextChangedListener(totalWatcher_P3);
		edt_p3_double5.addTextChangedListener(totalWatcher_P3);
		edt_p3_double4.addTextChangedListener(totalWatcher_P3);
		edt_p3_double3.addTextChangedListener(totalWatcher_P3);
		edt_p3_double2.addTextChangedListener(totalWatcher_P3);
		edt_p3_double1.addTextChangedListener(totalWatcher_P3);
		edt_p3_double0.addTextChangedListener(totalWatcher_P3);

		// Calculate totals
		// P4

		txt_P4_total = (TextView) findViewById(R.id.score_r9_c4);
		TextWatcher totalWatcher_P4 = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				try {
					int total = 0, score6 = 0, score5 = 0, score4 = 0, score3 = 0, score2 = 0, score1 = 0, score0 = 0;

					if (edt_p4_double6.getText().toString().equals("W")) {
						score6 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double6.getText().toString().trim())) {
						score6 = Integer.parseInt(edt_p4_double6.getText().toString());
					}

					if (edt_p4_double5.getText().toString().equals("W")) {
						score5 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double5.getText().toString().trim()))
						score5 = Integer.parseInt(edt_p4_double5.getText().toString());

					if (edt_p4_double4.getText().toString().equals("W")) {
						score4 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double4.getText().toString().trim()))
						score4 = Integer.parseInt(edt_p4_double4.getText().toString());

					if (edt_p4_double3.getText().toString().equals("W")) {
						score3 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double3.getText().toString().trim()))
						score3 = Integer.parseInt(edt_p4_double3.getText().toString());

					if (edt_p4_double2.getText().toString().equals("W")) {
						score2 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double2.getText().toString().trim()))
						score2 = Integer.parseInt(edt_p4_double2.getText().toString());

					if (edt_p4_double1.getText().toString().equals("W")) {
						score1 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double1.getText().toString().trim()))
						score1 = Integer.parseInt(edt_p4_double1.getText().toString());

					if (edt_p4_double0.getText().toString().equals("W")) {
						score0 = 0;
					} else if (!TextUtils.isEmpty(edt_p4_double0.getText().toString().trim()))
						score0 = Integer.parseInt(edt_p4_double0.getText().toString());

					total = score6 + score5 + score4 + score3 + score2 + score1 + score0;

					txt_P4_total.setText(String.valueOf(total));
				} catch (Exception ex) {
					Log.i("error1", ex.getMessage());
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		};

		edt_p4_double6.addTextChangedListener(totalWatcher_P4);
		edt_p4_double5.addTextChangedListener(totalWatcher_P4);
		edt_p4_double4.addTextChangedListener(totalWatcher_P4);
		edt_p4_double3.addTextChangedListener(totalWatcher_P4);
		edt_p4_double2.addTextChangedListener(totalWatcher_P4);
		edt_p4_double1.addTextChangedListener(totalWatcher_P4);
		edt_p4_double0.addTextChangedListener(totalWatcher_P4);

		checkTotals();
	}

}
