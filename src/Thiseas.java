import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Thiseas {
	
	public static String [][] maze;
	public static StringStack stoiva;
	
	public static void SaveCoordinates(int x, int y){
		stoiva.push(Integer.toString(x));
		stoiva.push(Integer.toString(y));
	}
	public static int[] LoadCoordinates(){
		int[] result = {Integer.parseInt(stoiva.pop()), Integer.parseInt(stoiva.pop())};
		return result;
	}
	
	public static boolean isExit(int x, int y){
		int dimy = maze.length-1;
		int dimx = maze[0].length-1;
		if ((maze[y][x].equals("0"))&&(x==0||y==0||x==dimx||y==dimy)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void addNeighbors(int x, int y){
		int dimy = maze.length;
		int dimx = maze[0].length;		
		if((x+1<dimx)&&(maze[y][x+1]).equals("0")){
			SaveCoordinates(x+1, y);
		}if((y+1<dimy)&&(maze[y+1][x].equals("0"))){
			SaveCoordinates(x, y+1);
		}if((y-1>=0)&&(maze[y-1][x].equals("0"))){
			SaveCoordinates(x, y-1);
		}if((x-1>=0)&&(maze[y][x-1].equals("0"))){
			SaveCoordinates(x-1, y);
		}
	}

	/* afhnw th me8odo print maze san sxolio edw se periptwsh pou 8eloume na ektypwsoume to lavyrintho
	public static void printMaze(){
//		 Test
//				 print array we read
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[j].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
	*/
	
	
	public static void LabExit(int startX, int startY){
		int[] v = new int [2];
		SaveCoordinates(startX, startY);
		while(!stoiva.isEmpty()){
			v = LoadCoordinates();
			// check if we have reached exit
			if (isExit(v[1],v[0])){
				System.out.printf("We have found an exit: (%d, %d)\n",v[0],v[1]);
				return;
			} else if(!maze[v[0]][v[1]].equals("2")){
				// mark as visited
				maze[v[0]][v[1]] = "2";
				//find neighbors
				addNeighbors(v[1],v[0]);			
			}
		}
		// We have not found an exit
		System.out.println("The maze given does not have a solution");
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		String path = args[0];
		Scanner txtfile = new Scanner(new File(path));
		try{
			int dimX, dimY, startX, startY;
		
		
		dimY = txtfile.nextInt();
		dimX = txtfile.nextInt();
		startY = txtfile.nextInt();
		startX = txtfile.nextInt();
		
		// eat up newline char
		txtfile.nextLine();
		
		int realDimX = 0;
		int realDimY = 0;
		
		maze = new String [dimY][dimX];
		
		while(txtfile.hasNextLine()){
			String line = txtfile.nextLine();
			if (realDimY>=dimY){
				System.out.println("Error2, lines differ from dimentions");
				return;
			}
			maze[realDimY] = line.split(" ");
			
			realDimX = maze[realDimY].length;
			if (realDimX!=dimX){
				System.out.println("Error1, lines differ from dimentions");
				return;
			}
			realDimY++;
			
			
		}
		if (realDimY!=dimY){
			System.out.println("Error2, lines differ from dimentions");
			return;
		}
		
		if (!maze[startY][startX].equals("E")){
			// error
			System.out.println("Error E");
			return;
		}
		
		
		
		
		//DFS gia lavyrintho
		stoiva = new StringStackImpl();
		LabExit(startX,startY);
		
		
		
		}// finalization, close Scanner (close file)
		finally{
			txtfile.close();
		}
		
		
	}
	
	
}
