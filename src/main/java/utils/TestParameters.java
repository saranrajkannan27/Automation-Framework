package utils;



public class TestParameters {
	
	private String currentTestcase;
	private String Description;
	private String setCategory;
	private String execute;
	private String browser;
	
	public String getCurrentTestcase() {
		return currentTestcase;
	}
	public void setCurrentTestcase(String currentTestcase) {
		this.currentTestcase = currentTestcase;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getSetCategory() {
		return setCategory;
	}
	public void setSetCategory(String setCategory) {
		this.setCategory = setCategory;
	}
	public String getExecuteCurrentTestcase() {
		return execute;
	}
	public void setExecuteCurrentTestcase(String execute) {
		this.execute = execute;
	}
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public String getBrowser() {
		return browser;
	}

}
