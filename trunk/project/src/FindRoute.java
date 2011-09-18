/*
 * This class contains the methods for finding the solution to the problem.
 */
public class FindRoute 
{
	int node;
	int noServiced; //number arcs serviced
	Arc arcList[];
	Arc arcPath[];
	int newNode=0;

	/*
	 * 
	 */
	public void findRoute(int node ,Graph map)
	{
		noServiced= map.arcs; //loads the number to be serviced with the total arcs
		arcList= new Arc[map.arcs]; 

		//System.out.println(noServiced);
		while (noServiced>0)
		{
			/*
			 * there could be problems here i could be reading the matrix in the wrong order
			 * this loop gets everything adjacent with a node
			 */
			for(int i=0; i<map.arcs; i++)
			{
				arcList[i]=map.getAdjMatrix(node,i);
				if(arcList[i]!=null)
				{
					System.out.println(arcList[i].getTitle());
				}
						
				//		System.out.println("current path "+arcList[noServiced].getTitle());
			}
				arcPath[noServiced]=compareArcs(arcList);
				//arcPath[noServiced].getRow
			node=newNode;
			//System.out.println("node is: "+node + " newNode is: "+newNode);
			//	System.out.println(noServiced);
			noServiced--;			


		}

		//printRoute(arcPath);
	}




	public void printRoute(Arc finPath[])
	{
		System.out.println("Take");
		for(int i =0; i<=arcPath.length; i++)
		{
			System.out.println(" to "+arcPath[i]);
		}
	}


	/*
	 *  This is the method in which the arcs are compared 
	 *  it returns the best arc to take.
	 */
	public Arc compareArcs(Arc adjArray[])
	{
		Arc bestAnswer= adjArray[0];
		// FIX
		int bestSum=Integer.MAX_VALUE;
		/*
		 * This section checks which  path to take my summing the cost of the arcs. 
		 * if all of the arcs have been traversed
		 */
		if(allTraversed(adjArray)== true)
		{
			for(int i=1; i<=adjArray.length;i++)
			{
				if(bestSum >adjArray[i].getSumCost())
				{
					bestAnswer=adjArray[i];
				}
			}
			return bestAnswer;
		}
		/*
		 * This section checks which  path to take my summing the cost of the arcs. 
		 * if not all or none of the arcs have been traversed
		 */

		else if (allTraversed(adjArray)== false)
		{
			for(int i=1; i<=adjArray.length;i++)
			{
				if(bestSum >adjArray[i].getSumCost() && adjArray[i].getRoadTook()==0)
				{
					bestAnswer=adjArray[i];
				}
			}
			return bestAnswer;
		}


		return null;

	}



	/*
	 * this method will check to see if all the arcs connected with the node have been serviced.
	 * The method will then return a true if they have and a false otherwise
	 */
	public boolean allTraversed(Arc adjArray[])
	{
		//this for loop changes the roads serviced to null
		for(int i=0; i<=adjArray.length; i++)
		{
			if(adjArray[i].getRoadTook() !=0 )
			{
				adjArray[i].streetName=null;
			}
		}
		/*
		 *  this loop checks to see if they are all null
		 */
		for(int j=0; j<=adjArray.length; j++)
		{
			if(adjArray[j].streetName != null)
			{
				return true;	
			}
		}
		return false;
	}

}
