
In this example we’ll look at how to implement a thread pool using goroutines and channels.

To run the thread pool run command : $ go run threadpool.go 

Console Output:
2021/10/30 10:44:37 Lets start the thread pool ..
2021/10/30 10:44:37 Worker 3 started job 1 
2021/10/30 10:44:37 Worker 2 started job 3 
2021/10/30 10:44:37 Worker 1 started job 2 
2021/10/30 10:44:38 Worker 1 finished job 2 
2021/10/30 10:44:38 Worker 1 started job 4 
2021/10/30 10:44:38 result 4 
2021/10/30 10:44:38 Worker 3 finished job 1 
2021/10/30 10:44:38 Worker 3 started job 5 
2021/10/30 10:44:38 result 2 
2021/10/30 10:44:38 Worker 2 finished job 3 
2021/10/30 10:44:38 Worker 2 started job 6 
2021/10/30 10:44:38 result 6 
2021/10/30 10:44:39 Worker 2 finished job 6 
2021/10/30 10:44:39 Worker 1 finished job 4 
2021/10/30 10:44:39 Worker 1 started job 8 
2021/10/30 10:44:39 result 12 
2021/10/30 10:44:39 Worker 3 finished job 5 
2021/10/30 10:44:39 result 8 
2021/10/30 10:44:39 Worker 3 started job 9 
2021/10/30 10:44:39 result 10 
2021/10/30 10:44:39 Worker 2 started job 7 
2021/10/30 10:44:40 Worker 3 finished job 9 
2021/10/30 10:44:40 Worker 1 finished job 8 
2021/10/30 10:44:40 Worker 2 finished job 7 
2021/10/30 10:44:40 result 18 
2021/10/30 10:44:40 result 16 
2021/10/30 10:44:40 result 14 
2021/10/30 10:44:40 Worker 3 started job 10 
2021/10/30 10:44:41 Worker 3 finished job 10 
2021/10/30 10:44:41 result 20 
2021/10/30 10:44:41 Hurray, All jobs done !