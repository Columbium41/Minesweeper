/* 
 * Charley Liu
 * Dec 26th, 2021
 * A JPanel that holds all the components for the main menu.
*/
package minesweeper;

import javax.swing.*;
import java.awt.*;

/**
 * @author Charley Liu
*/
public class mainMenuPanel extends JPanel {

    // Panel Variables
    private final int WIDTH = 800;
    private final int HEIGHT = 400;

    // Button Variables
    private final int BUTTON_WIDTH = 150;
    private final int BUTTON_HEIGHT = 40;

    // Text Field Variables
    private final int TEXT_FIELD_WIDTH = 100;
    private final int TEXT_FIELD_HEIGHT = 30;

    /* 
     * JPanel Constructor
    */
    mainMenuPanel() {

        // Initiate all the components in the panel
        initComponents();
        
        // Panel Properties
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));  // Sets the preferred size of the JPanel
        this.setBackground(Color.GRAY);  // Sets the background color to gray
        this.setLayout(new BorderLayout());  // Sets the border layout for the panel
        
        // Add Components to Panel
        this.add(headingPanel, BorderLayout.NORTH);
        this.add(presetDifficultyPanel, BorderLayout.WEST);
        this.add(customDifficultyPanel, BorderLayout.EAST);

    }

    /*
     * Creates all the components in the panel
    */
    public void initComponents() {

        // Text Fields
        rowsTextField = new JTextField();
        rowsTextField.setBounds(120, 80, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);

        columnsTextField = new JTextField();
        columnsTextField.setBounds(120, 140, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);

        minesTextField = new JTextField();
        minesTextField.setBounds(120, 200, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);

        // Panels
        headingPanel = new JPanel();
        headingPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 5));
        headingPanel.setBackground(Color.GRAY);
        headingPanel.setLayout(new GridBagLayout()); // Layout that helps center the text

        presetDifficultyPanel = new JPanel();
        presetDifficultyPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
        presetDifficultyPanel.setBackground(Color.GRAY);
        presetDifficultyPanel.setLayout(null);

        customDifficultyPanel = new JPanel();
        customDifficultyPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
        customDifficultyPanel.setBackground(Color.GRAY);
        customDifficultyPanel.setLayout(null);

        // Buttons
        easyButton = new JButton();
        easyButton.setText("Easy");
        easyButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        easyButton.setBounds(new Rectangle(120, 80, BUTTON_WIDTH, BUTTON_HEIGHT));
        easyButton.setForeground(Color.GREEN);
        easyButton.setFocusable(false); // Makes sure the button can't be focused (very bad looking)
        easyButton.setFont(new Font(easyButton.getFont().getName(), Font.PLAIN, 20));

        normalButton = new JButton();
        normalButton.setText("Normal");
        normalButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        normalButton.setBounds(new Rectangle(120, 140, BUTTON_WIDTH, BUTTON_HEIGHT));
        normalButton.setForeground(Color.YELLOW);
        normalButton.setFocusable(false); // Makes sure the button can't be focused (very bad looking)
        normalButton.setFont(new Font(normalButton.getFont().getName(), Font.PLAIN, 20));

        hardButton = new JButton();
        hardButton.setText("Hard");
        hardButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        hardButton.setBounds(new Rectangle(120, 200, BUTTON_WIDTH, BUTTON_HEIGHT));
        hardButton.setForeground(Color.RED);
        hardButton.setFocusable(false); // Makes sure the button can't be focused (very bad looking)
        hardButton.setFont(new Font(hardButton.getFont().getName(), Font.PLAIN, 20));

        customButton = new JButton();
        customButton.setText("Create Game");
        customButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        customButton.setBounds(new Rectangle(95, 260, BUTTON_WIDTH, BUTTON_HEIGHT));
        customButton.setForeground(Color.ORANGE);
        customButton.setFocusable(false); // Makes sure the button can't be focused (very bad looking)
        customButton.setFont(new Font(customButton.getFont().getName(), Font.PLAIN, 18));

        // Labels
        heading = new JLabel();
        heading.setText("Minesweeper");
        heading.setFont(new Font(heading.getFont().getName(), Font.PLAIN, 50));
        heading.setForeground(Color.BLACK);

        presetDifficultyLabel = new JLabel();
        presetDifficultyLabel.setText("Select a Difficulty");
        presetDifficultyLabel.setFont(new Font(presetDifficultyLabel.getFont().getName(), Font.PLAIN, 20));
        presetDifficultyLabel.setForeground(Color.BLACK);
        presetDifficultyLabel.setBounds(120, 0, 200, 50);

        customDifficultyLabel = new JLabel();
        customDifficultyLabel.setText("Make a Custom Game");
        customDifficultyLabel.setFont(new Font(customDifficultyLabel.getFont().getName(), Font.PLAIN, 20));
        customDifficultyLabel.setForeground(Color.BLACK);
        customDifficultyLabel.setBounds(75, 0, 200, 50);

        rowsLabel = new JLabel();
        rowsLabel.setText("Rows: ");
        rowsLabel.setBounds(70, 80, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
        rowsLabel.setFont(new Font(rowsLabel.getFont().getName(), Font.PLAIN, 15));
        rowsLabel.setForeground(Color.BLACK);

        columnsLabel = new JLabel();
        columnsLabel.setText("Columns: ");
        columnsLabel.setBounds(50, 140, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
        columnsLabel.setFont(new Font(columnsLabel.getFont().getName(), Font.PLAIN, 15));
        columnsLabel.setForeground(Color.BLACK);

        minesLabel = new JLabel();
        minesLabel.setText("Mines: ");
        minesLabel.setBounds(70, 200, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
        minesLabel.setFont(new Font(minesLabel.getFont().getName(), Font.PLAIN, 15));
        minesLabel.setForeground(Color.BLACK);

        errorLabel = new JLabel();
        errorLabel.setText("<html>Warning: expect <br/> Custom Games<br/> to be buggy!</html>");
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(230, 120, TEXT_FIELD_WIDTH * 2, TEXT_FIELD_HEIGHT * 2);
        errorLabel.setFont(new Font(errorLabel.getFont().getName(), Font.BOLD, 15));

        // Add Components
        headingPanel.add(heading);
        presetDifficultyPanel.add(presetDifficultyLabel);
        presetDifficultyPanel.add(easyButton);
        presetDifficultyPanel.add(normalButton);
        presetDifficultyPanel.add(hardButton);
        customDifficultyPanel.add(customDifficultyLabel);
        customDifficultyPanel.add(rowsTextField);
        customDifficultyPanel.add(columnsTextField);
        customDifficultyPanel.add(minesTextField);
        customDifficultyPanel.add(rowsLabel);
        customDifficultyPanel.add(columnsLabel);
        customDifficultyPanel.add(minesLabel);
        customDifficultyPanel.add(customButton);
        customDifficultyPanel.add(errorLabel);

    }

    // Private Component Declarations 
    private JPanel headingPanel;
    private JPanel presetDifficultyPanel;
    private JPanel customDifficultyPanel;
    private JLabel heading;
    private JLabel presetDifficultyLabel;
    private JLabel customDifficultyLabel;
    private JLabel rowsLabel, columnsLabel, minesLabel;

    // Public Component Declarations
    public static JButton easyButton, normalButton, hardButton, customButton;
    public static JTextField rowsTextField, columnsTextField, minesTextField;
    public static JLabel errorLabel;

}
