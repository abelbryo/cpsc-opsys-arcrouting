
import org.eclipse.swt.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		
		
		Display d = new Display();
		Shell shell = new Shell(d);
		shell.setText("Arc routing Visualization");
		shell.setLayout(new FillLayout());
		shell.setSize(800, 600);
		Grapher Meadowood =new Grapher(shell);
		
		Meadowood.addArc("White Oak Drive",  10, 5, 3);
		Meadowood.addArc("ThornWood Road",  15, 10, 3);
		Meadowood.addArc("Blue Grass Drive" , 7, 5, 6);
		Meadowood.addArc("Aspen Road" , 7, 5, 6);
		Meadowood.addArc("Oakridge Drive" ,8, 9, 6);
		Meadowood.addArc("Fairlane Drive" ,8, 12, 15);
		Meadowood.addArc("Foxcroft Drive" ,8, 12, 15);
		
		Meadowood.addArcConnection("White Oak Drive", "ThornWood Road");
		Meadowood.addArcConnection("White Oak Drive", "Blue Grass Drive" );
		
		Meadowood.addArcConnection("ThornWood Road", "White Oak Drive");
		Meadowood.addArcConnection("ThornWood Road", "Blue Grass Drive" );
		Meadowood.addArcConnection("ThornWood Road", "Fairlane Drive" );
		Meadowood.addArcConnection("ThornWood Road", "Foxcraft Drive" );
		Meadowood.addArcConnection("ThornWood Road", "Oakridge Drive" );
		
		Meadowood.addArcConnection("Blue Grass Drive" ,"White Oak Drive");
		Meadowood.addArcConnection("Blue Grass Drive" ,"ThornWood Road");
		
		Meadowood.addArcConnection("Oakridge Drive", "ThornWood Road" );
		
		Meadowood.addArcConnection("Fairlane Drive", "ThornWood Road" );
		
		Meadowood.addArcConnection("Foxcroft Drive", "ThornWood Road" );
		
		Meadowood.addArcConnection("Aspen Road", "White Oak Drive" );
		Meadowood.addArcConnection("Aspen Road", "Blue Grass Drive" );
		
		
		
		Meadowood.printMap();
		Meadowood.buildMapDisplay();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//char  vertexList[];
	/*	map1.addArc(0, 1 ,"A",  50 ,5 , 1);
		map1.addArc(1, 2 ,"Sumner st",  10 ,0 , 2);
	    map1.addArc(1, 6 ,"Stromberg st", 0, 17 ,8);
		map1.addArc(2, 3 ,"Second ave",  1 ,9 , 5);
		map1.addArc(1, 3 ,"Main st", 6 ,7 , 3);
		map1.addArc(3, 4 ,"Oakridge Drive",  2 ,100 , 1);
		map1.addArc(2, 4 ,"Vinyard",  2 ,100 , 1);
		map1.addArc(2, 5 ,"Camron drive",  2 ,100 , 76);
		map1.addArc(1, 16 ,"CROM!",  2 ,100 , 76);
		map1.addArc(1, 5 ,"juice",  2 ,41 , 76);
		map1.addArc(0, 4 ,"candel",  2 ,100 , 1);
		map1.addArc(2, 7 ,"mouse",  2 ,100 , 76);
		map1.addArc(6, 16 ,"horse",  2 ,100 , 76);
		map1.addArc(16, 5 ,"keyboard",  2 ,41 , 76);*/
		FindRoute newRoute=new FindRoute();
		newRoute.findRoute(0, Meadowood);
		
		
		
		
		
		shell.open();
		while (!shell.isDisposed())
		{
			while (!d.readAndDispatch())
			{
				d.sleep();
			}
		}	
	}

}
