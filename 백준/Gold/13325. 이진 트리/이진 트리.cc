#include <cstdio>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

int *tree;
int *maxArray;
//int tree[(1 << 21) + 1];
//int maxArray[(1 << 21) + 1];
int n, m, maxWeight, sum;
vector<int> leafWeight;

void ComputeLeafWeight() {
	queue< pair<int, int> > visit;
	visit.push(make_pair(0, 0));
	while (!visit.empty()) {
		int pos = visit.front().first,
			weight = visit.front().second,
			left = pos * 2 + 1,
			right = pos * 2 + 2;
		visit.pop();
		if (left < m) {
			visit.push(make_pair(left, weight + tree[left]));
			visit.push(make_pair(right, weight + tree[right]));
		}
		else {
			leafWeight.push_back(weight);
		}
	}
}

void ComputeMaxArray() {
	int k = (1 << (n - 1)) - 1;
	queue<int> visit;
	for (int i = k, l = 0; i < m; i++, l++) {
		visit.push(i);
		maxArray[i] = leafWeight[l];
	}
	while (!visit.empty())
	{
		int a = visit.front();
		visit.pop();
		int b = visit.front();
		visit.pop();
		maxArray[a / 2] = maxArray[a] > maxArray[b] ? maxArray[a] : maxArray[b];
		if (a/2) {
			visit.push(a / 2);
		}
	}
}

void ComputeAnswer() {
	queue<int> visit;
	visit.push(0);
	while (!visit.empty())
	{
		int pos = visit.front(),
			left = pos * 2 + 1,
			right = pos * 2 + 2,
			parent = (int)ceil(pos / 2.0) - 1,
			x;
		visit.pop();
		if (!pos) {
			parent = 0;
		}
		x = (maxWeight - (maxArray[pos] + tree[parent]));
		sum += tree[pos] + x;
		tree[pos] = tree[parent] + x;

		if (left < m) {
			visit.push(left);
			visit.push(right);
		}
	}
}

int main(void) {
	scanf("%d", &n);
	n++;
	m = (1 << n) - 1;

	tree = new int[m + 1];
	maxArray = new int[m + 1];
	maxArray[0] = tree[0] = 0;
	for (int i = 1; i < m; i++) {
		scanf("%d", tree + i);
	}
	ComputeLeafWeight();
	ComputeMaxArray();
	maxWeight = maxArray[0];
	ComputeAnswer();
	printf("%d\n", sum);
	delete[] tree;
	delete[] maxArray;
	return 0;
}