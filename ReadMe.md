# BOOKING APPLICATION

## Description
The application is composed of 2 parts: 
1. Restful API Server
2. CommandLine User Interface 

## 1. Restful API Server
### Hotel API
`getHotels` - it retrieves hotels based on the user's location and a specified radius
### Room API
`getAvailableRooms` it retrieves all the hotel rooms within a specified period of time
### Reservation API
`reserveRoom` it books a room for a specified period of time
<br>
`cancelReservation` it cancels a reservation
### Feedback API
`createFeedback` it creates a feedback for a hotel 

## 2. CommandLine User Interface
 We have a console based application that allows the user to interact with the Hotel, Room and the Reservation API
<br>
 Hotel Feedback API is not yet implemented in the interface

## TODO's
1. Clean up the command line user interface code
2. Implement the Hotel Feedback API in the command line user interface
3. Validations for adding everything


