import java.util.*;

public class AdjacencyMatrixGraph{
	private int[][] adjacencyMatrix;

	public AdjacencyMatrixGraph(int[][] adjMatrix)
	{ 
		adjacencyMatrix= adjMatrix;
	}
	
	//get the number of vertices
	public int numVertices() {
		return adjacencyMatrix.length;
	}
	
	//get the number of edges
	public int numEdges() {
		int count = 0;
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			for (int col = 0; col < adjacencyMatrix[row].length; col++) {
				if (adjacencyMatrix[row][col] != 0) count++;
			}
		}
		return count;
	}
	
	//check if the graph is a directed graph or not
	public boolean isDirected(){
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			for (int col = 0; col < adjacencyMatrix[row].length; col++) {
				if (adjacencyMatrix[row][col] != adjacencyMatrix[col][row]) return true;
			}
		}
		return false;
	}
	
	//check if the graph is a weighted graph or not
	public boolean isWeighted(){
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			for (int col = 0; col < adjacencyMatrix[row].length; col++) {
				if (adjacencyMatrix[row][col] != 0 && adjacencyMatrix[row][col] != 1) return true;
			}
		}
		return false;
	}

	//get the number of out degree for the vertex whose index is v
	public int outDegree(int v){
	//for  each cell at row v
		//count the number of cell not equal to 0
	//return the count	
		int count = 0;
		for (int col = 0; col < adjacencyMatrix[v].length; col++) {
			if (adjacencyMatrix[v][col] != 0 ) count++;
		}
		return count;
	}

	//get the number of in degree for the vertex whose index is v
	public int inDegree(int v){
	//for each cell at col v
		//count the number of cell not equal to 0
	//return the count	
		int count = 0;
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			if (adjacencyMatrix[row][v] != 0 ) count++;
		}
		return count;
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
		int maxID;
		if(isDirected() == false) {
			int max = adjacencyMatrix[0][0];
			maxID = 0;
			for (int row = 0; row < adjacencyMatrix.length; row++) {
				for (int col = 0; col < adjacencyMatrix[row].length; col++) {
					if (adjacencyMatrix[row][col] > max) {
						max = adjacencyMatrix[row][col];
						maxID = adjacencyMatrix[row][col];
					}
				}
			}
		}
		else {
			int max = inDegree(0) + outDegree(0);
			maxID = 0;
			for (int row = 0; row < adjacencyMatrix.length; row++) {
				for (int col = 0; col < adjacencyMatrix[row].length; col++) {
					if (adjacencyMatrix[row][col] > max) {
						max = adjacencyMatrix[row][col];
						maxID = adjacencyMatrix[row][col];
					}
				}
			}
		}
		return maxID;
	}
	
	//get the list of neighbor for the vertex whose index is v
	public ArrayList<Integer> getNeighbors(int v){
		//create an empty ArrayList
		//for each cell at row v
				//if the stored element is not equal to 0, add the col index into the ArrayList
		//return the ArrayList	
		 
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int col = 0; col < adjacencyMatrix[v].length; col++) {
			if (adjacencyMatrix[v][col] != 0 ) out.add(col);
		}
		return out;
	}
	
	//return true if vertex u and v are neighbors
	public boolean isNeighbors(int u, int v){
		//check cell value equals to 0 or not
		if (adjacencyMatrix[u][v] == 0) return true;
		else return false;
	}
	
	//insert an edge between two vertices, return false if there is an edge between them already existed
	public boolean insertEdge(int u, int v, int weight){
	//if directed graph and edge does not exist, insert edge [u][v] and return true
	//if undirected graph and edge does not exist, insert edge[u][v], [v][u] and return true	
	//return false
		if(isDirected() == true && adjacencyMatrix[u][v] == 0) {
			adjacencyMatrix[u][v] = weight;
			return true;
		}
		else if (isDirected() == false && adjacencyMatrix[u][v] == 0 && adjacencyMatrix[v][u] == 0) {
			adjacencyMatrix[u][v] = weight;
			adjacencyMatrix[v][u] = weight;
			return true;
		}
		return false;
	}

	//remove an edge between two vertices, return false if there is no edge between them
	public boolean removeEdge(int u, int v){
	//if directed graph and edge exists, remove edge [u][v] and return true
	//if undirected graph and edge exists, remove edge[u][v], [v][u] and return true
	//return false
		if(isDirected() == true && adjacencyMatrix[u][v] != 0) {
			adjacencyMatrix[u][v] = 0;
			return true;
		}
		else if (isDirected() == false && adjacencyMatrix[u][v] != 0 && adjacencyMatrix[v][u] != 0) {
			adjacencyMatrix[u][v] = 0;
			adjacencyMatrix[v][u] = 0;
			return true;
		}
		return false;
	}
	
	//this method will remove vertex has row index v and col index v
	public void removeVertex(int v){
		//create a two dimensional array referred as newMatrix here with size adjacencyMatrix.length-1 by adjacencyMatrix.length-1
		//copy element from adjacencyMatrix to newMatrix, skip row and col v
		//update adjacencyMatrix newMatrix 
		int newRow = 0;
		int[][] newMatrix = new int[adjacencyMatrix.length-1][adjacencyMatrix.length-1];
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			if (row != v) {
				int newCol = 0;
			for (int col = 0; col < adjacencyMatrix[row].length; col++) {
				if (col != v) {
					newMatrix[newRow][newCol] = adjacencyMatrix[row][col];
					newCol++;
				}
			}
			newRow++;
			}
		}
		adjacencyMatrix = newMatrix;
	}
	
	//get the traversal sequence of the graph by using BFS and keep the sequence in an ArrayList
	public ArrayList<Integer> BFS(int start)
	{
		int[] checked = new int[adjacencyMatrix.length];
		for (int i = 0; i < checked.length; i++) checked[i] = 0;
		ArrayList<Integer> currLayer = new ArrayList<Integer>();
		ArrayList<Integer> nextLayer = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		currLayer.add(start);
		while (currLayer.size() != 0) {
			result.add(currLayer.get(0));
			checked[currLayer.get(0)] = 1;
			ArrayList<Integer> neighbor = new ArrayList<Integer>();
			neighbor = getNeighbors(currLayer.get(0));
			for (int u = 0; u < neighbor.size(); u++) {
				if(checked[neighbor.get(u)] != 1 && nextLayer.contains(neighbor.get(u)) == false && currLayer.contains(neighbor.get(u)) == false) 
					nextLayer.add(neighbor.get(u));
			}
			currLayer.remove(0);
			if (currLayer.size() == 0) {
				currLayer.addAll(nextLayer);
				nextLayer.clear();
			}
		}
		for (Integer e:result) System.out.print(e + " ");
		return result;
	}
	
	public boolean isConnected()
	{
		//check the size of the array returned by BFS or DFS
		//return true is equals to the number of vertices on the grpah
		//false otherwise
		if (BFS(0).size() == numVertices()) return true;
		else return false;
	}
	
	public void printAdjMatrix()
	{
		for(int i=0;i<adjacencyMatrix.length;i++) {
			for(int j=0;j<adjacencyMatrix[i].length;j++)
				System.out.print(adjacencyMatrix[i][j]+"\t");
			System.out.println();
		}
		
	}

}
