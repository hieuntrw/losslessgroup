package com.aptech.labourmanagement.component;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aptech.labourmanagement.entity.Attendance;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

public class ReportAttendanceOnce {

    @SuppressWarnings(value = "unchecked")
    public JPanel getEnumerationViewer(ArrayList<Attendance> arr, boolean isEnumeration, Date dateFrom, Date dateTo) {
        JPanel viewer = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            //THONG TIN PARAMETER
            HashMap parameterMap = new HashMap();

            parameterMap.put("PFIRSTN", arr.get(0).getWorker().getFirstName());
            parameterMap.put("PLASTN", arr.get(0).getWorker().getLastName());
            parameterMap.put("PDAYOB", dateFormat.format(arr.get(0).getWorker().getDayOfBirth()));
            parameterMap.put("PADDRESS", arr.get(0).getWorker().getAddress());
            parameterMap.put("PWORKINGDAY", "Working day");
            parameterMap.put("PTIMEIN", "Time in");
            parameterMap.put("PTIMEOUT", "Time out");
            parameterMap.put("PEXTRA", "Extra shift");
            parameterMap.put("PCOMPLETE", "Complete");
            parameterMap.put("PDATEFROM", dateFormat.format(dateFrom));
            parameterMap.put("PDATETO", dateFormat.format(dateTo));

            ArrayList reportRows = new ArrayList();
            //information labor and salary
            HashMap rowMap = null;
            for (Attendance at : arr) {
                rowMap = new HashMap();
                rowMap.put("FWORKINGDAY", dateFormat.format(at.getWorkDay()));
                rowMap.put("FTIMEIN", at.getShift().getTimeIn());
                rowMap.put("FTIMEOUT", at.getShift().getTimeOut());
                String extra = "";
                if (at.isIsExtraShift()) {
                    extra = "Yes";
                } else {
                    extra = "No";
                }
                rowMap.put("FEXTRA", extra);
                String complete = "";
                if (at.isStatus()) {
                    complete = "Yes";
                } else {
                    complete = "No";
                }
                rowMap.put("FCOMPLETE", complete);

                reportRows.add(rowMap);
            }
            rowMap = new HashMap();
            // parameterMap.put("SO_LUONG", new Integer(reportRows.size()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(getInputStream("attendanceReportOne.jasper"),
                    parameterMap, new JRMapCollectionDataSource(reportRows));
            viewer = new JRViewer(jasperPrint);
            return viewer;
        } catch (Exception ex) {
            System.out.println("Error get report: " + ex.getMessage());
            return viewer;
        }

    }

    private InputStream getInputStream(String reportName) {
        URL url = getClass().getResource("/com/aptech/labourmanagement/report/" + reportName);
        InputStream input = null;

        try {
            input = url.openStream();
            return input;
        } catch (IOException ex) {
            System.out.println("Error get file attendanceReportOne.jasper: " + ex.getMessage());
            return null;
        }
    }
}
