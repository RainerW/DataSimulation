/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SimulatorFrame.java
 *
 * Created on 04.10.2009, 21:44:23
 */
package de.bitnoise.datasim.gui;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import de.bitnoise.datasim.SimulatorControllerProvider;
import de.bitnoise.datasim.gui.adapter.EventTable;
import de.bitnoise.datasim.gui.adapter.ModelTable;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorModelListener;

/**
 * 
 * @author rainer
 */
public class SimulatorFrame extends javax.swing.JFrame implements
		SimulatorModelListener {

	/** Creates new form SimulatorFrame */
	public SimulatorFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    eventsTable = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jProgressBar1 = new javax.swing.JProgressBar();
    jPanel2 = new javax.swing.JPanel();
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

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        formWindowClosed(evt);
      }
    });

    eventsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane1.setViewportView(eventsTable);

    jLabel1.setText("Next Events in Queue :");

    jLabel2.setText("Simulation speed : ");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2)
        .addGap(33, 33, 33)
        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(546, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addContainerGap(703, Short.MAX_VALUE))
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(78, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jTabbedPane1.addTab("Events", jPanel1);

    modelTableOther.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane2.setViewportView(modelTableOther);

    javax.swing.GroupLayout tabOtherLayout = new javax.swing.GroupLayout(tabOther);
    tabOther.setLayout(tabOtherLayout);
    tabOtherLayout.setHorizontalGroup(
      tabOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
    );
    tabOtherLayout.setVerticalGroup(
      tabOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
    );

    jTabbedPane2.addTab("Running", tabOther);

    modelTableErrorFail.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane3.setViewportView(modelTableErrorFail);

    javax.swing.GroupLayout tabErrorFailLayout = new javax.swing.GroupLayout(tabErrorFail);
    tabErrorFail.setLayout(tabErrorFailLayout);
    tabErrorFailLayout.setHorizontalGroup(
      tabErrorFailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
    );
    tabErrorFailLayout.setVerticalGroup(
      tabErrorFailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
    );

    jTabbedPane2.addTab("Error or Fails", tabErrorFail);

    modelTableOk.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane4.setViewportView(modelTableOk);

    javax.swing.GroupLayout tabErrorOkLayout = new javax.swing.GroupLayout(tabErrorOk);
    tabErrorOk.setLayout(tabErrorOkLayout);
    tabErrorOkLayout.setHorizontalGroup(
      tabErrorOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
    );
    tabErrorOkLayout.setVerticalGroup(
      tabErrorOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
    );

    jTabbedPane2.addTab("Completed", tabErrorOk);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Model", jPanel2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	SimulatorControllerProvider myController;
	private ModelTable adapterRunning;
	private ModelTable adapterError;
	private ModelTable adapterOk;

	private void formWindowClosed(java.awt.event.WindowEvent evt)// GEN-FIRST:event_formWindowClosed
	{// GEN-HEADEREND:event_formWindowClosed
		myController.stop();
	}// GEN-LAST:event_formWindowClosed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SimulatorFrame().setVisible(true);
			}
		});
	}

	public void showMainFrame(SimulatorControllerProvider controller) {
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
			adapterRunning = new ModelTable(controller,ModelState.UNDEFINED,ModelState.RUNNING);
			modelTableOther.setModel(adapterRunning);
			adapterRunning.setTableWidth(modelTableOther.getColumnModel());
		}
		{
			adapterError = new ModelTable(controller,ModelState.ERROR,ModelState.FAIL);
			modelTableErrorFail.setModel(adapterError);
			adapterError.setTableWidth(modelTableErrorFail.getColumnModel());
		}
		{
			adapterOk = new ModelTable(controller,ModelState.OK);
			modelTableOk.setModel(adapterOk);
			adapterOk.setTableWidth(modelTableOk.getColumnModel());
		}
		controller.registerModelListener(this);
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable eventsTable;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JProgressBar jProgressBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTabbedPane jTabbedPane2;
  private javax.swing.JTable modelTableErrorFail;
  private javax.swing.JTable modelTableOk;
  private javax.swing.JTable modelTableOther;
  private javax.swing.JPanel tabErrorFail;
  private javax.swing.JPanel tabErrorOk;
  private javax.swing.JPanel tabOther;
  // End of variables declaration//GEN-END:variables

	public void eventSimulatorModelChanged(SimulatorModel changedModel) {
//		// TODO: Nur deregisitieren wenn liste auch wirklich gewechselt wird !
//		if (changedModel.removeListener(adapterRunning)) {
//			adapterRunning.fireTableDataChanged();
//		}
//		if (changedModel.removeListener(adapterError)) {
//			adapterError.fireTableDataChanged();
//		}
//		if (changedModel.removeListener(adapterOk)) {
//			adapterOk.fireTableDataChanged();
//		}
//
//		// Register correct adapters again
//		switch (changedModel.getModelState()) {
//		case OK:
//			changedModel.addModelListener(adapterOk);
//			adapterOk.fireTableDataChanged();
//			break;
//		case ERROR:
//		case FAIL:
//			changedModel.addModelListener(adapterError);
//			adapterError.fireTableDataChanged();
//			break;
//		default:
//			changedModel.addModelListener(adapterRunning);
//			adapterRunning.fireTableDataChanged();
//		}
	}
}
