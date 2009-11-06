package org.synku4j.wbxml.marshal.test;

import java.util.Collection;

import org.synku4j.wbxml.annotation.WbxmlField;
import org.synku4j.wbxml.annotation.WbxmlPage;


@WbxmlPage(index=0x00, name="Root")
public class Root {

	@WbxmlField(index=0x01, name="foo", required=true)
	private String foo;
	
	@WbxmlField(index=0x02, name="children", required=true)
	private Collection<Child> children;
	
	
}
