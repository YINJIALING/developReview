package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer>{
	List<Integer> nestedList=new ArrayList<>();
	int index=0;
    public NestedIterator(List<Integer> nestedList) {
    		this.nestedList=nestedList;
    }

    @Override
    public Integer next() {
    		nestedList.get(index);
    		index++;
    }

    @Override
    public boolean hasNext() {
        if(index<nestedList.size())
        		return true;
        else
        		return false;
    }
}
