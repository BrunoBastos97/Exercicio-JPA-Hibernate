package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;
import model.AlunoModel;

public class AlunoView extends JFrame {

	private JFrame frmAluno;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldIdade;
	AlunoModel alunoModel = new AlunoModel();
	AlunoController con = new AlunoController();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoView window = new AlunoView();
					window.frmAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlunoView() {
		initialize();
	    CrearModelo2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmAluno = new JFrame();
		frmAluno.setTitle("ALUNO");
		frmAluno.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAluno.setBounds(100, 100, 386, 430);
		frmAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAluno.getContentPane().setLayout(null);

		table = new JTable();
		table.setBounds(31, 241, 307, 139);
		frmAluno.getContentPane().add(table);
		table.setModel(
				new DefaultTableModel(
						new Object[][] {
							
						},
						new String[] {
								
						}
						));
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(31, 111, 46, 14);
		frmAluno.getContentPane().add(lblNewLabel);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(31, 136, 46, 14);
		frmAluno.getContentPane().add(lblMatricula);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(244, 134, 46, 14);
		frmAluno.getContentPane().add(lblIdade);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(102, 108, 232, 20);
		frmAluno.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(102, 133, 122, 20);
		frmAluno.getContentPane().add(textFieldMatricula);

		textFieldIdade = new JTextField();
		textFieldIdade.setColumns(10);
		textFieldIdade.setBounds(288, 131, 46, 20);
		frmAluno.getContentPane().add(textFieldIdade);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Apagar();
			}
		});
		btnApagar.setBackground(Color.WHITE);
		btnApagar.setBounds(132, 207, 92, 23);
		frmAluno.getContentPane().add(btnApagar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					alunoModel.setNome(textFieldNome.getText());
					alunoModel.setMatricula(textFieldMatricula.getText());
					alunoModel.setIdade(Integer.parseInt(textFieldIdade.getText()));
					con.Salvar(alunoModel);
					Apagar();

				} catch (Exception s) {
					JOptionPane.showMessageDialog(null, "ERRO EXISTE CAMPOS VAZIOS OU INVÁLIDOS\n" + s, "ERRO SALVAR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(31, 175, 86, 23);
		frmAluno.getContentPane().add(btnSalvar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setBackground(new Color(178, 34, 34));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Comfirme a Remoção","Remover", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
				try {
					alunoModel.setId(Integer.parseInt(textFieldId.getText()));
					con.Remover(alunoModel);
					Apagar();

				} catch (Exception r) {
					JOptionPane.showMessageDialog(null, "ERRO EXISTE CAMPOS VAZIOS OU INVÁLIDOS\n" + r, "ERRO REMOVER",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnRemover.setBounds(132, 173, 92, 23);
		frmAluno.getContentPane().add(btnRemover);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(SystemColor.activeCaption);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					alunoModel.setNome(textFieldNome.getText());
					alunoModel.setMatricula(textFieldMatricula.getText());
					alunoModel.setIdade(Integer.parseInt(textFieldIdade.getText()));
					con.Salvar(alunoModel);
					Apagar();

				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "ERRO EXISTE CAMPOS VAZIOS OU INVÁLIDOS\n" + a,
							"ERRO ATUALIZAR", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnAtualizar.setBounds(241, 173, 93, 23);
		frmAluno.getContentPane().add(btnAtualizar);

		JLabel lblAluno = new JLabel("ALUNO");
		lblAluno.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 24));
		lblAluno.setBounds(139, 11, 174, 34);
		frmAluno.getContentPane().add(lblAluno);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(31, 86, 46, 14);
		frmAluno.getContentPane().add(lblNewLabel_1);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(102, 83, 86, 20);
		frmAluno.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);

	}

	private void Apagar() {
		textFieldNome.setText("");
		textFieldMatricula.setText("");
		textFieldIdade.setText("");
	}
	public static DefaultTableModel modelo2; 
	private JTextField textFieldId;
    private void CrearModelo2(){
        try {
            modelo2 = (new DefaultTableModel(
               null, new String [] {
               "id","Nome",
               "Matricula","idade"}){
               Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
               };
               boolean[] canEdit = new boolean [] {
               false,false,false,false
               };
               @Override
               public Class getColumnClass(int columnIndex) {
                  return types [columnIndex];
               }
               @Override
               public boolean isCellEditable(int rowIndex, int colIndex){
                  return canEdit [colIndex];
               }
           });
         table.setModel(modelo2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString()+"error2");
           }    
       }
}
