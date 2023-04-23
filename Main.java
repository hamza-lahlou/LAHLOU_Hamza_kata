import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static int x,y;
	private static char direction;
	private static Scanner scanner;
	private static String instructions;
	private static int maxX=0;
	private static int maxY=0;
	public static char turnRight() {
		switch(direction) {
		case 'N':
			direction='E';
			break;
		case 'E':
			direction='S';
			break;
		case 'S':
			direction='W';
			break;
		case 'W':
			direction='N';
			break;
		}
		return direction;
	}
	public static char turnLeft() {
		switch(direction) {
		case 'N':
			direction='W';
			break;
		case 'E':
			direction='N';
			break;
		case 'S':
			direction='E';
			break;
		case 'W':
			direction='S';
			break;
		}
		return direction;
	}
	public static void move() {
		switch(direction) {
		case 'N':
			y++;
			break;
		case 'E':
			x++;
			break;
		case 'S':
			y--;
			break;
		case 'W':
			x--;
			break;
		}
	}
	public static void main(String[] args){

		try {
			scanner= new Scanner(new File(args[0]));
			String[] upperRightPlateauCoordinates = scanner.nextLine().split(" ");
			maxX= Integer.parseInt(upperRightPlateauCoordinates[0]);
			maxY= Integer.parseInt(upperRightPlateauCoordinates[1]);
			
			while(scanner.hasNext()) {
				String[] roverCoordinate = scanner.nextLine().split(" ");
				x=Integer.parseInt(roverCoordinate[0]);
				y=Integer.parseInt(roverCoordinate[1]);
				direction=roverCoordinate[2].charAt(0);
				
				instructions=scanner.nextLine();
				
				for(int i=0; i<instructions.length();i++) {
					char currentInstruction = instructions.charAt(i);
					switch(currentInstruction) {
					case 'L':
						turnLeft();
						break;
					case  'R':
						turnRight();
						break;
					case 'M':
						move();
						break;
					}
				}
				if(x<0) x=0;
				if(x>maxX) x=maxX;
				if(y<0) y=0;
				if(y>maxY) y=maxY; 
				System.out.println(x+" "+y+" "+direction);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}
}
