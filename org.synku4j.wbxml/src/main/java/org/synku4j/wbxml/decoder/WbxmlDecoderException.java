package org.synku4j.wbxml.decoder;

public class WbxmlDecoderException extends Exception {

	private static final long serialVersionUID = 1L;

	WbxmlDecoderException() {
	}

	WbxmlDecoderException(String message) {
		super(message);
	}

	WbxmlDecoderException(Throwable cause) {
		super(cause);
	}

	WbxmlDecoderException(String message, Throwable cause) {
		super(message, cause);
	}
}
