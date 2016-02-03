# Retrieve and Rank
The IBM Watson [Retrieve and Rank][service_url] service helps users find the most relevant information for their queries by using a combination of search and machine learning algorithms to detect "signals" in the data. You load your data into the service, which is built on top of Apache Solr, and train a machine learning model. Then use the trained model to provide improved results to users.

Give it a try! Click the button below to fork into IBM DevOps Services and deploy your own copy of this application on Bluemix.  
[![Deploy to Bluemix](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/germanattanasio/retrieve-and-rank-java)

## Getting Started

1. Create a Bluemix Account

   [Sign up][sign_up] in Bluemix or use an existing account. Watson Services
   in Beta are free to use.

2. Download and install the [Cloud-foundry CLI][cloud_foundry] tool.

3. Edit the `manifest.yml` file and change the `<application-name>` to something unique.

  ```none
  applications:
  - services:
    - retrieve-and-rank-service
    name: <application-name>
    path: webApp.war
    memory: 512M
  ```

  The name you use determines your initial application URL, e.g.,
  `<application-name>.mybluemix.net`.

4. Connect to Bluemix in the command line tool.

  ```sh
  $ cf api https://api.ng.bluemix.net
  $ cf login -u <your-user-ID>
  ```

5. Create the Personality Insights service in Bluemix.

  ```sh
  $ cf create-service personality_insights tiered retrieve-and-rank-service
  ```

6. Download and install the [maven][maven] compiler.

7. Build the project.

   You need to use the Apache `maven` to build the war file.

  ```sh
  $ maven install
  ```

8. Push it live!
  ```sh
  $ cf push -p target/webApp.war
  ```

## Running locally

  The application uses the WebSphere Liberty profile runtime as its server,
  so you need to download and install the profile as part of the steps below.

1. Copy the credentials from your `retrieve-and-rank-service` service in Bluemix to
   `RetrieveAndRankResource.java`. You can use the following command to see the
   credentials:

    ```sh
    $ cf env <application-name>
    ```

   Example output:

    ```sh
    System-Provided:
    {
    "VCAP_SERVICES": {
      "retrieve-and-rank": [{
          "credentials": {
            "url": "<url>",
            "password": "<password>",
            "username": "<username>"
          },
        "label": "retrieve-and-rank",
        "name": "retrieve-and-rank-service",
        "plan": "Standard"
     }]
    }
    }
    ```

	You need to copy the `username`, `password`, and `url`.

2. Install the [Liberty profile runtime][liberty] (for Mac OSX, check this
   [guide][liberty_mac]).

3. Create a Liberty profile server in Eclipse.

4. Add the application to the server.

5. Start the server.

6. Go to `http://localhost:9080/retrieve-and-rank-v1-sample` to see the running application.

## Troubleshooting

  To troubleshoot your Bluemix application, the most useful source of
  information is the log files. To see them, run the following command:

  ```sh
  $ cf logs <application-name> --recent
  ```

## License

  This sample code is licensed under Apache 2.0.  
  Full license text is available in [LICENSE](LICENSE).

## Contributing

  See [CONTRIBUTING](CONTRIBUTING.md).

## Open Source @ IBM

  Find more open source projects on the
  [IBM Github Page](http://ibm.github.io/).

[service_url]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/retrieve-and-rank.html
[cloud_foundry]: https://github.com/cloudfoundry/cli
[sign_up]: https://console.ng.bluemix.net/registration/
[liberty]: https://developer.ibm.com/wasdev/downloads/
[liberty_mac]: http://www.stormacq.com/how-to-install-websphere-8-5-liberty-profile-on-mac/
[maven]: https://maven.apache.org/
