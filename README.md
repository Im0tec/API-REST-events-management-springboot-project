# 5 Semestre - AC2 Programação Orientada a Objetos
**DUPLA:**  
Eduardo Campos Gonçalves - 190309  
Johanna Bernecker - 190737

### Link da aplicação no Heroku  
https://semester5-ac1-poolab-190309.herokuapp.com/
### Estilos dos JSON's de requisição (POST)
  
**1. Event**  
  
*A variável place ainda continua como o do projeto de AC1 (apenas recebendo uma string), pois como não era necessário fazer a ligação entre as entidades **Place** e **Event** deixei
como estava para não retornar uma valor null no banco de dados. Porém, no código, as linhas que representam a relação de associação entre as tabelas estão comentadas.*  
```json  
{  
  "name": "Event name here",  
  "description": "Event description here",  
  "place": "Event place here",  
  "start_date": "dd/MM/yyyy",  
  "end_date": "dd/MM/yyyy",  
  "start_time": "hh:MM",  
  "end_time": "hh:MM",  
  "email": "Event email here",  
  "amountFreeTickets": "Free tickets here",  
  "amountPayedTickets": "Payed tickets here",  
  "priceTicket": "Price ticket here",  
  "adminId": "Event admin id here"  
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
