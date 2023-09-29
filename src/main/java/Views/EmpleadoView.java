package Views;

import controllers.EmpleadoController;

public class EmpleadoView {
	public static void main (String[] args) {
		
		// Crear Empleado
		//String usuario = new EmpleadoController().createUsuario("Kein","Horacio",20,"masculino",200);
		
		
		// Eliminar Empleado
		//String usuario = new EmpleadoController().deleteUsuario(3);
		
		
		// Actualizar Empleado
		//String usuario = new EmpleadoController().updateUsuario(1,"Najarro","Aaron",18, "masculino", 3000);
		
		
		// Leer Empleado
		String usuario = new EmpleadoController().getUsuario(2);
		System.out.println(usuario);
		
		
	}

}
