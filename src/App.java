import javax.swing.*;


public class App extends JFrame{

    public int highscore=0;
    

    public static void main(String[] args) {
        new App();
    }

    public App()
    {
        
        GameMechanics gMechanics = new GameMechanics(); 
        ImageIcon img = new ImageIcon(this.getClass().getResource("BrickBreakerIcon.png"));
        setIconImage(img.getImage());
        setSize(800, 800);
        setLocationRelativeTo(null);
        setTitle("Brick Breaker");
        setResizable(false);
        getContentPane().add(gMechanics);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
