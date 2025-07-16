import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class ShapeDrawer {

    static int shapeChoice;  
    static int radius, length, width, height, base;
    static final double PIXELS_PER_CM = 37.8; // Conversion factor: 96 DPI / 2.54 cm per inch

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to select 
        System.out.println("-----SHAPE DRAWER-----");
        System.out.println("Enter the number corresponding to your desired shape:");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");
        System.out.print("Enter your choice (1-3): ");
        shapeChoice = scanner.nextInt();

        // The switch control structure to assign the dimensions depending on the choice selected by user
        switch (shapeChoice) {
            case 1 -> {     // assign radius for the circle
                System.out.print("Enter the radius of the circle (in cm): ");
                radius = (int) (scanner.nextDouble() * PIXELS_PER_CM);
            }
            case 2 -> {     // assign height and base length for the triangle
                System.out.print("Enter the height of the triangle (in cm): ");
                height = (int) (scanner.nextDouble() * PIXELS_PER_CM);
                System.out.print("Enter the base length of the triangle (in cm): ");
                base = (int) (scanner.nextDouble() * PIXELS_PER_CM);
            }
            case 3 -> {     // assign length and width rectangle
                System.out.print("Enter the length of the rectangle (in cm): ");
                length = (int) (scanner.nextDouble() * PIXELS_PER_CM);
                System.out.print("Enter the width of the rectangle (in cm): ");
                width = (int) (scanner.nextDouble() * PIXELS_PER_CM);
            }
            default -> {       // execute this if the user enters any value other than 1-3
                System.out.println("Invalid choice.");
                System.exit(0);
            }
        }

        // The parent GUI on which the shape will be drawn or rendered on
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape Drawer");
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ShapePanel());
            frame.setVisible(true);
        });

        scanner.close();
    }

    // a nested class to draw the shape
    static class ShapePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);    // calls the constructor of the inherited class (JPanel)
            setBackground(Color.WHITE);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLUE);
            g2.setStroke(new BasicStroke(2));

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            switch (shapeChoice) {
                case 1 -> // Circle
                    g2.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

                case 2 -> {
                    // Triangle
                    int halfBase = base / 2;
                    int[] xPoints = {
                        centerX,
                        centerX - halfBase,
                        centerX + halfBase             
                    };
                    int[] yPoints = {
                        centerY - height / 2,
                        centerY + height / 2,
                        centerY + height / 2           
                    };
                    g2.drawPolygon(xPoints, yPoints, 3);
                }

                case 3 -> // Rectangle
                    g2.drawRect(centerX - length / 2, centerY - width / 2, length, width);
            }
        }
    }
}