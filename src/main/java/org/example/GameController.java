package org.example;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;


import java.util.Scanner;

public class GameController {
    Holder holder;
boolean Gaming = true;

    //GUI_Player player1,player2,player3,player4;
    Player player1;
    Player player2;
    Player player3;
    Player player4;


    GUI_Player playerz;
    GUI_Player playery;
    GUI_Player playerx;
    GUI_Player kartoffelcheck;




    Board board2;
    public GameController(){
        holder=new Holder();


        this.player1 = new Player("Bob",20);
        this.player2 = new Player("Billy",20);
        player3 = new Player("Jurgen",20);
        player4= new Player("Hej",20);
        board2= new Board();
        GameBoard gameBoard = new GameBoard(board);
    }
    private GameBoard[] board;


    Scanner scanner = new Scanner(System.in);
    boolean playing = true;


    String inputText= "";
String Textdata;

    public void play() {
        GUI_Field[] board = GameBoard.makeFields();
        GUI_Field[] board2 = new GUI_Field[24];

        for(int i = 0; i < board2.length; ++i) {
            board2[i] = board[i];
        }

        GUI gui = new GUI(board2);


        Textdata = "" + gui.getUserString(inputText);
        while (playing) {

            System.out.println(gui.getUserButtonPressed(inputText, new String[]{"Tryk!"}));
            gui.getUserInteger(inputText);



            gui.showMessage("Du har indtastet :" + Textdata);
            // System.out.println(Textdata);
            int x = Integer.parseInt(Textdata);
            System.out.println(x);



//PROBLEMET LIGGER HER
            player1.setPlayerAmount(x,gui,board2,player1);

            holder.sum();
            gui.setDice(holder.die1.getFacevalue(),holder.die2.getFacevalue());

            //player1.moveSquare(holder.getSum());

            player1.moveCar1(board2,holder.getSum(),player1);

            gui.getUserButtonPressed("ja", String.valueOf(true));
            holder.sum();
            gui.setDice(holder.die1.getFacevalue(),holder.die2.getFacevalue());
            player2.setPlayerAmount2(x,gui,board2,player2);
            player2.moveCar2(board2, holder.getSum(),player2);



           /*
                        for(int i = 0; i <  parseTextdata; ++i) {
                        }
                  //  }
                //} catch (Exception e) {
                  //  System.out.println("Den er helt gakgak");
*/






            updateFlow();
            while (holder.getSum() == 10) {
                System.out.println("Du får et ekstra slag");
                updateFlow();

            }
            if (player1.myWallet.getMoney() >= 3000) {
                playing = false;
                System.out.println("Spiller 1 har vundet");
                break;
            }

            updateFlow2();
            while (holder.getSum() == 10) {
                System.out.println("Du får et ekstra slag");
                updateFlow2();

            }
            if (player2.myWallet.getMoney() >= 3000) {
                playing = false;
                System.out.println("Spiller 2 har vundet");
                break;
            }
        }
    }

    public void PlayerChecker() {
    }

    public void updateFlow(){
        System.out.println("Tryk på enter spiller 1");
        String p1 = scanner.nextLine();
        //holder.sum();

        Comment();
        System.out.println(" player 1 har nu "+player1.myWallet.UpdateMoney()+" ");
    }


    public void updateFlow2(){
        System.out.println("Tryk på enter spiller 2");
        String p2 = scanner.nextLine();
        System.out.println();
        //holder.sum();

        Comment();
        System.out.println(" player 2 har nu "+player2.myWallet.UpdateMoney()+" ");
    }

    public void Comment(){

        }
    }


