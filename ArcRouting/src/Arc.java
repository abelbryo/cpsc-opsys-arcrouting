



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
	String streetName="grouch";
	public int row;
	public int column;
	boolean required;

	/*
	 *  this is the second constructor it creates an arc with every value as zero 
	 *  it is used to form the adjacency matrix
	 */
	public Arc()
	{
		streetName ="tikeynull";
		roadTook =0;
		collectionPoints = 0;
		timeArc=0;
		arcDistance=0;
		column = 0;
		row=0;
		required=true;
	}


	/*
	 * This is the constructor for the arc object
	 */




	public Arc(String title , int collection,int time ,int length)
	{
		streetName =title;
		roadTook =0;
		collectionPoints = collection ;
		timeArc=time;
		arcDistance=length;
		column = 0;
		row=0;
		required=true;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " Arc [ roadTook= " + roadTook + " , collectionPoints= "
				+ collectionPoints + " , timeArc= " + timeArc + " , arcDistance= "
				+ arcDistance + " , streetName= " + streetName + " ,  row= " + row
				+ " , column= " + column + " , required= " + required + " ] ";
	}


	public boolean getRequired()
	{
		return required;
	}
	
	public void setRequired(boolean a)
	{
		required=a;
	}
	
	
	public int getRow()
	{
		return row;
	}

	public void setRow(int a)
	{
		row=a;

	}

	public int getCol()
	{
		return column;
	}

	public void setCol(int a)
	{
		column=a;

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
		//sum=this.getCollectionPoints()+this.getDistance()+this.getTime()+this.getRoadTook();
		sum=this.getCollectionPoints()+this.getDistance()+this.getTime()+this.getRoadTook();
		return sum;
	}
	
}

//}
