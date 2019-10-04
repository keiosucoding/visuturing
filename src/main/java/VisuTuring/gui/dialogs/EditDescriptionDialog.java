package VisuTuring.gui.dialogs;

import VisuTuring.core.TuringMachine;
import VisuTuring.gui.panels.EditDescriptionPanel;
import java.awt.Frame;
import java.awt.event.ActionListener;

public class EditDescriptionDialog extends VTDialog implements ActionListener {
  private EditDescriptionPanel descriptionEditor;

  public EditDescriptionDialog(Frame var1, TuringMachine var2) {
    super(var1, "Edit Description");
    this.descriptionEditor = new EditDescriptionPanel(var2);
    this.init(this.descriptionEditor);
  }

  public String getDescription() {
    return this.descriptionEditor.getDescription();
  }

  public String getName() {
    return this.descriptionEditor.getName();
  }
}
