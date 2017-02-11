//package chess;
//
//import java.util.ArrayList;
//import java.util.ListIterator;
//
//import javax.swing.JOptionPane;
//
//import pieces.King;
//
///**
// * Created by carora on 2/10/17.
// */
//public class Util {
//
//  // A function to change the chance from White Player to Black Player or vice verse
//  // It is made public because it is to be accessed in the Time Class
//  public void changechance()
//  {
//    //if (boardState[getKing(chance).getx()][getKing(chance).gety()].ischeck())
//    //{
//    //	chance^=1;
//    //	gameend();
//    //}
//    //if(destinationlist.isEmpty()==false)
//    //	cleandestinations(destinationlist);
//    //if(previous!=null)
//    //	previous.deselect();
//    //previous=null;
//    //chance^=1;
//    //if(!end)
//    //{
//    //	//timer.reset();
//    //	//timer.start();
//    //	showPlayer.remove(CHNC);
//    //	if(Main.move=="White")
//    //		Main.move="Black";
//    //	else
//    //		Main.move="White";
//    //	CHNC.setText(Main.move);
//    //	showPlayer.add(CHNC);
//    //}
//  }
//
//  //A function to retrieve the Black King or White King
//  private King getKing(int color)
//  {
//    if (color==0)
//      return wk;
//    else
//      return bk;
//  }
//
//  //A function to clean the highlights of possible destination cells
//  private void cleandestinations(ArrayList<Cell> destlist)      //Function to clear the last move's destinations
//  {
//    ListIterator<Cell> it = destlist.listIterator();
//    while(it.hasNext())
//      it.next().removepossibledestination();
//  }
//
//  //A function that indicates the possible moves by highlighting the Cells
//  private void highlightdestinations(ArrayList<Cell> destlist)
//  {
//    ListIterator<Cell> it = destlist.listIterator();
//    while(it.hasNext())
//      it.next().setpossibledestination();
//  }
//
//
//  //Function to check if the king will be in danger if the given move is made
//  private boolean willkingbeindanger(Cell fromcell,Cell tocell)
//  {
//    Cell newboardstate[][] = new Cell[8][8];
//    for(int i=0;i<8;i++)
//      for(int j=0;j<8;j++)
//      {	try { newboardstate[i][j] = new Cell(boardState[i][j]);} catch (CloneNotSupportedException e){e.printStackTrace(); System.out.println("There is a problem with cloning !!"); }}
//
//    if(newboardstate[tocell.x][tocell.y].getpiece()!=null)
//      newboardstate[tocell.x][tocell.y].removePiece();
//
//    newboardstate[tocell.x][tocell.y].setPiece(newboardstate[fromcell.x][fromcell.y].getpiece());
//    if(newboardstate[tocell.x][tocell.y].getpiece() instanceof King)
//    {
//      ((King)(newboardstate[tocell.x][tocell.y].getpiece())).setx(tocell.x);
//      ((King)(newboardstate[tocell.x][tocell.y].getpiece())).sety(tocell.y);
//    }
//    newboardstate[fromcell.x][fromcell.y].removePiece();
//    if (((King)(newboardstate[getKing(chance).getx()][getKing(chance).gety()].getpiece())).isindanger(newboardstate)==true)
//      return true;
//    else
//      return false;
//  }
//
//  //A function to eliminate the possible moves that will put the King in danger
//  private ArrayList<Cell> filterdestination (ArrayList<Cell> destlist, Cell fromcell)
//  {
//    ArrayList<Cell> newlist = new ArrayList<Cell>();
//    Cell newboardstate[][] = new Cell[8][8];
//    ListIterator<Cell> it = destlist.listIterator();
//    int x,y;
//    while (it.hasNext())
//    {
//      for(int i=0;i<8;i++)
//        for(int j=0;j<8;j++)
//        {	try { newboardstate[i][j] = new Cell(boardState[i][j]);} catch (CloneNotSupportedException e){e.printStackTrace();}}
//
//      Cell tempc = it.next();
//      if(newboardstate[tempc.x][tempc.y].getpiece()!=null)
//        newboardstate[tempc.x][tempc.y].removePiece();
//      newboardstate[tempc.x][tempc.y].setPiece(newboardstate[fromcell.x][fromcell.y].getpiece());
//      x=getKing(chance).getx();
//      y=getKing(chance).gety();
//      if(newboardstate[fromcell.x][fromcell.y].getpiece() instanceof King)
//      {
//        ((King)(newboardstate[tempc.x][tempc.y].getpiece())).setx(tempc.x);
//        ((King)(newboardstate[tempc.x][tempc.y].getpiece())).sety(tempc.y);
//        x=tempc.x;
//        y=tempc.y;
//      }
//      newboardstate[fromcell.x][fromcell.y].removePiece();
//      if ((((King)(newboardstate[x][y].getpiece())).isindanger(newboardstate)==false))
//        newlist.add(tempc);
//    }
//    return newlist;
//  }
//
//  //A Function to filter the possible moves when the king of the current player is under Check
//  private ArrayList<Cell> incheckfilter (ArrayList<Cell> destlist, Cell fromcell, int color)
//  {
//    ArrayList<Cell> newlist = new ArrayList<Cell>();
//    Cell newboardstate[][] = new Cell[8][8];
//    ListIterator<Cell> it = destlist.listIterator();
//    int x,y;
//    while (it.hasNext())
//    {
//      for(int i=0;i<8;i++)
//        for(int j=0;j<8;j++)
//        {	try { newboardstate[i][j] = new Cell(boardState[i][j]);} catch (CloneNotSupportedException e){e.printStackTrace();}}
//      Cell tempc = it.next();
//      if(newboardstate[tempc.x][tempc.y].getpiece()!=null)
//        newboardstate[tempc.x][tempc.y].removePiece();
//      newboardstate[tempc.x][tempc.y].setPiece(newboardstate[fromcell.x][fromcell.y].getpiece());
//      x=getKing(color).getx();
//      y=getKing(color).gety();
//      if(newboardstate[tempc.x][tempc.y].getpiece() instanceof King)
//      {
//        ((King)(newboardstate[tempc.x][tempc.y].getpiece())).setx(tempc.x);
//        ((King)(newboardstate[tempc.x][tempc.y].getpiece())).sety(tempc.y);
//        x=tempc.x;
//        y=tempc.y;
//      }
//      newboardstate[fromcell.x][fromcell.y].removePiece();
//      if ((((King)(newboardstate[x][y].getpiece())).isindanger(newboardstate)==false))
//        newlist.add(tempc);
//    }
//    return newlist;
//  }
//
//  //A function to check if the King is check-mate. The Game Ends if this function returns true.
//  public boolean checkmate(int color)
//  {
//    ArrayList<Cell> dlist = new ArrayList<Cell>();
//    for(int i=0;i<8;i++)
//    {
//      for(int j=0;j<8;j++)
//      {
//        if (boardState[i][j].getpiece()!=null && boardState[i][j].getpiece().getcolor()==color)
//        {
//          dlist.clear();
//          dlist=boardState[i][j].getpiece().move(boardState, i, j);
//          dlist=incheckfilter(dlist,boardState[i][j],color);
//          if(dlist.size()!=0)
//            return false;
//        }
//      }
//    }
//    return true;
//  }
//
//
//
//  @SuppressWarnings("deprecation")
//  private void gameend()
//  {
//    cleandestinations(destinationlist);
//    displayTime.disable();
//    //timer.countdownTimer.stop();
//    if(previous!=null)
//      previous.removePiece();
//    if(chance==0)
//    {	White.updateGamesWon();
//      White.Update_Player();
//      winner=White.name();
//    }
//    else
//    {
//      Black.updateGamesWon();
//      Black.Update_Player();
//      winner=Black.name();
//    }
//    JOptionPane.showMessageDialog(board,"Checkmate!!!\n"+winner+" wins");
//    WhitePlayer.remove(wdetails);
//    BlackPlayer.remove(bdetails);
//    displayTime.remove(label);
//
//    displayTime.add(start);
//    showPlayer.remove(mov);
//    showPlayer.remove(CHNC);
//    showPlayer.revalidate();
//    showPlayer.add(timeSlider);
//
//    split.remove(board);
//    split.add(temp);
//    WNewPlayer.enable();
//    BNewPlayer.enable();
//    wselect.enable();
//    bselect.enable();
//    end=true;
//    Mainboard.disable();
//    Mainboard.dispose();
//    Mainboard = new Main();
//    Mainboard.setVisible(true);
//    Mainboard.setResizable(false);
//  }
//
//}
