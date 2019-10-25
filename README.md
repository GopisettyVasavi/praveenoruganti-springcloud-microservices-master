# praveenoruganti-springcloud-microservices-master
SpringBoot applications using cloud concepts by making use of PCF Webservices

Introduction to MicroServices

Microservices are built around the capabilities and independently deployable by fully automated deployment machinery like usage of SpringBoot, Jenkins and PCF.

Each Microservice should be able to provide unique business context.

Generally, it is implemented as a REST service on HTTP protocol, with technology-agnostic APIs.
Ideally, it does not share database with any other service.

Microservices are

	REST
	and Small Well Chosen deployable Units
	and Cloud Enabled

Challenges of Microservices

	Bounded Context
	Configuration Management
	Dynamic Scale up and Scale down – we will use Eureka,Ribbon.
	Visibility – we will use Zipkin(using sleuth for generated id for each request) and Zuul
	Pack of Cards – Not well designed – Fault tolerance i.e. using Hystrix.


Spring Cloud solves the above challenges of microservices by using Netflix Eureka for service registry and discovery which is known as Naming Server ,Spring Cloud config which provides central GIT location for all the configuration files, Spring cloud sleuth for distributed tracing, Netflix Hystrix for fault tolerance which acts as circuit breaker, Netflix Ribbon for Client side load balancing and Netflix Zuul is a gateway service that provides dynamic routing, monitoring, resiliency, security.


What is Bounded Context?
A bounded context is like a specific responsibility that is developed within a boundary. In a domain there can be multiple bounded contexts that are internally implemented. Eg. A hospital system can have bounded contexts like- Emergency Ward handling, Regular vaccination, Out patient treatment etc. Within each bounded context, each sub-system can be independently designed and implemented.



Advantages of Microservices

	Adaption of new technologies and process adaption
	Dynamic Scaling
	Resilence
	Reuse
	Faster release cycles i.e... smaller component development

Why Microservices? 

To build reliable business system

Is it a good idea for Microservices to share a common database?

Sharing a common database between multiple Microservices increases coupling
between them. One service can start accessing data tables of another service. This can defeat the purpose of bounded context. So it is not a good idea to share a common
database between Microservices.

What are the disadvantages of using Shared libraries approach to decompose a monolith application?
	You can create shared libraries to increase reuse and sharing of features among teams. But there are some downsides to it.
	Since shared libraries are implemented in same language, it constrains you from using multiple types of technologies.
	It does not help you with scaling the parts of system that need better performance.
	Deployment of shared libraries is same as deployment of Monolith application, so it comes with same deployment issues.
	Shared libraries introduce shared code that can increase coupling in software.

What is the preferred type of communication between Microservices? Synchronous or Asynchronous?
	Synchronous communication is a blocking call in which client blocks itself from doing anything else, till the response comes back.In Asynchronous communication, client can move ahead with its work after making an asynchronous call. Therefore client is not blocked.
	In synchronous communication, a Microservice can provide instant response about success or failure. In real-time systems, synchronous service is very useful. In Asynchronous communication, a service has to react based on the response received in future.
	Synchronous systems are also known as request/response based. Asynchronous systems are event-based.
	Synchronous Microservices are not loosely coupled.  
	Depending on the need and critical nature of business domain, Microservices can choose synchronous or asynchronous form of communication.
SOA vs Microservices
 
Service Oriented Architecture (SOA) is an approach to develop software by creating multiple services. It creates small parts of services and promotes reusability of software. But SOA development can be slow due to use of things like communication protocols SOAP, middleware and lack of principles.
On the other hand, Microservices are agnostic to most of these things. You can use any technology stack, any hardware/middleware, any protocol etc. as long as you follow the principles of Microservices. Microservices architecture also provides more flexibility, stability and speed of development over SOA architecture.
What is the difference between Orchestration and Choreography in Microservices architecture?
	In Orchestration, we rely on a central system to control and call various Microservices to complete a task. In Choreography, each Microservice works like a State Machine and reacts based on the input from other parts.
	Orchestration is a tightly coupled approach for integrating Microservices. But Choreography introduces loose coupling. Also, Choreography based systems are more flexible and easy to change than Orchestration based systems.
	Orchestration is often done by synchronous calls. But choreography is done by asynchronous calls. The synchronous calls are much simpler compared to asynchronous communication.
Can we create Microservices as State Machines?
Yes, Microservices are independent entities that serve a specific context. For that context, the Microservice can work as a State Machine. In a State Machine, there are lifecycle events that cause change in the state of the system.
For Example, In a Library service, there is a book that changes state based on different events like- issue a book, return a book, lose a book, late return of a book, add a new book to catalog etc. These events and book can form a state machine for Library Microservice.
12 Factor App
 
12 factor app (twelve-factor app) is a methodology for building distributed applications that run in the cloud and are delivered as a service. The approach was developed by Adam Wiggins, the co-founder of Horoku, a platform-as-a-service which is now part of Salesforce.com: The Customer Success Platform To Grow Your Business. Wiggin's goal was to synthesize best practices for deploying an app on Horoku and provide developers who are new to the cloud with a framework for discussing the challenges of native cloud applications.
Although some factors may seem self-evident to developers today, interest in developing apps that adhere to common best practices continues to grow with the rise of micro-services and applications that are composed of loosely-coupled web services.
12 factors developers should think about when building native cloud apps:
1. Code base
 Use one codebase, even when building cross-platform apps. Address the needs of specific devices with version controls.
2. Dependencies
 Explicitly declare and isolate all dependencies.
3. Configuration
 Don't store config as constants in code. Design the app to read its config from the environment.
4. Backing Services
 Treat back-end services as attached resources to be accessed with a URL or other locator stored in config.
5. Build, Release, Run
 Strictly separate build and run stages.
6. Processes
 Execute the app as one or more stateless processes. Data that must be persistent should be stored in a stateful backing service.
7. Port binding
 Use port binding to export services.
8. Concurrency
 Scale out apps horizontally, not vertically.
9. Disposability
 Use fast startups and graceful shutdowns to maximize robustness.
10. Parity
 Facilitate continuous deployment by making development, staging, and production environments as similar as possible.
11. Logs
 Treat logs as event streams. Logs should not be concerned with routing or storing the app's output.
12. Admin processes
 Run admin tasks as one-off processes from a machine in the production environment that's running the latest production code.
The 12-factor basics
When a developer uses the twelve-factor app DevOps methodology, applications will have certain characteristics in common that address a variety of scenarios as an app scales. For example, the methodology recommends that apps use declarative formats for setup automation to assist new developers that enter the project at a later time.
Apps should also be written to have maximum portability between execution environments and scale easily without significant reworking. Twelve-factor apps can be written in any programming language and in combination with any back-end service, such as a database.
The goal of the twelve-factor framework is to help developers build apps that use an architecture that ensures speed, reliability, agility, portability and ultimately results in a robust and reliable application.
Any developer building cloud-based applications, most of which run as a service, should familiar with the 12 factors.
Benefits of 12-factor app methodology
	This method shows a path to follow for the development.
	It avoids the confusion and saves time.
	The project can be handled more efficiently by adopting this method.
	Time and resource management can be done appropriately with this method.
	Deployment date is handled properly.
	End minute changes can be done easily.
	The method suits perfectly with cloud platforms and other operating systems as well.
To implement the above 12 Factor App we need a Cloud.
PCF (Pivotal Cloud Foundary)
Now a days Cloud Computing and Microservice have become very popular concept and almost all the organizations are investing and adapting it very fast. Currently there are only few popular cloud providers in the market and Cloud Foundry is one of them. It is a PaaS service where we can easily deploy and manage our applications and the Cloud Foundry will take care of the rest of the cloud based offerings like scalability, high availability etc.
Cloud Foundry is an open source cloud computing program basically generated in-house by VMware. It is presently allowed via Pivotal Software, which is a collective venture built up of VMware, General Electric, and EMC.
 
Cloud Foundry is optimized to perform…
	Fast application improvement and deployment.
	Extremely scalable and accessible architecture.
	DevOps-friendly workflows.
	Lowered chance of human failure.
	Multi-tenant calculate capabilities.
Not only can Cloud Foundry lighten developer workloads, however, considering Cloud Foundry manages so generous of an application’s source administration, but it can also further hugely reduce the above burden on your employment team.
Essential advantages of Cloud Foundry:
	Employment portability.
	Applying auto-scaling.
	Centralized principles administration.
	Centralized logging.
	Powerful routing.
	Application health management.
	Alliance with external logging elements like Logstash and Elasticsearch.
	A role-based path for expanded applications.
	Provision for horizontal and vertical scaling.
	Base security. Pivotal Training
	Assistance for multiple IaaS providers.
It is a service (PaaS) on which developers can build, deploy, run and scale applications.
Many Organizations provide the cloud foundry platform separately. For example following are some cloud foundry providers
	Pivotal Cloud Foundry
	IBM Bluemix
	HPE Helion Stackato 4.0
	Atos Canopy
	CenturyLink App Fog
	Huawei FusionStage
	SAP Cloud Platform
	Swisscom Application Cloud
CloudFoundary Architecture
 
Pivotal Cloud Foundry (PCF) is just a multi-cloud platform for the deployment, management, and continuous delivery of applications, containers, and functions. PCF is just a distribution of the open source Cloud Foundry developed and maintained by Pivotal Software, Inc.
 
Advantages of PCF
	Fast application development and deployment.
	Highly scalable and available architecture.
	DevOps-friendly workflows.
	Reduced chance of human error.
	Multi-tenant compute efficiencies.
PCF Development Environment Setup
Downloading and installing Cloud Foundry Command Line Interface (CLI)
The Cloud Foundry (cf) command line interface (CLI) provides a set of commands for managing your apps. We will need to download and install this interface for our windows machine.
Download the installer from https://cli.run.pivotal.io/stable?release=windows64&source=github and unzip it. After that double click on the CF CLI executable and install it.
To list all of the cf commands and associated help information, use cf help. Use cf command_name -h to view detailed help information for a particular command.
Creating Pivotal Cloud Foundry Account
Go to https://account.run.pivotal.io/sign-up and register for free account by providing your personal details which includes mobile number as well. 
After that click on Pivotal Web Services
 
In the above step, I have created an Organization named praveenorugant-org. A default development space was assigned to us.
Organization (org) is a development account that encompasses computing resources, apps, and services. It can be owned and used by an individual or by multiple collaborators. Set the org name to be the name of the project you'll be working on or the name of your team. Don't worry - you can change this name at any time.
 Login into your pcf account using CLI command cf login by providing your creditionals 
 
Now let’s see how we can deploy the springboot application in pcf
First you need to create manifest.yml for your springboot application shown as below.
For example,
cd D:\Praveen\workspace\praveen-springboot-master\praveen-user-management-service

Example manifest.yml for spring boot application praveen-user-management-service
 
Now for deploying the application in PCF you need to run the command cf push
 
Open the Route URL mentioned in above screenshot for accessing the application.
https://praveen-user-management-service.cfapps.io/ 
 
Now modify the URL as https://praveen-user-management-service.cfapps.io/rest/users
 
For deleting app in PCF
cf delete -r app-name
for example, cf delete -r praveen-user-management-service
What  cf push  does?

	Upload package
	Staging -creation of droplet
o	determine the right build pack
o	Run the build packs to create droplet
	Deployment- deployment of droplet into a cell

Package (Source Code) + Build Pack(s) = Droplet
What is Cloud Foundry BuildPack?
Buildpacks provide framework and runtime support for apps. Buildpacks typically examine your apps to determine what dependencies to download and how to configure the apps to communicate with bound services. When you push an app, Cloud Foundry automatically detects an appropriate buildpack for it. This buildpack is used to compile or prepare your app for launch.
How to scale an microservice in PCF?

cf scale praveen-user-management-service -i 2




What are various Roles and associated permissions in PCF?
 
PCF Inbuilt Services
There is an advantage of PCF i.e... provision of inbuilt services. For example we have service-registry, config-server, redis, rabbitmq, circuitbreaker, mysql and many inbuilt services are available….
