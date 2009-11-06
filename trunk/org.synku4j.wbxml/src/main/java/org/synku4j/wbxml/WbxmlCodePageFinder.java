package org.synku4j.wbxml;

public interface WbxmlCodePageFinder {
	WbxmlCodePageField find(int codePageIdx, int fieldId);
	
	WbxmlCodePageField find(int codePageIdx, String fieldName);
}
