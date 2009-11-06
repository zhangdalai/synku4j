package org.synku4j.wbxml.core;

import java.util.Arrays;

import org.synku4j.wbxml.WbxmlCodePageField;

/**
 * The <code>WbxmlValue</code> class
 * 
 * @author Jools Enticknap
 */
public final class WbxmlValue {
	private WbxmlCodePageField field;
	private byte[] value;
	
	
	
	public WbxmlValue(final WbxmlCodePageField field) {
		this.field = field;
	}

	public void setValue(final byte[] value) {
		this.value = value;
	}

	public byte[] getValue() {
		return value;
	}
	
	public WbxmlCodePageField getField() {
		return field;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + Arrays.hashCode(value);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WbxmlValue)) {
			return false;
		}
		WbxmlValue other = (WbxmlValue) obj;
		if (field == null) {
			if (other.field != null) {
				return false;
			}
		} else if (!field.equals(other.field)) {
			return false;
		}
		if (!Arrays.equals(value, other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "WbxmlValue [field=" + field + ", value=" + Arrays.toString(value) + "]";
	}
}
