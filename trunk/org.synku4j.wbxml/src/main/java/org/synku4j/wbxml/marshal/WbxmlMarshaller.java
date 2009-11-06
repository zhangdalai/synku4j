package org.synku4j.wbxml.marshal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.synku4j.wbxml.context.WbxmlContext;

public interface WbxmlMarshaller {
	<T> T unmarshal(WbxmlContext cntx, InputStream is, Class<T> t,  String...filter) 
	throws IOException, WbxmlMarshallerException;
	
	<T> void marshal(WbxmlContext cntx, OutputStream os,  T t, String...filter) 
	throws IOException, WbxmlMarshallerException;
}
