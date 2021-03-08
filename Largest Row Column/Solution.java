import java.util.*; 
import java.io.*;
 
class Main {
 
  public static int[][] convertStringArrToMatrix(String[] strArr){
    int [][] matrix = new int [strArr.length][strArr[0].length()];
    for(int i = 0; i < strArr.length; i++){
      for(int j = 0; j < strArr[i].length(); j++){
        matrix[i][j] =  (int) (strArr[i].charAt(j)) - 48 ;
      }
    }
 
    // for(int i = 0; i < matrix.length; i++){
    //   for(int j = 0; j < matrix[i].length; j++){
    //     System.out.print(matrix[i][j]);
    //   }
    // }
    return matrix;
  }
 
  static class Pair <T>{
    T first;
    T second;
 
    public Pair(T frst, T scnd){
      this.first = frst;
      this.second = scnd;
    }
 
    T getFirst(){
      return this.first;
    }
    T getSecond(){
      return this.second;
    }
 
    public String toString(){ return "[" + this.getFirst() + "," + this.getSecond() + "]";}
  }
 
  public static ArrayList<Pair> findAdjacentElement(int[][] mtrx, int row, int col){
    ArrayList<Pair> adjacentElements = new ArrayList();
 
    // boolean upLeft = true;
    // boolean up = true;
    // boolean upRight = true;
    // boolean right = true;
    // boolean rightDown = true;
    // boolean down = true;
    // boolean downLeft = true;
    // boolean left = true;
 
    int height = mtrx.length;
    int width = mtrx[0].length;
    // System.out.println("height: " + height);
    // System.out.print("width: " + width);
 
    // if(row - 1 < 0 || col - 1 < 0){ // upLeft = false
    //   upLeft = false;
    // }
    // else{
    //   // add upLeft to the list
    //   adjacentElements.add(mtrx[row - 1][col - 1]);
    // }
 
    // if(row - 1 < 0){ // up = false
    //   up = false;
    // }
    // else{
    //   // add up to the list
    //   adjacentElements.add(mtrx[row - 1][col]);
    // }
 
    if(row - 1 >= 0){
      if(col - 1 >= 0){
        // add upLeft to the list
        // adjacentElements.add(mtrx[row - 1][col - 1]);
        adjacentElements.add(new Pair(row - 1, col - 1));
      }
      // add up to the list
      // adjacentElements.add(mtrx[row - 1][col]);
      adjacentElements.add(new Pair(row - 1, col));
    }
 
    // if(row - 1 < 0 || col + 1 > width){ // upRight = false
    //   upRight = false;
    // }
    // else{
    //   // add upRight to the list
    //   adjacentElements.add(mtrx[row - 1][col + 1]);
    // }
 
    // if(col + 1 > width){ // right = false 
    //   right = false;
    // }
    // else{
    //   // add right to the list
    //   adjacentElements.add(mtrx[row][col + 1]);
    // }
 
    if(col + 1 < width){
      if(row - 1 >= 0){
        // add upRight to the list
        // adjacentElements.add(mtrx[row - 1][col + 1]);
        adjacentElements.add(new Pair(row - 1, col + 1));
      }
      // add right to the list
      // adjacentElements.add(mtrx[row][col + 1]);
      adjacentElements.add(new Pair(row, col + 1));
    }
 
    // if(row + 1 > height || col +1 > width){ // rightDown = false
    //   rightDown = false;
    // }
    // else{
    //   // add rightDown to the list
    //   adjacentElements.add(mtrx[row + 1][col + 1]);
    // }
    
    // if(row + 1 > height){ // down = false
    //   down = false;
    // }
    // else{
    //   // add down to the list
    //   adjacentElements.add(mtrx[row + 1][col]);
    // }
 
    if(row + 1 < height){
      if(col +1 < width){
        // add rightDown to the list
        // adjacentElements.add(mtrx[row + 1][col + 1]);
        adjacentElements.add(new Pair(row + 1, col + 1));
      }
      // add down to the list
      // adjacentElements.add(mtrx[row + 1][col]);
      adjacentElements.add(new Pair(row + 1, col));
    }
 
    // if(row + 1 > height || col - 1 < 0){ // downLeft = false
    //   downLeft = false;
    // }
    // else{
    //   // add downLeft to the list
    //   adjacentElements.add(mtrx[row + 1][col - 1]);
    // }
 
    // if(col - 1 < 0){ // left = false
    //   left = false;
    // }
    // else{
    //   // add left to the list
    //   adjacentElements.add(mtrx[row][col - 1]);
    // }
 
    if(col - 1 >= 0){
      if(row + 1 < height){
        // add downLeft to the list
        // adjacentElements.add(mtrx[row + 1][col - 1]);
        adjacentElements.add(new Pair(row + 1, col - 1));
      }
      // add left to the list
      // adjacentElements.add(mtrx[row][col - 1]);
      adjacentElements.add(new Pair(row, col - 1));
    }
 
    return adjacentElements;
  }
 
  public static void printList(ArrayList<Pair> adjacentElementList){
    for (int i = 0; i < adjacentElementList.size(); i++) {
      System.out.print(adjacentElementList.get(i));
    }
    System.out.println("");
  }
 
  public static boolean checkTwoElmntAdjacency(Pair firstIdx, Pair secondIdx){
    int frstI = (int) firstIdx.getFirst();
    int frstJ = (int) firstIdx.getSecond();
 
    int scndI = (int) secondIdx.getFirst();
    int scndJ = (int) secondIdx.getSecond();
 
    if(frstI == scndI && scndJ - frstJ == 1){
      return true;
    } else if(frstJ == scndJ && scndI - frstI == 1){
      return true;
    }
    return false;
  }
 
  public static boolean checkAdjacency(Pair firstIdx, Pair secondIdx, Pair thirdIdx){
    boolean firstAdjncy = checkTwoElmntAdjacency(firstIdx, secondIdx);
    boolean scndAdjancy = checkTwoElmntAdjacency(secondIdx, thirdIdx);
    boolean thrdAdjancy = checkTwoElmntAdjacency(thirdIdx, firstIdx);
 
    System.out.println("firstAdjncy is: " + firstAdjncy);
    System.out.println("scndAdjancy is: " + scndAdjancy);
    System.out.println("thrdAdjancy is: " + thrdAdjancy);
 
    if(firstAdjncy && scndAdjancy){
      return true;
    }else if(thrdAdjancy && firstAdjncy){
      return true;
    }
    return false;
  }
 
  // sorts ascending
  public static ArrayList<Pair> sortPairs(int [][] mtrx, ArrayList<Pair> adjacentElements){
 
    // System.out.println("before sorting: ");
    // printList(adjacentElements);
 
    for(int i = 0; i + 1 < adjacentElements.size(); i++){
      Pair pair0 = adjacentElements.get(i);
      Pair pair1 = adjacentElements.get(i + 1);
 
      if(mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()] > mtrx[ (int) pair1.getFirst()][ (int) pair1.getSecond()]){
        // int temp = mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()];
        // mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()] = mtrx[ (int) pair1.getFirst()][ (int) pair1.getSecond()];
        // mtrx[ (int) pair1.getFirst()][ (int) pair1.getSecond()] = temp;
 
        int temp = i;
        adjacentElements.set(i, pair1);
        adjacentElements.set(i + 1, pair0);
        
        // System.out.println(" ");
        // System.out.println("temp: " + mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()]);
        // System.out.println("diger temp: " + mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()]);
        
        i = -1;
      }
    }
    // System.out.println(" ");
    // System.out.println("After sorting: ");
    // printList(adjacentElements);
 
    return adjacentElements;
  }
 
  public static int findLargestSum(int [][] mtrx, ArrayList<Pair> adjacentElements){
    int maximumSum = mtrx[0][0];
    int listSize = adjacentElements.size();
    boolean adjacency = false;
 
    // adjacentElements = sortPairs(mtrx, adjacentElements);
    for(int i = 0; i + 2 < listSize; i++){
      
      Pair pair0 = adjacentElements.get(i);
      Pair pair1 = adjacentElements.get(i + 1);
      Pair pair2 = adjacentElements.get(i + 2);
 
      // System.out.println("pair0: " + mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()]);
      // System.out.println("pair1: " + mtrx[ (int) pair1.getFirst()][ (int) pair1.getSecond()]);
      // System.out.println("pair2: " + mtrx[ (int) pair2.getFirst()][ (int) pair2.getSecond()]);
 
      int sum = mtrx[ (int) pair0.getFirst()][ (int) pair0.getSecond()] + 
                  mtrx[ (int) pair1.getFirst()][ (int) pair1.getSecond()] + 
                  mtrx[ (int) pair2.getFirst()][ (int) pair2.getSecond()];
      adjacency = checkAdjacency(pair0, pair1, pair2);
 
      if(adjacency){
        maximumSum = Math.max(maximumSum, sum);
        System.out.println("Max sum is: " + maximumSum);
      }
    }
    
    // System.out.println("Max sum is: " + maximumSum);
    return maximumSum;
  }
 
  public static boolean checkMtrxBounds(int[][] mtrx, int sum){
 
    int height = mtrx.length;
    int width = mtrx[0].length;
 
    int firstDigit = sum / 10;
    int secondDigit = sum - firstDigit * 10;
 
    System.out.println("First digit: " + firstDigit);
    System.out.println("Second digit: " + secondDigit);
 
    System.out.println("width: "+ width);
    System.out.println("height: " + height);
 
    if(firstDigit >= 0 && firstDigit < height && secondDigit >= 0 && secondDigit < width){
      return true;
    }
    return false;
  }
  public static int LargestRowColumn(String[] strArr) {
    // code goes here
    int [][] matrix = convertStringArrToMatrix(strArr);
    int sum = matrix[0][0];
    // System.out.println("Element sent: " + matrix[1][1]);
    // ArrayList<Pair> adjacentElements = findAdjacentElement(matrix, 1, 1);
 
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length; j++){
        System.out.println("Element sent: " + matrix[i][j]);
        ArrayList<Pair> adjacentElements = findAdjacentElement(matrix, i, j);
        printList(adjacentElements);
        sum = findLargestSum(matrix, adjacentElements);
        System.out.println("Sum is :" + sum);
        // boolean mtrxBounds = checkMtrxBounds(matrix, sum);
        // if(mtrxBounds){
        //   return sum;
        // }
      }
    }
    
    return sum;
  }
 
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(LargestRowColumn(s.nextLine())); 
  }
 
}
 