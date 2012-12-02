/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author legion
 */
public class ProdAB extends ProdA {
	
	private static final String name = "ProdAB";
	
	public ProdAB(ProdA prod) {
		super(prod);
		if (!super.arg.startsWith(name)) {
			throw new RuntimeException("No Accept");
		}
		System.out.println("Created " + name + ": " + arg);
	}
	
	static {
		try {
			ProductFactory.register(ProdAB.class, ProdA.class);
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static boolean accepts(ProdA prod) {
		return prod.arg.startsWith(name);
	}
}
