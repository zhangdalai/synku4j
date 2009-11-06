package org.synku4j.wbxml.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.synku4j.wbxml.WbxmlCodePageField;
import org.synku4j.wbxml.WbxmlCodePageFinder;
import org.synku4j.wbxml.decoder.WbxmlDecoder;
import org.synku4j.wbxml.decoder.WbxmlDecoderException;
import org.synku4j.wbxml.decoder.event.WbxmlEvent;

public final class XmlUtils {

	
	public static void toXml(final InputStream is, final OutputStream os, WbxmlCodePageFinder finder, WbxmlCodePageFinder alt) throws IOException, WbxmlDecoderException {
		final PrintStream ps = new PrintStream(os);
		
		final WbxmlDecoder decoder = new WbxmlDecoder(is, finder);
		WbxmlEvent event;
		while ((event = decoder.next()) != null) {
			final WbxmlCodePageField cp = event.getField();
			
			switch(event.getEventType()) {
				case StartElement:
					ps.print("<"+cp.getFieldName()+">");
					break;
				case EndElement:
					ps.print("</"+cp.getFieldName()+">");
					break;
				case Text:
					ps.print(decoder.text());
					break;
				case Opaque: {
					final Class<?> modelClass = cp.getModelClass();
					boolean isString = true;
					byte[] data = decoder.opaque();
					for (byte b : data) {
						if (b == 0) {
							isString = false;
							break;
						}
					}
					if (isString) {
						ps.print(new String(data));
					} else {
						if (alt != null) {
							try {
								toXml(new ByteArrayInputStream(data), os, null, null);
							} catch (Exception e) {
								e.printStackTrace();
								ps.print(new String(data));
							}
						}
					}
					
					break;
				}
			}
		}
	}
}
