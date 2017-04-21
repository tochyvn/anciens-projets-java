package reflectionG2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Prg {
	private Contrat t;
	private Class<?> cl;
	private Method[] lesM;
	
	public Prg(String s) {
		try {
			cl = Class.forName(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void go()
	{
		Object o = null;
		int sauv = -1;
		lesM = cl.getDeclaredMethods();
		for (int i = 0 ; i < lesM.length ; i++) {
			System.out.println(lesM[i].getName());
			if(lesM[i].getName().equals("m1"))
			{
				sauv = i;
			}
		}
		try {
			o = cl.newInstance();
			t = (Contrat)cl.newInstance();
			if(sauv >= 0)
			{
				lesM[sauv].invoke(o, (Object[])null);
			}
			System.out.println("le T est un contrat m1 = ");
			t.m1();
			System.out.println("objet cree de type: "+o.getClass().getSimpleName());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 //		System.out.println(cl.getSimpleName());
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args)
	{
		System.out.println(args[0]);
		Prg p = new Prg(args[0]);
		p.go();
	}

}
