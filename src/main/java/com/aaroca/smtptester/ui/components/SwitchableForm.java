package com.aaroca.smtptester.ui.components;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.apache.commons.lang3.ArrayUtils;

public class SwitchableForm extends JComponent implements ChangeListener {

  private JCheckBox checkBox;
  private JPanel panel;
  private List<JComponent> fields;

  public SwitchableForm(String label, String title, JComponent... fields) {
    init();
    buildComponents(label, title, fields);
    addComponents();
  }

  @Override
  public void stateChanged(ChangeEvent event) {
    if (event.getSource() == checkBox) {
      toggle();
    }
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);

    checkBox.setEnabled(enabled);
    panel.setEnabled(enabled);
    fields.forEach(field -> field.setEnabled(enabled));
  }

  public void clear() {
    checkBox.setSelected(false);
  }

  private void init() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setAlignmentX(Component.LEFT_ALIGNMENT);
  }

  private void buildComponents(String label, String title, JComponent... fields) {
    if (ArrayUtils.isEmpty(fields)) {
      throw new IllegalArgumentException("Provide at least one field.");
    }

    this.fields = Arrays.stream(fields).collect(Collectors.toList());
    this.checkBox = new JCheckBox(label);
    this.checkBox.addChangeListener(this);
    this.panel = new JPanel();
    this.panel.setBorder(BorderFactory.createTitledBorder(title));
    this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
    this.panel.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.panel.setEnabled(false);
  }

  private void addComponents() {
    add(this.checkBox);
    add(this.panel);
    this.fields.forEach(field -> {
      field.setEnabled(false);
      this.panel.add(field);
    });
  }

  private void toggle() {
    this.panel.setEnabled(this.checkBox.isSelected());
    this.fields.forEach(field -> field.setEnabled(this.checkBox.isSelected()));
  }

  public boolean isSelected() {
    return this.checkBox.isSelected();
  }
}
