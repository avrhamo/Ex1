
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;

import org.jgrapht.WeightedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class GraphAlgo{

	private File file;
	private int queries;
	private BufferedReader br;
	private FileReader fr;
	private boolean Directed;
	private SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> DWGraph;
	private WeightedGraph<Integer, DefaultWeightedEdge> UDWGraph;
	final private double INF = Double.MAX_VALUE;
	private int [][] blackList;
	private double [][]outputFile;
	private double [] solutions;


	public GraphAlgo(Graph _graph, String _file){

		file = new File(_file);

		if (_graph.isDirected()) {
			DWGraph = _graph.getDWGraph();
			Directed = true;
		} 
		else {
			UDWGraph = _graph.getUDWGraph();
			Directed = false;
		}
		
	}

	
	public double[][] getOutputFile(){
		return outputFile;
	}

	public void ShortestPathDijkstra (){

		double weights[] = null;
		solutions = new double[queries];
		int index = 0;

		DijkstraShortestPath<Integer, DefaultWeightedEdge> sp = null;


		for (int i = 0; i < blackList.length; i++) {


			for (int j = 2; j < blackList[i].length; j++) {

				if(blackList[i][j] == -1)
				{
					if (Directed)
						sp = new DijkstraShortestPath<Integer, DefaultWeightedEdge>(DWGraph, blackList[i][0], blackList[i][1]); 
					else
						sp = new DijkstraShortestPath<Integer, DefaultWeightedEdge>(UDWGraph, blackList[i][0], blackList[i][1]); 
					
					solutions[i] = sp.getPathLength();
				}

				else {

					Set<DefaultWeightedEdge> EdgesSet1;
					Set<DefaultWeightedEdge> EdgesSet2;

					if(Directed) {
						EdgesSet1 = DWGraph.edgesOf(blackList[i][j]);
						EdgesSet2 = DWGraph.edgesOf(blackList[i][j]);
					}
					else {
						EdgesSet1 = UDWGraph.edgesOf(blackList[i][j]);
						EdgesSet2 = UDWGraph.edgesOf(blackList[i][j]);
					}


					weights = new double[EdgesSet2.size()];

					if(Directed) {

						for (DefaultWeightedEdge dwe : EdgesSet1) {

							weights[index] = DWGraph.getEdgeWeight(dwe);
							DWGraph.setEdgeWeight(dwe, INF);
							index++;
						}

						sp = new DijkstraShortestPath<Integer, DefaultWeightedEdge>(DWGraph, blackList[i][0], blackList[i][1]); 
						solutions[i] = sp.getPathLength();


						index = 0;
						for (DefaultWeightedEdge dwe : EdgesSet2){
							DWGraph.setEdgeWeight(dwe, weights[index]);
							index++;
						} 

					}

					else {

						for (DefaultWeightedEdge dwe : EdgesSet1) {

							weights[index] = UDWGraph.getEdgeWeight(dwe);
							UDWGraph.setEdgeWeight(dwe, INF);
							index++;
						}

						sp = new DijkstraShortestPath<Integer, DefaultWeightedEdge>(UDWGraph, blackList[i][0], blackList[i][1]); 
						solutions[i] = sp.getPathLength();


						index = 0;
						for (DefaultWeightedEdge dwe : EdgesSet2){
							UDWGraph.setEdgeWeight(dwe, weights[index]);
							index++;
						} 
					}

					index = 0;
				}
			}
		}
		
		//getting all of the solutions
		for (int i = 0; i < solutions.length; i++) {
			outputFile[i][outputFile[i].length - 1] = solutions[i];
		}
		
	}




	public void readFile() {

		int v1 = 0, v2 = 0, Index = 0, blackListedVertexes = 0;
		int blackListSize = 0;
		StringTokenizer tok;
		String line = null;

		try {

			fr =  new FileReader(file);
			br = new BufferedReader(fr);
			
			line = br.readLine();
			queries = Integer.parseInt(line);
			blackList = new int [queries][];
			outputFile = new double[queries][];
			line = br.readLine();
			tok = new StringTokenizer(line, " " );
			
			while(line != null) {
				
				v1 = Integer.parseInt(tok.nextToken());
				v2 = Integer.parseInt(tok.nextToken());
				blackListSize = Integer.parseInt(tok.nextToken());

				if(blackListSize > 0){
					//Adding 2 for v1 & v2
					blackList [Index] = new int [blackListSize + 2]; 
					
					//Adding 4 for the number of black listed vertexes, shortest path result, v1 & v2.
					outputFile[Index] = new double[blackListSize + 3];
					outputFile[Index][2] = blackListSize;
					
				}

				else {
					//Means no black listed vertexes
					blackList [Index] = new int [3];
					outputFile[Index] = new double[3];
					blackList [Index][2] = -1;
					outputFile[Index][2] = 0;
				}

				blackList [Index][0] = v1;
				blackList [Index][1] = v2;
				outputFile [Index][0] = v1;
				outputFile [Index][1] = v2;

				while(blackListedVertexes < blackListSize) {
					blackList[Index][blackListedVertexes + 2] = Integer.parseInt(tok.nextToken());
					outputFile[Index][blackListedVertexes + 3] = (double)blackList[Index][blackListedVertexes + 2];
					blackListedVertexes++;
					if(tok.hasMoreTokens() && blackListedVertexes == blackListSize)
						outputFile[Index][blackListedVertexes + 2] = (double)Integer.parseInt(tok.nextToken());
						
				}
				
				Index++;
				blackListedVertexes = 0;
				
				line = br.readLine();
				if(line != null)
					tok = new StringTokenizer(line, " "); 
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}




	}



}

