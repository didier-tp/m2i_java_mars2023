package tp.demo;

public class MyParamApp {

	public static void main(String[] args) {
		boolean avecDetails = Boolean.parseBoolean(System.getProperty("details"));
		if(avecDetails) {
			System.out.println("os.name=" +System.getProperty("os.name") );
		    System.out.println("nb args=" + args.length);
		}
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double resAdd=x+y;
		System.out.println(resAdd);
        System.exit(0);
	}

}
