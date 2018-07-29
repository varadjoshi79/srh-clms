package com.srh.DynamicJasper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

	public static void main(String[] args) throws Exception {

		try {
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clms_db?useSSL=false&useTimezone=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "Mahanagar@12");
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("Select project.PROJECT_NAME, project.PROJECT_ID, project.START_DATE,\r\n" + 
					"  project.END_DATE, project.PROJECT_DESCP, project.PROJECT_STATUS, work.WORK_ID,\r\n" + 
					"  work.WORK_TYPE, work.START_DATE, work.END_DATE, work.REQ_PEOPLE,\r\n" + 
					"  work.LABOUR_RATE, work.CONTRACTOR_ID, labourer.LABOURER_TYPE,\r\n" + 
					"  labourer.CARD_ID, labourer.WORK_WORK_ID, labourer.AVAILABLE\r\n" + 
					"From project Right Join\r\n" + 
					"  work On work.PROJECT_PROJECT_ID = project.PROJECT_ID Right Join\r\n" + 
					"  labourer On labourer.WORK_WORK_ID = work.WORK_ID Right Join\r\n" + 
					"  salary On salary.LABOURER_ID_INFO = labourer.ID_INFO");

			FastReportBuilder drb = new FastReportBuilder();

			DynamicReport dr = drb.addColumn("Project Name", "PROJECT_NAME", String.class.getName(), 50)
					.addColumn("Project ID", "PROJECT_ID", String.class.getName(), 50)
					.addColumn("Start Date", "START_DATE", String.class.getName(), 50)
					.addColumn("End Date", "END_DATE", String.class.getName(), 50)
					.addColumn("Project Description", "PROJECT_DESCP", String.class.getName(), 50)
					.addColumn("Project Status", "PROJECT_STATUS", String.class.getName(), 50)
					.addColumn("Work ID", "WORK_ID", String.class.getName(), 50)
					.addColumn("Work Type", "WORK_TYPE", String.class.getName(), 50)
					.addColumn("Start Date", "START_DATE", String.class.getName(), 50)
					.addColumn("End Date", "END_DATE", String.class.getName(), 50)
					.addColumn("Required People", "REQ_PEOPLE", String.class.getName(), 50)
					.addColumn("Labour Rate", "LABOUR_RATE", String.class.getName(), 50)
					.addColumn("Contractor ID", "CONTRACTOR_ID", String.class.getName(), 50)
					.addColumn("Labour Type ", "LABOURER_TYPE", String.class.getName(), 50)
					.addColumn("Card ID", "CARD_ID", String.class.getName(), 50)
					.addColumn("Work ID", "WORK_WORK_ID", String.class.getName(), 50)
					.addColumn("Available", "AVAILABLE", String.class.getName(), 50)
					.setTitle("CLMS REPORT").setSubtitle("This report was generated at " + new Date())
					.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();

			JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(rs);

			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(),
					resultsetdatasource);

			JasperViewer.viewReport(jp);
		}

		catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
