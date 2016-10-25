package com.makotogo.learn.properties;

/*
 * Copyright 2016 Makoto Consulting Group, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertiesFileTest {

  private PropertiesFile classUnderTest;

  @Before
  public void setUp() throws Exception {
    classUnderTest = new PropertiesFile("test.properties");
  }

  @After
  public void tearDown() throws Exception {
    classUnderTest = null;
  }

  @Test
  public void testGetProperty() {
    String propertyName = "property1";
    String expectedPropertyValue = "property1Value";
    String actualPropertyValue = classUnderTest.getProperty(propertyName);

    assertEquals(expectedPropertyValue, actualPropertyValue);

  }

  @Test
  public void testPutProperty() {
    String propertyName = "dynamicProperty";

    classUnderTest.putProperty(propertyName + "1", "value1");
    classUnderTest.putProperty(propertyName + "2", "value2");
    classUnderTest.putProperty(propertyName + "3", "value3");
    classUnderTest.putProperty(propertyName + "4", "value4");

    // Now save the properties to original file (no backup)
    classUnderTest.save(false);

    // Now save the properties to backup file
    classUnderTest.save(true);

  }

}
