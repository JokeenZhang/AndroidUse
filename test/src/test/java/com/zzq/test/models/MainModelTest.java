package com.zzq.test.models;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Test;

public class MainModelTest {

    @Test
    public void createTestString() {
        MainModel mainModel = new MainModel();
        TestCase.assertEquals("123456",mainModel.createTestString(8) );
    }
}