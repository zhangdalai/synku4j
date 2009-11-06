package org.synku4j.wbxml;

/**
 * The <code>CodePage</code> interface defines the
 * 
 * @author Jools Enticknap
 */
public interface WbxmlCodePage {
	/**
	 * @return the global public identifier for this codepage, if 0 then the
	 *         formalPublicID MUST no return a null, or an empty string
	 */
	int getPublicID();

	/**
	 * @return return the formal public id of a code page, for example "-//SYNCML//DTD SyncML 1.0//EN"
	 */
	String getFormalPublicID();

	/**
	 * @return the code page index.
	 */
	int getIndex();

	/**
	 * @return the namespace for example "MetInf"
	 */
	//String nameSpace();

	/**
	 * @return the fields which are defined for this code page.
	 */
	WbxmlCodePageField[] getFields();
}
