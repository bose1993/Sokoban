package sokoban;
/**
 * This file is part of Sokoban By Bose.
 *
 *  Sokoban By Bose is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Sokoban By Bose is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with Sokoban By Bose.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * @version 1.0
 * Classe di gestione del gioco Sokoban
 * @author e.bosetti
 */
public class SokobanGame {
    private boolean Campo[][];
    private int riga;
    private int colonna;
    
    /**
     * Costruttore che setta la posizione di mario e della scatola
     * @param mx Coordinata X Mario
     * @param my Coordinata Y Mario
     * @param bx Coordinata X Scatola
     * @param by Coordinata Y Scatola
     */
    public SokobanGame(int mx, int my, int bx, int by){
        this.Campo= new boolean[5][5];
        for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){
                this.Campo[r][c]=false;
            }
        }
        
        this.riga=my;
        this.colonna=mx;
        this.Campo[by][bx]=true;
    }
    
    /**
     * Ritorna true o false in base se si esce o meno dalla mappa
     * @param r coordinata Y
     * @param c coordinata X
     * @param m tipo di mossa
     * @return true/false in base se esce o meno dalla mappa
     */
    private boolean canMove(int r,int c, int m){
        switch(m){
            case 1:
                if(r-1<0)
                    return false;
                break;
            case 2:
                if(c+1>4)
                    return false;
                break;
            case 3:
                if(r+1>4)
                    return false;
                break;
            case 4:
                if(c-1<0)
                    return false;
                break;
        }
        
        return true;
    }
    
    /**
     * Torna le coordinate della posizione attuale della scatola
     * @return array poszione 0 le Y poszione 1 le X
     */
    private int[] getBoxCoordinate(){
        for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){
                if(this.Campo[r][c]==true){
                    int result[] = new int[2];
                    result[0]=r;
                    result[1]=c;
                    return result;
                }
            }
        }
        return null;
    }
    
    /**
     * Verifica se le coordinate inserite sono le stelle caselle della posizione attuale della scatola
     * @param r Coordinate Y
     * @param c Coordinate X
     * @return true/false se le coordinate sono le stesse o meno
     */
    private boolean hitBox(int r,int c){
        int coord[] = this.getBoxCoordinate();
        return coord[0]==r && coord[1]==c;
    }
    
    /**
     * Muove mario in base alla tipologia di mossa
     * 1. Alto
     * 2. Destra
     * 3. Basso
     * 4. Sinistra
     * @param m prametro con tipologia di mossa
     * @return 
     */
    public boolean move(int m){
        if(m>4 || m<0)
            return false;
        if(this.canMove(this.riga, this.colonna, m)){
           int nextMarioCoordinate[] = this.nextCoordinate(this.riga,this.colonna, m);
           if(this.hitBox(nextMarioCoordinate[0], nextMarioCoordinate[1])){
               int coord[] = this.getBoxCoordinate();
               if(this.canMove(coord[0], coord[1], m)){
                   int newcoord[] = this.nextCoordinate(coord[0], coord[1], m);
                   this.Campo[coord[0]][coord[1]]=false;
                   this.Campo[newcoord[0]][newcoord[1]]=true;
               }else{
                   return false;
               }
           }
            this.riga=nextMarioCoordinate[0];
            this.colonna=nextMarioCoordinate[1];
           
        }else{
            return false;
        }
        return true;
    }
    
    /**
     * Trova le prossime coordinate in base alla mossa passata
     * @param r Coordinate Y
     * @param c Coordinate X
     * @param m Tipologia di mossa
     * @return array nella posizione 0 le Y nella poszione 1 le X
     */
    public int[] nextCoordinate(int r,int c, int m){
        int newCord [] = new int[2];
         switch(m){
            case 1:
                newCord[0] = r-1;
                newCord[1] = c;   
                break;
            case 2:
                newCord[1]=c+1;
                newCord[0]=r;
                break;
            case 3:
                newCord[0]=r+1;
                newCord[1]=c;
                break;
            case 4:
                newCord[1]=c-1;
                newCord[0]=r;
                break;
        }
        return newCord;
    }
    
    /**
     * Stampa il terreno di gioco
     */
    
    public void print(){
        for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){
                int BCoord[] = this.getBoxCoordinate();
                if(r==BCoord[0]&&c==BCoord[1]){
                    System.out.print("B");
                }else{
                    if(r==this.riga&&c==this.colonna){
                        System.out.print("M");
                    }else{
                        System.out.print(" ");
                    }
                    
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.println("- - - - -");
        }
    }
}
