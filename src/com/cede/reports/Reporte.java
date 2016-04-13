package com.cede.reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Reporte {
    public String route;
    Connection connect;
    String reporte;
    String reporteSalida;
    public Reporte(){
        route = "src/com/cede/db/estadia.db";
        reporte = "src/com/cede/reports/productosReport.jasper";
        reporteSalida = "src/com/cede/reports/RequisitionReport.jasper";
    }
    public void ReporteNuevo(Map parametros)throws SQLException, ClassNotFoundException, JRException {
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:"+route);
        JasperReport report = null;
        report = (JasperReport) JRLoader.loadObjectFromFile(reporte);
        JasperPrint jp = JasperFillManager.fillReport(report, parametros, connect);
        JasperViewer ver = new JasperViewer(jp, false);
        ver.setVisible(true);
    }
    
    public void ReporteRequisicion(Map parametros )throws SQLException, ClassNotFoundException, JRException{
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:"+route);
        JasperReport report = null;
        report = (JasperReport) JRLoader.loadObjectFromFile(reporteSalida);
        JasperPrint jp = JasperFillManager.fillReport(report, parametros, connect);
        JasperViewer ver = new JasperViewer(jp, false);
        ver.setVisible(true);
    }
}
