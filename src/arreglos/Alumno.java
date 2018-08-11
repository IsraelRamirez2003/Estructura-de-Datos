package arreglos;

public class Alumno {
	
	/**
	 * Atributos
	 */
	private String nombre;
	private String grado;
	private int numMaterias;
	private int numExamenes;
	private BoletaDeCalificaciones boleta;
	
	/*
	 * Constructor
	 */
	public Alumno( String nombre, String grado,int numMaterias, int numExamenes) {
		this.nombre = nombre;
		this.grado = grado;
		this.numMaterias = numMaterias;
		this.numExamenes = numExamenes;
		this.boleta = new BoletaDeCalificaciones(numMaterias, numExamenes);
	}
	
	/*
	 * getter and setter
	 */
	protected String getNombre() {
		return nombre;
	}

	protected String getGrado() {
		return grado;
	}

	protected int getNumMaterias() {
		return numMaterias;
	}

	protected int getNumExamenes() {
		return numExamenes;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setGrado(String grado) {
		this.grado = grado;
	}
	
	protected void setNumMaterias(int numMaterias) {
		this.numMaterias = numMaterias;
	}
	
	protected void setNumExamenes(int numExamenes) {
		this.numExamenes = numExamenes;
	}
	
	public void imprimirDatos(){
		String format = "%-10s%-3c%s\n";
		System.out.printf(format,"Nombre",':', getNombre());
		System.out.printf(format,"Grado",':', getGrado());
		System.out.printf(format,"Materias",':', getNumMaterias());
		System.out.printf(format,"Examenes",':', getNumExamenes() * getNumMaterias());
		this.boleta.imprimir();
	}	

}
