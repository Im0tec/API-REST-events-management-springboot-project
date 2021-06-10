# 5 Semestre - AC2 Programação Orientada a Objetos
**DUPLA:**  
Eduardo Campos Gonçalves - 190309  
Johanna Bernecker - 190737

### Link da aplicação no Heroku  
  
*O link continua da ac1 pois fiquei receoso de alterá-lo e o projeto de alguma forma bugar e parar de funcionar*  
  
https://semester5-ac1-poolab-190309.herokuapp.com/
## Estilos dos JSON's de requisição
  
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
