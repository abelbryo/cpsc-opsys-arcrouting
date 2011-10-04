
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;


public class Grapher 
{
	private final int MAXIMUM_INTERSECTIONS = 75; //number of nodes in a graph
	public String label;
	public boolean wasVisited;
	private Arc adjMatrix[][];
	private HashMap<String , ArrayList<Arc>> AdjList;// this is the adjacency matrix
	public ArrayList<GraphNode> graphPoints ;
	public ArrayList<GraphConnection> Links;
	
	/*
	 * This is the list of vertex's in the future it should be turned from an array
	 * of characters to and array or strings or int's to better define the area covered
	 */
	public ArrayList<String> vertexList;
	private int countInterections;
	public int arcs =0;

	Shell parentShell;
	Graph mapView;
	
	
	//public LinkedList<Comparable> arcList;
	ArrayList<Arc> arcList;

	/*
	 * This is the constructor that makes a new object graph
	 */
	public Grapher()
	{
		AdjList = new HashMap<String, ArrayList<Arc>>();
		vertexList= new ArrayList<String>();
		adjMatrix=new Arc[MAXIMUM_INTERSECTIONS][MAXIMUM_INTERSECTIONS];
		arcList=new ArrayList<Arc>();
		graphPoints = new ArrayList<GraphNode>();
		Links = new ArrayList<GraphConnection>();
	
		countInterections=0;
		for(int i=0; i<MAXIMUM_INTERSECTIONS ;  i++)
		{
			for(int j=0; j<MAXIMUM_INTERSECTIONS; j++)
			{
				adjMatrix[i][j]=new Arc();
				adjMatrix[i][j].setCollectionPoints(0);
				adjMatrix[i][j].setDistance(0);
				adjMatrix[i][j].setRoadTook(0);
				adjMatrix[i][j].setTime(0);
				adjMatrix[i][j].setTitle("0");
				adjMatrix[i][j].setCol(j);
				adjMatrix[i][j].setRow(i);
				adjMatrix[i][j].setRequired(false);
			}

		}


	}
	
	public Grapher(Shell parent)
	{
		parentShell = parent;
		mapView = new Graph(parentShell, SWT.NONE);
		arcList=new ArrayList<Arc>();
		AdjList = new HashMap<String, ArrayList<Arc>>();
		graphPoints = new ArrayList<GraphNode>();
		vertexList= new ArrayList<String>();
		adjMatrix=new Arc[MAXIMUM_INTERSECTIONS][MAXIMUM_INTERSECTIONS];
		countInterections=0;
		mapView.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		Links = new ArrayList<GraphConnection>();
		for(int i=0; i<MAXIMUM_INTERSECTIONS ;  i++)
		{
			for(int j=0; j<MAXIMUM_INTERSECTIONS; j++)
			{
				adjMatrix[i][j]=new Arc();
				adjMatrix[i][j].setCollectionPoints(0);
				adjMatrix[i][j].setDistance(0);
				adjMatrix[i][j].setRoadTook(0);
				adjMatrix[i][j].setTime(0);
				//adjMatrix[i][j].setTitle(i+"null"+j);
				adjMatrix[i][j].setTitle("0");
				adjMatrix[i][j].setCol(j);
				adjMatrix[i][j].setRow(i);
				adjMatrix[i][j].setRequired(false);
			}
		}
		
	}

	/*
	 * This is the method that adds a vertex to the list of vertices 
	 */
	public void addVertex(String inLabel) 
	{
		vertexList.add(inLabel);
		graphPoints.add(new GraphNode(mapView, SWT.NONE, inLabel));
		//mapView.addNode(graphPoints.get(graphPoints.size()-1));
		
		
	}


	/*
	 * This is the method that adds the arc to the adjacency matrix start and end 
	 * are the starting and ending nodes respectively 
	 * This will work for just out examples it will need changed once we factor in different sides
	 * costing different amounts
	 */
	public void addArc( String startStreet, int numberOfCollectPoints ,int time , int length )
	{
		Arc tempStartArc = new Arc(startStreet ,  numberOfCollectPoints, time ,length );
		
		/*if(vertexList.contains(start) == false)
		{
			addVertex(start);
		}
		if(vertexList.contains(end) == false)
		{
			addVertex(end);
		}*/
		if(AdjList.containsKey(tempStartArc.streetName) == false)
		{
			AdjList.put(tempStartArc.streetName,  new ArrayList<Arc>());
		}
		
		arcList.add(tempStartArc);
		
		// System.out.println(AdjList.keySet());
		    
	
		/*
		adjMatrix[start][end]= new Arc(name ,  collection, time ,distance );
		adjMatrix[end][start]= new Arc(name ,  collection, time ,distance );
		adjMatrix[start][end].setCol(end);
		adjMatrix[start][end].setRow(start);
		adjMatrix[end][start].setCol(start);
		adjMatrix[end][start].setRow(end);
		adjMatrix[start][end].setRequired(true);
		adjMatrix[end][start].setRequired(true);
		arcs++;
		
		int startPoint =vertexList.indexOf(start);
		int endPoint = vertexList.indexOf(end);
		new GraphConnection(mapView, SWT.NONE, graphPoints.get(startPoint), graphPoints.get(endPoint)).setText(name);
		*/
		
	}
	/*
	 * This method displays of how many arcs are in the graph
	 */
	
	public boolean addArcConnection( String startStreet, String endStreet)
	{
		
		Arc temp1 = getArcByName(startStreet);
		if(temp1 == null)
		{
			return false;
		}
		Arc temp2 = getArcByName(endStreet);
		if(temp2 == null)
		{
			return false;
		}
		
		ArrayList<Arc>  tempList = AdjList.get(startStreet);
		if(tempList.contains(temp2) == false)
		{
			tempList.add(temp2);
			AdjList.put(startStreet, tempList);
		}
		
		tempList = AdjList.get(endStreet);
		if(tempList.contains(temp1) == false)
		{
			tempList.add(temp1);
			AdjList.put(endStreet, tempList);
		}
		
		tempList = null;
		
		//System.out.println(AdjList.values());
		
		return true;
	}
	
	public Arc getArcByName(String Name)
	{
		
		for(Arc a : arcList)
		{
			if(arcList.get(arcList.indexOf(a)).streetName == Name)
			{
				return a;
			}
			
		}
		
		return  null;
	}
	
	public void printMap()
	{
		
		for(String S : AdjList.keySet())
		{
			System.out.print( S + " : " );
			for(Arc a :  AdjList.get(S))
			{
				System.out.print(a.streetName);
			}
			System.out.print("\n");
		}
		
	}
	public int getArcs()
	{
		return arcList.size();
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
		System.out.print(vertexList.toString());
	}

	/*
	 * This method provides informations about an arc.
	 */
//	public void displayArc(int n ,int m)
//	{
//		if(adjMatrix[n][m].getTitle()!= "null")
//		{
//			System.out.println("the title is "+adjMatrix[n][m].getTitle());
//			System.out.println("The columns are "+adjMatrix[n][m].getCol()+"the rows are"+adjMatrix[n][m].getRow());
//			System.out.println("N is: "+n +" M is: "+m);
//			System.out.println("_______________________________________________________________________");
//		}
//	}

	/*
	 * prints out the adjacency matrix not working right now.
	 */
//	public void displayAdjMatrix()
//	{
//		for(int i=0; i<MAXIMUM_INTERSECTIONS ;  i++)
//		{
//			for(int j=0; j<MAXIMUM_INTERSECTIONS; j++)
//			{
//				if(adjMatrix[i][j].getTitle()=="null")
//				{
//					System.out.print("0"+ " ");	
//				}
//				else
//					//System.out.print(adjMatrix[i][j].getRoadTook()+" ");
//				//	System.out.print(adjMatrix[i][j].getTitle()+" ");
//					System.out.print(adjMatrix[i][j].getTitle()+" ");
//				//System.out.print("("+adjMatrix[i][j].getRow()+","+adjMatrix[i][j].getCol()+")");
//			}
//			System.out.println("");
//
//		}
//	}
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
	public Arc[]  getColumn( int n ,Grapher g)
	{
		Arc columnMat[]=new Arc[MAXIMUM_INTERSECTIONS];
		for(int j=0; j<this.getMaxIntersections(); j++)
		{
			columnMat[j]=g.getAdjMatrix(j, n);
		}
		return columnMat;
	}
	
	public void buildMapDisplay()
	{		
		for(String S : AdjList.keySet())
		{
			for(Arc a :  AdjList.get(S))
			{
				if((vertexList.contains(S +" at " + a.streetName) == false)
						&& (vertexList.contains(a.streetName +" at " + S) == false))
				{
					addVertex(S +" at " + a.streetName);
				}
			}// end arc for
		}//end string for
		
		String tempSource, tempDestination;
		for(GraphNode n : graphPoints)
		{
			for(String S : AdjList.keySet())
			{
				for(Arc A: AdjList.get(S))
				{
					if(n.getText().startsWith(S))
					{
						tempSource = S;
						tempDestination = A.streetName;
					}
					else if(n.getText().startsWith(A.streetName))
					{
						tempSource = A.streetName;
						tempDestination = S;
					}
					//Links.add(new GraphConnection(mapView, SWT.NONE, getNodeByName(tempSource,tempDestination ), getNodeByName()))
					
				}
			}
		}
	}// close buildMapDisplay

	GraphNode getNodeByName(String source, String destination)
	{
		for(GraphNode N: graphPoints)
		{
			if(N.getText().equals(source+" at "+destination) )
			{
				return N;
			}
		}
		
		return null;
				
	}
	
	
	
}
