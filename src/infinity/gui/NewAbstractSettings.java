// Near Infinity - An Infinity Engine Browser and Editor
// Copyright (C) 2001 - 2005 Jon Olav Hauglid
// See LICENSE.txt for license information

package infinity.gui;

import infinity.icon.Icons;

import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

// Common base class for settings dialogs, used to customize the creation of new resources
public abstract class NewAbstractSettings extends JDialog implements ActionListener
{
  private boolean accepted;
  private JButton okButton;
  private JButton cancelButton;

  protected NewAbstractSettings(Window parent, String title)
  {
    super(parent, title, Dialog.ModalityType.APPLICATION_MODAL);
    setIconImage(Icons.getIcon("New16.gif").getImage());

    okButton = new JButton("Create");
    okButton.addActionListener(this);
    getRootPane().setDefaultButton(okButton);

    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(this);
  }

  // public interface to resource-specific configuration data
  public abstract Object getConfig();

  // incquire the return state of the dialog
  public boolean isAccepted()
  {
    return accepted;
  }

  // override to implement special actions performed when clicking the "Create" button
  protected void accept()
  {
    accepted = true;
    setVisible(false);
  }

  // override to implement special actions performed when clicking the "Cancel" button
  protected void reject()
  {
    accepted = false;
    setVisible(false);
  }

  protected JButton acceptButton()
  {
    return okButton;
  }

  protected JButton rejectButton()
  {
    return cancelButton;
  }

//--------------------- Begin Interface ActionListener ---------------------

  public void actionPerformed(ActionEvent event)
  {
    if (event.getSource() == acceptButton())
      accept();
    else if (event.getSource() == rejectButton())
      reject();
  }

//--------------------- End Interface ActionListener ---------------------
}
