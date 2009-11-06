package org.synku4j.wbxml.marshal;

import java.io.ByteArrayOutputStream;

import org.synku4j.wbxml.context.WbxmlContext;
import org.testng.annotations.Test;

public class WbxmlMarshallerTest {

	@Test
	public void testMarshaller() throws Exception {
		
		WbxmlMarshaller marshaller = new DefaultWbxmlMarshaller();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		WbxmlContext cntx = new WbxmlContext();
		
	}
}
