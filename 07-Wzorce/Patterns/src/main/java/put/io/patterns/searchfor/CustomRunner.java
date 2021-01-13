package put.io.patterns.searchfor;

public abstract class CustomRunner {
	public static void checkAndRun(String[] params, int num, String paramsUsage, CustomRunner runner) {
		if (params == null || params.length != num) {
			System.err.println("Usage: java " + runner.getClass().getName() + " " + paramsUsage);
			System.exit(1);
		}
		try {
			runner.run(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void run(String[] params) throws Exception;
}
