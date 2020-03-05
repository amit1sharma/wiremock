package com.amt.testmodel;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Tests {

    TestData testData;

    @XmlElement(name="test-data")
    public TestData getTestData() {
        return testData;
    }

    public void setTestData(TestData testData) {
        this.testData = testData;
    }

}