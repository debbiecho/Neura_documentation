#An introduction to Neura for developers

###Neura distills raw data from a user's smartphone and [internet-of-things (IoT)](http://en.wikipedia.org/wiki/Internet_of_Things) devices into contextual knowledge.  
###Developers can use Neura's contextual knowledge to make smarter apps and IoT devices that enhance the user's life.  Let the magic flow...

![Neura data flow diagram](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDataFlowDiagram.png)

##The API is in private alpha
The API is currently available only to select developers while it is in alpha.  If you'd like to apply for access, contact build [at] theneura [dot] com; please be sure to include information about your technical skills and use cases you'd like to address.  

**While the Neura API is in private alpha, you may only use the API to access your own data and that of your company's participating colleagues.**  You may not use the Neura API with your users or customers.  

Because the API is in alpha, we appreciate your patience as we continue to improve it.  We will do our best to give you at least 10 days' notice before releasing breaking changes and to constantly communicate the [status of the API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md). 


##Neura's nomenclature
**Users** are individuals with the Neura app and/or third party apps that build with Neura. Users are also known as consumers.  Neura is free for users.

**Integrations** are apps, devices, and/or services that send input data to Neura, such as Fitbit, Jawbone, Nest, and Withings. Here is our [current list of integrations](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md); we're always adding more.  It is free for devices to integrate with Neura.

**Developers** are third-party software developers that build apps, devices, and/or services that consume data output from Neura's API. Developers are also known as **partners**.  Since Neura has a freemium business model, some developers are also paying **customers**.

**States** are moments where the user is doing a particular activity in a particular location.  

**Events** are changes in the state of a user that Neura delivers as a callback to your server or mobile app.  Here are details on [subscribing to receive Neura events](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md).

**Insights** contain user information, such as wellness, activity, or sleep information, during a period of time in JSON format that you access asynchronously.  Here are details on [sending requests for Neura insights](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md).

**Permissions** are where a user grants an app access to their personal events and insights.  Developers need permission to subscribe to events or receive an insight.

**Subscriptions** are where an app receives a callback for a Neura event. 

**Timeline** is the interface in the Neura app that allows the user to scroll through personal events that Neura has recorded. 

##Why build with Neura?
Neura is the perfect complement to any app, service, or internet-of-things (IoT) device that wants to enhance user experience through the smart use of data.  A common reason developers build with Neura is that Neura provides contextual knowledge, as opposed to raw data that needs to be processed for meaning and insight.

Additional benefits of building with Neura include:  
  - More data. Access data from more than [30+ IoT devices.](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md)  
  - Freemium pricing. Only pay when you generate value for users.
  - Machine learning. Neura gets better the more you use it.

## Getting your users on Neura
Your users will need to install the Neura app, create an account with Neura, and grant you access to their data.  Neura performs well for users with only a smartphone; for users who onboard [IoT devices](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md), Neura performs even better.  

Neura is available for users with smartphones running Android or iOS.  The Neura app has been optimized for the following smartphone models:  
**Android**: Galaxy S3, Galaxy S4, Nexus 4, Nexus 5, LG G2.  
**iOS**: 7.0 running on iPhone 4, iPhone 4S, iPhone 5, iPhone 5C, iPhone 5S,  iPhone 6.  


## Days, time, and time zones
A "Neura day" is from when a user wakes up one day to when they wake up the next day.  Consequently, a calendar day is always 24 hours long, whereas the length of a Neura day is semantic and varies with user sleep patterns.  In the example below, Neura considers the user to have had a 28 hour long Friday that began at 6am Friday and ended at 10am on Saturday.

![Neura's view of a person's day](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/semantic_cycle.png)

Specifically, Neura treats the event when the user awoke to be the "anchor" that defines their day.  A Neura day begins on the calendar day when the user awakes and finishes the following calendar day just before the user awakes; we believe this best conveys a day from the perspective of the user.  If Neura is unable to detect when a user awoke (e.g. because their phone is off), then there may not be data objects available for that day.  

### Timezone changes
Neura considers a user changing timezones as an [edge case](http://en.wikipedia.org/wiki/Edge_case). Consequently, our approach is to always calculate events based on the timezone the user was in when they awoke, regardless of their timezone the rest of the day.

### Differences in time between the Neura app and the Neura API 
Time is conveyed differently in the Neura app versus the Neura API to make the most sense for each audience.  The Neura API uses [epoch time](http://en.wikipedia.org/wiki/Unix_time) so that developers don't need to worry about differences in time zones between different users.  For instance, when Neura delivers an event or an insight, it returns a `timestamp` in epoch time.

For users, the Neura app always displays time in the user's current timezone.  When a user changes timezones, Neura automatically updates their timeline.  In the example above, let's say the user awakes in San Francisco on Sunday at 9am PT and then flies to Chicago. On Monday morning, they wake up in Chicago at 11am CT, Neura considers Sunday to be a 26-hour day.  

## Data gathered by the Neura app
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

## Go forth and build
You can now build with Neura [on Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md) and [on iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md). Your app can query Neura [insights](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md); Android apps can also [subscribe to events](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md). 


## [Return to the main page](https://github.com/NeuraLabs/Neura_documentation#build-with-neura)
