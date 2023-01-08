package com.example.chinesedumz;

import java.util.ArrayList;
import java.util.List;

import android.widget.EditText;

public class Down {
	private EditText P1;
	private EditText P2;
	private EditText P3;
	private EditText P4;

	private List<EditText> row;
	
	public Down(EditText... downGroup) {
		if (downGroup.length != 4) {
			return;
		}

		this.P1 = downGroup[0];
		this.P2 = downGroup[1];
		this.P3 = downGroup[2];
		this.P4 = downGroup[3];

		this.row = new ArrayList<EditText>();
		for (EditText item : downGroup) {
			this.row.add(item);
		}

	}
	
	@Override
	public String toString() {
		if(this.row == null || this.row.isEmpty() ) {
			return "Please create a down group";
		}
		
		String row = "";
		for(EditText item : this.row) {
			row += item.getText().toString();
		}
		return row;
	}

	public EditText getP1() {
		return this.P1;
	}

	public EditText getP2() {
		return this.P2;
	}

	public EditText getP3() {
		return this.P3;
	}

	public EditText getP4() {
		return this.P4;
	}
	
	public List<EditText> getRow() {
		return this.row;
	}

}
