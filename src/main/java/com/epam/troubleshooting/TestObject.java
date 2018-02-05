package com.epam.troubleshooting;

public class TestObject {
   private int value;

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject objOne = (TestObject) o;
        return value == objOne.getValue();
    }

    @Override
    public int hashCode() {
        return value;
    }
}
