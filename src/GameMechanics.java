import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

import java.util.concurrent.ThreadLocalRandom;

public class GameMechanics extends JPanel implements ActionListener, KeyListener {

    boolean play = false, isVisible = true;
    BrickGenerator b;
    

    Timer t;
    int delay = 8, score = 0, highscore = 0, id = 0, rows = 5, cols = 5, totalBricks, lives = 3;

    public GameMechanics() {

        b = new BrickGenerator(rows, cols);// Set you number of bricks
        totalBricks = rows * cols;
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        addKeyListener(this);
        

        t = new Timer(delay, this);
        t.start();

    }

    int speedX = 0;
    int speedY = -5;
    int ballposX = 395;
    int ballposY = 725;
    int playerpos = 350;

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);

        if (isVisible)
            b.draw((Graphics2D) g);

        // Ball
        g.setColor(Color.RED);
        g.fillOval(ballposX, ballposY, 25, 25);

        // Pallet
        g.setColor(Color.ORANGE);
        g.fillRoundRect(playerpos, 750, 110, 20, 20, 20);

        // Score & HighScore
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times New Roman", Font.BOLD, 15));
        g.drawString("Score: " + score, 550, 15);
        g.drawString("HighScore: " + highscore, 650, 15);

        // Lifes
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times New Roman", Font.BOLD, 15));
        g.drawString("Lifes Left: " + lives, 450, 15);
    

        // Intro
        if (play == false && id == 0) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 25));
            g.drawString("Press Space to Start", 300, 455);
            g.setFont(new Font("Times New Roman", Font.BOLD, 15));
            g.drawString("You can pause your game whenever you like by using ESC key", 200, 495);
        }

        // Outro Lose
        if (play == false && id == 1) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.BOLD, 35));
            g.drawString("GAME OVER", 300, 255);
            g.setFont(new Font("Times New Roman", Font.BOLD, 15));
            g.drawString("Press SPACE to Restart", 300, 495);
            g.drawString("Press ENTER to Exit", 300, 515);
        }

        // Outro Win
        if (play == false && id == 2) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times New Roman", Font.BOLD, 35));
            g.drawString("Congrats you have won!!!", 200, 255);
            g.setFont(new Font("Times New Roman", Font.BOLD, 15));
            g.drawString("Press SPACE to Restart", 300, 495);
            g.drawString("Press ENTER to Exit", 300, 515);
        }

        // Pause
        if (play == false && id == 3) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 25));
            g.drawString("Game Paused", 300, 455);
            g.setFont(new Font("Times New Roman", Font.BOLD, 15));
            g.drawString("Press ESC again to Resume", 300, 495);
        }

        // Revive
        if (play == false && id == 4) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.BOLD, 25));
            g.drawString("You just Lost a life", 300, 455);
            g.setFont(new Font("Times New Roman", Font.BOLD, 25));

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Animate Ball
        t.start();
        if (play) {
            ballposX += speedX;
            ballposY += speedY;
            if (ballposX >= 750 || ballposX <= 0)
                speedX = -speedX;
            if (ballposY <= 50) {
                speedY = -speedY;
                int X = ThreadLocalRandom.current().nextInt(0, 1);
                if (speedX == 0 && X == 1)
                    speedX = -5;
                if (speedX == 0 && X == 0)
                    speedX = 5;

            }

            if (ballposY >= 760) {

                if (lives >= 0) {
                    play = false;
                    lives--;
                    ballposX = 395;
                    ballposY = 725;
                    playerpos = 350;
                    speedX = 0;
                    speedY = -5;
                    id = 4;
                }
                
                if (lives < 0) {
                    isVisible = false;
                    play = false;
                    ballposX = 395;
                    ballposY = 725;
                    playerpos = 350;
                    id = 1;
                    totalBricks = rows * cols;
                    lives = 3;
                    score = 0;
                }

            }

            if (totalBricks <= 0) {
                play = false;
                isVisible = false;
                ballposX = 395;
                ballposY = 725;
                playerpos = 350;
                speedX = 0;
                speedY = -5;
                score = 0;
                totalBricks = rows * cols;
                id = 2;
                lives=3;
            }

            Rectangle pallet = new Rectangle(playerpos, 750, 100, 20);

            // Pallet and ball contact
            if (new Rectangle(ballposX, ballposY, 25, 25).intersects(pallet)) {
                speedY = -speedY;
            }

            B: for (int i = 0; i < b.brickmap.length; i++) {
                for (int j = 0; j < b.brickmap[0].length; j++) {
                    if (b.brickmap[i][j]) {
                        int brickx = i * b.brickWidth + 100;
                        int bricky = j * b.brickHeight + 125;
                        int brickwidth = b.brickWidth;
                        int brickheight = b.brickHeight;

                        Rectangle brickrect = new Rectangle(brickx, bricky, brickwidth, brickheight);
                        Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);

                        if (ballrect.intersects(brickrect)) {

                            int X = ThreadLocalRandom.current().nextInt(0, 1);
                            if (speedX == 0 && X == 1)
                                speedX = -5;
                            if (speedX == 0 && X == 0)
                                speedX = 5;

                            b.disableBrick(i, j);
                            totalBricks--;

                            if (ballposX + 19 <= brickrect.x || ballposX + 1 >= brickrect.x + brickrect.width) {
                                speedX = -speedX;
                            } else {
                                speedY = -speedY;
                            }

                            if (score >= highscore) {
                                score += 5;
                                highscore += 5;
                            }

                            else
                                score += 5;

                            break B;
                        }

                    }
                }
            }

        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerpos >= 680)
                playerpos = 680;

            else {
                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerpos <= 0)
                playerpos = 0;

            else {
                moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            System.exit(1);

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            play = true;
            isVisible = true;
            if (play && (id == 1 || id == 2))
                b = new BrickGenerator(rows, cols);
            id = 0;
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

            if (!play) {
                id = 0;
                play = true;
            }

            else {
                id = 3;
                play = false;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {

            new Settings().setVisible(true);
        }

    }

    void moveRight() {

        if (id != 3) {
            if (!play)
                ballposX += 30;
            playerpos += 30;
        }
    }

    void moveLeft() {

        if (id != 3) {
            if (!play)
                ballposX -= 30;
            playerpos -= 30;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
