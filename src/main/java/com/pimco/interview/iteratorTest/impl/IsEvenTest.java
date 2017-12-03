package com.pimco.interview.iteratorTest.impl;

import com.pimco.interview.iteratorTest.IObjectTest;

public class IsEvenTest implements IObjectTest {

    /**
     * only pass the even number
     *
     * @param {@link Object} object is going to be tested
     * @return boolean if {@link Object} o pass the test
     */
    @Override
    public boolean test(Object o) {
        return ((Integer) o) % 2 == 0;
    }
}
