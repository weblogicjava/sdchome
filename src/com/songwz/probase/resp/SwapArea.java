package com.songwz.probase.resp;


public class SwapArea {

	private String errorCode ;
	
	private String errorMsg ; 
	
	private String nextMove ;
	
	private Object msgpack ; 
	
	public static SwapArea createSwapArea(){
		return new SwapArea() ;
	}
	
	public Object getMsgpack() {
		return msgpack;
	}

	public SwapArea setMsgpack(Object msgpack) {
		this.msgpack = msgpack;
		return this ;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public SwapArea setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this ;
	}
	
	public SwapArea setSuccessCode() {
		this.errorCode = "SUCCESS";
		return this ;
	}
	
	public SwapArea setFailCode() {
		this.errorCode = "FAIL";
		return this ;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public SwapArea setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this ;
	}

	public String getNextMove() {
		return nextMove;
	}

	public SwapArea setNextMove(String nextMove) {
		this.nextMove = nextMove;
		return this ;
	}
	
	
	
}
