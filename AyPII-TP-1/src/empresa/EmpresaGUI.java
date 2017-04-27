package empresa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionEvent;

public class EmpresaGUI {

	protected Shell shell;
	Button botonAgregar;
	Button botonQuitar;
	private Text text;
	private Text textoDni;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table table;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 452);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Label labelAccion = new Label(shell, SWT.NONE);
		labelAccion.setAlignment(SWT.RIGHT);
		labelAccion.setText("Accion");
		
		Button radioAgregar = new Button(shell, SWT.RADIO);
		radioAgregar.setText("Agregar");
		radioAgregar.addSelectionListener(
			    new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent evento) {
			        }
			        public void widgetSelected(SelectionEvent evento) {
		                boolean isSelected = ((Button)evento.getSource()).getSelection();
		          if(isSelected){
		        	  botonAgregar.setEnabled(true);
		        	  botonQuitar.setEnabled(false);
		          }
		          }
			        }
			    );
		new Label(shell, SWT.NONE);
		
		Button radioQuitar = new Button(shell, SWT.RADIO);
		radioQuitar.setText("Quitar");
		radioQuitar.addSelectionListener(
			    new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent evento) {
			        }
			        public void widgetSelected(SelectionEvent evento) {
		                boolean isSelected = ((Button)evento.getSource()).getSelection();
		          if(isSelected){
		        	  botonAgregar.setEnabled(false);
		        	  botonQuitar.setEnabled(true);
		          }
		          }
			        }
			    );		
		Label labelDni = new Label(shell, SWT.NONE);
		labelDni.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelDni.setText("DNI");
		
		textoDni = new Text(shell, SWT.BORDER);
		textoDni.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label labelNombre = new Label(shell, SWT.NONE);
		labelNombre.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelNombre.setText("Nombre");
		
		text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label labelCuil = new Label(shell, SWT.NONE);
		labelCuil.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelCuil.setText("CUIL");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label labelSueldo = new Label(shell, SWT.NONE);
		labelSueldo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSueldo.setText("Sueldo Fijo");
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label labelSalarioHora = new Label(shell, SWT.NONE);
		labelSalarioHora.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSalarioHora.setText("Salario / Hora");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label labelHorasTrabajadas = new Label(shell, SWT.NONE);
		labelHorasTrabajadas.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelHorasTrabajadas.setText("Horas Trabajadas");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label premioEjecutivo = new Label(shell, SWT.NONE);
		premioEjecutivo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		premioEjecutivo.setText("Premio");
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		botonAgregar = new Button(shell, SWT.NONE);
		botonAgregar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		botonAgregar.setText("Agregar");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		botonQuitar = new Button(shell, SWT.NONE);
		botonQuitar.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		botonQuitar.setText(" Quitar  ");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("New Column");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("New Column");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("New Column");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("New Column");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("New Column");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");

	}

}
