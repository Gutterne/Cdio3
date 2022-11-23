package org.example;
import Fields.Field;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
public class GameRunner4 {
    int p1,p2,p3,p4;
    Holder holder;
    Board board3;
    public GameRunner4(){
        holder=new Holder();
        board3= new Board();
    }
    public void GameRun4(GUI_Player play1, GUI_Player play2,GUI_Player play3, GUI_Player play4, GUI_Field[] board2, GUI gui, Player player1, Player player2, Player player3, Player player4){
        gui.showMessage("Player1 tryk enter:");
        p1 += holder.sum();
        gui.setDice(holder.die1.getFacevalue(), holder.die2.getFacevalue());
        int m = p1 % 24;
        if(board2[(p1 - holder.getSum()) % 24].hasCar(play2)){
            board2[(p1 - holder.getSum()) % 24].removeAllCars();
            board2[(p1 - holder.getSum()) % 24].setCar(play2,true);
        }
        else
            board2[(p1 - holder.getSum()) % 24].removeAllCars();
        board2[m].setCar(play1, true);

        Field playerField1 = board3.fieldlist[m];
        playerField1.landOndField(player1, player2);
        play1.setBalance(player1.myWallet.getMoney());
        play2.setBalance(player2.myWallet.getMoney());
        if(playerField1.isOwned()&&player1.getOwnerlist(m+1)){
            gui.showMessage("Player1 owns this property");

        }
        else if (playerField1.isOwned()&& !player1.getOwnerlist(m+1))
            gui.showMessage("This property belongs to player2, pay rent player1");
        else
            System.out.println();


        gui.showMessage("Player2 tryk enter:");
        p2 += holder.sum();
        gui.setDice(holder.die1.getFacevalue(), holder.die2.getFacevalue());
        int n = p2 % 24;
        if(board2[(p2 - holder.getSum()) % 24].hasCar(play1)){
            board2[(p2 - holder.getSum()) % 24].removeAllCars();
            board2[(p2 - holder.getSum()) % 24].setCar(play1,true);
        }
        else
            board2[(p2 - holder.getSum()) % 24].removeAllCars();
        board2[n].setCar(play2, true);
        Field playerField2 = board3.fieldlist[n];
        playerField2.landOndField(player2, player1);
        play2.setBalance(player2.myWallet.getMoney());
        play1.setBalance(player1.myWallet.getMoney());
        if(playerField2.isOwned()&&player2.getOwnerlist(n+1)){
            gui.showMessage("Player2 owns this property");
        }
        else if (playerField2.isOwned()&& !player2.getOwnerlist(n+1))
            gui.showMessage("This property belongs to player1, pay rent player2");
        else
            System.out.println();

    }

}




