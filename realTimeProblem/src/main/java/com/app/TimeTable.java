package com.app;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// private Date date;
	private Timestamp dateTime;

	private float value;
	private String units;

	enum Qty {
		GOOD, BAD
	};

	private Qty quality;

	public TimeTable() {

	}

	public TimeTable(Timestamp dateTime, float value, String units, Qty quality) {
		super();
		// this.date = date;
		this.dateTime = dateTime;
		this.value = value;
		this.units = units;
		this.quality = quality;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public Date getDate() {
	// return date;
	// }
	//
	// public void setDate(Date date) {
	// this.date = date;
	// }

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Qty getQuality() {
		return quality;
	}

	public void setQuality(Qty quality) {
		this.quality = quality;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
}
