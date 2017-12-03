package com.pimco.interview;


import com.pimco.interview.iteratorTest.IObjectTest;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteringIterator implements Iterator {
    private Iterator iterator;
    private IObjectTest iObjectTest;
    private Object next;
    private boolean isNextCalled;
    private boolean hasNext;

    public FilteringIterator(Iterator iterator, IObjectTest iObjectTest) {
        this.iterator = iterator;
        this.iObjectTest = iObjectTest;
        this.isNextCalled = false;
        this.hasNext = false;
    }

    @Override
    public boolean hasNext() {
        if (!isNextCalled) {
            hasNext = false;
            while (iterator.hasNext()) {
                if (iObjectTest.test(next = iterator.next())) {
                    hasNext = true;
                    break;
                }
            }
            isNextCalled = true;
        }
        return hasNext;
    }

    @Override
    public Object next() {
        if (isNextCalled || hasNext()) {
            isNextCalled = false;
            return next;
        } else {
            throw new NoSuchElementException();
        }
    }
}
