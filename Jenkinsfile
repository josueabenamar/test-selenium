pipeline
{
	agent any

	stages
	{
		stage("Build")
		{
			steps
			{
				echo "building app"

				sh '''
					cd java
					javac -cp ".:libs/*" FirefoxLoginTest.java
					javac -cp ".:libs/*" ChromeLoginTest.java
					'''
			}
		}

		stage("Test Firefox")
		{
			steps
			{
				echo "testing app on firefox"

				sh '''
					export DISPLAY=":99"
					cd java
					java -cp ".:libs/*" org.junit.runner.JUnitCore FirefoxLoginTest
					'''
			}
		}

		stage("Test Chrome")
		{
			steps
			{
				echo "testing app on chrome"

				sh '''
					export DISPLAY=":99"
					cd java
					java -cp ".:libs/*" org.junit.runner.JUnitCore ChromeLoginTest
					'''
			}
		}
	}
}
