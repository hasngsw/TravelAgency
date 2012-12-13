/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.robertshippey.travelagency.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Robert
 */
public class Directions extends javax.swing.JFrame {

    private static final String URLFormat = "http://maps.googleapis.com/maps/api/directions/xml?origin=%s&destination=%s&sensor=false&alternatives=false";
    private static final String XPathToHTML = "/DirectionsResponse/route/leg/step/html_instructions";
    private static final String XPathToStatus = "/DirectionsResponse/status";

    /**
     * Creates new form Directions
     */
    public Directions(String origin, String destination) {
        initComponents();
        jLabel1.setText("Alternate directions from " + origin + " to " + destination + ".");
        String htmlDirections = getDirections(origin, destination);
        jEditorPane1.setContentType("text/html");
        jEditorPane1.setText(htmlDirections);
        jEditorPane1.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize
     * the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jEditorPane1);

        jLabel1.setText("jLabel1");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 262, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private String getDirections(String origin, String destination) {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();

            URL url = new URL(String.format(URLFormat, origin.replace(" ", "%20"), destination.replace(" ", "%20")));

            InputSource inputXml = new InputSource(url.openConnection().getInputStream());



            NodeList nodes = (NodeList) xpath.evaluate(XPathToHTML, inputXml, XPathConstants.NODESET);

            String html = "<html><body>";

            if (nodes.getLength() > 0) {


                for (int x = 0; x < nodes.getLength(); x++) {
                    html += "<p>";
                    html += nodes.item(x).getTextContent();
                    html += "</p>";
                }
            } else {
                html += "<p>No alternate directions available. Sorry about that!</p>";
            }

            html += "</body></html>";
            return html;

        } catch (MalformedURLException ex) {
            return "MalformedURLException: " + ex.getMessage();
        } catch (IOException ioe) {
            return "IOException: " + ioe.getMessage();
        } catch (XPathExpressionException xpee) {
            return "XPathExpressionException: " + xpee.getMessage();
        }
    }
}
