

import java.util.ArrayList;

public class Graph 
{
	private final int MAXIMUM_INTERSECTIONS = 15; //number of nodes in a graph
	public char label;
	public boolean wasVisited;
	private Arc adjMatrix[][];	// this is the adjacency matrix

	/*
	 * This is the list of vertex's in the future it should be turned from an array
	 * of characters to and array or strings or int's to better define the area covered
	 */
	public char  vertexList[];
	private int countInterections;
	public int arcs =0;


	//public LinkedList<Comparable> arcList;
	ArrayList<Arc> arcList=new ArrayList<Arc>();

	/*
	 * This is the constructor that makes a new object graph
	 */
	public Graph()
	{
		vertexList= new char[MAXIMUM_INTERSECTIONS];
		adjMatrix=new Arc[MAXIMUM_INTERSECTIONS][MAXIMUM_INTERSECTIONS];
		countInterections=0;
		/*for(int i=0; i<MAXIMUM_INTERSECTIONS ;  i++)
		{
			for(int j=0; j<MAXIMUM_INTERSECTIONS; j++)
			{
				adjMatrix[i][j].setCollectionPoints(0);
				adjMatrix[i][j].setDistance(0);
				adjMatrix[i][j].setRoadTook(0);
				adjMatrix[i][j].setTime(0);
				adjMatrix[i][j].setTitle("0");
			}

		}*/


	}

	/*
	 * This is the method that adds a vertex to the list of vertices 
	 */
	public void addVertex(char label) 
	{
		vertexList[countInterections++]=label;
	}


	/*
	 * This is the method that adds the arc to the adjacency matrix start and end 
	 * are the starting and ending nodes respectively 
	 * This will work for just out examples it will need changed once we factor in different sides
	 * costing different amounts
	 */
	public void addArc(int start, int end , String name, int visited,int collection ,int time , int distance )
	{
		adjMatrix[start][end]= new Arc(name , visited , collection, time ,distance );
		adjMatrix[end][start]= new Arc(name , visited , collection, time ,distance );
		arcs++;
	}
	/*
	 * This method displays of how many arcs are in the graph
	 */
	public int getArcs()
	{
		return arcs;
	}
	public void setArcs(int n)
	{
		arcs=n;

	}
	/*
	 * This method prints which intersection is associated with the value n
	 */
	public void displayIntersection(int n)
	{
		System.out.print(vertexList[n]);
	}

	/*
	 * This method provides informations about an arc.
	 */
	public void displayArc(int n ,int m)
	{
		if(adjMatrix[n][m]!= null)
		{
			System.out.println("The number of collection points are:" + adjMatrix[n][m].getCollectionPoints() );
			System.out.println("The road was took "+adjMatrix[n][m].getRoadTook()+"times. ");
			System.out.println("It takes "+adjMatrix[n][m].getTime()+" seconds to traverse this road.");
			System.out.println("The road is "+adjMatrix[n][m].getDistance()+" miles long." );
		}
	}

	/*
	 * prints out the adjacency matrix not working right now.
	 */
	public void displayAdjMatrix()
	{
		for(int i=0; i<MAXIMUM_INTERSECTIONS ;  i++)
		{
			for(int j=0; j<MAXIMUM_INTERSECTIONS; j++)
			{
				if(adjMatrix[i][j]==null)
				{
					System.out.print("0"+ " ");	
				}
				else
					System.out.print(adjMatrix[i][j].getTitle()+" ");
			}
			System.out.println("");

		}
	}
	public Arc getAdjMatrix(int i, int j)
	{
		Arc road =adjMatrix[i][j];
		return road;
	}

	/*
	 * Returns the total number of intersections in the graph.
	 */

	public int getMaxIntersections()
	{
		return MAXIMUM_INTERSECTIONS;
	}

}
