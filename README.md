# praveenoruganti-springcloud-microservices-master

https://www.facebook.com/groups/2340886582907696/

I am raising funds for our group maintenance and if you like the group articles, writings, Git Projects and Ebooks, you can provide your contributions by using the below channel.

UPI ID:
praveenoruganti-1@okhdfcbank

Happy Learning!!!!


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

You can understand all the microservices,pcf and spring cloud concepts from my ebook https://www.facebook.com/groups/2340886582907696/permalink/2360752190921135/


