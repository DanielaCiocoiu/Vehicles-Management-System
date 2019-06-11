package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	private JLabel markLabel;
	private JLabel modelLabel;
	private JLabel mileageLabel;
	private JLabel priceLabel;
	private JLabel transmissionLabel;
	private JTextField markField;
	private JTextField modelField;
	private JTextField mileageField;
	private JTextField priceField;
	private JTextField transmissionField;
	private JButton okBtn;
	private FormListener formListener;
	private JList fuelList;
	private JComboBox<String> empCombo;
	private JRadioButton usedCarRadio;
	private JRadioButton newCarRadio;
	private ButtonGroup newUsedGroup;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 350;
		setPreferredSize(dim);

		markLabel = new JLabel("Mark: ");
		modelLabel = new JLabel("Model: ");
		mileageLabel = new JLabel("Mileage: ");
		priceLabel = new JLabel("Price: ");
		transmissionLabel = new JLabel("Transmission: ");
		markField = new JTextField(10);
		modelField = new JTextField(10);
		mileageField = new JTextField(10);
		priceField = new JTextField(10);
		transmissionField = new JTextField(10);
		fuelList = new JList();
		empCombo = new JComboBox();
		okBtn = new JButton("OK");// 1. sursa evenimentului, genereaza un actioEvent

		usedCarRadio = new JRadioButton("Used");
		newCarRadio = new JRadioButton("New");
		usedCarRadio.setActionCommand("Used");
		newCarRadio.setActionCommand("New");

		newUsedGroup = new ButtonGroup();
		usedCarRadio.setSelected(true);

		// new Used radios
		newUsedGroup.add(usedCarRadio);
		newUsedGroup.add(newCarRadio);

		// list box
		DefaultListModel fuelModel = new DefaultListModel();
		fuelModel.addElement(new FuelCategory(0, "Diesel"));
		fuelModel.addElement(new FuelCategory(1, "Petrol"));
		fuelModel.addElement(new FuelCategory(2, "Electric"));
		fuelList.setModel(fuelModel);

		fuelList.setPreferredSize(new Dimension(110, 70));
		fuelList.setBorder(BorderFactory.createEtchedBorder());
		fuelList.setSelectedIndex(0);

		// combo box
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("One year");
		empModel.addElement("Five years");
		empModel.addElement("Ten years");
		empModel.addElement("Fifteen years");

		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		empCombo.setEditable(true);// il fac editabil

		okBtn.addActionListener(new ActionListener() {
				// ma inregistrez in lista butonului, ii spun ca sunt interesat de ev

			public void actionPerformed(ActionEvent e) {
				// clasa interioara anonima, definesc metoda de tratare a ev, argum action event trimite
				// informatia de la butonul ok care a ridicat ev catre clasa anonima
				// ob ev actionEvent va inmag informatia de mai jos si o va trimite catre
				// controller in mainFrame
				String mark = markField.getText();
				String model = modelField.getText();
				String mileage = mileageField.getText().trim();
				String price = priceField.getText();
				String transmission = transmissionField.getText();
				FuelCategory fuelCat = (FuelCategory) fuelList.getSelectedValue();
				String empCat = (String) empCombo.getSelectedItem();// ret un ob, cast la string
				String newUsed = newUsedGroup.getSelection().getActionCommand();// returneaza used, new

				FormEvent ev = new FormEvent(this, mark, model, mileage, price, transmission, fuelCat.getId(), empCat,
						newUsed);
				if (formListener != null) {
					formListener.formEventOcurred(ev);
					// apelez metoda formEvent din mainFrame iar mainFrame transmite catre text
					// panel ce are de facut
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add car");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		layoutComponents();
	}

	public void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		///// mark //////
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);// external padding of the component
		gc.anchor = GridBagConstraints.LINE_END;
		add(markLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(markField, gc);
		gc.fill = GridBagConstraints.NONE;

		///// model //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(modelLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(modelField, gc);

		///// mileage //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(mileageLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(mileageField, gc);

		///// price //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(priceLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(priceField, gc);
		///// transmission //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(transmissionLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(transmissionField, gc);
		///// fuel //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Fuel: "), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(fuelList, gc);

		///// FirstRegistration //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("First Registration: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(empCombo, gc);

		///// used //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.05;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("New/Used: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(usedCarRadio, gc);

		///// new //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(newCarRadio, gc);

		///// ok Btn //////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);

	}

	public void setFormListener(FormListener listener) {

		this.formListener = listener;
	}
}

class FuelCategory {

	private int id;
	private String text;

	public FuelCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public String toString() {
		return text;
	}

	public int getId() {
		return id;
	}
}
