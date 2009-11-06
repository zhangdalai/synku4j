package org.synku4j.wbxml.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.synku4j.wbxml.WbxmlCodePageField;
import org.synku4j.wbxml.annotation.WbxmlPage;

/**
 * The <code>WbxmlContext</code> class manages the state.
 * 
 * @author Jools Enticknap
 */
public class WbxmlContext {

	private int wbxmlVersion;
	private int wbxmlEncoding;
	
	/** Require that all strings are encoded as opqque values */
	private boolean opaqueStrings;
	
	private Stack<WbxmlCodePageField> elements = new Stack<WbxmlCodePageField>();
	private boolean captureXML;
	private StringBuilder xml;
	private Stack<WbxmlPage> codePages = new Stack<WbxmlPage>();
	private List<WbxmlCodePageField> codePageFields = new ArrayList<WbxmlCodePageField>();
	
	public WbxmlContext() {
	}
	
	public boolean captureXML() {
		return captureXML;
	}

	public StringBuilder getXml() {
		return xml;
	}

	public Stack<WbxmlCodePageField> getElements() {
		return null;
	}

	public void reset() {
		elements.clear();
		codePages.clear();
		if (captureXML) {
			xml = new StringBuilder();
		}
	}

	public void pushCodePage(WbxmlPage page) {
		codePages.push(page);
	}
	
	public WbxmlPage popCodePage() {
		return codePages.pop();
	}

	public WbxmlPage peekCodePage() {
		if (codePages.isEmpty()) {
			return null;
		}
		return codePages.peek();
	}

	public void setCaptureXML(boolean capture) {
		captureXML = capture;
	}

	public Class<?> classFor(WbxmlCodePageField cp) {
		return null;
	}

	public void addCodePageFields(WbxmlCodePageField[] fields) {
		codePageFields.addAll(Arrays.asList(fields));
	}

	public List<WbxmlCodePageField> getCodePageFields() {
		return codePageFields;
	}

	public int getWbxmlVersion() {
		return wbxmlVersion;
	}

	public void setWbxmlVersion(int wbxmlVersion) {
		this.wbxmlVersion = wbxmlVersion;
	}

	public int getWbxmlEncoding() {
		return wbxmlEncoding;
	}

	public void setWbxmlEncoding(int wbxmlEncoding) {
		this.wbxmlEncoding = wbxmlEncoding;
	}

	public boolean isOpaqueStrings() {
		return opaqueStrings;
	}

	public void setOpaqueStrings(boolean opaqueStrings) {
		this.opaqueStrings = opaqueStrings;
	}
}
