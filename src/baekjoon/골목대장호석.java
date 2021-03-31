package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ������ȣ�� {
	static int N,M,A,B,C;
	static LinkedList<Node>[] mapA;
	static boolean[] visited;
	static int total = Integer.MAX_VALUE;
	public static class Node {
		int dest;
		int cost;
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//		������ ���� N, ��� ���� M, ���� ������ ��ȣ A, ���� ������ ��ȣ B, ���� �� C
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken())-1;
		B = Integer.parseInt(st.nextToken())-1;
		C = Integer.parseInt(st.nextToken());
		mapA = new LinkedList[N];
		for(int i = 0; i < N ;++i) mapA[i] = new LinkedList<>();
		visited = new boolean[N];
		int stNode;
		int endNode;
		int nodeCost;
		for(int i = 0; i < M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			stNode = Integer.parseInt(st.nextToken())-1;
			endNode = Integer.parseInt(st.nextToken())-1;
			nodeCost = Integer.parseInt(st.nextToken());
			
			mapA[stNode].add(new Node(endNode, nodeCost));
			mapA[endNode].add(new Node(stNode, nodeCost));
			
		}
		
		dfs(A,C,-1);
		System.out.println(total == Integer.MAX_VALUE ? -1 : total);
	}
	private static void dfs(int point, int cost, int maxVal) {
		if (point == B) {
			total = Math.min(total, maxVal);
			return;
		}
		if (cost <= 0) return;
		
		for(int i = 0; i < mapA[point].size(); ++i) {
			int nowNode = mapA[point].get(i).dest;
			int newCost = mapA[point].get(i).cost;
			
			if ( visited[nowNode] || cost < newCost) continue;
			
			visited[nowNode] = true;
			dfs(nowNode, cost-newCost, Math.max(newCost, maxVal));
			visited[nowNode] = false;
		}
		
	}
}