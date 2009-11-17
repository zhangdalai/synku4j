package org.synku4j.wbxml.core.impl;

import org.synku4j.wbxml.core.WbxmlCodePage;
import org.synku4j.wbxml.core.WbxmlCodePageField;

public class DefaultWbxmlCodePage implements WbxmlCodePage {
	
	private final String formalPublicId;
	private final int publicId;
	private final int index;
	private final WbxmlCodePageField[] fields;

	public DefaultWbxmlCodePage(String formalPublicId, int publicId, int index, WbxmlCodePageField[] fields) {
		this.formalPublicId = formalPublicId;
		this.publicId = publicId;
		this.index = index;
		this.fields = fields;
	}

	@Override
	public WbxmlCodePageField[] getFields() {
		return fields;
	}

	@Override
	public String getFormalPublicID() {
		return formalPublicId;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public int getPublicID() {
		return publicId;
	}

}
