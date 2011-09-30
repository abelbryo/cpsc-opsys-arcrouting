import java.util.*;

/*
 * This class contains the methods for finding the solution to the problem.
 */
public class FindRoute 
{
	String  arcsTook[];
	int arcsTookCounter=0;
	int counter=0;
	String lastTook;
	ArrayList<Arc> finPath = new ArrayList<Arc>();


	int newNode=0;

	public void findRoute(int node ,Grapher map)
	{
		Arc arcAnswer=new Arc();
		Arc arcArray[];
		while (arcsTookCounter<map.getArcs())
		{
			arcArray= map.getColumn(node,map);
			arcAnswer=findBestArc(arcArray);
			if((map.getAdjMatrix(arcAnswer.getRow(),arcAnswer.getCol()).getRoadTook()==0 )&&(map.getAdjMatrix(arcAnswer.getCol(),arcAnswer.getRow()).getRoadTook()==0))
			{
				arcsTookCounter++;
			}
			if((map.getAdjMatrix(arcAnswer.getRow(),arcAnswer.getCol()).getTitle()!="0" )&&(map.getAdjMatrix(arcAnswer.getCol(),arcAnswer.getRow()).getTitle()!="0"))
			{
				map.getAdjMatrix(arcAnswer.getRow(),arcAnswer.getCol()).setRoadTook(arcAnswer.getRoadTook()+1);
				map.getAdjMatrix(arcAnswer.getCol(),arcAnswer.getRow()).setRoadTook(arcAnswer.getRoadTook()+1);
			}
			lastTook=arcAnswer.getTitle();
			node=arcAnswer.getRow();
			finPath.add(counter, arcAnswer);
			counter++;
		}
		printRoute(finPath);
		sumRoute(finPath);
	}
	public Arc findBestArc(Arc adjArray[])
	{
		int bestSum=Integer.MAX_VALUE;
		int countVar=0;
		for(int i=0; i<adjArray.length;i++)
		{
			if((bestSum >adjArray[i].getSumCost()) && (adjArray[i].getRequired()==true )&&( adjArray[i].getTitle()!="0")  &&(adjArray[i].getRoadTook()==0)) 
			{

				bestSum=adjArray[i].getSumCost();
				countVar=i;
			}
		}
		if((adjArray[countVar].getRoadTook()==0) && (adjArray[countVar].getRequired()==true))
		{
			return adjArray[countVar];
		}
		else 
		{
			countVar=0;
			for(int j=0; j<adjArray.length;j++)
			{
				if((bestSum >adjArray[j].getSumCost()) && (adjArray[j].getRequired()==true )&&( adjArray[j].getTitle()!="0") && ( adjArray[j].getTitle()!=lastTook)  ) 
				{
					bestSum=adjArray[j].getSumCost();
					countVar=j;

				}
			}
			if( ( adjArray[countVar].getTitle()!=lastTook) &&( adjArray[countVar].getTitle()!="0") )
			{
				return adjArray[countVar];
			}
		}
		countVar=0;
		for(int j=0; j<adjArray.length;j++)
		{
			if((bestSum >adjArray[j].getSumCost()) && (adjArray[j].getRequired()==true )&&( adjArray[j].getTitle()!="0")  ) 
			{
				bestSum=adjArray[j].getSumCost();
				countVar=j;

			}
		}
		return adjArray[countVar];
	}


	public void printRoute(ArrayList<Arc> finPath)
	{
		System.out.println("Take");
		for(int i =0; i<finPath.size() ; i++)
		{
			System.out.println(" to "+((Arc) finPath.get(i)).getTitle());
		}
	}
	public void sumRoute(ArrayList <Arc> finpath)
	{
		int totalCost=0;
		for(int i =0; i<finPath.size() ; i++)
		{
			totalCost=totalCost+((Arc)finPath.get(i)).getSumCost();
		}
		System.out.println(totalCost);
	
	}
}
