package org.synku4j.wbxml.decoder.event;

import java.util.EventObject;

import org.synku4j.wbxml.WbxmlCodePageField;
import org.synku4j.wbxml.decoder.WbxmlDecoder;

public class WbxmlEvent extends EventObject {
	
	public enum EventType {
		StartElement, EndElement, Text, Opaque
	}

	private static final long serialVersionUID = 1L;
	
	private final EventType eventType;
	private final boolean hasContent;
	private final WbxmlCodePageField field;
	
	public WbxmlEvent(final WbxmlDecoder source, final EventType eventType, final WbxmlCodePageField field) {
		this(source, eventType, field, false);
	}
	
	public WbxmlEvent(final WbxmlDecoder source, final EventType eventType, final WbxmlCodePageField field, final boolean hasContent) {
		super(source);
		this.eventType = eventType;
		this.field = field;
		this.hasContent = hasContent;
	}
	
	public EventType getEventType() {
		return eventType;
	}
	
	
	public WbxmlCodePageField getField() {
		return field;
	}

	public boolean hasContent() {
		return hasContent;
	}

	public WbxmlDecoder getSourceAsWbxmlDecoder() {
		return (WbxmlDecoder) getSource();
	}
}
