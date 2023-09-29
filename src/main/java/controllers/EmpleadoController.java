package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;


public class EmpleadoController {

	// Crear Empleado
	public String createUsuario(String apellidos, String nombres, int edad, String sexo, double salario) {
			
		SessionFactory sesionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sesionFactory.openSession();
			
		try {
			Empleado usuario = new Empleado(apellidos, nombres, edad, sexo, salario);
			session.beginTransaction();
			session.save(usuario); 
			session.getTransaction().commit();
			sesionFactory.close();
			return "Empleado creado";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al registrar Empleado";
	}

	// Eliminar Empleado
	public String deleteUsuario (int idEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado usuario = session.get(Empleado.class, idEmpleado);
			session.delete(usuario);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Empleado eliminado correctamente";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al eliminar Empleado";
	}

	
	// Actualiza Empleado
	public String updateUsuario (int idEmpleado, String apellidos, String nombres, int edad, String sexo, double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado usuario = session.get(Empleado.class, idEmpleado); 
			usuario.setApellidos(apellidos);
			usuario.setNombres(nombres);
			usuario.setEdad(edad);
			usuario.setSexo(sexo);
			usuario.setSalario(salario);
			
			session.update(usuario);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Empleado actualizado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al actualizar Empleado";
	}
	
	// Leer Empleado
	public String getUsuario (int idEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado usuario = session.get(Empleado.class, idEmpleado);
			session.getTransaction().commit();
			sessionFactory.close();
			return usuario.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Empleado no existe";
	}

}
