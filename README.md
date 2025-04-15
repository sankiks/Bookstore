projektet körs på jdk 17 så see till att den är installerad
projektet är byggd i springboot som maven projekt

projektet innehåller en runnable jar file.
den hittar ni under bookstore/bookstore/target/Bookstore-0.0.1-SNAPSHOT.jar

För att köra jar filen öppna cmd där jar filen ligger och skriv
java -jar Bookstore-0.0.1-SNAPSHOT.jar

för test av end points/ api.et kan ni använda postman

DTOs...

för att göra en order, gör en post till http://localhost:8080/orders

JSON formatet ska se ut som nedan

en lista av orderitems med parameterarna bookId och quantity. varje id representerar en book id, quantity är hur många man vill köpa. programmet har 4 olika böcker i stock med id 1 2 3 4.

{

  "orderItems": [

    {
      "bookId": 1,
      "quantity": 2
    },
    {
      "bookId": 2,
      "quantity": 4
    }, 
  ]
}


för att hämta alla booker,

skicka en get till http://localhost:8080/Book/allBooks



för att restocka skicka en put till http://localhost:8080/Book/admin/restock
JSON ska se ut så här
{
  "bookId": 3,
  "quantity": 13
}
