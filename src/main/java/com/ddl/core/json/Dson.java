package com.ddl.core.json;

import java.util.HashMap;

public class Dson extends HashMap<String, Object> {

	private static final long serialVersionUID = -144464705205896803L;

	public void setCode(int code) {
		super.put("code", code);
	}

	public void setMsg(String msg) {
		super.put("msg", msg);
	}

	public void setData(Object data) {
		super.put("data", data);
	}
}
