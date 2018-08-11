package arreglos;



import javax.swing.JOptionPane;

public class BoletaDeCalificaciones {
	
	
	/**
	 * Atributos
	 */
	private String[] materias;
	private int[][] calificacionesDeExamenes;
	private double[] promedios;
	private double promedioGeneral;
	private int numMaterias;
	private int numExamenes;
	
	
	
	/**
	 * Constructor
	 */
	public BoletaDeCalificaciones(int numMaterias , int numExamenes) {
		setNumMaterias(numMaterias);
		setNumExamenes(numExamenes);
		this.materias = new String [numMaterias];
		this.calificacionesDeExamenes = new int [numMaterias] [numExamenes];
		this.promedios = new double[numMaterias];
		this.promedioGeneral = 0;
		setMaterias();
		setCalificacionesDeExamenes();
		setPromedios();
		setPromedioGeneral();
	}

	
	
	/**
	 * Getters & Setters
	 */
	protected String[] getMaterias() {
		return materias;
	}
	
	protected int[][] getCalificacionesDeExamenes() {
		return calificacionesDeExamenes;
	}

	protected double getPromedioGeneral() {
		return promedioGeneral;
	}

	protected void setMaterias() {
		for(int i = 0; i < getNumMaterias(); i++){
			materias[i] = JOptionPane.showInputDialog("Ingrese el nombre de la materia " + (i+1) + ": ");
			
		};
	}
	
	protected void setCalificacionesDeExamenes() {
		int materia, examen;

		for(materia = 0; materia < getNumMaterias(); materia++){
			for(examen = 0; examen < getNumExamenes(); examen++){
				calificacionesDeExamenes[materia][examen] = Integer.parseInt(JOptionPane.showInputDialog("Materia: " +
			materias[materia]+"\nCalificación Examen " + (examen+1)+ "="));
				
				
			}	
		}
		
	}

	protected void setPromedioGeneral() {
		double suma = 0;
		for(int i = 0; i < getNumMaterias();i++){
			suma += promedios[i];
			promedioGeneral = suma/getNumExamenes();
		}
	}
	
	protected double[] getPromedios() {
		return promedios;
	}

	protected int getNumMaterias() {
		return numMaterias;
	}

	protected int getNumExamenes() {
		return numExamenes;
	}

	protected void setPromedios() {
		int suma = 0 , promedio = 0;
		int examen,materia = 0;
		for(materia = 0; materia < getNumMaterias(); materia++){

			for(examen = 0; examen < getNumExamenes(); examen++){
				suma += calificacionesDeExamenes[materia][examen];
			}
			promedio = suma/getNumExamenes(); 
			promedios[materia] = promedio;
			promedio = 0;
			suma = 0;
		}
	}

		

	protected void setNumMaterias(int numMaterias) {
		this.numMaterias = numMaterias;
	}

	protected void setNumExamenes(int numExamenes) {
		this.numExamenes = numExamenes;
	}

	
	
	/**
	 * Metodos
	 */
	public void imprimir(){
		String formatoMateria = "%-14s";
		String formatoCalificacion = "%-4s";
		
		System.out.print("_____________________________________________________\n");
		System.out.printf(formatoMateria, "Materias");
		
		System.out.print("| Calificaciones De Examenes\n");
		System.out.print("******************************************************************\n");
		for(int materia = 0; materia < getNumMaterias(); materia++){
			System.out.printf(formatoMateria,materias[materia]);
			for(int examen = 0; examen < getNumExamenes(); examen++){
				System.out.printf(formatoCalificacion,calificacionesDeExamenes[materia][examen]);
			}                                                                       
			System.out.printf(formatoCalificacion, "|  " + promedios[materia] + "\n");
		}
		System.out.print("******************************************************************\n");
		System.out.print("Promedio General:\t" + promedioGeneral +"\n\n");
	}



	
	
	
	
	
	
	
}

