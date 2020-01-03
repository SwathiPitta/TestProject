package com.registration.response;

import org.springframework.stereotype.Component;

@Component
public class RegResponse {
	private ErrorResponse error;
	private RegResult result;
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public RegResult getResult() {
		return result;
	}
	public void setResult(RegResult result) {
		this.result = result;
	}
}
