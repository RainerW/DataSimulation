/*
 * To change this template, choose Tools | Templates and open the
 * template in the editor.
 */

/*
 * SimulatorFrame.java
 * 
 * Created on 04.10.2009, 21:44:23
 */
package de.bitnoise.datasim.ui.gui;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import de.bitnoise.datasim.controller.SimulatorControllerProvider;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorModelListener;
import de.bitnoise.datasim.ui.adapter.DetailTable;
import de.bitnoise.datasim.ui.adapter.EventTable;
import de.bitnoise.datasim.ui.adapter.ModelTable;

/**
 * 
 * @author rainer
 */
public class SimulatorFrame extends javax.swing.JFrame implements
    SimulatorModelListener
{

  /** Creates new form SimulatorFrame */
  public SimulatorFrame()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize
   * the form. WARNING: Do NOT modify this code. The content of this
   * method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed"
  // <editor-fold defaultstate="collapsed"
  // <editor-fold defaultstate="collapsed"
  // <editor-fold defaultstate="collapsed"
  // <editor-fold defaultstate="collapsed"
  // <editor-fold defaultstate="collapsed"
  // desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    panelGenerators = new javax.swing.JPanel();
    checkRunning = new javax.swing.JCheckBox();
    speedSlider = new javax.swing.JSlider();
    jLabel4 = new javax.swing.JLabel();
    speedText = new javax.swing.JLabel();
    jScrollPane5 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    panelEvents = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    eventsTable = new javax.swing.JTable();
    panelTrackers = new javax.swing.JPanel();
    panelModel = new javax.swing.JPanel();
    jTabbedPane2 = new javax.swing.JTabbedPane();
    tabOther = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    modelTableOther = new javax.swing.JTable();
    tabErrorFail = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    modelTableErrorFail = new javax.swing.JTable();
    tabErrorOk = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    modelTableOk = new javax.swing.JTable();
    jScrollPane6 = new javax.swing.JScrollPane();
    tableDetails = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter()
    {
      public void windowClosed(java.awt.event.WindowEvent evt)
      {
        formWindowClosed(evt);
      }
    });

    checkRunning.setText("Run Simulation");
    checkRunning.addChangeListener(new javax.swing.event.ChangeListener()
    {
      public void stateChanged(javax.swing.event.ChangeEvent evt)
      {
        checkRunningStateChanged(evt);
      }
    });

    speedSlider.setMaximum(240);
    speedSlider.setMinimum(1);
    speedSlider.setValue(60);
    speedSlider.addChangeListener(new javax.swing.event.ChangeListener()
    {
      public void stateChanged(javax.swing.event.ChangeEvent evt)
      {
        speedSliderStateChanged(evt);
      }
    });

    jLabel4.setText("Speed:");

    speedText.setText("60 times per Minute");

    jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
        {null, null, null, null}, {null, null, null, null},
        {null, null, null, null}, {null, null, null, null}}, new String[] {
        "Title 1", "Title 2", "Title 3", "Title 4"}));
    jScrollPane5.setViewportView(jTable1);

    jButton1.setText("Clear System");
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panelGeneratorsLayout =
        new javax.swing.GroupLayout(panelGenerators);
    panelGenerators.setLayout(panelGeneratorsLayout);
    panelGeneratorsLayout
        .setHorizontalGroup(panelGeneratorsLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panelGeneratorsLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        panelGeneratorsLayout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 669,
                                Short.MAX_VALUE)
                            .addGroup(
                                panelGeneratorsLayout
                                    .createSequentialGroup()
                                    .addComponent(checkRunning)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        panelGeneratorsLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                speedSlider,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                263,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(
                                                panelGeneratorsLayout
                                                    .createSequentialGroup()
                                                    .addGap(295, 295, 295)
                                                    .addComponent(speedText)))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1).addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)))));
    panelGeneratorsLayout
        .setVerticalGroup(panelGeneratorsLayout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panelGeneratorsLayout.createSequentialGroup().addGroup(
                    panelGeneratorsLayout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        panelGeneratorsLayout.createSequentialGroup().addGap(
                            12, 12, 12).addGroup(
                            panelGeneratorsLayout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkRunning).addComponent(
                                    jLabel4).addComponent(speedText)
                                .addComponent(jButton1))).addGroup(
                        panelGeneratorsLayout.createSequentialGroup()
                            .addContainerGap().addComponent(speedSlider,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane5,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 301,
                        Short.MAX_VALUE)));

    jTabbedPane1.addTab("Generators", panelGenerators);

    eventsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] { {null, null, null, null}, {null, null, null, null},
            {null, null, null, null}, {null, null, null, null}}, new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"}));
    jScrollPane1.setViewportView(eventsTable);

    javax.swing.GroupLayout panelEventsLayout =
        new javax.swing.GroupLayout(panelEvents);
    panelEvents.setLayout(panelEventsLayout);
    panelEventsLayout.setHorizontalGroup(panelEventsLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1,
        javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE));
    panelEventsLayout.setVerticalGroup(panelEventsLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1,
        javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE));

    jTabbedPane1.addTab("Events", panelEvents);

    javax.swing.GroupLayout panelTrackersLayout =
        new javax.swing.GroupLayout(panelTrackers);
    panelTrackers.setLayout(panelTrackersLayout);
    panelTrackersLayout.setHorizontalGroup(panelTrackersLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(
            0, 679, Short.MAX_VALUE));
    panelTrackersLayout.setVerticalGroup(panelTrackersLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(
            0, 342, Short.MAX_VALUE));

    jTabbedPane1.addTab("Tracker", panelTrackers);

    modelTableOther.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] { {null, null, null, null}, {null, null, null, null},
            {null, null, null, null}, {null, null, null, null}}, new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"}));
    modelTableOther.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        modelTableOtherMouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(modelTableOther);

    javax.swing.GroupLayout tabOtherLayout =
        new javax.swing.GroupLayout(tabOther);
    tabOther.setLayout(tabOtherLayout);
    tabOtherLayout.setHorizontalGroup(tabOtherLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane2,
        javax.swing.GroupLayout.Alignment.TRAILING,
        javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE));
    tabOtherLayout.setVerticalGroup(tabOtherLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane2,
        javax.swing.GroupLayout.Alignment.TRAILING,
        javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));

    jTabbedPane2.addTab("Running", tabOther);

    modelTableErrorFail.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] { {null, null, null, null}, {null, null, null, null},
            {null, null, null, null}, {null, null, null, null}}, new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"}));
    modelTableErrorFail.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        modelTableErrorFailMouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(modelTableErrorFail);

    javax.swing.GroupLayout tabErrorFailLayout =
        new javax.swing.GroupLayout(tabErrorFail);
    tabErrorFail.setLayout(tabErrorFailLayout);
    tabErrorFailLayout.setHorizontalGroup(tabErrorFailLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 674,
            Short.MAX_VALUE));
    tabErrorFailLayout.setVerticalGroup(tabErrorFailLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane3,
        javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));

    jTabbedPane2.addTab("Error or Fails", tabErrorFail);

    modelTableOk.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] { {null, null, null, null}, {null, null, null, null},
            {null, null, null, null}, {null, null, null, null}}, new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"}));
    modelTableOk.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        modelTableOkMouseClicked(evt);
      }
    });
    jScrollPane4.setViewportView(modelTableOk);

    javax.swing.GroupLayout tabErrorOkLayout =
        new javax.swing.GroupLayout(tabErrorOk);
    tabErrorOk.setLayout(tabErrorOkLayout);
    tabErrorOkLayout.setHorizontalGroup(tabErrorOkLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4,
        javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE));
    tabErrorOkLayout.setVerticalGroup(tabErrorOkLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4,
        javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));

    jTabbedPane2.addTab("Completed", tabErrorOk);

    tableDetails.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] { {null, null, null, null}, {null, null, null, null},
            {null, null, null, null}, {null, null, null, null}}, new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"}));
    tableDetails.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        tableDetailsMouseClicked(evt);
      }
    });
    jScrollPane6.setViewportView(tableDetails);

    javax.swing.GroupLayout panelModelLayout =
        new javax.swing.GroupLayout(panelModel);
    panelModel.setLayout(panelModelLayout);
    panelModelLayout.setHorizontalGroup(panelModelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane2,
        javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE).addGroup(
        panelModelLayout.createSequentialGroup().addComponent(jScrollPane6,
            javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE).addGap(
            10, 10, 10)));
    panelModelLayout.setVerticalGroup(panelModelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        panelModelLayout.createSequentialGroup().addComponent(jTabbedPane2,
            javax.swing.GroupLayout.PREFERRED_SIZE, 265,
            javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
            javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
            jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 71,
            Short.MAX_VALUE)));

    jTabbedPane1.addTab("Model", panelModel);

    javax.swing.GroupLayout layout =
        new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1,
        javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1,
        javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void tableDetailsMouseClicked(java.awt.event.MouseEvent evt)
  {// GEN-FIRST:event_tableDetailsMouseClicked

  }// GEN-LAST:event_tableDetailsMouseClicked

  private void modelTableErrorFailMouseClicked(java.awt.event.MouseEvent evt)
  {// GEN-FIRST:event_modelTableErrorFailMouseClicked
    if (evt.getSource() instanceof JTable)
    {
      JTable table = (JTable) evt.getSource();
      if (table.getModel() instanceof ModelTable)
      {
        ModelTable adapter = (ModelTable) table.getModel();
        int row = table.getSelectedRow();
        if (row != -1)
        {
          SimulatorModel model = adapter.getModelAt(row);
          showDetails(model);
        }
      }

    }
  }// GEN-LAST:event_modelTableErrorFailMouseClicked

  private void modelTableOkMouseClicked(java.awt.event.MouseEvent evt)
  {// GEN-FIRST:event_modelTableOkMouseClicked
    if (evt.getSource() instanceof JTable)
    {
      JTable table = (JTable) evt.getSource();
      if (table.getModel() instanceof ModelTable)
      {
        ModelTable adapter = (ModelTable) table.getModel();
        int row = table.getSelectedRow();
        if (row != -1)
        {
          SimulatorModel model = adapter.getModelAt(row);
          showDetails(model);
        }
      }

    }
  }// GEN-LAST:event_modelTableOkMouseClicked

  private void checkRunningStateChanged(javax.swing.event.ChangeEvent evt)
  {// GEN-FIRST:event_checkRunningStateChanged
    boolean state = checkRunning.isSelected();
    myController.pause(!state);
  }// GEN-LAST:event_checkRunningStateChanged

  private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt)
  {// GEN-FIRST:event_speedSliderStateChanged
    int value = speedSlider.getValue();
    myController.setEventsPerSecond(value);
    speedText.setText("" + value + " ticks per minute");
  }// GEN-LAST:event_speedSliderStateChanged

  private void modelTableOtherMouseClicked(java.awt.event.MouseEvent evt)
  {// GEN-FIRST:event_modelTableOtherMouseClicked
    if (evt.getSource() instanceof JTable)
    {
      JTable table = (JTable) evt.getSource();
      if (table.getModel() instanceof ModelTable)
      {
        ModelTable adapter = (ModelTable) table.getModel();
        int row = table.getSelectedRow();
        if (row != -1)
        {
          SimulatorModel model = adapter.getModelAt(row);
          showDetails(model);
        }
      }

    }
  }// GEN-LAST:event_modelTableOtherMouseClicked

  private void showDetails(SimulatorModel model)
  {
    tableDetails.setModel(new DetailTable(model));
  }

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
  {// GEN-FIRST:event_jButton1ActionPerformed
    myController.executeResetEvent();
  }// GEN-LAST:event_jButton1ActionPerformed

  SimulatorControllerProvider myController;

  private ModelTable adapterRunning;

  private ModelTable adapterError;

  private ModelTable adapterOk;

  private void formWindowClosed(java.awt.event.WindowEvent evt)// GEN-FIRST:event_formWindowClosed
  {// GEN-HEADEREND:event_formWindowClosed
    myController.stop();
  }// GEN-LAST:event_formWindowClosed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new SimulatorFrame().setVisible(true);
      }
    });
  }

  public void showMainFrame(SimulatorControllerProvider controller)
  {
    myController = controller;
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);

    // Events Table View
    {
      EventTable adapter = new EventTable(controller);
      eventsTable.setModel(adapter);
      adapter.setTableWidth(eventsTable.getColumnModel());
    }
    // Model Table Views
    {
      adapterRunning =
          new ModelTable(controller, ModelState.UNDEFINED, ModelState.RUNNING);
      modelTableOther.setModel(adapterRunning);
      adapterRunning.setTableWidth(modelTableOther.getColumnModel());
    }
    {
      adapterError =
          new ModelTable(controller, ModelState.ERROR, ModelState.FAIL);
      modelTableErrorFail.setModel(adapterError);
      adapterError.setTableWidth(modelTableErrorFail.getColumnModel());
    }
    {
      adapterOk = new ModelTable(controller, ModelState.OK);
      modelTableOk.setModel(adapterOk);
      adapterOk.setTableWidth(modelTableOk.getColumnModel());
    }
    controller.registerModelListener(this);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox checkRunning;

  private javax.swing.JTable eventsTable;

  private javax.swing.JButton jButton1;

  private javax.swing.JLabel jLabel4;

  private javax.swing.JScrollPane jScrollPane1;

  private javax.swing.JScrollPane jScrollPane2;

  private javax.swing.JScrollPane jScrollPane3;

  private javax.swing.JScrollPane jScrollPane4;

  private javax.swing.JScrollPane jScrollPane5;

  private javax.swing.JScrollPane jScrollPane6;

  private javax.swing.JTabbedPane jTabbedPane1;

  private javax.swing.JTabbedPane jTabbedPane2;

  private javax.swing.JTable jTable1;

  private javax.swing.JTable modelTableErrorFail;

  private javax.swing.JTable modelTableOk;

  private javax.swing.JTable modelTableOther;

  private javax.swing.JPanel panelEvents;

  private javax.swing.JPanel panelGenerators;

  private javax.swing.JPanel panelModel;

  private javax.swing.JPanel panelTrackers;

  private javax.swing.JSlider speedSlider;

  private javax.swing.JLabel speedText;

  private javax.swing.JPanel tabErrorFail;

  private javax.swing.JPanel tabErrorOk;

  private javax.swing.JPanel tabOther;

  private javax.swing.JTable tableDetails;

  // End of variables declaration//GEN-END:variables

  public void eventSimulatorModelChanged(SimulatorModel changedModel)
  {
    // // TODO: Nur deregisitieren wenn liste auch wirklich gewechselt
    // wird !
    // if (changedModel.removeListener(adapterRunning)) {
    // adapterRunning.fireTableDataChanged();
    // }
    // if (changedModel.removeListener(adapterError)) {
    // adapterError.fireTableDataChanged();
    // }
    // if (changedModel.removeListener(adapterOk)) {
    // adapterOk.fireTableDataChanged();
    // }
    //
    // // Register correct adapters again
    // switch (changedModel.getModelState()) {
    // case OK:
    // changedModel.addModelListener(adapterOk);
    // adapterOk.fireTableDataChanged();
    // break;
    // case ERROR:
    // case FAIL:
    // changedModel.addModelListener(adapterError);
    // adapterError.fireTableDataChanged();
    // break;
    // default:
    // changedModel.addModelListener(adapterRunning);
    // adapterRunning.fireTableDataChanged();
    // }
  }
}
