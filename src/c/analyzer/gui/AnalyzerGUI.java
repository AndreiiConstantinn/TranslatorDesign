package c.analyzer.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import c.analyzer.ClanguageAnalyzer;
import c.analyzer.Function;
import c.analyzer.FunctionsAnalyzer;
import c.analyzer.Variable;

public class AnalyzerGUI {
	private JFrame frame;
	private JTextField inputField;
	private JTextField outputField;
	private JTextField resultField;
	private JTextField statementsField;
	private JTextField functionsField;
	private JTextArea variablesArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyzerGUI window = new AnalyzerGUI();
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
	public AnalyzerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(500, 300));
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInputFile = new JLabel("Input file:");
		lblInputFile.setBounds(34, 41, 72, 16);
		frame.getContentPane().add(lblInputFile);
		
		JLabel lblOutputFile = new JLabel("Output file:");
		lblOutputFile.setBounds(34, 69, 72, 16);
		frame.getContentPane().add(lblOutputFile);
		
		inputField = new JTextField();
		inputField.setBounds(117, 36, 274, 26);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		outputField = new JTextField();
		outputField.setBounds(118, 64, 273, 26);
		frame.getContentPane().add(outputField);
		outputField.setColumns(10);
		
		JButton inputBrowse = new JButton("Browse");
		inputBrowse.setBounds(403, 36, 72, 29);
		inputBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// create an object of JFileChooser class 
	            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory()); 
	            
	            // create a filter for c files
	            FileFilter filter = new FileNameExtensionFilter("C File","c");
	            fileChooser.setFileFilter(filter);
	            
	            int result = fileChooser.showOpenDialog(null); 
	            // if the user selects a file 
	            if (result == JFileChooser.APPROVE_OPTION) { 
	                // set the label to the path of the selected file 
	                inputField.setText(fileChooser.getSelectedFile().getAbsolutePath()); 
	                resultField.setVisible(false);
	            } 
	        } 
		});
		frame.getContentPane().add(inputBrowse);
		
		JButton outputBrowse = new JButton("Browse");
		outputBrowse.setBounds(403, 64, 72, 29);
		outputBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// create an object of JFileChooser class 
	            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory()); 
	            
	            int result = fileChooser.showOpenDialog(null); 
	            // if the user selects a file 
	            if (result == JFileChooser.APPROVE_OPTION) { 
	                // set the label to the path of the selected file 
	                outputField.setText(fileChooser.getSelectedFile().getAbsolutePath()); 
	            } 
	        } 
		});
		frame.getContentPane().add(outputBrowse);
		
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setVisible(false);
		resultField.setBounds(148, 97, 255, 26);
		resultField.setColumns(10);
		frame.getContentPane().add(resultField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(415, 97, 60, 29);
		btnClear.setVisible(false);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultField.setVisible(false);
				btnClear.setVisible(false);
				variablesArea.setText("");
				statementsField.setText("");
				functionsField.setText("");
			}
		});
		frame.getContentPane().add(btnClear);
		
		JButton btnRunAnalyzer = new JButton("Run Analyzer");
		btnRunAnalyzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClanguageAnalyzer cAnalyzer = new ClanguageAnalyzer();
				cAnalyzer.runAnalyzer(inputField.getText(), outputField.getText());
				resultField.setVisible(true);
				btnClear.setVisible(true);
				
				FunctionsAnalyzer fAnalyzer = cAnalyzer.getParser().getAnalyzer();
				
				StringBuilder functions = new StringBuilder();
				for (Function function : fAnalyzer.getFunctions()) {
					functions.append(function.getName() + ", located at line: " + function.getDefLine());
				}
				functionsField.setText(functions.toString());
				
				StringBuilder variables = new StringBuilder();
				for (Variable variable : fAnalyzer.getVarList()) {
					String varName = variable.getName();
					variables.append(varName).append(", located at: " + cAnalyzer.getVariablesLocations().get(varName)).append("\n");
				}
				variablesArea.setText(variables.toString());
				
				statementsField.setText("" + fAnalyzer.getNrOfStatements());
			}
		});
		btnRunAnalyzer.setBounds(21, 97, 117, 29);
		frame.getContentPane().add(btnRunAnalyzer);
		
		JLabel lblFunctions = new JLabel("Functions:");
		lblFunctions.setBounds(31, 166, 94, 16);
		frame.getContentPane().add(lblFunctions);

		functionsField = new JTextField();
		functionsField.setColumns(10);
		functionsField.setBounds(137, 161, 326, 26);
		frame.getContentPane().add(functionsField);
		
		JLabel lblNrStatements = new JLabel("Nr. statements:");
		lblNrStatements.setBounds(31, 138, 105, 16);
		frame.getContentPane().add(lblNrStatements);
		
		statementsField = new JTextField();
		statementsField.setBounds(137, 133, 60, 26);
		frame.getContentPane().add(statementsField);
		statementsField.setColumns(10);
		
		JLabel lblVariables = new JLabel("Variables:");
		lblVariables.setBounds(34, 208, 61, 16);
		frame.getContentPane().add(lblVariables);
		
		variablesArea = new JTextArea();
		variablesArea.setBounds(137, 192, 326, 80);
		frame.getContentPane().add(variablesArea);
	}
}
