
package br.com.cds.connecta.framework.core.exeception;

/**
 * 
 * @Autor Ryan A. Thuin

 * 
 */
public class PersistenceException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(String message, Throwable root) {
		super(message, root);
	}
	
	public PersistenceException(Throwable cause) {
		super(cause);
	}

	protected PersistenceException() {
		super();
	}
}
