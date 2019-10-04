package VisuTuring.gui;

import VisuTuring.core.Transition;
import VisuTuring.core.TuringMachine;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TransitionFrame extends JDialog implements ActionListener {
  Transition transition;
  JList currentSymbol;
  JList task;

  public TransitionFrame(TuringMachine var1, Transition var2) {
    super(new Frame(), true);
    this.setResizable(false);
    this.setUndecorated(true);
    JLayeredPane var3 = new JLayeredPane();
    JLabel var4 = new JLabel(this.createImageIcon("/res/bitmaps/transframe.gif"));
    var4.setBounds(0, 0, (int)var4.getPreferredSize().getWidth(), (int)var4.getPreferredSize().getHeight());
    Container var5 = this.getContentPane();
    var5.add(var3);
    var3.add(var4, JLayeredPane.DEFAULT_LAYER);
    JButton var6 = this.createMediaButton("Update", "tick");
    var6.setBounds(258, 19, 22, 22);
    var3.add(var6, JLayeredPane.POPUP_LAYER);
    this.transition = new Transition(var2);
    JLabel var7 = new JLabel(var2.getCurrentState());
    var7.setForeground(Color.BLACK);
    var7.setFont(new Font("Helvetica", 1, 15));
    var7.setHorizontalAlignment(0);
    var7.setBounds(10, 19, 60, 20);
    var3.add(var7, JLayeredPane.POPUP_LAYER);
    JLabel var8 = new JLabel(var2.getNextState());
    var8.setFont(new Font("Helvetica", 1, 15));
    var8.setForeground(Color.BLACK);
    var8.setHorizontalAlignment(0);
    var8.setBounds(131, 19, 60, 20);
    var3.add(var8, JLayeredPane.POPUP_LAYER);
    Vector var9 = new Vector(var1.getAlphabet());
    this.currentSymbol = new JList(var9);
    this.currentSymbol.setFont(new Font("Helvetica", 1, 15));
    JScrollPane var10 = new JScrollPane(this.currentSymbol);
    var10.setBounds(70, 19, 60, 20);
    this.currentSymbol.setBounds(70, 19, 60, 20);
    var10.setWheelScrollingEnabled(true);
    var3.add(var10, JLayeredPane.POPUP_LAYER);
    this.currentSymbol.setSelectedValue("" + var2.getCurrentSymbol(), true);
    Vector var11 = new Vector(var1.getAlphabet());
    var11.remove(new String("⊳"));
    var11.add(new String("←"));
    var11.add(new String("→"));
    this.task = new JList(var11);
    this.task.setFont(new Font("Helvetica", 1, 15));
    JScrollPane var12 = new JScrollPane(this.task);
    var12.setBounds(192, 19, 60, 20);
    var3.add(var12, JLayeredPane.POPUP_LAYER);
    this.task.setSelectedValue("" + var2.getTask(), true);
    var3.setPreferredSize(new Dimension((int)var4.getPreferredSize().getWidth(), (int)var4.getPreferredSize().getHeight()));
    this.pack();
  }

  JButton createMediaButton(String var1, String var2) {
    JButton var3 = new JButton();
    var3.setCursor(new Cursor(12));
    var3.setToolTipText(var1);
    var3.setName(var1);
    var3.setOpaque(false);
    var3.setFocusPainted(false);
    var3.setBorderPainted(false);
    var3.setContentAreaFilled(false);
    var3.setIcon(this.createImageIcon("/res/buttons/" + var2 + ".gif"));
    var3.setPreferredSize(new Dimension(22, 22));
    var3.addActionListener(this);
    return var3;
  }

  public ImageIcon createImageIcon(String var1) {
    return new ImageIcon(this.getClass().getResource(var1));
  }

  public void actionPerformed(ActionEvent var1) {
    this.setVisible(false);
  }

  public Transition getTransition() {
    if (this.currentSymbol.getSelectedIndex() > -1) {
      this.transition.setCurrentSymbol(this.currentSymbol.getSelectedValue().toString().charAt(0));
    } else {
      this.transition.setCurrentSymbol('⊔');
    }

    if (this.task.getSelectedIndex() > -1) {
      this.transition.setTask(this.task.getSelectedValue().toString().charAt(0));
    } else {
      this.transition.setTask('⊔');
    }

    return this.transition.getCurrentSymbol() == 8883 && this.transition.getTask() != 8594 ? null : this.transition;
  }
}
