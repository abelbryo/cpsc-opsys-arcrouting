import java.util.*;

/*
 * This class contains the methods for finding the solution to the problem.
 */
public class FindRoute 
{
	int node;
	int noServiced=0; //number arcs serviced
	Arc arcArray[];
	Arc answer;
	String  arcsTook[];
	int arcsTookCounter=0;
	int counter=0;
	int a=0;
	public boolean allTraversed=false;
	public boolean track=false;
	int tracker=0;
	Arc errorArc=new Arc();
	//Arc arcPath[];
	ArrayList<Arc> finPath = new ArrayList<Arc>();
	boolean setValueer=false;

	int newNode=0;

	/*
	 * 
	 */
	public void findRoute(int node ,Graph map)
	{
		//arcArray= new Arc[map.getMaxIntersections()]; 
		arcsTook=new String[map.getArcs()];


		//answer=map.getColumn(node);
		for(int i=0;i<arcsTook.length; i++)
		{
			arcsTook[i]="0";
		}
		//map.getAdjMatrix(answer.getRow(),node).setRoadTook(answer.getRoadTook()+1);
		//	map.getAdjMatrix(node,answer.getRow()).setRoadTook(answer.getRoadTook()+1);
		while (arcsTookCounter<map.getArcs())

		{
			arcArray= map.getColumn(node,map);
			answer=compareArcs(arcArray,map);
			if(answer.getTitle()!="error")
			{
				//	System.out.println(answer.getTitle());
			}
			/////////////////////////////////////////////////////////////////////////	System.out.println("tracker is:"+tracker);
			if(checkedTraverse(arcsTook,answer.getTitle())==true )
			{
				//	if(answer.getTitle()!="0")
				{
					arcsTook[arcsTookCounter]=answer.getTitle();
					arcsTookCounter++;

				}
			}
			for(int i=0; i<arcsTook.length;i++) 
			{
				//System.out.print(" "+arcsTook[i]+" ");
				//System.out.print("row: "+answer.getRow()+"col: "+answer.getCol());
			}
			//		System.out.println("columns: "+answer.getCol()+"rows: "+answer.getRow());
			//	System.out.println();


			finPath.add(counter, answer);

			counter++;
			node=answer.getRow();
			/////////////////////////////////////////////////////////////////////	System.out.println(track);
		}


	printRoute(finPath);
	}



	/*
	 * sets how many routes you would like to have serviced
	 */

	public void setNumServiced(int a)
	{
		noServiced=a;
	}

	/*
	 * returns the amount of routes to be serviced.
	 */
	public int getNumServiced()
	{
		return noServiced;
	}

	public void printRoute(ArrayList finPath)
	{
		System.out.println("Take");
		for(int i =0; i<finPath.size() ; i++)
		{
			System.out.println(" to "+((Arc) finPath.get(i)).getTitle());
		}
	}


	/*
	 *  This is the method in which the arcs are compared 
	 *  it returns the best arc to take.
	 */
	public Arc compareArcs(Arc adjArray[],Graph g)
	{

		int bestSum=Integer.MAX_VALUE;
		String holdTitles[]=new String[adjArray.length];
		String holdTitlesFinal[]=new String[g.getArcs()];
		//	System.out.println(tester);

		for(int i=0; i<adjArray.length;i++)
		{
			holdTitles[i]=adjArray[i].getTitle();
			//System.out.print(holdTitles[i]);

		}
		for(int k=0;k<holdTitles.length;k++)
		{
			if(holdTitles[k]!="0")
			{
				holdTitlesFinal[k]=holdTitles[k];
			}
			else
			{
				//	holdTitlesFinal[k]="String";
			}
		}

		for(int j=0; j<holdTitlesFinal.length;j++)
		{
			//	System.out.print(holdTitlesFinal[j]);

		}
	//	System.out.println("track is:"+track);
	//	System.out.println("result is"+compareArcs(arcsTook,holdTitles));
		if(compareArcs(arcsTook,holdTitles)==2)
		{
			int countVar=0;
			for(int i=0; i<adjArray.length;i++)
			{
				if(bestSum >adjArray[i].getSumCost() && adjArray[i].getTitle()!="0" && adjArray[i].getRequired()==true)
				{
					bestSum=adjArray[i].getSumCost();
					countVar=i;
				}
			}

			if(track==false)
			{
				noServiced =getNumServiced()+1; 
				tracker=0;
			}

			return adjArray[countVar];
		}
		else if(compareArcs(arcsTook,holdTitles)==0)
		{

			System.out.println("in");
			int countVar=0;
			for(int i=0; i<adjArray.length;i++)
			{
				if(bestSum >adjArray[i].getSumCost() && adjArray[i].getRequired()==true && adjArray[i].getTitle()!="0" ) 
				{
					bestSum=adjArray[i].getSumCost();
					countVar=i;

				}
			}
			tracker=1;
			return adjArray[countVar];

		}
		else if(compareArcs(arcsTook,holdTitles)==1)
		{
			int countVar=0;
			for(int i=0; i<adjArray.length;i++)
			{
				if(bestSum >adjArray[i].getSumCost() && adjArray[i].getRoadTook()==0 && adjArray[i].getRequired()==true && checkedTraverse(arcsTook,adjArray[i].getTitle())==true)
				{
					bestSum=adjArray[i].getSumCost();
					countVar=i;
				}
			}
			if(track==false)
			{
				noServiced =getNumServiced()+1; 
				tracker=2;
			}
			return adjArray[countVar];
		}
		else if(compareArcs(arcsTook,holdTitles)==3)
		{
			//System.out.println(arcsTook);
		}
		errorArc.setTitle("error");
		return errorArc;
	}






	/*
	 * this method will check to see if all the arcs connected with the node have been serviced.
	 * The method will then return a true if they have and a false otherwise
	 */
	public boolean allTraversed(Arc arcArray[])
	{
		int arcCheckArray[] =new int[arcArray.length];
		//this for loop changes the roads serviced to null

		for(int i=0; i<arcArray.length; i++)
		{
			if(arcArray[i].getRoadTook() != 0 )
			{
				arcCheckArray[i]=0;
				//System.out.println("road has been took");
			}
			else if(arcArray[i].getRoadTook() == 0  )
			{
				arcCheckArray[i]=1;
				//System.out.println("road has not been took");
			}
		}
		for(int k=0; k<arcCheckArray.length; k++)
		{
			//	System.out.print(arcCheckArray[k]);
		}
		//System.out.println("out");
		for(int j=0; j<arcArray.length; j++)
		{
			if(arcCheckArray[j] == 1)
			{

				return false;	
			}
		}

		return true;
	}



	public boolean checkedTraverse(String arcsServed[], String checkVar)
	{
		int count=0;
		for(int i= 0; i<arcsServed.length;i++)
		{
			if(arcsServed[i]==checkVar &&arcsServed[i]!="0")
			{
				count++;
			}
		}
		if(count==0 ) //no nodes are traversed
		{
			return true;
		}
		else if(count==arcsServed.length)
		{
			allTraversed=true;
			return false;
		}
		return false;

	}

	public int compareArcs(String arcsServed[], String checkVar[])
	{
		int count=0;
		for(int k=0; k<arcsServed.length;k++)
		{
			System.out.print(arcsServed[k]);
		}
		System.out.println();
		
		
		
		for(int i= 0; i<arcsServed.length;i++)
		{
			//track=false;
			for(int j=0;j<checkVar.length;j++)
			{
				if((arcsServed[i]==checkVar[j]) &&(checkVar[j]!="0"))
				{
					count++;

				}
				//	System.out.println("arcs[i]is: "+arcsServed[i]);
				//	if(arcsServed[i].equals("0"))
				{
					//	track=true;
				}
			}
		}
			for(int r= 0; r<checkVar.length;r++)
			{
				for(int q=0;q<arcsServed.length;q++)
				{
					if(arcsServed[q].contains(checkVar[r]))
					{
						System.out.println("Arcs Served:"+arcsServed[q]+"checkVar: "+checkVar[r]);
						setValueer=true;
					
					}

				}
			}
		}
		//System.out.println("set value is:"+setValueer);
		//System.out.println("track is: "+track);
		if(count==arcsServed.length )//all traversed
		{
			return 0;
		}
		else if(count==0) //none traversed
		{
			return 2; 
		}
		else if(count<arcsServed.length )//some traversed
		{
			return 1;
		}
		else //error
			return 3;
		}
	}
