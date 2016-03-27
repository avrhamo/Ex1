import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Graph {



	private WeightedGraph<Integer, DefaultWeightedEdge> UDWGraph;
	private SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> DWGraph;
	private int numOfNodes, numOfEdges;
	private boolean Directed;
	private static PrintWriter writer;




	/* Constructor Graph
	 * Creating a graph that given in the file.
	 * By default the constructor is going to create a
	 * directed graph with the given weights.
	 * */
	public Graph(String _file) {
		int v1 = 0, v2 = 0;
		double edgeVal = 0;
		Directed = true;
		DefaultWeightedEdge edge;
		String line = null;
		StringTokenizer tok;

		try (BufferedReader BR = Files.newBufferedReader(Paths.get(_file), StandardCharsets.UTF_8)) {

			line = BR.readLine();
			numOfNodes = Integer.parseInt(line);
			line = BR.readLine();
			numOfEdges = Integer.parseInt(line);
			
			DWGraph = new SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge>
			(DefaultWeightedEdge.class);

			for (line = null; (line = BR.readLine()) != null;) {

				tok = new StringTokenizer(line, " ");

				v1 = Integer.parseInt(tok.nextToken());
				v2 = Integer.parseInt(tok.nextToken());

				edgeVal = Double.parseDouble(tok.nextToken());

				
				DWGraph.addVertex(v1);
				DWGraph.addVertex(v2);

				edge = DWGraph.addEdge(v1, v2);
				DWGraph.setEdgeWeight(edge, edgeVal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/*	Constructor Graph :
	 * 	Determines if the graph is going to be directed or not 
	 * 	by the given value of the Boolean parameter. 
	 * 	If true a directed graph will be created, 
	 * 	else a undirected graph will be created.
	 * */
	public Graph(String _file, boolean _Directed) {

		int v1 = 0, v2 = 0;
		double edgeVal = 0;
		Directed = _Directed;
		DefaultWeightedEdge edge;
		String line = null;
		StringTokenizer tok;

		if(Directed) {

			try (BufferedReader BR = Files.newBufferedReader(Paths.get(_file), StandardCharsets.UTF_8)) {

				line = BR.readLine();
				numOfNodes = Integer.parseInt(line);
				line = BR.readLine();
				numOfEdges = Integer.parseInt(line);

				DWGraph = new SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge>
				(DefaultWeightedEdge.class);

				for (line = null; (line = BR.readLine()) != null;) {

					tok = new StringTokenizer(line, " ");

					v1 = Integer.parseInt(tok.nextToken());
					v2 = Integer.parseInt(tok.nextToken());

					edgeVal = Double.parseDouble(tok.nextToken());
					DWGraph.addVertex(v1);
					DWGraph.addVertex(v2);

					edge = DWGraph.addEdge(v1, v2);
					DWGraph.setEdgeWeight(edge, edgeVal);
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		else{
			
			try (BufferedReader BR = Files.newBufferedReader(Paths.get(_file), StandardCharsets.UTF_8)) {

			line = BR.readLine();
			numOfNodes = Integer.parseInt(line);
			line = BR.readLine();
			numOfEdges = Integer.parseInt(line);
			
			UDWGraph = new SimpleWeightedGraph <Integer, DefaultWeightedEdge>
			(DefaultWeightedEdge.class);

			for (line = null; (line = BR.readLine()) != null;) {

				tok = new StringTokenizer(line, " ");

				v1 = Integer.parseInt(tok.nextToken());
				v2 = Integer.parseInt(tok.nextToken());

				edgeVal = Double.parseDouble(tok.nextToken());
				UDWGraph.addVertex(v1);
				UDWGraph.addVertex(v2);
				edge = UDWGraph.addEdge(v1, v2);
				UDWGraph.setEdgeWeight(edge, edgeVal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		}


	}

	//printing the current graph
	public void printGraph() {

		System.out.println("The number of vertexes in the graph is : "+ numOfNodes );
		System.out.println("The number of edges in the graph is : "+ numOfEdges );
		System.out.println("And the graph is " + ( (Directed ) ? "a directed" : "not a directed" + " graph"));

		if(Directed)
			System.out.println(DWGraph.toString());
		else
			System.out.println(UDWGraph.toString());

	}

	//return true if directed graph false otherwise
	public boolean isDirected(){
		return Directed;
	}

	//return the number of nodes in the graph
	public int getNumOfNodes() {
		return numOfNodes;
	}

	//return the number of edges in the graph
	public int getNumOfEdges() {
		return numOfEdges;
	}

	// If a directed graph was define returns the whole graph otherwise return's null 
	public SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> getDWGraph(){

		return DWGraph;
	}

	// If a undirected graph was define returns the whole graph otherwise return's null 
	public WeightedGraph<Integer, DefaultWeightedEdge> getUDWGraph(){

		return UDWGraph;
	}

	public static void main(String[]args) {
		String file2load = null,file2test = null,directed = null;
		Graph g = null;
		GraphAlgo ga = null; 
		if(args.length > 0) {
			file2load = args[0];
			file2test = args[1];
			if(args.length > 2)
				directed = args[2];
		}
		
		long startTime = System.currentTimeMillis();
		
		System.out.println("Reading file \n");
		
		long loadingFileTime  = System.currentTimeMillis();
		
		if(args.length > 0) {
			if(args.length > 2) {
				g = new Graph(file2load,Boolean.parseBoolean(directed));
				System.out.println("Done reading the files in: "+(loadingFileTime - startTime)+"ms.\n");
				ga = new GraphAlgo(g, file2test);
			}
				else{
					g = new Graph(file2load);
					System.out.println("Done reading the files in: "+(loadingFileTime - startTime)+"ms.\n");
					ga = new GraphAlgo(g, file2test);
				}
		}
		else{
			g = new Graph("src\\MyTest.txt");		
			ga = new GraphAlgo(g, "src\\test1.txt");
		}
		
		ga.readFile();
		System.out.println("Start calculate dijkstra shortest path... \n");
		long culcDijkstra  = System.currentTimeMillis();
		ga.ShortestPathDijkstra();
		
		System.out.println("Done calculate dijkstra shortest path in: " +(culcDijkstra - loadingFileTime)+"ms.\n");
		
		try {
			double solutions [][] = ga.getOutputFile();
			if(args.length == 0)
				writer = new PrintWriter("src\\SolutionUndirected_test2.txt", "UTF-8");
			else
				writer = new PrintWriter("Solution_for_"+file2test, "UTF-8");
			
				
			writer.println(solutions.length + " queries and there solutions: ");
			for (int i = 0; i < solutions.length; i++) {
				for (int j = 0; j < solutions[i].length; j++) {
					
					if(j+1 == solutions[i].length)
						writer.print(solutions[i][j]+" ");
					else
						writer.print((int)solutions[i][j]+" ");
				
				}
				writer.println();
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done Writing and creating solutions file, total time is: " +(culcDijkstra - startTime)+"ms.\n");
	}

}
