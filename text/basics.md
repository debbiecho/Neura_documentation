#An introduction to Neura for developers

####Neura distills raw data from a user's smartphone and internet-of-things (IoT) devices into contextual knowledge.  Developers can use this contextual knowledge to make smarter apps and devices that enhance the user's life.  Let the magic flow...

![Neura data flow diagram](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDataFlowDiagram.png)

##The API is in private alpha
The API is currently available only to select developers while it is in alpha.  If you'd like to apply for access, contact build [at] theneura [dot] com; please be sure to include information about your technical skills and use cases you'd like to address.  

**While the Neura API is in private alpha, you may only use the API to access your own data and that of your company's participating colleagues.**  You may not use the Neura API with your users or customers.  

Because the API is in alpha, we appreciate your patience as we continue to improve it.  We will do our best to give you at least 10 days' notice before releasing breaking changes and to constantly communicate the [status of the API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md). 


##Neura's nomenclature
**Users** are individuals with the Neura app and/or third party apps that build with Neura. Users are also known as consumers.  Neura is free for users.

**Integrations** are apps, devices, and/or services that send input data to Neura, such as Fitbit, Jawbone, Nest, and Withings. Here is our [current list of integrations](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md); we're always adding more.  It is free for devices to integrate with Neura.

**Developers** are third-party software developers that build apps, devices, and/or services that consume data output from Neura's API. Developers are also known as partners.  Since Neura has a freemium business model, some developers are also paying customers.

**States** are moments where the user is doing a particular activity in a particular location.  

**Events** are changes in the state of a user that Neura delivers as a callback to your server or mobile app.  Here are details on [subscribing to receive Neura events](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md).

**Data objects** contain user information, such as wellness, activity, or sleep information, during a period of time in JSON format that you access asynchronously.  Here are details on [sending requests for Neura data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md).

**Permissions** are where a user grants an app access to their personal events and data objects.  Developers need permission to subscribe to events or receive a data object.

**Subscriptions** are where an app receives a callback for a Neura event. 

**Timeline** is the interface in the Neura app that allows the user to scroll through personal events that Neura has recorded. 

##Why build with Neura?
Neura is the perfect complement to any app, service, or internet-of-things (IoT) device that enhances user experience through the smart use of data.  A common reason developers build with Neura is that they instantly benefit from Neura's [30+ integrations](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) and that Neura provides contextual knowledge, as opposed to raw data that needs to be processed for meaning and insight.

Additional benefits of building with Neura include:

  - More data. Access data from all of your users' IoT devices.
  - Freemium pricing. Only pay when you generate value for users.
  - Machine learning. Neura gets better the more you use it.


## Getting your users on Neura
Your users will need to install the Neura app, create an account with Neura, and grant you access to their data.  Neura performs well for users with only a smartphone; for users who onboard smart devices, Neura performs even better.  

Neura is available for users with smartphones running Android or iOS.  The Neura app has been optimized for the following smartphone models:  
**Android**: Galaxy S3, Galaxy S4, Nexus 4, Nexus 5, LG G2.  
**iOS**: 7.0 running on iPhone 4, iPhone 4S, iPhone 5, iPhone 5C, iPhone 5S iPhone 6.  


## Days, time, and time zones
A Neura day begins on the calendar day when the user awakes and finishes the following calendar day just before the user awakes to best convey the day from the perspective of the user.  Neura treats the event when the user awoke to be the "anchor" that defines their day. Consequently, a calendar day is always 24 hours long, whereas the length of a Neura day varies with user sleep patterns.  Additionally, if Neura is unable to detect when a user awoke (e.g. because their phone is off), then there are not data objects available for that day.  

![Neura's view of a person's day](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDailyCalendar.jpg)

### Timezone changes
Neura considers a user changing timezones as an [edge case](http://en.wikipedia.org/wiki/Edge_case). Consequently, our approach is to always calculate events based on the timezone the user was in when they awoke, regardless of their timezone the rest of the day.

### Differences in time between the Neura app and the Neura API 
Time is conveyed differently in the Neura app versus the Neura API to make the most sense for each audience.  The Neura API uses [epoch time](http://en.wikipedia.org/wiki/Unix_time) so that developers don't need to worry about differences in time zones between different users.  For instance, when Neura delivers an event or a data object, it returns a `timestamp` in epoch time.

For users, the Neura app always displays time in the user's current timezone.  When a user changes timezones, Neura automatically updates their timeline.  On a normal day, a user might awake at 9am on Monday morning in San Francisco (PT) and awake on Tuesday in San Francisco at 8am.  Therefore, for Neura, Monday results in a 23 hour day.  However, if a user awakes in San Francisco on Tuesday at 8am and then flies to New York and wakes up in New York on Wednesday morning at 10am (ET), for Neura, Tuesday results in a 26-hour day.  

![Neura frames events in a user's timezone and always returns UTC](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraUTC.jpg)   

## Neura's data inputs
Neura utilizes data gathered by the Neura app and [integrated devices](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) that the user has authorized for Neura to access.  The Neura app gathers data from the the user's phone's:  
  - Wifi
  - Bluetooth
  - GPS
  - Accelerometer
  - Battery

##Privacy
Neura puts user privacy first and we expect developers to do the same.  We've designed Neura to enrich users' lives, not to sell ads. If you have any questions or concerns about how to design privacy protections into your apps, contact build [at] theneura [dot] com.

**While the Neura API is in private alpha, you may only use the API to access your own data and that of your company's participating colleagues.**

HTTPS is required for all Neura APIs because we transmit private user information. Users trust your application with their data and Neura expects you respect this trust. We require that your application not retransmit insecurely, retain indefinitely, nor share with third parties any data sent via the Neura API. 

