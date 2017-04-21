package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Prg {

	public Prg() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Class<?> cl = null;
		Method[] lesM = null;
		Object o = null;
		System.out.println(args[0]);
		//Charger DESC
		try {
			cl = Class.forName(args[0]);
			System.out.println("ok");
			lesM = cl.getDeclaredMethods();
			for (Method m : lesM) {
				System.out.println(m.getName());
			}
			o = cl.newInstance();
			lesM[1].invoke(o, (Object[])null);
			
		} catch (ClassNotFoundException e) {
			System.out.println("pas trouve la classe "+args[0]);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
