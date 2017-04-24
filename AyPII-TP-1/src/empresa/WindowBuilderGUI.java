package empresa;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Event;

public class WindowBuilderGUI extends Composite {
	private Text textoDni;
	private Text textoNombre;
	private Text textoCuil;
	private Table table;
	Button botonQuitar;
	Button botonAgregar;

	public void run(){
		
	}
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public WindowBuilderGUI(Composite parent, int style) {
		super(parent, style);
		
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    Group accionesAgregarQuitar = new Group(shell, SWT.NONE);
	    
	     // pos x, pos y, width, height
	    shell.setBounds(0, 0, 1024, 768);
	    shell.setText("Empresa");
	    shell.setLayout(new FillLayout());
	    
	    Button radioAgregar = new Button(accionesAgregarQuitar, SWT.RADIO);
 		radioAgregar.setBounds(53, 32, 106, 16);
		radioAgregar.setText("Agregar");
		boolean estadoBotonAgregar = radioAgregar.getSelection();
		if (estadoBotonAgregar){
			botonQuitar.setEnabled(false);
		}
		
	    radioAgregar.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event evento) {
	    		switch (evento.type){
	    		case SWT.Selection:
	    			System.out.println("Button pressed");
	    			botonQuitar.setEnabled(false);
	    		}
	    	}
	    });

		botonAgregar = new Button(accionesAgregarQuitar, SWT.NONE);
		botonAgregar.setBounds(20, 303, 92, 34);
		botonAgregar.setText("Agregar");
		
		botonQuitar = new Button(accionesAgregarQuitar, SWT.NONE);
		botonQuitar.setBounds(169, 303, 92, 34);
		botonQuitar.setText("Quitar");
		
		Button botonCargar = new Button(accionesAgregarQuitar, SWT.NONE);
		botonCargar.setBounds(325, 303, 92, 34);
		botonCargar.setText("Cargar");
		
		Button botonGuardar = new Button(accionesAgregarQuitar, SWT.NONE);
		botonGuardar.setBounds(480, 303, 92, 34);
		botonGuardar.setText("Guardar");
				
		Button radioQuitar = new Button(accionesAgregarQuitar, SWT.RADIO);
		radioQuitar.setBounds(192, 32, 106, 16);
		radioQuitar.setText("Quitar");
		boolean estadoBotonQuitar = radioQuitar.getSelection();
		if (estadoBotonQuitar){
			botonAgregar.setEnabled(false);
		}
		
		Label etiquetaDni = new Label(accionesAgregarQuitar, SWT.NONE);
		etiquetaDni.setBounds(53, 87, 26, 15);
		etiquetaDni.setText("DNI");
		
		Label etiquetaNombre = new Label(accionesAgregarQuitar, SWT.NONE);
		etiquetaNombre.setBounds(53, 135, 55, 15);
		etiquetaNombre.setText("Nombre");
		
		Label etiquetaCuil = new Label(accionesAgregarQuitar, SWT.NONE);
		etiquetaCuil.setBounds(53, 183, 35, 15);
		etiquetaCuil.setText("CUIL");
		
		textoDni = new Text(accionesAgregarQuitar, SWT.BORDER);
		textoDni.setBounds(80, 79, 417, 30);
		
		textoNombre = new Text(accionesAgregarQuitar, SWT.BORDER);
		textoNombre.setBounds(113, 126, 384, 30);
		
		textoCuil = new Text(accionesAgregarQuitar, SWT.BORDER);
		textoCuil.setBounds(89, 176, 408, 30);
		
		Label tipoDeTrabajador = new Label(accionesAgregarQuitar, SWT.NONE);
		tipoDeTrabajador.setBounds(53, 238, 30, 15);
		tipoDeTrabajador.setText("Tipo");
		
		Combo comboTipoTrabajador = new Combo(accionesAgregarQuitar, SWT.NONE);
		comboTipoTrabajador.setBounds(85, 227, 245, 34);
		
		table = new Table(accionesAgregarQuitar, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 343, 581, 250);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn columnaDni = new TableColumn(table, SWT.NONE);
		columnaDni.setWidth(100);
		columnaDni.setText("DNI");
		
		TableColumn columnaNombre = new TableColumn(table, SWT.NONE);
		columnaNombre.setWidth(300);
		columnaNombre.setText("Nombre");
		
		TableColumn columnaCuil = new TableColumn(table, SWT.NONE);
		columnaCuil.setWidth(100);
		columnaCuil.setText("CUIL");
		
		shell.open();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
