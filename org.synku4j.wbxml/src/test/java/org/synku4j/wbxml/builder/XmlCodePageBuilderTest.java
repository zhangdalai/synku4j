package org.synku4j.wbxml.builder;

import java.io.InputStream;

import org.synku4j.wbxml.WbxmlCodePage;
import org.synku4j.wbxml.WbxmlDocument;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XmlCodePageBuilderTest {

	@Test
	public void testXmlBuilder() throws Exception {
		final InputStream is = getClass().getResourceAsStream("/codepages/test-codepage.xml");
		Assert.assertNotNull(is);
		final WbxmlDocument[] documents = XmlCodePageBuilder.build(is);	
	}
	
}
