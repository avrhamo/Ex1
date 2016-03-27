/**
 * 
 **/

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestingGraph {
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	
	/*
	 *	Testing if two files that was created are the same,
	 *	checking with a undirected graph.
	 */
	
	@Test
	public void testFilesWithUndirectedGraph1() throws IOException {
	    File expected = new File("src\\SolutionUndirected_test1.txt");
	    File output = folder.newFile("SolutionUndirected.txt");
	    
	    Graph graph = new Graph("src\\MyTest.txt",false);
	    GraphAlgo ga = new GraphAlgo(graph, "src\\test1.txt");
		ga.readFile();
		ga.ShortestPathDijkstra();
		
		double solutions [][] = ga.getOutputFile();
		PrintWriter writer = new PrintWriter(output, "UTF-8");
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
	    Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
	}
	
	/*
	 *	Testing if two files that was created are the same,
	 *	checking with a undirected graph.
	 */
	
	@Test
	public void testFilesWithUndirectedGraph2() throws IOException {
	    File expected = new File("src\\SolutionUndirected_test2.txt");
	    File output = folder.newFile("SolutionUndirected.txt");
	    
	    Graph graph = new Graph("src\\MyTest.txt",false);
	    GraphAlgo ga = new GraphAlgo(graph, "src\\test2.txt");
		ga.readFile();
		ga.ShortestPathDijkstra();
		
		double solutions [][] = ga.getOutputFile();
		PrintWriter writer = new PrintWriter(output, "UTF-8");
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
	    Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
	}
	
	
	/*
	 *	Testing if two files that was created are the same,
	 *	checking with a directed graph.
	 */
	
	@Test
	public void testFilesWithDirectedGraph1() throws IOException {
	    File expected = new File("src\\SolutionDirected_test1.txt");
	    File output = folder.newFile("SolutionDirected.txt");
	    
	    Graph graph = new Graph("src\\MyTest.txt");
	    GraphAlgo ga = new GraphAlgo(graph, "src\\test1.txt");
		ga.readFile();
		ga.ShortestPathDijkstra();
		
		double solutions [][] = ga.getOutputFile();
		PrintWriter writer = new PrintWriter(output, "UTF-8");
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
	    Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
	}
	
	/*
	 *	Testing if two files that was created are the same,
	 *	checking with a directed graph.
	 */
	
	@Test
	public void testFilesWithDirectedGraph2() throws IOException {
	    File expected = new File("src\\SolutionDirected_test2.txt");
	    File output = folder.newFile("SolutionDirected.txt");
	    
	    Graph graph = new Graph("src\\MyTest.txt");
	    GraphAlgo ga = new GraphAlgo(graph, "src\\test2.txt");
		ga.readFile();
		ga.ShortestPathDijkstra();
		
		double solutions [][] = ga.getOutputFile();
		PrintWriter writer = new PrintWriter(output, "UTF-8");
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
	    Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
	}
	
	
	@Test
	public void testConstructor1() {
		
		/*
		 * 	Creating directed graph with weights on it. 
		 *	Then checking if the same graph was created 
		 *	by calling the 'Graph' constructor with no boolean parameter
		 */
		
		SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge> g =
	            new SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge>
	            (DefaultWeightedEdge.class);
		
		
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		
		DefaultWeightedEdge e1 = g.addEdge(0, 1);
		g.setEdgeWeight(e1, 0.2);
		DefaultWeightedEdge e2 = g.addEdge(0, 5);
		g.setEdgeWeight(e2, 0.4);
		DefaultWeightedEdge e3 = g.addEdge(1, 2);
		g.setEdgeWeight(e3, 0.3);
		DefaultWeightedEdge e4 = g.addEdge(2, 4);
		g.setEdgeWeight(e4, 0.8);
		DefaultWeightedEdge e5 = g.addEdge(2, 3);
		g.setEdgeWeight(e5, 0.1);
		DefaultWeightedEdge e6 = g.addEdge(2, 7);
		g.setEdgeWeight(e6, 0.123);
		DefaultWeightedEdge e7 = g.addEdge(3, 4);
		g.setEdgeWeight(e7, 0.1);
		DefaultWeightedEdge e8 = g.addEdge(4, 0);
		g.setEdgeWeight(e8, 0.7);
		DefaultWeightedEdge e9 = g.addEdge(4, 1);
		g.setEdgeWeight(e9, 0.5);
		DefaultWeightedEdge e10 = g.addEdge(4, 5);
		g.setEdgeWeight(e10, 0.8);
		DefaultWeightedEdge e11 = g.addEdge(6, 1);
		g.setEdgeWeight(e11, 0.321);


		Graph graph = new Graph("src\\MyTest.txt");
		
		
		assertEquals(graph.getDWGraph().getAllEdges(1, 6).size(),g.getAllEdges(1, 6).size());
		assertEquals(graph.getDWGraph().getAllEdges(4, 7).size(),g.getAllEdges(4, 7).size());
		assertEquals(graph.getDWGraph().getAllEdges(7, 0).size(),g.getAllEdges(7, 0).size());
		assertEquals(graph.getDWGraph().getAllEdges(4, 1).size(),g.getAllEdges(4, 1).size());
		assertEquals(graph.getDWGraph().getAllEdges(5, 7).size(),g.getAllEdges(5, 7).size());
		assertEquals(graph.getDWGraph().getAllEdges(3, 0).size(),g.getAllEdges(3, 0).size());
		assertEquals(graph.getDWGraph().getAllEdges(1, 6).size(),g.getAllEdges(1, 6).size());
		assertEquals(graph.getDWGraph().getAllEdges(4, 7).size(),g.getAllEdges(4, 7).size());
		assertEquals(graph.getDWGraph().getAllEdges(7, 0).size(),g.getAllEdges(7, 0).size());
		
		assertEquals(graph.isDirected(), true);
		assertEquals(graph.getNumOfEdges(), 11);
		assertEquals(graph.getNumOfNodes(), 7);
		
	}

	@Test
	public void testConstructor2() {
		
		/*
		 * 	Creating undirected graph with weights on it. 
		 *	Then checking if the same graph was created 
		 *	by calling the 'Graph' constructor with 'false'
		 *	which going to create a undirected graph with weights  
		 */
		
		WeightedGraph <Integer, DefaultWeightedEdge> g =
	            new SimpleWeightedGraph <Integer, DefaultWeightedEdge>
	            (DefaultWeightedEdge.class);
		
		
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		
		DefaultWeightedEdge e1 = g.addEdge(0, 1);
		g.setEdgeWeight(e1, 0.2);
		DefaultWeightedEdge e2 = g.addEdge(0, 5);
		g.setEdgeWeight(e2, 0.4);
		DefaultWeightedEdge e3 = g.addEdge(1, 2);
		g.setEdgeWeight(e3, 0.3);
		DefaultWeightedEdge e4 = g.addEdge(2, 4);
		g.setEdgeWeight(e4, 0.8);
		DefaultWeightedEdge e5 = g.addEdge(2, 3);
		g.setEdgeWeight(e5, 0.1);
		DefaultWeightedEdge e6 = g.addEdge(2, 7);
		g.setEdgeWeight(e6, 0.123);
		DefaultWeightedEdge e7 = g.addEdge(3, 4);
		g.setEdgeWeight(e7, 0.1);
		DefaultWeightedEdge e8 = g.addEdge(4, 0);
		g.setEdgeWeight(e8, 0.7);
		DefaultWeightedEdge e9 = g.addEdge(4, 1);
		g.setEdgeWeight(e9, 0.5);
		DefaultWeightedEdge e10 = g.addEdge(4, 5);
		g.setEdgeWeight(e10, 0.8);
		DefaultWeightedEdge e11 = g.addEdge(6, 1);
		g.setEdgeWeight(e11, 0.321);

		Graph graph = new Graph("src\\MyTest.txt",false);
		
		assertEquals(graph.getUDWGraph().getAllEdges(1, 6).size(),g.getAllEdges(1, 6).size());
		assertEquals(graph.getUDWGraph().getAllEdges(4, 7).size(),g.getAllEdges(4, 7).size());
		assertEquals(graph.getUDWGraph().getAllEdges(7, 0).size(),g.getAllEdges(7, 0).size());
		assertEquals(graph.getUDWGraph().getAllEdges(4, 1).size(),g.getAllEdges(4, 1).size());
		assertEquals(graph.getUDWGraph().getAllEdges(5, 7).size(),g.getAllEdges(5, 7).size());
		assertEquals(graph.getUDWGraph().getAllEdges(3, 0).size(),g.getAllEdges(3, 0).size());
		assertEquals(graph.getUDWGraph().getAllEdges(1, 6).size(),g.getAllEdges(1, 6).size());
		assertEquals(graph.getUDWGraph().getAllEdges(4, 7).size(),g.getAllEdges(4, 7).size());
		assertEquals(graph.getUDWGraph().getAllEdges(7, 0).size(),g.getAllEdges(7, 0).size());
		
		assertEquals(graph.isDirected(), false);
		assertEquals(graph.getNumOfEdges(), 11);
		assertEquals(graph.getNumOfNodes(), 7);
		
	}


	@Test
	public void testConstructor3() {
		
		/*
		 * 	Creating directed graph with weights on it. 
		 *	Then checking if the same graph was created 
		 *	by calling the 'Graph' constructor with 'true'
		 *	which will create a directed graph with weights  
		 */
		
		SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge> g =
	            new SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge>
	            (DefaultWeightedEdge.class);
		
		
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		
		DefaultWeightedEdge e1 = g.addEdge(0, 1);
		g.setEdgeWeight(e1, 0.2);
		DefaultWeightedEdge e2 = g.addEdge(0, 5);
		g.setEdgeWeight(e2, 0.4);
		DefaultWeightedEdge e3 = g.addEdge(1, 2);
		g.setEdgeWeight(e3, 0.3);
		DefaultWeightedEdge e4 = g.addEdge(2, 4);
		g.setEdgeWeight(e4, 0.8);
		DefaultWeightedEdge e5 = g.addEdge(2, 3);
		g.setEdgeWeight(e5, 0.1);
		DefaultWeightedEdge e6 = g.addEdge(2, 7);
		g.setEdgeWeight(e6, 0.123);
		DefaultWeightedEdge e7 = g.addEdge(3, 4);
		g.setEdgeWeight(e7, 0.1);
		DefaultWeightedEdge e8 = g.addEdge(4, 0);
		g.setEdgeWeight(e8, 0.7);
		DefaultWeightedEdge e9 = g.addEdge(4, 1);
		g.setEdgeWeight(e9, 0.5);
		DefaultWeightedEdge e10 = g.addEdge(4, 5);
		g.setEdgeWeight(e10, 0.8);
		DefaultWeightedEdge e11 = g.addEdge(6, 1);
		g.setEdgeWeight(e11, 0.321);



		Graph graph = new Graph("src\\MyTest.txt",true);
		
		assertEquals(graph.getDWGraph().getAllEdges(1, 6).size(),g.getAllEdges(1, 6).size());
		assertEquals(graph.getDWGraph().getAllEdges(4, 7).size(),g.getAllEdges(4, 7).size());
		assertEquals(graph.getDWGraph().getAllEdges(7, 0).size(),g.getAllEdges(7, 0).size());
		assertEquals(graph.getDWGraph().getAllEdges(4, 1).size(),g.getAllEdges(4, 1).size());
		assertEquals(graph.getDWGraph().getAllEdges(5, 7).size(),g.getAllEdges(5, 7).size());
		assertEquals(graph.getDWGraph().getAllEdges(3, 0).size(),g.getAllEdges(3, 0).size());
		assertEquals(graph.getDWGraph().getAllEdges(1, 6).size(),g.getAllEdges(1, 6).size());
		assertEquals(graph.getDWGraph().getAllEdges(4, 7).size(),g.getAllEdges(4, 7).size());
		assertEquals(graph.getDWGraph().getAllEdges(7, 0).size(),g.getAllEdges(7, 0).size());
		
		assertEquals(graph.isDirected(), true);
		assertEquals(graph.getNumOfEdges(), 11);
		assertEquals(graph.getNumOfNodes(), 7);
		
		
		
		
	}

	
}
