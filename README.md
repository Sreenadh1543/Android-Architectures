# Android-Architectures

**Project Description :**

Connect With a REST - API and retrieve list of countries in Mvc , Mvp and Mvvm Architectures.

Countries API to be connected with 

>https://restcountries.eu/rest/v2/all

A Free Api to respond with countries list in JSON ; We are going to use country names to display a list as a part of this exercise.

Adapters Used :

* RX Java , RX Android

* RetroFit , RetroFit Adapter For RX Java , Gson Converters


> MVC  : Model - View - Controller


Concept : To Split the implementation as per data model ; presentation layer ; and controller flows 

How it fits with Android ?

* In android an Activity manages layout + Business logic .

* Mvc makes an activity to set it's View (Layout) alone and makes it dependent on controller for model operations. 

**Conclusions :**

Separation of Concerns is done as below :

*  Model --  Controls the connection with API and retrieval of Countries list

*  View --  Controls all Actions related to GUI (Activity)

*  Controller -- Business logic here to retrieve country list and delegate back to handle success or Failure scenarios. 

Concerns 

* A tight coupling between activity and controller ; but better than keeping every thing in an activity .






> MVP  : Model - View - Presenter




> MVVM : Model  - View - ViewModel
