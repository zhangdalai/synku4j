package org.synku4j.wbxml.decoder;

import java.util.HashMap;
import java.util.Map;

import org.synku4j.wbxml.WbxmlCodePageField;
import org.synku4j.wbxml.WbxmlCodePageFinder;

public abstract class AbstractCodePageFinder implements WbxmlCodePageFinder {
	
	private Map<Integer, Map<Integer, WbxmlCodePageField>> codepageById = new HashMap<Integer, Map<Integer, WbxmlCodePageField>>();
	private Map<Integer, Map<String, WbxmlCodePageField>> codepageByName = new HashMap<Integer, Map<String, WbxmlCodePageField>>();

	protected AbstractCodePageFinder() {
	}

	@Override
	public WbxmlCodePageField find(int codePageIdx, int fieldId) {
		final Map<Integer, WbxmlCodePageField> m = codepageById.get(codePageIdx);
		if (m == null) {
			return null;
		}

		return m.get(fieldId);
	}
	
	@Override
	public WbxmlCodePageField find(int codePageIdx, String fieldName) {
		Map<String, WbxmlCodePageField> m = codepageByName.get(codePageIdx);
		if (m == null) {
			return null;
		}

		return m.get(fieldName);
	}
	
	protected void populate(int codePageIdx, WbxmlCodePageField[] fields) {
		final Map<Integer, WbxmlCodePageField> fieldMapId = new HashMap<Integer, WbxmlCodePageField>();
		final Map<String, WbxmlCodePageField> fieldMapName = new HashMap<String, WbxmlCodePageField>();

		for (WbxmlCodePageField field : fields) {
			fieldMapId.put(field.getToken(), field);
			fieldMapName.put(field.getFieldName(), field);
		}

		codepageById.put(codePageIdx, fieldMapId);
		codepageByName.put(codePageIdx, fieldMapName);
	}
}
