package com.projekat.poslovna.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Prometni dokument
 * 
 * @author alowishusad
 *
 */
public class Document {
	private int id;
	private char type; // TODO ovaj tip bi mogao biti poseban entitet, takodje u analitici robne
						// kartice
	private int serialNumber; // TODO sta je ovo????
	private Timestamp formedOn;
	private Timestamp bookedOn;
	private char status; // TODO takodje bi ovaj status mogao biti poseban entitet????

	// samo jedan od ova dva bi smeo biti not null!! to ce neki trigger na bazi
	// ili...
	private BusinessPartner businessPartner;
	private Warehouse warehouse;

	private Warehouse mandatoryWarehouse; // moramo imati bar jedan warehouse
	private FiscalYear fiscalYear;
	private Set<DocumentItem> documentItems = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Timestamp getFormedOn() {
		return formedOn;
	}

	public void setFormedOn(Timestamp formedOn) {
		this.formedOn = formedOn;
	}

	public Timestamp getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Timestamp bookedOn) {
		this.bookedOn = bookedOn;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Warehouse getMandatoryWarehouse() {
		return mandatoryWarehouse;
	}

	public void setMandatoryWarehouse(Warehouse mandatoryWarehouse) {
		this.mandatoryWarehouse = mandatoryWarehouse;
	}

	public FiscalYear getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(FiscalYear fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public Set<DocumentItem> getDocumentItems() {
		return documentItems;
	}

	public void setDocumentItems(Set<DocumentItem> documentItems) {
		this.documentItems = documentItems;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Document)) {
			return false;
		}
		Document document = (Document) o;
		return id == document.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
