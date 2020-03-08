package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    public static final int H_VS_A = 0;
    public static final int H_VS_H = 1;

    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;

    public BattleMap() {
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {
        if (isInitialized == false) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
        if (Logic.gameFinish) {
            gameOverMessage(g, GameWindow.getWindowHeight());
        }

    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode %d fieldSizeX %d fieldSizeY %d winLength %d \n"
                , mode, fieldSizeX, fieldSizeY, winLength);

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;

        isInitialized = true;
        repaint();
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        System.out.println(cellX + " " + cellY);
        if (!Logic.gameFinish) {
            Logic.setHumanXY(cellX, cellY);
        }

        repaint();

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(255, 0, 0));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));


        g2.drawLine(cellX * cellWidth, cellY * cellHeight,
                (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g2.drawLine((cellX + 1) * cellWidth, cellY * cellHeight,
                cellX * cellWidth, (cellY + 1) * cellHeight);
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(0, 13, 255));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));
        g2.drawOval(cellX * cellWidth, cellY * cellHeight,
                cellWidth, cellHeight);

    }

    private void gameOverMessage(Graphics g, int x) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, x / 3, x, x/8);
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", 10, 40));
        g.drawString(Logic.winnerName, 100, (x - 80)/2);

    }
}
