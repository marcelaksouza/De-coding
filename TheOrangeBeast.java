package openet;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * FastStart - a robot by (your name here)
 */
public class TheOrangeBeast extends Robot
{

	/**
	 * run: Robocode's default behavior
	 */
	public void run() {
		
		double initialBodyDegree = getHeading();
		double initialGunDegree = getGunHeading();
		
		
		
		if (initialGunDegree > initialBodyDegree){
			turnGunLeft((initialGunDegree - initialBodyDegree)-90.0);		
		}
		else if (initialGunDegree < initialBodyDegree){
			turnGunRight((initialBodyDegree - initialGunDegree)+90.0);
		}
		if (initialBodyDegree == 0.0){
			ahead(getBattleFieldHeight() - getY());
		}
		else if (initialBodyDegree == 90.0){
			ahead(getBattleFieldWidth() - getX());	
		}
		else if (initialBodyDegree == 180.0){
			ahead(getY());	
		}
		else if (initialBodyDegree == 270.0){
			ahead(getX());	
		}
		else{
			turnRight(360.0 - initialBodyDegree);
		}
		
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(700);
			if (getGunHeading() > getHeading()){
				turnGunLeft(getGunHeading() - getHeading() - 90);
			}
			else if(getHeading() > getGunHeading()){
				turnGunRight(getHeading() - getGunHeading() + 90);
			}
			else if(getHeading() == getGunHeading()){
				turnGunRight(90);
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onScannedRobot(ScannedRobotEvent e){
	 if (e.getDistance() < 100) {
			fire(3);		}
		else{
			fire(1);
		}
	}	

	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(90);
	}	
	
	public void onHitRobot(HitRobotEvent e){
		
		if (e.getBearing() > -90 && e.getBearing() <=90) {
			turnGunLeft(90);
		}
		
	}
}

