package com.projekat.poslovna.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private Connection connection;
	
	@GetMapping("/warehouseState/{warehouseId}")
	public ResponseEntity<Resource> downloadWarehouseStateReport(@PathVariable int warehouseId){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("WarehouseIdParameter", warehouseId);
		
		try {
			JasperPrint jp = JasperFillManager.fillReport(getClass().getResource("/jasper/Lager_Lista.jasper").openStream(), parameters, connection);
			ByteArrayInputStream bis = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(jp));
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=warehouse-"+ warehouseId +".pdf");
			
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/articleCardAnalytics/{warehouseId}/{articleId}/{fiscalYearId}")
	public ResponseEntity<?> downloadArticleCardAnalyticsReport(@PathVariable int warehouseId, @PathVariable int articleId, @PathVariable int fiscalYearId){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("WarehouseId", warehouseId);
		parameters.put("ArticleId", articleId);
		parameters.put("FiscalYearId", fiscalYearId);
		
		try {
			JasperPrint jp = JasperFillManager.fillReport(getClass().getResource("/jasper/Robna_Kartica_Analitika_Prometa.jasper").openStream(), parameters, connection);
			
			if(jp.getPages().size() == 0) {
				throw new JRException("empty document");
			}
			
			ByteArrayInputStream bis = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(jp));
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=articleCardAnalytics-"+ warehouseId +"-"+ articleId +"-"+ fiscalYearId +".pdf");
			
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No changes yet");
		}
	}
}
