package de.eduardvodicka.applications.digitalframe.controller;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

/**
 * Created by evodicka on 23.01.2016.
 */
public class TimeBasedResourceSelectorTest {

    private ResourceSelector underTest = new TimeBasedResourceSelector();

    @Test(expected = IllegalArgumentException.class)
    public void select_exception() {
        int result = underTest.selectResourceId(0);
    }
    
    @Test
    public void select() {
        int result = underTest.selectResourceId(20);

        assertThat(result, greaterThan(0));
        assertThat(result, lessThan(21));
    }

}