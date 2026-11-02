package com.proggertopper.spring.springcore.properties;

import java.util.Properties;

public class ContriesAndLanguages {
	
	private Properties languages;

	public Properties getLanguages() {
		return languages;
	}

	public void setLanguages(Properties languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "ContriesAndLanguages [languages=" + languages + "]";
	}
	

}
