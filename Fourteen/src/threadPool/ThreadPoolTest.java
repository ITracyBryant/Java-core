/**
 * 
 */
package threadPool;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * use a thread pool to execute the task
 * @XinCheng 2018年1月18日 Administrator
 *
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in))
		{
			System.out.print("Enter base directory (e.g. /usr/local/jdk1.8.144/src): ");
			String directory = in.nextLine();
			System.out.print("Enter keyword (e.g. java): ");
			String keyword = in.nextLine();
			
			ExecutorService pool = Executors.newCachedThreadPool();
			
			MatchCounter counter = new MatchCounter(new File(directory), keyword, pool, 0);
			Future<Integer> result = pool.submit(counter);
			
			try
			{
				System.out.println(result.get() + " Matching files.");
			}
			catch(ExecutionException e)
			{
				e.printStackTrace();
			}
			catch(InterruptedException e)
			{
				
			}
			pool.shutdown(); // 启动该池关闭序列
			
			int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
			System.out.println("Largest pool size = " + largestPoolSize);
		}
	}

}

/**
 * This task counts the files in a directory and its sub-directories that contain a given keyword.
 * @XinCheng 2018年1月18日 Administrator
 *
 */
class MatchCounter implements Callable<Integer>
{
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;
	
	/**
	 * Constructs a MatchCounter.
	 * @param directory the directory in which to start the search
	 * @param keyword the keyword to look for
	 * @param pool the thread pool for submit subtasks
	 * @param count the count to calculate the match number
	 */
	public MatchCounter(File directory, String keyword, ExecutorService pool, int count) {
		super();
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
		this.count = count;
	}
	
	public Integer call()
	{
		count = 0;
		try
		{
			File[] files =directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>(); //
			
			for(File file : files)
			{
				if(file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file, keyword, pool, count);
					Future<Integer> result = pool.submit(counter); //
					results.add(result);
				}
				else
				{
					if(search(file)) count++;
				}
			}
			
			for(Future<Integer> result : results)
			{
				try
				{
					count += result.get();
				}
				catch(ExecutionException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(InterruptedException e)
		{
			
		}
		return count;
	}
	
	/**
	 * Searches a file for a given keyword.
	 * @param file the file to search
	 * @return true if the keyword is contained in the file
	 */
	public boolean search(File file)
	{
		try
		{
			try(Scanner in = new Scanner(file, "UTF-8"))
			{
				boolean found = false;
				while(!found && in.hasNextLine())
				{
					String line = in.nextLine();
					if(line.contains(keyword))
						found = true;
				}
				return found;
			}
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
}
