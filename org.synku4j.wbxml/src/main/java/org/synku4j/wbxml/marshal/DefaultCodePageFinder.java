/*
 * Copyright (C) 2009 Jools Enticknap
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
