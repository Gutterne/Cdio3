package org.example;

public class Player {
   public Wallet myWallet;
    private int position;
    private int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
private boolean[] ownerlist = new boolean[]{false,false,false,false,false,false,false,false,
false,false,false,false,false,false,false,false,false,false,false,
false,false,false,false,false,false,false,false};

    public Player() {
        myWallet = new Wallet();
    }

    public boolean[] getOwnerlist() {
        return ownerlist;
    }

    public void setOwnerlist(boolean[] ownerlist) {
        this.ownerlist = ownerlist;
    }

    public int[] moveSquare (int n) {

        if (n >= 0) {

            for (int j = 0; j < n; j++) {
                int first = ints[0];

                for (int i = 0; i < ints.length - 1; i++)
                    ints[i] = ints[i + 1];

                ints[ints.length - 1] = first;
            }}
        return ints;
    }
    public int showIntPosition(){
        position=ints[0];
        return position;
    }



}
