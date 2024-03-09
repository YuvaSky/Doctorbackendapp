package com.doctor.util;

import java.util.HashMap;
import java.util.Map;

public class DoctorPatient {
	
	public static Map<String,String> map = new HashMap<String,String>();
	static {
		map.put("Arthritis","Orthopedic");
		map.put("Backpain","Orthopedic");
		map.put("Tissue injuries","Orthopedic");
		map.put("Dysmenorrhea","Gynecology");
		map.put("Skin infection","Dermatology");
		map.put("Skin burn","Dermatology");
		map.put("Ear pain","ENT");
	}
}
