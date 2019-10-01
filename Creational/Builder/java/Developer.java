public class Developer {

	private String name;
	private String programingLanguage;
	private String operationSystem;

	//access only to builder class
	private Developer(Builder builder) {
		this.name = builder.name;
		this.programingLanguage = builder.programingLanguage;
		this.operationSystem = builder.operationSystem;
	}

	public static Builder builder(){
		return new Developer.Builder();
	}

	public String getName() {
		return name;
	}

	public String getProgramingLanguage() {
		return programingLanguage;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProgramingLanguage(String programingLanguage) {
		this.programingLanguage = programingLanguage;
	}

	public void setOperationSystem(String operationSystem) {
		this.operationSystem = operationSystem;
	}

	public String toString() {
		return "Developer{" +
				"name='" + name + '\'' +
				", programingLanguage='" + programingLanguage + '\'' +
				", operationSystem='" + operationSystem + '\'' +
				'}';
	}

	public static class Builder {
		private String name;
		private String programingLanguage;
		private String operationSystem;

		//access only to developer class
		private Builder() {
			//internal use
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder programingLanguage(String programingLanguage) {
			this.programingLanguage = programingLanguage;
			return this;
		}

		public Builder operationSystem(String operationSystem) {
			this.operationSystem = operationSystem;
			return this;
		}

		public Developer build(){
			return new Developer(this);
		}
	}
}
