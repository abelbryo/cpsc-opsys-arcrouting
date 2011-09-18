
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Graph map1 =new Graph();
		map1.addVertex('1');
		map1.addVertex('2');
		map1.addVertex('3');
		map1.addVertex('4');
		map1.addArc(0, 1 ,"a", 0, 5 ,5 , 1);
		map1.addArc(1, 2 ,"b", 0, 17 ,8 , 2);
		map1.addArc(2, 3 ,"c", 0, 1 ,9 , 5);
		map1.addArc(1, 3 ,"d", 0, 6 ,7 , 3);
		map1.addArc(3, 4 ,"e", 0, 2 ,99 , 1);
		FindRoute newRoute=new FindRoute();
		newRoute.findRoute(0, map1);
		//System.out.println("The arc information is");
		/*int k=0;
		for(int i=0; i<=4; i++)
		{
			//System.out.println("Road"+k);
			for(int j=0 ; j<=4; j++)
			{
				
				map1.displayArc(j, i);
			}
			k++;
			System.out.println("\n");
		}*/
	//	map1.displayAdjMatrix();




	}

}
