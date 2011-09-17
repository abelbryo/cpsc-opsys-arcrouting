/*
 * This class contains the methods for finding the solution to the problem.
 */
public class FindRoute 
{
	int node;
	int noServiced; //number arcs serviced
	Arc arcList[];
	int counter;
	/*
	 * 
	 */
	public void findRoute(int node ,Graph map)
	{
		noServiced= map.arcs; //loads the number to be serviced with the total arcs
		arcList= new Arc[map.arcs]; 

		while (noServiced>0)
		{
			/*
			 * there could be problems here i could be reading the matrix in the wrong order
			 * this loop gets everything adjacent with a node
			 */
			for(int i=0; i<=map.getMaxIntersections(); i++)
			{
				arcList[i]=map.getAdjMatrix(node, i);
				counter++;
			}
			/*
			 * This checks if an arc has been traversed this technique will always choose unserviced roads
			 * over serviced roads to reduce dead heading.
			 */

		}
	}

	/*
	 * this method will check to see if all the arcs conected with the node have been serviced.
	 * The method will then return a true if they have and a false otherwise
	 */
	public boolean allTraversed(Arc adjArray[])
	{
		//this for loop changes the roads serviced to null
		for(int i=0; i<=adjArray.length; i++)
		{
			if(adjArray[i].roadTook != 0)
			{
				adjArray[i]=null;
			}
		}

		for(int j=0; j<=adjArray.length; j++)
		{
			if(adjArray[j] == null)
			{
				
			}
		}
		return false;
	}

}
