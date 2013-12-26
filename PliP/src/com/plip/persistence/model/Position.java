package com.plip.persistence.model;

// Generated Dec 26, 2013 7:09:50 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Position generated by hbm2java
 */
public class Position implements java.io.Serializable {

	private Integer idPosition;
	private int face;
	private int angle;
	private Set images = new HashSet(0);

	public Position() {
	}

	public Position(int face, int angle) {
		this.face = face;
		this.angle = angle;
	}

	public Position(int face, int angle, Set images) {
		this.face = face;
		this.angle = angle;
		this.images = images;
	}

	public Integer getIdPosition() {
		return this.idPosition;
	}

	public void setIdPosition(Integer idPosition) {
		this.idPosition = idPosition;
	}

	public int getFace() {
		return this.face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public int getAngle() {
		return this.angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public Set getImages() {
		return this.images;
	}

	public void setImages(Set images) {
		this.images = images;
	}

}
