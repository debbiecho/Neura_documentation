#An introduction to Neura for developers

####Neura distills raw data from a user's smartphone and internet-of-things (IoT) devices into contextual knowledge so that your apps and devices can be smarter to better enhance the user's life.

**_insert sexy picture here. make the text visual._**

##The API is in private alpha
The API is currently available only to select developers while it is in alpha.  If you'd like to apply for access, contact build [at] theneura [dot] com; please be sure to include information on your technical skills and use cases you'd like to address.  

Particularly because the API is in alpha, we appreciate your patience as we continue to improve it.  We will do our best to give you at least 10-days notice before releasing breaking changes and to constantly communicate the [status of the API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md). 


##Neura's nomenclature
**Users** are individuals with the Neura app and/or third party apps that build with Neura. Users are also known as consumers.  Neura is free for users.

**Integrations** are apps, devices and/or services that send input data to Neura, such as Fitbit, Jawbone, Nest, and Withings.  Here is our [current list of integrations](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md); we're always adding more.  It is free for devices to integrate with Neura.

**Developers** are third-party software developers that build apps, devices and/or services that consume output data from Neura. Developers are also known as partners.  Since Neura has a freemium business model, some developers are also paying customers.

 **States** are moments where the user is doing a particular activity and/or in a particular location.  

**Events** are changes in the state of a user that Neura delivers as a callback.  Here are details on [subscribing to PUSH notifications for events]().

**Data objects** contain user information, such as wellness, activity or sleep information, during a period of time in JSON format.  Here are details on [sending requests for data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/endpoints.md).

**Permissions** are when a user grants an app access to their data.  Developers need permission to subscribe to events or receive a data object.

**Subscriptions** are when an app is registered to receive event notifications. 


##Why build with Neura?
Neura is the perfect compliment to any app, service, or internet-of-things (IoT) device that enhances user experience through the smart use of data.  A common reason developers build with Neura is that they instantly benefit from Neura's [30+ integrations](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) and that Neura provides contextual knowledge, as opposed to raw data that first needs to be processed for meaning and insight.

Other reasons to build with Neura include:

  - Freemium pricing. Only pay when you start generating value for users.
  - Machine learning. Yup, we've got that. Tachlis. 
  - **_Get in put from Gilad, Ori, & Eric; 4 bullets max_**


## Getting your users on Neura
Your users will need to install the Neura app, create an account with Neura, and grant you access to their data.  Neura performs well for users with only a smartphone;  for users that onboard devices, Neura performs even better.  

Neura is available for users with smartphones running on Android or iOS.  The Neura app has been optimized for the following model phones:  
**Android**: Galaxy S3, Galaxy S4, Nexus 4, Nexus 5, LG G2.  
**iOS**: 7.0 running on iPhone 4, iPhone 4S, iPhone 5, iPhone 5C, iPhone 5S.  
_**How have we dealt with iPhone 6?**_

## Time and Timezones
**How do dates work? Timezones? Flight/travel?**
   **feedback from Eric @ Zenobase: what timezone? when does date start and end? how do we align different datasets?**
**What is the expected latency on push events?** 
**Even if we don't have perfect answers, let's address upfront.**


##Privacy
Neura puts user privacy first and we expect developers to do the same.  We've designed Neura to enrich users' lives, not to sell ads. If you have any questions or concerns about how to design privacy protections into your apps, contact build [at] theneura [dot] com.

HTTPS is required for all Neura APIs because we transmit private user information. Users trust your application with their data and Neura expects you respect this trust. We require that your application not retransmit insecurely, retain indefinitely or share with third parties any data sent via the Neura API. 

-------

#Mikimer & Eroc to chat about
Eric, can you build out our privacy policy? I benchmarked **Privacy** with Jawbone, Fitbit & Nest.  They raise a good point that once Neura transmits data, we need to limit how it can be used by developers.  How do we protect users?  *probably good to talk w/ triinu about this: what was RSA's approach?*

