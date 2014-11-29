package com.wf.exception;

public class DaoException extends Exception{

	public DaoException(String string, Exception e) {
		e.printStackTrace();
	}

	public DaoException(String string) {
		System.out.println(string);
	}

}
