class MedianFinder {
public:
    priority_queue<int> maxHeap; // left (smaller half)
    priority_queue<int, vector<int>, greater<int>> minHeap; // right (larger half)

    MedianFinder() {}

    void addNum(int num) {
        // Step 1: add to maxHeap
        maxHeap.push(num);

        // Step 2: balance: move top to minHeap
        minHeap.push(maxHeap.top());
        maxHeap.pop();

        // Step 3: maintain size property
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }

    double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.top();
        }
        return (maxHeap.top() + minHeap.top()) / 2.0;
    }
};