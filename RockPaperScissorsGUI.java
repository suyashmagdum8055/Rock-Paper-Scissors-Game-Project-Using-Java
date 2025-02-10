import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGUI extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel titleLabel, userChoiceLabel, computerChoiceLabel, resultLabel;
    private JPanel mainPanel, buttonPanel;

    public RockPaperScissorsGUI() {
        setTitle("Rock Paper Scissors");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        // Title Label
        titleLabel = new JLabel("Rock Paper Scissors", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);

        
        rockButton = new JButton(resizeIcon(new ImageIcon("rock.png"), 100, 100));
        paperButton = new JButton(resizeIcon(new ImageIcon("paper.png"), 100, 100));
        scissorsButton = new JButton(resizeIcon(new ImageIcon("scissors.png"), 100, 100));

        
        rockButton.setOpaque(false);
        rockButton.setContentAreaFilled(false);
        rockButton.setBorderPainted(false);

        paperButton.setOpaque(false);
        paperButton.setContentAreaFilled(false);
        paperButton.setBorderPainted(false);

        scissorsButton.setOpaque(false);
        scissorsButton.setContentAreaFilled(false);
        scissorsButton.setBorderPainted(false);

        
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

    
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);


        userChoiceLabel = new JLabel("Your Choice: ", SwingConstants.CENTER);
        computerChoiceLabel = new JLabel("Computer's Choice: ", SwingConstants.CENTER);
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);

        userChoiceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        computerChoiceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.add(titleLabel);
        mainPanel.add(userChoiceLabel);
        mainPanel.add(computerChoiceLabel);
        mainPanel.add(resultLabel);

        // Add Panels to Frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method to Resize 
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = "";
        if (e.getSource() == rockButton) userChoice = "Rock";
        else if (e.getSource() == paperButton) userChoice = "Paper";
        else if (e.getSource() == scissorsButton) userChoice = "Scissors";
        
        String computerChoice = getComputerChoice();
        String result = determineWinner(userChoice, computerChoice);
        
        userChoiceLabel.setText("Your Choice: " + userChoice);
        computerChoiceLabel.setText("Computer's Choice: " + computerChoice);
        resultLabel.setText("Result: " + result);
    }

    private String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return choices[random.nextInt(3)];
    }

    private String determineWinner(String user, String computer) {
        if (user.equals(computer)) return "It's a Tie!";
        else if ((user.equals("Rock") && computer.equals("Scissors")) ||
                 (user.equals("Paper") && computer.equals("Rock")) ||
                 (user.equals("Scissors") && computer.equals("Paper"))) {
            return "You Win!";
        } else {
            return "Computer Wins!";
        }
    }

    public static void main(String[] args) {
        new RockPaperScissorsGUI();
    }
}
