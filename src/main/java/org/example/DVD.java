package org.example;

public class DVD extends Item {
    private final int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "DVD: " + getTitle() + " (Duration: " + duration + " minutes)";
    }
}

