package gui;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import dataStorageLayer.BookStorageFacade;

import applicationLayer.BranchBook;
import applicationLayer.UserControl;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UserGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton jButton1;
	public JPanel centre;
	protected JPanel south;
	protected JLabel jLabel3;
	protected JPasswordField jPasswordField1;
	private JTable jTable1;
	protected JButton recordBookReturn;
	protected JButton submitRequestButton;
	protected JButton markAsSentButton;
	protected JScrollPane scrollResult;
	protected JButton activateSearch;
	protected JLabel bookSearchLabel;
	protected JTextField bookSearchField;
	protected JComboBox SearchOptions;
	protected JPanel searchResult;
	protected JPanel searchBy;
	protected JPanel east;
	protected JTextField jTextField1;
	protected JLabel jLabel2;
	protected JLabel jLabel1;
	protected JMenu Action;
	protected JMenuBar jMenuBar1;
	protected JButton bookSearchButton;
	protected DefaultTableModel jTable1Model;
	public JPanel west;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UserGUI inst = new UserGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public UserGUI() {
		super();
		initGUI();
		
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Branch Library System");
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					Action = new JMenu();
					jMenuBar1.add(Action);
					Action.setText("Action");
				}
			}
			{
				west = new JPanel();
				{
					bookSearchButton = new JButton("Book Search");
					west.add(bookSearchButton);
					bookSearchButton.setToolTipText("use this to search for  all information about a book");
					west.add(new JLabel("        "));
					bookSearchButton.addActionListener(new BookSearchListener());
				}
			}
			{
				south = new JPanel();
				FlowLayout jPanel2Layout = new FlowLayout();
				south.setLayout(jPanel2Layout);
				{
					jLabel3 = new JLabel();
					south.add(jLabel3);
					jLabel3.setText("User not logged in");
					jLabel3.setPreferredSize(new java.awt.Dimension(118, 14));
				}
				{
					jLabel1 = new JLabel();
					south.add(jLabel1);
					FlowLayout jLabel1Layout = new FlowLayout();
					jLabel1.setLayout(jLabel1Layout);
					jLabel1.setText("User ID");
					jLabel1.setVisible(true);
					jLabel1.setEnabled(true);
					jLabel1.setToolTipText("Enter your User ID in this field");
				}
				{
					jTextField1 = new JTextField();
					south.add(jTextField1);
					jTextField1.setBounds(259, 45, 168, 20);
					jTextField1.setPreferredSize(new java.awt.Dimension(155, 20));
				}
				{
					jLabel2 = new JLabel();
					south.add(jLabel2);
					jLabel2.setText("Password");
					jLabel2.setToolTipText("Enter your password in this field");
					jLabel2.setPreferredSize(new java.awt.Dimension(109, 14));
					jLabel2.setBounds(431, 8, 91, 14);
				}
				{
					jPasswordField1 = new JPasswordField();
					jLabel2.setLabelFor(jPasswordField1);
					south.add(jPasswordField1);
					jPasswordField1.setPreferredSize(new java.awt.Dimension(147, 20));
					jPasswordField1.setBounds(527, 5, 147, 20);
				}
				{
					jButton1 = new JButton();
					south.add(jButton1);
					jButton1.setText("Login");
					jButton1.addActionListener(new LoginListener());
				}
				//remember how you copied and pasted this guys
				{
					markAsSentButton = new JButton();
					markAsSentButton.setText("Mark as Sent");
					markAsSentButton.setVisible(false);
					markAsSentButton.setToolTipText("lets  know that you've sent the book");
				}
				{
					submitRequestButton = new JButton();
					submitRequestButton.setText("Submit Request");
					submitRequestButton.setVisible(false);
				}
				{
					recordBookReturn = new JButton();
					recordBookReturn.setText("Record return");
					recordBookReturn.setVisible(false);
				}
			}
			{
				east = new JPanel();
			}
			{
				centre = new JPanel();
				//end

				//start
				
				//end
				
					
			}
				thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(thisLayout.createParallelGroup()
					    .addComponent(centre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					    .addComponent(west, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
					    .addComponent(east, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))
					.addComponent(south, 0, 35, Short.MAX_VALUE)
					.addGap(6));
				thisLayout.setHorizontalGroup(thisLayout.createParallelGroup()
					.addComponent(south, GroupLayout.Alignment.LEADING, 0, 761, Short.MAX_VALUE)
					.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
					    .addPreferredGap(south, west, LayoutStyle.ComponentPlacement.INDENT)
					    .addComponent(west, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					    .addGap(21)
					    .addComponent(centre, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					    .addComponent(east, 0, 106, Short.MAX_VALUE)
					    .addContainerGap()));
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class BookSearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("View Status Button Clicked");
			
			//start
			{
				centre.removeAll();
				searchBy = new JPanel();
				centre.add(searchBy);
				GroupLayout searchByLayout = new GroupLayout((JComponent)searchBy);
				searchBy.setLayout(searchByLayout);
				searchBy.setPreferredSize(new java.awt.Dimension(493, 119));
				String choiceList[]  = {"Search by ISBN", "Search by Title", "Search by Publisher",
						"Search By Author",	"Search by Book ID"};
				{
					ComboBoxModel SearchOptionsModel = 
						new DefaultComboBoxModel(choiceList);
					SearchOptions = new JComboBox();
					SearchOptions.setModel(SearchOptionsModel);
					SearchOptions.setSelectedIndex(0);
					SearchOptions.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							bookSearchLabel.setText("Enter "+((String)((JComboBox)(e.getSource())).getSelectedItem()).substring(10));
						}
					});

				}
				{
					activateSearch = new JButton();
					activateSearch.setText("Search");
					activateSearch.addActionListener(new SearchTypeListener());
				}
				{
					bookSearchField = new JTextField();
				}
				{
					bookSearchLabel = new JLabel("Enter ISBN");
				}

				searchByLayout.setHorizontalGroup(searchByLayout.createSequentialGroup()
					.addContainerGap(19, 19)
					.addGroup(searchByLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, searchByLayout.createSequentialGroup()
					        .addComponent(SearchOptions, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					        .addGap(124)
					        .addComponent(activateSearch, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, searchByLayout.createSequentialGroup()
					        .addGap(78)
					        .addComponent(bookSearchLabel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(bookSearchField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)))
					.addContainerGap(24, 24));
				searchByLayout.setVerticalGroup(searchByLayout.createSequentialGroup()
					.addComponent(SearchOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(searchByLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(bookSearchField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(bookSearchLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(activateSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE));
			}
			{
				searchResult = new JPanel();
				GroupLayout searchResultLayout = new GroupLayout((JComponent)searchResult);
				searchResult.setLayout(searchResultLayout);
				centre.add(searchResult);
				searchResult.setPreferredSize(new java.awt.Dimension(498, 338));
				{
					scrollResult = new JScrollPane();
					{
						String[] colHeadings = { "Id", "Name", "Author", "ISBN", "State" };
						jTable1Model = new DefaultTableModel(0, colHeadings.length);
						jTable1Model.setColumnIdentifiers(colHeadings);
						jTable1 = new JTable();
						scrollResult.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
					}
				}

					searchResultLayout.setHorizontalGroup(searchResultLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(searchResultLayout.createParallelGroup()
					    .addGroup(searchResultLayout.createSequentialGroup()
					        .addComponent(scrollResult, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, searchResultLayout.createSequentialGroup()
					        .addGap(25)
					        .addComponent(recordBookReturn, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					        .addGap(32)
					        .addComponent(markAsSentButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					        .addGap(35)
					        .addComponent(submitRequestButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 11, Short.MAX_VALUE)))
					.addContainerGap(16, 16));
					searchResultLayout.setVerticalGroup(searchResultLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollResult, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(searchResultLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(markAsSentButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(submitRequestButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(recordBookReturn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, 36));
			}
		//end

		}
	}
	private class SearchTypeListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// get type from listbox
			BookStorageFacade bsf = BookStorageFacade.getInstance();
			List<BranchBook> bbl = null;
			try {
				switch(SearchOptions.getSelectedIndex()) {
					case 0 : bbl = bsf.getBooksBy("ISBN", bookSearchField.getText()); break; //ISBN
					case 1 : bbl = bsf.getBooksBy("title", bookSearchField.getText()); break; //title
					case 2 : bbl = bsf.getBooksBy("publisher", bookSearchField.getText()); break; // publisher
					case 3 : bbl = bsf.getBooksBy("author", bookSearchField.getText()); break; // author
					case 4 : bbl = new ArrayList<BranchBook>();
						bbl.add(bsf.getBookByID(Integer.parseInt(bookSearchField.getText())));
						break; // id
					default : JOptionPane.showMessageDialog(UserGUI.this, "Unable to retrieve Information from the Database", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NullPointerException ex) {
				;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(UserGUI.this, "Unable to retrieve Information from the Database\nError :" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			int rc = jTable1Model.getRowCount();
			
			for(int i = 0; i < rc ; i++)
				jTable1Model.removeRow(0);
			
			if (bbl != null) {
				for (BranchBook b : bbl) {
					Vector<String> v = new Vector<String>();
					v.add(String.valueOf(b.getID()));
					v.add(b.getTitle());
					v.add(b.getAuthors());
					v.add(b.getISBN());
					v.add(b.getState().toString());
					
					jTable1Model.addRow(v);
				}
			}
		}	
	}	
	private class LoginListener implements ActionListener{

		public void actionPerformed(ActionEvent ev) {		
			/*if username and password is empty
			 * 	do nothing
			 *else
			 *	verify the user and pass combinattion
			 *	if valid
			 *		display the assebility sturves*/
			
			/*south.removeAll();
			south.removeAll();*/
			
			System.out.println("Login Button Clicked");
			Integer uid = Integer.parseInt(jTextField1.getText());
			String pwd = new String(jPasswordField1.getPassword());
			if (uid == null || pwd.isEmpty()) {
				JOptionPane.showMessageDialog(UserGUI.this, "Invalid User ID or/and password", "Error", JOptionPane.ERROR_MESSAGE);
				jPasswordField1.setText("");
			} else {
				UserControl u = UserControl.getInstance();
				try {
					u.login(uid, pwd);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(UserGUI.this, "Unable to login", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					UserGUI.this.dispose();
					UserGUI g = GUIFactory.createGUI(u.getUser());
					g.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(UserGUI.this, "Error occured : "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
		
	}
}
