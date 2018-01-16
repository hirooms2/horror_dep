package com.horrornumber1.horrordepartment.DataModel;

import java.util.ArrayList;
import java.util.List;

public class Youtube_Box {
	List<Youtube_con> con_box = new ArrayList<>();
	List<Youtube_key> key_box = new ArrayList<>();

	public List<Youtube_con> getCon_box() {
		return con_box;
	}

	public void setCon_box(List<Youtube_con> con_box) {
		this.con_box = con_box;
	}

	public List<Youtube_key> getKey_box() {
		return key_box;
	}

	public void setKey_box(List<Youtube_key> key_box) {
		this.key_box = key_box;
	}

}
