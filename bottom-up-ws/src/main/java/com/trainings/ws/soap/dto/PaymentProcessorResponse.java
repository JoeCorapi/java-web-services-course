package com.trainings.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class PaymentProcessorResponse {

	private boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
