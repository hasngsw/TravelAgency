/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.robertshippey.travelagency.client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.StringReader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.xml.ws.WebServiceException;
import net.robertshippey.travelagency.data.Flight;
import net.robertshippey.travelagency.data.ListOfFlights;

/**
 *
 * @author Robert
 */
public class Main extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private String currency = "GBP";
    private FlightTableModel flightTableModel;
    private String[] currencyCodes;
    private boolean amSearching = false;

    /**
     * Creates new form Main
     */
    public Main() {
        try {
            flightTableModel = new FlightTableModel(getAllFlights());
            currencyCodes = getCurrencyCodes().toArray(new String[0]);
        } catch (WebServiceException wse) {
            JOptionPane.showMessageDialog(null, "Could not connect to core web service. Stopping!");
            System.exit(1);
        }

        initComponents();

        jTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Flight f = flightTableModel.getRow(row);
                    new Details(f).setVisible(true);
                }
            }
        });

        currenciesComboBox.setSelectedIndex(15);

    }

    private void updateTableModel() {
        try {
            ListOfFlights list;
            if (amSearching) {
                list = doSearch();
            } else {
                list = getAllFlights();
            }
            flightTableModel = new FlightTableModel(list);
            jTable2.setModel(flightTableModel);
        } catch (WebServiceException wse) {
            JOptionPane.showMessageDialog(this, "Could not contact web wervice!");
        }
    }

    private TableModel getTableModel() {
        return flightTableModel;
    }

    /**
     * This method is called from within the constructor to initialize
     * the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currenciesComboBox = new javax.swing.JComboBox();
        currenciesSetButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        originText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        destinationText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        directFlightBox = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel Agency");

        currenciesComboBox.setModel(new DefaultComboBoxModel(currencyCodes));

        currenciesSetButton.setText("Set Currency");
        currenciesSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currenciesSetButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Show all");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showAllClickListener(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Origin:");

        jLabel6.setText("Destination:");

        jLabel7.setText("Date:");

        directFlightBox.setText("Direct flight?");

        jTable2.setModel(getTableModel());
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Search!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(currenciesComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(currenciesSetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel5)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(originText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel7)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(dateText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel6)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(destinationText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(0, 0, Short.MAX_VALUE))
                                    .add(layout.createSequentialGroup()
                                        .add(directFlightBox)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jButton1))))
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(currenciesSetButton)
                    .add(currenciesComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(originText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(destinationText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(dateText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(directFlightBox)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currenciesSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currenciesSetButtonActionPerformed
        // TODO add your handling code here:
        currency = currenciesComboBox.getModel().getSelectedItem().toString().split(" - ")[0];
        updateTableModel();
    }//GEN-LAST:event_currenciesSetButtonActionPerformed

    private void showAllClickListener(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showAllClickListener
    }//GEN-LAST:event_showAllClickListener

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        amSearching = false;
        updateTableModel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        amSearching = true;
        updateTableModel();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox currenciesComboBox;
    private javax.swing.JButton currenciesSetButton;
    private javax.swing.JTextField dateText;
    private javax.swing.JTextField destinationText;
    private javax.swing.JCheckBox directFlightBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField originText;
    // End of variables declaration//GEN-END:variables

    private ListOfFlights doSearch() {
        amSearching = true;
        String origin = originText.getText();
        String destination = destinationText.getText();
        String date = dateText.getText();
        String direct = directFlightBox.isSelected() ? "yes" : "no";
        ListOfFlights searchResults = searchFlights(origin, destination, date, direct);
        return searchResults;
    }

    private class FlightTableModel implements TableModel {

        @Override
        public void addTableModelListener(TableModelListener tl) {
            //throw new UnsupportedOperationException("addTableModelListener: Not supported yet.");
        }

        @Override
        public void removeTableModelListener(TableModelListener tl) {
            //throw new UnsupportedOperationException("removeTableModelListener: Not supported yet.");
        }
        //implimented
        private Flight[] flightList;
        private final String[] columns = {"Origin",
            "Destination", "Airline", "Available Seats", "Number of Connections",
            "Cost"
        };

        public FlightTableModel(ListOfFlights list) {
            flightList = list.getFlight().toArray(new Flight[0]);
        }

        public Flight getRow(int i) {
            return flightList[i];
        }

        @Override
        public void setValueAt(Object o, int i, int i1) {
        }

        @Override
        public String getColumnName(int i) {
            return columns[i];
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

        @Override
        public int getRowCount() {
            return flightList.length;
        }

        @Override
        public Class<?> getColumnClass(int i) {
            return String.class;
        }

        @Override
        public Object getValueAt(int flight, int column) {
            Flight f = flightList[flight];
            switch (column) {
                case 0:
                    return f.getOriginCity();
                case 1:
                    return f.getDestinationCity();
                case 2:
                    return f.getAirline();
                case 3:
                    return String.valueOf(f.getAvailableSeats());
                case 4:
                    return String.valueOf(f.getNumberOfConnections());
                case 5:
                    String monies = String.format("%.2f", f.getFare().getAmount());
                    return monies;
            }
            return "Error";
        }
    }

    private static String getAllFlightsXML(String currency) throws WebServiceException {
        net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService_Service service = new net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService_Service();
        net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService port = service.getTravelAgencyWebServicePort();
        return port.getAllFlights(currency);
    }

    private ListOfFlights getAllFlights() throws WebServiceException {
        String xml = getAllFlightsXML(currency);
        ListOfFlights list = stringToXMLObj(xml);
        return list;

    }

    private static String searchFlightsToXML(String origin, String desdination, String date, String directFlight, String currency) throws WebServiceException {
        net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService_Service service = new net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService_Service();
        net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService port = service.getTravelAgencyWebServicePort();
        return port.searchFlights(origin, desdination, date, directFlight, currency);
    }

    private ListOfFlights searchFlights(String origin, String destination, String date, String directFlight) throws WebServiceException {
        String xml = searchFlightsToXML(origin, destination, date, directFlight, currency);
        ListOfFlights list = stringToXMLObj(xml);
        return list;
    }

    private static ListOfFlights stringToXMLObj(String xml) {
        ListOfFlights list = new ListOfFlights();
        StringReader sr = new StringReader(xml);
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(list.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            list = (ListOfFlights) unmarshaller.unmarshal(sr); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return list;
    }

    private static java.util.List<java.lang.String> getCurrencyCodes() throws WebServiceException {
        net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService_Service service = new net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService_Service();
        net.robertshippey.travelagency.webservice.reference.TravelAgencyWebService port = service.getTravelAgencyWebServicePort();
        return port.getCurrencyCodes();
    }
}
