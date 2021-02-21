package com.aaroca.smtptester.ui.components;

import com.aaroca.smtptester.services.I18nService;
import com.aaroca.smtptester.services.impl.DefaultI18nService;
import com.aaroca.smtptester.utils.Constants.Ui;
import com.aaroca.smtptester.utils.logging.JConsoleLoggingHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class JConsole extends JPanel implements ActionListener {

  private final I18nService i18nService;

  private JButton scrollToBottomButton;
  private JButton clearLogButton;
  private JButton saveLogButton;
  private JScrollPane scrollPane;
  private JTextArea logArea;
  private JConsoleLoggingHandler loggingHandler;

  public JConsole() {
    this.i18nService = DefaultI18nService.getInstance();

    init();
    buildComponents();
    addComponents();
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    final Object eventSource = event.getSource();

    if (eventSource == scrollToBottomButton) {
      scrollToBottom();
    } else if (eventSource == clearLogButton) {
      clear();
    } else if (eventSource == saveLogButton) {

    }
  }

  private void init() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createTitledBorder(getI18nService().getString("main.trace")));
  }

  private void buildComponents() {
    this.scrollToBottomButton = new JButton(IconFontSwing.buildIcon(FontAwesome.SORT_AMOUNT_ASC,
        Ui.SMALL_ICON_SIZE, Ui.BUTTON_COLOR));
    this.scrollToBottomButton.setToolTipText(getI18nService().getString("console.scroll"));
    this.scrollToBottomButton.addActionListener(this);

    this.clearLogButton = new JButton(IconFontSwing.buildIcon(FontAwesome.TRASH_O,
        Ui.SMALL_ICON_SIZE, Ui.BUTTON_COLOR));
    this.clearLogButton.setToolTipText(getI18nService().getString("console.clear"));
    this.clearLogButton.addActionListener(this);

    this.saveLogButton = new JButton(IconFontSwing.buildIcon(FontAwesome.FLOPPY_O,
        Ui.SMALL_ICON_SIZE, Ui.BUTTON_COLOR));
    this.saveLogButton.setToolTipText(getI18nService().getString("console.save"));
    this.saveLogButton.addActionListener(this);

    this.logArea = new JTextArea(10, 20);
    this.logArea.setEditable(false);
    this.logArea.setBackground(Color.BLACK);

    this.scrollPane = new JScrollPane(this.logArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.scrollPane.setBorder(BorderFactory.createEmptyBorder());

    this.loggingHandler = new JConsoleLoggingHandler(this.logArea);
  }

  private void addComponents() {
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    buttonsPanel.add(scrollToBottomButton);
    buttonsPanel.add(clearLogButton);
    buttonsPanel.add(saveLogButton);

    add(buttonsPanel);
    add(scrollPane);
  }

  private void clear() {
    getLoggingHandler().flush();
  }

  private void scrollToBottom() {
    logArea.setCaretPosition(logArea.getDocument().getLength());
  }

  protected I18nService getI18nService() {
    return i18nService;
  }

  public JConsoleLoggingHandler getLoggingHandler() {
    return loggingHandler;
  }
}
