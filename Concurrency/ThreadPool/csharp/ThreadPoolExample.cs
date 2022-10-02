namespace ThreadTest;

public static class ThreadPoolExample
{
  public static void DoMultiThreadedWork(int numberOfJobs = 400)
  {
    for (int i = 0; i < numberOfJobs; i++)
    {
      // Add a work item to the ith spot in the queue.
      ThreadPool.QueueUserWorkItem(WorkItem, i);
      
      // Set the min number of thread that should be working on this queue.
      ThreadPool.SetMinThreads(6, 4);

      // Set the max number of threads assigned to this queue.
      // We typically want one thread per core on the cpu.
      ThreadPool.SetMaxThreads(10, 4);

      while (ThreadPool.PendingWorkItemCount != 0)
      {
        // Show console output of the current thread count, completed work item count,
        // and pending work item count.
        Console.WriteLine($"Threads={ThreadPool.ThreadCount,2}");
        Console.WriteLine($"Completed={ThreadPool.CompletedWorkItemCount,-3}");
        Console.WriteLine($"Pending={ThreadPool.PendingWorkItemCount,-3}");
        Console.WriteLine();
        Thread.Sleep(200);
      }
    }
  }

  static void WorkItem(object o)
  {
    // This represents a work item that a thread will pick up.
    // We are calling a random sleep time to similate the job being performed.
    // Each simulated job will take between .2 and 1.1 seconds to complete.
    Thread.Sleep(new Random().Next(200, 1100));
  }
}
