/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

/**
 *
 * @author legion
 */
public class ProdA implements ProductI {

	String arg;
	private static final String name = "ProdA";
	
	public ProdA(String arg) {
		if (!arg.startsWith(name)) {
			throw new RuntimeException("No Accept");
		}
		System.out.println("Created " + name + ": " + arg);
		this.arg = arg;
	}
	
	public ProdA(ProdA other) {
		this.arg = other.arg;
		System.out.println("Created " + name + ": " + arg);
	}
	
	
	
	@Override
	public String toString() {
		return name;
	}
}
