package org.synku4j.wbxml.marshal.test;

import org.synku4j.wbxml.annotation.WbxmlField;
import org.synku4j.wbxml.annotation.WbxmlPage;

@WbxmlPage(index=0x00, name="Root")
public class Child {
	@WbxmlField(index=0x03, name="bar", required=true)
	private String bar;
}
