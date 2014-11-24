#Neura distills context. 

##An introduction to Neura for developers
####Neura distills raw data from a user's smartphone and internet-of-things (IoT) devices into contextual knowledge so that you can enhance their life.

##The API is in private alpha
The API is currently available only to select developers while it is in alpha.  If you'd like to apply for access, contact build [at] theneura [dot] com; please be sure to include information on your technical skills and use cases you'd like to address.  

Particularly because the API is in alpha, we appreciate your patience as we continue to improve it.  We will do our best to give you at least 10-days notice before releasing breaking changes and to constantly communicate the [status of the API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md). 


##Neura's nomenclature

**Users** are individuals with the Neura app and/or third party apps that build with Neura. Users are also known as consumers.  Neura is free for users.
**Integrations** are apps, devices and/or services that send input data to Neura, such as Fitbit, Jawbone, Nest, and Withings.  Here is our [current list of integrations]()**link**; we're always adding more.  Neura is free for integrations.

**Developers** are third-party software developers that build apps, devices and/or services that consume output data from Neura. Developers are also known as partners.  Since Neura has a freemium business model, some developers are also customers.
**Events** are changes in the status of a user that Neura delivers as a callback.  Developers need user permission to subscribe to events. Here are details on [subscribing to PUSH notifications for events]().

**Data objects** contain user information, such as wellness, activity or sleep information, during a period of time in JSON format.  Developers need user permission to receive data objects.  Here are details on [sending PULL requests for data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/endpoints.md).

## Neura's conventions
Neura distills contextual knowledge from raw data in users' smartphone sensors, apps, devices so that you can enhance your apps.  To do this, your users will need to install the Neura app, create an account with Neura, and onboard any IoT devices they own into Neura**(wordchoice?)**.  Neura performs well for users with only a smartphone;  for users that onboard devices, Neura performs even better.  Finally, you need to secure user permission for event subscriptions and data object requests.

Neura is available for users with smartphones running on Android or iOS.  The Neura app has been optimized for the following model phones:

  **Android**: Galaxy S3, Galaxy S4, Nexus 4, Nexus 5, LG G2.  **iOS**: 7.0 running on iPhone 4, iPhone 4S, iPhone 5, iPhone 5C, iPhone 5S.

**How have we dealt with iPhone 6?**
**How do dates work? Timezones? Flight/travel?**
   **feedback from Eric @ Zenobase: what timezone? when does date start and end? how do we align different datasets?**
**What is the expected latency on push events?** 
**Even if we don't have perfect answers, let's address upfront.**


##Why build with Neura?
Neura is the perfect compliment to any app, service, or internet-of-things (IoT) device that enhances user experience through the smart use of data.  A common reason developers build with Neura is that they instantly benefit from Neura's [50+ integrations]()**link** and that Neura provides contextual knowledge, as opposed to raw data that first needs to be processed for meaning and insight.

Other reasons to build with Neura include:

  - Freemium pricing. Only pay when you start generating value for users.
  - Machine learning. Yup, we've got that. Tachlis. 
  - **Get in put from Gilad, Ori, & Eric; 4 bullets max**

##Privacy
Neura puts user privacy first and we expect developers to do the same.  We've designed Neura to distill data to enrich our users' lives, not to sell ads. If you have any questions or concerns about  how to design privacy protections into your apps, contact build [at] theneura [dot] com.

HTTPS is required for all Neura APIs because private user information will be transmitted. Users trust your application with this info and Neura expects you respect this trust. We require that your application not retransmit insecurely, retain indefinitely or share with third parties any data sent via the Neura API. 


### Authentication

You can query the Neura API to pull information about a user. All requests for user data must include an **authorization header** containing the user's access token:

**Example**

```
Authorization: Bearer asdf1234*****************
```

**We need to explain how to get the auth token**


-------

#Mikimer & Eroc to chat about
Eric, can you build out our privacy policy? I benchmarked **Privacy** with Jawbone, Fitbit & Nest.  They raise a good point that once Neura transmits data, we need to limit how it can be used by developers.  How do we protect users?  *probably good to talk w/ triinu about this: what was RSA's approach?*

