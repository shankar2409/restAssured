package genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer {

	int count=0;
	int retryCount=3;
	@Override
	public boolean retry(ITestResult arg0) {
		if(count<=retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
