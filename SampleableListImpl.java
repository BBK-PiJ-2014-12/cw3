
public class SampleableListImpl extends LinkedList implements SampleableList {
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample() {
		SampleableList sampleList = new SampleableListImpl();
		for(int i = 0; i < size(); i = i + 2) {
			sampleList.add(get(i).getReturnValue());
		}
		return sampleList; 
	}
}
