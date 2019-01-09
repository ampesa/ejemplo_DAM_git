package program;

import java.util.Date;
import org.hibernate.Session;

/********************************************************************************************************
 * 
 * Recuerda introducir la contraseña para el root en el fichero de configuración hibernate.cfg.xml
 * 
 * *****************************************************************************************************/

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Hola");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		/*
		session.beginTransaction();
		
		Usuario u = new Usuario();
		u.setNombre("Paco");
		u.setObjetivo(40);
		u.setTotal(100);
		
		session.save(u);
		
		session.getTransaction().commit();
		*/
		
		// Iniciamos Transacción
		session.beginTransaction();
		
		/*
		// Añadimos Empresas
		Empresa e = new Empresa();
		e.setCif("B46326548");
		e.setNombre("Cementos Pepe");
		e.setEmpleados(23);
		e.setDireccion("Calle 2 de mayo, 23. 46980 - Paterna");
		session.save(e);
		
		Empresa d = new Empresa();
		d.setCif("A46857925");
		d.setNombre("Palets Mariano");
		d.setEmpleados(45);
		d.setDireccion("Calle Calvario, 2. 46470 - Catarroja");
		session.save(d);*/
		
		// Añadimos Pedidos
		Pedido p = new Pedido();
		p.setFecha(new Date());
		p.getItem().add(new Item("tijeras", 7));
		p.getItem().add(new Item("papel hoja A4", 500));
		session.save(p);
		
		Pedido q = new Pedido();
		q.setFecha(new Date());
		q.getItem().add(new Item("grapadora", 5));
		q.getItem().add(new Item("grapas", 1000));
		session.save(q);
		
		/*
		// Añadimos Items
		Item i = new Item();
		i.setNombre("Grapadora 6589");
		i.setCantidad(4);
		session.save(i);
		
		Item j = new Item();
		j.setNombre("Grapas 6588");
		j.setCantidad(1000);
		session.save(j);*/
		
		// Hacemos el commit
		session.getTransaction().commit();
		
		/*
		// Comprobamos que han persistido en la base de datos
		Empresa f = session.get(Empresa.class, "B46326548");
		System.out.println("Recuperamos la empresa " + e.getNombre() + " con " + e.getEmpleados() + " empleados");
		*/
		
		// Comprobamos la persistencia del pedido recuperándolo desde la bbdd
		Pedido p2 = session.get(Pedido.class, 1);
		System.out.println("Recuperamos el pedido " + p2.getId() + " con fecha " + p2.getFecha() + "que contiene: ");
		
		for (Item item : p2.getItem()){
			System.out.println(item.getNombre() + " " + item.getCantidad());
		}
		
		// Recuperamos también el pedido en la posición 2
		Pedido p3 = session.get(Pedido.class, 2);
		System.out.println("Recuperamos el pedido " + p3.getId() + " con fecha " + p3.getFecha() + "que contiene: ");

		for (Item item : p3.getItem()){
			System.out.println(item.getNombre() + " " + item.getCantidad());
		}		
		
		/*
		// Hacemos lo mismo con un Item
		Item k = session.get(Item.class, 1);
		System.out.println("Recuperamos el item " + i.getNombre() + " con " + i.getCantidad() + " unidades");
		*/
		
		// Cerramos session y SessionFactory
		session.close();
		HibernateUtilities.getSessionFactory().close();
		System.out.println("Adios");

	}

}
