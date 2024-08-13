# software-designs-patterns
Welcome to the Software Architecture Implementation project! This project explores and implements various software architecture patterns and principles to build scalable, maintainable, and efficient systems. The aim is to demonstrate how different architectural approaches can be applied to real-world scenarios and to provide a reference implementation for these concepts.
## Event driven architecture (ranking)
![image](https://github.com/user-attachments/assets/5a24382d-0c31-454e-97fc-fb4a60417b9c)
This architecture enables asynchronous communication between applications using a publisher-subscriber model event broker, leading to effective decoupling of components. In this setup, every significant action within the application is represented as an event. It is crucial for the programmer to determine when and which events should be published and subscribed to ensure proper system functionality and responsiveness.

PROS  | CONS
------------- | -------------
Any subscriber has access to the event to use as it pleases	| Not Everything is up-to-date
Scalability: Promotes loose coupling and allows independent scaling |	Complexity: Designing and implementing can be complex
Responsiveness: Real-time or near-real-time processing improves user experience |	Event Handling Overhead: Asynchronous processing can introduce latency
Flexibility: Easy to integrate new services and adapt to changes	| Event Management: Challenges with ordering and duplication of events
Fault Tolerance: Isolates failures and improves system resilience |	Testing Challenges: Difficulties with integration and end-to-end testing
Simplified Communication: Reduces need for direct service-to-service calls | Infrastructure Requirements: Needs message brokers or event streaming platforms

The Ranking Application tracks all movies played throughout the day and ranks them based on the number of plays. Each time a user hits play on a movie, an event is generated and recorded. At the end of the day, the application compiles this data to produce a ranking of the most-watched movies.
It is implemented with java events producer and subscribers, but it should be a bus broker, such as kafka, SQS and others.
