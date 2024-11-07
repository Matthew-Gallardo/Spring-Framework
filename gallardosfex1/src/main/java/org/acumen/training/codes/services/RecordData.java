package org.acumen.training.codes.services;

import java.util.List;
import java.util.Map;

public class RecordData {
	private List<Integer> ageList;
	private Map<String, String> nameRecords;

	public RecordData(List<Integer> ageList, Map<String, String> nameRecords) {

		this.ageList = ageList;
		this.nameRecords = nameRecords;
	}

	public List<Integer> getAgeList() {
		return ageList;
	}

	public void setAgeList(List<Integer> ageList) {
		this.ageList = ageList;
	}

	public Map<String, String> getNameRecords() {
		return nameRecords;
	}

	public void setNameRecords(Map<String, String> nameRecords) {
		this.nameRecords = nameRecords;
	}

	@Override
	public String toString() {
		return "RecordData [ageList=" + ageList + ", nameRecords=" + nameRecords + "]";
	}
	


}