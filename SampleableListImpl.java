
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
