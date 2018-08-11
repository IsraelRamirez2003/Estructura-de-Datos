package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import arreglos.Alumno;
import arreglos.GrupoAlumnos;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ventana {

	private JFrame frame;
	private GrupoAlumnos grupo;
	//Elementos del menu
	private JList listaMenu;
	private DefaultListModel<String> modelo;
	private JLabel lblMenu;
	private JButton btnSeleccionar;
	//Elementos del formulario de dastos del alumno
	private JTextField campoNombreAlumno;
	private JTextField campoNumeroGrado;
	private JTextField campoNumExamenes;
	private JTextField campoNumMaterias;
	private JLabel lblNombreAlumno;
	private JLabel lblNumeroGrado;
	private JLabel lblNumExamenes;
	private JLabel lblNumMaterias;
	private JButton btnGuardarAlumno;
	private JButton btnRegresar;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
		grupo = new GrupoAlumnos();
		setAlumnosComponentsInvisible();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Gestión de Alumnos");
		frame.setBounds(100, 100, 508, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		modelo = new DefaultListModel<String>();
		listaMenu = new JList(modelo);
		modelo.addElement("1.Añadir alumno");
		modelo.addElement("2.Ver lista de alumnos");
		
		lblMenu = new JLabel("Menu");
		
		btnSeleccionar = new JButton("Seleccionar");
		
		btnRegresar = new JButton("Regresar");
		
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = Integer.parseInt(((String)listaMenu.getSelectedValue()).substring(0, 1));
				
				
				switch(opcion){
				case 1:
					setMenuComponentsInvisible();
					setAlumnosComponentsVisible();
					
					
					//grupo.add(new Alumno(nombre, grado, materias, examenes));
					break;
				case 2:
					
					System.out.println(grupo.get(0));
					break;
				default:
					JOptionPane.showMessageDialog(frame,"Opcion no válida","ERROR!!",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setMenuComponentsVisible();
				setAlumnosComponentsInvisible();		
				
			}
			
		});
		
		lblNombreAlumno = new JLabel("Nombre del alumno");
		
		campoNombreAlumno = new JTextField();
		campoNombreAlumno.setColumns(10);
		
		lblNumeroGrado = new JLabel("Grado");
		
		campoNumeroGrado = new JTextField();
		campoNumeroGrado.setColumns(10);
		
		lblNumExamenes = new JLabel("Numero de examenes");
		
		campoNumExamenes = new JTextField();
		campoNumExamenes.setColumns(10);
		
		lblNumMaterias = new JLabel("Numero de materias");
		
		campoNumMaterias = new JTextField();
		campoNumMaterias.setColumns(10);
		
		btnGuardarAlumno = new JButton("Guardar");
		
		btnGuardarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(campoNombreAlumno.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ingrese el nombre del alumno", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
				}
				
				if(campoNumeroGrado.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ingrese el grado en el que va el alumno", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
				}
				
				if(campoNumExamenes.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ingrese el numero de examenes que va a realizar el alumno por materia", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
				}
				
				if(campoNumMaterias.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ingrese el numero de materias que va a realizar el alumno", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
				}
				grupo.add(new Alumno(campoNombreAlumno.getText(), campoNumeroGrado.getText(), 
						Integer.parseInt(campoNumMaterias.getText()), Integer.parseInt(campoNumExamenes.getText()) ));
				JOptionPane.showMessageDialog(null, "Alumno añadido exitosamente");
				((Alumno)grupo.get(0)).imprimirDatos();
			}
		});
		btnGuardarAlumno.setMnemonic('g');
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(btnSeleccionar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(campoNombreAlumno, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addComponent(lblNombreAlumno)
								.addComponent(lblNumeroGrado)
								.addComponent(lblNumExamenes)
								.addComponent(lblNumMaterias)
								.addComponent(campoNumeroGrado, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addComponent(campoNumExamenes, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnGuardarAlumno)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnRegresar))
										.addComponent(campoNumMaterias, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMenu)
									.addGap(85))
								.addComponent(listaMenu, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
					.addGap(193))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoNombreAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreAlumno)
								.addComponent(lblMenu))
							.addGap(18)
							.addComponent(listaMenu)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnSeleccionar))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNumeroGrado)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(campoNumeroGrado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNumExamenes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(campoNumExamenes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNumMaterias)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(campoNumMaterias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardarAlumno)
						.addComponent(btnRegresar))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void setMenuComponentsInvisible(){
		lblMenu.setVisible(false);
		listaMenu.setVisible(false);
		btnSeleccionar.setVisible(false);
	}
	
	public void setAlumnosComponentsInvisible(){
		campoNombreAlumno.setVisible(false);
	    campoNumeroGrado.setVisible(false);
		campoNumExamenes.setVisible(false);
		campoNumMaterias.setVisible(false);
		lblNombreAlumno.setVisible(false);
		lblNumeroGrado.setVisible(false);
		lblNumExamenes.setVisible(false);
		lblNumMaterias.setVisible(false);
		btnGuardarAlumno.setVisible(false);
		btnRegresar.setVisible(false);
	}
	
	public void setMenuComponentsVisible(){
		lblMenu.setVisible(true);
		listaMenu.setVisible(true);
		btnSeleccionar.setVisible(true);
	}
	
	public void setAlumnosComponentsVisible(){
		campoNombreAlumno.setVisible(true);
	    campoNumeroGrado.setVisible(true);
		campoNumExamenes.setVisible(true);
		campoNumMaterias.setVisible(true);
		lblNombreAlumno.setVisible(true);
		lblNumeroGrado.setVisible(true);
		lblNumExamenes.setVisible(true);
		lblNumMaterias.setVisible(true);
		btnGuardarAlumno.setVisible(true);
		btnRegresar.setVisible(true);
	}
}
