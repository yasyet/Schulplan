package ui;

public class HourDef {
    private final int number;
    private final String label;
    private final int durationMinutes;
    private final boolean isBreak;

    public HourDef(int number, String label, int durationMinutes, boolean isBreak) {
        this.number = number;
        this.label = label;
        this.durationMinutes = durationMinutes;
        this.isBreak = isBreak;
    }

    public int getNumber() {
        return number;
    }

    public String getLabel() {
        return label;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isBreak() {
        return isBreak;
    }
}
