public class DeveloperBuildUsage {

	public static void main(String[] args) {
		Developer developer = Developer.builder()
				.name("José")
				.programingLanguage("Java")
				.operationSystem("Windows")
				.build();
		Developer developer2 = Developer.builder()
				.name("Augusto")
				.programingLanguage("Java")
				.operationSystem("Linux")
				.build();
		System.out.println(developer.toString());
		System.out.println(developer2.toString());
	}
}
