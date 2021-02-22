package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� �ٸ��� ���� weight���� �ߵ��ϴ�.
 * �� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.
 * 
 * ���� ���, ���̰� 2�̰� 10kg ���Ը� �ߵ�� �ٸ��� �ֽ��ϴ�. ���԰� [7, 4, 5, 6]kg�� Ʈ���� ������� �ִ� �ð� �ȿ� �ٸ��� �ǳʷ��� ������ ���� �ǳʾ� �մϴ�.
 * 
 * ��� �ð�	�ٸ��� ���� Ʈ��	�ٸ��� �ǳʴ� Ʈ��	��� Ʈ��
 * 0			[]			[]			[7,4,5,6]
 * 1~2			[]			[7]			[4,5,6]
 * 3			[7]			[4]			[5,6]
 * 4			[7]			[4,5]		[6]
 * 5			[7,4]		[5]			[6]
 * 6~7			[7,4,5]		[6]			[]
 * 8			[7,4,5,6]	[]			[]
 * ����, ��� Ʈ���� �ٸ��� �������� �ּ� 8�ʰ� �ɸ��ϴ�.
 * 
 * solution �Լ��� �Ű������� �ٸ� ���� bridge_length, �ٸ��� �ߵ� �� �ִ� ���� weight, Ʈ���� ���� truck_weights�� �־����ϴ�. �̶� ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * ���� ����
 * bridge_length�� 1 �̻� 10,000 �����Դϴ�.
 * weight�� 1 �̻� 10,000 �����Դϴ�.
 * truck_weights�� ���̴� 1 �̻� 10,000 �����Դϴ�.
 * ��� Ʈ���� ���Դ� 1 �̻� weight �����Դϴ�.
 * ����� ��
 * bridge_length	weight	truck_weights	return
 * 2	10	[7,4,5,6]	8
 * 100	100	[10]	101
 * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
 * ��ó
 * 
 * �� ���� - 2020�� 4�� 06�� �׽�Ʈ���̽��� �߰��Ǿ����ϴ�.
 */
public class Q1_�ٸ���������Ʈ��_stack_queue_lv2 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		if(truck_weights[0] > weight) return -1;
		
		class Truck {
			int weight;
			int cross_time;
			Truck(int weight, int cross_time){
				this.weight = weight;
				this.cross_time = cross_time;			
			}
		}
		Queue<Truck> wating = new LinkedList<Truck>();
		Queue<Truck> cross = new LinkedList<Truck>();
		
		for(int truck_weight : truck_weights) wating.offer(new Truck(truck_weight, 0));
		
		int time = 0;
		int total_weight = 0;
		while(!cross.isEmpty() || !wating.isEmpty()) {
			++time;
			if(!cross.isEmpty() && time - cross.peek().cross_time >= bridge_length) total_weight -= cross.poll().weight;
			
			if(!wating.isEmpty() && total_weight + wating.peek().weight <= weight) {
				Truck temp = wating.poll();
				total_weight += temp.weight;
				cross.offer(new Truck(temp.weight, time));
			}
		};
		
		return time;
	}
}
