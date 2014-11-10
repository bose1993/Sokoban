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

package sokoban;

import java.util.Scanner;

/**
 * @version 1.0
 * @author e.bosetti
 */
public class Sokoban {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SokobanGame s = new SokobanGame(0,0,1,1);
       s.print();
       while(true){
           Scanner input = new Scanner(System.in);
           String m = input.nextLine();
           try{
            s.move(Integer.parseInt(m));
           }catch(NumberFormatException e){
                   
            }
           s.print();
       }
    }
    
}
