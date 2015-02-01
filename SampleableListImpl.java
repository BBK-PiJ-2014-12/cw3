/**
 * A list with the sample method that return every second object in a new list. 
 * 
 * @author Zsolt Balvanyos
 *
 */
public class SampleableListImpl extends LinkedList implements SampleableList {
	@Override
	public SampleableList sample() {
		SampleableList sampleList = new SampleableListImpl();
		for(int i = 0; i < size(); i = i + 2) {
			sampleList.add(get(i).getReturnValue());
		}
		return sampleList; 
	}
}
