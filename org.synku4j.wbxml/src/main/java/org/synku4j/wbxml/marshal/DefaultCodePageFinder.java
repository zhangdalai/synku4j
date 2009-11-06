package org.synku4j.wbxml.marshal;

import java.util.ArrayList;
import java.util.List;

import org.synku4j.wbxml.WbxmlCodePage;
import org.synku4j.wbxml.WbxmlCodePageField;
import org.synku4j.wbxml.WbxmlCodePageFinder;
import org.synku4j.wbxml.util.WbxmlUtil;

public class DefaultCodePageFinder implements WbxmlCodePageFinder {
	
	final List<WbxmlCodePage> pages = new ArrayList<WbxmlCodePage>();

	public DefaultCodePageFinder(final Class<?> source, final List<WbxmlCodePageField> extrapages) {
		WbxmlUtil.introspect(source, pages);
		for (WbxmlCodePageField cpf : extrapages) {
			Class<?> modelClass = cpf.getModelClass();
			if (modelClass != null) {
				WbxmlUtil.introspect(modelClass, pages);	
			} 
		}
	}
	public DefaultCodePageFinder(final Class<?> source) {
		WbxmlUtil.introspect(source, pages);	
	}
	
	@Override
	public WbxmlCodePageField find(int codePageIdx, int fieldId) {
		for (WbxmlCodePage cp : pages) {
			if (cp.getIndex() == codePageIdx) {
				
				for (WbxmlCodePageField cpf : cp.getFields()) {
					if (cpf.getToken() == fieldId) {
						return cpf;
					}
				}
			}
		}
		return null;
	}

	@Override
	public WbxmlCodePageField find(int codePageIdx, String fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

}
