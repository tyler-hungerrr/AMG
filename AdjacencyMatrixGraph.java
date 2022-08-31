import java.util.*;

public class AdjacencyMatrixGraph{
	private int[][] adjacencyMatrix;

	public AdjacencyMatrixGraph(int[][] adjMatrix)
	{ 
		adjacencyMatrix= adjMatrix;
	}
	
	//get the number of vertices
	public int numVertices() {
	//return the number of row or col
	}

	//get the number of edges
	public int numEdges() {
	//for each row
		//for each col
			//count the number of element not equal to 0
	//return the count
	}
	
	//check if the graph is a directed graph or not
	public boolean isDirected(){
	//if a graph is undirected, then the top-right half and left-bottom half should symmetric according to the main diagonal
	//for each row in the the top-right half	
		//for each col the the top-right half
		   //if element stored at [i][j] not equals [j][i], return false
	//return true
	}
	
	//check if the graph is a weighted graph or not
	public boolean isWeighted(){
	//for each row 	
		//for each col 
		   //if the cell contains a value is not 0 and not 1, return true
	//return false
	}

	//get the number of out degree for the vertex whose index is v
	public int outDegree(int v){
	//for  each cell at row v
		//count the number of cell not equal to 0
	//return the count		
	}

	//get the number of in degree for the vertex whose index is v
	public int inDegree(int v){
	//for each cell at col v
		//count the number of cell not equal to 0
	//return the count	
	}
	

	public int getMaxDegree() {
		//if the graph is an undirected graph, this method return the vertex with maximum degree
			//initial max to the degree of the first vertex, maxID to 0
			//for each remaining vertex
				//if it has a larger degree, update max and maxID
		//else return the vertex with maximum indegree+outdegree
			//initial max to the indegree+outdegree of the first vertex, maxID to 0
			//for each remaining vertex
				//if it has a larger indegree+outdegree, update max and maxID
		//return maxID
	}
	
	//get the list of neighbor for the vertex whose index is v
	public ArrayList<Integer> getNeighbors(int v){
		//create an empty ArrayList
		//for each cell at row v
				//if the stored element is not equal to 0, add the col index into the ArrayList
		//return the ArrayList		
	}
	
	//return true if vertex u and v are neighbors
	public boolean isNeighbors(int u, int v){
		//check cell value equals to 0 or not
	}
	
	//insert an edge between two vertices, return false if there is an edge between them already existed
	public boolean insertEdge(int u, int v, int weight){
	//if directed graph and edge does not exist, insert edge [u][v] and return true
	//if undirected graph and edge does not exist, insert edge[u][v], [v][u] and return true	
	//return false
	}

	//remove an edge between two vertices, return false if there is no edge between them
	public boolean removeEdge(int u, int v){
	//if directed graph and edge exists, remove edge [u][v] and return true
	//if undirected graph and edge exists, remove edge[u][v], [v][u] and return true
	//return false
	}
	
	//this method will remove vertex has row index v and col index v
	public void removeVertex(int v){
		//create a two dimensional array referred as newMatrix here with size adjacencyMatrix.length-1 by adjacencyMatrix.length-1
		//copy element from adjacencyMatrix to newMatrix, skip row and col v
		//update adjacencyMatrix newMatrix 
	}
	
	//get the traversal sequence of the graph by using BFS and keep the sequence in an ArrayList
	public ArrayList<Integer> BFS(int start)
	{
		//create one array to record if a vertex is checked, initialize to unchecked
		//create two ArrayList refers to currLayer, nextLayer
		//create another ArrayList to keep the BFS result
		//add start to currLayer
		//while currLayer is not empty
			//grab the first element from currLayer
			//add this element to BFS result
			//marked it as checked in the checkedArray
			//add all its unchecked neighbor to nextLayer one by one
		    //remove this element from currLayer
			//if currLayer is empty, make nextLayer to currLayer, set nextLayer to null		
		
		//return BFS result
	}
	
	public boolean isConnected()
	{
		//check the size of the array returned by BFS or DFS
		//return true is equals to the number of vertices on the grpah
		//false otherwise
	}
			
	// or DFS()
	 /* get the traversal sequence of the graph by using DFS and keep the sequence in an ArrayList
	 
	public ArrayList<Integer> DFS()
	{

	}*/
	
	public void printAdjMatrix()
	{
		for(int i=0;i<adjacencyMatrix.length;i++) {
			for(int j=0;j<adjacencyMatrix[i].length;j++)
				System.out.print(adjacencyMatrix[i][j]+"\t");
			System.out.println();
		}
		
	}

}
