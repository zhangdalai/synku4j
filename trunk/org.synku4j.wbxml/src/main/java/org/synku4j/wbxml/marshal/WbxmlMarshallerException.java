package org.synku4j.wbxml.marshal;

public class WbxmlMarshallerException extends Exception {

	private static final long serialVersionUID = 1L;

	public WbxmlMarshallerException() {
	}

	public WbxmlMarshallerException(String message) {
		super(message);
	}

	public WbxmlMarshallerException(Throwable cause) {
		super(cause);
	}

	public WbxmlMarshallerException(String message, Throwable cause) {
		super(message, cause);
	}
}
