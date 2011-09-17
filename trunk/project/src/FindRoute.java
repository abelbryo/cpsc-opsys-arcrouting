/*
 * This class contains the methods for finding the solution to the problem.
 */
public class FindRoute 
{
int node;
int noServiced;
Arc arcList[];
	/*
	 * 
	 */
	public void findRoute(int node ,Graph map)
	{
		noServiced= map.arcs;
		arcList= new Arc[map.arcs]; 
		while (noServiced>0)
		{
			/*
			 * there could be problems here i could be reading the matrix in the wrong order
			 */
			for(int i=0; i<=map.getMaxIntersections(); i++)
			{
				arcList[i]=map.getAdjMatrix(node, i);
			}
			/*
			 * This checks if an arc has been traversed the
			 */
			
			
			
			
			
			
			
			
			
			
		}
	}


}
