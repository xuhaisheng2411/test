package com.entity;

import java.io.Serializable;

public class OcBaseElement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1035730252438197600L;
	protected String classId;	
	protected String datasetId="ACMDB";
	protected String reconciliationId="0";
	protected String instanceId;
	protected String configId;
	protected String name;
	protected String status;
	protected String description;
	protected String location;
	protected String lastModifier;
	protected String submitter;

	
	public String getLastModifier() {
		return lastModifier;
	}
	public void setLastModifier(String lastModifier) {
		this.lastModifier = lastModifier;
	}
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatasetId() {
		return datasetId;
	}
	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}
	public String getReconciliationId() {
		return reconciliationId;
	}
	public void setReconciliationId(String reconciliationId) {
		this.reconciliationId = reconciliationId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getConfigId() {
		return configId;
	}
	public void setConfigId(String configId) {
		this.configId = configId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BaseElement [classId=" + classId + ", datasetId=" + datasetId + ", reconciliationId=" + reconciliationId
				+ ", instanceId=" + instanceId + ", configId=" + configId + ", name=" + name + ", status=" + status
				+ ", description=" + description + ", location=" + location + ", lastModifier=" + lastModifier
				+ ", submitter=" + submitter + "]";
	}


}
