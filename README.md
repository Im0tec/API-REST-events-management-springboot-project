# 5th Semester - AC2 Object-Oriented Programming 👨🏽‍💻

Api-Restfull developed in my OOP classes.

### Application link on Heroku:  
  
https://semester5-ac1-poolab-190309.herokuapp.com/

## Endpoints
1. Access registered events ("/events"):  
https://semester5-ac1-poolab-190309.herokuapp.com/events

2. Access registered places ("/places"):  
https://semester5-ac1-poolab-190309.herokuapp.com/places  

3. Access registered admins ("/admins"):  
https://semester5-ac1-poolab-190309.herokuapp.com/admins  

4. Access registered attendees ("/attendees"):  
https://semester5-ac1-poolab-190309.herokuapp.com/attendees  

## Request JSON's examples
  
### POST  
  
  
**1. Event**   
```json  
{  
  "name": "Event name here",  
  "description": "Event description here", 
  "start_date": "dd/MM/yyyy",  
  "end_date": "dd/MM/yyyy",  
  "start_time": "hh:MM",  
  "end_time": "hh:MM",  
  "email": "Event email here",  
  "amountFreeTickets": "Free tickets here",  
  "amountPayedTickets": "Payed tickets here",  
  "priceTicket": "Price ticket here",  
  "admin": {
    "id": "Event admin id here"
  } 
}  
```
**2. Place**  
```json
{  
    "name": "Place name here",  
    "address": "Place address here"  
}  
```
**3. Admin**  
```json
{
    "name": "Admin name here",
    "email": "Admin email here",
    "phoneNumber": "Admin name here"
}
```
**4. Attend**  
```json
{  
    "name": "Attend name here",  
    "email": "Attend email here",  
    "balance": "Attend balance here"  
}  
```  
**5. Tickets**  
```json
{
    "type": "Ticket type here (FREE or PAYED)",  
    "attend": {  
        "id": "Attend id here"  
    }  
}  
```  
-------
### PUT  
  
  
 **1. Event**  
  
```json  
{
    "name": "New event name here",
    "description": "New event description here",
    "email": "New event email here"
}
```
**2. Place**  
```json
{
    "name": "New place name here"
}
```
**3. Admin**  
```json
{
    "name": "New admin name here",
    "email": "New admin email here",
    "phoneNumber": "New admin phone number here"
}
```
**4. Attend**  
```json
{
    "name": "New attend name here",
    "email": "New attend email here"
}
```
