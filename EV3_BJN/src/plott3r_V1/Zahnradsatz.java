package plott3r_V1;

import java.util.Arrays;
import java.util.List;

public class Zahnradsatz implements IUebersetzung {

	private List<Zahnrad> zahnraeder;

	public Zahnradsatz(Zahnrad... zahnraeder) {
		this.zahnraeder = Arrays.asList(zahnraeder);
	}

	@Override
	public double getUebersetzungsverhaeltnis() {
	}

}
