package ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import ui.HourDef;

public class StundenplanPanel extends JPanel {
    private static final int AMOUNT_DAYS = 5;

    private final HourDef[] HOURS = {
            new HourDef(1, "1. Stunde", 45, false),
            new HourDef(0, "Pause", 5, true),
            new HourDef(2, "2. Stunde", 45, false),
            new HourDef(0, "Pause", 20, true),
            new HourDef(3, "3. Stunde", 45, false),
            new HourDef(0, "Pause", 5, true),
            new HourDef(4, "4. Stunde", 45, false),
            new HourDef(0, "Pause", 15, true),
            new HourDef(5, "5. Stunde", 45, false),
            new HourDef(0, "Pause", 5, true),
            new HourDef(6, "6. Stunde", 45, false),
            new HourDef(0, "Pause", 5, true),
            new HourDef(7, "7. Stunde", 45, false),
            new HourDef(0, "Pause", 15, true),
            new HourDef(8, "8. Stunde", 45, false),
            new HourDef(0, "Pause", 5, true),
            new HourDef(9, "9. Stunde", 45, false)
    };

    public StundenplanPanel() {
        setLayout(new BorderLayout());
        add(createHeaderRow(), BorderLayout.NORTH);
        add(createHourArea(), BorderLayout.CENTER);
    }

    private JComponent createHeaderRow() {
        JPanel header = new JPanel(new GridLayout(1, AMOUNT_DAYS + 1));
        String[] days = { "", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" };

        for (String day : days) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            header.add(label);
        }

        return header;
    }

    private JComponent createHourArea() {
        // Vertical box for periods/breaks
        JPanel hoursPanel = new JPanel();
        hoursPanel.setLayout(new BoxLayout(hoursPanel, BoxLayout.Y_AXIS));

        int totalMinutes = 0;
        for (HourDef hour : HOURS) {
            totalMinutes += hour.getDurationMinutes();
        }

        int baseHeight = 600; // Total height for the schedule area in pixels

        for (HourDef hour : HOURS) {
            double ratio = (double) hour.getDurationMinutes() / totalMinutes;
            int rowHeight = (int) (baseHeight * ratio);

            JPanel rowPanel = createRowForHour(hour, rowHeight);
            hoursPanel.add(rowPanel);
        }

        return hoursPanel;
    }

    private JPanel createRowForHour(HourDef hour, int height) {
        JPanel row = new JPanel(new GridLayout(1, AMOUNT_DAYS + 1));
        row.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Line height with preferred size
        row.setPreferredSize(new Dimension(0, height));

        // Left label
        JLabel leftLabel = new JLabel();
        if (!hour.isBreak()) {
            leftLabel.setText(hour.getLabel());
            leftLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }

        if (hour.isBreak()) {
            leftLabel.setOpaque(true);
        }
        row.add(leftLabel);

        // Empty cells for each day
        for (int i = 0; i < AMOUNT_DAYS; i++) {
            JComponent cell;
            if (hour.isBreak()) {
                JLabel pauseLabel = new JLabel("", SwingConstants.CENTER);
                pauseLabel.setOpaque(true);

                cell = pauseLabel;
            } else {
                JButton cellButton = new JButton();
                cellButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

                cell = cellButton;
            }
            row.add(cell);
        }
        return row;
    }
}
