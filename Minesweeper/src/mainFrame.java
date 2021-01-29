/* 
 * Charley Liu
 * Dec 26th, 2021
 * The JFrame that will display the all the panels. 
*/
package Java.Projects.Minesweeper.src;

import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Charley Liu
*/
public class mainFrame extends JFrame implements ActionListener {

    // Public Game Variables
    public static int numRows, numColumns, numMines;

    /* 
     * JFrame Constructor
    */
    mainFrame() {

        // Frame properties
        this.setTitle("Minesweeper");  // Sets the title of the JFrame
        this.setResizable(false);  // Makes sure the user can't resize the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensures that the threads close the program when the user hits the exit button
        this.setIconImage(new ImageIcon("Java/Projects/Minesweeper/images/" + new Random().nextInt(13) + ".png").getImage());  // Selects a random Image for the JFrame icon

        this.add(new mainMenuPanel());  // Adds the panel containing the main menu to the JFrame
        this.pack();  // Sets every component to their preferred size
        this.setLocationRelativeTo(null);  // Put's the JFrame at the center of the user's screen 

        // Adds Action Listeners to button components
        mainMenuPanel.easyButton.addActionListener(this);
        mainMenuPanel.normalButton.addActionListener(this);
        mainMenuPanel.hardButton.addActionListener(this);
        mainMenuPanel.customButton.addActionListener(this);

        this.setVisible(true);  // Makes the JFrame visible to the user

    }

    /* 
     * Main Method
    */
    public static void main(String[] args) {

        // Create a new JFrame
        new mainFrame();

    }

    /* 
     * Runs whenever an action is performed
     * Return type: returns nothing (void)
     * @param e: the event that happened
    */
    @Override
    public void actionPerformed(ActionEvent e) {

        // User clicked return button
        if (e.getSource() == gamePanel.returnButton) {

            // Switch panels
            switchPanels(new mainMenuPanel());
            // Adds Action Listeners to button components
            mainMenuPanel.easyButton.addActionListener(this);
            mainMenuPanel.normalButton.addActionListener(this);
            mainMenuPanel.hardButton.addActionListener(this);
            mainMenuPanel.customButton.addActionListener(this);  

        }

        // User selected easy difficulty
        else if (e.getSource() == mainMenuPanel.easyButton) {

            // Disable the button
            mainMenuPanel.easyButton.setEnabled(false);

            // Set the Game variables
            numRows = 10;
            numColumns = 8;
            numMines = 10;

            // Switch the main menu panel to the game panel
            switchPanels(new gamePanel());
            gamePanel.returnButton.addActionListener(this);

        } 

        // User selected normal difficulty
        else if (e.getSource() == mainMenuPanel.normalButton) {

            mainMenuPanel.normalButton.setEnabled(false);

            numRows = 18;
            numColumns = 14;
            numMines = 40;

            switchPanels(new gamePanel());
            gamePanel.returnButton.addActionListener(this);

        } 

        // User selected hard difficulty
        else if (e.getSource() == mainMenuPanel.hardButton) {

            mainMenuPanel.hardButton.setEnabled(false);

            numRows = 24;
            numColumns = 20;
            numMines = 99;

            switchPanels(new gamePanel());
            gamePanel.returnButton.addActionListener(this);

        } 
        
        // User selected a custom difficulty
        else if (e.getSource() == mainMenuPanel.customButton) {
            
            // Try to run the following lines of code and catch an exception if one happens
            try {
                
                // Get the user's text field input
                numRows = Integer.parseInt(mainMenuPanel.rowsTextField.getText());
                numColumns = Integer.parseInt(mainMenuPanel.columnsTextField.getText());
                numMines = Integer.parseInt(mainMenuPanel.minesTextField.getText());

                // Game constraints
                if (numRows <= 3 || numColumns <= 3 || numMines > numRows * numColumns - 9 || numMines <= 0) {

                    // Display an error message
                    mainMenuPanel.errorLabel.setText("<html>Error: Please enter in<br/> valid numbers</html>");

                }

                // Start the game
                else {

                    // Switch the main menu panel with the game panel
                    switchPanels(new gamePanel());
                    gamePanel.returnButton.addActionListener(this);

                }  
                
            } 
            
            // User entered in a non-integer input for the text fields
            catch (NumberFormatException error) {

                // Display an error message
                mainMenuPanel.errorLabel.setText("<html>Error: Please enter in a<br/> number for these fields</html>");

                error.printStackTrace();

            }

        }

    }

    /* 
     * Switches panels between main menu and the game
     * Return type: returns nothing (void)
     * @param addPanel: The panel to add to the screen
    */
    public void switchPanels(JPanel addPanel) {

        // Remove all components
        this.getContentPane().removeAll();

        // Add the new panel
        this.add(addPanel);

        // Pack the contents and repaint the GUI
        this.pack();
        this.repaint();

    }

}
