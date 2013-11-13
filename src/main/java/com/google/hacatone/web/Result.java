package com.google.hacatone.web;

import java.util.List;

public class Result {
	private List<?> list;
	
	public Result(List<?> list) {
		this.list=list;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	
}
