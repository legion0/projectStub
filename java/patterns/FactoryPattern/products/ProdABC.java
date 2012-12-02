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
public class ProdABC extends ProdAB {
	
	static {
		try {
			ProductFactory.register(ProdABC.class, ProdAB.class);
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
	}
	
	private static final String name = "ProdABC";
	
	public ProdABC(ProdA prod) {
		super(prod);
		if (!super.arg.startsWith(name)) {
			throw new RuntimeException("No Accept");
		}
		System.out.println("Created " + name + ": " + arg);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static boolean accepts(ProdAB prod) {
		return prod != null && prod.arg.startsWith(name);
	}
}
