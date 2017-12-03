import com.pimco.interview.FilteringIterator;
import com.pimco.interview.iteratorTest.IObjectTest;
import com.pimco.interview.iteratorTest.impl.IsEvenTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class FilteringIteratorTest {
    private FilteringIterator filteringIterator;
    private List<Integer> list;

    @Before
    public void setUp() {
        iniList();
        Iterator myIterator = list.iterator();
        IObjectTest isEvenTest = new IsEvenTest();
        filteringIterator = new FilteringIterator(myIterator, isEvenTest);
    }

    @Test
    public void printAllElementsTest1() {
        List<Integer> testList = new ArrayList<>();
        while (filteringIterator.hasNext()) {
            testList.add((Integer) filteringIterator.next());
        }
        assertEquals(50, testList.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void printAllElementsTest2() {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            testList.add((Integer) filteringIterator.next());
        assertEquals(50, testList.size());
    }

    @Test
    public void printAllElementsTest3() {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            testList.add((Integer) filteringIterator.next());
        assertEquals(50, testList.size());
    }

    @Test
    public void printAllElementsTest4() {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (Math.random() < 0.5) {
                filteringIterator.hasNext();
            }
            testList.add((Integer) filteringIterator.next());
        }
        assertEquals(50, testList.size());
    }

    private void iniList() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }
}
