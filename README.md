# Warehouse-Delivery-Service
Delivery service tells us what product we will receive, how many of them, and who it comes from. For example, every day we expect to receive thousands of bananas from our banana supplier! When a delivery arrives at one of our warehouses we need to make sure that we have marked it as received (so that we can pay for it, and put it into our inventory). Deliveries are how we get the products into our warehouses so that we can sell them to you later! Your service will help us with this process.

## Prerequisites

Java 11

Maven 3

## Instructions

### Installing
```
mvn clean package
```

### To run the webapp manually

```
mvn spring-boot:run
```

....and navigate your browser to  http://localhost:8080/

## Adding In memory database 

Use url http://localhost:8080/api/saveDelivery by passing below json in the body.

```
[
    {
        "deliveryId": 101,
        "product": "Bananas",
        "supplier": "JungleInc",
        "quantity": 1000000,
        "expectedDate": "2027-01-08T07:17:48.237Z",
        "expectedWarehouse": "TheMoon"
    },
    {
        "deliveryId": 103,
        "product": "Bananas",
        "supplier": "JungleInc",
        "quantity": 1000000,
        "expectedDate": "2027-01-08T07:17:48.237Z",
        "expectedWarehouse": "TheMoon"
    },
    {
        "deliveryId": 102,
        "product": "Saiyans",
        "supplier": "Bardock",
        "quantity": 9001,
        "expectedDate": "2019-10-10T09:08:11.098Z",
        "expectedWarehouse": "Namek"
    }
]
```
## API sample request

http://localhost:8080/api/deliveries

You should get below response:

```
[
    {
        "deliveryId": 101,
        "product": "Bananas",
        "supplier": "JungleInc",
        "quantity": 1000000,
        "expectedDate": "2027-01-08T07:17:48.237Z",
        "expectedWarehouse": "TheMoon"
    },
    {
        "deliveryId": 103,
        "product": "Bananas",
        "supplier": "JungleInc",
        "quantity": 1000000,
        "expectedDate": "2027-01-08T07:17:48.237Z",
        "expectedWarehouse": "TheMoon"
    },
    {
        "deliveryId": 102,
        "product": "Saiyans",
        "supplier": "Bardock",
        "quantity": 9001,
        "expectedDate": "2019-10-10T09:08:11.098Z",
        "expectedWarehouse": "Namek"
    }
]
```

