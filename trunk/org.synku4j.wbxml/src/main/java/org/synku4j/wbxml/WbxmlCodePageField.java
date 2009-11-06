package org.synku4j.wbxml;

/**
 * The <code>CodePageField</code> interface defines the mapping of a field
 * to it's name, supplying where specified a class which represents the field.
 * 
 * As a general rule, only composite fields (fields that have children) will have a model class.
 * 
 * @author Jools Enticknap
 */
public interface WbxmlCodePageField {
	/**
	 * @return the name of the field, as it would appear in the DTD
	 */
	String getFieldName();
	
	/**
	 * @return the WBXML integer which represents this field.
	 */
	int getToken();
	
	/**
	 * @return the integer which represents this namespace this page resides in.
	 */
	int getPage();
	
	/**
	 * @return the class which represents this field.
	 */
	Class<?> getModelClass();
}
