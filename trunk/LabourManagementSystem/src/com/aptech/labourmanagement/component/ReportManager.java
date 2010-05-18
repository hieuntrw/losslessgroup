package com.aptech.labourmanagement.component;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aptech.labourmanagement.entity.HourTotal;
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

public class ReportManager {

    @SuppressWarnings(value = "unchecked")
    public JPanel getEnumerationViewer(ArrayList<HourTotal> arr, boolean isEnumeration, Date dateFrom, Date dateTo) {
        JPanel viewer = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            //THONG TIN PARAMETER
            HashMap parameterMap = new HashMap();

            parameterMap.put("FIRSTN", "First Name");
            parameterMap.put("LASTN", "Last Name");
            parameterMap.put("DAYOB", "Day Of Birth");
            parameterMap.put("HOUR", "Total Hours");
            parameterMap.put("GRADE", "Salary Grade");
            parameterMap.put("SALARY", "Total Salary");
            parameterMap.put("DATEFROM", dateFormat.format(dateFrom));
            parameterMap.put("DATETO", dateFormat.format(dateTo));

            ArrayList reportRows = new ArrayList();
            //information labor and salary
            HashMap rowMap = null;
            for (HourTotal ht : arr) {
                rowMap = new HashMap();
                rowMap.put("FIRSTN", ht.getWorker().getFirstName());
                rowMap.put("LASTN", ht.getWorker().getLastName());
                rowMap.put("DAYOB", dateFormat.format(ht.getWorker().getDayOfBirth()));
                rowMap.put("HOUR", ht.getHourTotal());
                rowMap.put("GRADE", new Float(ht.getWorker().getSalaryGrade().getGradeNum()));
                rowMap.put("SALARY", new Float(ht.getHourTotal() * ht.getWorker().getSalaryGrade().getGradeNum()));

                reportRows.add(rowMap);
            }
            //rowMap = new HashMap();
            // parameterMap.put("SO_LUONG", new Integer(reportRows.size()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(getInputStream("gr_salary.jasper"),
                    parameterMap, new JRMapCollectionDataSource(reportRows));
            viewer = new JRViewer(jasperPrint);
            return viewer;
        } catch (Exception ex) {
            System.out.println("Error get report!" + ex.getMessage());
            return viewer;
        }

    }

    private InputStream getInputStream(String reportName) {
        URL url = getClass().getResource("../report/" + reportName);
        InputStream input = null;

        try {
            input = url.openStream();
            return input;
        } catch (IOException ex) {
            System.out.println("Error get file gr_salary.jasper: " + ex.getMessage());
            return null;
        }
    }
}
