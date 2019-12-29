# Android-Architectures

**Project Description :**

Connect With a REST - API and retrieve list of countries in Mvc , Mvp and Mvvm Architectures.

Countries API to be connected with 

>https://restcountries.eu/rest/v2/all

A Free Api to respond with countries list in JSON ; We are going to use country names to display a list as a part of this exercise.

**Adapters Used :**

* RX Java , RX Android

* RetroFit , RetroFit Adapter For RX Java , Gson Converters


> MVC  : Model - View - Controller

**Concept :** To Split the implementation as per data model ; presentation layer ; and controller flows 

How it fits with Android ?

* In android an Activity manages layout + Business logic .

* Mvc makes an activity to set it's View (Layout) alone and makes it dependent on controller for model operations. 

**Conclusions :**

Separation of Concerns is done as below :

*  Model --  Controls the connection with API and retrieval of Countries list

*  View --  Controls all Actions related to GUI (Activity)

*  Controller -- Business logic here to retrieve country list and delegate back to handle success or Failure scenarios. 

**Pain Points :** 

* A tight coupling between activity and controller ; but better than keeping every thing in an activity .


> MVP  : Model - View - Presenter


* Starts with providing a solution for the problem which MVC creates ; A tight coupling or one - one relation between view and controller

* In an enterprise project this creates a roadblock on maintainability 

* MVP Addresses this problem by Abstracting the View as an interface 

**Separation of Concerns :**

* Presenter (A.K.A) generalised controller will not be connected to a view directly but instead to an interface of view .

* It solves the tight coupling between view and controller as view can be easily swapped with another view implementing the interface as per the business requirement .

**Pain Points :**

* Though Presenter is un aware of the view it's calling ,view knows exactly to what presenter it's bounded to it .

* More over , Presenter is now allowed to call back view with out dependency to the state of the user .


> MVVM : Model  - View - ViewModel


* 



