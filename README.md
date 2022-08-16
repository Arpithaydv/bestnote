# bestnote
Disqo Notes Application

**Problem Statement:**
Build a RESTful service which can allow users to login over Basic Auth to add, modify or delete the notes.
Each user can have multiple notes, but each note belongs to one user.


**Tech Stack**
1. Java
2. Spring Boot framework
3. PostgreSQL


**Entities**

 *User:* 
A user in the system. It contains the following fields: 
- Email: Non-blank, valid email address, unique 
- Password: Non-blank, at least 8 characters 
- Create Time 
- Last Update Time 

 *Note:* 
A note in the system. Notes are associated with Users. A user can have many notes. A note has the  following fields: 
- Title: Non-blank, max 50 characters long 
- Note: max 1000 long 
- Create Time 
- Last Update Time 


Solution: Entities were defined using JPA and persisited over Hibernate

User password details were authenticated using BcryptPassword provider.


**Endpoints for Note**

- GET NOTES BY USER EMAIL

```
curl --location --request GET 'localhost:8091/api/v1/note?emailId=user1@domain.com' \
--header 'Authorization: Basic dXNlcjFAZG9tYWluLmNvbTp1c2VyMQ==' \
--header 'Cookie: JSESSIONID=0038C9654B30C70758A224E83DABFE50'

```
<img width="971" alt="image" src="https://user-images.githubusercontent.com/23045426/184783483-f5e21636-5a81-4ae1-a548-c1bbccd3fcf2.png">


- ADD NEW POST BY USER

```
curl --location --request POST 'localhost:8091/api/v1/note' \
--header 'Authorization: Basic dXNlcjFAZG9tYWluLmNvbTp1c2VyMQ==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=0038C9654B30C70758A224E83DABFE50' \
--data-raw '{
    "title": "THEIR TRUNKS HAVE MAD SKILLS",
    "notes": "Elephants have around 150,000 muscle units in their trunk. Their trunks are perhaps the most sensitive organ found in any mammal - Asian elephants have been seen to pick up a peanut, shell it, blow the shell out and eat the nut.",
    "user": {
        "emailId": "user1@domain.com"
    }
}'
```
![image](https://user-images.githubusercontent.com/23045426/184783373-fa10e834-cff2-4ca0-829f-ab25eaacd14c.png)


- Update existing NOTE 

```
curl --location --request PUT 'localhost:8091/api/v1/note' \
--header 'Authorization: Basic dXNlcjFAZG9tYWluLmNvbTo=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=0038C9654B30C70758A224E83DABFE50' \
--data-raw '{
    "title": "THEIR TRUNKS HAVE MAD SKILLS",
    "notes": "example to show case update",
    "user": {
    "emailId":"user1@domain.com" 
}
}'

```
![image](https://user-images.githubusercontent.com/23045426/184783671-1d5720dc-253c-41bd-afaf-91bbbfee4d15.png)



- Delete existing NOTE:

```
curl --location --request DELETE 'localhost:8091/api/v1/note/delete-note?title=THEIR TRUNKS HAVE MAD SKILLS&emailId=user1@domain.com' \
--header 'Authorization: Basic dXNlcjFAZG9tYWluLmNvbTp1c2VyMQ==' \
--header 'Cookie: JSESSIONID=0038C9654B30C70758A224E83DABFE50'
```
![image](https://user-images.githubusercontent.com/23045426/184786177-9a1d1f60-0dba-461b-ab31-de488df237b6.png)

**Testing:**

Each of the cases are Manually tested for:
1. Basic Auth validation for unauthorized user
2. User based notes fetching and operation permission

Also some unit tests were introduced for 
1. Service Test
2. Data Layer Test

![image](https://user-images.githubusercontent.com/23045426/184790614-8fa09093-3c64-48e8-a462-3b1117cba606.png)
![image](https://user-images.githubusercontent.com/23045426/184790772-94a36389-ef8c-404c-a941-ac590d4bfab5.png)


references:
Lot of online spring boot tutorials

