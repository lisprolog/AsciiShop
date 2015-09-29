import java.util.Scanner;

public class SaveFactory implements Factory{

	MetricSet<AsciiImage> ms;

	/** initialised with a MetricSet */

	public SaveFactory(MetricSet<AsciiImage> saved){
		this.ms = saved;
	}

	public Operation create(Scanner scanner)throws FactoryException{
		SaveOperation o1 = new SaveOperation(ms);
		return o1;
	}

}
