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

package org.synku4j.wbxml.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.synku4j.wbxml.WbxmlCodePage;
import org.synku4j.wbxml.WbxmlCodePageField;
import org.synku4j.wbxml.WbxmlDocument;
import org.synku4j.wbxml.util.WbxmlCodePageFieldWrapper;
import org.synku4j.wbxml.util.WbxmlCodePageWrapper;

/**
 * The <code>XmlCodePageBuilder</code> class is used to read in an xml stream
 * and create a codepage, complete with field definitions.
 * 
 * @author Jools Enticknap
 */
public class XmlCodePageBuilder {

	public static WbxmlDocument[] build(InputStream is) throws JDOMException, IOException {
		final SAXBuilder saxbuilder = new SAXBuilder();
		final Document doc = saxbuilder.build(is);
		final Element root = doc.getRootElement();
		if (!root.getName().equals("WBXML")) {
			throw new IllegalArgumentException("Root element is not WBXML");
		}
		
		final List<WbxmlDocument> documents = new ArrayList<WbxmlDocument>();
		for (Object obj : root.getChildren("Document")) {
			documents.add(createWbxmlDocument((Element) obj));
		}
		
		return documents.toArray(new WbxmlDocument[documents.size()]);
	}
	
	private static WbxmlDocument createWbxmlDocument(final Element element) {
		String strPublicID = element.getAttributeValue("publicID");
		String strFormalPublicId = element.getAttributeValue("formalPublicID");
		int publicID = toInt(strPublicID);
		
		final List<WbxmlCodePage> codePages = new ArrayList<WbxmlCodePage>();
		for (Object obj : element.getChildren("CodePage")) {
			codePages.add(createWbxmlCodePage((Element) obj, publicID, strFormalPublicId));
		}
		
		return new WbxmlDocument(publicID, strFormalPublicId, codePages.toArray(new WbxmlCodePage[codePages.size()]));
	}

	
	private static WbxmlCodePage createWbxmlCodePage(Element element, int publicID, String formalID) {
		final String strIndex = element.getAttributeValue("index");
		final String publicFormalID = element.getAttributeValue("formalPublicID");
		final int index = toInt(strIndex);
		
		final WbxmlCodePageWrapper codePage = new WbxmlCodePageWrapper(index, publicID, publicFormalID == null ? formalID:publicFormalID); 
		
		for (Object fld : element.getChildren("field")) {
			codePage.addCodePageField(createWbxmlCodePageField(index, (Element)fld));
		}
		
		return codePage;
	}
	
	private static WbxmlCodePageField createWbxmlCodePageField(int pageIdx, Element element) {
		String name = element.getAttributeValue("name");
		int token = toInt(element.getAttributeValue("token"));
		String strModelClass = element.getAttributeValue("modelClass");
		
		Class<?> modelClass = null;
		try {
			modelClass = strModelClass == null ? null : Class.forName(strModelClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new WbxmlCodePageFieldWrapper(pageIdx, token, name, modelClass);
	}

	private static int toInt(String str) {
		if (str == null) {
			return 0;
		}
		if (str.startsWith("0x")) {
			str = str.substring(2);
			return Integer.parseInt(str, 16);
		} else {
			return Integer.parseInt(str);
		}
	}
}
