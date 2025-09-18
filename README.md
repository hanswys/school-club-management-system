# School Club Management System - REST API

A Spring Boot RESTful API to manage **students, clubs, and events**.  
The system supports full CRUD operations with **PostgreSQL** as the database.

---

## 🏗 Technology Stack

- Java 17+
- Spring Boot
    - Spring Web
    - Spring Data JPA
- PostgreSQL (v17+)
- Maven 
- HikariCP (Connection Pool)

---

## 🔗 API Endpoints

```bash

Members

Method	Endpoint	Description	Request Body
GET	/members	Get all members	N/A
GET	/members/{id}	Get a member by ID	N/A
POST	/members	Create a new member	JSON: { "name": "", "email": "", "grade": "", "clubIds": [] }
PUT	/members/{id}	Update a member	JSON: { "name": "", "email": "", "grade": "", "clubIds": [] }
DELETE	/members/{id}	Delete a member	N/A


⸻

Clubs

Method	Endpoint	Description	Request Body
GET	/clubs	Get all clubs	N/A
GET	/clubs/{id}	Get a club by ID	N/A
POST	/clubs	Create a new club	JSON: { "name": "", "description": "", "advisor": "", "memberIds": [], "eventIds": [] }
PUT	/clubs/{id}	Update a club	JSON: { "name": "", "description": "", "advisor": "", "memberIds": [], "eventIds": [] }
DELETE	/clubs/{id}	Delete a club	N/A


⸻

Events

Method	Endpoint	Description	Request Body
GET	/events	Get all events	N/A
GET	/events/{id}	Get an event by ID	N/A
POST	/events	Create a new event	JSON: { "title": "", "date": "YYYY-MM-DD", "description": "", "clubId": 1 }
PUT	/events/{id}	Update an event	JSON: { "title": "", "date": "YYYY-MM-DD", "description": "", "clubId": 1 }
DELETE	/events/{id}	Delete an event	N/A


⸻

💾 Database Schema
	•	Member
	•	id (PK), name, email, grade
	•	Many-to-Many: Members ↔ Clubs
	•	Club
	•	id (PK), name, description, advisor
	•	Many-to-Many: Members
	•	One-to-Many: Club → Events
	•	Event
	•	id (PK), title, date, description
	•	FK: club_id → Club

⸻

🧪 Testing
	1.	Unit Tests: Service methods are tested with Mockito.
	2.	Integration Tests: Repository methods tested against Postgres.
	3.	Controller Tests: REST endpoints tested with MockMvc.


📚 References
	•	Spring Boot Documentation
	•	Spring Data JPA
	•	PostgreSQL Documentation
	•	MockMvc for Controller Tests

⸻

