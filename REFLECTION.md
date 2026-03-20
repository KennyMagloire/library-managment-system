

# Reflection: Challenges in Balancing Stakeholder Needs

Developing the Library Management System as a single developer introduced several challenges, particularly when trying to balance stakeholder needs with technical and practical limitations.

One of the main challenges was scalability and performance. The system is expected to manage a large number of books and transactions efficiently. As the number of records increases, operations such as searching, reporting, and updating data must remain fast. While the current design supports moderate usage, scaling the system to handle significantly larger datasets or real-time access would require more advanced solutions such as database optimization or distributed systems. For example, if the system were extended into a web-based platform with many concurrent users, techniques such as load balancing would become necessary to handle multiple requests efficiently.

Another challenge is managing concurrent access to the system. Although the current implementation assumes limited simultaneous usage, in a real-world scenario multiple librarians or administrators may need to access the system at the same time. This introduces the risk of data conflicts, such as multiple users modifying the same record simultaneously. Handling such situations would require concurrency control mechanisms, which increase system complexity.

Access control and security also present challenges. Different stakeholders require different levels of access. For instance, librarians should perform operational tasks such as borrowing and returning books, while sensitive information such as system logs and administrative controls should only be accessible to the head librarian or system administrator. Implementing such role-based access control requires careful design to ensure both security and usability, while avoiding unnecessary complexity.

Maintaining detailed logs and monitoring system activity is another important aspect. While logging improves accountability and supports auditing, it also introduces challenges related to storage and performance. As the number of transactions increases, storing and managing logs efficiently becomes more difficult, and excessive logging can impact system performance.

Another key trade-off was between performance and simplicity. The system uses file-based storage and basic data structures, which simplifies development and maintenance. However, this approach may not be as efficient as using a full database system when dealing with very large datasets. Choosing this design reflects a balance between feasibility and performance within the constraints of a single-developer project.

Usability was also a concern. The system is implemented using a command-line interface, which is straightforward to develop but less intuitive compared to graphical interfaces. While this approach ensures simplicity and faster implementation, it may not provide the best user experience for all users, particularly those who are less familiar with command-line environments.

Security considerations also had to be balanced with the project scope. Basic authentication and operation tracking were implemented to ensure accountability. However, more advanced security features such as encryption or multi-factor authentication were not included due to complexity and time constraints. This highlights the trade-off between security and development effort.

Ensuring data consistency and reliability is another challenge. For example, if a system failure occurs during a transaction, there is a risk of incomplete or inconsistent data. Handling such situations properly would require more advanced error handling and recovery mechanisms.

Finally, working as a single developer with limited resources required prioritizing core functionality over advanced features. Decisions had to be made about which features were essential and which could be considered future improvements. This constraint influenced many design choices, particularly in areas such as scalability, security, and user interface design.

In conclusion, the main challenge was finding a balance between functionality, system complexity, and available resources. While the system meets its core objectives, several areas such as scalability, concurrency, and security would require further improvement in a real-world deployment.