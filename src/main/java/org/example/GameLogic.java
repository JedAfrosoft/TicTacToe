package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic implements ActionListener {

    GameWindow gameWindow;
    JPanel buttonGrid;
    JLabel playerTurn;
    JLabel title;
    JButton square1,square2,square3,square4,square5,square6,square7,square8,square9;

    GameLogic(){

    }

    public void createGameWindow(){
        gameWindow=new GameWindow();
        gameWindow.setTitle("TicTacToe");

        buttonGrid=new JPanel(new GridLayout(3,3,1,1));
        buttonGrid.setBorder(BorderFactory.createLineBorder(Color.cyan,2));
        buttonGrid.setBounds(100,50,600,500);
        buttonGrid.setBackground(Color.BLACK);

        playerTurn=new JLabel();
        playerTurn.setBounds(300,550,300,100);
        playerTurn.setText("Player " + markToBePut + ", it is your turn");
        playerTurn.setFont(new Font(null,Font.PLAIN,20));
        playerTurn.setForeground(Color.BLACK);
        gameWindow.add(playerTurn);

        title=new JLabel();
        title.setBounds(330,0,300,50);
        title.setText("TicTacToe");
        title.setFont(new Font(null,Font.BOLD,25));
        title.setForeground(Color.BLACK);
        gameWindow.add(title);

        square1=new JButton();
        square1.setText("");
        square1.addActionListener(this);
        buttonGrid.add(square1);

        square2=new JButton();
        square2.setText("");
        square2.addActionListener(this);
        buttonGrid.add(square2);

        square3=new JButton();
        square3.setText("");
        square3.addActionListener(this);
        buttonGrid.add(square3);

        square4=new JButton();
        square4.setText("");
        square4.addActionListener(this);
        buttonGrid.add(square4);

        square5=new JButton();
        square5.setText("");
        square5.addActionListener(this);
        buttonGrid.add(square5);

        square6=new JButton();
        square6.setText("");
        square6.addActionListener(this);
        buttonGrid.add(square6);

        square7=new JButton();
        square7.setText("");
        square7.addActionListener(this);
        buttonGrid.add(square7);

        square8=new JButton();
        square8.setText("");
        square8.addActionListener(this);
        buttonGrid.add(square8);

        square9=new JButton();
        square9.setText("");
        square9.addActionListener(this);
        buttonGrid.add(square9);

        gameWindow.add(buttonGrid);


    }

    Boolean isItDraw=true;
    String markToBePut="X";
    int matchCounter;
    JButton[][] listOfButtons;

    public void winChecker(){

        listOfButtons=new JButton[][]{{square1,square2,square3},
                                      {square4,square5,square6},
                                      {square7,square8,square9}
                                     };

            //Row win check
            for (int i=0;i<=2;i++)
            {
                System.out.println("Row Number: " + (i+1));
                for (int j=0;j<=1;j++)
                {
                    if (!listOfButtons[i][j].getText().equals(markToBePut))
                    {
                        System.out.println("Square is blank, skipping check");
                        break;
                    }

                    if(listOfButtons[i][j].getText().equals(listOfButtons[i][j+1].getText()))
                    {
                        System.out.println(listOfButtons[i][j].getText());
                        System.out.println(listOfButtons[i][j+1].getText());
                        matchCounter++;
                        System.out.println("Counter:" + matchCounter);

                    }
                    else {matchCounter=0;break;}


                }

                if (matchCounter==2)
                {
                    System.out.println("We have a winner");
                    isItDraw=false;
                    JOptionPane.showMessageDialog(null,"We have a winner!","WINNER!",JOptionPane.INFORMATION_MESSAGE);
                    endGame();
                    return;
                }
                matchCounter=0;
            }


            //Column win check
            for (int i=0;i<=2;i++)
            {
                System.out.println("Column Number: " + (i+1));
                for (int j=0;j<=1;j++)
                {
                    if (!listOfButtons[j][i].getText().equals(markToBePut))
                    {
                        System.out.println("Square is blank, skipping check");
                        break;
                    }

                    if(listOfButtons[j][i].getText().equals(listOfButtons[j+1][i].getText()))
                    {
                        System.out.println(listOfButtons[j][i].getText());
                        System.out.println(listOfButtons[j+1][i].getText());
                        matchCounter++;
                        System.out.println("Counter:" + matchCounter);

                    }
                    else {matchCounter=0;break;}


                }

                if (matchCounter==2)
                {
                    System.out.println("We have a winner");
                    isItDraw=false;
                    JOptionPane.showMessageDialog(null,"We have a winner!","WINNER!",JOptionPane.INFORMATION_MESSAGE);
                    endGame();
                    return;
                }
                matchCounter=0;
            }


            //Diagonal win check
            //Top left to bottom right
            System.out.println("Top left to bottom right check:\n");
            System.out.println("Mark being used:" + markToBePut);
            if (!listOfButtons[0][0].getText().equals(markToBePut))
            {
                System.out.println("Square is blank or does not match, skipping check");
            }
            else{
                if (listOfButtons[0][0].getText().equals(listOfButtons[1][1].getText()))
                {
                    if (listOfButtons[1][1].getText().equals(listOfButtons[2][2].getText()))
                    {
                        System.out.println("Top left to bottom right win");
                        isItDraw=false;
                        JOptionPane.showMessageDialog(null,"We have a winner!","WINNER!",JOptionPane.INFORMATION_MESSAGE);
                        endGame();
                        return;
                    }
                }
            }


            //Top right to bottom left
            System.out.println("Top right to bottom left check:\n");
            System.out.println("Mark being used:" + markToBePut);
            if (!listOfButtons[0][2].getText().equals(markToBePut))
            {
                System.out.println("Square is blank or does not match, skipping check");
            }
            else {
                if (listOfButtons[0][2].getText().equals(listOfButtons[1][1].getText()))
                {
                    if (listOfButtons[1][1].getText().equals(listOfButtons[2][0].getText()))
                    {
                        System.out.println("Top right to bottom left win");
                        isItDraw=false;
                        JOptionPane.showMessageDialog(null,"We have a winner!","WINNER!",JOptionPane.INFORMATION_MESSAGE);
                        endGame();
                    }
                }
            }


        }

        int nonBlanks;
        public void setTextAndDoWinCheck(JButton selectedSquare){

            selectedSquare.setText(markToBePut);
            winChecker();

            //Checking if all the squares are full but no winner
            nonBlanks=0;
            for (int i=0;i<=2;i++)
            {
                for (int j=0;j<=2;j++)
                {
                    if (listOfButtons[i][j].getText().equals("X") || listOfButtons[i][j].getText().equals("O"))
                    {
                        nonBlanks++;
                        System.out.println("Number of non-blank squares: " + nonBlanks);
                    }
                }
            }

            if (isItDraw && nonBlanks==9){
                JOptionPane.showMessageDialog(null,"It's a draw. You are both losers!","DRAW",JOptionPane.INFORMATION_MESSAGE);
                endGame();
                return;
            }

            if (markToBePut.equals("X"))
            {
                markToBePut="O";
                System.out.println("Changed mark to " + markToBePut);
            }
            else {
                markToBePut="X";
                System.out.println("Changed mark to " + markToBePut);
            }

            playerTurn.setText("Player " + markToBePut + ", it is your turn");


        }

    public void endGame(){

        //Disabling all the squares
        for (int i=0;i<=2;i++)
        {
            for (int j=0;j<=2;j++)
            {
                listOfButtons[i][j].setEnabled(false);
            }
        }

        playerTurn.setEnabled(false);

        int response=JOptionPane.showConfirmDialog(null,"Restart game?","Game Over", JOptionPane.YES_NO_OPTION);

        if (response==JOptionPane.YES_OPTION)
        {
            gameWindow.setVisible(false);
            resetGame();
            gameWindow.setVisible(true);
        }
        else {gameWindow.dispose();}
    }

    private void resetGame() {

        for (int i=0;i<=2;i++)
        {
            for (int j=0;j<=2;j++)
            {
                listOfButtons[i][j].setEnabled(true);
                listOfButtons[i][j].setText("");

            }
        }

        markToBePut="O"; //This will then be changed to X by another line of code later on. I did this out of laziness
        matchCounter=0;
        isItDraw=true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==square1)
        {
            System.out.println("1");
            square1.setEnabled(false);
            setTextAndDoWinCheck(square1);

        }
        if (e.getSource()==square2)
        {
            System.out.println("2");
            square2.setEnabled(false);
            setTextAndDoWinCheck(square2);

        }
        if (e.getSource()==square3)
        {
            System.out.println("3");
            square3.setEnabled(false);
            setTextAndDoWinCheck(square3);

        }
        if (e.getSource()==square4)
        {
            System.out.println("4");
            square4.setEnabled(false);
            setTextAndDoWinCheck(square4);

        }
        if (e.getSource()==square5)
        {
            System.out.println("5");
            square5.setEnabled(false);
            setTextAndDoWinCheck(square5);

        }
        if (e.getSource()==square6)
        {
            System.out.println("6");
            square6.setEnabled(false);
            setTextAndDoWinCheck(square6);

        }
        if (e.getSource()==square7)
        {
            System.out.println("7");
            square7.setEnabled(false);
            setTextAndDoWinCheck(square7);

        }
        if (e.getSource()==square8)
        {
            System.out.println("8");
            square8.setEnabled(false);
            setTextAndDoWinCheck(square8);

        }
        if (e.getSource()==square9)
        {
            System.out.println("9");
            square9.setEnabled(false);
            setTextAndDoWinCheck(square9);

        }
    }
}
