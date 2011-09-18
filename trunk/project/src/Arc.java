import java.util.*;



public class Arc 
{
	/*
	 * This is the class that contains the constructor and the methods to interact with and arc object
	 */

	//public void arc(int visited, int majCollection,int minCollection,boolean wasUsed,int time,boolean directed)
	int roadTook;
	int collectionPoints;
	int timeArc;
	int arcDistance;
	String streetName;
	int row;
	int column;

	/*
	 *  this is the second constructor it creates an arc with every value as zero 
	 *  it is used to form the adjacency matrix
	 */
	public Arc()
	{
		streetName ="0";
		roadTook =0;
		collectionPoints = 0;
		timeArc=0;
		arcDistance=0;

	}


	/*
	 * This is the constructor for the arc object
	 */




	public Arc(String title ,int visited, int collection,int time ,int distance)
	{
		streetName =title;
		roadTook =visited;
		collectionPoints = collection ;
		timeArc=time;
		arcDistance=distance;
		int row=0;
		int column=0;

	}

	public int getRow()
	{
		return row;
	}

	public void setRow(int a)
	{
		row=a;

	}

	public int getcol()
	{
		return row;
	}

	public void setcol(int a)
	{
		row=a;

	}

	/*
	 *  This is the method to get how many times a road was took
	 *  we opted to keep track of how many time a road was traversed rather then
	 *  if it was traversed just in case we need the information in the future.
	 */
	public int getRoadTook()
	{

		return roadTook;
	}
	/*
	 * This is the method that allows you to manipulate the number of times an arc was traversed
	 */

	public int setRoadTook(int newRoad)
	{
		roadTook = newRoad;
		return roadTook;

	}
	/*
	 * This method allows you to get the number of collection points along an arc
	 */
	public int getCollectionPoints()
	{

		return collectionPoints;
	}
	/*
	 * This method allows you to manipulate the number of collection points along an arc
	 */
	public int setCollectionPoints(int newCollectionpoints)
	{
		collectionPoints = newCollectionpoints;
		return collectionPoints;

	}
	/*
	 * This method allows you  get the amount of time it takes to traverse an arc.
	 */
	public int getTime()
	{

		return timeArc;
	}
	/*
	 * this method allows you to set the time it takes to traverse an arc.
	 */
	public int setTime(int newTime)
	{
		timeArc = newTime;
		return timeArc;

	}
	/*
	 * This method allows you  get the amount of distance it takes to traverse an arc.
	 */
	public int getDistance()
	{

		return arcDistance;
	}
	/*
	 * this method allows you to set the distance it takes to traverse an arc.
	 */
	public int setDistance(int newDistance)
	{
		arcDistance = newDistance;
		return arcDistance;

	}


	public String getTitle()
	{

		return streetName;
	}
	/*
	 * this method allows you to set the distance it takes to traverse an arc.
	 */
	public String setTitle(String newTitle)
	{
		streetName = newTitle;
		return streetName;
	}

	/*
	 * This method figures out what the cost is to traverse an arc.
	 */
	public int getSumCost()
	{
		int sum =0;
		sum=this.getCollectionPoints()+this.getDistance()+this.getTime();
		return sum;
	}
}

//}
